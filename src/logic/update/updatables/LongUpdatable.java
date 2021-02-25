package logic.update.updatables;

public interface LongUpdatable extends Updatable<Long> {
    @Override
    void update(Long updateInfo);
}
