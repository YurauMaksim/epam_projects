package console.report.writer;

import constants.Constants;
import info.ProjectInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class ProjectInfoReader {
    private final String path;


    private static final int GROUP_ID = 0;
    private static final int ARTEFACT_ID = 1;
    private static final int VERSION = 2;
    private static final int BUILD_TIMESTAMP = 3;

    public ProjectInfoReader(String path) {
        this.path = path;
    }

    public String readFile(){
        StringBuilder sb = new StringBuilder();

        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8)) {

            int i;
            while((i=isr.read())!= -1){

                sb.append((char) i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public ProjectInfo getProjectInfo(String string){

        String[] info;
        ProjectInfo projectInfo;
        info = string.split(Constants.DELIMETER);
        projectInfo = new ProjectInfo(info[GROUP_ID], info[ARTEFACT_ID], info[VERSION], info[BUILD_TIMESTAMP]);

        return projectInfo;
    }
}
