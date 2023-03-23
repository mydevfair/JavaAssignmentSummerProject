package CraftyCake.java;

public class Main {
    public static void main(String[] args) throws Exception {
        Team team = new Team(); // Create new instance of team array
        //Create all instances of required employees
        Employee bob = new Employee("Bob", 100);
        Employee andrew = new Employee("Andrew", 101);
        Employee hafsa = new Employee("Hafsa", 34);
        Employee ayub = new Employee("Ayub", 101);
        Employee amaan = new Employee("Amaan", 101);
        Employee gary = new Employee("Gary", 49);
        Employee diane = new Employee("Diane", 217);
        Employee rabia = new QualityController("Rabia", 385);
        try {
            team.sortTeam();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        //Call method to print teams details with exception handling
        try {
            System.out.println(team.printTeam());
            System.out.println(team.printTeamTotalWages());
            System.out.println(team.printTeamTotalCakes());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        //Add all employees to team array
        team.addEmployee(bob);
        team.addEmployee(andrew);
        team.addEmployee(hafsa);
        team.addEmployee(ayub);
        team.addEmployee(amaan);
        team.addEmployee(gary);
        team.addEmployee(diane);
        team.addEmployee(rabia);
        //Print single employee details

        System.out.println(bob.printEmployee());
        //Call methods to add cakes and set error cakes and handle exceptions
        try {
            bob.setErrorCakes(100);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            andrew.addCakesMade(32);
            andrew.setErrorCakes(18);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            hafsa.addCakesMade(44);
            hafsa.setErrorCakes(21);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            ayub.addCakesMade(102);
            ayub.setErrorCakes(12);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            amaan.addCakesMade(56);
            amaan.setErrorCakes(1);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            gary.addCakesMade(62);
            gary.setErrorCakes(25);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        try {
            diane.addCakesMade(10);
            diane.setErrorCakes(2);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        //Call method to sort team with exception handling
        try {
            team.sortTeam();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        //Call method to print teams details with exception handling
        try {
            System.out.println(team.printTeam());
            System.out.println(team.printTeamTotalWages());
            System.out.println(team.printTeamTotalCakes());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
