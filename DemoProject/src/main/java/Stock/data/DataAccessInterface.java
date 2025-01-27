package Stock.data;

import java.util.List;

import Stock.models.DataModel;

public interface  DataAccessInterface {

    public DataModel getById(long id);
    public List<DataModel> getData();
    public List<DataModel> searchData(String searchTerm);
    public long addOne(DataModel newData);
    public boolean deleteOne(long id);
    public DataModel updateOne(long idToUpdate, DataModel updateData);
}
