package com.bancolombia.co.Tareas;
import com.bancolombia.co.Interfaces.BuscarClienteNuevoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
public class BuscarClienteSinValidarTask implements Task {

    private final String documento;
    private final String tipoBusqueda;

    public BuscarClienteSinValidarTask(String documento, String tipoBusqueda) {
        this.documento = documento;
        this.tipoBusqueda = tipoBusqueda;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("\n========== BUSCANDO CLIENTE (SIN VALIDAR RESULTADO) ==========");
        System.out.println("Documento: " + documento);
        System.out.println("Tipo: " + tipoBusqueda);

        // PASO 0: Esperar a que se estabilice la página
        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 1: Ingresa número de consulta
        System.out.println("\nPASO 1: Ingresando número de consulta...");

        try {
            actor.attemptsTo(
                    WaitUntil.the(BuscarClienteNuevoPage.CampoNumeroConsulta, isVisible())
                            .forNoMoreThan(Duration.ofSeconds(15))
            );
            System.out.println("✅ Campo número de consulta ENCONTRADO");

            actor.attemptsTo(
                    Click.on(BuscarClienteNuevoPage.CampoNumeroConsulta),
                    SendKeys.of(documento).into(BuscarClienteNuevoPage.CampoNumeroConsulta)
            );
            System.out.println("✅ Documento ingresado: " + documento);

        } catch (Exception e) {
            System.out.println("❌ ERROR: No encontró campo número de consulta");
            System.out.println("   Solución: Inspecciona HTML del modal en DevTools (F12)");
            System.out.println("   Actualiza XPath en: BuscarClienteNuevoPage.java línea ~23");
            throw e;
        }

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 2: Selecciona tipo de búsqueda
        System.out.println("\nPASO 2: Seleccionando tipo de búsqueda...");

        actor.attemptsTo(
                WaitUntil.the(BuscarClienteNuevoPage.CampoTipoBusqueda, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10)),
                Click.on(BuscarClienteNuevoPage.CampoTipoBusqueda),
                SendKeys.of(tipoBusqueda).into(BuscarClienteNuevoPage.CampoTipoBusqueda)
        );

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 2B: Selecciona opción con ARROW_DOWN + ENTER
        actor.attemptsTo(
                SendKeys.of(Keys.ARROW_DOWN).into(BuscarClienteNuevoPage.CampoTipoBusqueda),
                SendKeys.of(Keys.ENTER).into(BuscarClienteNuevoPage.CampoTipoBusqueda)
        );

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        System.out.println("✅ Tipo de búsqueda seleccionado: " + tipoBusqueda);

        // PASO 3: Click en BUSCAR
        System.out.println("\nPASO 3: Haciendo click en botón BUSCAR...");

        actor.attemptsTo(
                WaitUntil.the(BuscarClienteNuevoPage.BtnBuscarEnModal, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        actor.attemptsTo(
                Click.on(BuscarClienteNuevoPage.BtnBuscarEnModal)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ BUSCAR ejecutado");
        System.out.println("========== BÚSQUEDA COMPLETADA (SIN VALIDACIÓN) ==========\n");
    }

    public static BuscarClienteSinValidarTask conDocumentoYTipo(String documento, String tipoBusqueda) {
        return new BuscarClienteSinValidarTask(documento, tipoBusqueda);
    }
}
