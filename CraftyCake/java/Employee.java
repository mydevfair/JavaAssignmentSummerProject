package CraftyCake.java;
public class Employee implements Comparable<Employee>{
    private String name;
    private int cakesMade;
    public Employee(String name, int cakesMade){
        this.name = name;
        this.cakesMade = cakesMade;
    }
    public String getName() {
        return name;
    }
    public int getCakesMade() {
        return cakesMade;
    }
    public void setCakesMade(int addCakes) {
        this.cakesMade = cakesMade + addCakes;
    }
    public void setErrorCakes(int subCakes){
        this.cakesMade = cakesMade - subCakes * 2;
    }
    public double getWage(){
        double wage;
        if(cakesMade <= 50){
            wage = cakesMade * 0.1;
        }else{
            wage = (50 * 0.1) + ((cakesMade - 50) * 0.15);
        }
        return wage;
    }
    @Override
    public int compareTo(Employee o) {
        if (this.cakesMade == o.cakesMade){
            return this.getName().compareToIgnoreCase(o.getName());
        }
        else{return this.cakesMade - o.cakesMade;}
    }
}
