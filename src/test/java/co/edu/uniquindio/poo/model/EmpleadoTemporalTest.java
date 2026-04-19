/**
 * Clase para probar que el salario de un empleado temporal no sea igual a 0
 * @author Cristian Gallardo
 * @since 2026-04
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
package co.edu.uniquindio.poo.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.logging.Logger;

class EmpleadoTemporalTest {

    private static final Logger LOG = Logger.getLogger(EmpleadoTemporalTest.class.getName());

    //Verificar que el salario neto de un empleado temporal no sea igual a 0.
    @Test
    public void verificarSalarioNetoNoSeaCero() {
        LOG.info("Iniciando prueba para verificar que el empleado temporal no tenga un salario bruto igual a 0");

        EmpleadoTemporal empTemporal = new EmpleadoTemporal(
                "Juanito", "572931", 26, 0, CategoriaEmpleado.JUNIOR,
                4, 4, 10,700000);

        assertNotEquals(0, empTemporal.calcularSalarioNeto());
        LOG.info("Resultado obtenido: " + empTemporal.calcularSalarioNeto());
    }
}
