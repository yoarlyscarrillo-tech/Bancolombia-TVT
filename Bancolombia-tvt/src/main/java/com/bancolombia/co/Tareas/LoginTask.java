package com.bancolombia.co.Tareas;

import com.bancolombia.co.Modelos.LoginModel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.bancolombia.co.Interfaces.LoginPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class LoginTask implements Task {
    private final LoginModel model;

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Paso 1: Ingresa usuario
        actor.attemptsTo(
                WaitUntil.the(Nombre_de_Usuario, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Enter.theValue(model.getUsuario()).into(Nombre_de_Usuario)
        );

        // Paso 2: Ingresa contraseña
        actor.attemptsTo(
                Enter.theValue(model.getPassword()).into(Contrasena)
        );

        // Paso 3: Clickea el botón ingresar
        actor.attemptsTo(
                WaitUntil.the(Ingresae, isClickable()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(Ingresae)
        );
    }

    // Constructor estático
    public static LoginTask realizarLogin(LoginModel model) {
        return new LoginTask(model);
    }
}
