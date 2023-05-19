import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class BankAccountInfo {
    public static void main(String[] args) {
        // Get the three first digits of the bank account from the user
        String bankAccountPrefix = getBankAccountPrefixFromUser();

        // Load the contents of the text file from the URL
        String fileContents = loadFileContentsFromURL();

        // Extract the relevant information from the file contents
        String bankNumber = extractBankNumber(fileContents, bankAccountPrefix);
        String bankName = extractBankName(fileContents, bankAccountPrefix);

        // Display the bank information to the user
        if (bankNumber != null && bankName != null) {
            System.out.println("Bank Number: " + bankNumber);
            System.out.println("Bank Name: " + bankName);
        } else {
            System.out.println("Bank information not found for the provided bank account prefix.");
        }
    }

    private static String getBankAccountPrefixFromUser() {
        // You can implement the logic to get the bank account prefix from the user here
        // For simplicity, let's assume the prefix is hardcoded
        return "123";
    }

    private static String loadFileContentsFromURL() {
        StringBuilder fileContents = new StringBuilder();
        try {
            URL url = new URL("https://ewib.nbp.pl/plewibnra?dokNazwa=plewibnra.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                fileContents.append(line);
                fileContents.append(System.lineSeparator());
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while loading the file contents: " + e.getMessage());
        }

        return fileContents.toString();
    }

    private static String extractBankNumber(String fileContents, String bankAccountPrefix) {
        String[] lines = fileContents.split(System.lineSeparator());
        for (String line : lines) {
            if (line.startsWith(bankAccountPrefix)) {
                return line.substring(0, 8);
            }
        }
        return null;
    }

    private static String extractBankName(String fileContents, String bankAccountPrefix) {
        String[] lines = fileContents.split(System.lineSeparator());
        for (String line : lines) {
            if (line.startsWith(bankAccountPrefix)) {
                return line.substring(9);
            }
        }
        return null;
    }
}
