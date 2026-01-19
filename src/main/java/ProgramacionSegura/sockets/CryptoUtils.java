package ProgramacionSegura.sockets;



import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class CryptoUtils {

    public static SecretKey generarClave() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        return keyGen.generateKey();
    }

    // Convertir clave a Base64
    public static String claveToBase64(SecretKey clave) {
        return Base64.getEncoder().encodeToString(clave.getEncoded());
    }

    // Reconstruir clave desde Base64
    public static SecretKey base64ToClave(String claveBase64) {
        byte[] bytes = Base64.getDecoder().decode(claveBase64);
        return new SecretKeySpec(bytes, "AES");
    }

    public static String cifrar(String texto, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, clave);
        byte[] cifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(cifrado);
    }

    public static String descifrar(String textoCifrado, SecretKey clave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, clave);
        byte[] bytes = Base64.getDecoder().decode(textoCifrado);
        return new String(cipher.doFinal(bytes), StandardCharsets.UTF_8);
    }
}
