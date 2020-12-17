package logic.update.fixedUpdate;

import logic.update.UpdaterBase;

public interface FixedUpdater<F extends FixedUpdatable> extends UpdaterBase<F, Void> {
    @Override
    void register(F updatable);

    @Override
    void deregister(F updatable);

    void updateNow();
}
