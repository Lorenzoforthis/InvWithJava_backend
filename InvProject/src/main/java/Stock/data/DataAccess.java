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
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataAccess(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }


    @Override
    public List<DataModel> getData() {
       List<DataModel> results = jdbcTemplate.query("SELECT * FROM data_db", new DataMapper());
       return results;
    }

    @Override
    public List<DataModel> searchData(String searchTerm) {
        // the following are the code for FaketestData 
        // List<DataModel> foundItems = new ArrayList<>(); 
        // for(int i=0; i< results.size();i++ ){
        //     if(results.get(i).getComName().toLowerCase().contains(searchTerm)){
        //         foundItems.add(results.get(i));
        //     }
        // }
        // return foundItems;
        // List<DataModel> foundItems = dataSource
        //     .stream()
        //     .filter(dataSource -> dataSource.getComName().toLowerCase()).contains(searchTerm.toLowerCase())
        //     .collect(Collectors.toList());
        //     return foundItems;
        
        return jdbcTemplate.query("SELECT * FROM data_db WHERE COMNAME LIKE ?", new DataMapper(),"%" + searchTerm + "%");
        
        } 

    @Override
    public DataModel getById(long id) {
        List<DataModel> results = jdbcTemplate.query("SELECT * FROM data_db WHERE ID =?", new DataMapper(),id);

        if(!results.isEmpty()){
            return results.get(0);
        }else{ 
            return null;
        }
            
    }

    @Override
    public boolean deleteOne(long id) {
      int result = jdbcTemplate.update("DELETE FROM data_db WHERE ID =?", id);

      if(result > 0){
        return true;
      }else{
        return false;
      }
    }

   

    @Override
    public DataModel updateOne(long idToUpdate, DataModel updateData) {
        int result = jdbcTemplate.update(
            "UPDATE data_db SET ORDERNO = ?, COMNAME = ?, PRICE = ?, QUANTITY = ? WHERE ID = ?",
            updateData.getOrderNo(),
            updateData.getComName(),
            updateData.getPrice(),
            updateData.getQuantity(),
            idToUpdate // Include the ID in the parameters
        );

        if (result > 0) {
            return updateData; // Return the updated DataModel
        } else {
            return null; // Return null if the update was not successful
        }
    }



    @Override
    public long addOne(DataModel newData) {
        long result = jdbcTemplate.update("INSERT INTO data_db(ORDERNO,COMNAME,PRICE,QUANTITY) VALUES (?,?,?,?)",
                                        newData.getOrderNo(),
                                        newData.getComName(),
                                        newData.getPrice(),
                                        newData.getQuantity()                       
                                        );
            return result;   
        }

}
