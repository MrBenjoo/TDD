package clock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClockTestBorders {
    // Each test gets its own instance of the test class!!!
    // In this case the Clock class
    private Clock clock = new Clock();


    @Test
    void set_InputHourOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(24, 0, 0));
    }

    @Test
    void set_InputHourOneUnderUpperLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("22:00:00", clock.set(22, 0, 0));
    }

    @Test
    void set_InputHourOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(-1, 0, 0));
    }

    @Test
    void set_InputHourOneOverLowerLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("01:00:00", clock.set(1, 0, 0));
    }


    @Test
    void set_InputMinuteOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(0, 60, 0));
    }

    @Test
    void set_InputMinuteOneUnderUpperLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("00:58:00", clock.set(0, 58, 0));
    }

    @Test
    void set_InputMinuteOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(0, -1, 0));
    }

    @Test
    void set_InputMinuteOneOverLowerLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("00:01:00", clock.set(0, 1, 0));
    }


    @Test
    void set_InputSecondsOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(0, 0, 60));
    }

    @Test
    void set_InputSecondsOneUnderUpperLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("00:00:58", clock.set(0, 0, 58));
    }

    @Test
    void set_InputSecondsOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(0, 0, -1));
    }

    @Test
    void set_InputSecondsOneOverLowerLimit_ShouldReturnTheTime() {
        clock.ready();
        assertEquals("00:00:01", clock.set(0, 0, 1));
    }


    // date
    @Test
    void set_InputYearOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(2101, 1, 1));
    }

    @Test
    void set_InputYearOneUnderUpperLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2099-01-01", clock.set(2099, 1, 1));
    }

    @Test
    void set_InputYearOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(1999, 1, 1));
    }

    @Test
    void set_InputYearOneOverLowerLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2001-01-01", clock.set(2001, 1, 1));
    }


    @Test
    void set_InputMonthOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(2000, 13, 1));
    }

    @Test
    void set_InputMonthOneUnderUpperLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2000-11-01", clock.set(2000, 11, 1));
    }

    @Test
    void set_InputMonthOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(2000, 0, 1));
    }

    @Test
    void set_InputMonthOneOverLowerLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2000-01-01", clock.set(2000, 1, 1));
    }


    @Test
    void set_InputDayOneOverUpperLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(2000, 1, 32));
    }

    @Test
    void set_InputDayOneUnderUpperLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2000-01-30", clock.set(2000, 1, 30));
    }

    @Test
    void set_InputDayOneUnderLowerLimit_ShouldGiveBoundaryOutOfRange() {
        clock.changeMode();
        clock.ready();
        assertEquals(Clock.BOUNDARY_OUT_OF_RANGE, clock.set(2000, 1, 0));
    }

    @Test
    void set_InputDayOneOverLowerLimit_ShouldReturnTheDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2000-01-02", clock.set(2000, 1, 2));
    }


}
