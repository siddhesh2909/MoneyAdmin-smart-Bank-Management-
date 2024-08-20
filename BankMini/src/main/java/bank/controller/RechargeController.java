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

import bank.model.Recharge;

@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RechargeController() {
        super();
            }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mobNo = request.getParameter("mobNo");
		String custId = null;
		String provider = request.getParameter("provider");
		String type = request.getParameter("type");
		int billingUnit=0;
		if(type.equals("electricity")) {
			custId = request.getParameter("custId");
			billingUnit = Integer.parseInt(request.getParameter("billingUnit"));
		}
		else if(type.equals("DTH"))
		{
			custId = request.getParameter("custId");
		}
		double price = Double.parseDouble(request.getParameter("price"));
		Recharge r = new Recharge(mobNo, custId, provider, type, billingUnit, price);
		HttpSession session = request.getSession();
		session.setAttribute("recharge", r);
		response.sendRedirect("confirmRecharge.jsp");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
	}

}
