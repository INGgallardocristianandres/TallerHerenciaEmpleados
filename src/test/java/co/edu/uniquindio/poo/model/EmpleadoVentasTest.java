/**
 * Clase para probar que el salario bruto de un empleado de ventas se calcule correctamente
 * @author Cristian Gallardo
 * @since 2026-04
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */
package co.edu.uniquindio.poo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.logging.Logger;
public class EmpleadoVentasTest {
    /**
     * Instancia para el manejo de logs (el diario de la prueba)
     */
    private static final Logger LOG = Logger.getLogger(EmpleadoVentasTest.class.getName());

    @Test
    //Verificar que el salario bruto de un empleado de ventas se calcule correctamente
    public void validarSalarioBruto() {
        LOG.info("Iniciando prueba de salario bruto para el empleado de ventas");

        EmpleadoVentas empVentas = new EmpleadoVentas("Pepito", "1234567", 35, 1000000,
                CategoriaEmpleado.JUNIOR, 4, 4, 2000000, 5);

        assertEquals(1150000, empVentas.calcularSalarioBruto());

        LOG.info("Prueba finalizada con éxito para empleado de ventas");
    }

    @Test
    //Verificar que la bonificación de un empleado JUNIOR sea mayor que 0.
    public void verificarBonificacionJunior() {
        LOG.info("Iniciando prueba para verificar que la bonificacion de los empleados Junior sea mayor a 0");
        Empleado empleadoVentas = new EmpleadoVentas("Juan", "2020", 19, 100000, CategoriaEmpleado.JUNIOR, 5, 5, 20, 50);
        float bonificacionJunior = empleadoVentas.calcularBonificacionCategoria();
        assertTrue(bonificacionJunior > 0);
        LOG.info("Prueba finalizada, se cumplio con exito");
    }

    @Test
    public void verificarSalarioNetoNoNegativo() {
        LOG.info("Iniciando prueba para verificar que el salario neto nunca sea negativo");
        EmpleadoVentas empVentas = new EmpleadoVentas("Joselito", "2222", 28, 1000000, CategoriaEmpleado.JUNIOR, 5, 5, 0, 0);
        float salarioNeto = empVentas.calcularSalarioNeto();
        assertTrue(salarioNeto >= 0);

        LOG.info("Resultado obtenido: " + salarioNeto);
    }

    @Test
    public void validarExcepcionSalarioNegativo() {
        LOG.info("Iniciando prueba: Validar que el constructor rechace salarios negativos");
        assertThrows(IllegalArgumentException.class, () -> {
            new EmpleadoVentas("Juan", "98545", 25, -100000,
                    CategoriaEmpleado.JUNIOR, 4, 4, 0, 0);
        });
        LOG.info("Prueba superada la excepcion no permite salarios negativos");
    }
}


