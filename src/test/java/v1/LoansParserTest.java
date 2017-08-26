package v1;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class LoansParserTest {

    @Test(expected = LoansParser.InvalidIncomingDataFileFormatException.class)
    public void testParserThrowsException_WhenNonTabSeparatedExceptionIsUsed_ThenExceptionThrown() throws Exception {
        new LoansParser("LoansInfo", true, false);
    }

    @Test
    public void testParserModelsFile_WhenFileIsPassedToPaser_ThenTheObjectCanProvideSchemaInformation() throws Exception {
        LoansParser loansParser = new LoansParser("LoansInfo", true, true);
        assertEquals(Optional.of(12), loansParser.getColumnCount());
    }
}