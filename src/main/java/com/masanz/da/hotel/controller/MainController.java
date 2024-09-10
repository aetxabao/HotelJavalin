package com.masanz.da.hotel.controller;

import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

public class MainController {

    public static void servirIndice(Context context) {
        Map<String, Object> model = new HashMap<>();
        model.put("titulo", "Hotel Javalin");
        context.render("/templates/index.ftl", model);
    }

    public static void servirError(Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("/templates/error.ftl", model);
    }

}
