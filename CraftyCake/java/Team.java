package CraftyCake.java;

import java.util.ArrayList;

public class Team {
    public  ArrayList<Employee> team = new ArrayList<>();
    public ArrayList<Employee> getTeam() {
        return team;
    }
    public void addEmployee(Employee i){
        this.team.add(i);
    }
    public void removeEmployee(Employee i){
        this.team.remove(i);
    }
    private int getTeamTotalCakes(){
        int sum = 0;
        for(Employee i : team){
            sum = sum + i.getCakesMade();
        }
        return sum;
    }
}
