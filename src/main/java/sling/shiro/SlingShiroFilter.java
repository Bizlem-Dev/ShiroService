package sling.shiro;



import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

import org.apache.shiro.web.servlet.IniShiroFilter;


@SuppressWarnings("deprecation")
@Component(immediate=true, metatype=false)
@Service(value=javax.servlet.Filter.class)
@Properties({
    @Property(name="service.description", value="Sling Shiro Filter"),
    @Property(name="service.vendor", value="The Apache Software Foundation"),
    @Property(name="filter.scope", value="request"),
    @Property(name="sling.filter.scope", value="request")
})
public class SlingShiroFilter extends IniShiroFilter   {


  protected String getHeaderName() {
        return "FILTER_COUNTER_SLING";
    }

}
