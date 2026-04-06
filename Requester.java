public class Requester {
    private final int requesterClearanceLevel;
    private final String id;
    private final String name;
    public Requester(int requesterClearanceLevel, String id, String name) {
        this.requesterClearanceLevel = requesterClearanceLevel;
        this.id = id;
        this.name = name;
    }
    public int getRequesterClearanceLevel() {
        return this.requesterClearanceLevel;

}
}