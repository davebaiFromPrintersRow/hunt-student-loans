package v1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;

public class LoansParser {
    private Optional<Integer> columnCount = Optional.empty();

    public LoansParser(String loansFile, boolean hasHeader, boolean tabSeparated) throws IOException {
        if (!tabSeparated) {
            throw new InvalidIncomingDataFileFormatException();
        }
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(loansFile);
        BufferedReader in = new BufferedReader(new InputStreamReader(resourceAsStream));
        String line = null;

        while ((line = in.readLine()) != null) {
            if (hasHeader) {
                String[] splitHeaderTabs = line.split("\t");
                this.columnCount = Optional.of(splitHeaderTabs.length);
                hasHeader = false;
            } else {

            }
        }
    }

    public Optional<Integer> getColumnCount() {
        return columnCount;
    }

    public class InvalidIncomingDataFileFormatException extends RuntimeException {
    }
}
