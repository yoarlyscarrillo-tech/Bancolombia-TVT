package StepDefinitions;

import com.bancolombia.co.Tareas.*;
import com.bancolombia.co.Utilidades.DatosClienteNuevo;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;

public class BuscarClienteNuevoStep {
    private Actor actor = LoginStep.actor;


    @Cuando("Buscamos cliente no existente numero de consulta y Número de identificación")
    public void buscamosClienteNoExistenteNumeroDeConsultaYNúmeroDeIdentificación() {
        System.out.println("\n🔍 BUSCANDO CLIENTE (PARA CREAR VENTA NUEVA)");

        // Leer valores desde locators.properties
        String numeroCliente = DatosClienteNuevo.obtener("cliente.numero.identificacion");
        String tipoBusqueda = DatosClienteNuevo.obtener("cliente.tipo.busqueda");

        System.out.println("   Número: " + numeroCliente);
        System.out.println("   Tipo: " + tipoBusqueda);

        // Validar que los datos no estén vacíos
        if (numeroCliente.isEmpty() || tipoBusqueda.isEmpty()) {
            throw new IllegalArgumentException("❌ Datos incompletos en locators.properties");
        }

        // Ejecutar búsqueda SIN VALIDAR que aparezca en tabla
        // Solo buscamos para poder seleccionar PCRC y crear nueva venta
        actor.attemptsTo(
                BuscarClienteSinValidarTask.conDocumentoYTipo(numeroCliente, tipoBusqueda)
        );

        System.out.println("✅ Cliente buscado\n");
    }

    @Y("seleccionamos PCRC y creamos nueva venta")
    public void seleccionamosPCRCYCreamosNuevaVenta() {
        System.out.println("\n🎯 SELECCIONANDO PCRC Y CREANDO NUEVA VENTA");

        // Leer valor PCRC desde properties
        String pcrcValor = DatosClienteNuevo.obtener("cliente.pcrc");
        System.out.println("📋 PCRC a seleccionar: " + pcrcValor);

        if (pcrcValor.isEmpty()) {
            throw new IllegalArgumentException("❌ ERROR: cliente.pcrc está VACÍO en locators.properties");
        }

        // PASO 1: Seleccionar PCRC
        System.out.println("\n→ PASO 1: Seleccionando PCRC...");
        actor.attemptsTo(
                SeleccionarPCRCTask.conValorDelProperties()
        );
        System.out.println("✅ PCRC seleccionado: " + pcrcValor);

        // PASO 2: Crear nueva venta
        System.out.println("\n→ PASO 2: Creando nueva venta...");
        actor.attemptsTo(
                SeleccionarPCRCYNuevaVentaTask.paraCrearNuevoCliente()
        );
        System.out.println("✅ NUEVA VENTA creada exitosamente\n");
    }
}
