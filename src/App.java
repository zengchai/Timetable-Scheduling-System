import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Course> Course = new ArrayList<Course>();
        Admins z = new Admins(Course); 
        z.menu();
    }
}
