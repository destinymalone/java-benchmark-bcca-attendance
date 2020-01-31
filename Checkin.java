import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Checkin {
    // private static final int absences = 0;
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<Attendance> checkins = loadCheckins();
        ArrayList<Attendance> checkinTimes = checkinTime(0, null, null);

        Attendance roll = startRoll();

        System.out.println("Sign in: ");
        while (true) {
            String choice = getStudentChoice();
            // String date = checkinTime(0, choice, null);
            if (choice == null) {
                break;
            }
            Integer quantity = getTotalPresent();

            updateRoll(roll, choice, quantity);
        }

        System.out.print("Total Students Present: ");
        System.out.println(roll.calculateTotalPresent());

        checkins.add(roll);

        displayAttendanceLog(roll);

        saveCheckins(checkins);
        saveCheckinTime(checkinTimes);
    }

    private static int displayAttendanceLog(Attendance roll) {
        System.out.println("--- Attendance Log ---");
        System.out.println("Total: $" + roll.calculateTotalPresent());
        System.out.println("Name: " + roll.name);
        System.out.println("Date: " + roll.date);
        System.out.println("Students:");

        if (roll.angieU > 0) {
            System.out.println(" - Angie U.: " + roll.angieU);
        }
        if (roll.christianG > 0) {
            System.out.println(" - Christian G: " + roll.christianG);
        }
        if (roll.dakotaN > 0) {
            System.out.println(" - Dakota N.: " + roll.dakotaN);
        }
        if (roll.derekS > 0) {
            System.out.println(" - Derek S.: " + roll.derekS);
        }
        if (roll.destinyM > 0) {
            System.out.println(" - Destiny M.: " + roll.destinyM);
        }
        if (roll.devinB > 0) {
            System.out.println(" - Devin B.: " + roll.devinB);
        }
        if (roll.dylanM > 0) {
            System.out.println(" - Dylan M: " + roll.dylanM);
        }
        if (roll.gillianF > 0) {
            System.out.println(" - Gillian F.: " + roll.gillianF);
        }
        if (roll.jdG > 0) {
            System.out.println(" - JD G.: " + roll.jdG);
        }
        if (roll.oscarG > 0) {
            System.out.println(" - Oscar G.: " + roll.oscarG);
        }
        if (roll.pattonB > 0) {
            System.out.println(" - Patton B.: " + roll.pattonB);
        }
        if (roll.tylerI > 0) {
            System.out.println(" - Tyler I.: " + roll.tylerI);
        }
    }

    public static Object notCheckedIn(String choice, int absences) {
        while (true) {
            if (choice != "1") {
                return absences++;
            } else if (choice != "2") {
                return absences++;
            } else if (choice != "3") {
                return absences++;
            } else if (choice != "4") {
                return absences++;
            } else if (choice != "5") {
                return absences++;
            } else if (choice != "6") {
                return absences++;
            } else if (choice != "7") {
                return absences++;
            } else if (choice != "8") {
                return absences++;
            } else if (choice != "9") {
                return absences++;
            } else if (choice != "10") {
                return absences++;
            } else if (choice != "11") {
                return absences++;
            } else if (choice != "12") {
                return absences++;
            } else {
                break;
            }
        }
        return absences;
    }

    private static ArrayList<Attendance> checkinTime(long tardies, ArrayList<Attendance> name, Boolean choice) {
        java.util.Date date = new java.util.Date();
        java.sql.Date dateTime = new java.sql.Date(date.getTime());
        System.out.println(dateTime);

        boolean isBefore = dateTime.getTime() < new Date(tardies).getTime();
        boolean isAfter = dateTime.getTime() > new Date(tardies).getTime();

        if (choice == isBefore) {
            System.out.print(name + " is on time.");
        } else if (choice == isAfter) {
            System.out.print(name + " is late.");
        } else {
            System.out.print("Everyone was on time!");
        }
        return name;
    }

    private static void saveCheckins(ArrayList<Attendance> checkins) {
        try {
            FileOutputStream fileStream = new FileOutputStream("checkin.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkins);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save checkins.");
        }
    }

    private static void saveCheckinTime(ArrayList<Attendance> checkinTimes) {
        try {
            FileOutputStream fileStream = new FileOutputStream("checkin.ser");
            ObjectOutputStream os = new ObjectOutputStream(fileStream);
            os.writeObject(checkinTimes);
            os.close();
        } catch (IOException ex) {
            System.out.println("Failed to save checkins.");
        }
    }

    private static void updateRoll(Attendance roll, String choice, Integer quantity) {
        if (choice.equals("1")) {
            roll.angieU += quantity;
        } else if (choice.equals("2")) {
            roll.christianG += quantity;
        } else if (choice.equals("3")) {
            roll.dakotaN += quantity;
        } else if (choice.equals("4")) {
            roll.derekS += quantity;
        } else if (choice.equals("5")) {
            roll.destinyM += quantity;
        } else if (choice.equals("6")) {
            roll.devinB += quantity;
        } else if (choice.equals("7")) {
            roll.dylanM += quantity;
        } else if (choice.equals("8")) {
            roll.gillianF += quantity;
        } else if (choice.equals("9")) {
            roll.jdG += quantity;
        } else if (choice.equals("10")) {
            roll.oscarG += quantity;
        } else if (choice.equals("11")) {
            roll.pattonB += quantity;
        } else if (choice.equals("12")) {
            roll.tylerI += quantity;
        } else {
            System.out.println("Not a choice.");
        }
    }

    private static Integer getTotalPresent() {
        while (true) {
            System.out.print("Checked In[1]/Didn't Check In[2] ");
            try {
                Integer quantity = Integer.parseInt(in.nextLine());
                if (quantity == 1) {
                    return quantity;
                }
            } catch (NumberFormatException ex) {
            }
            System.out.println("Please provide a positive, whole number-[1] or [2]");
        }
    }

    private static String getStudentChoice() {
        while (true) {
            System.out.println(" 1. Angie U.");
            System.out.println(" 2. Christian G.");
            System.out.println(" 3. Dakota N.");
            System.out.println(" 4. Derek S.");
            System.out.println(" 5. Destiny M.");
            System.out.println(" 6. Devin B.");
            System.out.println(" 7. Dylan M");
            System.out.println(" 8. Gillian F.");
            System.out.println(" 9. JD G.");
            System.out.println(" 10. Oscar G.");
            System.out.println(" 11. Patton B.");
            System.out.println(" 12. Tyler I.");
            System.out.println(" Q. quit");
            System.out.print(">>> ");
            String choice = in.nextLine();
            if (choice.equalsIgnoreCase("q")) {
                return null;
            } else if (choice.equals("1") || choice.equals("2") || choice.equals("3") || choice.equals("4")
                    || choice.equals("5") || choice.equals("6") || choice.equals("7") || choice.equals("8")
                    || choice.equals("9") || choice.equals("10") || choice.equals("11") || choice.equals("12")) {
                return choice;
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    public static Attendance startRoll() {
        System.out.print("Full Name: ");
        String name = in.nextLine();
        System.out.print("Date: ");
        String date = in.nextLine();
        return new Attendance(name, date);
    }

    public static ArrayList<Attendance> loadCheckins() {
        try {
            FileInputStream fileStream = new FileInputStream("checkin.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            ArrayList<Attendance> checkin = (ArrayList<Attendance>) os.readObject();
            os.close();
            return checkin;
        } catch (IOException | ClassNotFoundException ex) {
            return new ArrayList<Attendance>();
        }
    }
}