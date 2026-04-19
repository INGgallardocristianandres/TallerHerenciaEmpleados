package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Empleado> listaEmpleados;

    public Empresa(String nombre){
        this.nombre = nombre;
        this.listaEmpleados = new ArrayList<>();
    }

    //Crud Empleado
    public Empleado buscarEmpleado(String documento) {
        for (Empleado empleado : listaEmpleados) {
            if (empleado.getDocumento().equals(documento)) {
                return empleado;
            }
        }
        return null;
    }

    public String registrarEmpleado(Empleado nuevoEmpleado) {
        if (buscarEmpleado(nuevoEmpleado.getDocumento()) != null) {
            return "Error: El empleado ya se encuentra registrado.";
        }
        listaEmpleados.add(nuevoEmpleado);
        return "Empleado registrado exitosamente.";
    }
    public void mostrarTodosLosEmpleados() {
        System.out.println("Lista Empleados");
        if (listaEmpleados.isEmpty()) {
            System.out.println("Lista vacia, agregar empleados primero.");
        } else {
            for (Empleado empleado : listaEmpleados) {
                empleado.mostrarInformacion();
            }
        }
    }
    public float calcularNominaTotal() {
        float acumulador = 0;
        for (Empleado empleado : listaEmpleados) {
            acumulador += empleado.calcularSalarioNeto();
        }
        return acumulador;
    }
    public Empleado obtenerMayorSalarioNeto() {
        Empleado empleadoMayorSalario = null;
        for (Empleado empleado : listaEmpleados) {
            if (empleadoMayorSalario == null) {
                empleadoMayorSalario = empleado;
            } else {
                if (empleado.calcularSalarioNeto() > empleadoMayorSalario.calcularSalarioNeto()) {
                    empleadoMayorSalario = empleado;
                }
            }
        }
        return empleadoMayorSalario;
    }
    public void ResumenenPagos() {
        System.out.println("Resumen de pago");
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.generarResumenPago().toString());
        }
    }

    public String getNombre() {
        return nombre;
    }


    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public ArrayList<Empleado> obtenerEmpleadosMayorSalarioNeto(double valor) {
        ArrayList<Empleado> listaEmpleadosMayoresSalarios = new ArrayList<>();
        for (Empleado empleado : listaEmpleados) {
            if (empleado.calcularSalarioNeto() > valor) {

                listaEmpleadosMayoresSalarios.add(empleado);
            }
        }
        return listaEmpleadosMayoresSalarios;
    }
    public List<EmpleadoTemporal> obtenerEmpleadosTemporales100Horas(int diasTrabajados){
    List<EmpleadoTemporal> listaEmpleados100Horas = new ArrayList<>();
    for(Empleado empleado : listaEmpleados)
    if(empleado instanceof EmpleadoTemporal){
        EmpleadoTemporal temporal = (EmpleadoTemporal) empleado;
        if (temporal.getDiasTrabajados() > diasTrabajados) {
            listaEmpleados100Horas.add(temporal);
        }
    }
    return listaEmpleados100Horas;
    }
}

