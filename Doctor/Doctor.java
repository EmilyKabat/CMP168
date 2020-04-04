public class Doctor implements SeesPatients{
    private static int numDoctors = 0;
    private String name;
    private int licenseNumber;
    private int numPatients;
    private Patient[] patients;
    public Doctor() {
        this.numDoctors++;
        this.name = "";
        this.licenseNumber = numDoctors;
        this.numPatients = 0;
        patients = new Patient[100];
    }
    public Doctor(String name) {
        this.numDoctors++;
        this.name = name;
        this.licenseNumber = numDoctors;
        this.numPatients = 0;
        patients = new Patient[100];
    }
    public static int getNumDoctors() {
        return numDoctors;
    }
    public int getLicenseNumber() {
        return licenseNumber;
    }
    public String getName() {
        return name;
    }
    public int getNumberOfPatients() {
        return numPatients;
    }
    public Patient[] getPatients() {
        return patients;
    }
    public void setName(String name) {
    	this.name = name;
    }
    public void setNumberOfPatients(int numPatients) {
    	this.numPatients = numPatients;
    }

    public void addPatient(Patient p) throws PatientException {
      if (numPatients < 100) {
      	patients[numPatients] = p;
      	numPatients++;
      }
      else {
        throw new PatientException("Too many patients");
      }
    }
    public String getPatientsAsString() {
        String s = "patients= ";
        if (numPatients > 0) {
          s = s + patients[0].toString();
          for (int i = 1; i < numPatients; i++) {
            s+= ", ";
              s += patients[i].toString();
          }
        }
        return s;
    }
    public boolean isPatient(Patient p) {
        for (int i = 0; i < numPatients; i++) {
            if (patients[i].equals(p)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return String.format("Doctor: name= %20s | license number= %06d | %s", name, licenseNumber, getPatientsAsString());
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof Doctor) {
            Doctor a = (Doctor)o;
            if (this.name == a.name && this.numPatients == a.numPatients) {
                return true;
            }
        }
        return false;
    }
    public int compareTo(Doctor doctor) {
        if (doctor.numPatients > this.numPatients) {
            return -1;
        }
        else if (doctor.numPatients < this.numPatients) {
            return 1;
        }
        return 0;
    }

}
