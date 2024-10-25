package Stock.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Stock.models.PieDataModel;
import Stock.models.PieMapper;

@Repository
public class PieAccess implements PieAccessInterface {

     private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PieAccess(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    @Override
    public List<PieDataModel> getData() {
       List<PieDataModel> results = jdbcTemplate.query("SELECT * FROM taiwanmarket", new PieMapper());
       return results;
    }

    @Override
    public PieDataModel getById(long id) {
        try {                   
            // Query the database
            List<PieDataModel> results = jdbcTemplate.query("SELECT * FROM taiwanmarket WHERE ID = ?", 
                new PieMapper(), 
                id
            );
    
            // Return the first result or null if not found
            return results.isEmpty() ? null : results.get(0);
            
        } catch (Exception e) {
            // Log the exception more effectively (consider using a logging framework)
            System.err.println("Error retrieving PieDataModel by ID: " + e.getMessage());
            return null; // Return null in case of error
        }
    }


    @Override
    public List<PieDataModel> searchData(String searchTerm) {
           List<PieDataModel> results = jdbcTemplate.query("SELECT * FROM taiwanmarket WHERE COM_NAME LIKE ?", new PieMapper(),"%" + searchTerm + "%");
            return results;        
        }

    @Override
    public long addOne(PieDataModel newData) {
        try {        
            long result = jdbcTemplate.update("INSERT INTO taiwanmarket(COM_NAME,NET_INCOME,TAX_FEE,PROFIT_NON_SALES) VALUES (?,?,?,?)",
                        newData.getCom_Name(),
                        newData.getNet_Income(),
                        newData.getTax_Fee(),
                        newData.getProfit_non_Sales()
                        // newData.getCrt_Time()                
                        );
            return result;   
        } catch (Exception e) { System.err.println("Error adding PieDataModel in PieAccess " + e.getMessage());
            return -1;
        }
    }
    @Override
    public PieDataModel updateOne(long idToUpdate, PieDataModel updateData) {
        try {    
            int result = jdbcTemplate.update(
                "UPDATE taiwanmarket SET COM_NAME = ?, NET_INCOME = ?, TAX_FEE = ?, PROFIT_NON_SALES = ? WHERE ID = ?",
                updateData.getCom_Name(),
                updateData.getNet_Income(),
                updateData.getTax_Fee(),
                updateData.getProfit_non_Sales(), 
                // updateData.getCrt_Time(),     
                idToUpdate // Include the ID in the parameters 
            );

            if (result > 0) {
                return updateData; // Return the updated DataModel
            } else {
                addOne(updateData);
                return null;
                   
            }
        }catch (Exception e) {
            System.err.println("Error updating PieDataModel in PieAccess " + e.getMessage());
            return null;
        }
    }   
     
    @Override
    public boolean deleteOne(long id) {
        try {
            int result = jdbcTemplate.update("DELETE FROM taiwanmarket WHERE ID = ?", id);
            if(result > 0){
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error deleting record in data_db: " + e.getMessage());
            return false; // Return false in case of an error
        }
    }
    
}
