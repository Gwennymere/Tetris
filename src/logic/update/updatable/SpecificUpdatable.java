package logic.update.updatable;

import exceptions.runtime.BadUpdateException;

public interface SpecificUpdatable<D> extends GenericUpdatable{
    void update(D data);

    default void update() {
        throw new BadUpdateException("SpecificUpdatable ohne defaultImplementierung fue update() muessen beim Update einen Parameter erhalten");
    }
}
