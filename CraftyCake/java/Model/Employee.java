package CraftyCake.java.Model;

import CraftyCake.java.Assets.Utils;
import CraftyCake.java.DBAL.TeamDBAL;

public class Employee implements Comparable<Employee> {

    private final String name; //Declare variable with private attribute for objects name
    private int cakesMade; //Declare variable with private attribute for objects cakes made value
    private int id;

    //Create constructor for employee objects
    public Employee(String name, int cakesMade, int id) {
        this.name = name;
        this.cakesMade = cakesMade;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    //Getter method for accessing private variable
    public String getName() {
        return name;
    }

    //Getter method for accessing private variable
    public int getCakesMade() {
        return cakesMade;
    }

    //Method for calculating wages returns 0 if calculation is less than 0
    public double getWage() {
        double wage;
        wage = (50 * 0.1) + (getCakesMade() - 50) * 0.15;
        if (wage <= 0) {
            wage = 0;
        }
        return wage;
    }

    //Method for adding cakes made to employee total cakes made
    public void addCakesMade(int addCakes) throws Exception {
        if (addCakes > 0){
            this.cakesMade += addCakes;

        } else{
            throw new Exception("Must provide a number greater than zero");
        }
    }

    //Method for setting error cakes deductions to employee with exception message
    //If error cakes takes cakes into a minus deficit cakes made is set to zero and
    //Notifies user
    public void setErrorCakes(int subCakes) throws Exception {
        if (cakesMade - subCakes * 2 >= 0) {
            this.cakesMade = cakesMade - subCakes * 2;
        } else {
            throw new Exception("ERROR!!!!" + getName() + "'s " + "Cakes made cannot be less than 0, " +
                    "please enter a value less than " + cakesMade / 2 + " " +
                    "for error cakes value, otherwise it will remain at the last remaining value\n");
        }
    }

    //Method to print individual employee details
    public String printEmployee() {
        return String.format("|%-10s| %10s | %12s|\n",
                this.getName(), this.getCakesMade(), Utils.getMoney(this.getWage()));
    }

    //Override of compare to method which changes the method to sort firstly by
    //cakesMade in descending order, and then alphabetically if cakesMade are equal
    @Override
    public int compareTo(Employee o) {
        if (this.getCakesMade() == o.getCakesMade()) {
            return this.getName().compareToIgnoreCase(o.getName());
        } else {
            return o.getCakesMade() - this.getCakesMade();
        }
    }
}