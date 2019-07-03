import javafx.util.Pair;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.ServerException;

@WebServlet("/company/*")
public class Testing extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServerException, IOException {
        if(Main.names.isEmpty())
            Main.init();

        if(req.getSession().getAttribute("user") == null){
            resp.sendError(412,"User unknown!");
            return;
        }

        String buff = req.getRequestURI();
        String[] subbuff = buff.substring(buff.indexOf("company") + 8).split("/");
        String name = req.getParameter("name");

        //resp.setContentType("text/html;charset=utf-8");

        if(req.getParameterMap().isEmpty()){
            resp.sendError(404,"You should use parameters!");
            return;
        }

        boolean flg = false;

        for(Pair<String,String> pair : Main.names){
            if(pair.getValue().equals(req.getSession().getAttribute("user"))){
                if(pair.getKey().equals(req.getSession().getAttribute("company"))){
                    flg = true;
                    break;
                }else{
                    resp.sendError(412,"You aren't an employee!");
                    return;
                }
            }
        }
        if(!flg){
            resp.sendError(412,"You aren't an employee!");
            return;
        }


        flg = false;
        for(Pair<String,String> pair : Main.names){
            if(pair.getKey().equals(subbuff[0])) flg = true;
        }

        if(!flg){
            resp.sendError(404,"There isn't such company!");
            return;
        }

        flg = false;
        for(Pair<String,String> pair : Main.names){
            if(pair.getValue().equals(req.getSession().getAttribute("user"))){
                if(subbuff[0].equals(pair.getKey())) flg = true;
            }
        }
        if(!flg){
            resp.sendError(412,"User can search only coworkers!");
            return;
        }

        flg = false;
        for(Pair<String,String> pair : Main.names){
            if(pair.getValue().equals(name)){
                if(pair.getKey().equals(subbuff[0]))
                    resp.getWriter().println("The user is " + pair.getValue() + " and he works at " + pair.getKey() + " company.");
                else {
                    resp.sendError(412,"The parameter 'name' or 'company' is incorrect!");
                    return;
                }
            }
        }

        /*
        Iterator<String> it = req.getParameterNames().asIterator();

        while(it.hasNext()){
            String buffName = it.next();
            resp.getWriter().println(buffName + " " + req.getParameterMap().get(buffName)[0]);
        }
        */

        //resp.getWriter().println("Company:" + subbuff[0]);
    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServerException,IOException {

    }
}
