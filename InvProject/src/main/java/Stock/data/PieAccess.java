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

}
