public class Pediatrician extends Doctor {
    private Boolean hasPrivatePractice;
    private String hospitalName;
    public Pediatrician() {
        hasPrivatePractice = false;
        hospitalName = "";
    }
    public Pediatrician(String name) {
        super(name);
        hasPrivatePractice = false;
        hospitalName = "";
    }
    public Pediatrician(String name, Boolean hasPrivatePractice, String hospitalName) {
        super(name);
        this.hasPrivatePractice = hasPrivatePractice;
        this.hospitalName = hospitalName;
    }
    public Boolean hasPrivatePractice() {
        return hasPrivatePractice;
    }
    public String getHospitalName() {
        return hospitalName;
    }
    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }
    @Override
    public void addPatient(Patient p) throws PatientException {
       if (2020 - p.getBirthYear() < 18) {
         super.addPatient(p);
       }
       else {
         throw new PatientException("Too old");
       }
    }
    @Override
    public String toString() {
        return super.toString() + String.format("\nPediatrician: %s | hospital name=%15s", (hasPrivatePractice ? "has private practice" : "does not have private practice"), hospitalName);
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Pediatrician) {
            Pediatrician a = (Pediatrician)o;
            if (this.hasPrivatePractice == a.hasPrivatePractice && this.hospitalName == a.hospitalName) {
                return true;
            }
        }
        return false;
    }
}
