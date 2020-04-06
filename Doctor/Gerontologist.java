public class Gerontologist extends Doctor {
    private Boolean performsHouseCalls;
    private double visitFee;
    public Gerontologist(String name) {
        super(name);
        performsHouseCalls = false;
        visitFee = 0.00;
    }
    public Gerontologist(String name, Boolean performsHouseCalls, double visitFee) {
        super(name);
        this.performsHouseCalls = performsHouseCalls;
        this.visitFee = visitFee;
    }
    public Boolean performsHouseCalls() {
        return performsHouseCalls;
    }
    public double getVisitFee() {
        return visitFee;
    }
    public void setPerformsHouseCalls(Boolean performsHouseCalls) {
        this.performsHouseCalls = performsHouseCalls;
    }
    public void setVisitFee(double visitFee) {
      if (visitFee > 0) {
        this.visitFee = visitFee;
      }
      else {
        this.visitFee = 0;
      }
    }
    public void addPatient(Patient p) throws PatientException{
      if (2020 - p.getBirthYear() > 65) {
        super.addPatient(p);
      }
      else {
        throw new PatientException("Patient too young");
      }
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nGerontologist: %s | visit fee=%02.2f", (performsHouseCalls ? "performs house calls" : "no house calls"), visitFee);
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Gerontologist) {
            Gerontologist a = (Gerontologist) o;
            if (this.performsHouseCalls == a.performsHouseCalls && this.visitFee == a.visitFee && super.equals(a)) {
                return true;
            }
        }
        return false;
    }
}
