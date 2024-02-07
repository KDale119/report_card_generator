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



        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");

        getFile(myReader, scan, students);
        assignment(scan, students);
        output(scan, students);


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
                break;
            }
        }
    }
    private static void output(Scanner scan, List<Student> students) {
        String filePath = scan.nextLine();
        BufferedWriter writer = null;
        for (Student student : students) {
            try {
                File studentFile = new File(filePath + "\\" + student.getFirstName() + student.getLastName() + ".txt");
                writer = new BufferedWriter(new FileWriter(studentFile));
                writer.write(student.getFirstName() + " " + student.getLastName() + "\n");
                for (String i : student.getAssignmentToGrade().keySet()) {

                    writer.write(i + ": " + student.getAssignmentToGrade().get(i) + "%");
                }

            } catch (Exception e) {
                System.out.println("error");
                e.printStackTrace();
            } finally {
                try {
                    if (writer != null) {
                        writer.close();
                    }
                } catch (Exception e) {
                    System.out.println("error");
                }
            }
        }
    }
//    private static Double average(){
//        double sum = 0;
//        double mean = 0;
//        for (Double total : grades) {
//            sum += total;
//            mean = sum/10;
//        }
//    }
}