package console.report.writer;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import java.io.File;

import static constants.Constants.REPORT_PATH;

@Mojo(name = "consoleWriter")
public class ConsoleWriterMojo extends AbstractMojo {
    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        String path = new File(REPORT_PATH).getAbsolutePath();
        ProjectInfoReader projectInfoReader = new ProjectInfoReader(path);
        String info = projectInfoReader.readFile();
        getLog().info(info);
    }
}
