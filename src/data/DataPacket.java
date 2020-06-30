package data;

import java.util.HashMap;
import java.util.Map;

public abstract class DataPacket<E> {
    protected Map<Enum, E> data;

    public DataPacket() {
        this.data = new HashMap<>();
    }

    public void addData(Enum property, E data) {
        this.data.put(property, data);
    }

    public abstract void getDataEntries(Enum key);
}
