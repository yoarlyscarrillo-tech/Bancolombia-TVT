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
        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        actor.attemptsTo(
                WaitUntil.the(NumeroDeConsulta, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(NumeroDeConsulta),
                SendKeys.of(documento).into(NumeroDeConsulta)
        );

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 2: Click en dropdown tipo de búsqueda
        actor.attemptsTo(
                WaitUntil.the(BuscarClientePage.TipoBusquedaInput, isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BuscarClientePage.TipoBusquedaInput)
        );

        try { Thread.sleep(500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 3: Ingresa tipo de búsqueda dinámicamente
        actor.attemptsTo(
                SendKeys.of(tipoBusqueda).into(BuscarClientePage.TipoBusquedaInput)
        );

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 3B: Selecciona la opción usando ARROW_DOWN + ENTER (más robusto con react-select)
        actor.attemptsTo(
                SendKeys.of(Keys.ARROW_DOWN).into(BuscarClientePage.TipoBusquedaInput),
                SendKeys.of(Keys.ENTER).into(BuscarClientePage.TipoBusquedaInput)
        );

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 4: Click en BUSCAR
        actor.attemptsTo(
                WaitUntil.the(BtnBuscarModal, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        actor.attemptsTo(
                Click.on(BtnBuscarModal)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // PASO 5: Validar que aparezca el resultado (éxito)
        actor.attemptsTo(
                WaitUntil.the(ResultadoBusquedaCliente, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15))
        );

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Log de éxito
        System.out.println("\n✅ TEST PASÓ: Búsqueda completada exitosamente");
        System.out.println("📋 Cliente encontrado: " + documento);
        System.out.println("🔍 Tipo de búsqueda: " + tipoBusqueda);
    }

    public static BuscarClienteTask conDocumentoYTipo(String documento, String tipoBusqueda) {
        return new BuscarClienteTask(documento, tipoBusqueda);
    }
}