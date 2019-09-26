package clock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockTestInvalidStates {
    private Clock clock = new Clock();

    @Test
    void set_DisplayTimeState_ShouldReturnInvalidStateMessage() {
        assertEquals(Clock.INVALID_STATE, clock.set(0, 0, 0));
    }

    @Test
    void set_DisplayDateState_ShouldReturnInvalidStateMessage() {
        clock.changeMode();
        assertEquals(Clock.INVALID_STATE, clock.set(2000, 1, 1));
    }

    @Test
    void changeMode_ChangeTimeState_ShouldReturnInvalidStateMessage() {
        clock.ready();
        assertEquals(Clock.INVALID_STATE, clock.changeMode());
    }

    @Test
    void ready_ChangeTimeState_ShouldReturnInvalidStateMessage() {
        clock.ready();
        assertEquals(Clock.INVALID_STATE, clock.ready());
    }

    @Test
    void changeMode_ChangeDateState_ShouldReturnInvalidStateMessage() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.INVALID_STATE, clock.changeMode());
    }

    @Test
    void ready_ChangeDateState_ShouldReturnInvalidStateMessage() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.INVALID_STATE, clock.ready());
    }

}
