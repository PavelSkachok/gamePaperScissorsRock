import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Authentication {
    private String fieldKeyHMAC;
    private String fieldHMAC;

    public Authentication(String message) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        SecretKey secretKey = genKey(128);
        this.fieldKeyHMAC = "HMAC key: " + bytesToHex(secretKey.getEncoded());
        this.fieldHMAC = "HMAC: " + bytesToHex(calcHMAC(message, secretKey));
    }

    public String getFieldKeyHMAC() {
        return fieldKeyHMAC;
    }

    public String getFieldHMAC() {
        return fieldHMAC;
    }

    private static SecretKey genKey(int dimension) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(dimension, new SecureRandom());
        return keyGen.generateKey();
    }

    private static byte[] calcHMAC(String message, SecretKey key) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(key);
        byte[] stringBytes = message.getBytes("utf8");
        return mac.doFinal(stringBytes);
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuffer hexString = new StringBuffer(bytes.length);
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xff & bytes[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
