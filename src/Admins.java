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
            this.roundRobin();
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
        Course min;
        ArrayList<Course> tmpcourselist = new ArrayList<Course>();
        do{
            min = new Course(classtime);
            for(int i=0;i<course.size();i++){
                if(course.get(i).getAtime()<=count){
                if(course.get(i).getChour()<min.getChour()){
                    min = course.get(i);
                    counter = i;
                    //System.out.println(i);
                }}
            }
            if(course.size()!=0){
                if(course.get(counter).getCounter()>0)
                {
                    tmpcourselist.add(min);
                    course.get(counter).setCounter();
                    System.out.println("Class " + (count+1));
                    System.out.println("Course Name: "+ tmpcourselist.get(count).getName());
                    System.out.println("Course Code: "+ tmpcourselist.get(count).getCode());
                    System.out.println("Course Credit Hour: "+ tmpcourselist.get(count).getChour());
                    count+=1;
                    System.out.println();
                }else{
                    course.remove(counter);
                }}
                else{
                    System.out.println("Class " + (count+1));
                    System.out.println("Course Name: NULL");
                    System.out.println("Course Code: NULL");
                    System.out.println("Course Credit Hour: 0");
                    System.out.println();
                    count+=1;
                }
        }while(count < z);
    }

    public void roundRobin()
    {
        System.out.print("Enter the quantum time: ");  
        int quantumTime = z.nextInt();  
        int z = classtime;
        int count = 0;
        int counter = 0;
        Course c;
        ArrayList<Course> tmpcourselist = new ArrayList<Course>(classtime);
        
        while(count < z){
            c = new Course(classtime);
            if(course.size()!=0){
                for(int i=0;i<course.size();i++)
                {
                    if(course.get(i).getAtime()<=count)
                    {
                        if(course.get(i).getCounter()<=quantumTime) //getCounter = getChour
                        {
                            c = course.get(i);
                            counter = i;
                            
                            if(course.get(counter).getCounter()==0)
                            {
                                course.remove(counter);
                                break;
                            }   
                            while(course.get(counter).getCounter()!=0)//loop until all process done then proceed to unfinish process
                            {
                                tmpcourselist.add(c);
                                course.get(counter).setCounter();//decrement by 1
                                System.out.println("Class " + (count+1));
                                System.out.println("Course Name: "+ tmpcourselist.get(count).getName());
                                System.out.println("Course Code: "+ tmpcourselist.get(count).getCode());
                                System.out.println("Course Credit Hour: "+ tmpcourselist.get(count).getChour());
                                System.out.println();
                                count+=1; 
                
                            }
                        }
                        
                        else if (course.get(i).getCounter()>quantumTime)
                        {
                            if(course.get(i).getChour()!=0)
                            {
                                c = course.get(i);
                                counter = i;
                
                                if(course.get(counter).getCounter()>0)//loop until all process done then proceed to unfinish process
                                {
                                    for (int j = 0; j < quantumTime; j++)
                                    {
                                        tmpcourselist.add(c);
                                        course.get(counter).setCounter();//decrement by 1
                                        System.out.println("Class " + (count+1));
                                        System.out.println("Course Name: "+ tmpcourselist.get(count).getName());
                                        System.out.println("Course Code: "+ tmpcourselist.get(count).getCode());
                                        System.out.println("Course Credit Hour: "+ tmpcourselist.get(count).getChour());
                                        System.out.println();
                                        count+=1;
                                    }
                                }                       
                            }
                        }
                    }
                }
            }
            else if(course.isEmpty()){
                System.out.println("Class " + (count+1));
                System.out.println("Course Name: NULL");
                System.out.println("Course Code: NULL");
                System.out.println("Course Credit Hour: 0");
                System.out.println();
                count+=1;
            }
        }
        System.out.println();
    }
}
