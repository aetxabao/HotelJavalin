package com.masanz.da.hotel.dao;

import com.masanz.da.hotel.database.ConnectionManager;
import com.masanz.da.hotel.dto.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {
    public UsuarioDao(){
        ConnectionManager.conectar(
                "reservas_db",
                "proy",
                "password");
    }

    public Usuario obtenerUsuario(long idUsuario) {
        String sql = "SELECT id, habitacion, nombre, personas, pin FROM usuarios WHERE id = ?";
        Object[] params = {idUsuario};
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        Usuario usuario = null;
        if (resultado != null) {
            usuario = new Usuario();
            usuario.setId((Long)resultado[0][0]);
            usuario.setHabitacion((Integer)resultado[0][1]);
            usuario.setNombre((String)resultado[0][2]);
            usuario.setPersonas((Integer)resultado[0][3]);
            usuario.setPin((Integer)resultado[0][4]);
        }
        return usuario;
    }

    public Usuario eliminarUsuario(long idUsuario, int pin) {
        Usuario usuario = obtenerUsuario(idUsuario);
        if (usuario == null || usuario.getPin() != pin) {
            return null;
        }
        String sql = "DELETE FROM usuarios WHERE id = ?";
        Object[] params = {idUsuario};
        if (ConnectionManager.ejecutarUpdateSQL(sql, params) == 1) {
            return usuario;
        } else {
            return null;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        String sql = "SELECT id, habitacion, nombre, personas, pin " +
                "FROM usuarios ORDER BY habitacion ASC";
        Object[] params = {};
        return obtenerUsuarios(sql, params);
    }

    public List<Usuario> obtenerUsuarios(int planta) {
        String sql = "SELECT id, habitacion, nombre, personas, pin " +
                "FROM usuarios WHERE LEFT(habitacion, 1) = ? " +
                "ORDER BY habitacion ASC";
        Object[] params = {planta};
        return obtenerUsuarios(sql, params);
    }

    private List<Usuario> obtenerUsuarios(String sql, Object[] params) {
        Object[][] resultado = ConnectionManager.ejecutarSelectSQL(sql, params);
        List<Usuario> usuarios = new ArrayList<>();
        if (resultado != null) {
            for (Object[] fila : resultado) {
                Usuario usuario = new Usuario();
                usuario.setId((Long)fila[0]);
                usuario.setHabitacion((Integer)fila[1]);
                usuario.setNombre((String)fila[2]);
                usuario.setPersonas((Integer)fila[3]);
                usuario.setPin((Integer)fila[4]);
                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

}
