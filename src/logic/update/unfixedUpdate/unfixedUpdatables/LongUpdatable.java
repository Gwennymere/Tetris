package logic.update.unfixedUpdate.unfixedUpdatables;

import logic.update.unfixedUpdate.Updatable;

public interface LongUpdatable extends Updatable<Long> {
    @Override
    void update(Long updateInfo);
}
