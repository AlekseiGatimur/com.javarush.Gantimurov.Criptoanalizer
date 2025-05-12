
public class Readability {
// Проверка на читабельность расшифрованного текста
    public Readability() {
    }

    private final char lettersVowel[] = {'а', 'и', 'о', 'е', 'ё', 'й', 'у', 'ы', 'э', 'ю', 'я'};
    private final String[] commonWords = {"он", "она", "ты", "кто", "вы", "они", "все", "или", "если", "где", "на", "из", "вот", "для", "это", "не", "за", "бы"};

    public boolean isReadability(String text, int key) {
        int counter = 0;
        int counterVowel = 0;
        int wordsCount = 0;

        for (char c : text.toString().toCharArray()) {
            if (c == ' ') {
                counter++;
            }
            for (char vowel : lettersVowel) {
                if (c == vowel) {
                    counterVowel++;
                    break;
                }
            }
        }
        String[] words = text.toString().toLowerCase().split("\\s+");
        for (String word : words) {
            for (String commonWord : commonWords) {
                if (commonWord.equals(word)) {
                    wordsCount++;
                    break;
                }
            }
        }

        if (counter > 5 && counterVowel > 10 && wordsCount > 2) {
            System.out.println("Возможный ключ: " + key + " (Пробелов:" + counter + ", гласных:" + counterVowel + " Слов:" + wordsCount + ")");
            return true;


        }
        return false;
    }
}


