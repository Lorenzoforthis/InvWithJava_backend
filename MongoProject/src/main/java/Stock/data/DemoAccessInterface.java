package Stock.data;

import java.util.List;

import Stock.models.DemoModel;

public interface  DemoAccessInterface {

    public DemoModel getById(String id);
    public List<DemoModel> getData();
    public List<DemoModel> searchData(String searchTerm);
    public String addOne(DemoModel newData);
    public boolean deleteOne(String id);
    public DemoModel updateOne(String idToUpdate, DemoModel updateData);
}
