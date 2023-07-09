package CraftyCake.java.DBAL;

import CraftyCake.java.Assets.DBUtils;
import CraftyCake.java.Model.Employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static java.sql.DriverManager.getConnection;
public class TeamDBAL {
    private DBUtils dbu = new DBUtils();

    private ArrayList<Employee> employees = new ArrayList<>();

    public TeamDBAL() throws SQLException {
        readAllEmployees();
    }

    private void readAllEmployees() throws SQLException {
        Connection conn = getConnection(dbu.getConnectionUrl(), dbu.getUser(), dbu.getPass());
        String query = "SELECT * FROM employee";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while(rs.next()){
            this.employees.add(new Employee(rs.getString("name"), rs.getInt("cakes_covered")));
        }
        stmt.close();
        conn.close();
    }

    public ArrayList<Employee> getEmployees(){
        return this.employees;}
}
