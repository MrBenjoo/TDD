import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rovarTest {

    @Test
    void enrovAllLowerCase() {
        assertEquals("rorovovaror", rovar.enrov("rovar"));
    }

    @Test
    void enrovAllUpperCase() {
        assertEquals("ROROVOVAROR", rovar.enrov("ROVAR"));
    }

    @Test
    void enrovUpperCaseLowerCaseDifferentCharacters() {
        assertEquals("PoPlolÅnonbobokoksostotjojuvovaRoR",  rovar.enrov("PlÅnbokstjuvaR"));
    }

    @Test
    void enrovDifferentCharacters() {
        assertEquals("poplolånonbobokoksostotjojuvovaror",  rovar.enrov("plånbokstjuvar"));
    }

    @Test
    void enrovEmptyString() {
        assertEquals(" ",  rovar.enrov(" "));
    }

    @Test
    void enrovNullPointer() {
        assertNull(rovar.enrov(null));
    }





    @Test
    void derovAllLowerCase() {
        assertEquals("rovar", rovar.derov("rorovovaror"));
    }

    @Test
    void derovAllUpperCase() {
        assertEquals("ROVAR", rovar.derov("ROROVOVAROR"));
    }

    @Test
    void derovUpperCaseLowerCaseDifferentCharacters() {
        assertEquals("PlÅnbokstjuvaR",  rovar.derov("PoPlolÅnonbobokoksostotjojuvovaRoR"));
    }

    @Test
    void derovDifferentCharacters() {
        assertEquals("plånbokstjuvar",  rovar.derov("poplolånonbobokoksostotjojuvovaror"));
    }

    @Test
    void derovEmptyString() {
        assertEquals(" ",  rovar.derov(" "));
    }

    @Test
    void derovNullPointer() {
        assertNull(rovar.derov(null));
    }


}