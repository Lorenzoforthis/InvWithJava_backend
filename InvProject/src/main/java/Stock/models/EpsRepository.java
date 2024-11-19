package Stock.models;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class EpsRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_SQL = """
        INSERT INTO quarterly_financials_typed (
            report_date, year, quarter, company_code, company_name, 
            industry, eps, par_value, operating_revenue, 
            operating_profit, non_operating, net_income
        ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
        ON DUPLICATE KEY UPDATE
            year = VALUES(year),
            quarter = VALUES(quarter),
            company_name = VALUES(company_name),
            industry = VALUES(industry),
            eps = VALUES(eps),
            par_value = VALUES(par_value),
            operating_revenue = VALUES(operating_revenue),
            operating_profit = VALUES(operating_profit),
            non_operating = VALUES(non_operating),
            net_income = VALUES(net_income)
    """;

    private static final int BATCH_SIZE = 500;

    public void batchInsertFinancialData(List<EpsModel> dataList) {
        try {
            // Split the list into smaller batches
            for (int i = 0; i < dataList.size(); i += BATCH_SIZE) {
                int endIndex = Math.min(i + BATCH_SIZE, dataList.size());
                List<EpsModel> batch = dataList.subList(i, endIndex);
                
                processBatch(batch);
                log.info("Processed batch {} to {} of {}", i, endIndex, dataList.size());
            }
        } catch (Exception e) {
            log.error("Error batch inserting financial data", e);
            throw new RuntimeException("Failed to insert financial data", e);
        }
    }

    private void processBatch(List<EpsModel> batch) {
        jdbcTemplate.batchUpdate(INSERT_SQL, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                EpsModel data = batch.get(i);
                ps.setString(1, data.getReportDate());
                ps.setString(2, data.getYear());
                ps.setString(3, data.getQuarter());
                ps.setString(4, data.getCompanyCode());
                ps.setString(5, data.getCompanyName());
                ps.setString(6, data.getIndustry());
                setDecimalValue(ps, 7, data.getEps());
                ps.setString(8, data.getParValue());
                setDecimalValue(ps, 9, data.getOperatingRevenue());
                setDecimalValue(ps, 10, data.getOperatingProfit());
                setDecimalValue(ps, 11, data.getNonOperating());
                setDecimalValue(ps, 12, data.getNetIncome());
            }

            @Override
            public int getBatchSize() {
                return batch.size();
            }
        });
    }

    private void setDecimalValue(PreparedStatement ps, int index, String value) throws SQLException {
        if (value == null || value.trim().isEmpty() || value.equals("--")) {
            ps.setNull(index, Types.DECIMAL);
            return;
        }
        
        try {
            String cleanValue = value.replace(",", "");
            BigDecimal decimalValue = new BigDecimal(cleanValue);
            ps.setBigDecimal(index, decimalValue);
        } catch (NumberFormatException e) {
            log.error("Error converting value: {} to decimal", value, e);
            ps.setNull(index, Types.DECIMAL);
        }
    }

    // Query methods
    public List<Map<String, Object>> findByCompanyCode(String companyCode) {
        String sql = "SELECT * FROM quarterly_financials_typed WHERE company_code = ?";
        return jdbcTemplate.queryForList(sql, companyCode);
    }

    public List<Map<String, Object>> findByIndustry(String industry) {
        String sql = "SELECT * FROM quarterly_financials_typed WHERE industry = ?";
        return jdbcTemplate.queryForList(sql, industry);
    }


     // New method to retrieve all data
     public List<Map<String, Object>> findAll() {
        String sql = "SELECT * FROM quarterly_financials_typed";
        return jdbcTemplate.queryForList(sql);
    }

    // New method to retrieve all data with pagination
    public List<Map<String, Object>> findAllWithPagination(int page, int pageSize) {
        String sql = "SELECT * FROM quarterly_financials_typed LIMIT ? OFFSET ?";
        int offset = (page - 1) * pageSize;
        return jdbcTemplate.queryForList(sql, pageSize, offset);
    }

    // New method to count total records
    public int getTotalCount() {
        String sql = "SELECT COUNT(*) FROM quarterly_financials_typed";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
