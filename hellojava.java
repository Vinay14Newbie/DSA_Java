public class hellojava{ 
    String name;
    int rollNo;
    double percentage;
    private static int noOfStudents;

    // public int getrollNo(){  //getter function
    //     return rollNo;
    // }
    // public void setrollNo(int rollNo){
    //     this.rollNo = rollNo;  //this keyword use to show given constructor is of given file
    // // }
    public hellojava(){
        noOfStudents++;
    }
    public static int getnoOfStudents(){ //if we remove static function we cannot hellojava.getnoOfStudents() do this we have to traditonally access the function
        return noOfStudents;
    }
    public hellojava(String name, int rollNo, double percentage){  //constructor
        this.name = name;
        this.rollNo = rollNo;
        this.percentage = percentage;
        noOfStudents++;
    }
}