package com.bancolombia.co.Interfaces;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    public static final Target Nombre_de_Usuario = Target.the("id nombre de usuario").locatedBy("//label[contains(text(), 'Nombre de Usuario')]//following::input[1]");
    public static final Target Contrasena = Target.the("id contraseña").locatedBy("//input[@type='password']");
    public static final Target Ingresae = Target.the("id ingresar").locatedBy("//button[contains(@class, 'MuiButton-contained')]");
    public static final Target Bienvenidos_Bancolombia = Target.the("ingreso vista bienvenidos a bancolombia").locatedBy("//a[contains(text(), 'Bancolombia')]");

    }