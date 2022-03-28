package wasdev.sample.servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet("/SimpleServlet")
public class SimpleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.getWriter().print(getMessage());
    }

    private String getMessage(){
        String[] messages ={"I am late!", "Hurry up!", "Whatever!", "Don't loose your mind!", "Focus!"};
        try{
            return messages[new Random().nextInt(messages.length)];
        }
        catch(Exception exc){
            return "Someway the code failed!! :-(";
        }
    }

}
