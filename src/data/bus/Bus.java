package data.bus;

import data.DataPacket;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;

public abstract class Bus <DataType extends DataPacket> extends Observable {
    public void publishData(DataType d) {

    };

    @Override
    public void addListener(InvalidationListener invalidationListener) {

    }

    @Override
    public void removeListener(InvalidationListener invalidationListener) {

    }
}
