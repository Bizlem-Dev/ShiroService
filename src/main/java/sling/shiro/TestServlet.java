package sling.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;
/*
import com.loginService.dwr.LoginService;*/


@Component(immediate = true, metatype = false)
@Service(value = javax.servlet.Servlet.class)
@Properties({
        @Property(name = "service.description", value = "Prefix Test Servlet Minus One"),
        @Property(name = "service.vendor", value = "The Apache Software Foundation"),
        @Property(name = "sling.servlet.paths", value = { "/servlet/pop/shiro" }),
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.extensions", value = { "run", "save", "call",
                "hiroo" }) })
@SuppressWarnings("serial")
public class TestServlet extends SlingAllMethodsServlet {

    @Reference
    SlingRepository repository;

    PrintWriter out;

    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) {
        if(request.getRequestPathInfo().getExtension().equals("call")){
         //   LoginService login_service=new LoginService();
         //   login_service.login(request.getParameter("call"));
        }

    }

    protected void doPost(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {
        if (request.getRequestPathInfo().getExtension().equals("save")) {
            try {
        /*        Factory<SecurityManager> factory = new
                         IniSecurityManagerFactory("classpath:shiro.ini");
                         SecurityManager securityManager = factory.getInstance();
                         
                         SecurityUtils.setSecurityManager(securityManager);*/
                UsernamePasswordToken token = new UsernamePasswordToken(
                        request.getParameter("username"),
                        request.getParameter("password"));

                Subject subject = SecurityUtils.getSubject();
                subject.login(token);

                /*out.print("<br>shiro subject==<br>" + subject);
                out.print("<br>shiro Principals<br>" + subject.getPrincipals());*/
                if (subject.isAuthenticated()) {

                    response.getOutputStream().print(
                            subject.getPrincipals()
                                    + " is Authenticated successfully.");
                    // response.getOutputStream().println(subject.g+
                    // " is Authenticated successfully.");
                } else {

                    response.getOutputStream().println(
                            "You are not Authenticated .");
                }

            } catch (Exception e) {
                response.getOutputStream().println(e.getMessage());
                e.printStackTrace();
            }
        }
    }

}