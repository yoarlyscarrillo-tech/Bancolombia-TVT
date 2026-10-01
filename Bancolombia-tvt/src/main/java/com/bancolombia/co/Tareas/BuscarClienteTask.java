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
        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        actor.attemptsTo(
                WaitUntil.the(NumeroDeConsulta, isVisible()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(NumeroDeConsulta),
                SendKeys.of(documento).into(NumeroDeConsulta)
        );

        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 2: Click en dropdown tipo de búsqueda
        actor.attemptsTo(
                WaitUntil.the(BuscarClientePage.TipoBusquedaInput, isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BuscarClientePage.TipoBusquedaInput)
        );

        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 3: Ingresa tipo de búsqueda dinámicamente
        actor.attemptsTo(
                SendKeys.of(tipoBusqueda).into(BuscarClientePage.TipoBusquedaInput)
        );

        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // Espera y selecciona la opción
        Target opcionBusqueda = Target.the("Opción " + tipoBusqueda)
                .locatedBy("//div[contains(@class, 'option')]//span[contains(text(), '" + tipoBusqueda + "')]");
        actor.attemptsTo(
                WaitUntil.the(opcionBusqueda, isClickable()).forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(opcionBusqueda)
        );

        try { Thread.sleep(3000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 4: Click en BUSCAR (con espera y pausa LARGA)
        actor.attemptsTo(
                WaitUntil.the(BtnBuscarModal, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        // Pausa MUY larga antes de hacer click
        try {
            Thread.sleep(8000);  // Espera 8 segundos
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        actor.attemptsTo(
                Click.on(BtnBuscarModal)
        );

        // Pausa MUY LARGA después del click para ver resultado
        try {
            Thread.sleep(10000);  // Espera 10 segundos - VE LA TABLA
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // PASO 5: Validar que aparezca el resultado (éxito)
        actor.attemptsTo(
                WaitUntil.the(ResultadoBusquedaCliente, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(15))
        );

        // Pausa final para ver la validación
        try {
            Thread.sleep(5000);  // Espera 5 segundos finales
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
