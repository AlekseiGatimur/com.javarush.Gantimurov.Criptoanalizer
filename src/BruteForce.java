import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BruteForce {

    public BruteForce(String inputFile, String outputFile) throws CaesarCipherException {
        try {
            Path pathRead = Path.of(inputFile);
            Path pathWrite = Path.of(outputFile);
            Validator validator = new Validator();
            validator.isFileValidator(inputFile);
            validator.isFileValidator(outputFile);

            List<String> firstFiles = Files.readAllLines(pathRead);
            for (int key = 1; key < CaesarCipher.ALPHABET_SIZE; key++) {
                StringBuilder textBuilder = new StringBuilder();
                for (String firstFile : firstFiles) {
                    for (char c : firstFile.toCharArray()) {
                        if (CaesarCipher.charToIndexMap.containsKey(c)) {
                            int index = CaesarCipher.charToIndexMap.get(c);
                            int indexTrue = (index - key + CaesarCipher.ALPHABET_SIZE) % CaesarCipher.ALPHABET_SIZE;
                            textBuilder.append(CaesarCipher.ALPHABET[indexTrue]);
                        } else {
                            textBuilder.append(c);
                        }
                    }
                    textBuilder.append("\n");
                }
                textBuilder.append("\nКлюч: " + key + "\n");

                Readability readability = new Readability();
                if (readability.isReadability(textBuilder.toString(), key)) {
                    Files.writeString(pathWrite, textBuilder);
                    break;
                }
            }
        } catch (CaesarCipherException ex) {
            ex.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
