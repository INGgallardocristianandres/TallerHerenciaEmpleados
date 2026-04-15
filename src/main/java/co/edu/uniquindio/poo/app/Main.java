package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;

import static java.awt.SystemColor.menu;

public class Main {
    public static void main(String[] args) {


        String nombreEmpresa = JOptionPane.showInputDialog("Nombre de la empresa:");
        Empresa empresa = new Empresa(nombreEmpresa);
        int opcion = -1;

        while (opcion != 0) {
            String menu = (" Sistema de nomina") + empresa.getNombre() + " \n" +
                    "1. Registrar Empleado Planta\n" +
                    "2. Registrar Empleado Ventas\n" +
                    "3. Registrar Empleado Temporal\n"+
                    "4. Buscar Empleado\n" +
                    "5. Mostrar Todos los Empleados\n" +
                    "6. Calcular Nómina Total\n" +
                    "7. Ver Empleado con Mayor Salario\n" +
                    "8. Ver Resúmenes de Pago (Records)\n" +
                    "0. Salir\n\n" +
                    "Seleccione una opción:";

            try {
                String input = JOptionPane.showInputDialog(null, menu);
                if (input == null) {
                    opcion = 0;
                    break;
                }
                opcion = Integer.parseInt(input);


                switch (opcion) {
                    case 1:
                        String nombreEmpleadoPlanta = JOptionPane.showInputDialog("Nombre:");
                        String documentoEmpleadoPlanta = JOptionPane.showInputDialog("Documento:");
                        int edadEmpleadoPlanta = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salarioBaseEmpleadoPlanta = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));
                        int categoriaEmpleadoPlanta = Integer.parseInt(JOptionPane.showInputDialog("Categoría (1.Junior, 2.Semi-Senior, 3.Senior):"));
                        CategoriaEmpleado categoriaEmpleadoP = (categoriaEmpleadoPlanta == 1) ? CategoriaEmpleado.JUNIOR : (categoriaEmpleadoPlanta == 2) ? CategoriaEmpleado.SEMI_SENIOR : CategoriaEmpleado.SENIOR;

                        float descuentoSaludPlanta = Float.parseFloat(JOptionPane.showInputDialog("Descuento Salud (%):"));
                        float descuentoPensionPlanta = Float.parseFloat(JOptionPane.showInputDialog("Descuento Pensión (%):"));
                        String cargoEmpleadoPlanta = JOptionPane.showInputDialog("Cargo:");
                        int horasExtraEmpleadoPlanta = Integer.parseInt(JOptionPane.showInputDialog("Horas Extra trabajadas:"));
                        float valorHoraExtraPlanta = Float.parseFloat(JOptionPane.showInputDialog("Valor Hora Extra:"));
                        float auxTransportePlanta = Float.parseFloat(JOptionPane.showInputDialog("Auxilio Transporte:"));

                        EmpleadoPlanta planta = new EmpleadoPlanta(
                                nombreEmpleadoPlanta,
                                documentoEmpleadoPlanta,
                                edadEmpleadoPlanta,
                                salarioBaseEmpleadoPlanta,
                                categoriaEmpleadoP,
                                descuentoSaludPlanta,
                                descuentoPensionPlanta,
                                cargoEmpleadoPlanta,
                                horasExtraEmpleadoPlanta,
                                valorHoraExtraPlanta,
                                auxTransportePlanta
                        );

                        mostrarMensaje(empresa.registrarEmpleado(planta));
                        break;
                    case 2:
                        String nombreEmpleadoVentas = JOptionPane.showInputDialog("Nombre:");
                        String documentoEmpleadoVentas = JOptionPane.showInputDialog("Documento:");
                        int edadEmpleadoVentas = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salarioBaseVentas = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));
                        int categoriaVentas = Integer.parseInt(JOptionPane.showInputDialog("Categoría (1.Junior, 2.Semi-Senior, 3.Senior):"));
                        CategoriaEmpleado categoriaV = (categoriaVentas == 1) ? CategoriaEmpleado.JUNIOR : (categoriaVentas == 2) ? CategoriaEmpleado.SEMI_SENIOR : CategoriaEmpleado.SENIOR;
                        float descuentoSaludVentas = Float.parseFloat(JOptionPane.showInputDialog("Descuento Salud (%):"));
                        float descuentoPensionVentas = Float.parseFloat(JOptionPane.showInputDialog("Descuento Pensión (%):"));
                        float totalVentasMensuales = Float.parseFloat(JOptionPane.showInputDialog("Total Ventas Mensuales:"));
                        float porcentajeComision = Float.parseFloat(JOptionPane.showInputDialog("Porcentaje Comisión :"));

