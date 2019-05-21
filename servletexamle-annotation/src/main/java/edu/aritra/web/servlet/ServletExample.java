package edu.aritra.web.servlet;

import edu.aritra.web.db.DBAccess;
import edu.aritra.web.db.Student;
import edu.aritra.web.service.ExampleService;
import org.springframework.context.ApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet1", urlPatterns = {"/home", "/database", "/data"})
public class ServletExample extends HttpServlet {

    private Map<String, String> environmentProperties;
    private ExampleService service;

    public ServletExample() {
        super();
        environmentProperties = System.getenv();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContext applicationContext = (ApplicationContext) getServletContext().getAttribute("applicationContext");
        service = applicationContext.getBean(ExampleService.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.getWriter().append("Served at: ").append(request.getContextPath());
        String path = request.getRequestURI().substring(request.getContextPath().length());

        request.setAttribute("DATABASE_HOST", environmentProperties.get("DATABASE_HOST"));
        request.setAttribute("DATABASE_PORT", environmentProperties.get("DATABASE_PORT"));

        String jspPath;
        if (path.equals("/home")) {
            String msg = service.execute();
            request.setAttribute("message", msg);
            jspPath = "jsp" + path + ".jsp";
        } else {
            if (path.equals("/data")) {
                DBAccess dbAccess = new DBAccess(environmentProperties.get("DATABASE_HOST"),
                        environmentProperties.get("DATABASE_PORT"),
                        environmentProperties.get("DATABASE_NAME"),
                        environmentProperties.get("DATABASE_USER"),
                        environmentProperties.get("DATABASE_PASSWORD"));
                List<Student> students = dbAccess.getData();
                request.setAttribute("result", students);
            }
            jspPath = "WEB-INF/jsp" + path + ".jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(jspPath);
        dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
