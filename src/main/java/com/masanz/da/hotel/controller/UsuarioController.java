package com.masanz.da.hotel.controller;

import com.masanz.da.hotel.dto.Reserva;
import com.masanz.da.hotel.dto.Usuario;
import com.masanz.da.hotel.service.UsuarioService;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UsuarioController {

    private  static UsuarioService usuarioService = new UsuarioService();

    public static void servirUsuarios(Context context) {
        int planta = 0;
        try {
            planta = Integer.parseInt(context.queryParam("planta"));
        }catch (Exception e) {
        }
        List<Usuario> usuarios = new ArrayList<>();
        if (planta==0) {
            usuarios = usuarioService.obtenerUsuarios();
        }else {
            usuarios = usuarioService.obtenerUsuarios(planta);
        }

        Map<String, Object> model = new HashMap<>();
        model.put("usuarios", usuarios);

        context.render("/templates/usuarios.ftl", model);
    }

    public static void consultarUsuario(Context context) {
    }

    public static void servirEliminarUsuario(Context context) {
    }

    public static void eliminarUsuario(Context context) {
    }

    public static void servirCrearUsuario(Context context) {
        Map<String, Object> model = new HashMap<>();
        Usuario usuario = new Usuario();
        model.put("agregar", true);
        model.put("usuario", usuario);
        context.render("/templates/usuario-form.ftl", model);
    }

    public static void crearUsuario(Context context) {
    }

    public static void servirEditarUsuario(Context context) {
        long id = Long.parseLong(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Usuario usuario = usuarioService.obtenerUsuario(id);
        model.put("agregar", false);
        model.put("usuario", usuario);
        if (usuario.getId() == 0) {
            context.redirect("/error");
        }else {
            context.render("/templates/usuario-form.ftl");
        }
    }

    public static void editarUsuario(Context context) {
    }

}
