import java.time.LocalDate;

public class Prestataire extends Travailleur {
    private double tjm;

    public Prestataire(int id, String nom, String prenom, String email, String telephone, double tjm) {
        super(id, nom, prenom, email, telephone);
        this.tjm = tjm;
    }

    public double getTjm() {
        return tjm;
    }

    public void setTjm(double tjm) {
        this.tjm = tjm;
    }

    @Override
    public double calculerSalaire() {

        return 30 * tjm;
    }


    public double calculerSalaire(LocalDate debut, LocalDate fin) {
        double joursTravailles = getDaysRed(debut, fin);
        return joursTravailles * tjm;
    }
}