package com.bancolombia.co.Tareas;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static com.bancolombia.co.Interfaces.BuscarClientePage.BtnBuscarCliente;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class ClickBuscarClienteTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BtnBuscarCliente, isClickable()).forNoMoreThan(Duration.ofSeconds(20)),
                Click.on(BtnBuscarCliente)
        );
    }

    public static ClickBuscarClienteTask hacerClic() {
        return instrumented(ClickBuscarClienteTask.class);
    }
}

