import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Travailleur {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;
    protected String telephone;
    protected List<Promotion> promotions = new ArrayList<>();
    protected List<Pointage> pointages = new ArrayList<>();

    public Travailleur(int id, String nom, String prenom, String email, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.telephone = telephone;
    }

    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
    }

    public void addPointage(Pointage pointage) {
        pointages.add(pointage);
    }

    public boolean pointageRouge(LocalDate date) {
        double somme = 0;
        boolean hasPointageForDate = false;

        for (Pointage p : pointages) {
            if (p.getDate().equals(date)) {
                hasPointageForDate = true;
                for (Mission mission : p.getMissions()) {
                    double quota = mission.getQuotaTemps();
                    if (quota <= 0 || quota > 1) {
                        throw new IllegalArgumentException("Quota invalide: " + quota + " pour le pointage du " + date);
                    }
                    somme += quota;
                }
            }
        }

        if (!hasPointageForDate) {
            return false;
        }

        if (somme > 1) {
            throw new IllegalArgumentException("Total des quotas dépasse 1: " + somme + " pour le pointage du " + date);
        }

        return Math.abs(somme - 1.0) < 1e-9;
    }

    public double getDaysRed(LocalDate debut, LocalDate fin) {
        double totalDays = 0;

        for (Pointage p : pointages) {
            LocalDate date = p.getDate();
            if (!date.isBefore(debut) && !date.isAfter(fin)) {

                boolean isAbsence = false;
                for (Mission mission : p.getMissions()) {
                    TypeTravail type = mission.getTypeTravail();
                    if (type == TypeTravail.ABS_PAYEE || type == TypeTravail.ABS_NON_PAYEE) {
                        isAbsence = true;
                        break;
                    }
                }

                if (!isAbsence && pointageRouge(date)) {
                    totalDays += 1.0;
                }
            }
        }

        return totalDays;
    }


    public abstract double calculerSalaire();
}