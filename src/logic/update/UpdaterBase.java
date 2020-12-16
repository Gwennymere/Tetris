package logic.update;

public interface UpdaterBase<U> {
    default void register(U updatable) {
        throw new IllegalArgumentException("Updater brauchen Updatables oder FixedUpdatables");
    }
}
