package Stock.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DataMapper implements RowMapper<DataModel> {

    @Override
    public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {

       DataModel dataShow = new DataModel
        (   rs.getInt("ID"),
            rs.getString("ORDERNO"), 
            rs.getString("COMNAME"),
            rs.getFloat("PRICE"),
            rs.getInt("QUANTITY")
        );

        return dataShow;
    }

 

}
