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
    public List<Voluntario> getAllVoluntariosByCoordinadorId(Long id_coordinador_asginado) {
        String sql = "SELECT * FROM voluntario WHERE id_coordinador_asignado = :id_coordinador_asignado";
        List<Voluntario> listaVoluntarios;

        try (Connection conn = sql2o.open()) {
            listaVoluntarios = conn.createQuery(sql)
                    .addParameter("id_coordinador_asignado", id_coordinador_asginado)
                    .executeAndFetch(Voluntario.class);

            return listaVoluntarios;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los voluntarios del coordinador", e);
        }
    }

    @Override
    public void createVoluntario(Voluntario voluntario) {
        String sql = "INSERT INTO voluntario (nombre, apellido, email, telefono, direccion, fecha_de_nacimiento, genero, ranking, id_coordinador_asignado) VALUES (:nombre, :apellido, :email, :telefono, :direccion, :fecha_de_nacimiento, :genero, :ranking, :id_coordinador_asignado)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre", voluntario.getNombreVoluntario())
                    .addParameter("apellido", voluntario.getApellidoVoluntario())
                    .addParameter("email", voluntario.getEmailVoluntario())
                    .addParameter("telefono", voluntario.getTelefonoVoluntario())
                    .addParameter("direccion", voluntario.getDireccionVoluntario())
                    .addParameter("fecha_de_nacimiento", voluntario.getFechaDeNacimientoVoluntario())
                    .addParameter("genero", voluntario.getGeneroVoluntario())
                    .addParameter("ranking", voluntario.getRankingVoluntario())
                    .addParameter("id_coordinador_asignado", voluntario.getIdCoordinadorAsignado())
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
        String sql = "UPDATE voluntario SET nombre = :nombre, apellido = :apellido, email = :email, telefono = :telefono, direccion = :direccion, fecha_de_nacimiento = :fecha_de_nacimiento, genero = :genero, ranking = :ranking, id_coordinador_asignado = :id_coordinador_asignado WHERE id_voluntario = :id_voluntario";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nombre", voluntario.getNombreVoluntario())
                    .addParameter("apellido", voluntario.getApellidoVoluntario())
                    .addParameter("email", voluntario.getEmailVoluntario())
                    .addParameter("telefono", voluntario.getTelefonoVoluntario())
                    .addParameter("direccion", voluntario.getDireccionVoluntario())
                    .addParameter("fecha_de_nacimiento", voluntario.getFechaDeNacimientoVoluntario())
                    .addParameter("genero", voluntario.getGeneroVoluntario())
                    .addParameter("ranking", voluntario.getRankingVoluntario())
                    .addParameter("id_coordinador_asignado", voluntario.getIdCoordinadorAsignado())
                    .addParameter("id_voluntario", voluntario.getIdVoluntario())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el voluntario", e);
        }
    }

    @Override
    public void deleteVoluntario(Long id) {
        String sql = "DELETE FROM voluntario WHERE id_voluntario = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el voluntario", e);
        }
    }
}
