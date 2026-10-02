package com.bancolombia.co.Tareas;

import com.bancolombia.co.Interfaces.BuscarClienteNuevoPage;
import com.bancolombia.co.Utilidades.DatosClienteNuevo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarPCRCTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("\n========== SELECCIONANDO PCRC ==========");

        // PASO 0: Leer valor desde properties
        String valorPCRC = DatosClienteNuevo.obtener("cliente.pcrc");
        System.out.println("📋 PCRC a seleccionar: " + valorPCRC);

        if (valorPCRC.isEmpty()) {
            throw new IllegalArgumentException("❌ ERROR: cliente.pcrc está VACÍO en locators.properties");
        }

        // Esperar a que el campo esté visible
        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 1: Validar que el campo está VISIBLE
        System.out.println("PASO 1: Validando que campo PCRC está visible...");
        actor.attemptsTo(
                WaitUntil.the(BuscarClienteNuevoPage.DropdownPCRC, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(20))
        );
        System.out.println("✅ Campo PCRC está VISIBLE");

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 2: HACER CLICK en el campo de texto
        System.out.println("PASO 2: Dando CLICK en el campo de texto...");
        actor.attemptsTo(
                Click.on(BuscarClienteNuevoPage.DropdownPCRC)
        );
        System.out.println("✅ CLICK realizado en campo PCRC");

        try { Thread.sleep(1500); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 3: ESCRIBIR el valor en el campo
        System.out.println("PASO 3: Escribiendo valor en el campo...");
        actor.attemptsTo(
                SendKeys.of(valorPCRC).into(BuscarClienteNuevoPage.DropdownPCRC)
        );
        System.out.println("✅ Valor ESCRITO: " + valorPCRC);

        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 4: NAVEGAR con ARROW_DOWN para mostrar opciones
        System.out.println("PASO 4: Navegando con ARROW_DOWN...");
        actor.attemptsTo(
                SendKeys.of(Keys.ARROW_DOWN).into(BuscarClienteNuevoPage.DropdownPCRC)
        );
        System.out.println("✅ ARROW_DOWN enviado");

        try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        // PASO 5: SELECCIONAR opción con ENTER
        System.out.println("PASO 5: Seleccionando opción con ENTER...");
        actor.attemptsTo(
                SendKeys.of(Keys.ENTER).into(BuscarClienteNuevoPage.DropdownPCRC)
        );
        System.out.println("✅ ENTER presionado - Opción SELECCIONADA");

        try { Thread.sleep(2000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }

        System.out.println("========== PCRC SELECCIONADO EXITOSAMENTE ==========\n");
    }

    public static SeleccionarPCRCTask conValorDelProperties() {
        return new SeleccionarPCRCTask();
    }
}
