package communication;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractMapCommunicator<K, V> implements MapCommunicator<K, V>{
    Map<K, V> data = new HashMap<>();

    @Override
    public V getEntry(K key) {
        return data.get(key);
    }

    @Override
    public void setData(K key, V value) {
        data.put(key, value);
    }
}
