package Stock.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class PieDataModel {

    private long id                =0L; 
    private String com_Name        ="";
    private String net_Income      ="";
    private float tax_Fee          =0.0f;
    private float profit_non_Sales =0.0f;
    private LocalDateTime crt_Time = LocalDateTime.now();   

    public PieDataModel(long id, String com_Name, String net_Income, float tax_Fee, float profit_non_Sales,
            Timestamp timestamp) {
        this.id = id;
        this.com_Name = com_Name;
        this.net_Income = net_Income;
        this.tax_Fee = tax_Fee;
        this.profit_non_Sales = profit_non_Sales;
        this.crt_Time = timestamp.toLocalDateTime();
    }


    @Override
    public String toString() {
        return "PieDataModel [id=" + id + ", com_Name=" + com_Name + ", net_Income=" + net_Income + ", tax_Fee="
                + tax_Fee + ", profit_non_Sales=" + profit_non_Sales + ", crt_Time=" + crt_Time + "]";
    }


    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getCom_Name() {
        return com_Name;
    }
    public void setCom_Name(String com_Name) {
        this.com_Name = com_Name;
    }
    public String getNet_Income() {
        return net_Income;
    }
    public void setNet_Income(String net_Income) {
        this.net_Income = net_Income;
    }
    public float getTax_Fee() {
        return tax_Fee;
    }
    public void setTax_Fee(float tax_Fee) {
        this.tax_Fee = tax_Fee;
    }
    public float getProfit_non_Sales() {
        return profit_non_Sales;
    }
    public void setProfit_non_Sales(float profit_non_Sales) {
        this.profit_non_Sales = profit_non_Sales;
    }
    public LocalDateTime getCrt_Time() {
        return crt_Time;
    }
    public void setCrt_Time(LocalDateTime crt_Time) {
        this.crt_Time = crt_Time;
    }
}
