package ServiciosRed.RickMorty;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashManager {

    private static final String ALGORITMO = "SHA-256";

    public static byte[] getDigest(byte[] mensaje)
            throws NoSuchAlgorithmException {

        MessageDigest algoritmo = MessageDigest.getInstance(ALGORITMO);
        algoritmo.reset();
        algoritmo.update(mensaje);

        return algoritmo.digest();
    }

    public static boolean compararResumenes(byte[] resumen1, byte[] resumen2)
            throws NoSuchAlgorithmException {

        // Mensaje para ver que el método se ejecuta
        System.out.println(">> Ejecutando comparador de hashes...");

        MessageDigest algoritmo = MessageDigest.getInstance(ALGORITMO);
        algoritmo.reset();

        boolean iguales = algoritmo.isEqual(resumen1, resumen2);

        if (iguales) {
            System.out.println(">> RESULTADO: Los hashes COINCIDEN");
        } else {
            System.out.println(">> RESULTADO: Los hashes NO coinciden");
        }

        return iguales;
    }
}

