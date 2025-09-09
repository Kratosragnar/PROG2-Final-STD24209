public class Salarie extends Travailleur {
    private double salaireMensuel;

    public Salarie(int id, String nom, String prenom, String email, String telephone, double salaireMensuel) {
        super(id, nom, prenom, email, telephone);
        this.salaireMensuel = salaireMensuel;
    }

    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    public void setSalaireMensuel(double salaireMensuel) {
        this.salaireMensuel = salaireMensuel;
    }

    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }
}