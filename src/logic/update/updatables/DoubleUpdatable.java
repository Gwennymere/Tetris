package logic.update.updatables;

public interface DoubleUpdatable extends Updatable<Double> {
    @Override
    void update(Double updateInfo);
}
