public class PatientProfileV2 extends PatientProfile {
    private String allergy;
    public PatientProfileV2(int patientID, String name, String illness, int version, String allergy, Security securityLevel) {
        super(patientID, name, illness, version, securityLevel);
        this.allergy = allergy;
    }

    @Override
    public PatientProfileV2 maskFields(int requesterClearanceLevel) {
        if (requesterClearanceLevel < this.securityLevel.level()) {
            return new PatientProfileV2(
                this.patientID, 
                "******", 
                "******", 
                this.version, 
                "*******", 
                this.securityLevel);
        }else{
            return this;
        }
    }

    @Override
    public String toString(){
        return super.toString()
                +"Version : "+this.version+"\n"
                +"Allergy : "+this.allergy+"\n";
    }
}
