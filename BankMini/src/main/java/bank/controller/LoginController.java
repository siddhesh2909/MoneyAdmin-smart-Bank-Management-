package bank.controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accUname = request.getParameter("username");
        String accPassword = request.getParameter("password");
        Register rmodel = new Register(accUname, accPassword);
        BankDao bdao = new BankDaoImpl();
        List<Register> lst = new ArrayList<>();
        lst.add(rmodel);
        List<Register> loginResult = bdao.Login(lst);
        HttpSession session = request.getSession();
        if (loginResult != null && !loginResult.isEmpty()) {
        	for(Register r: loginResult) {
        		int accNumber = r.getAccNumber();
                String accHolder = r.getAccHolder();
                String MobileNo = r.getMobileNo();
                String email = r.getEmail();
                String panNo= r.getPanNo();
                String adharNo= r.getAdharNo();
                double accBal = r.getAccBal();
        		Register rg = new Register(accNumber, accHolder, accUname, MobileNo, email, panNo, adharNo, accPassword, accBal);
        		session.setAttribute("login", rg);
        		response.sendRedirect("LoginDashboard.jsp");
        	}} else {
        		response.sendRedirect("error.html");
        	}
        	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
