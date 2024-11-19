package Stock.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Stock.models.EpsRepository;

@RestController
@RequestMapping("/api/financials")
@CrossOrigin(origins = "*")  // Configure this based on your security requirements
public class EpsController {

    @Autowired
    private EpsRepository epsRepository;

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAllFinancials(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer pageSize
    ) {
        try {
            if (page != null && pageSize != null) {
                List<Map<String, Object>> paginatedData = epsRepository.findAllWithPagination(page, pageSize);
                return ResponseEntity.ok(paginatedData);
            } else {
                List<Map<String, Object>> allData = epsRepository.findAll();
                return ResponseEntity.ok(allData);
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/paginated")
    public ResponseEntity<Map<String, Object>> getPaginatedFinancials(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "50") int pageSize
    ) {
        try {
            List<Map<String, Object>> data = epsRepository.findAllWithPagination(page, pageSize);
            int totalRecords = epsRepository.getTotalCount();
            int totalPages = (int) Math.ceil((double) totalRecords / pageSize);

            Map<String, Object> response = new HashMap<>();
            response.put("data", data);
            response.put("currentPage", page);
            response.put("pageSize", pageSize);
            response.put("totalRecords", totalRecords);
            response.put("totalPages", totalPages);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/company/{companyCode}")
    public ResponseEntity<List<Map<String, Object>>> getByCompanyCode(
            @PathVariable String companyCode
    ) {
        try {
            List<Map<String, Object>> data = epsRepository.findByCompanyCode(companyCode);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/industry/{industry}")
    public ResponseEntity<List<Map<String, Object>>> getByIndustry(
            @PathVariable String industry
    ) {
        try {
            List<Map<String, Object>> data = epsRepository.findByIndustry(industry);
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Map<String, Object>> getTotalRecords() {
        try {
            int totalRecords = epsRepository.getTotalCount();
            Map<String, Object> response = new HashMap<>();
            response.put("totalRecords", totalRecords);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}