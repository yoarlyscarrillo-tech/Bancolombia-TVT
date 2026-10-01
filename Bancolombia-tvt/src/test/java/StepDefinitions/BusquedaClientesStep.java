package StepDefinitions;

import com.bancolombia.co.Tareas.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

public class BusquedaClientesStep {
    private Actor actor = LoginStep.actor;

    @Cuando("Damos clic en buscar cliente")
    public void damosClicEnBuscarCliente() {
        actor.attemptsTo(ClickBuscarClienteTask.hacerClic());
    }

    @Cuando("Buscamos cliente con documento {int} y tipo {string}")
    public void buscamosClienteConDocumentoYTipo(int documento, String tipoBusqueda) {
        actor.attemptsTo(
                BuscarClienteTask.conDocumentoYTipo(String.valueOf(documento), tipoBusqueda)
        );
    }

    @Entonces("Validamos que la búsqueda fue exitosa")
    public void validamosQueLaBúsquedaFueExitosa() {
        // Pausa LARGA para visualizar la tabla cargada
        try {
            Thread.sleep(8000);  // 8 segundos para ver la tabla completa
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Validar que el resultado aparece en la tabla (cliente 30203)
        actor.attemptsTo(
                WaitUntil.the(
                                net.serenitybdd.screenplay.targets.Target.the("Resultado búsqueda cliente")
                                        .locatedBy("//th[@scope='col' and contains(text(), '30203')]"),
                                WebElementStateMatchers.isVisible())
                        .forNoMoreThan(Duration.ofSeconds(10))
        );

        // Pausa MUY LARGA para ver la validación completada
        try {
            Thread.sleep(12000);  // 12 segundos para confirmar el resultado
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Log de éxito
        System.out.println("\n✅ VALIDACIÓN EXITOSA: Resultado de búsqueda visible en tabla");
        System.out.println("📋 Cliente encontrado correctamente");
        System.out.println("⏱️ Validación completada");
        System.out.println("⏰ Pausa: 20 segundos totales");
    }
}
