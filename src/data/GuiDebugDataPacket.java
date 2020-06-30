package data;

import enums.data.debug.GuiDebugDataType;

public class GuiDebugDataPacket extends DataPacket {

    public void getDataEntries(GuiDebugDataType key) {
        this.data.get(key);
    }

    @Override
    public void getDataEntries(Enum key) {
        throw new IllegalArgumentException("Illegal type on dataPacket: " + key.getClass());
    }
}
