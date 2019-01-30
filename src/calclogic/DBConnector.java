package calclogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBConnector
 */
@WebServlet("/DBConnector")
public class DBConnector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBConnector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String uname = request.getParameter("userName");
		PrintWriter out = response.getWriter();
		String bankname = request.getParameter("bankname");
		String loantype = request.getParameter("loantype");
		double lamt = Double.parseDouble(request.getParameter("lamt"));
		int lperiod = Integer.parseInt(request.getParameter("lperiod"));
		
		
		//int credibility = 0;
		InterestRate ir = new InterestRate();
		double irate = ir.getInterestRate(loantype, bankname);
		
		LoanCalculator loancalc = new LoanCalculator();
		double[] itrValues = loancalc.getLoanAmount(loantype, irate, lperiod, lamt);
		double payment = itrValues[0];
		double interest = itrValues[1];
		double unpaidamt = itrValues[2];

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");
			Statement st = con.createStatement();
			int i = st.executeUpdate(
					"insert into loandetails(uname,bankname, loantype, loanamt, loanperiod, interest, payment, unpaidamt, interestrate) values ('"
							+ uname + "','" + bankname + "','" + loantype + "','" + lamt + "','" + lperiod + "','"
							+ interest + "','" + payment + "', '" + unpaidamt + "','" + irate
							+ "')");
			if (i > 0) {

				DecimalFormat twoDigits = new DecimalFormat(".00");
				request.setAttribute("uname", uname);
				request.setAttribute("loantype", loantype);
				request.setAttribute("bankname", bankname);
				request.setAttribute("loanamt", lamt);
				request.setAttribute("interestrate", irate);
				request.setAttribute("payment", twoDigits.format(payment));
				request.setAttribute("interest", twoDigits.format(interest));
				request.setAttribute("principle", twoDigits.format(unpaidamt));
				request.getRequestDispatcher("LoanResult.jsp").forward(request, response);
			} else {
				out.println("Try Again!!!!!!!!");
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
