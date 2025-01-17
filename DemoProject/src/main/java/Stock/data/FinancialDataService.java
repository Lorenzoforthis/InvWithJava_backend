package Stock.data;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Stock.models.FinancialDataDTO;
import Stock.models.FinancialDataRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FinancialDataService {
    
    @Autowired
    private FinancialDataRepository repository;

    public void processFinancialData(List<FinancialDataDTO> dataList) {
        log.info("Starting to process {} financial records", dataList.size());
        repository.batchInsertFinancialData(dataList);
        log.info("Completed processing financial records");
    }

    public List<FinancialDataDTO> readFinancialDataFromJson(String filePath) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            List<FinancialDataDTO> data = mapper.readValue(
                new File(filePath), 
                new TypeReference<List<FinancialDataDTO>>() {}
            );
            log.info("Successfully read {} records from JSON file", data.size());
            return data;
        } catch (IOException e) {
            log.error("Error reading JSON file: {}", filePath, e);
            throw new RuntimeException("Failed to read financial data", e);
        }
    }

    public List<Map<String, Object>> getCompanyData(String companyCode) {
        return repository.findByCompanyCode(companyCode);
    }

    public List<Map<String, Object>> getIndustryData(String industry) {
        return repository.findByIndustry(industry);
    }
}
