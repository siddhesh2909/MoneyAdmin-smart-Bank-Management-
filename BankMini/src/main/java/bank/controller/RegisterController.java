package bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.BankDao;
import bank.dao.BankDaoImpl;
import bank.model.Register;


@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegisterController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			String accFname = request.getParameter("accHolder");
			String accUname= request.getParameter("accUname");
			String accPassword = request.getParameter("accPassword");
			String mobileNo = request.getParameter("mobileNo");
			String email = request.getParameter("email");
			String panNo = request.getParameter("panNo");
			String adharNo = request.getParameter("adharNo");
			double accbal = Double.parseDouble(request.getParameter("accbal"));
			
			Register rmodel = new Register(accFname, accUname, mobileNo, email, panNo, adharNo, accPassword, accbal);
			
			List <Register> lstreg = new ArrayList<Register>();
			lstreg.add(rmodel);
			BankDao bdao = new BankDaoImpl();
			int i=bdao.createRecord(lstreg);
			if(i>0)
			{
				response.sendRedirect("LoginView.html");
			}
			else {
				response.sendRedirect("error.html");
			}
			
			
	}

}
