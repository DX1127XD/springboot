package servlet;

import cn.edu.usts.cs2018.dao.CustomerDaoImpl;
import cn.edu.usts.cs2018.dao.base.ICustomerDao;
import cn.edu.usts.cs2018.entity.Customer;
import com.mysql.cj.Session;
import com.mysql.cj.protocol.x.Notice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SaveServlet")
public class SaveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);

        int id= (int) session.getAttribute("id");
        String name= (String) session.getAttribute("name");//request.getParameter("username");
        String telephone= (String) session.getAttribute("telephone");
        String address= (String) session.getAttribute("address");
        String dept= (String) session.getAttribute("dept");
        Customer cus = new Customer(id, name, telephone, address, dept);
        CustomerDaoImpl.insertMYSQL(cus);
        List<Customer> customer = CustomerDaoImpl.findAllMYSQL();
        session.setAttribute("customer", customer);
        RequestDispatcher dispatcher;
        dispatcher=request.getRequestDispatcher("CURD.jsp");
        dispatcher.forward(request, response);
    }

}
