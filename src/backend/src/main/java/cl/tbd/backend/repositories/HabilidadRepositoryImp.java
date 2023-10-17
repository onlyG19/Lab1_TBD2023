package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Habilidad;

@Repository
public class HabilidadRepositoryImp implements HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Habilidad> getAllHabilidades() {
        String sql = "SELECT * FROM habilidad";
        List<Habilidad> listaHabilidades;

        try (Connection conn = sql2o.open()) {
            listaHabilidades = conn.createQuery(sql).executeAndFetch(Habilidad.class);
            
            return listaHabilidades;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las habilidades", e);
        }
    }

    @Override
    public Habilidad getHabilidadById(Long id_habilidad) {
        String sql = "SELECT * FROM habilidad WHERE id_habilidad = :id_habilidad";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetchFirst(Habilidad.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la habilidad por ID", e);
        }
    }

    @Override
    public void createHabilidad(Habilidad habilidad) {
        String sql = "INSERT INTO habilidad (nombre_habilidad) VALUES (:nombre_habilidad)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("nombre_habilidad", habilidad.getNombreHabilidad())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue(); // Convierte el Integer a Long
            habilidad.setIdHabilidad(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear la habilidad", e);
        }

    }

    @Override
    public void updateHabilidad(Habilidad habilidad) {
        String sql = "UPDATE habilidad SET nombre_habilidad = :nombre_habilidad WHERE id_habilidad = :id_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("nombre_habilidad", habilidad.getNombreHabilidad())
                    .addParameter("id_habilidad", habilidad.getIdHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar la habilidad", e);
        }
    }

    @Override
    public void deleteHabilidad(Long id_habilidad) {
        String sql = "DELETE FROM habilidad WHERE id_habilidad = :id_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar la habilidad", e);
        }
    }
}
