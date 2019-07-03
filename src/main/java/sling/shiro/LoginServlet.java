package sling.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;

@Component(immediate = true, metatype = false)
@Service(value = javax.servlet.Servlet.class)
@Properties({
        @Property(name = "service.description", value = "Prefix Test Servlet Minus One"),
        @Property(name = "service.vendor", value = "The Apache Software Foundation"),
        @Property(name = "sling.servlet.paths", value = { "/login" }),
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.extensions", value = { "jsp" }) })
@SuppressWarnings("serial")
public class LoginServlet extends SlingAllMethodsServlet {

    @Reference
    SlingRepository repository;

    PrintWriter out;

    private ResourceBundle bundle;
    
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) {
        bundle=ResourceBundle.getBundle("server");
        try {
            String URL = "http://"+bundle.getString("cas.serverHost")+
                    ":"+bundle.getString("cas.serverPort")+
                    "/"+bundle.getString("cas.serverName")+
                    "/login?service="+bundle.getString("sling.serverSpec")+
                    "/shiro-cas";
            response.sendRedirect(URL);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}