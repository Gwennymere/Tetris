package logic.Manager;

import data.GuiDebugDataPacket;
import enums.data.debug.GuiDebugDataType;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {
    private Map<GuiDebugDataType, GuiDebugDataPacket> debugDataMap = new HashMap<>();

    public boolean addDebugEntry(GuiDebugDataType entryType, GuiDebugDataPacket data) {
        return debugDataMap.putIfAbsent(entryType, data) != null;
    }
}
