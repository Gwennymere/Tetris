package logic.state;

import logic.clocking.GameClock;
import logic.clocking.updatables.UnfixedUpdatable;

public class GameState implements UnfixedUpdatable {
    private double charAX = 0;
    private double charAY = 0;
    private double charBX = 1000;
    private double charBY = 700;

    public GameState(GameClock clock) {
        this.registerWithClock(clock);
    }

    @Override
    public void update(long timeElapsed) {
        charAX += timeElapsed * 10;
        charAY += timeElapsed * 10;
        charBX -= timeElapsed * 10;
        charBY -= timeElapsed * 10;
    }

    @Override
    public void registerWithClock(GameClock clock) {
        clock.registerUpdatable(this);
    }
}
