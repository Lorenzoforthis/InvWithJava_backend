package Stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;

import Stock.services.DataBusinessService;
import Stock.services.DataBusinessServiceInterface;

@Configuration
public class BeanConfig {

    @Bean(name="DataBusinessService", initMethod="init" ,destroyMethod="destroy")
    @RequestScope
    public DataBusinessServiceInterface getDataBusiness(){
        return new DataBusinessService();
    }
}
