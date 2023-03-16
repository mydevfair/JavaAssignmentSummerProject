package CraftyCake.java;

public class Employee extends Team implements Comparable<Employee> {
    private String name; //Declare variable with private attribute for objects name
    private int cakesMade; //Declare variable with private attribute for objects cakes made value

    //Create constructor for employee objects
    public Employee(String name, int cakesMade) {
        this.name = name;
        this.cakesMade = cakesMade;
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
        if (wage < 0) {
            wage = 0;
        }
        return wage;
    }

    //Method for adding cakes made to employee
    public void addCakesMade(int addCakes) {
        this.cakesMade = cakesMade + addCakes;
    }

    //Method for setting error cakes deductions to employee with exception
    public void setErrorCakes(int subCakes) throws Exception {
        if (cakesMade - subCakes * 2 >= 0) {
            this.cakesMade = cakesMade - subCakes * 2;
        } else {
            cakesMade = 0;
            throw new Exception("\n" + getName() + "'s " + "Cakes made has been set to 0 " +
                    "error cakes would have put them into a minus deficit\n");
        }
    }

    //Method to print individual employee details
    public void printEmployee() {
        System.out.println("Employee name: " + getName() + "\n" + "Cakes made: " + getCakesMade() + "\n" + "Wage = " + getMoney(getWage()));
    }

    //Override of compare to method which changes the method to sort firstly by
    //cakesMade descending order, and then alphabetically if cakesMade are equal
    @Override
    public int compareTo(Employee o) {
        if (this.getCakesMade() == o.getCakesMade()) {
            return this.getName().compareToIgnoreCase(o.getName());
        } else {
            return o.getCakesMade() - this.getCakesMade();
        }
    }
}