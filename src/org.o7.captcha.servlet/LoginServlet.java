package org.o7.captcha.servlet
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.servlet.http.HtppServletResponse;

public class LoginServlet extends HttpServlet{
    private static final long serialVersionUID = 958900029856081978L;
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        RequestDispatcher dispatcher =
                req.getServletContext().getRequestDispatcher("hello-loginview.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletrRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        this.doGet(req, resp);
    }
}