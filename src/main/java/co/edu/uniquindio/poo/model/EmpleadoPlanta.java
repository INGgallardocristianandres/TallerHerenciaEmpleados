package co.edu.uniquindio.poo.model;

public class EmpleadoPlanta extends Empleado {
    private String cargo;
    private int horasExtra;
    private float valorHoraExtra;
    private float auxilioTransporte;

    public EmpleadoPlanta(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoriaEmpleado, float descuentosSalud, float descuentoPension, String cargo, int horasExtra, float valorHoraExtra, float auxilioTransporte) {


        super(nombre, documento, edad, salarioBase, categoriaEmpleado, descuentosSalud, descuentoPension);
        if (horasExtra < 0) throw new IllegalArgumentException("Error, ingrese un valor adecuado de horas extra");
        if (valorHoraExtra < 0) throw new IllegalArgumentException("Error, ingrese un valor de hora extra adecuado");
        this.cargo = cargo;
        this.horasExtra = horasExtra;
        this.valorHoraExtra = valorHoraExtra;
        this.auxilioTransporte = auxilioTransporte;
    }
    @Override
    public float calcularSalarioBruto(){
        return salarioBase + calcularBonificacionCategoria() + (horasExtra * valorHoraExtra) + auxilioTransporte;
    }

}


