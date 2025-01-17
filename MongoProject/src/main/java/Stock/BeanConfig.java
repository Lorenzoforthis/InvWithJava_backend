package Stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import Stock.data.DemoAccess;
import Stock.data.DemoAccessInterface;
import Stock.services.DemoBusinessService;
import Stock.services.DemoBusinessServiceInterface;


@Configuration
@ComponentScan
public class BeanConfig {


    @Bean(name="DemoBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public DemoBusinessServiceInterface getServiceBusiness(){
        return new DemoBusinessService();
    }

    @Bean(name="dataDAO")
    @RequestScope
    public DemoAccessInterface getDataBusiness(){
        return new DemoAccess();
    }

   

}
