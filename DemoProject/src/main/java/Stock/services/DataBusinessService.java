package Stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Stock.data.DataAccessInterface;
import Stock.models.DataModel;

@Service
public class DataBusinessService implements DataBusinessServiceInterface {

    // Linked with PieAccess @Repository
    @Autowired
    DataAccessInterface dataDAO;

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
    public List<DataModel> getData() {
        return dataDAO.getData();
    }

    @Override
    public DataModel getById(long id) {
        return dataDAO.getById(id);
    }

    @Override
    public List<DataModel> searchData(String searchTerm) {
        return dataDAO.searchData(searchTerm);
    }

    @Override
    public long addOne(DataModel model) {
        return dataDAO.addOne(model);
    }

    @Override
    public boolean deleteOne(long id) {
        return dataDAO.deleteOne(id);
    }

    @Override
    public DataModel updateOne(long idToUpdate, DataModel updateData) {
        return dataDAO.updateOne(idToUpdate, updateData);
        //throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }


}
