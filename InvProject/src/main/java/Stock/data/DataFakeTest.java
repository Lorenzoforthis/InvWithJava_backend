package Stock.data;

import java.util.ArrayList;
import java.util.List;

import Stock.models.DataModel;

// @Repository
public class DataFakeTest implements DataAccessInterface {

    List<DataModel> dataShow = new ArrayList<>();

    public DataFakeTest() {
       dataShow.add(new DataModel(0, "001", "BMW",100.4f, 2));
       dataShow.add(new DataModel(1, "002", "BENZ",220.7f, 4));
       dataShow.add(new DataModel(2, "003", "AUDI",220.4f, 2));
       dataShow.add(new DataModel(3, "004", "TOyota",133.2f, 3));
       dataShow.add(new DataModel(4, "00b", "hondi",122.4f, 21));

    }

    @Override
    public DataModel getById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<DataModel> getData() {
       return dataShow;
    }

    @Override
    public List<DataModel> searchData(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchData'");
    }

    @Override
    public long addOne(DataModel newData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOne'");
    }

    @Override
    public boolean deleteOne(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public DataModel updateOne(long idToUpdate, DataModel updateData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

}
