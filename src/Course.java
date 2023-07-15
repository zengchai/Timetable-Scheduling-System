public class Course {
    private String name;
    private String code;
    private int chour;
    private String lecname;
    private int atime;
    private int counter;
    public Course(){
    }
    public Course(int chour){
        this.chour = chour;
    }
    public Course(String name, String code, int chour, String lecname, int atime) {
        this.name = name;
        this.code = code;
        this.chour = chour;
        this.counter = chour;
        this.lecname = lecname;
        this.atime = atime;
    }
    public void setCounter() {
        this.counter -=1;
    }
    public void setChour(int ch)
    {
        this.chour = ch;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getCounter() {
        return counter;
    }
    public int getChour() {
        return chour;
    }
    public String getLecname() {
        return lecname;
    }
    public int getAtime() {
        return atime;
    }
    
}
