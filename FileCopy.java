import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "source.txt";
        String destinationFilePath = "destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String replacedLine = line.replace(" ", "-");
                writer.write(replacedLine);
                writer.newLine();
            }
            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("An error occurred while copying the file: " + e.getMessage());
        }
    }
}
