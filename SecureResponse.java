public class SecureResponse<T extends MedicalRecord & Confidential<PatientProfile> & Versioned> {
    private T data;
    private int requesterClearanceLevel;

    public SecureResponse(T data, int requesterClearanceLevel){
        this.data = data;
        this.requesterClearanceLevel = requesterClearanceLevel;
    }

    private T applyMask(T originalData){
        if(originalData instanceof Confidential){
            Confidential<?> maskableData = (Confidential<?>) originalData;
            return (T) maskableData.maskFields(requesterClearanceLevel);
        }
        return originalData;
    }

    public T getData(){
        return data;
    }
}
