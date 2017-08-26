package v1;

import org.junit.Test;

public class LoansParserTest {
    @Test
    public void testParserModelsFile_WhenFileIsPassedToPaser_ThenTheObjectCanProvideSchemaInformation() throws Exception {
        LoansParser loansParser = new LoansParser("LoansInfo");
    }
}