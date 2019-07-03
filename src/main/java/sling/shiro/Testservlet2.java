package sling.shiro;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;

import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.jcr.api.SlingRepository;

@Component(immediate = true, metatype = false)
@Service(value = javax.servlet.Servlet.class)
@Properties({
        @Property(name = "service.description", value = "Prefix Test Servlet Minus One"),
        @Property(name = "service.vendor", value = "The Apache Software Foundation"),
        @Property(name = "sling.servlet.paths", value = { "/servlet/pop/shirop" }),
        @Property(name = "sling.servlet.resourceTypes", value = "sling/servlet/default"),
        @Property(name = "sling.servlet.extensions", value = { "run", "logout","test" }) })
@SuppressWarnings("serial")
public class Testservlet2 extends SlingAllMethodsServlet {

    @Reference
    SlingRepository repository;

    PrintWriter out;

    protected void doGet(SlingHttpServletRequest request,
            SlingHttpServletResponse response) {
        try {
            Subject subject = SecurityUtils.getSubject();
            response.setContentType("text/html");
            out = response.getWriter();
            if (request.getRequestPathInfo().getExtension().equals("run")) {

                out.println("Welcome to apache sling <br>");
                out.println("1");

              
                if (subject.isAuthenticated())
                    out.println("6");
                out.println(subject.isAuthenticated());
                out.println("<br>Remote HOst==" + request.getRemoteHost());
                out.println("<br>shiro subject==" + subject);
                out.println("<br>shiro Principals==" + subject.getPrincipals());

                if (subject.hasRole("user")) {
                    out.println("<br/>"+subject.getPrincipals() + " contains role:  user");

                }else if (subject.hasRole("admin")) {
                    out.println("<br/>"+subject.getPrincipals() + " contains role:  admin");

                }
            } else if (request.getRequestPathInfo().getExtension()
                    .equals("logout")) {
                subject.logout();
                out.print("logout");
            } else if(request.getRequestPathInfo().getExtension()
                    .equals("test")){
                Subject subject1 = SecurityUtils.getSubject();
                Session session = subject1.getSession();
                SavedRequest savedRequest = (SavedRequest) session.getAttribute("shiroSavedRequest");
                System.out.println(session.getAttribute("shiroSavedRequest"));
                response.getOutputStream().print(savedRequest.getRequestUrl()+"");
                response.getOutputStream().print(savedRequest.getRequestURI()+"");

            }
        } catch (Exception e) {
           
            try {
               // response.getOutputStream().print(e.getMessage());
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            e.printStackTrace();

        }

    }

    protected void doPost(SlingHttpServletRequest request,
            SlingHttpServletResponse response) throws ServletException,
            IOException {

        response.setContentType("text/html");

        out = response.getWriter();

        out.println("hello..post..");

    }

}