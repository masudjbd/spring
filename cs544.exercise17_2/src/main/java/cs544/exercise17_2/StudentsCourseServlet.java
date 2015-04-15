package cs544.exercise17_2;

import java.io.IOException;
import javax.servlet.ServletContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class StudentsCourseServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        String studentIdStr = request.getParameter("studentid");

        long studentid = -1;
        Student student = null;

        if (studentIdStr != null && studentIdStr.matches("\\d+")) {
            studentid = Long.parseLong(studentIdStr);
            
            ServletContext servletcontext=getServletContext();
            WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletcontext);
                    
            StudentService studentService = context.getBean("studentService",
                    StudentService.class);
            studentService.createStudent();
//			StudentService studentService = new StudentService();
            student = studentService.getStudent(studentid);
        }

        request.setAttribute("student", student);
        request.getRequestDispatcher("student.jsp").forward(request, response);

    }

}
