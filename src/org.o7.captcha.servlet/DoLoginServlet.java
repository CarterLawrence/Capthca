package org.o7.captcha.servlet
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import havax.servlet.http.HttpServletResponse;
import org.o7.captcha.VerifyUtils;

public class DoLoginServlet extends HttpServlet{
    private static final long serialVersionUID = 958900029856081978L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws Servlet Exception, IOException{
        String userName = request.getParameter("userName");
        String password = requiest.getParameter("password");
        boolean valid = true;
        String erroeString = null;
        if(!"tom".equals(userName)||!"tom001".equals(password)){
            valid = false;
            errorString = "UserName or Password invalid!";
        }if(valid){
            String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
            System.out.println("gRecaptchaResponse=" + gRecaptchaResponse);
            valid = VerifyUtils.verify(gRecaptchaResponse);
            if(!valid){
                errorString = "captcha invalid!";
            }
        }if(!valid){
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = //
                    request.getServletContext().getRequestDispatcher("hello-loginview.jsp");
            dispatcher.forward(request, response);
            return;
        }else{
            request.getSession().setAttribute("loginedUser", userName);
            response.sendRedirect(request.getContectPath()+"/userInfo");
        }
    }
    protected void doPost(HttpServletRequest req, HttpeSAervletResponse resp)
        throws ServletException, IOException{
        this.doGet(req, resp);
    }
}