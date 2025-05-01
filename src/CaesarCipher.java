import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CaesarCipher {
    // Алфавит
    public static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ж', 'з',
            'и', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public static final Map<Character, Integer> charToIndexMap = new HashMap<>();
    public static final int ALPHABET_SIZE = ALPHABET.length;
    Validator validator = new Validator();

    static {
        for (int i = 0; i < ALPHABET.length; i++) {
            charToIndexMap.put(ALPHABET[i], i);
        }
    }

    public void encrypt(String inputFile, String outputFile, int key) throws CaesarCipherException {
        validator.isFileValidator(inputFile);
        validator.isFileValidator(outputFile);
        validator.isKeyValidator(key, ALPHABET_SIZE);
        worksFile(inputFile, outputFile, key);
    }

    public void decrypt(String inputFile, String outputFile, int key) throws CaesarCipherException {
        validator.isFileValidator(inputFile);
        validator.isFileValidator(outputFile);
        validator.isKeyValidator(key, ALPHABET_SIZE);
        worksFile(inputFile, outputFile, -key);
    }

    private void worksFile(String inputFile, String outputFile, int key) {
        try {
            Path pathRead = Path.of(inputFile);
            Path pathWrite = Path.of(outputFile);

            List<String> firstFiles = Files.readAllLines(pathRead);

            StringBuilder textBuilder = new StringBuilder();

            for (String string : firstFiles) {

                StringBuilder lineBuilder = new StringBuilder();

                for (char c : string.toCharArray()) {
                    byte b = (byte) c;
                    if (charToIndexMap.containsKey(c)) {

                        int index = charToIndexMap.get(c);
                        int indexFalse = (index + key + ALPHABET_SIZE) % ALPHABET_SIZE;

                        lineBuilder.append(ALPHABET[indexFalse]);
                    } else {
                        lineBuilder.append(c);
                    }
                }
                textBuilder.append(lineBuilder);
                textBuilder.append("\n");
            }
            Files.writeString(pathWrite, textBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

