package logic.update.unfixedUpdate;

import logic.update.UpdaterBase;

public interface Updater<U extends Updatable> extends UpdaterBase<U> {
    @Override
    void register(U updatable);
}
