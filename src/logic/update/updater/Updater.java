package logic.update.updater;

import logic.update.updatables.Updatable;

public interface Updater<U extends Updatable, D> extends UpdaterBase<U, D> {
    @Override
    void register(U updatable);

    @Override
    void deregister(U updatable);
}
