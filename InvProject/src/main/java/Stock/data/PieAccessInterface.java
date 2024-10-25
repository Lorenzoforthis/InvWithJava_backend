package Stock.data;

import java.util.List;

import Stock.models.PieDataModel;


public interface PieAccessInterface {
    public List<PieDataModel> getData();
    public PieDataModel getById(long id);
    public List<PieDataModel> searchData(String searchTerm);
    public long addOne(PieDataModel newData);   
    public PieDataModel updateOne(long idToUpdate, PieDataModel updateData);
    public boolean deleteOne(long id);

}
