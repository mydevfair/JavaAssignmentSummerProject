package CraftyCake.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.text.NumberFormat;

public class Team {
    private ArrayList<Employee> team = new ArrayList<>();



    public void addEmployee(Employee i){
        this.team.add(i);
    }
    public void removeEmployee(Employee i){
        this.team.remove(i);
    }

    public void sortTeam() throws Exception {
        if (team.isEmpty()){
            throw new Exception("Team list is empty");
        }else {
            Collections.sort(team);
        }
    }
    public int getTeamTotalCakes(){
        int sum = 0;
        for(Employee i : team){
            sum = sum + i.getCakesMade();
        }
        return sum;
    }
    public double getTeamTotalWages(){
        double sum = 0;
        for (Employee i : team){
            sum = sum + i.getWage();
        }
        return sum;
    }
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
    public String printTeamTotalWages() throws Exception{
        StringBuilder sb = new StringBuilder();
        sb.append("Team Total Wages: " + getMoney(getTeamTotalWages()));
        sb.append("\n");
        return sb.toString();
    }
    public String printTeamTotalCakes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team Total Cakes: " + getTeamTotalCakes());
        sb.append("\n");
        return sb.toString();
    }
    public String getMoney(double amount){
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.UK);
        return nf.format(amount);
    }
}
