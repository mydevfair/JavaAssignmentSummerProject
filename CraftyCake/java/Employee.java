package CraftyCake.java;

public class Employee extends Team implements Comparable<Employee> {
    private String name;
    private int cakesMade;

    public Employee(String name, int cakesMade) {
        this.name = name;
        this.cakesMade = cakesMade;
    }

    public String getName() {
        return name;
    }

    public int getCakesMade() {
        return cakesMade;
    }

    public double getWage() {
        double wage;
        wage = (50 * 0.1) + (getCakesMade() - 50) * 0.15;
        return wage;
    }

    public void addCakesMade(int addCakes) {
        this.cakesMade = cakesMade + addCakes;
    }

    public void setErrorCakes(int subCakes) throws Exception {
        if (cakesMade - subCakes * 2 >= 0) {
            this.cakesMade = cakesMade - subCakes * 2;
        } else {
            throw new Exception(getName() + "'s " + "Cakes made cannot be less than 0, " +
                    "please enter a value less than " + cakesMade / 2 + " " +
                    "for error cakes value, otherwise it will remain at the last remaining value\n");
        }
    }

    public void printEmployee() {
        System.out.println("Employee name: " + getName() + "\n" + "Wage = " + getMoney(getWage()));
    }

    @Override
    public int compareTo(Employee o) {
        if (this.getCakesMade() == o.getCakesMade()) {
            return this.getName().compareToIgnoreCase(o.getName());
        } else {
            return o.getCakesMade() - this.getCakesMade();
        }
    }
}
