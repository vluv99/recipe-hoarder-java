import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class Index extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {

        String text =  config.getServletContext().getServerInfo();
        System.out.println(text);
        super.init(config);
    }

    @Override
    public void destroy() {
        //super.destroy();
        System.out.println(this.getServletName() + " destroyed");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.append("Email: " + req.getParameter("email") + "<br>");
        writer.append("Password: " + req.getParameter("password") + "\n");

    }
}
