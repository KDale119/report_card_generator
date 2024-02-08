import java.io.*;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
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
        System.out.println("\nSuccessfully Generate Report Cards!");


    }

    private static void getFile(BufferedReader myReader, Scanner scan, List<Student> students) {
        System.out.print("Enter the student file location: ");
        String file = scan.nextLine();
        if (file.isEmpty() || !Files.exists(Paths.get(file))) {
            System.out.println("\nInput file not found\n");
            System.out.print("Enter the student file location: ");
            file = scan.nextLine();
            System.out.println("\n");
        }
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
                while (true) {
                    System.out.print("Enter grade for " + stud.getFirstName() + " " + stud.getLastName() + ": ");
                    double grade = scan.nextDouble();
                    scan.nextLine();
                    if (grade >= 0 && grade <=100){
                        stud.getAssignmentToGrade().put(assignmentName, grade);
                        break;
                    } else {
                        System.out.println("Invalid grade. Try again");
                    }
                }

            }
            if (!anotherAssignment(scan)) {
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
                writer.write("\nAverage: " + average(student, student) + "\n");
                if (average(student, student) < 100 & average(student, student) >= 90) {
                    writer.write("Letter Grade: A \n");
                } else if (average(student, student) < 90 && average(student, student) >= 80) {
                    writer.write("Letter Grade: B \n");
                } else if (average(student, student) < 80 && average(student, student) >= 70) {
                    writer.write("Letter Grade: C \n");
                }else if (average(student, student) < 70 && average(student, student) >= 60) {
                    writer.write("Letter Grade: D \n");
                } else {
                    writer.write("Letter Grade: F \n");
                }
                writer.write("\n");
                for (String i : student.getAssignmentToGrade().keySet()) {
                    writer.write( i + ": " + student.getAssignmentToGrade().get(i) + "%\n");
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

    private static Double average(Student student, Student students) {
        double sum = 0;
        double mean = 0;
        for (Double i : student.getAssignmentToGrade().values()) {
            sum += i;
            mean = sum / students.getAssignmentToGrade().size();
        }
        return mean;
    }
}