package co.edu.uniquindio.poo.model;

public class EmpleadoVentas extends Empleado {
    private float totalVentas;
    private float porcentajeComision;

    public EmpleadoVentas(String nombre,String documento, int edad, float salarioBase, CategoriaEmpleado categoria, float salud, float pension, float totalVentas, float porcentajeComision) {
        super(nombre, documento, edad, salarioBase, categoria, salud, pension);


        if (porcentajeComision < 0 || porcentajeComision > 100) {
            throw new IllegalArgumentException("Error el porcentaje no se encuentra en el rango 0-100");
        }

        this.totalVentas = totalVentas;
        this.porcentajeComision = porcentajeComision;
    }

    @Override
    public float calcularSalarioBruto() {
        float comision = totalVentas * (porcentajeComision / 100);
        return salarioBase + calcularBonificacionCategoria() + comision;
    }
}