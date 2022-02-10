package info;


public class ProjectInfo {
    private String groupId;
    private String artifactId;
    private String version;
    private String buildTimeStamp;

    public ProjectInfo() {
    }

    public ProjectInfo(String groupId, String artifactId, String version, String buildTimeStamp) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.buildTimeStamp = buildTimeStamp;
    }

    @Override
    public String toString() {
        return  groupId + ";" + artifactId + ";" + version + ";" + buildTimeStamp;
    }
}
