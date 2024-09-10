package com.masanz.da.hotel.service;

import com.masanz.da.hotel.dao.ReservaDao;
import com.masanz.da.hotel.dto.Reserva;

import java.util.List;

public class ReservaService {

    private ReservaDao reservaDao = new ReservaDao();
    public Reserva obtenerReserva(long idReserva) {
            return reservaDao.obtenerReserva(idReserva);
    }

    public Reserva eliminarReserva(long idReserva, int pin) {
        return reservaDao.eliminarReserva(idReserva, pin);
    }

    public List<Reserva> obtenerReservas(String nombreUsuario, int numeroHabitacion) {
        return reservaDao.obtenerReservas(nombreUsuario, numeroHabitacion);
    }

}
