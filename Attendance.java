import java.io.Serializable;
import java.util.Date;

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

    public Attendance(String date, Date date2) {
        this.date = date;
        this.name = date2;
        this.tardies = 0;
        this.absences = 0;
        this.partialAbsences = 0;
        this.angieU = 0;
        this.christianG = 0;
        this.dakotaN = 0;
        this.derekS = 0;
        this.destinyM = 0;
        this.devinB = 0;
        this.dylanM = 0;
        this.gillianF = 0;
        this.jdG = 0;
        this.oscarG = 0;
        this.pattonB = 0;
        this.tylerI = 0;
    }

    public Attendance(String date, String name, Integer tardies, Integer absences, Integer partialAbsences,
            Integer angieU, Integer christianG, Integer dakotaN, Integer derekS, Integer destinyM, Integer devinB,
            Integer dylanM, Integer gillianF, Integer jdG, Integer oscarG, Integer pattonB, Integer tylerI) {
        this.date = date;
        this.name = name;
        this.tardies = tardies;
        this.absences = absences;
        this.partialAbsences = partialAbsences;
        this.angieU = angieU;
        this.christianG = christianG;
        this.dakotaN = dakotaN;
        this.derekS = derekS;
        this.destinyM = destinyM;
        this.devinB = devinB;
        this.dylanM = dylanM;
        this.gillianF = gillianF;
        this.jdG = jdG;
        this.oscarG = oscarG;
        this.pattonB = pattonB;
        this.tylerI = tylerI;

    }

    public Attendance(String name2, Date date2) {
	}

	public Integer calculateTotalTardies() {
        return (tardies + angieU + christianG + dakotaN + derekS + destinyM + devinB + dylanM + gillianF + jdG + oscarG
                + pattonB + tylerI);
    }

    public Integer calculateTotalAbsences() {
        return (absences + angieU - christianG - dakotaN - derekS - destinyM - devinB - dylanM - gillianF - jdG - oscarG
                - pattonB - tylerI);
    }

    public Integer calculateTotalPartialAbsences() {
        return (partialAbsences - angieU + christianG + dakotaN + derekS + destinyM + devinB + dylanM + gillianF + jdG
                + oscarG + pattonB + tylerI);
    }

    public Integer calculateTotalPresent() {
        return (angieU + christianG + dakotaN + derekS + destinyM + devinB + dylanM + gillianF + jdG + oscarG + pattonB
                + tylerI);
    }

}