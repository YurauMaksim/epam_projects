package project.info;

import info.ProjectInfo;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.File;

import static constants.Constants.REPORT_PATH;

@Mojo(name = "projectInfo")
public class ProjectInfoMojo extends AbstractMojo {

    @Parameter(property = "projectInfo.groupId")
    private String groupId;

    @Parameter(property = "projectInfo.artifactId")
    private String artifactId;

    @Parameter(property = "projectInfo.version")
    private String version;

    @Parameter(property = "projectInfo.timeStamp")
    private String timeStamp;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
                ProjectInfo projectInfo = new ProjectInfo(groupId, artifactId, version, timeStamp);
                String path = new File(REPORT_PATH).getAbsolutePath();
                ProjectInfoWriter projectInfoWriter = new ProjectInfoWriter(path);
                projectInfoWriter.writeFile(projectInfo);


    }
}
