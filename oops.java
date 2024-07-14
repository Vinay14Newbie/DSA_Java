// import java1.testing;

import java.util.Scanner;

import java1.linkedList_implementation; //to access class from different package or folder we have to import that package

public class oops{
  // creating a new data type with multiple artribute
  public static class students{ 
    String name;
    int rollNo;
    double percentage;
    final String schoolName = "SSPC";
    int noOfStudents;
  }
  // public static void print(students s1){
  //   // System.out.println(s1.name);
  //   s1.name = "naruto";
  // }
  // public static void print(hellojava s1){
  //   s1.name = "naruto";
  // }
  public static void main(String[] args) {
    // Scanner sc = new Scanner(System.in);
    // class students{
    //   String name;
    //   int rollNo;
    //   double percentage;
    // }
    // testing s1 = new testing(); //declaration
    // students s1 = new students();
    // hellojava.noOfStudents = 1000;
    System.out.println(hellojava.getnoOfStudents());  //now it cannot be directly modified
    // hellojava s1 = new hellojava();
    System.out.println(hellojava.getnoOfStudents());
    // System.out.println(s1.name+" "+s1.rollNo+" "+s1.percentage);

    hellojava s2 = new hellojava();
    System.out.println(s2.getnoOfStudents()); //we don't need to write like this if we are using static function instead of this we can write, as write as above 
    // System.out.println(s2.name+" "+s2.rollNo+" "+s2.percentage);

    hellojava s3 = new hellojava();
    System.out.println(s3.getnoOfStudents());
    // System.out.println(s3.name+" "+s3.rollNo+" "+s3.percentage);

    // hellojava s1 = new hellojava();
    // s1.name = sc.nextLine();
    // s1.rollNo = sc.nextInt();
    // s1.percentage = sc.nextDouble();
    // hellojava s1 = new hellojava();
    // s1.name = "vinay";
    // s1.rollNo = 1111;
    // s1.percentage = 71.20;
    // // s1.schoolName = "kk";
    // System.out.println(s1.schoolName);

    // System.out.println(s1.name+" "+s1.rollNo+" "+s1.percentage);
    // hellojava s2 = new hellojava();
    // s2.name = "vinay";
    // System.out.println(s2.name);
    // s1.name = "vinay";
    // s1.rollNo = 1111;
    // System.out.println(s1.getrollNo());  //getter
    // s1.setrollNo(1113);
    // System.out.println(s1.getrollNo());
    // s1.percentage = 71.20;
    // System.out.println(s1.name);
    // print(s1);
    // System.out.println(s1.name);
    // students s2 = new students();
    // s2.name = "ajay";
    // s2.rollNo = 2342;
    // s2.percentage = 90.34;
    // System.out.print(s1.name +" "+ s1.rollNo +" "+ s1.percentage );
  }
}