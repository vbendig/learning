package cert.java.security;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.io.FilePermission;
import java.math.BigInteger;
import java.net.SocketPermission;
import java.nio.charset.StandardCharsets;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidParameterSpecException;

public class Test {
    public static void main(String[] args) {
        checkPermissions();
        messageDigest();
        encryptDecrypt();
    }

    private static void encryptDecrypt() {
        String text = "Value that requires encryption";
        try {
            SecretKey key = KeyGenerator.getInstance("AES").generateKey();
            System.out.println(key.getFormat());
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte [] value = text.getBytes(StandardCharsets.UTF_8);
            byte [] encryptedData = cipher.doFinal(value);
            GCMParameterSpec ps = cipher.getParameters().getParameterSpec(GCMParameterSpec.class);
            cipher.init(Cipher.DECRYPT_MODE, key, ps);
            byte [] decryptedValue = cipher.doFinal(encryptedData);
            System.out.println(new String(decryptedValue, StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }

    }

    private static void messageDigest() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte [] digest = md.digest("Hola Mundo".getBytes());
            String hash = (new BigInteger(1, digest)).toString(16);
            System.out.println(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static void checkPermissions() {
        SocketPermission socketPermission = new SocketPermission("localhost:7777", "accept, connect, listen");
        FilePermission filePermission = new FilePermission("~/.bashrc", "read, write");
        try {
            AccessController.checkPermission(socketPermission);
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
        try {
            AccessController.checkPermission(filePermission);
        } catch (AccessControlException e) {
            e.printStackTrace();
        }
    }
}
