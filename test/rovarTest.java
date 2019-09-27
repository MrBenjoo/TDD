import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class rovarTest {

    @Test
    void enrov_AllLowerCase() {
        assertEquals("rorovovaror", rovar.enrov("rovar"));
    }

    @Test
    void enrov_AllUpperCase() {
        assertEquals("RoROVoVARoR", rovar.enrov("ROVAR"));
    }

    @Test
    void enrov_UpperCaseLowerCaseDifferentCharacters() {
        assertEquals("PoPlolÅnonbobokoksostotjojuvovaRoR",  rovar.enrov("PlÅnbokstjuvaR"));
    }

    @Test
    void enrov_DifferentCharacters() {
        assertEquals("poplolånonbobokoksostotjojuvovaror",  rovar.enrov("plånbokstjuvar"));
    }

    @Test
    void enrov_EmptyString() {
        assertEquals(" ",  rovar.enrov(" "));
    }

    @Test
    void enrov_NullPointer() {
        assertNull(rovar.enrov(null));
    }

    @Test
    void derov_AllLowerCase() {
        assertEquals("rovar", rovar.derov("rorovovaror"));
    }

    @Test
    void derov_AllUpperCase() {
        assertEquals("ROVAR", rovar.derov("ROROVOVAROR"));
    }

    @Test
    void derov_UpperCaseLowerCaseDifferentCharacters() {
        assertEquals("PlÅnbokstjuvaR",  rovar.derov("PoPlolÅnonbobokoksostotjojuvovaRoR"));
    }


    @Test
    void derov_DifferentCharacters() {
        assertEquals("plånbokstjuvar",  rovar.derov("poplolånonbobokoksostotjojuvovaror"));
    }

    @Test
    void derov_EmptyString() {
        assertEquals(" ",  rovar.derov(" "));
    }

    @Test
    void derov_NullPointer() {
        assertNull(rovar.derov(null));
    }

    @Test
    void enrov_AllNumbers() {
        assertEquals("1234567890",  rovar.derov("1234567890"));
    }

    @Test
    void derov_AllNumbers() {
        assertEquals("1234567890",  rovar.derov("1234567890"));
    }

    @Test
    void enrov_AllCharacters() {
        String allCharacters = "!#$%&()*+,-./:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~'";

        String actual = rovar.enrov(allCharacters);
        String expected = "!#$%&()*+,-./:;<=>?@ABoBCoCDoDEFoFGoGHoHIJoJKoKLoLMoMNoNOPoPQoQRoRSoSToTUVoVWoWXoXYZoZ[]^_`abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzoz{|}~'";

        assertEquals(expected, actual);
    }

    @Test
    void derov_AllCharacters() {
        String enrovedString = "!#$%&()*+,-./:;<=>?@ABoBCoCDoDEFoFGoGHoHIJoJKoKLoLMoMNoNOPoPQoQRoRSoSToTUVoVWoWXoXYZoZ[]^_`abobcocdodefofgoghohijojkoklolmomnonopopqoqrorsostotuvovwowxoxyzoz{|}~'";
        String actual = rovar.derov(enrovedString);
        String expected = "!#$%&()*+,-./:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[]^_`abcdefghijklmnopqrstuvwxyz{|}~'";
        assertEquals(expected, actual);
    }


}