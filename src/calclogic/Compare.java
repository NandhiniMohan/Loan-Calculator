package calclogic;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Compare
 */
@WebServlet("/Compare")
public class Compare extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Compare() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DecimalFormat twoDigits = new DecimalFormat(".00");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");
			Statement st = con.createStatement();
			String uname = request.getParameter("userName");
			ResultSet rs = st.executeQuery(
					"select bankname, loantype, loanamt, loanperiod from loandetails where uname='" + uname + "'");
			while (rs.next()) {
				String bankname = rs.getString(1);
				String loantype = rs.getString(2);
				double lamt = rs.getDouble(3);
				int lperiod = rs.getInt(4);

				ArrayList<String> al = new ArrayList<String>();
				al.add("IndianBank");
				al.add("CitiBank");
				al.add("SBI");
				Iterator<String> itr = al.iterator();
				while (itr.hasNext()) {
					String remainingBank = itr.next();

					InterestRate ir = new InterestRate();
					double irate = ir.getInterestRate(loantype, remainingBank);

					LoanCalculator loancalc = new LoanCalculator();
					double[] itrValues = loancalc.getLoanAmount(loantype, irate, lperiod, lamt);
					double payment = itrValues[0];
					double interest = itrValues[1];
					double unpaidamt = itrValues[2];

					if (loantype.equals("PersonalLoan")) {
						if (remainingBank.equals("CitiBank")) {
							request.setAttribute("loantype", loantype);
							request.setAttribute("citibankname", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("citiinterestrate", irate);
							request.setAttribute("citibankpayment", twoDigits.format(payment));
							request.setAttribute("citibankinterest", twoDigits.format(interest));
							request.setAttribute("citibankprinciple", twoDigits.format(unpaidamt));
						} else if (remainingBank.equals("SBI")) {
							request.setAttribute("loantype", loantype);
							request.setAttribute("sbibank", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("sbiinterest", irate);
							request.setAttribute("sbibankpayment", twoDigits.format(payment));
							request.setAttribute("sbibankinterest", twoDigits.format(interest));
							request.setAttribute("sbibankprinciple", twoDigits.format(unpaidamt));
						} else if (remainingBank.equals("IndianBank")) {
							request.setAttribute("bankname", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("interestrate", irate);
							request.setAttribute("payment", twoDigits.format(payment));
							request.setAttribute("interest", twoDigits.format(interest));
							request.setAttribute("principle", twoDigits.format(unpaidamt));

						}
					} else if (loantype.equals("CarLoan")) {
						if (remainingBank.equals("CitiBank")) {
							request.setAttribute("loantype", loantype);
							request.setAttribute("citibankname", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("citiinterestrate", irate);
							request.setAttribute("citibankpayment", twoDigits.format(payment));
							request.setAttribute("citibankinterest", twoDigits.format(interest));
							request.setAttribute("citibankprinciple", twoDigits.format(unpaidamt));
						} else if (remainingBank.equals("SBI")) {
							request.setAttribute("uname", uname);
							request.setAttribute("loantype", loantype);
							request.setAttribute("sbibank", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("sbiinterest", irate);
							request.setAttribute("sbibankpayment", twoDigits.format(payment));
							request.setAttribute("sbibankinterest", twoDigits.format(interest));
							request.setAttribute("sbibankprinciple", twoDigits.format(unpaidamt));
						} else if (remainingBank.equals("IndianBank")) {
							request.setAttribute("uname", uname);
							request.setAttribute("loantype", loantype);
							request.setAttribute("bankname", remainingBank);
							request.setAttribute("loanamt", lamt);
							request.setAttribute("interestrate", irate);
							request.setAttribute("payment", twoDigits.format(payment));
							request.setAttribute("interest", twoDigits.format(interest));
							request.setAttribute("principle", twoDigits.format(unpaidamt));
						}
					}

				}
			}
			request.setAttribute("uname", uname);
			request.getRequestDispatcher("CompareResult.jsp").include(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
