import java.io.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import java.util.Scanner;

public class ReportCard {
    public static void main(String... args) {
        List<Student> students = new ArrayList<>(); // [{kevin, dale} , {kayla, dale}]
        BufferedReader myReader = null;
        Scanner scan = new Scanner(System.in);
        Student student = null;
        BufferedWriter writer = null;

        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");

        getFile(myReader, scan, students);
        assignment(scan, students);


    }

    private static void getFile(BufferedReader myReader, Scanner scan, List<Student> students) {
        System.out.print("Enter the student file location: ");
        String file = scan.nextLine();
        try {
            myReader = new BufferedReader(new FileReader(file));
            String fullName;
            while ((fullName = myReader.readLine()) != null) {
                String firstName = fullName.split(" ")[0];
                String lastName = fullName.split(" ")[1];
                Student student = new Student(firstName, lastName);
                students.add(student);
                System.out.println("Creating student " + student.getFirstName() + " " + student.getLastName());
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
    private static boolean anotherAssignment(Scanner scan) {
        System.out.print("\nAnother assignment? (y/n): ");
        String result = scan.nextLine();
        return result.equalsIgnoreCase("y");
    }


    private static void assignment(Scanner scan, List<Student> students) {
        while (true) {
            System.out.print("\nEnter the name of an Assignment: ");
            String assignmentName = scan.nextLine();
            for (Student stud : students) {
                System.out.print("Enter grade for " + stud.getFirstName() + " " + stud.getLastName() + ": ");
                double grade = scan.nextDouble();
                scan.nextLine();
                stud.getAssignmentToGrade().put(assignmentName, grade);
            }
            if(!anotherAssignment(scan)){
                System.out.print("\n Enter output directory: ");
                output(scan, );
            }
        }
    }
    private static void output(Scanner scan, Map<String, Double> assignmentToGrade){
        String filePath = scan.nextLine();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            for (Double i : assignmentToGrade.values()) {
                writer.write(i);
            }
        } catch (Exception e) {
            System.out.println("error");
        }
    }

}