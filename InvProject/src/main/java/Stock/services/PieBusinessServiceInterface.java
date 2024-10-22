package Stock.services;

import java.util.List;

import Stock.models.PieDataModel;

public interface PieBusinessServiceInterface {
    
    public void init();
    
    public void destroy();

    public List<PieDataModel> getData();
}
