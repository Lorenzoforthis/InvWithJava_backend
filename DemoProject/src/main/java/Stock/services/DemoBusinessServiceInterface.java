package Stock.services;

import java.util.List;

import Stock.models.DemoModel;

public interface DemoBusinessServiceInterface {
    public void test();    

    public void init();
    public void destroy();

    public DemoModel getById(long id);
    public List<DemoModel> getData();
    public List<DemoModel> searchData(String searchTerm);
    public long addOne(DemoModel model);
    public boolean deleteOne(long id);
    public DemoModel updateOne(long idToUpdate, DemoModel updateData);

}
