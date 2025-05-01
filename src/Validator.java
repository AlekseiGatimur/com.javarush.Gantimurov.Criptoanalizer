import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {
    public void isFileValidator(String file) throws CaesarCipherException {
        if (file.isEmpty() || !Files.exists(Path.of(file))) {
            throw new CaesarCipherException("Пустой файл или не существующий адрес ");
        }
    }

    public void isKeyValidator(int key, int alphabetSize) throws CaesarCipherException {
        if (key < 0 || key >= alphabetSize) {
            throw new CaesarCipherException("Ключ должен быть от 0 до " + alphabetSize);
        }
    }

}
