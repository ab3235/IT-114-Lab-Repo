
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GradeProcessor {

    public static void main(String[] args) {
        String inputFileName = "student_data.txt";
        String outputFileName = "grade_report.txt";

        // TODO 1: Wrap your code in a try-catch block.
        try {
            // TODO 2: Create a File object and a Scanner to read the input file.
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);
            // TODO 3: Create a PrintWriter object to write to the output file.
            PrintWriter pw = new PrintWriter(outputFileName);
            System.out.println("Processing file...");

            // Write the header to the output file separated by tab characters (\t);
            pw.println("Name\tAverage\tStatus");
            // Print a dashed line ("--------------------");
            pw.println("--------------------");
            // TODO 4: Create a while loop to process the file line by line.
            while (scanner.hasNext()) {
                //   - Read the name (String)
                String name = scanner.next();
                //   - Read the three scores (int or double)
                int score1 = scanner.nextInt();
                int score2 = scanner.nextInt();
                int score3 = scanner.nextInt();
                //   - Calculate the average
                double average = (score1 + score2 + score3) / 3.0;
                //   - Determine "Pass" or "Fail" (Pass is >= 70.0)
                if (average >= 70.0) {
                    //   - Write the formatted line to the output file
                    pw.println(name + " " + average + " Pass!");
                } else {
                    pw.println(name + " " + average + " Fail!");
                }
            }
            // TODO 5: Close both the Scanner and the PrintWriter.
            scanner.close();
            pw.close();

            System.out.println("Done! Check " + outputFileName + " for results.");

            // TODO 6: catch block:
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file '" + inputFileName + "' was not found.");

        }
    }
}
