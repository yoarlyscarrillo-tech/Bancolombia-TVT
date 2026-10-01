package com.bancolombia.co.Interfaces;
import net.serenitybdd.screenplay.targets.Target;

public class BuscarClientePage {
    // Botón BUSCAR CLIENTE en el header
    public static final Target BtnBuscarCliente = Target.the("Botón buscar cliente")
            .locatedBy("//button[contains(., 'Buscar Cliente')]");

    // Campo número de consulta
    public static final Target NumeroDeConsulta = Target.the("Campo número de consulta")
            .locatedBy("//input");

    // Opción del dropdown que coincida con el texto
    public static final Target getOpcionBusqueda(String tipo) {
        return Target.the("Opción " + tipo)
                .locatedBy("//div[contains(@class, 'MuiAutocomplete-option') and contains(text(), '" + tipo + "')]");
    }


    // Dropdown tipo de búsqueda (react-select)
    public static final Target TipoBusquedaDropdown = Target.the("Dropdown tipo de búsqueda")
            .locatedBy("/html/body/div[3]/div[3]/div/div[1]/div/div[2]/div");

    // Input dentro del dropdown para escribir

    // Input del dropdown tipo de búsqueda (usando placeholder)
    public static Target getOpcionReactSelect(String valor) {
        return Target.the("Opción " + valor)
                .locatedBy("(//div[contains(@class, 'option')]//span[contains(text(), '" + valor + "')])[1]");
    }

    // Botón BUSCAR
    public static final Target BtnBuscarModal = Target.the("Botón buscar")
            .locatedBy("//button[contains(@class, 'MuiButton-contained') and contains(., 'BUSCAR')]");
    // Botón CANCELAR
    public static final Target BtnCancelar = Target.the("Botón cancelar")
            .locatedBy("//button[contains(text(), 'CANCELAR')]");

    // Modal
    public static final Target ModalBuscarCliente = Target.the("Modal buscar cliente")
            .locatedBy("//div[contains(text(), 'BUSCAR CLIENTE O CASO DE VENTA')]");
}
