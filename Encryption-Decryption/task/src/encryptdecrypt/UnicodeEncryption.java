package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;

public class UnicodeEncryption extends Encryption{
    UnicodeEncryption(String data, int key, String output) {
        super(data, key, output);
    }

    @Override
    public void encryption() throws IOException {
        char[] chars = new char[data.length()];
        for (int i = 0; i < data.length(); i++) {
            chars[i] = (char) (data.charAt(i) + key);
        }

        if (output == null) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
        } else {
            FileWriter fileWriter = new FileWriter(output);
            for (char aChar : chars) {
                fileWriter.write(aChar);
            }
            fileWriter.close();
        }
    }

    @Override
    public void decryption() throws IOException {
        char[] chars = new char[data.length()];
        for (int i = 0; i < data.length(); i++) {
            chars[i] = (char) (data.charAt(i) - key);
        }

        if (output == null) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
        } else {
            FileWriter fileWriter = new FileWriter(output);
            for (char aChar : chars) {
                fileWriter.write(aChar);
            }
            fileWriter.close();
        }
    }
}
