package CraftyCake.java;
//Java library imports

import java.util.Locale;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;


public class Team {
    private final ArrayList<Employee> team = new ArrayList<>(); //Create array list to hold all employees

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
            sb.append("       CRAFTY CAKE COMPANY LTD\n");
            sb.append("|-------------------------------------|\n");
            sb.append(String.format("%-10s | %10s | %13s", "|Name", "Cakes Made", "Wage |"));
            sb.append("\n");
            sb.append("|-------------------------------------|\n");
            for (Employee i : team) {
                sb.append(i.printEmployee());
            }
            sb.append("|-------------------------------------|\n");
            return sb.toString();
        }
    }


    //Method to print teams total wages
    //Throws exception if team is empty
    public String printTeamTotalWages() {
        String sb = "Team Total Wages: " + getMoney(getTeamTotalWages()) +
                "\n";
        return sb;
    }

    //Method to print teams total cakes made
    public String printTeamTotalCakes() {
        String sb = "Team Total Cakes: " + getTeamTotalCakes() +
                "\n";
        return sb;
    }

    //Method to get currency instance values
    public String getMoney(double amount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
        return nf.format(amount);
    }
}

