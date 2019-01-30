package calclogic;

import java.io.IOException;
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
 * Servlet implementation class bestBank
 */
@WebServlet("/bestBank")
public class bestBank extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public bestBank() {
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
		// TODO Auto-generated method stub
		// doGet(request, response);
		String userArg = request.getParameter("bestbank");
		String bestBank = "";
		double lowestInterestRate = 0, temp = 0;
		String bankname = "";
		String loantype = "";
		double lamt = 0.0;
		int lperiod = 0, credibility = 0;
		double irate = 0.0;
		DecimalFormat twoDigits = new DecimalFormat(".00");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root", "root");
			Statement st = con.createStatement();
			String uname = request.getParameter("userName");
			ResultSet rs = st.executeQuery(
					"select bankname, loantype, loanamt, loanperiod from loandetails where uname='" + uname + "'");

			while (rs.next()) {
				bankname = rs.getString(1);
				loantype = rs.getString(2);
				lamt = rs.getDouble(3);
				lperiod = rs.getInt(4);

			}
			ArrayList<String> al = new ArrayList<String>();
			al.add("IndianBank");
			al.add("CitiBank");
			al.add("SBI");
			Iterator<String> itr = al.iterator();
			double citiBankInterest = 0.0;
			double indianBankInterest = 0.0;
			double sbiBankInterest = 0.0;
			while (itr.hasNext()) {
				String bankName = itr.next();
				if(loantype.equals("PersonalLoan"))
				{
				if (userArg.equals("Interest")) {
					
					if (bankName.equals("CitiBank")) {
						irate = 14.99;
						citiBankInterest = irate;
					} else if (bankName.equals("SBI")) {
						irate = 11.75;
						sbiBankInterest = irate;
					} else if (bankName.equals("IndianBank")) {
						irate = 17.5;
						indianBankInterest = irate;
					}

					// formula to check lowest interest between 3 banks
					temp = citiBankInterest < sbiBankInterest ? citiBankInterest : sbiBankInterest;
					lowestInterestRate = indianBankInterest < temp ? indianBankInterest : temp;
				} else if (userArg.equals("Credibility")) {
					if (bankName.equals("CitiBank")) {
						credibility = 4;
						citiBankInterest = credibility;
					} else if (bankName.equals("SBI")) {
						credibility = 2;
						sbiBankInterest = credibility;
					} else if (bankName.equals("IndianBank")) {
						credibility = 3;
						indianBankInterest = credibility;
					}
					temp = citiBankInterest > sbiBankInterest ? citiBankInterest : sbiBankInterest;
					lowestInterestRate = indianBankInterest > temp ? indianBankInterest : temp;
				}
				}
				else if(loantype.equals("CarLoan"))
				{
					if (userArg.equals("Interest")) {
						
						if (bankName.equals("CitiBank")) {
							irate = 12.75;
							citiBankInterest = irate;
						} else if (bankName.equals("SBI")) {
							irate = 10.65;
							sbiBankInterest = irate;
						} else if (bankName.equals("IndianBank")) {
							irate = 9.40;
							indianBankInterest = irate;
						}
						temp = citiBankInterest < sbiBankInterest ? citiBankInterest : sbiBankInterest;
						lowestInterestRate = indianBankInterest < temp ? indianBankInterest : temp;
					} else if (userArg.equals("Credibility")) {
						if (bankName.equals("CitiBank")) {
							credibility = 4;
							citiBankInterest = credibility;
						} else if (bankName.equals("SBI")) {
							credibility = 2;
							sbiBankInterest = credibility;
						} else if (bankName.equals("IndianBank")) {
							credibility = 3;
							indianBankInterest = credibility;
						}
						temp = citiBankInterest > sbiBankInterest ? citiBankInterest : sbiBankInterest;
						lowestInterestRate = indianBankInterest > temp ? indianBankInterest : temp;
					}
				}
				if (lowestInterestRate == citiBankInterest) {
					bestBank = "CitiBank";
				} else if (lowestInterestRate == sbiBankInterest) {
					bestBank = "SBIBank";
				} else if (lowestInterestRate == indianBankInterest) {
					bestBank = "IndianBank";
				}
			}
			request.setAttribute("bestBank", bestBank);
			request.setAttribute("lowestInterestRate", twoDigits.format(lowestInterestRate));
			request.getRequestDispatcher("BestBank.jsp").include(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
