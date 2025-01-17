package Stock.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import Stock.models.DemoModel;

public interface DemoAccess extends MongoRepository<DemoModel,String>  {

    @Query("{'comName':{'$regex':'?0','$options':'i'}}")
    List<DemoModel> findByComName(String searchTerm);
}
