package report.mail.sender;

import constants.Constants;
import exceptions.ReportNotFoundException;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.io.FileNotFoundException;

@Mojo(name = "mailSender")
public class MailSenderMojo extends AbstractMojo {

    @Parameter(property = "mailSender.username", defaultValue = "")
    private String username;

    @Parameter(property = "mailSender.password")
    private String password;

    @Parameter(property = "mailSender.theme")
    private String theme;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        MailSender postman = new MailSender();
        try {
            postman.sendMail(username, password, theme);
        } catch (Exception e) {
            getLog().info(Constants.REPORT_CONDITION);
        }




    }
}
