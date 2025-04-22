/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongimnasio;

/**
 *
 * @author ingen
 */
public class Cliente {
    private int id;
    private String nombre;
    private int edad;
    private double peso;
    private Membresia membresia;

    public Cliente(int id, String nombre, int edad, double peso, Membresia membresia) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.membresia = membresia;
    }

    public int getId() {
        return id;
    }

    public String mostrarInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + ", Edad: " + edad + ", Peso: " + peso + " kg\n"
             + "Membresía: " + membresia.mostrarDetalles();
    }

    public String toFileString() {
        return id + "," + nombre + "," + edad + "," + peso + "," 
             + membresia.getTipo() + "," + membresia.getPrecio() + "," + membresia.getDuracionMeses();
    }
}
