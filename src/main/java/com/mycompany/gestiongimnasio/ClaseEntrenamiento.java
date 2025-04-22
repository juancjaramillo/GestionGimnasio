/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestiongimnasio;

/**
 *
 * @author ingen
 */
public class ClaseEntrenamiento {
    private String nombreClase;
    private int duracionMinutos;
    private Entrenador entrenador;

    public ClaseEntrenamiento(String nombreClase, int duracionMinutos, Entrenador entrenador) {
        this.nombreClase = nombreClase;
        this.duracionMinutos = duracionMinutos;
        this.entrenador = entrenador;
    }

    public String mostrarInformacion() {
        return "Clase: " + nombreClase + " (" + duracionMinutos + " min)\n"
             + "Entrenador: " + entrenador.mostrarInformacion();
    }

    public String toFileString() {
        return nombreClase + "," + duracionMinutos + "," + entrenador.toFileString();
    }
}
