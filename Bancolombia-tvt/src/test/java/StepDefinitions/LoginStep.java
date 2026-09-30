package StepDefinitions;

import com.bancolombia.co.Modelos.LoginModel;
import com.bancolombia.co.Tareas.LoginTask;
import com.bancolombia.co.Utilidades.Datos_login;
import com.bancolombia.co.Utilidades.Url;
import io.cucumber.java.Before;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.bancolombia.co.Interfaces.LoginPage.Bienvenidos_Bancolombia;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginStep {

    @Managed(driver = "chrome")
    private ChromeDriver driver;

    public static Actor actor; // ✅ STATIC para compartir con SearchClientStep
    private Url url = new Url();

    @Before
    public void configurarActor() {
        actor = Actor.named("Usuario");
        actor.can(BrowseTheWeb.with(driver));
    }

    @Dado("Ingresamos a la url de TVT")
    public void ingresamosALaUrlDeTVT() {
        actor.wasAbleTo(Open.browserOn(url));
    }

    @Cuando("Realizamos login en TVT")
    public void realizamosLoginEnTVT() {
        LoginModel modelo = Datos_login.datoslogin();
        actor.attemptsTo(LoginTask.realizarLogin(modelo));
    }

    @Entonces("Validamos inicio de sesion exitoso")
    public void validamosInicioDeSesionExitoso() {
        actor.attemptsTo(
                WaitUntil.the(Bienvenidos_Bancolombia, isVisible())
                        .forNoMoreThan(Duration.ofSeconds(80)),
                Ensure.that(Bienvenidos_Bancolombia)
                        .text()
                        .containsIgnoringCase("Bancolombia")
        );
    }
}