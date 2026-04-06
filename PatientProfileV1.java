public class PatientProfileV1 extends PatientProfile {
    public PatientProfileV1(int patientID, String name, String illness, int version, Security securityLevel) {
        super(patientID, name, illness, version, securityLevel);
    }

    @Override
    public PatientProfileV1 maskFields(int requesterClearanceLevel) {
        if (requesterClearanceLevel < this.securityLevel.level()) {
            return new PatientProfileV1(
                this.patientID, 
                "******", 
                "******", 
                this.version, 
                this.securityLevel);
        }else{
            return this;
        }
    }

    @Override
    public String toString(){
        return super.toString()
                +"Version : "+this.version+"\n";
    }
}
