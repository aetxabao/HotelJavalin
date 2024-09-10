package com.masanz.da.hotel.dto;

public class Reserva {

    private long id;
    private String sala;
    private String fecha;
    private String turno;
    private String usuario;
    private int habitacion;
    private int pin;


    public Reserva() {
        this(0, "", "","", "",0, 0);
    }

    public Reserva(int id, String sala, String fecha, String turno, String usuario, int habitacion, int pin) {
        this.id = id;
        this.sala = sala;
        this.fecha = fecha;
        this.turno = turno;
        this.usuario = usuario;
        this.habitacion = habitacion;
        this.pin = pin;
    }

    public Reserva(String sala, String fecha, String turno, String usuario, int habitacion, int pin) {
        this(0, sala, fecha, turno, usuario, habitacion, pin);
    }

    //region getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
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
        return "Reserva{" +
                "id=" + id +
                ", sala='" + sala + '\'' +
                ", fecha='" + fecha + '\'' +
                ", turno='" + turno + '\'' +
                ", usuario='" + usuario + '\'' +
                ", pin=" + pin +
                '}';
    }

}
