package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Emergencia;

@Repository
public class EmergenciaRepositoryImp implements EmergenciaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Emergencia> getAllEmergencias() {
        String sql = "SELECT * FROM emergencia";
        List<Emergencia> listaEmergencias;

        try (Connection conn = sql2o.open()) {
            listaEmergencias = conn.createQuery(sql).executeAndFetch(Emergencia.class);
            
            return listaEmergencias;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las emergencias", e);
        }
    }

    @Override
    public Emergencia getEmergenciaById(Long id_emergencia) {
        String sql = "SELECT * FROM emergencia WHERE id_emergencia = :id_emergencia";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetchFirst(Emergencia.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la emergencia por ID", e);
        }
    }

    @Override
    public List<Emergencia> getAllEmergenciasByCoordinadorId(Long id_coordinador) {
        String sql = "SELECT * FROM emergencia WHERE id_coordinador = :id_coordinador";
        List<Emergencia> listaEmergencias;

        try (Connection conn = sql2o.open()) {
            listaEmergencias = conn.createQuery(sql)
                    .addParameter("id_coordinador", id_coordinador)
                    .executeAndFetch(Emergencia.class);

            return listaEmergencias;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las emergencias del coordinador", e);
        }
    }

    @Override
    public List<Emergencia> getAllEmergenciasByInstitucionId(Long id_institucion) {
        String sql = "SELECT * FROM emergencia WHERE id_institucion = :id_institucion";
        List<Emergencia> listaEmergencias;

        try (Connection conn = sql2o.open()) {
            listaEmergencias = conn.createQuery(sql)
                    .addParameter("id_institucion", id_institucion)
                    .executeAndFetch(Emergencia.class);

            return listaEmergencias;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las emergencias de la institucion", e);
        }
    }

    @Override
    public void createEmergencia(Emergencia emergencia) {
        String sql = "INSERT INTO emergencia (nombre_emergencia, descripcion_emergencia, fecha_creacion_emergencia, " +
                "id_coordinador, id_institucion) VALUES (:nombre_emergencia, :descripcion_emergencia, " +
                ":fecha_creacion_emergencia, :id_coordinador, :id_institucion)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre_emergencia", emergencia.getNombreEmergencia())
                    .addParameter("descripcion_emergencia", emergencia.getDescripcionEmergencia())
                    .addParameter("fecha_creacion_emergencia", emergencia.getFechaCreacionEmergencia())
                    .addParameter("id_coordinador", emergencia.getIdCoordinador())
                    .addParameter("id_institucion", emergencia.getIdInstitucion())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            emergencia.setIdEmergencia(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el vol_habilidad", e);
        }
    }

    @Override
    public void updateEmergencia(Emergencia emergencia) {
        String sql = "UPDATE emergencia SET nombre_emergencia = :nombre_emergencia, " +
                "descripcion_emergencia = :descripcion_emergencia, fecha_creacion_emergencia = :fecha_creacion_emergencia," +
                "id_coordinador = :id_coordinador, id_institucion = :id_institucion WHERE id_emergencia = :id_emergencia";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nombre_emergencia", emergencia.getNombreEmergencia())
                    .addParameter("descripcion_emergencia", emergencia.getDescripcionEmergencia())
                    .addParameter("fecha_creacion_emergencia", emergencia.getFechaCreacionEmergencia())
                    .addParameter("id_coordinador", emergencia.getIdCoordinador())
                    .addParameter("id_institucion", emergencia.getIdInstitucion())
                    .addParameter("id_emergencia", emergencia.getIdEmergencia())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la emergencia", e);
        }
    }
    
    @Override
    public void deleteEmergencia(Long id_emergencia) {
        String sql = "DELETE FROM emergencia WHERE id_emergencia = :id_emergencia";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la emergencia", e);
        }
    }

    @Override
    public int numeroTareasActivasEmergencia(Long id_emergencia) {
        String sql = "SELECT COUNT(*) FROM tarea WHERE id_emergencia = :id_emergencia AND estado_tarea = 1";

        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeScalar(Integer.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el numero de tareas activas de la emergencia", e);
        }
    }
}
