package StepDefinitions;

import com.bancolombia.co.Tareas.*;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;

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
}