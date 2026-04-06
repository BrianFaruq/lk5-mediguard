public interface Confidential<T extends Confidential<T>> {
    T maskFields(int requesterClearanceLevel);
    int getSecurityLevel();
}
