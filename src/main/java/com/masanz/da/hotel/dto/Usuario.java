package com.masanz.da.hotel.dto;

public class Usuario {

    private long id;
    private int habitacion;
    private String nombre;
    private int personas;
    private int pin;

    public Usuario(
            long id,
            int habitacion,
            String nombre,
            int personas,
            int pin
    ) {
        this.id = id;
        this.habitacion = habitacion;
        this.nombre = nombre;
        this.personas = personas;
        this.pin = pin;
    }

    public Usuario(int habitacion, String nombre, int personas, int pin) {
        this(0, habitacion, nombre, personas, pin);
    }

    public Usuario() {
        this(0, 0, "", 0, 0);
    }

    //region getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    //endregion


    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", habitacion=" + habitacion +
                ", nombre='" + nombre + '\'' +
                ", personas=" + personas +
                ", pin=" + pin +
                '}';
    }
}
