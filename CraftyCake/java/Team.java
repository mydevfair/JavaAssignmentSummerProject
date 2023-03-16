package CraftyCake.java;
//Java library imports

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.text.NumberFormat;

public class Team {
    private ArrayList<Employee> team = new ArrayList<>(); //Create array list to hold all employees

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
            throw new Exception("Team list is empty");
        } else {
            Collections.sort(team);
        }
    }

    //Method to get team total cakess
    public int getTeamTotalCakes() {
        int sum = 0;
        for (Employee i : team) {
            sum = sum + i.getCakesMade();
        }
        return sum;
    }

    //Method to get team total wages
    public double getTeamTotalWages() throws Exception {
        double sum = 0;
        for (Employee i : team) {
            sum = sum + i.getWage();
        }
        return sum;
    }

    //Method to print the full team in a neat table
    public String printTeam() throws Exception {
        if (team.isEmpty()) {
            throw new Exception("Cannot print as the team list is empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("       CRAFTY CAKE COMPANY LTD\n");
            sb.append("|-------------------------------------|\n");
            sb.append(String.format("%-10s | %10s | %13s", "|Name", "Cakes Made", "Wage |"));
            sb.append("\n");
            sb.append("|-------------------------------------|\n");
            for (Employee i : team) {
                sb.append(String.format("|%-10s| %10s | %10s  |", i.getName(), i.getCakesMade(), getMoney(i.getWage())));
                sb.append("\n");
                sb.append("|-------------------------------------|\n");
            }
            return sb.toString();
        }
    }

    //Method to print teams total wages
    public String printTeamTotalWages() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Total Wages: " + getMoney(getTeamTotalWages()));
        sb.append("\n");
        return sb.toString();
    }

    //Method to print teams total cakes made
    public String printTeamTotalCakes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Total Cakes: " + getTeamTotalCakes());
        sb.append("\n");
        return sb.toString();
    }

    //Method to get currency instance values
    public String getMoney(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
        return nf.format(amount);
    }
}
