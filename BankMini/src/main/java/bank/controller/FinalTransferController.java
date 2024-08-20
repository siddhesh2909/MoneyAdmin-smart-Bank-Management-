package bank.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.FundTransfer;
import bank.model.Recharge;
import bank.model.Register;
import bank.model.Transaction;


@WebServlet("/FinalTransferController")
public class FinalTransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public FinalTransferController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Register rg = (Register) session.getAttribute("login");
		FundTransfer ft = (FundTransfer) session.getAttribute("FUND");
		String transfer_type = ft.getType();
		System.out.println(transfer_type);

        if (rg == null || ft == null) {
        	
            response.sendRedirect("error.html"); 
            return;
        }
        BankDao bdao = new BankDaoImpl();
        int result = bdao.Transfer(rg, ft, transfer_type);

        if (result > 0) {
        	
        		System.out.println("Test3");
                response.sendRedirect("TransferBill.jsp");
                
        }

         else {
            System.err.println("Fund Transfer operation failed.");
            response.sendRedirect("error.html"); 
        }
    }

		

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
