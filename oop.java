import java.util.Scanner;

public class oop {
    public static void main(String[] args) {
        intro obj = new intro();
        doctor ashir = new doctor("Ashir");
        Scanner input = new Scanner(System.in);
        boolean running = true;

        obj.discription();
        
        while (running) {
            System.out.println("\nPress 1 to view as a Patient.");
            System.out.println("Press 2 to view as a Doctor.");
            System.out.println("Press any other number to exit.");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("\n\nPress 1 to add patients to the list.");
                        System.out.println("Press 2 to view patients in the list.");
                        System.out.println("Press 3 to delete all data from the file.");
                        System.out.println("Press 4 to search for a patient by ID or Name.");
                        System.out.println("Press any other number to exit from patient view");
                        int patient_choice = input.nextInt();
                        input.nextLine(); 
                        switch (patient_choice) {
                            case 1:
                                obj.add_patient();
                                return;

                            case 2:
                                obj.view_patients();
                                break;

                            case 3:
                                obj.deleteAllPatients();
                                break;

                            case 4:
                                System.out.println("Enter patient ID or Name to search:");
                                String searchTerm = input.nextLine();
                                obj.search_patient(searchTerm);
                                break;

                            default:
                                running = false;
                                break;
                        }
                    } while (!obj.check_patient());
                    break;

                case 2:
                    System.out.println("Welcome, Dr. Ashir. You are now logged in.");
                    System.out.println("Press 1 to view patient records.");
                    System.out.println("Press any other number to exit.");
                    int doctor_choice = input.nextInt();
                    if (doctor_choice == 1) {
                        obj.view_patients(); 
                    }
                    break;

                default:
                    running = false;
                    break;
            }
        }

        input.close();
    }
}
