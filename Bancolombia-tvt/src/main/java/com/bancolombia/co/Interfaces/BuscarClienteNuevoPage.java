package com.bancolombia.co.Interfaces;
import net.serenitybdd.screenplay.targets.Target;

public class BuscarClienteNuevoPage {
    // ==================== CAMPO NÚMERO DE CONSULTA ====================
    // TODO: Actualizar este XPath con el valor correcto del modal
    // Intenta uno de estos:
    // //input[@id='identificacion']
    // //input[@placeholder='Ingrese número']
    // //input[contains(@placeholder, 'número')]
    // //input[@type='text'][1]

    public static final Target CampoNumeroConsulta = Target.the("Campo número de consulta")
            .locatedBy("//input");  // Actualiza este XPath

    // ==================== TIPO DE BÚSQUEDA ====================

    public static final Target CampoTipoBusqueda = Target.the("Campo tipo de búsqueda")
            .locatedBy("//input[@id='react-select-2-input']");

    // ==================== BOTÓN BUSCAR ====================

    public static final Target BtnBuscarEnModal = Target.the("Botón buscar en modal")
            .locatedBy("//button[contains(@class, 'MuiButton-containedPrimary') and normalize-space(.)='Buscar']");

    // ==================== DROPDOWN PCRC ====================

    public static final Target DropdownPCRC = Target.the("Dropdown seleccionar PCRC")
            .locatedBy("//input[@id='react-select-3-input']");

    // Opción PCRC dinámica
    public static Target getOpcionPCRC(String valorPCRC) {
        return Target.the("Opción PCRC " + valorPCRC)
                .locatedBy("//div[contains(@class, 'option')]//span[contains(text(), '" + valorPCRC + "')]");
    }

    // ==================== BOTÓN NUEVA VENTA ====================

    public static final Target BtnNuevaVenta = Target.the("Botón nueva venta")
            .locatedBy("//button[contains(., 'Nueva Venta')]");

    // ==================== BOTONES DE NAVEGACIÓN ====================

    public static final Target BtnBuscarClienteHeader = Target.the("Botón buscar cliente en header")
            .locatedBy("//button[contains(., 'Buscar Cliente')]");

    public static final Target BtnCancelar = Target.the("Botón cancelar")
            .locatedBy("//button[contains(text(), 'CANCELAR')]");

    // ==================== MODAL ====================

    public static final Target ModalBuscarCliente = Target.the("Modal buscar cliente")
            .locatedBy("//div[contains(text(), 'BUSCAR CLIENTE O CASO DE VENTA')]");
}

