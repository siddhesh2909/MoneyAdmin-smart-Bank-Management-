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
import bank.model.Recharge;
import bank.model.Register;

@WebServlet("/FinalRecharge")
public class FinalRecharge extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public FinalRecharge() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Recharge r = (Recharge) session.getAttribute("recharge");
        Register rg = (Register) session.getAttribute("login");
        String recharge_type = r.getRecharge_type();

        if (r == null || rg == null) {
            System.err.println("Recharge or Register object is null.");
            response.sendRedirect("error.html"); 
            return;
        }
        BankDao bdao = new BankDaoImpl();
        int result = bdao.Recharge(r, rg, recharge_type);

        if (result > 0) {
        	switch (recharge_type) {
            case "mobile(prepaid)":
            	 Register reg = new Register(rg.getAccNumber(), rg.getAccHolder(), rg.getAccUname());
                 Recharge rec = new Recharge(r.getMobNo(), r.getProvider(), r.getRecharge_type(), r.getPrice());
                 session.setAttribute("bill1", rec);
                 session.setAttribute("bill2", reg);
                 response.sendRedirect("RechargeBill.jsp");
                break;
            case "mobile(postpaid)":
           	 Register reg3 = new Register(rg.getAccNumber(), rg.getAccHolder(), rg.getAccUname());
                Recharge rec3 = new Recharge(r.getMobNo(), r.getProvider(), r.getRecharge_type(), r.getPrice());
                session.setAttribute("bill1", rec3);
                session.setAttribute("bill2", reg3);
                response.sendRedirect("RechargeBill.jsp");
               break;
            case "DTH":
            	Register reg1 = new Register(rg.getAccNumber(), rg.getAccHolder(), rg.getAccUname());
                Recharge rec1 = new Recharge(r.getCust_id(), r.getProvider(),r.getPrice());
                session.setAttribute("bill1", rec1);
                session.setAttribute("bill2", reg1);
                response.sendRedirect("RechargeBill.jsp");
                break;
            case "electricity":
            	Register reg2 = new Register(rg.getAccNumber(), rg.getAccHolder(), rg.getAccUname());
                Recharge rec2 = new Recharge(r.getCust_id(), r.getProvider(), r.getRecharge_type(),r.getBilling_unit(), r.getPrice());
                session.setAttribute("bill1", rec2);
                session.setAttribute("bill2", reg2);
                response.sendRedirect("RechargeBill.jsp");
                break;
        }

        } else {
            System.err.println("Recharge operation failed.");
            response.sendRedirect("error.html"); 
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
