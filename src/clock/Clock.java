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
        String valueOfState;

        switch (currentState) {

            case DISPLAY_TIME_S1:
                currentState = State.DISPLAY_DATE_S2;
                valueOfState = theDate.showDate();
                break;

            case DISPLAY_DATE_S2:
                currentState = State.DISPLAY_TIME_S1;
                valueOfState = theTime.showTime();
                break;

            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                valueOfState = INVALID_STATE;
                break;

            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_DATE_S2;
                valueOfState = INVALID_STATE;
                break;

            default:
                valueOfState = "Unexpected state: " + currentState;

        }

        return valueOfState;
    }

    public String ready() {
        String valueOfState;

        switch (currentState) {

            case DISPLAY_TIME_S1:
                currentState = State.CHANGE_TIME_S3;
                valueOfState = GIVE_TIME;
                break;

            case DISPLAY_DATE_S2:
                currentState = State.CHANGE_DATE_S4;
                valueOfState = GIVE_DATE;
                break;

            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                valueOfState = INVALID_STATE;
                break;

            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_DATE_S2;
                valueOfState = INVALID_STATE;
                break;

            default:
                valueOfState = "Unexpected state: " + currentState;

        }

        return valueOfState;
    }

    public String set(int p1, int p2, int p3) {
        String valueOfState;

        switch (currentState) {

            case DISPLAY_TIME_S1:
            case DISPLAY_DATE_S2:
                valueOfState = INVALID_STATE;
                break;

            case CHANGE_TIME_S3:
                currentState = State.DISPLAY_TIME_S1;
                valueOfState = theTime.timeSet(p1, p2, p3);
                break;

            case CHANGE_DATE_S4:
                currentState = State.DISPLAY_TIME_S1;
                valueOfState = theDate.dateSet(p1, p2, p3);
                return valueOfState;

            default:
                valueOfState = "Unexpected state: " + currentState;

        }

        return valueOfState;
    }


}


