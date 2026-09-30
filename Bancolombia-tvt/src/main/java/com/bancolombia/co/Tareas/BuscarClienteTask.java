package com.bancolombia.co.Tareas;
import com.bancolombia.co.Interfaces.BuscarClientePage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;


import java.time.Duration;

import static com.bancolombia.co.Interfaces.BuscarClientePage.*;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@AllArgsConstructor
public class BuscarClienteTask implements Task {
    private final String documento;
    private final String tipoBusqueda;

    @Override
    public <T extends Actor> void performAs(T actor) {

        // PASO 1: Ingresa documento
        actor.attemptsTo(
                WaitUntil.the(NumeroDeConsulta, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(NumeroDeConsulta),
                SendKeys.of(documento).into(NumeroDeConsulta)
        );

        // Paso 2: Selecciona tipo de búsqueda
        actor.attemptsTo(
                WaitUntil.the(TipoBusquedaDropdown, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(TipoBusquedaDropdown)
        );



        // PASO 4: Click en BUSCAR
        actor.attemptsTo(
                WaitUntil.the(BtnBuscarModal, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BtnBuscarModal)
        );
    }

    public static BuscarClienteTask conDocumentoYTipo(String documento, String tipoBusqueda) {
        return new BuscarClienteTask(documento, tipoBusqueda);
    }
}