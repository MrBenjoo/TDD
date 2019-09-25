import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoverageExampleTest {

    /* 100% statement coverage since each statement is visited.
    * Even though it provided 100% statement coverage, the test case
    * did not find the bug */
    @Test
    public void testIdentityAllTrue() {
        assertEquals(0, CoverageExample.identity(0, true ,true ,true));
    }

    /* 100% branch coverage since each possible branch outcome is
    * tested. The above test covers all the true branches while this test covers
    * all the false branches and therefore achieves 100% branch coverage.
    * Even with 100% statement and branch coverage, no bug has yet been
    * uncovered.
    */
    @Test
    public void testAllFalse() {
        assertEquals(0, CoverageExample.identity(0, false ,false ,false));
    }

    /* the following 6 tests are for the path coverage */
    @Test
    public void testTrueTrueFalse() {
        assertEquals(0, CoverageExample.identity(0, true, true, false));
    }

    @Test
    public void testTrueFalseTrue() {
        assertEquals(0, CoverageExample.identity(0, true, false, true));
    }

    @Test
    public void testTrueFalseFalse() {
        assertEquals(0, CoverageExample.identity(0, true, false, false));
    }

    @Test
    public void testFalseTrueTrue() {
        assertEquals(0, CoverageExample.identity(0, false, true, true));
    }

    @Test
    public void testFalseTrueFalse() {
        assertEquals(0, CoverageExample.identity(0, false, true, false));
    }

    @Test
    public void testFalseFalseTrue() {
        assertEquals(0, CoverageExample.identity(0, false, false, true));
    }





}