import java.util.ArrayList;
import java.util.Scanner;

public class Admins {
    private ArrayList<Course> course;
    private int classtime;
    private Scanner z;
    
    public Admins(ArrayList<Course> course) {
        this.course = course;
        this.classtime = 0;
        this.z = new Scanner(System.in);
    }
    public void setCourseList(ArrayList<Course> course) {
        this.course = course;
        this.classtime = 0;
        this.z = new Scanner(System.in);
    }

    public void menu(){
        int option = 0;
        do{
        System.out.println("Welcome to Timetable Scheduling System");
        System.out.println("\n1. Set Class Time");
        System.out.println("2. Set Course");
        System.out.println("3. SRT schedulling");
        System.out.println("4. Round Robbin schedulling");
        System.out.println("5. View timetable");
        System.out.println("6. Exit");
        System.out.print("\nEnter your option: ");
        option = z.nextInt();
        if(option == 1){
            this.setClasstime();
        }
        else if(option ==2){
            this.setCourse();
        }
        else if(option == 3){
            this.srt();
        }
        else if(option == 4){
        }
        else if(option == 5){
        }
        }while(option != 6);
    }

    public void setCourse(){
        z.nextLine();
        System.out.print("Enter the course name: ");
        String n = z.nextLine();
        System.out.print("Enter the course code: ");
        String c = z.nextLine();
        System.out.print("Enter the credit hour: ");
        int ch = z.nextInt();
        z.nextLine();
        System.out.print("Enter the lecturer name: ");
        String ln = z.nextLine();
        System.out.print("Enter the lecturer's arrival time: ");
        int la = z.nextInt();
        Course a = new Course(n,c,ch,ln,la);
        this.course.add(a);
        System.out.println("Enter successfully!");
    }

    
    public void setClasstime() {
        System.out.print("Enter the class time: ");
        int n = z.nextInt();
        z.nextLine();
        this.classtime = n;
    }

    public void srt(){
        int z = classtime;
        int count = 0;
        int counter = 0;
        int time = 1;
        Course min = course.get(0);
        ArrayList<Course> tmpcourselist = new ArrayList<Course>();
        do{
            for(int i=0;i<course.size();i++){
                if(course.get(i).getAtime()<=count){
                if(course.get(i).getChour()<min.getChour()){
                    min = course.get(i);
                    counter = i;
                    System.out.println(i);
                }}
            }
                tmpcourselist.add(min);
                if(course.get(counter).getCounter()>=0)
                {course.get(counter).setCounter(course.get(counter).getCounter()-1);
                min = course.get(0);}
                else{course.remove(min);
                if(course.size()!=0){
                min = course.get(0);
                }
                else{
                min = new Course(null, null, 0, null, 0);
                }}
                System.out.println("Class " + (count+1));
                System.out.println("Course Name: "+ tmpcourselist.get(count).getName());
                System.out.println("Course Code: "+ tmpcourselist.get(count).getCode());
                System.out.println("Course Credit Hour: "+ tmpcourselist.get(count).getChour());
                count+=1;
        }while(count < z);
        course = tmpcourselist;
    }

}
