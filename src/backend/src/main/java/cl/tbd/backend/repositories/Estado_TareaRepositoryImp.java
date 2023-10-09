package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Estado_Tarea;

@Repository
public class Estado_TareaRepositoryImp implements Estado_TareaRepository {
    @Autowired
    private Sql2o sql2o;

    @Override 
    public List<Estado_Tarea> getAllEstado_Tareas() {
        String sql = "SELECT * FROM estado_tarea";
        List<Estado_Tarea> listaEstado_Tareas;

        try (Connection conn = sql2o.open()) {
            listaEstado_Tareas = conn.createQuery(sql).executeAndFetch(Estado_Tarea.class);
            
            return listaEstado_Tareas;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas los estado_tareas", e);
        }
    }

    @Override
    public Estado_Tarea getEstado_TareaById(Long id) {
        String sql = "SELECT * FROM estado_tarea WHERE id_estado_tarea = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Estado_Tarea.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el estado_tarea por ID", e);
        }
    }

    @Override
    public void createEstado_Tarea(Estado_Tarea estado_tarea) {
        String sql = "INSERT INTO estado_tarea (nombre_estado) VALUES (:nombre_estado)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre_estado", estado_tarea.getName())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            estado_tarea.setIdEstado_Tarea(id);;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el estado_tarea", e);
        }
    }

    @Override
    public void updateEstado_Tarea(Estado_Tarea estado_tarea) {
        String sql = "UPDATE estado_tarea SET nombre_estado = :nombre_estado WHERE id_estado_tarea = :id_estado_tarea";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nombre_estado", estado_tarea.getName())
                    .addParameter("id_estado_tarea", estado_tarea.getIdEstado_Tarea())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el estado_tarea", e);
        }
    }

    @Override
    public void deleteEstado_Tarea(Long id) { 
        String sql = "DELETE FROM estado_tarea WHERE id_estado_tarea = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la estado_tarea", e);
        }
    }
}
