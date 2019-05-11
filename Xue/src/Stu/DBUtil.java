package Stu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
    private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection getCon() throws ClassNotFoundException,
            SQLException {
        Connection con = null;

        Class.forName(DRIVER_NAME);

        con = DriverManager.getConnection(URL, USER, PASS);

        return con;
    }

    public static void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}