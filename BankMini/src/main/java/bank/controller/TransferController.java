package bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.model.FundTransfer;

@WebServlet("/TransferController")
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public TransferController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String beneficiaryName = request.getParameter("beneficiaryName");
		String accNo = request.getParameter("accNo");
		String bankName = request.getParameter("bankName");
		String ifscCode = request.getParameter("ifscCode");
		double price = Double.parseDouble(request.getParameter("price"));
		String upiId =null;
		String type = request.getParameter("type");

		if(type.equals("UPI")) {
		upiId = request.getParameter("upiId");

		}
		System.out.println(upiId);
		
		FundTransfer FT = new FundTransfer(beneficiaryName, accNo, bankName, ifscCode, price, type, upiId);
		HttpSession session = request.getSession();
		session.setAttribute("FUND", FT);
		response.sendRedirect("ConfirmTransfer.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
