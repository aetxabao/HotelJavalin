<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Listado de Usuarios</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css"/>
    <link rel="icon" type="image/x-icon" href="imgs/favicon.ico"/>
</head>
<body>
<h1 id="titulo">Listado de Usuarios</h1>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <#list 1..5 as i>
        <a class="btn" href="${'usuarios?planta=' + i}">Planta ${i}</a>&nbsp;
    </#list>
    <a class="btn" href="/usuarios">Todos</a>
    <a class="btn" href="/crea-usuario">Crear usuario</a>
</div>
<br/><br/>
<div id="usuarios">
    <table>
        <tr>
            <th class="t16">Habitación</th>
            <th class="t40">Nombre</th>
            <th class="t16">Personas</th>
            <th>Editar</th>
            <th>Borrar</th>
        </tr>
        <#list usuarios as usuario>
            <tr>
                <td>${usuario.habitacion}</td>
                <td>${usuario.nombre}</td>
                <td>${usuario.personas}</td>
                <td><a class="btn" href="${'edita-usuario/' + usuario.id}">Editar</a></td>
                <td><a class="btn" href="${'elimina-usuario/' + usuario.id}">Borrar</a></td>
            </tr>
        </#list>
    </table>
</div>
<div>
    <a class="btn" href="/">Volver al inicio</a>
    <a class="btn" href="#titulo">Volver arriba</a>
    <a class="btn" href="/crea-usuario">Crear usuario</a>
</div>
</body>
</html>