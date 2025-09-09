public class Mission {
    private TypeTravail typeTravail;
    private double quotaTemps;
    private String description;

    public Mission(TypeTravail typeTravail, double quotaTemps, String description) {
        this.typeTravail = typeTravail;
        this.quotaTemps = quotaTemps;
        this.description = description;
    }

    public TypeTravail getTypeTravail() {
        return typeTravail;
    }

    public double getQuotaTemps() {
        return quotaTemps;
    }

    public String getDescription() {
        return description;
    }
}