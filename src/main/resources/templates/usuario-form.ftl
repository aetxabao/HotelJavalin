<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title><#if agregar>Crear Usuario<#else>Editar Usuario</#if></title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
<h1><#if agregar>Crear Usuario<#else>Editar Usuario</#if></h1>
<a class="btn" href="/usuarios">Regresar al listado</a>
<br/><br/>

<#if agregar>
    <#assign accion>/crea-usuario</#assign>
    <#assign texto>Crear</#assign>
<#else>
    <#assign accion>${'/edita-usuario/' + usuario.id}</#assign>
    <#assign texto>Guardar</#assign>
</#if>
<form action="${accion}" method="POST">
    <div class="container">
        <label for="habitacion">Habitación</label>
        <input type="number" name="habitacion" value="${usuario.habitacion}"/>
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre" value="${usuario.nombre}"/>
        <label for="personas">Personas</label>
        <input type="number" name="personas" value="${usuario.personas}"/>
        <label for="pin">PIN</label>
        <input type="number" name="pin" value="${usuario.pin}"/>
    </div>
    <input type="submit" value="${texto}" />
</form>

</body>
</html>