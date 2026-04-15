package co.edu.uniquindio.poo.model;

public enum CategoriaEmpleado {
    JUNIOR(0.05f),SEMI_SENIOR(0.10f),
    SENIOR(0.15f);

    private final float porcentajeBonificacion;

    CategoriaEmpleado(float porcentaje) {
        this.porcentajeBonificacion = porcentaje;
    }

    public float getPorcentajeBonificacion() {
        return porcentajeBonificacion;
    }
}

