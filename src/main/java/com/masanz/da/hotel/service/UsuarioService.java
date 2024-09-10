package com.masanz.da.hotel.service;

import com.masanz.da.hotel.dao.UsuarioDao;
import com.masanz.da.hotel.dto.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDao usuarioDao = new UsuarioDao();
    public Usuario obtenerUsuario(long idUsuario) {
        return usuarioDao.obtenerUsuario(idUsuario);
    }

    public Usuario eliminarUsuario(long idUsuario, int pin) {
        return usuarioDao.eliminarUsuario(idUsuario, pin);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.obtenerUsuarios();
    }

    public List<Usuario> obtenerUsuarios(int planta) {
        return usuarioDao.obtenerUsuarios(planta);
    }

}
