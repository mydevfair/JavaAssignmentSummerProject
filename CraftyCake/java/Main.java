package CraftyCake.java;

public class Main {
    public static void main(String[] args) throws Exception {
        Team team = new Team();
        Employee bob = new Employee("Bob", 100);
        Employee andrew = new Employee("Andrew", 162);
        Employee hafsa = new Employee("Hafsa", 34);
        Employee ayub = new Employee("Ayub", 193);
        Employee amaan = new Employee("Amaan", 309);
        Employee gary = new Employee("Gary", 49);
        Employee diane = new Employee("Diane", 217);
        Employee rabia = new QualityController("Rabia", 385);

        team.addEmployee(bob);
        team.addEmployee(andrew);
        team.addEmployee(hafsa);
        team.addEmployee(ayub);
        team.addEmployee(amaan);
        team.addEmployee(gary);
        team.addEmployee(diane);
        team.addEmployee(rabia);

        try{
            bob.setErrorCakes(100);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            andrew.addCakesMade(32);
            andrew.setErrorCakes(16);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            hafsa.addCakesMade(44);
            hafsa.setErrorCakes(21);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            ayub.addCakesMade(102);
            ayub.setErrorCakes(12);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            amaan.addCakesMade(56);
            amaan.setErrorCakes(1);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            gary.addCakesMade(62);
            gary.setErrorCakes(11);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try{
            diane.addCakesMade(10);
            diane.setErrorCakes(2);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try {
            team.sortTeam();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        try {
            System.out.println(team.printTeam());
            System.out.println(team.printTeamTotalWages());
            System.out.println(team.printTeamTotalCakes());
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
