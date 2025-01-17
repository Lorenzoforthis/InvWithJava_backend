package Stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import Stock.data.DemoAccessInterface;
import Stock.models.DemoModel;

@Repository
public class DemoBusinessService implements DemoBusinessServiceInterface {

    // Linked with PieAccess @Repository
    @Autowired
    DemoAccessInterface dataDAO;

    @Override
    public void test() {
       System.out.println("DataBusiness is working");
    }
   
    @Override
    public void init() {
       System.out.println("DataBusinessService method 'init' is working");
    }

    @Override
    public void destroy() {
        System.out.println("DataBusinessService method 'destroy' is working");
    }

    @Override
    public List<DemoModel> getData() {
        return dataDAO.getData();
    }

    @Override
    public DemoModel getById(String id) {
        return dataDAO.getById(id);
    }

    @Override
    public List<DemoModel> searchData(String searchTerm) {
        return dataDAO.searchData(searchTerm);
    }

    @Override
    public String addOne(DemoModel model) {
        return dataDAO.addOne(model);
    }

    @Override
    public boolean deleteOne(String  id) {
        return dataDAO.deleteOne(id);
    }

    @Override
    public DemoModel updateOne(String  idToUpdate, DemoModel updateData) {
        return dataDAO.updateOne(idToUpdate, updateData);
        //throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }


}
