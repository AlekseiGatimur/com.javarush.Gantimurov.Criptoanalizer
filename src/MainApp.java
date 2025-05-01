import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CaesarCipher caesarCipher = new CaesarCipher();
        boolean run = true;

        while (run) {
            System.out.println("Шифрование по методу \"Гая Юлия Цезаря\" ");
            System.out.println("Выберите режим: ");
            System.out.println("Меню: ");
            System.out.println("1.Шифрования ");
            System.out.println("2.Расшифровка с ключом ");
            System.out.println("3.Brute force ");
            System.out.println("0.Выход ");


            int point = scanner.nextInt();
            scanner.nextLine();
            switch (point) {
                case 1:
                    System.out.print("Введите путь файла для зашифровки: ");
                    String filePathInput = scanner.nextLine();
                    System.out.print("Введите путь файла для записи: ");
                    String filePathOutput = scanner.nextLine();
                    System.out.print("Ключ: ");
                    int keyEncrypt = scanner.nextInt();
                    try {
                        caesarCipher.encrypt(filePathInput, filePathOutput, keyEncrypt);
                    } catch (CaesarCipherException ex) {
                        System.out.println("Ошибка в зашифровки: " + ex.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Введите путь файла для расшифровки: ");
                    filePathInput = scanner.nextLine();
                    System.out.print("Введите путь файла для записи: ");
                    filePathOutput = scanner.nextLine();
                    System.out.print("Ключ: ");
                    int keyDecrypt = scanner.nextInt();
                    try {
                        caesarCipher.decrypt(filePathInput, filePathOutput, keyDecrypt);
                    } catch (CaesarCipherException e) {
                        System.out.println("Ошибка в расшифровке: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Введите путь файла для расшифровки: ");
                    filePathInput = scanner.nextLine();
                    System.out.print("Введите путь файла для записи: ");
                    filePathOutput = scanner.nextLine();
                    try {
                        new BruteForce(filePathInput, filePathOutput);
                    } catch (CaesarCipherException e) {
                        System.out.println("Ошибка в брутфорсе: " + e.getMessage());
                    }
                case 0:
                    run = false;
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор, пожалуйста попробуйте снова");
            }
        }

    }
}
