package com.bancolombia.co.Utilidades;
import com.bancolombia.co.Modelos.LoginModel;
import java.util.ResourceBundle;
public class Datos_login {

    private static final ResourceBundle BUNDLE =
            ResourceBundle.getBundle("datos.credenciales");

    public static String getdatos(String llave) {
        return BUNDLE.getString(llave);
    }

    public static LoginModel datoslogin() {
        LoginModel login = new LoginModel();
        login.setUsuario(getdatos("usuario"));
        login.setPassword(getdatos("contrasena"));
        return login;
    }
}