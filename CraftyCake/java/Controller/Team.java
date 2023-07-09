package CraftyCake.java.Controller;
//Java library imports

import CraftyCake.java.DBAL.TeamDBAL;
import CraftyCake.java.Assets.Utils;
import CraftyCake.java.Model.Employee;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.SQLException;

public class Team {
    private ArrayList<Employee> team; //Create array list to hold all employees

    private TeamDBAL teamDBAL = new TeamDBAL();

    public Team()throws SQLException {
        this.team = teamDBAL.getEmployees();
    }

    //Method to add employees to team array list
    public void addEmployee(Employee i) {
        this.team.add(i);
    }

    //Method to remove employees from team array list
    public void removeEmployee(Employee i) {
        this.team.remove(i);
    }

    //Method to sort team as instructed with exception handling
    public void sortTeam() throws Exception {
        if (team.isEmpty()) {
            throw new Exception("Cannot sort an empty team list\n");
        } else {
            Collections.sort(team);
        }
    }

    //Method to get team total cakes
    public int getTeamTotalCakes() {
        int sum = 0;
        for (Employee i : team) {
            sum = sum + i.getCakesMade();
        }
        return sum;
    }

    //Method to get team total wages
    public double getTeamTotalWages() {
        double sum = 0;
        for (Employee i : team) {
            sum = sum + i.getWage();
        }
        return sum;
    }

    //Method to print the full team in a neat table
    //Throws exception if team is empty
    public String printTeam() throws Exception {
        StringBuilder sb = new StringBuilder();
        if (team.isEmpty()) {
            throw new Exception("Cannot print as the team list is empty\n");
        } else {
            sb.append(Utils.tableHeads());
            for (Employee i : team) {
                sb.append(i.printEmployee());
            }
            sb.append(Utils.tableFoot());
            return sb.toString();
        }
    }

    //Method to print teams total wages
    //Throws exception if team is empty
    public String printTeamTotalWages() throws Exception {
        if (team.isEmpty()) {
            throw new Exception("Cannot sort an empty team list\n");
        } else {
            String sb = "Team Total Wages: " + Utils.getMoney(getTeamTotalWages()) +
                    "\n";
            return sb;
        }
    }

    //Method to print teams total cakes made
    public String printTeamTotalCakes() throws Exception {
        if (team.isEmpty()) {
            throw new Exception("Cannot sort an empty team list\n");
        } else {
            String sb = "Team Total Cakes: " + getTeamTotalCakes() +
                    "\n";
            return sb;
        }
    }
}
