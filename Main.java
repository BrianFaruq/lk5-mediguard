public class Main {
    public static void main(String[] args) {
        PatientProfileV2 patient1 = new PatientProfileV2(1001, "John Doe", "Heart Disease", 1, "Peanut", new Security(1));
        patient1.addRecord("2023-01-01 : Initial visit");
        patient1.addRecord("2023-02-01 : Follow-up visit");
        patient1.addRecord("2023-03-01 : Consultation with Dr. Smith");
        patient1.addRecord("2023-04-01 : Test results");
        patient1.addRecord("2023-05-01 : Follow-up visit");
        
        Requester request = new Requester(2, "1001", "Dr. Smith");

        IntegrationGateway<PatientProfileV2> gateway = new IntegrationGateway<>(patient1, request.getRequesterClearanceLevel());
        SecureResponse<PatientProfileV2> response = gateway.fetchData(patient1, request.getRequesterClearanceLevel());

        System.out.println(response.toString());
        
    }
 }

