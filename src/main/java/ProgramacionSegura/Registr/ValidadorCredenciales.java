package ProgramacionSegura.Registr;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class ValidadorCredenciales {

    private static final String ENCODING_TYPE = "UTF-8";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce identificador (email): ");
        String identificador = sc.nextLine();

        System.out.print("Introduce contraseña: ");
        String password = sc.nextLine();

        try {
            byte[] resumen =
                    HashManager.getDigest(password.getBytes(ENCODING_TYPE));

            byte[] resumenAlmacenado =
                    Files.readAllBytes(
                            new File(identificador + ".credencial").toPath());

            if (HashManager.compararResumenes(resumen, resumenAlmacenado)) {
                System.out.println("Autorizado");
            } else {
                System.out.println("Error de validación");
            }

            mostrarResumenHexadecimal(resumen);
            mostrarResumenHexadecimal(resumenAlmacenado);

        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        sc.close();
    }

    private static void mostrarResumenHexadecimal(byte[] resumen) {
        String resumenHexadecimal =
                String.format("%064x", new BigInteger(1, resumen));
        System.out.println(resumenHexadecimal);
    }
}

