package logic.update.unfixedUpdate.unfixedUpdatables;

import logic.update.unfixedUpdate.Updatable;

public interface DoubleUpdatable extends Updatable<Double> {
    @Override
    void update(Double updateInfo);
}
