import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet("/register")
public class MainServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServerException, IOException {
        if(Main.names.isEmpty()){
            Main.init();
        }
        String user = req.getParameter("user");
        String company = req.getParameter("company");

        HttpSession session = req.getSession();
        if(user != null && company != null && !user.equals("") && !company.equals("")) {
            session.setAttribute("user",user);
            session.setAttribute("company",company);
            resp.getWriter().println("You have been signed up!");
        }else{
            resp.sendError(404,"You should put in user and company parameters!");
            return;
        }
        //ServletContext context = req.getServletContext();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServerException,IOException {

    }
}
