package Stock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Stock.services.DataBusinessService;
import Stock.services.DataBusinessServiceInterface;

@Configuration
public class BeanConfig {

    @Bean(name="DataBusinessService")
    Public DataBusinessServiceInterface getDataBusiness(){
        return new DataBusinessService();
    }
}
