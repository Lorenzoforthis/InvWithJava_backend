package Stock.data;

import java.util.List;

import Stock.models.DemoModel;

public interface  DemoAccessInterface {

    public DemoModel getById(long id);
    public List<DemoModel> getData();
    public List<DemoModel> searchData(String searchTerm);
    public long addOne(DemoModel newData);
    public boolean deleteOne(long id);
    public DemoModel updateOne(long idToUpdate, DemoModel updateData);
}
