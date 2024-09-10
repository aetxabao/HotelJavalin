package com.masanz.da.hotel.dao;

import com.masanz.da.hotel.database.ConnectionManager;
import com.masanz.da.hotel.dto.Reserva;

import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    public ReservaDao(){
        ConnectionManager.conectar(
                "reservas_db",
                "proy",
                "password");
    }

    public Reserva obtenerReserva(long idReserva) {
        String sql = "SELECT r.id, s.nombre, r.fecha, t.nombre, u.nombre, u.habitacion, u.pin " +
                "FROM reservas r, salas s, turnos t, usuarios u " +
                "WHERE r.sala_id = s.id AND r.turno_id = t.id AND r.usuario_id = u.id " +
                "AND r.id = ? ";
        Object[] params = {idReserva};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        Reserva reserva = null;
        if (resultado != null) {
            reserva = new Reserva();
            reserva.setId((Long)resultado[0][0]);
            reserva.setSala((String)resultado[0][1]);
            reserva.setFecha((String)resultado[0][2]);
            reserva.setTurno((String)resultado[0][3]);
            reserva.setUsuario((String)resultado[0][4]);
            reserva.setHabitacion((Integer)resultado[0][5]);
            reserva.setPin((Integer)resultado[0][6]);
        }
        return reserva;
    }

    public Reserva eliminarReserva(long idReserva, int pin) {
        Reserva reserva = obtenerReserva(idReserva);
        if (reserva == null || reserva.getPin() != pin) {
            return null;
        }
        String sql = "DELETE FROM reservas WHERE id = ?";
        Object[] params = {idReserva};
        if (ConnectionManager.ejecutarUpdateSQL(sql, params) == 1) {
            return reserva;
        } else {
            return null;
        }
    }

    public List<Reserva> obtenerReservas(String nombreUsuario, int numeroHabitacion) {
        String sql = "SELECT r.id, s.nombre, r.fecha, t.nombre, u.nombre, u.habitacion, u.pin " +
                "FROM reservas_db.reservas r, reservas_db.salas s, reservas_db.turnos t, reservas_db.usuarios u " +
                "WHERE r.sala_id = s.id AND r.turno_id = t.id AND r.usuario_id = u.id " +
                "AND u.nombre = ? AND  u.habitacion = ? " +
                "ORDER BY r.fecha DESC, t.nombre ASC";
        Object[] params = {nombreUsuario, numeroHabitacion};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Reserva> reservas = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Reserva reserva = new Reserva();
                reserva.setId((Long)fila[0]);
                reserva.setSala((String)fila[1]);
                reserva.setFecha((String)fila[2]);
                reserva.setTurno((String)fila[3]);
                reserva.setUsuario((String)fila[4]);
                reserva.setHabitacion((Integer)fila[5]);
                reserva.setPin((Integer)fila[6]);
                reservas.add(reserva);
            }
        }
        return reservas;
    }

}
