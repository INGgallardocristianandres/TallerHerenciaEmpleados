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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmpresaTest {
    private static final Logger LOG = Logger.getLogger(EmpresaTest.class.getName());

    //Verificar que los empleados almacenados en la empresa sean los correctos.
    @Test
    public void verificarAlmacenamientoEmpleados() {
        LOG.info("Iniciando prueba para verificar almacenamiento adecuado de empleados");
        Empresa empresa = new Empresa("Empresa prueba");
        EmpleadoPlanta planta = new EmpleadoPlanta("Andres", "11111", 30, 4000000,
                CategoriaEmpleado.SENIOR, 4, 4, "Desarrollador", 0, 0, 0);

        EmpleadoVentas ventas = new EmpleadoVentas("Maria", "22222", 21, 1000000,
                CategoriaEmpleado.JUNIOR, 4, 4, 5000000, 5);
        empresa.registrarEmpleado(planta);
        empresa.registrarEmpleado(ventas);
        assertEquals(2, empresa.getListaEmpleados().size());
        Empleado buscado = empresa.buscarEmpleado("11111");
        Empleado buscado2 = empresa.buscarEmpleado("22222");
        assertNotNull(buscado);
        assertEquals("Andres", buscado.getNombre());
        assertEquals("11111", buscado.getDocumento());
        assertEquals("Maria", buscado2.getNombre());
        assertEquals("22222", buscado2.getDocumento());
        assertTrue(empresa.getListaEmpleados().contains(planta));
        assertTrue(empresa.getListaEmpleados().contains(ventas));

        LOG.info("Prueba terminada los empleados se almacenan y recuperan correctamente.");
    }

    @Test
    public void verificarBusquedaInexistenteRetornaNull() {
        LOG.info("Iniciando prueba para buscar empleado inexistente y que retorne un null");
        Empresa empresa = new Empresa("Empresa de Prueba");
        Empleado resultado = empresa.buscarEmpleado("9999");
        assertNull(resultado);

        LOG.info("Prueba superada el sistema retorna null correctamente.");
    }

    @Test
    public void verificarObtenerEmpleadosMayorSalarioNeto() {
        LOG.info("Iniciando prueba para verificar que la lista de empleados con un salario neto mayor al indicado este correcta");
        Empresa empresa = new Empresa("Empresa Prueba");

        EmpleadoVentas emp1 = new EmpleadoVentas("Carlos", "111", 25, 1000000,
                CategoriaEmpleado.JUNIOR, 4, 4, 0, 0);
        EmpleadoVentas emp2 = new EmpleadoVentas("Ana", "222", 30, 5000000,
                CategoriaEmpleado.JUNIOR, 4, 4, 0, 0);
        EmpleadoVentas emp3 = new EmpleadoVentas("Beatriz", "333", 28, 6000000,
                CategoriaEmpleado.JUNIOR, 4, 4, 0, 0);

        empresa.registrarEmpleado(emp1);
        empresa.registrarEmpleado(emp2);
        empresa.registrarEmpleado(emp3);

        java.util.ArrayList<Empleado> listaEsperada = new java.util.ArrayList<>();
        listaEsperada.add(emp2);
        listaEsperada.add(emp3);

        java.util.ArrayList<Empleado> listaObtenida = empresa.obtenerEmpleadosMayorSalarioNeto(2000000);
        assertIterableEquals(listaEsperada, listaObtenida);

        LOG.info("Prueba superada y verificada correctamente.");
    }
    @Test
    public void buscarEmpleado() {
        LOG.info("Iniciando prueba para que el metodo buscarEmpleado retorne un null si el documento es inexistente");
        Empresa empresa = new Empresa("Empresa prueba");
        empresa.registrarEmpleado(new EmpleadoVentas("Juan","1111",27,2000000,CategoriaEmpleado.JUNIOR,5 , 5,2,10));
        empresa.registrarEmpleado(new EmpleadoVentas("Jose","1112",28,5000000,CategoriaEmpleado.JUNIOR,5 , 10,15,10));
Empleado empleadoBuscado = empresa.buscarEmpleado("1113");
assertNull(empleadoBuscado);
LOG.info("Prueba finalizada con exito, el documento buscado no existe");
    }

    @Test
    void validarEmpleadosMismoDocumento() {
        LOG.info("Iniciando prueba para que se valide que la empresa no pueda agregar empleados con el mismo documento varias veces");
        Empresa empresa = new Empresa("Empresa prueba");
        empresa.registrarEmpleado(new EmpleadoVentas("Juan","1111",27,2000000,CategoriaEmpleado.JUNIOR,5 , 5,2,10));
        empresa.registrarEmpleado(new EmpleadoVentas("Jose","1111",28,5000000,CategoriaEmpleado.JUNIOR,5 , 10,15,10));
assertEquals(1, empresa.getListaEmpleados().size());
assertEquals("Juan",empresa.getListaEmpleados().get(0).getNombre());
LOG.info("Prueba finalizada, la empresa no permite que se agreguen dos empleados iguales");
    }

    @Test
    void verificarMetodoObtenerMayorSalario() {
        LOG.info("Iniciando prueba para verificar que el metodo de obtener el empleado con el mayor salario funcione correctamente");
        Empresa empresa = new Empresa("Empresa prueba");
        empresa.registrarEmpleado(new EmpleadoVentas("Juan","1111",27,2000000,CategoriaEmpleado.JUNIOR,5 , 5,2,10));
        empresa.registrarEmpleado(new EmpleadoVentas("Jose","1112",28,5000000,CategoriaEmpleado.JUNIOR,5 , 10,15,10));
        empresa.registrarEmpleado(new EmpleadoVentas("Pedro","1113",28,4000000,CategoriaEmpleado.JUNIOR,5 , 10,15,10));
Empleado empleado = empresa.obtenerMayorSalarioNeto();
assertEquals("Jose",empleado.getNombre());
LOG.info("Prueba finalizada para el metodo, funciona correctamente");
    }
    @Test
    void verificarListaEmpleados100Horas(){
        LOG.info("Iniciando prueba para verificar que la lista de empleados con mas de 100 horas trabajadas funcione correctamente");
        Empresa empresa = new Empresa("Empresa prueba");
        empresa.registrarEmpleado(new EmpleadoPlanta("Juan", "111",27,2500000,CategoriaEmpleado.JUNIOR,5,7,"Desarrollador",
                10,30000, 200000));
        empresa.registrarEmpleado(new EmpleadoTemporal("Pedro","1112",29,200000,CategoriaEmpleado.JUNIOR,8,9,6,20000));
        empresa.registrarEmpleado(new EmpleadoTemporal("Joshua","1113",34,200000,CategoriaEmpleado.JUNIOR,8,9,10,20000));
        List<EmpleadoTemporal> resultado = empresa.obtenerEmpleadosTemporales100Horas(5);
        assertEquals(2, resultado.size());
        assertEquals("Pedro", resultado.get(0).getNombre());
        assertEquals("Joshua", resultado.get(1).getNombre());

        LOG.info("Prueba finalizada con éxito, solo se agregan los empleados que cumplan con mas de 100 horas trabajadas o mas de 5 dias.");
    }
    @Test
    void verificarSalarioNetoMayorAlBase(){
        LOG.info("Iniciando prueba para verificar que el salario neto sea mayor al salario base de un empleado cualquiera");
        Empresa empresa = new Empresa("Empresa prueba");
        EmpleadoPlanta empleadoPlanta= new EmpleadoPlanta("Carlos", "1111",20,2000000,CategoriaEmpleado.SENIOR,5,5,"Programador",10,20000,150000);
        empresa.registrarEmpleado(empleadoPlanta);
        Empleado empleadoBuscado = empresa.buscarEmpleado("1111");
        double salarioNeto = empleadoBuscado.calcularSalarioNeto();
        assertTrue(salarioNeto>empleadoBuscado.salarioBase);
        LOG.info("Prueba finalizada, el salario neto del empleado es mayor que su salario base");
    }
    @Test
    void verificarSalarioNetoTemporalMayoraCero(){
        LOG.info("Iniciando prueba para verificar que el salario de un empleado temporal sea mayor a cero siempre y cuando los dias trabajados y el valor del dia sea valido");
        Empresa empresa = new Empresa("Empresa prueba");
        EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal("Juan","1111",19,1500000,CategoriaEmpleado.JUNIOR,4,5,1,1000);
        empresa.registrarEmpleado(empleadoTemporal);
        double Neto = empleadoTemporal.calcularSalarioNeto();
        assertTrue(Neto> 0);
        LOG.info("Prueba finalizada, el salario neto es mayor a cero");
    }
    }





