package CraftyCake.java;
public class Main {
    public static void main(String[] args) {
        Team team = new Team();

        Employee bob = new Employee("Bob", 100);

        Employee rabia = new QualityController("Rabia", 385);

        bob.printEmployee();

        team.addEmployee(bob);
        team.addEmployee(rabia);



    }
}
