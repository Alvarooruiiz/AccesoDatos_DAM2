package org.example.Entity;

import jakarta.persistence.Entity;

import java.io.Serializable;

@Entity
public class CuentaDebito extends Cuenta implements Serializable {
    private double cargoPorDescubierto;

    public double getCargoPorDescubierto() {
        return cargoPorDescubierto;
    }

    public void setCargoPorDescubierto(double cargoPorDescubierto) {
        this.cargoPorDescubierto = cargoPorDescubierto;
    }
}