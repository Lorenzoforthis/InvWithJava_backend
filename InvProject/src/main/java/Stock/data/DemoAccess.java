package Stock.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Stock.models.DemoMapper;
import Stock.models.DemoModel;

@Repository
public class DemoAccess implements DemoAccessInterface{

    // application.properties to get the detail on mysql connection
    
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DemoAccess(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }


    @Override
    public List<DemoModel> getData() {
       List<DemoModel> results = jdbcTemplate.query("SELECT * FROM data_db", new DemoMapper());
       return results;
    }

    
    @Override
    public DemoModel getById(long id) {
        List<DemoModel> results = jdbcTemplate.query("SELECT * FROM data_db WHERE ID =?", new DemoMapper(),id);

        if(!results.isEmpty()){
            return results.get(0);
        }else{ 
            return null;
        }            
    }

    @Override
    public List<DemoModel> searchData(String searchTerm) {
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
        
        List<DemoModel> results = jdbcTemplate.query("SELECT * FROM data_db WHERE COMNAME LIKE ?", new DemoMapper(),"%" + searchTerm + "%");
            return results;        
        } 


    @Override
    public long addOne(DemoModel newData) {
        long result = jdbcTemplate.update("INSERT INTO data_db(ORDERNO,COMNAME,PRICE,QUANTITY) VALUES (?,?,?,?)",
                                        newData.getOrderNo(),
                                        newData.getComName(),
                                        newData.getPrice(),
                                        newData.getQuantity()                       
                                        );
            return result;   
        }    

    @Override
    public DemoModel updateOne(long idToUpdate, DemoModel updateData) {
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
    public boolean deleteOne(long id) {
      int result = jdbcTemplate.update("DELETE FROM data_db WHERE ID =?", id);

      if(result > 0){
        return true;
      }else{
        return false;
      }
    }  

}
