package CraftyCake.java;

import CraftyCake.java.Assets.Utils;
import CraftyCake.java.Controller.Team;
import CraftyCake.java.Model.Employee;
import CraftyCake.java.Model.QualityController;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            Utils utils = new Utils();
            Team team = new Team();

            team.sortTeam();
            System.out.println(team.printTeam());
            System.out.println(team.printTeamTotalCakes());
            System.out.println(team.printTeamTotalWages());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
