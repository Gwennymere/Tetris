package logic.clocking.updatables;

import logic.clocking.GameClock;

public interface Updatable {
    void update(long timeElapsed);

    void registerWithClock(GameClock clock);
}
