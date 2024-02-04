import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;

public class ReportCard {
    public static void main(String... args) {
        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");
        Scanner scanner = null;
        BufferedWriter writer = null;
        BufferedReader myReader = null;
        Student students = new Student();
        Student tStark = new Student();
        Student pParker = new Student();
        Student wWilson = new Student();


        System.out.println("Enter the student file location: ");
        String file = "C:\\Users\\bta96367\\QTR2\\report_card_generator\\student.txt";

        try {
            scanner = new Scanner(file);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("Tony Stark\n");
            writer.write("Peter Parker\n");
            writer.write("Wade Wilson\n");
        } catch (Exception e) {
            System.out.println("Input file not found");
        } finally {
            try {
                writer.close();
            }   catch (IOException e) {
                System.out.println("ERROR");
            }


        }
        try {
            myReader = new BufferedReader(new FileReader(file));
            String line;
            while((line = myReader.readLine()) != null) {
                String[] names = line.split(" ");
                String firstName = names[0];
                String lastName = names[1];
                students.setFirstName(firstName);
                students.setLastName(lastName);
                System.out.println("Creating student " + students.getFirstName() + " " + students.getLastName());
            }

        } catch (Exception e) {
            System.out.println("error");
        }
        finally {
            try {
                myReader.close();
            } catch (Exception e) {
                System.out.println("error");
            }
        }

        System.out.println("Enter the name of an assignment: ");
        if (scanner != null) {
            String assignmentName = scanner.nextLine();
            System.out.println("Enter grade for Tony Stark");
            double grade = scanner.nextDouble();
            scanner.nextLine();
            tStark.getAssignmentToGrade.put(assignmentName, grade);
        }
    }



}
//how to read scanner is 51:49