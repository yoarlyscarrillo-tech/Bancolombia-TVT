package com.bancolombia.co.Tareas;

import com.bancolombia.co.Interfaces.BuscarClienteNuevoPage;
import com.bancolombia.co.Interfaces.BuscarClientePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarPCRCYNuevaVentaTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        System.out.println("\n========== CREANDO NUEVA VENTA ==========");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // PASO 1: Esperar que botón Nueva Venta esté clickeable
        System.out.println("Buscando botón NUEVA VENTA...");

        actor.attemptsTo(
                WaitUntil.the(BuscarClienteNuevoPage.BtnNuevaVenta, isClickable())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        System.out.println("✅ Botón NUEVA VENTA encontrado");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // PASO 2: Click en botón NUEVA VENTA
        System.out.println("Haciendo click en NUEVA VENTA...");
        actor.attemptsTo(
                Click.on(BuscarClienteNuevoPage.BtnNuevaVenta)
        );

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("✅ Botón NUEVA VENTA clickeado correctamente - Creando nuevo caso de venta");
        System.out.println("========== NUEVA VENTA CREADA EXITOSAMENTE ==========\n");
    }

    public static SeleccionarPCRCYNuevaVentaTask paraCrearNuevoCliente() {
        return new SeleccionarPCRCYNuevaVentaTask();
    }
}


   