import java.io.*;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class ReportCard {
    public static void main(String... args) {
        List<Student> students = new ArrayList<>();
        BufferedReader myReader = null;
        Scanner scan = new Scanner(System.in);
        Scanner scanner = null;

        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");

        System.out.print("Enter the student file location: ");
        String file = scan.nextLine();

        try {
            myReader = new BufferedReader(new FileReader(file));
            while (myReader.readLine() != null) {
                String fullName = myReader.readLine();
                String firstName = fullName.split(" ")[0];
                String lastName = fullName.split(" ")[0];
                Student student = new Student();
                student.setFirstName(firstName);
                student.setLastName(lastName);
                students.add(student);
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
}
//how to read scanner is 51:49