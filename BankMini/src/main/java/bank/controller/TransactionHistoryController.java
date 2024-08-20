package bank.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Register;
import bank.model.Transaction;
import java.sql.Timestamp;

@WebServlet("/TransactionHistoryController")
public class TransactionHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TransactionHistoryController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BankDao bdao = new BankDaoImpl();
		List<Transaction> lst = bdao.DisplayHistory();

		HttpSession session = request.getSession();
		session.setAttribute("transactions", lst);
		response.sendRedirect("Transactions.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
