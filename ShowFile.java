import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        int bajt;

        try {
            fis = new FileInputStream("test123.txt"); 


            do {
                bajt = fis.read(); // Read from the file
                if (bajt != -1)
                    System.out.print((char) bajt);
            } while (bajt != -1); // When bajt equals -1, the end of the file has been reached

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        } finally {
            if (fis != null) {
                try {
                    fis.close(); // Close the file
                } catch (IOException e) {
                    System.out.println("Error closing file.");
                }
            }
        }
    }
}
