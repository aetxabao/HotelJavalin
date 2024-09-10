package com.masanz.da.hotel;

import com.masanz.da.hotel.controller.MainController;
import com.masanz.da.hotel.controller.ReservaController;
import com.masanz.da.hotel.controller.UsuarioController;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinFreemarker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("ARRANCANDO APLICACION");

        Javalin app = Javalin.create(config -> {
            config.staticFiles.add("/public");
            config.fileRenderer(new JavalinFreemarker());
        }).start(4567);

        app.get("/", MainController::servirIndice);
        app.get("/error", MainController::servirError);

        app.get("/usuarios", UsuarioController::servirUsuarios);
        app.get("/usuario/{id}", UsuarioController::consultarUsuario);
        app.get("/elimina-usuario/{id}", UsuarioController::servirEliminarUsuario);
        app.post("/elimina-usuario/{id}", UsuarioController::eliminarUsuario);
        app.get("/edita-usuario/{id}", UsuarioController::servirEditarUsuario);
        app.post("/edita-usuario/{id}", UsuarioController::editarUsuario);
        app.get("/crea-usuario", UsuarioController::servirCrearUsuario);
        app.post("/crea-usuario", UsuarioController::crearUsuario);

        app.get("/reservas", ReservaController::servirReservasUsuario);
        app.get("/reservas/{usuario}/{habitacion}", ReservaController::consultarReservasUsuario);
        app.post("/reservas", ReservaController::consultarReservasUsuario);
        app.get("/elimina-reserva/{id}", ReservaController::servirEliminarReseva);
        app.post("/elimina-reserva/{id}", ReservaController::eliminarReserva);

    }

}