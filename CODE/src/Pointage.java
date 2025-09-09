import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pointage {
    private LocalDate date;
    private List<Mission> missions;
    private String couleurAffichage;

    public Pointage(LocalDate date, String couleurAffichage) {
        this.date = date;
        this.missions = new ArrayList<>();
        this.couleurAffichage = couleurAffichage;
    }

    public LocalDate getDate() {
        return date;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public String getCouleurAffichage() {
        return couleurAffichage;
    }

    public void ajouterMission(Mission mission) {
        missions.add(mission);
    }


    public double getQuotaTotal() {
        double total = 0;
        for (Mission mission : missions) {
            total += mission.getQuotaTemps();
        }
        return total;
    }
}
