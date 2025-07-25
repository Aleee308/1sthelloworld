package studentgraderecord;
import java.util.Scanner;
public class StudentGradeRecord {
static int numberOfStudents;
static String[] StudentName;
static int StudentID[];
static int StudentMarks[];
public static void inputstudentdata(){
    Scanner input = new Scanner(System.in);
    System.out.println("Enter number of Students:");
    numberOfStudents = input.nextInt();
    StudentName = new String[numberOfStudents];
    StudentID = new int[numberOfStudents];
    StudentMarks = new int[numberOfStudents];
    
    for(int i=0; i<numberOfStudents; i++){
        System.out.println("Enter Data for Students:"+(i + 1));
        System.out.print("StudentName: ");
        StudentName[i] = input.nextLine();
        System.out.print("StudentID: ");
        StudentID[i] = input.nextInt();
        System.out.print("StudentMarks: ");
        StudentMarks[i] = input.nextInt();
        input.nextLine();
    }
}
public static void displayStudentdata(){
    System.out.println("-----Students Record-----");
    for(int i=0; i<numberOfStudents; i++){
    System.out.println("Students Name: "+StudentName[i]+" ,Student ID: "+StudentID[i]+" ,Student Marks: "+StudentMarks[i]+" ,Grade: "+getgrade(StudentMarks[i]));
    }
}
public static String getgrade(int marks){
    if(marks >= 85) return "A";
    else if(marks >= 70) return "B";
    else if(marks >= 60) return "C";
    else if(marks >= 50) return "D";
    else return "F";
}
public static int highest(int[] marks){
    int high = marks[0];
    for(int i=0; i<numberOfStudents; i++){
        if(high < marks[i]){
            high = marks[i]; 
        }
    }
    return high;
}
public static int lowest(int[] marks){
    int low = marks[0];
    for(int i=0; i<numberOfStudents; i++){
        if(low > marks[i]){
            low = marks[i];
        }
    }
    return low;
}
public static double calculateAverage(int[] marks){
    int sum = 0;
    for(int i=0; i<numberOfStudents; i++){
        sum+=marks[i];
    }
     double avg = sum/numberOfStudents;
     return avg;
}
    public static void main(String[] args) {
        inputstudentdata();
        displayStudentdata();
        System.out.println("The Average of the Students Marks: "+(calculateAverage(StudentMarks)));
        System.out.println("Highest marks: "+highest(StudentMarks));
        System.out.println("Lowest marks: "+lowest(StudentMarks));
    }
    
}
