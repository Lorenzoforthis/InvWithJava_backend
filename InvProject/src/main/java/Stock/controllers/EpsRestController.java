package Stock.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Stock.data.EpsDataService;
import Stock.models.EpsModel;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j

// this works to call a file with absolute path but fail to call json file with related path  /data/eps.json
public class EpsRestController {
 
    @Autowired
    private EpsDataService financialDataService;
    
    
    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestParam("file") String filePath) {
        try {
            log.info("Starting import from file: {}", filePath);
            List<EpsModel> dataList = financialDataService.readFinancialDataFromJson(filePath);
            financialDataService.processFinancialData(dataList);
            return ResponseEntity.ok("Successfully imported " + dataList.size() + " records");
        } catch (Exception e) {
            log.error("Error during import", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error importing data: " + e.getMessage());
        }
    }




    
    @GetMapping("/company/{companyCode}")
    public ResponseEntity<?> getCompanyData(@PathVariable String companyCode) {
        try {
            List<Map<String, Object>> data = financialDataService.getCompanyData(companyCode);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("Error retrieving company data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error retrieving data: " + e.getMessage());
        }
    }

    @GetMapping("/industry/{industry}")
    public ResponseEntity<?> getIndustryData(@PathVariable String industry) {
        try {
            List<Map<String, Object>> data = financialDataService.getIndustryData(industry);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            log.error("Error retrieving industry data", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error retrieving data: " + e.getMessage());
        }
    }
}


