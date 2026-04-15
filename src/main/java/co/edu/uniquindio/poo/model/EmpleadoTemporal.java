package co.edu.uniquindio.poo.model;

public class EmpleadoTemporal extends Empleado {
    private int diasTrabajados;
    private float valorDia;

    public EmpleadoTemporal(String nombre, String documento, int edad, float salarioBase,
                            CategoriaEmpleado categoria, float salud, float pension,
                            float valorDia) {
        super(nombre, documento, edad, salarioBase, categoria, salud, pension);


        if (diasTrabajados < 0) throw new IllegalArgumentException("Error los días trabajados deben ser superiores a 0");
        if (valorDia < 0) throw new IllegalArgumentException("Error el valor del dia debe ser positivo");

        this.diasTrabajados = diasTrabajados;
        this.valorDia = valorDia;
    }

    @Override
    public float calcularSalarioBruto() {
        float pagoDias = diasTrabajados * valorDia;
        return pagoDias + calcularBonificacionCategoria();
    }
}
