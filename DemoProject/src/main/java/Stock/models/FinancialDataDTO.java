package Stock.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinancialDataDTO {
    @JsonProperty("出表日期")
    private String reportDate;

    @JsonProperty("年度")
    private String year;

    @JsonProperty("季別")
    private String quarter;

    @JsonProperty("公司代號")
    private String companyCode;

    @JsonProperty("公司名稱")
    private String companyName;

    @JsonProperty("產業別")
    private String industry;

    @JsonProperty("基本每股盈餘(元)")
    private String eps;

    @JsonProperty("普通股每股面額")
    private String parValue;

    @JsonProperty("營業收入")
    private String operatingRevenue;

    @JsonProperty("營業利益")
    private String operatingProfit;

    @JsonProperty("營業外收入及支出")
    private String nonOperating;

    @JsonProperty("稅後淨利")
    private String netIncome;
}
