package Stock.services;

import java.util.List;

import Stock.models.PieDataModel;

public interface PieBusinessServiceInterface {
    
    public void init();
    
    public void destroy();

    public List<PieDataModel> getData();
    public PieDataModel getById(long id);   
    public List<PieDataModel> searchData(String searchTerm);
    public long addOne(PieDataModel model);
    public PieDataModel updateOne(long idToUpdate, PieDataModel updateData);
    public boolean deleteOne(long id);
   

}
