package util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Engine {


    public static byte[] encryptDES_ECB_No(byte[] PT, byte[] secret) throws Exception {

        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(PT);
    }

    public static byte[] encryptDES_ECB_PKCS5(byte[] PT, byte[] secret) throws Exception {

        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(PT);
    }

    public static byte[] decryptDES_ECB_PKCS5(byte[] CT, byte[] secret) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(CT);
    }

    public static byte[] encryptDES_CBC_PKCS5(byte[] PT, byte[] secret, byte[] IV) throws Exception {

        IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(PT);
    }

    public static byte[] encryptAES_ECB_No(byte[] PT, byte[] secret) throws Exception {

        SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(PT);
    }

    public static byte[] encryptAES_CBC_PKCS5(byte[] PT, byte[] secret, byte[] IV) throws Exception {

        IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
        return cipher.doFinal(PT);
    }

    public static byte[] decryptDES_ECB_No(byte[] CT, byte[] secret) throws Exception {

        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(CT);
    }

    public static byte[] decryptDES_CBC_PKCS5(byte[] CT, byte[] secret, byte[] IV) throws Exception {

        IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKey = new SecretKeySpec(secret, "DES");
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(CT);
    }

    public static byte[] decryptAES_CBC_PKCS5(byte[] CT, byte[] secret, byte[] IV) throws Exception {

        IvParameterSpec iv = new IvParameterSpec(IV);
        SecretKeySpec secretKey = new SecretKeySpec(secret, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
        return cipher.doFinal(CT);
    }

    public static void printBytes(byte[] bytes) {
        for (byte b : bytes) {
            System.out.print((char) b);
        }
    }
}
