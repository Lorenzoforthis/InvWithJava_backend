package Stock.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Stock.data.DataAccessInterface;
import Stock.models.DataModel;

@Component
public class DataBusinessService implements DataBusinessServiceInterface {

    @Autowired
    DataAccessInterface dataDAO;

    @Override
    public void test() {
       System.out.println("DataBusiness is working");
    }

    @Override
    public List<DataModel> getData() {
        List<DataModel> dataShow = new ArrayList<>();
        return dataShow;
    }

}
