package Stock.data;

import java.util.ArrayList;
import java.util.List;

import Stock.models.DemoModel;

// @Repository
public class DemoFakeTest implements DemoAccessInterface {

    List<DemoModel> dataShow = new ArrayList<>();

    public DemoFakeTest() {
       dataShow.add(new DemoModel(0, "001", "BMW",100.4f, 2));
       dataShow.add(new DemoModel(1, "002", "BENZ",220.7f, 4));
       dataShow.add(new DemoModel(2, "003", "AUDI",220.4f, 2));
       dataShow.add(new DemoModel(3, "004", "TOyota",133.2f, 3));
       dataShow.add(new DemoModel(4, "00b", "hondi",122.4f, 21));

    }

    @Override
    public DemoModel getById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

    @Override
    public List<DemoModel> getData() {
       return dataShow;
    }

    @Override
    public List<DemoModel> searchData(String searchTerm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchData'");
    }

    @Override
    public long addOne(DemoModel newData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addOne'");
    }

    @Override
    public boolean deleteOne(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public DemoModel updateOne(long idToUpdate, DemoModel updateData) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateOne'");
    }

}
