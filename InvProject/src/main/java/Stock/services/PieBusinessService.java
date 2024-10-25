package Stock.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Stock.data.PieAccessInterface;
import Stock.models.PieDataModel;

@Repository
public class PieBusinessService implements PieBusinessServiceInterface {

      // Linked with DataAccessInterface @Repository
    @Autowired
    PieAccessInterface stockDAO;

   
    @Override
    public void init() {
       System.out.println("ChartBusiness method 'init' is working");
    }

    @Override
    public void destroy() {
        System.out.println("ChartBusiness method 'destroy' is working");
    }

    @Override
    public List<PieDataModel> getData() {
        return stockDAO.getData();
    }

    @Override
    public PieDataModel getById(long id) {
        return stockDAO.getById(id);
    }

    @Override
    public List<PieDataModel> searchData(String searchTerm) {
        return stockDAO.searchData(searchTerm);
    }

    @Override
    public long addOne(PieDataModel model) {
        return stockDAO.addOne(model);
    }

    @Override
    public PieDataModel updateOne(long idToUpdate, PieDataModel updateData) {
       return stockDAO.updateOne(idToUpdate,updateData);
    }

    @Override
    public boolean deleteOne(long id) {
       return stockDAO.deleteOne(id);
    }
}
