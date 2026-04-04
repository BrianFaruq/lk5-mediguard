public class SecurityEnum {
    private final int securityLevel;
    private final String securityLevelName;
    public SecurityEnum(int securityLevel) {
        this.securityLevel = securityLevel;
        switch (securityLevel) {
            case 0:
                this.securityLevelName = "PUBLIC";
                break;
            case 1:
                this.securityLevelName = "RESTRICTED";
                break;
            case 2:
                this.securityLevelName = "SECRET";
                break;
            default:
                this.securityLevelName = "Unknown";
                break;
        }
    }
    public int level() {
        return securityLevel;
    }

    public String levelName() {
        return securityLevelName;
    }

}