                        EmpleadoVentas ventasEmp = new EmpleadoVentas(
                                nombreEmpleadoVentas,
                                documentoEmpleadoVentas,
                                edadEmpleadoVentas, salarioBaseVentas,
                                categoriaV,
                                descuentoSaludVentas,
                                descuentoPensionVentas,
                                totalVentasMensuales,
                                porcentajeComision
                        );

                        mostrarMensaje(empresa.registrarEmpleado(ventasEmp));
                        break;
                    case 3:
                        String nombreEmpleadoTemporal = JOptionPane.showInputDialog("Nombre:");
                        String documentoEmpleadoTemporal = JOptionPane.showInputDialog("Documento:");
                        int edadEmpleadoTemporal = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                        float salarioBaseTemporal = Float.parseFloat(JOptionPane.showInputDialog("Salario Base:"));
                        int categoriaTemporal = Integer.parseInt(JOptionPane.showInputDialog("Categoría (1.Junior, 2.Semi-Senior, 3.Senior):"));
                        CategoriaEmpleado categoriaT = (categoriaTemporal == 1) ? CategoriaEmpleado.JUNIOR : (categoriaTemporal == 2) ? CategoriaEmpleado.SEMI_SENIOR : CategoriaEmpleado.SENIOR;
                        float descuentoSaludTemporal = Float.parseFloat(JOptionPane.showInputDialog("Descuento Salud (%):"));
                        float descuentoPensionTemporal = Float.parseFloat(JOptionPane.showInputDialog("Descuento Pensión (%):"));
                        int diasTrabajadosEmpleadoTemporal = Integer.parseInt(JOptionPane.showInputDialog("Dias Trabajados : "));
                        float valorDiaEmpleadoTemporal = Float.parseFloat(JOptionPane.showInputDialog("Valor dia: "));
                        EmpleadoTemporal temporalEmp = new EmpleadoTemporal(
                                nombreEmpleadoTemporal,
                                documentoEmpleadoTemporal,
                                edadEmpleadoTemporal,
                                salarioBaseTemporal,
                                categoriaT,
                                descuentoSaludTemporal,
                                diasTrabajadosEmpleadoTemporal,
                                valorDiaEmpleadoTemporal
                        );


                        mostrarMensaje(empresa.registrarEmpleado(temporalEmp));
                        break;


                    case 4:
                        String documentoAbuscar = JOptionPane.showInputDialog("Ingrese el documento a buscar:");
                        co.edu.uniquindio.poo.model.Empleado empleadoEncontrado = empresa.buscarEmpleado(documentoAbuscar);
                        if (empleadoEncontrado != null) {
                            mostrarMensaje("Empleado encontrado:\n" + empleadoEncontrado.generarResumenPago().toString());
                        } else {
                            mostrarMensaje("El empleado con documento " + documentoAbuscar + " no existe.");
                        }
                        break;
                    case 5:
                        empresa.mostrarTodosLosEmpleados();
                        int totalEmpleados = empresa.getListaEmpleados().size();
                        mostrarMensaje("Lista de empleados de la empresa\n" +
                                "Total empleados: " + totalEmpleados + "\n" +
                                "La informacion puede ser detallada completamente en la consola del sistema."); // Se evita sobresaturar las ventanas de el Joption, ya que puede poseer una cantidad elevada de empleados
                        break;
                    case 6:
                        float totalNomina = empresa.calcularNominaTotal();
                        mostrarMensaje("Resumen nomina\n" +
                                "Total a pagar de nómina: " + totalNomina);
                        break;
                    case 7:
                        Empleado empleadoMayorSalario = empresa.obtenerMayorSalarioNeto();
                        if (empleadoMayorSalario != null) {
                            mostrarMensaje("Empleado Con mayor salario\n" +
                                    "Quien más gana es: " + empleadoMayorSalario.getNombre() + "\n" +
                                    "Con un salario de: " + empleadoMayorSalario.calcularSalarioNeto());
                        } else {
                            mostrarMensaje("No hay datos suficientes.");
                        }
                        break;
                    case 8:
                        empresa.ResumenenPagos();
                        mostrarMensaje("Los comprobantes de pago detallados se imprimieron en la consola."); //Para no saturar la ventana
                        break;

                    case 0:
                        mostrarMensaje("Saliendo...");
                        break;

                    default:
                        mostrarMensaje("Opción no válida");
                }
            } catch (Exception e) {
                mostrarMensaje("Error: Ingrese datos válidos.");
            }
        }


    }

    public static void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }
}



