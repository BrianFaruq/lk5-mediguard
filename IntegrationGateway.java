public class IntegrationGateway<T extends MedicalRecord & Confidential<PatientProfile> & Versioned> {
    private final T object;
    private int requesterClearanceLevel;
    public IntegrationGateway(T object, int requesterClearanceLevel) {
        this.object = object;
        this.requesterClearanceLevel = requesterClearanceLevel;
    }

    public SecureResponse<T> fetchData(T object, int requesterClearanceLevel){
        SecureResponse<T> response = new SecureResponse<>(object, requesterClearanceLevel);
        return response;
    }
   }
