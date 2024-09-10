<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Listado de Reservas</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico"/>
</head>
<body>
<h1>Listado de Reservas</h1>

<form action="/reservas" method="POST">
        <input type="text" name="usuario" value="${usuario}"
               placeholder="nombre de usuario" required="required"/>
        de la habitación
        <input type="number" name="habitacion" value="${habitacion}"
               placeholder="núm." pattern="[0-9]{3}" required="required"/>
        <input type="submit" value="Consultar" />
</form>

<#if listado>
    <div>
        <table id="reservas">
            <tr>
                <th class="t16">Fecha</th>
                <th class="t40">Turno</th>
                <th class="t24">Restaurante</th>
                <th class="t16">Eliminar</th>
            </tr>

            <#list reservas as reserva>
                <tr>
                    <td>${reserva.fecha}</td>
                    <td>${reserva.turno}</td>
                    <td>${reserva.sala}</td>
                    <td><a class="btn" href="${'/elimina-reserva/' + reserva.id}">Borrar</a></td>
                </tr>
            </#list>

        </table>
    </div>
</#if>
<div>
    <a class="btn" href="/">Volver al inicio</a>
</div>
</body>
</html>