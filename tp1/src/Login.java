import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        // Load the user database from the CSV file
        HashMap<String, String> userDatabase = loadUserDatabase("../data/user_hashpwd.csv");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ask for username
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();

            // Check if the username exists in the database
            if (userDatabase.containsKey(username)) {
                // Ask for password
                System.out.print("Enter password: ");
                String password = scanner.nextLine().trim();

                // Compare the hashed password (assuming you have a hashPassword method for password hashing)
                String storedHash = userDatabase.get(username);
                String hashedPassword = hashPassword(password);

                // Check if the password matches the stored hash
                if (storedHash.equals(hashedPassword)) {
                    System.out.println("Login successful!");
                    break; // Exit the loop and program
                } else {
                    System.out.println("Incorrect password. Please try again.");
                }
            } else {
                System.out.println("Username not found. Please try again.");
            }
        }

        scanner.close();
    }

    /**
     * Loads a user database from a CSV file.
     * The CSV file is expected to have two columns: username and hashed password.
     * 
     * @param filename The path to the CSV file containing user data.
     * @return A HashMap where keys are usernames and values are hashed passwords.
     * 
     * @throws IOException If an error occurs while reading the file.
     */
    public static HashMap<String, String> loadUserDatabase(String filename) {
        HashMap<String, String> userDatabase = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            br.readLine(); // Skip header if present
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    userDatabase.put(parts[0].trim(), parts[1].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return userDatabase;
    }

    /**
     * Hashes the provided password using SHA-256 (or any other suitable hashing algorithm).
     * 
     * @param password the password to be hashed
     * @return the hashed password
     */
    public static String hashPassword(String password) {
        // Implement password hashing here (e.g., SHA-256 or other hashing algorithm)
        // For simplicity, we'll just return the input as is in this example, but in practice
        // use a strong hashing algorithm with salt, like SHA-256 or bcrypt.
        return password; // Replace with actual hashing logic
    }
}
