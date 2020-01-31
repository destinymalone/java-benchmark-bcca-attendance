import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Log {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        java.util.Date date = new java.util.Date();

        ArrayList<String> students = new ArrayList<String>();
        students.add("Angie U.");
        students.add("Christian G.");
        students.add("Dakota N.");
        students.add("Derek S.");
        students.add("Destiny M.");
        students.add("Devin B.");
        students.add("Dylan M.");
        students.add("Gillian F.");
        students.add("JD G.");
        students.add("Oscar G.");
        students.add("Patton B.");
        students.add("Tyler I.");

        for (String student : students) {
            System.out.println(student);
        }

        System.out.print("Name: ");
        String name = scan.nextLine();
        System.out.println(name);
        scan.close();

        if (students.contains(name)) {
            System.out.println(name + "signed in on " + date);
        }

        saveCheckins(name);

    }

    private static void saveCheckins(String name) {
        try {
            FileOutputStream fileStream = new FileOutputStream("checkin.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(name);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save checkins.");
        }
    }
}
