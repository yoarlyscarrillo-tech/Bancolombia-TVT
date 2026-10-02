package com.bancolombia.co.Utilidades;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class DatosClienteNuevo {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = DatosClienteNuevo.class.getClassLoader()
                .getResourceAsStream("locators.properties")) {
            if (input == null) {
                System.err.println("❌ No se encontró locators.properties");
            } else {
                properties.load(input);
            }
        } catch (IOException ex) {
            System.err.println("❌ Error: " + ex.getMessage());
        }
    }

    public static String obtener(String key) {
        return properties.getProperty(key, "");
    }

    public static String obtener(String key, String placeholder, String value) {
        return properties.getProperty(key, "").replace(placeholder, value);
    }

    public static void mostrarTodos() {
        properties.forEach((k, v) -> System.out.println(k + " = " + v));
    }
}

