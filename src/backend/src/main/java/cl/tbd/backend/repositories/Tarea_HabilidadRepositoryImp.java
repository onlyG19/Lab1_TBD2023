package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Tarea_Habilidad;

@Repository
public class Tarea_HabilidadRepositoryImp implements Tarea_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Tarea_Habilidad> getAllTareaHabilidades() {
        String sql = "SELECT * FROM tarea_habilidad";
        List<Tarea_Habilidad> listaTareaHabilidades;

        try (Connection conn = sql2o.open()) {
            listaTareaHabilidades = conn.createQuery(sql).executeAndFetch(Tarea_Habilidad.class);
            
            return listaTareaHabilidades;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las tarea_habilidades", e);
        }
    }

    @Override
    public Tarea_Habilidad getTareaHabilidadById(Long id_tarea_habilidad) {
        String sql = "SELECT * FROM tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
                    .executeAndFetchFirst(Tarea_Habilidad.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la tarea_habilidad por ID", e);
        }
    }

    @Override
    public List<Tarea_Habilidad> getAllTareaHabilidadesByTareaId(Long id_tarea) {
        String sql = "SELECT * FROM tarea_habilidad WHERE id_tarea = :id_tarea";
        List<Tarea_Habilidad> listaTareaHabilidades;

        try (Connection conn = sql2o.open()) {
            listaTareaHabilidades = conn.createQuery(sql)
                    .addParameter("id_tarea", id_tarea)
                    .executeAndFetch(Tarea_Habilidad.class);

            return listaTareaHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las tarea_habilidad de la emergencia", e);
        }
    }

    @Override
    public List<Tarea_Habilidad> getAllTareaHabilidadesbyHabilidadesId(Long id_habilidad) {
        String sql = "SELECT * FROM tarea_habilidad WHERE id_habilidad = :id_habilidad";
        List<Tarea_Habilidad> listaTareaHabilidades;

        try (Connection conn = sql2o.open()) {
            listaTareaHabilidades = conn.createQuery(sql)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetch(Tarea_Habilidad.class);

            return listaTareaHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener las tarea_habilidad de la habilidad", e);
        }
    }

    @Override
    public void createTareaHabilidad(Tarea_Habilidad tarea_habilidad) {
        String sql = "INSERT INTO tarea_habilidad (id_tarea, id_habilidad, puntaje_tarea_habilidad) " +
                "VALUES (:id_tarea, :id_habilidad, :puntaje_tarea_habilidad)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("id_tarea", tarea_habilidad.getIdTarea())
                    .addParameter("id_habilidad", tarea_habilidad.getIdHabilidad())
                    .addParameter("puntaje_tarea_habilidad", tarea_habilidad.getPuntajeTareaHabilidad())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            tarea_habilidad.setIdTareaHabilidad(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la tarea_habilidad", e);
        }
    }

    @Override
    public void updateTareaHabilidad(Tarea_Habilidad tarea_habilidad) {
        String sql = "UPDATE tarea_habilidad SET id_tarea = :id_tarea, id_habilidad = :id_habilidad , " +
                "puntaje_tarea_habilidad =:puntaje_tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_tarea", tarea_habilidad.getIdTarea())
                    .addParameter("id_habilidad", tarea_habilidad.getIdHabilidad())
                    .addParameter("puntaje_tarea_habilidad", tarea_habilidad.getPuntajeTareaHabilidad())
                    .addParameter("id_tarea_habilidad", tarea_habilidad.getIdTareaHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la tarea_habilidad", e);
        }
    }

    @Override
    public void deleteTareaHabilidad(Long id_tarea_habilidad) {
        String sql = "DELETE FROM tarea_habilidad WHERE id_tarea_habilidad = :id_tarea_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_tarea_habilidad", id_tarea_habilidad)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la tarea_habilidad", e);
        }
    }
}
