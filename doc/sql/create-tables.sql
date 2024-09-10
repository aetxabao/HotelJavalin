CREATE TABLE reservas_db.usuarios (
        id  bigint(20) NOT NULL AUTO_INCREMENT,
        habitacion int DEFAULT 100,
        nombre varchar(255) DEFAULT '',
        personas int DEFAULT 2,
        pin int DEFAULT 987654321,
        PRIMARY KEY (id)
);
CREATE TABLE reservas_db.salas (
        id  bigint(20) NOT NULL AUTO_INCREMENT,
        nombre varchar(255) DEFAULT '',
        capacidad int DEFAULT 2,
        PRIMARY KEY (id)
);
CREATE TABLE reservas_db.turnos (
        id  bigint(20) NOT NULL AUTO_INCREMENT,
        nombre varchar(255) DEFAULT '',
        hora_inicio varchar(255) DEFAULT '',
        hora_fin varchar(255) DEFAULT '',
        PRIMARY KEY (id)
);
CREATE TABLE reservas_db.reservas (
        id  bigint(20) NOT NULL AUTO_INCREMENT,
        sala_id bigint(20) DEFAULT 0,
        fecha varchar(10) DEFAULT '2024-01-01',
        turno_id bigint(20) DEFAULT 0,
        usuario_id bigint(20) DEFAULT 0,
        PRIMARY KEY (id)
);