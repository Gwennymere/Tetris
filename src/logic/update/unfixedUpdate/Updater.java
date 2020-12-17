package logic.update.unfixedUpdate;

import logic.update.UpdaterBase;

public interface Updater<U extends Updatable, D> extends UpdaterBase<U, D> {
    @Override
    void register(U updatable);

    @Override
    void deregister(U updatable);
}
