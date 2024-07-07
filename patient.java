import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class patient {
    public void add_patient() {
        try {
            Scanner input = new Scanner(System.in);
            File file = new File("add_patients.txt");
            FileWriter writer = new FileWriter(file, true); // 'true' to append to the file

            System.out.println("Enter Password to verify that you are in our management department:");
            int choice = input.nextInt();

            if (choice == 1234) {
                input.nextLine(); // Consume newline left-over
                System.out.println("Enter patient name:");
                String name = input.nextLine();

                System.out.println("Enter patient age:");
                int age = input.nextInt();
                input.nextLine(); // Consume newline

                System.out.println("Enter patient gender:");
                String gender = input.nextLine();

                System.out.println("Enter patient ID:");
                int id = input.nextInt();
                input.nextLine(); // Consume newline

                System.out.println("Enter appointment date (yyyy-mm-dd):");
                String appointmentDate = input.nextLine();

                if (!isAppointmentAvailable(appointmentDate)) {
                    System.out.println("Appointment date is already booked. Please choose another date.");
                } else {
                    // Write patient information to file
                    writer.write("Patient ID: " + id + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Appointment Date: " + appointmentDate + "\n");
                    System.out.println("Patient information and appointment added successfully.");
                }
            } else {
                System.out.println("Incorrect password. Access denied.");
            }

            writer.close();
            input.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean isAppointmentAvailable(String appointmentDate) {
        try {
            File file = new File("add_patients.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Appointment Date: " + appointmentDate)) {
                    reader.close();
                    return false; // Appointment date is already booked
                }
            }

            reader.close();
            return true; // Appointment date is available
        } catch (IOException e) {
            System.out.println("An error occurred while checking the file.");
            e.printStackTrace();
            return false; // Consider appointment not available if an error occurs
        }
    }

    public void view_patients() {
        try {
            File file = new File("add_patients.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            System.out.println("Patient Records:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public boolean check_patient() {
        try {
            File file = new File("add_patients.txt");
            if (!file.exists() || file.length() == 0) {
                return true; // File is empty or does not exist

            } else {
                return false; // File is not empty
            }
        } catch (Exception e) {
            System.out.println("An error occurred while checking the file.");
            e.printStackTrace();
            return true; // Consider the file empty if an error occurs
        }
    }

    public void deleteAllPatients() {
        try {
            File file = new File("add_patients.txt");
            FileWriter writer = new FileWriter(file);
            writer.write(""); // Truncate the file by setting its content to an empty string
            writer.close();
            System.out.println("All patient data has been deleted.");
        } catch (IOException e) {
            System.out.println("An error occurred while deleting patient data.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void search_patient(String searchTerm) {
        try {
            File file = new File("add_patients.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                if (line.contains("Patient ID: " + searchTerm) || line.contains("Name: " + searchTerm)) {
                    System.out.println("Patient Found:");
                    System.out.println(line);
                    found = true;
                    break;
                }
            }

            reader.close();

            if (!found) {
                System.out.println("Patient with ID or Name " + searchTerm + " not found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
