import java.io.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ReportCard {
    public static void main(String... args) {
        List<Student> students = new ArrayList<>(); // [{kevin, dale} , {kayla, dale}]
        BufferedReader myReader = null;
        Scanner scan = new Scanner(System.in);
        Student student = null;

        greeting(myReader, scan, student, students);
    }

    private static void greeting(BufferedReader myReader, Scanner scan, Student student, List<Student> students){
        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");
        getFile(myReader, scan, student, students);
        assignment(scan, student, students);
        anotherAssignment(scan, student, students);
    }
    private static void getFile(BufferedReader myReader,Scanner scan, Student student, List<Student> students){
        System.out.print("Enter the student file location: ");
        String file = scan.nextLine();
        try {
            myReader = new BufferedReader(new FileReader(file));
            String fullName;
            while ((fullName = myReader.readLine()) != null) {
                String firstName = fullName.split(" ")[0];
                String lastName = fullName.split(" ")[1];
                student = new Student(firstName, lastName);
                students.add(student);
                System.out.println("Creating student " + student.getFirstName() + " " + student.getLastName() + "\n");
            }
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            try {
                myReader.close();
            } catch (Exception e) {
                System.out.println("error");
            }
        }
    }



    private static void assignment(Scanner scan, Student student, List<Student> students) {
        while (true) {
            System.out.print("Enter the name of an Assignment: ");
            String assignmentName = scan.nextLine();
            for (Student stud : students) {
                System.out.println("Enter grade for " + stud.getFirstName() + " " + stud.getLastName());
                double grade = scan.nextDouble();
                student.getAssignmentToGrade().put(assignmentName, grade);
            }
        }

    }
    private static void anotherAssignment(Scanner scan,Student student, List<Student> students){
        System.out.print("Another assignment? (y/n): ");
        String anotherAssignment=scan.nextLine();
        if(anotherAssignment.equalsIgnoreCase("y")){
            assignment(scan, student, students);
        }else{
            System.out.println("Tryagain");
            anotherAssignment(scan, student, students);
        }
    }


}
//how to read scanner is 51:49