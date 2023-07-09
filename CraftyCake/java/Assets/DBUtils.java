package CraftyCake.java.Assets;

public class DBUtils {
    private String systemName, dbName, user, pass;

    private boolean isHome = true;

    public DBUtils() {
        if (isHome) {
            systemName = "localhost";
            dbName = "summer_project.employee";
            user = "root";
            pass = "Glastonbury2022!";
        } else {
            System.out.println("Failed");
        }
    }
    public String getConnectionUrl(){ return "jdbc:mysql://"+systemName+":3306/"+dbName+"?useSSL=false"; }

    public String getUser(){ return user; }

    public String getPass(){ return pass; }
}
