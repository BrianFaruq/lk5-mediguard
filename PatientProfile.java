public class PatientProfile implements Versioned, MedicalRecord, Confidential<PatientProfile> {
    protected final int version;
    protected final int patientID;
    protected final String name;
    protected final String illness;
    protected final Security securityLevel;
    protected String[] record = new String[5];
    public PatientProfile(int patientID, String name, String illness, int version, Security securityLevel) {
        this.patientID = patientID;
        this.name = name;
        this.illness = illness;
        this.version = version;
        this.securityLevel = securityLevel;
    }
    @Override
    public int getVersion() {
        return this.version;
    };
    public int getSecurityLevel() {
        return this.securityLevel.level();
    }
    @Override
    public PatientProfile maskFields(int requesterClearanceLevel) {
        if (requesterClearanceLevel < this.securityLevel.level()) {
            return new PatientProfile(
                this.patientID, 
                   "******", 
                "******", 
                requesterClearanceLevel, 
                securityLevel);
        }else{
            return this;
        }
    }

    @Override
    public void addRecord(String record) {
        for(int i=4;i>0;i--){
            this.record[i] = this.record[i-1];
        }
        this.record[0] = record;
    }

    @Override
    public String toString(){
        return "========== Patient Profile ==========\n"+
                "Patient ID: "+this.patientID+"\n"+
                "Name: "+this.name+"\n"+
                "Illness: "+this.illness+"\n"+
                "Security Level: "+this.securityLevel.levelName()+"\n";
    }
}
