package data.bus;

import data.DataPacket;
import data.GuiDebugDataPacket;

public class GuiDebugBus implements Bus {

    @Override
    public void publishData(DataPacket d) {
        throw new IllegalArgumentException("Illegal type on bus: " + d.getClass());
    }

    public void publishData(GuiDebugDataPacket d) {

    }
}
