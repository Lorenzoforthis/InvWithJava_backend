package Stock.services;

import java.util.List;

import Stock.models.DataModel;

public interface DataBusinessServiceInterface {
    public void test();    

    public void init();
    public void destroy();

    public DataModel getById(long id);
    public List<DataModel> getData();
    public List<DataModel> searchData(String searchTerm);
    public long addOne(DataModel model);
    public boolean deleteOne(long id);
    public DataModel updateOne(long idToUpdate, DataModel updateData);

}
