package Stock.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PieMapper implements RowMapper<PieDataModel> {

    @Override
    public PieDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {

        PieDataModel dataShow = new PieDataModel
        (   rs.getLong("ID"),
            rs.getString("COM_NAME"), 
            rs.getString("NET_INCOME"),
            rs.getFloat("TAX_FEE"),
            rs.getLong("PROFIT_NON_SALES"),
            rs.getTimestamp("CRT_TIME")
        );

        return dataShow;
    }
}
