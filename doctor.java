import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class doctor {
    private String name;

    public doctor(String name) {
        this.name = name;
    }

    public void view_Doctor() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("doctor_records.txt"));
            String line;

            System.out.println("Doctor Records for " + name + ":");
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
}
