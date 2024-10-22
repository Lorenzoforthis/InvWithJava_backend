package Stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import Stock.services.DataBusinessService;
import Stock.services.DataBusinessServiceInterface;
import Stock.services.PieBusinessService;
import Stock.services.PieBusinessServiceInterface;

@Configuration
@ComponentScan
public class BeanConfig {

    @Bean(name="DataBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public DataBusinessServiceInterface getDataBusiness(){
        return new DataBusinessService();
    }

    @Bean(name="PieBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public PieBusinessServiceInterface getPieDataBusiness(){
        return new PieBusinessService();
    }
}
