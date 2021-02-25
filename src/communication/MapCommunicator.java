package communication;

import java.util.Map;

public interface MapCommunicator<K, V> {
    V getEntry(K key);

    void setData(K key, V value);
}
