package encryptdecrypt;

import java.io.IOException;

public abstract class Encryption {
    String data;
    int key;
    String output;

    Encryption(String data, int key, String output) {
        this.data = data;
        this.key = key;
        this.output = output;
    }

    public abstract void encryption() throws IOException;
    public abstract void decryption() throws IOException;
}
