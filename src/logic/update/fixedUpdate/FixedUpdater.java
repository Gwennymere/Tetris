package logic.update.fixedUpdate;

import logic.update.UpdaterBase;

public interface FixedUpdater<F extends FixedUpdatable> extends UpdaterBase<F> {
    @Override
    void register(F updatable);
}
