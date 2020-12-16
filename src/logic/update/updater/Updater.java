package logic.update.updater;

import logic.update.updatable.GenericUpdatable;

public interface Updater<U extends GenericUpdatable> {
    void register(U updatable);
}
