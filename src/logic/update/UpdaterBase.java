package logic.update;

import exceptions.runtime.BadUpdateException;

public interface UpdaterBase<U, D> {
    default void register(U updatable) {
        throw new IllegalArgumentException("Updater brauchen Updatables oder FixedUpdatables");
    }

    default void deregister(U updatable) {
        throw new IllegalArgumentException("Updater brauchen Updatables oder FixedUpdatables");
    }

    default void updateNow(D data) {
        throw new BadUpdateException("updateNow muss implementiert werden");
    }
}
