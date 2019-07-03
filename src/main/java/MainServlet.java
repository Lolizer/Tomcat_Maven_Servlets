import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

@WebServlet("/")
public class MainServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServerException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("I'm alive!");
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServerException,IOException {

    }
}
