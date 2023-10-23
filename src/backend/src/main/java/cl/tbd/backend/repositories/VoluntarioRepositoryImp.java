package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Voluntario;

@Repository
public class VoluntarioRepositoryImp implements VoluntarioRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Voluntario> getAllVoluntarios() {
        String sql = "SELECT * FROM voluntario";
        List<Voluntario> listaVoluntarios;

        try (Connection conn = sql2o.open()) {
            listaVoluntarios = conn.createQuery(sql).executeAndFetch(Voluntario.class);
            
            return listaVoluntarios;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los voluntarios", e);
        }
    }

    @Override
    public Voluntario getVoluntarioById(Long id) {
        String sql = "SELECT * FROM voluntario WHERE id_voluntario = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Voluntario.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el voluntario por ID", e);
        }
    }
    @Override
    public void createVoluntario(Voluntario voluntario) {
        String sql = "INSERT INTO voluntario (nombre_voluntario, apellido_voluntario, telefono_voluntario, " +
                "direccion_voluntario, fecha_nacimiento_voluntario, disponibilidad_voluntario," +
                "password_voluntario, email_voluntario) " +
                "VALUES (:nombre_voluntario, :apellido_voluntario, :telefono_voluntario, :direccion_voluntario, " +
                ":fecha_nacimiento_voluntario, :disponibilidad_voluntario, :password_voluntario, :email_voluntario)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre_voluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellido_voluntario", voluntario.getApellidoVoluntario())
                    .addParameter("telefono_voluntario", voluntario.getTelefonoVoluntario())
                    .addParameter("direccion_voluntario", voluntario.getDireccionVoluntario())
                    .addParameter("fecha_nacimiento_voluntario", voluntario.getFechaNacimientoVoluntario())
                    .addParameter("disponibilidad_voluntario", voluntario.getDisponibilidadVoluntario())
                    .addParameter("password_voluntario", voluntario.getPasswordVoluntario())
                    .addParameter("email_voluntario", voluntario.getEmailVoluntario())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            voluntario.setIdVoluntario(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el voluntario", e);
        }
    }

    @Override
    public void updateVoluntario(Voluntario voluntario) {
        String sql = "UPDATE voluntario SET nombre_voluntario = :nombre_voluntario, " +
                "apellido_voluntario = :apellido_voluntario, telefono_voluntario = :telefono_voluntario, " +
                "direccion_voluntario = :direccion_voluntario, fecha_nacimiento_voluntario = :fecha_nacimiento_voluntario, " +
                "disponibilidad_voluntario = :disponibilidad_voluntario, password_voluntario = :password_voluntario, " +
                "email_voluntario = :email_voluntario WHERE id_voluntario = :id_voluntario";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nombre_voluntario", voluntario.getNombreVoluntario())
                    .addParameter("apellido_voluntario", voluntario.getApellidoVoluntario())
                    .addParameter("telefono_voluntario", voluntario.getTelefonoVoluntario())
                    .addParameter("direccion_voluntario", voluntario.getDireccionVoluntario())
                    .addParameter("fecha_nacimiento_voluntario", voluntario.getFechaNacimientoVoluntario())
                    .addParameter("disponibilidad_voluntario", voluntario.getDisponibilidadVoluntario())
                    .addParameter("password_voluntario", voluntario.getPasswordVoluntario())
                    .addParameter("email_voluntario", voluntario.getEmailVoluntario())
                    .addParameter("id_voluntario", voluntario.getIdVoluntario())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el voluntario", e);
        }
    }

    @Override
    public void deleteVoluntario(Long id_voluntario) {
        String sql = "DELETE FROM voluntario WHERE id_voluntario = :id_voluntario";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el voluntario", e);
        }
    }

    @Override
    public Voluntario getVoluntarioByEmail(String email) {
        String sql = "SELECT * FROM voluntario WHERE email_voluntario = :email";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("email", email)
                    .executeAndFetchFirst(Voluntario.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el voluntario por email", e);
        }
    }
}
