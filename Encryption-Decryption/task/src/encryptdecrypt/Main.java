package encryptdecrypt;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String operation = null;
        String data = null;
        String sKey = null;
        String input = null;
        String output = null;
        String s = null;
        String alg = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode") && i % 2 == 0) {
                operation = args[i + 1];
            }
            if (args[i].equals("-key") && i % 2 == 0) {
                sKey = args[i + 1];
            }
            if (args[i].equals("-data") && i % 2 == 0) {
                data = args[i + 1];
            }
            if (args[i].equals("-in") && i % 2 == 0) {
                input = args[i + 1];
            }
            if (args[i].equals("-out") && i % 2 == 0) {
                output = args[i + 1];
            }
            if (args[i].equals("-alg") && i % 2 == 0) {
                alg = args[i + 1];
            }
        }

        if (operation == null) {
            operation = "enc";
        }
        if (sKey == null) {
            sKey = "0";
        }
        if (alg == null) {
            alg = "shift";
        }
        if (data == null && input == null) {
            s = "";
        } else if (data == null && input != null) {
            File file = new File(input);
            Scanner scanner = new Scanner(file);
            s = scanner.nextLine();
            scanner.close();
        } else if (data != null && input == null) {
            s = data;
        } else if (data != null && input != null) {
            s = data;
        }


        int key = Integer.parseInt(sKey);
        Encryption encdec;

        if (alg.equals("shift")) {
            encdec = new ShiftingEncryption(s, key, output);
        } else {
            encdec = new UnicodeEncryption(s, key, output);
        }

        if (operation.equals("enc")) {
            encdec.encryption();
        } else {
            encdec.decryption();
        }

    }




}
