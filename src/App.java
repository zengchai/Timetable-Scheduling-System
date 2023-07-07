import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Course> course = new ArrayList<Course>();
        Admins z = new Admins(course); 
        z.menu();
    }
}
