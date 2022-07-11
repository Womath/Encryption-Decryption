package encryptdecrypt;

import java.io.FileWriter;
import java.io.IOException;

public class ShiftingEncryption extends Encryption{

    ShiftingEncryption(String data, int key, String output) {
        super(data, key, output);
    }

    @Override
    public void encryption() throws IOException {
        char[] chars = new char[data.length()];
        for (int i = 0; i < data.length(); i++) {
            if (data.charAt(i) >= 65 && data.charAt(i) <= 90) {
                if ((char) (data.charAt(i) + key) > 90) {
                    chars[i] = (char) (data.charAt(i) + key - 26);
                } else {
                    chars[i] = (char) (data.charAt(i) + key);
                }
            } else if (data.charAt(i) >= 97 && data.charAt(i) <= 122) {
                if ((char) (data.charAt(i) + key) > 122) {
                    chars[i] = (char) (data.charAt(i) + key - 26);
                } else {
                    chars[i] = (char) (data.charAt(i) + key);
                }
            } else {
                chars[i] = (data.charAt(i));
            }
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
            if (data.charAt(i) >= 65 && data.charAt(i) <= 90) {
                if ((char) (data.charAt(i) - key) < 65) {
                    chars[i] = (char) (data.charAt(i) - key + 26);
                } else {
                    chars[i] = (char) (data.charAt(i) - key);
                }
            } else if (data.charAt(i) >= 97 && data.charAt(i) <= 122) {
                if ((char) (data.charAt(i) - key) < 97) {
                    chars[i] = (char) (data.charAt(i) - key + 26);
                } else {
                    chars[i] = (char) (data.charAt(i) - key);
                }
            } else {
                chars[i] = (data.charAt(i));
            }
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
