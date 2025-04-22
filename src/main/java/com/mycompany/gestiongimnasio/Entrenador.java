/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongimnasio;

/**
 *
 * @author ingen
 */
public class Entrenador {
    private int id;
    private String nombre;
    private String especialidad;

    public Entrenador(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public int getId() {
        return id;
    }

    public String mostrarInformacion() {
        return "ID: " + id + ", Nombre: " + nombre + ", Especialidad: " + especialidad;
    }

    public String toFileString() {
        return id + "," + nombre + "," + especialidad;
    }
}
