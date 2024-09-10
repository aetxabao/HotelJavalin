SELECT r.id, s.nombre, r.fecha, t.nombre, u.nombre, u.habitacion, u.pin
FROM reservas_db.reservas r, reservas_db.salas s, reservas_db.turnos t, reservas_db.usuarios u
WHERE r.sala_id = s.id AND r.turno_id = t.id AND r.usuario_id = u.id
AND r.id = ?;

DELETE FROM reservas_db.reserva WHERE id = ?;

SELECT r.id, s.nombre, r.fecha, t.nombre, u.nombre, u.habitacion, u.pin
FROM reservas_db.reservas r, reservas_db.salas s, reservas_db.turnos t, reservas_db.usuarios u
WHERE r.sala_id = s.id AND r.turno_id = t.id AND r.usuario_id = u.id
AND u.nombre = ? AND  u.habitacion = ?
ORDER BY r.fecha DESC, t.nombre ASC;