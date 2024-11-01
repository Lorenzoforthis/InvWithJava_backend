package Stock.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


public class DemoMapper implements RowMapper<DemoModel> {

    @Override
    public DemoModel mapRow(ResultSet rs, int rowNum) throws SQLException {

       DemoModel dataShow = new DemoModel
        (   rs.getInt("ID"),
            rs.getString("ORDERNO"), 
            rs.getString("COMNAME"),
            rs.getFloat("PRICE"),
            rs.getInt("QUANTITY")
        );

        return dataShow;
    }

 

}
