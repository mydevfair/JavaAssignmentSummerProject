package CraftyCake.java.DBAL;

import CraftyCake.java.Assets.DBUtils;
import CraftyCake.java.Model.Employee;

import java.sql.*;
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
            this.employees.add(new Employee(rs.getString("name"), rs.getInt("cakes_covered"),
                    rs.getInt("employee_id")));
        }
        stmt.close();
        conn.close();
    }
    public int updateEmployee(Employee employee) throws SQLException{
        Connection conn = getConnection(dbu.getConnectionUrl(), dbu.getUser(), dbu.getPass());
        String queryString = "UPDATE employee SET name = ?, cakes_covered = ? WHERE employee_id =?";
        PreparedStatement ps = conn.prepareStatement(queryString);
        ps.setString(1, employee.getName());
        ps.setInt(2, employee.getCakesMade());
        ps.setInt(3, employee.getId());

        try{
            return ps.executeUpdate();
        }finally {
            try{ps.close();} catch (Exception e) {/*Ignored*/}
            try{conn.close();} catch (Exception e) {/*Ignored*/}
        }
    }

    public ArrayList<Employee> getEmployees() {return this.employees;}
}
