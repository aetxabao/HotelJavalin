<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Reserva</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico"/>
</head>
<body>
<#if eliminar>
    <h1>Eliminar la Reserva</h1>
<#else>
    <h1>Vista de la Reserva</h1>
</#if>
<a class="btn" href="${'/reservas-usuario/' + reserva.usuario + '/' + reserva.habitacion}">Volver a la lista</a>
<br/><br/>
<table>
    <tr>
        <th>Habitación</th>
        <td>${reserva.habitacion}</td>
    </tr>
    <tr>
        <th>Nombre</th>
        <td>${reserva.usuario}</td>
    </tr>
    <tr>
        <th>Fecha</th>
        <td>${reserva.fecha}</td>
    </tr>
    <tr>
        <th>Comida</th>
        <td>${reserva.turno}</td>
    </tr>
    <tr>
        <th>Restaurante</th>
        <td>${reserva.sala}</td>
    </tr>
</table>
<br/><br/>

<#if eliminar>
    <form action="${'/elimina-reserva/' + reserva.id}" method="POST">
        Introduzca el PIN de 9 dígitos del usuario
        <input type="tel" name="pin" pattern="[0-9]{9}" required="required"/>
        <input type="submit" value="Confirmar" />
    </form>
<#else>
    <div>
        <a href="${'/elimina-reserva/' + reserva.id}">Eliminar</a>
    </div>
</#if>

</body>
</html>