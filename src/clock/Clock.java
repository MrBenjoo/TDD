package clock;

public class Clock {
    /******************************** Constants ********************************/
    public static final String DEFAULT_DATE = "2000-01-01";
    public static final String DEFAULT_TIME = "00:00:00";
    public static final String INVALID_STATE = "INVALID_STATE";
    public static final String GIVE_TIME = "Give time";
    public static final String GIVE_DATE = "Give date";
    public static final String BOUNDARY_OUT_OF_RANGE = "Boundary out of range";
    /* *********************************************************************** */

    private Time theTime = new Time();
    private Date theDate = new Date();
    private State currentState = State.DISPLAY_TIME_S1;

    private enum State {
        DISPLAY_TIME_S1,
        DISPLAY_DATE_S2,
        CHANGE_TIME_S3,
        CHANGE_DATE_S4
    }

    public String changeMode() {
        String changeMode;
        switch (currentState) {
            case DISPLAY_TIME_S1:
                currentState = State.DISPLAY_DATE_S2;
                changeMode = theDate.showDate();
                break;
            case DISPLAY_DATE_S2:
                currentState = State.DISPLAY_TIME_S1;
                changeMode = theTime.showTime();
                break;
            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                changeMode = INVALID_STATE;
                break;
            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_DATE_S2;
                changeMode = INVALID_STATE;
                break;
            default:
                changeMode = "Unexpected state: " + currentState;
        }
        return changeMode;
    }

    public String ready() {
        switch (currentState) {
            case DISPLAY_TIME_S1:
                currentState = State.CHANGE_TIME_S3;
                return GIVE_TIME;
            case DISPLAY_DATE_S2:
                currentState = State.CHANGE_DATE_S4;
                return GIVE_DATE;
            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                return INVALID_STATE;
            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_DATE_S2;
                return INVALID_STATE;
            default:
                throw new IllegalStateException("Unexpected state: " + currentState);
        }
    }

    public String set(int p1, int p2, int p3) {
        switch (currentState) {
            case DISPLAY_TIME_S1:
                return INVALID_STATE;
            case DISPLAY_DATE_S2:
                return INVALID_STATE;
            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                return theTime.timeSet(p1, p2, p3);
            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_TIME_S1;
                return theDate.dateSet(p1, p2, p3);
            default:
                throw new IllegalStateException("Unexpected state: " + currentState);
        }
    }


}


