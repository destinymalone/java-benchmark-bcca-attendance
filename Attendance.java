import java.io.Serializable;

public class Attendance implements Serializable {
    private static final long serialVersionUID = 1L;
    String date;
    String name;
    Integer tardies;
    Integer absences;
    Integer partialAbsences;
    Integer angieU;
    Integer christianG;
    Integer dakotaN;
    Integer derekS;
    Integer destinyM;
    Integer devinB;
    Integer dylanM;
    Integer gillianF;
    Integer jdG;
    Integer oscarG;
    Integer pattonB;
    Integer tylerI;
	public int quantity;

    public Attendance(String date, String name) {
        this.date = date;
        this.name = name;
        this.tardies = 0;
        this.absences = 0;
        this.partialAbsences = 0;
        this.angieU = 0;
        this.christianG = 0;
        this.dakotaN = 0;
        this.derekS = 0;
        this.destinyM = 0;
        this.devinB = 0;
        this.dylanM= 0;
        this.gillianF = 0;
        this.jdG = 0;
        this.oscarG = 0;
        this.pattonB = 0;
        this.tylerI = 0;
    }

    public Attendance(String date, String name, Integer tardies, Integer absences, Integer partialAbsences, Integer angieU, Integer christianG, Integer dakotaN, Integer derekS) {
        this.date = date;
        this.name = name;
        this.tardies = tardies;
        this.absences = absences;
        this.partialAbsences = partialAbsences;
    }

    public Integer calculateTotalTardies() {
        return (tardies);
    }

    public Integer calculateTotalAbsences() {
        return (absences);
    }

    public Integer calculateTotalPartialAbsences() {
        return (partialAbsences);
    }

	public String calculateTotalPresent() {
		return null;
	}

}