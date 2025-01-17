package Stock.services;

import java.util.List;

import Stock.models.DemoModel;

public interface DemoBusinessServiceInterface {
    public void test();    

    public void init();
    public void destroy();

    public DemoModel getById(String id);
    public List<DemoModel> getData();
    public List<DemoModel> searchData(String searchTerm);
    public String addOne(DemoModel model);
    public boolean deleteOne(String id);
    public DemoModel updateOne(String idToUpdate, DemoModel updateData);

}
