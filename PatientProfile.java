public class PatientProfile implements Versioned, MedicalRecord {
    private final int version;
    private final int patientID;
    private String illness;
    private SecurityEnum securityLevel;
    public PatientProfile(int patientID, String illness, int version, SecurityEnum securityLevel) {
        this.patientID = patientID;
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
}
