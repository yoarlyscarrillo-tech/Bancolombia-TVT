package com.bancolombia.co.Interaciones;

import com.bancolombia.co.Modelos.LoginModel;
import com.bancolombia.co.Interfaces.LoginPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

@AllArgsConstructor
    public class LoginInteractions implements Interaction {
        private final LoginModel model;
        @Override
        public <T extends Actor> void performAs(T actor) {

         actor.attemptsTo(Enter.theValue(model.getUsuario()).into(LoginPage.Nombre_de_Usuario),
                     Enter.theValue(model.getPassword()).into(LoginPage.Contrasena),
                    Click.on(LoginPage.Ingresae)
            );
        }
        public static LoginInteractions datos(LoginModel model){
            return new LoginInteractions(model);

     }
 }

