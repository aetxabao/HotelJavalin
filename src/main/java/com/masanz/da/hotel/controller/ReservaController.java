package com.masanz.da.hotel.controller;

import com.masanz.da.hotel.dto.Reserva;
import com.masanz.da.hotel.service.ReservaService;
import io.javalin.http.Context;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReservaController {

    private  static ReservaService reservaService = new ReservaService();

    public static void servirReservasUsuario(Context context) {
        Map<String, Object> model = new HashMap<>();
        model.put("usuario", "");
        model.put("habitacion", "");
        model.put("listado", false);
        context.render("/templates/reservas.ftl", model);
    }

    public static void consultarReservasUsuario(Context context) {
        String usuario = null;
        int habitacion = 0;
        try {
//            usuario = request.queryParams("usuario");
            usuario = context.formParam("usuario");
            if (usuario == null || usuario.isEmpty()) {
//                usuario = request.params(":usuario");
                usuario = context.pathParam("usuario");
//                habitacion = Integer.parseInt(request.params(":habitacion"));
                habitacion = Integer.parseInt(context.pathParam("habitacion"));
            }else {
//                habitacion = Integer.parseInt(request.queryParams("habitacion"));
                habitacion = Integer.parseInt(context.formParam("habitacion"));
            }
        }catch (Exception e) {
            System.out.println("Error:\n" + e.getMessage());
//            response.redirect("/error");
            context.redirect("/error");
//            return null;
            return;
        }
        List<Reserva> reservas = reservaService.obtenerReservas(usuario, habitacion);

        Map<String, Object> model = new HashMap<>();
        model.put("usuario", usuario);
        model.put("habitacion", Integer.toString(habitacion));
        model.put("listado", true);
        model.put("reservas", reservas);

        context.render("/templates/reservas.ftl", model);
    }

    public static void servirEliminarReseva(Context context) {
//        long idReserva = Long.parseLong(request.params(":id"));
        long idReserva = Long.parseLong(context.pathParam("id"));
        Map<String, Object> model = new HashMap<>();
        Reserva reserva = reservaService.obtenerReserva(idReserva);
        model.put("eliminar", true);
        model.put("reserva", reserva);
        context.render("/templates/reserva.ftl", model);
    }

    public static void eliminarReserva(Context context) {
//        long idReserva = Long.parseLong(request.params(":id"));
        long idReserva = Long.parseLong(context.pathParam("id"));
//        int pin = Integer.parseInt(request.queryParams("pin"));
        int pin = Integer.parseInt(context.formParam("pin"));
        Reserva reserva = reservaService.eliminarReserva(idReserva, pin);
        if (reserva != null ) {
            context.redirect("/reservas/" +
                    reserva.getUsuario() + "/" + reserva.getHabitacion());
        }else {
            context.redirect("/error");
        }
    }

}
