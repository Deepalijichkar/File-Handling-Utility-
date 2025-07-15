import java.io.*;
import java.util.Scanner;

public class FileUtility {

    // Method to write to a file
    public static void writeToFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read from a file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("📄 Reading file content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to modify content in a file (replace oldText with newText)
    public static void modifyFile(String filename, String oldText, String newText) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replace(oldText, newText)).append("\n");
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
            return;
        }

        // Write modified content back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content.toString());
            System.out.println("🔁 File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing file: " + e.getMessage());
        }
    }

    // Main method to demonstrate the file operations
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "sample.txt";

        System.out.println("📌 File Handling Utility 📌");
        
        // Write to file
        System.out.print("Enter text to write to the file: ");
        String content = scanner.nextLine();
        writeToFile(filename, content);

        // Read from file
        readFromFile(filename);

        // Modify file content
        System.out.print("Enter text to be replaced: ");
        String oldText = scanner.nextLine();
        System.out.print("Enter new text: ");
        String newText = scanner.nextLine();
        modifyFile(filename, oldText, newText);

        // Read updated file content
        readFromFile(filename);
    }
}
