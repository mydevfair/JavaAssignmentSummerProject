package CraftyCake.java;
public class QualityController extends Employee {
    public QualityController(String name, int cakesMade){
        super(name + "(QC)", cakesMade);
    }
    @Override
    public double getWage(){
        return super.getWage() * 1.12;
    }
}
