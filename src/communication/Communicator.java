package communication;

import java.util.List;

public interface Communicator<T> {
    List<T> getData();

    void setData(T data);
}
