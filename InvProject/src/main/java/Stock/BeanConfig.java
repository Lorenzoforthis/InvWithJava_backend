package Stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import Stock.services.DemoBusinessService;
import Stock.services.DemoBusinessServiceInterface;
import Stock.services.PieBusinessService;
import Stock.services.PieBusinessServiceInterface;




@Configuration
@ComponentScan
public class BeanConfig {

    @Bean(name="DataBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public DemoBusinessServiceInterface getDataBusiness(){
        return new DemoBusinessService();
    }

    @Bean(name="PieBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public PieBusinessServiceInterface getPieDataBusiness(){
        return new PieBusinessService();
    }

   

}
