package org.jenkinsci.plugins.expose_build_xml;
import hudson.Launcher;
import hudson.Extension;
import hudson.util.FormValidation;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;
import hudson.model.AbstractProject;
import hudson.tasks.Builder;
import hudson.tasks.BuildStepDescriptor;
import net.sf.json.JSONObject;
import org.kohsuke.stapler.DataBoundConstructor;
import org.kohsuke.stapler.StaplerRequest;
import org.kohsuke.stapler.QueryParameter;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by jbull on 12/12/2014.
 */
public class PostBuildXmlExposer extends Builder{

    private final String xmlSavePath;
    private final boolean outputJobXML;

    @DataBoundConstructor
    public PostBuildXmlExposer(boolean outputJobXML, String xmlSavePath) {
        this.outputJobXML = outputJobXML;
        this.xmlSavePath = xmlSavePath;
    }

    public String getXmlSavePath() {
        return this.xmlSavePath;
    }

    public boolean isOutputJobXML() {
        return this.outputJobXML;
    }

    @Override
    public boolean perform(AbstractBuild build, Launcher launcher, BuildListener listener) {
        // This is where you 'build' the project.
        // Since this is a dummy, we just say 'hello world' and call that a build.

        // This also shows how you can consult the global configuration of the builder
        if (this.isOutputJobXML()) {
            listener.getLogger().println("We will post the build XML!");
        }
        else {
            listener.getLogger().println("We wont post the build XML!");
        }
        return true;
    }


}
