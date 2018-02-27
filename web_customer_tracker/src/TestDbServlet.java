import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Author: hemraj
 * Date:  2/26/18.
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        Set up connection
        String user = "root";
        String pass = "root";

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";


//        Get connection to the database
        try {
            PrintWriter out = response.getWriter();
            out.println("Connecting to databases--->" + jdbcUrl);


            Class.forName(driver);

            Connection conn = DriverManager.getConnection(jdbcUrl, user, pass);

            out.println("SUCCESS!!!!!!!");


            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
