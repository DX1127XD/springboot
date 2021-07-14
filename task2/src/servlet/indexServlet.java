package servlet;

import cn.edu.usts.cs2018.dao.CustomerDaoImpl;
import cn.edu.usts.cs2018.entity.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "indexServlet")
public class indexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<Customer> customer = CustomerDaoImpl.findAllMYSQL();
        session.setAttribute("customer", customer);
        RequestDispatcher dispatcher;
        dispatcher=request.getRequestDispatcher("CURD.jsp");
        dispatcher.forward(request, response);
    }
}
