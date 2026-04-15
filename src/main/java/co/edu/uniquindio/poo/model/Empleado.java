package co.edu.uniquindio.poo.model;

public abstract class Empleado {
    protected String nombre;
    protected String documento;
    protected int edad;
    protected float salarioBase;
    protected CategoriaEmpleado categoriaEmpleado;
    protected float descuentosSalud;
    protected float descuentoPension;
    private Empresa ownedByEmpresa;

    public Empleado(String nombre, String documento, int edad, float salarioBase, CategoriaEmpleado categoriaEmpleado, float descuentosSalud, float descuentoPension) {
        this.nombre = nombre;
        this.documento = documento;
        this.edad = edad;
        this.salarioBase = salarioBase;
        this.categoriaEmpleado = categoriaEmpleado;
        this.descuentosSalud = descuentosSalud;
        this.descuentoPension = descuentoPension;
    }


    private void validarDatos(float salario, float descuentoSalud, float descuentoPension) {
        if (salario < 0) throw new IllegalArgumentException("El salario tiene que poseer un valor superior");
        if (descuentoSalud < 0 || descuentoSalud > 100 || descuentoPension < 0 || descuentoPension > 100) {
            throw new IllegalArgumentException("Error, el valor del porcentaje excede el rango 0-100.");
        }
    }
        public abstract float calcularSalarioBruto();

        public float calcularBonificacionCategoria() {
            return salarioBase * categoriaEmpleado.getPorcentajeBonificacion();
        }

        public float calcularDescuentos() {
            float totalDescuentoPorcentaje = (descuentosSalud + descuentoPension) / 100;
            return calcularSalarioBruto() * totalDescuentoPorcentaje;
        }

        public float calcularSalarioNeto() {
            return calcularSalarioBruto() - calcularDescuentos();
        }

        public ResumenPago generarResumenPago() {
            return new ResumenPago(
                    documento,
                    nombre,
                    this.getClass().getSimpleName(),
                    calcularSalarioBruto(),
                    calcularDescuentos(),
                    calcularSalarioNeto()
            );
        }

        public void mostrarInformacion() {
            System.out.println(generarResumenPago().toString());
        }

        public String getDocumento() { return documento; }

    public String getNombre() {
        return nombre;
    }
}






