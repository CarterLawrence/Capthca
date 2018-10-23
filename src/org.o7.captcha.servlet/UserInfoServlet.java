package org.o7.captcha.servlet;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserInfoServlet extends HttpServlet{
    private static final long serialVersionUID = 958900029856081978L;
    protacted void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        if(req.getSession().getAttribute("loginedUser")==null){
            resp.sendRedirect(req.getContectPath()+"/login");
            return;
        }
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("hello-userinfoview.jsp");
        dispatcher.forward(req, resp);
    }
    protected void doPOst(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException{
        this.doGet(reg, resp);
    }
}