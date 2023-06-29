public class Course {
    private String name;
    private String code;
    private int chour;
    private String lecname;
    private int atime;
    private int counter;
    public Course(int chour){
        this.chour = chour;
    }
    public Course(String name, String code, int chour, String lecname, int atime) {
        this.name = name;
        this.code = code;
        this.chour = chour;
        this.lecname = lecname;
        this.atime = atime;
    }
    public void setCounter(int counter) {
        this.counter = counter;
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
        this.counter = chour;
        return chour;
    }
    public String getLecname() {
        return lecname;
    }
    public int getAtime() {
        return atime;
    }
    
}
