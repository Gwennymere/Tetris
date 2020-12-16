package logic.state;

import logic.clocking.GameClock;
import logic.update.unfixedUpdate.unfixedUpdatables.LongUpdatable;

public class GameState implements LongUpdatable {
    private double charAX = 0;
    private double charAY = 0;
    private double charBX = 1000;
    private double charBY = 700;

    public GameState(GameClock clock) {
        this.registerWithClock(clock);
    }

    @Override
    public void update(Long timeElapsed) {
        charAX += timeElapsed * 10;
        charAY += timeElapsed * 10;
        charBX -= timeElapsed * 10;
        charBY -= timeElapsed * 10;
    }

    private void registerWithClock(GameClock clock) {
        clock.register(this);
    }
}
