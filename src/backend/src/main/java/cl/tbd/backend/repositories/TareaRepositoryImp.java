package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Tarea;

@Repository
public class TareaRepositoryImp implements TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea> getAllTareas() {
        String sql = "SELECT * FROM tarea";
        List<Tarea> listaTareas;

        try (Connection conn = sql2o.open()) {
            listaTareas = conn.createQuery(sql).executeAndFetch(Tarea.class);
            
            return listaTareas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las tareas", e);
        }
    }

    @Override
    public Tarea getTareaById(Long id) {
        String sql = "SELECT * FROM tarea WHERE id_tarea = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Tarea.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la tarea por ID", e);
        }
    }

    @Override
    public List<Tarea> getAllTareasByEmergenciaId(Long id_emergencia) {
        String sql = "SELECT * FROM tarea WHERE id_emergencia = :id_emergencia";
        List<Tarea> listaTareas;

        try (Connection conn = sql2o.open()) {
            listaTareas = conn.createQuery(sql)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Tarea.class);

            return listaTareas;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las tareas de la emergencia", e);
        }
    }

    @Override
    public List<Tarea> getAllTareasByEstadoTareaId(Long id_estado_tarea) {
        String sql = "SELECT * FROM tarea WHERE id_estado_tarea = :id_estado_tarea";
        List<Tarea> listaTareas;

        try (Connection conn = sql2o.open()) {
            listaTareas = conn.createQuery(sql)
                    .addParameter("id_estado_tarea", id_estado_tarea)
                    .executeAndFetch(Tarea.class);

            return listaTareas;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las tareas del estado de la tarea", e);
        }
    }

    @Override
    public void createTarea(Tarea tarea) {
        String sql = "INSERT INTO tarea (descripcion, fecha_asignacion, id_emergencia, id_estado_tarea) VALUES (:descripcion, :fecha_asignacion, :id_emergencia, :id_estado_tarea)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("fecha_asignacion", tarea.getFechaAsignacion())
                    .addParameter("id_emergencia", tarea.getIdEmergencia())
                    .addParameter("id_estado_tarea", tarea.getIdEstadoTarea())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            tarea.setIdTarea(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la tarea", e);
        }
    }

    @Override
    public void updateTarea(Tarea tarea) {
        String sql = "UPDATE tarea SET descripcion = :descripcion, fecha_asignacion = :fecha_asignacion, id_emergencia = :id_emergencia, id_estado_tarea = :id_estado_tarea WHERE id_tarea = :id_tarea";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("descripcion", tarea.getDescripcion())
                    .addParameter("fecha_asignacion", tarea.getFechaAsignacion())
                    .addParameter("id_emergencia", tarea.getIdEmergencia())
                    .addParameter("id_estado_tarea", tarea.getIdEstadoTarea())
                    .addParameter("id_tarea", tarea.getIdTarea())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la tarea", e);
        }
    }

    @Override
    public void deleteTarea(Long id) {
        String sql = "DELETE FROM tarea WHERE id_tarea = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la tarea", e);
        }
    }
}
