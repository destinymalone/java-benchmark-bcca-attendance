import java.io.Serializable;
import java.sql.Date;

public class Attendance implements Serializable{
    String name;
    Date dateTime;

    public Attendance(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }
}

