package clock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {
    // Each test gets its own instance of the test class!!!
    // In this case the Clock class
    private Clock clock = new Clock();

    // 0-switch transition
    @Test
    void changeMode_DisplayDate_ShouldReturnDefaultDate() {
        assertEquals(Clock.DEFAULT_DATE, clock.changeMode());
    }

    // 0-switch transition
    @Test
    void changeMode_DisplayTime_ShouldReturnDefaultTime() {
        clock.changeMode();
        assertEquals(Clock.DEFAULT_TIME, clock.changeMode());
    }

    // 0-switch transition
    @Test
    void ready_PrepareClockForTimeInput_ShouldReturnGiveTime() {
        assertEquals(Clock.GIVE_TIME, clock.ready());
    }

    // 0-switch transition
    @Test
    void set_ValidTime_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("12:59:59", clock.set(12, 59, 59));
    }

    // 1-switch transition
    @Test
    void ready_PrepareClockForDateInput_ShouldReturnGiveDate() {
        clock.changeMode();
        assertEquals(Clock.GIVE_DATE, clock.ready());
    }

    // 0-switch transition
    @Test
    void set_ValidDate_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2019-09-27", clock.set(2019, 9, 27));
    }


}