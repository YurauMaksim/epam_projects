package project.info;

import info.ProjectInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class ProjectInfoWriter {
    private String path;

    public ProjectInfoWriter(String path) {
        this.path = path;
    }

    public void writeFile(ProjectInfo projectInfo){
        try (FileOutputStream fos = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8)) {
            osw.write(projectInfo.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
