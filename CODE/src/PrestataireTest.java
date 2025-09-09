import java.time.LocalDate;

public class PrestataireTest {
    public static void main(String[] args) {
        testCalculerSalaire();
        System.out.println("Test OK !");
    }

    public static void testCalculerSalaire() {
        Prestataire prestataire = new Prestataire(1, "RAND", "Jimmy", "jimmy.rand@hei.fr", "0375893616", 500.0);
        LocalDate debut = LocalDate.of(2023, 10, 1);
        LocalDate fin = LocalDate.of(2023, 10, 31);


        for (int i = 1; i <= 3; i++) {
            Pointage pointage = new Pointage(LocalDate.of(2023, 10, i), "VERT");
            pointage.ajouterMission(new Mission(TypeTravail.ENSEIGNEMENT, 1.0, "Journée complète"));
            prestataire.addPointage(pointage);
        }

        double salaire = prestataire.calculerSalaire(debut, fin);


        if (Math.abs(salaire - 1500.0) < 0.001) {
            System.out.println("Test calculSalaire: PASSÉ");
        } else {
            System.out.println("Test calculSalaire: ÉCHEC - Attendu: 1500.0, Obtenu: " + salaire);
        }
    }
}