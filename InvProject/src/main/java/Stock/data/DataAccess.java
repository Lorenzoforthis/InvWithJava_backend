package Stock.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Stock.models.DataMapper;
import Stock.models.DataModel;

@Repository
public class DataAccess implements DataAccessInterface{

    // application.properties to get the detail on mysql connection
    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbcTemplate;

    @Override
    public DataModel getById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<DataModel> getData() {
       List<DataModel> results = jdbcTemplate.query("SELECT * FROM data_db", new DataMapper());
       return results;
    }

    @Override
    public List<DataModel> searchData(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchData'");
    }

    @Override
    public long addOne(DataModel IsNewAwareAuditingHandlerBeanDefinitionParser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOne'");
    }

    @Override
    public boolean delete(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public DataModel updateOne(long idToUpdate, DataModel updateData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

}
