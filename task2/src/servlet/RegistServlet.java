package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import cn.edu.usts.cs2018.entity.Customer;
//import entity.Customer;
@WebServlet(name = "RegistServlet")
public class RegistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        int id=Integer.parseInt(request.getParameter("id"));
        request.setAttribute("id",id);
        String name=request.getParameter("username");
        String telephone=request.getParameter("telephone");
        request.setAttribute("telephone",telephone);
        String address=request.getParameter("address");
        String dept=request.getParameter("dept");
        Customer cus=new Customer(id,name,telephone,address,dept);
        HttpSession session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("name", name);
        session.setAttribute("telephone", telephone);
        session.setAttribute("address", address);
        session.setAttribute("dept", dept);
        RequestDispatcher dispatcher;
        dispatcher=request.getRequestDispatcher("confirm.jsp");
        dispatcher.forward(request, response);

    }
}
