public class Employee implements Comparable{
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
    public double setWage(){
        double wage;
        wage = (50 * 0.1) + ((cakesMade - 50) * 0.15);
        return wage;
    }
}
