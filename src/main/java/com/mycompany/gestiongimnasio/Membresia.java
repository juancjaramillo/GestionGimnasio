/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongimnasio;

/**
 *
 * @author ingen
 */
public class Membresia {
    private String tipo;
    private double precio;
    private int duracionMeses;

    public Membresia(String tipo, double precio, int duracionMeses) {
        this.tipo = tipo;
        this.precio = precio;
        this.duracionMeses = duracionMeses;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public String mostrarDetalles() {
        return "Tipo: " + tipo + ", Precio: $" + precio + ", Duración: " + duracionMeses + " meses";
    }
}