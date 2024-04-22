import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> contraseñasValidas = new ArrayList<>(); // Mover la lista al ámbito de la clase

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pass validator = new Pass();

        boolean isValidPassword;
        String password;

        System.out.println("\nLEE ESTAS ESPECIFICACIONES PARA CREAR UNA CONTRASEÑA:");
        System.out.println("- Longitud mínima de 8 caracteres.");
        System.out.println("- Utilizar al menos 1 carácter especial.");
        System.out.println("- Utilizar al menos 2 letras mayúsculas.");
        System.out.println("- Utilizar al menos 3 letras minúsculas.");
        System.out.println("- Utilizar al menos 1 número.");

        do {
            System.out.print("\nIngrese una contraseña: ");
            password = scanner.nextLine();
            isValidPassword = validator.isValid(password);

            if (isValidPassword) {
                contraseñasValidas.add(password); // Agregar contraseña válida a la lista
                System.out.println("La contraseña es válida.");
            } else {
                System.out.println("La contraseña no cumple con las especificaciones. Intente nuevamente.");
            }
        } while (!isValidPassword);

        try {
            File logFile = new File("registro.txt");
            FileWriter writer = new FileWriter(logFile, true); // true para modo de añadir al archivo existente
            writer.write("Contraseña: " + password + " - Válida\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo de registro: " + e.getMessage());
        }

        System.out.print("Escribe SI si quieres validar una nueva contraseña o NO si no deseas: ");
        String continuar = scanner.nextLine();
        if (continuar.equalsIgnoreCase("SI")) {
            main(args); // Llamada recursiva para validar otra contraseña
        } else {
            System.out.println("\nContraseñas ingresadas válidas:");
            for (String pass : contraseñasValidas) {
                System.out.println(pass);
            }
            System.out.println("Fin del programa.");
            scanner.close();
        }
    }
}
