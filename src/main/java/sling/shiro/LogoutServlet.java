package sling.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;

import com.loginService.dwr.LoginService;


@Component(immediate = true, metatype = false)
@Service(value = javax.servlet.Servlet.class)
@Properties({
        @Property(name = "service.description", value = "Prefix Test Servlet Minus One"),
        @Property(name = "service.vendor", value = "The Apache Software Foundation"),
        @Property(name = "sling.servlet.paths", value = { "/logout" }),
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.extensions", value = { "jsp"}) 
        })
@SuppressWarnings("serial")
public class LogoutServlet extends SlingAllMethodsServlet {

    @Reference
    SlingRepository repository;

    PrintWriter out;
    
    private ResourceBundle bundle;
    
    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) {
        bundle=ResourceBundle.getBundle("server");
        try {
            LoginService login_service = new LoginService();
            Subject subject = SecurityUtils.getSubject();
            login_service.logout(request.getRemoteUser().replace("@","_"));
            subject.logout();
            response.sendRedirect("http://"+bundle.getString("cas.serverHost")+
                    ":"+bundle.getString("cas.serverPort")+
                    "/"+bundle.getString("cas.serverName")+"/logout");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}