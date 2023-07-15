import java.util.ArrayList;
import java.util.Scanner;

public class Admins {
    private ArrayList<Course> course;
    private ArrayList<Course> tmpcourse;
    private int classtime;
    private Scanner z;
    
    public Admins(ArrayList<Course> course) {
        this.tmpcourse = course;
        this.classtime = 0;
        this.z = new Scanner(System.in);
    }

    public void setCourseList(ArrayList<Course> course) {
        this.tmpcourse = course;
        this.classtime = 0;
        this.z = new Scanner(System.in);
    }

    public ArrayList<Course> copiarArrayList(){
        ArrayList<Course> copia = new ArrayList<Course>();
        for (int i = 0; i < tmpcourse.size(); i++) {
            copia.add(new Course(tmpcourse.get(i)));
        }
        return copia;
    }

    public void menu(){
        int option = 0;
        do{
        System.out.println("\nWelcome to Timetable Scheduling System");
        System.out.println("\n1. Set Timetable");
        System.out.println("2. SRT scheduling");
        System.out.println("3. Round Robbin scheduling");
        System.out.println("4. Exit");
        System.out.print("\nEnter your option: ");
        option = z.nextInt();
        if(option == 1){
            this.setClasstime();
        }
        else if(option == 2){
            this.srt();
        }
        else if(option == 3){
            this.roundRobin();
        }
        }while(option != 4);
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
        Course a = new Course(n,c,ch,ln,la-1);
        this.tmpcourse.add(a);
        System.out.println("Enter successfully!");
    }

    
    public void setClasstime() {
        tmpcourse.clear();
        System.out.print("Enter the class time: ");
        int n = z.nextInt();
        z.nextLine();
        this.classtime = n;
        System.out.print("Enter number of courses: ");
        int s = z.nextInt();
        for(int i=0;i<s;i++){
            System.out.println("\nCourses "+(i+1));
            this.setCourse();
        }
    }

    public void srt(){
        int z = classtime;
        int count = 0;
        int counter = 0;
        int time = 1;
        Course min;
        ArrayList<Course> course = this.copiarArrayList();
        ArrayList<Course> tmpcourselist = new ArrayList<Course>();
        System.out.printf("\n%-5s%-25s%-15s%-15s%-20s","No","Class Name","Class Code","Credit Hour","Lecture Name");
        do{
            min = new Course(classtime);
            for(int i=0;i<course.size();i++){
                if(course.get(i).getAtime()<=count){
                if(course.get(i).getChour()<min.getChour()){
                    min = course.get(i);
                    counter = i;
                }}
            }
            if(course.size()!=0){
                if(course.get(counter).getCounter()>0)
                {
                    tmpcourselist.add(min);
                    course.get(counter).setCounter();
                    System.out.printf("\n%-5s%-25s%-15s%-15s%-20s",count+1,tmpcourselist.get(count).getName(),tmpcourselist.get(count).getCode(),
                    tmpcourselist.get(count).getChour(),tmpcourselist.get(count).getLecname());
                    count+=1;
                    System.out.println();
                }else{
                    course.remove(counter);
                }}
                else{
                    System.out.printf("%-5s%-25s%-15s%-15s%-20s"," "," "," "," "," ");
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
        ArrayList<Course> course = this.copiarArrayList();
        ArrayList<Course> tmpcourselist = new ArrayList<Course>(classtime);
        System.out.printf("\n%-5s%-25s%-15s%-15s%-20s","No","Class Name","Class Code","Credit Hour","Lecture Name");

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
                                System.out.printf("\n%-5s%-25s%-15s%-15s%-20s",count+1,tmpcourselist.get(count).getName(),tmpcourselist.get(count).getCode(),
                                tmpcourselist.get(count).getChour(),tmpcourselist.get(count).getLecname());
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
                                        System.out.printf("\n%-5s%-25s%-15s%-15s%-20s",count+1,tmpcourselist.get(count).getName(),tmpcourselist.get(count).getCode(),
                                        tmpcourselist.get(count).getChour(),tmpcourselist.get(count).getLecname());
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
                System.out.printf("%-5s%-25s%-15s%-15s%-20s"," "," "," "," "," ");
                System.out.println();
                count+=1;
            }
        }
        System.out.println();
    }
}
