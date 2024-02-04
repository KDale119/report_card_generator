import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReportCard {
    public static void main(String... args) {
        System.out.println("Welcome to the Student Report Card Generator");
        System.out.println("--------------------------------------------\n");
        Scanner scanner = null;

        System.out.println("Enter the student file location: ");
        String file = "C:\\Users\\bta96367\\QTR2\\report_card_generator\\student.txt";

        try {

//            System.out.println("stops");
            File inputFile = new File(file);
//            System.out.println("stops");

            scanner = new Scanner(inputFile);
//            System.out.println("stops");

            String fileInput = scanner.nextLine();
//            System.out.println("stops");
            System.out.println(fileInput);
            Files.exists(Paths.get(fileInput));

        } catch (Exception e) {
            System.out.println("Input file not found");
        }


    }
}
