package communication;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCommunicator<T> implements Communicator<T> {
    List<T> data = new ArrayList<>();

    @Override
    public List<T> getData() {
        return data;
    }

    @Override
    public void setData(T data) {
        this.data.add(data);
    }
}
