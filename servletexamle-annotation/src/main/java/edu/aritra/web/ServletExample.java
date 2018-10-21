package edu.aritra.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="Servlet1", urlPatterns = {"/home","/mypage"})
public class ServletExample extends HttpServlet {

    public ServletExample() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String path = request.getRequestURI().substring(request.getContextPath().length());
        String jspPath;
        if(path.equals("/home")){
            jspPath = "jsp"+path+".jsp";
        }else{
            jspPath = "WEB-INF/jsp"+path+".jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request,response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
