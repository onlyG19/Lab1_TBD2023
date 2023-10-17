package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Eme_Habilidad;

@Repository
public class Eme_HabilidadRepositoryImp implements Eme_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Eme_Habilidad> getAllEmeHabilidades() {
        String sql = "SELECT * FROM eme_habilidad";
        List<Eme_Habilidad> listaEmeHabilidades;

        try (Connection conn = sql2o.open()) {
            listaEmeHabilidades = conn.createQuery(sql).executeAndFetch(Eme_Habilidad.class);
            
            return listaEmeHabilidades;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los eme_habilidades", e);
        }
    }

    @Override
    public Eme_Habilidad getEmeHabilidadById(Long id) {
        String sql = "SELECT * FROM eme_habilidad WHERE id_eme_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Eme_Habilidad.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el eme_habilidad por ID", e);
        }
    }

    @Override
    public List<Eme_Habilidad> getAllEmeHabilidadesByEmergenciaId(Long id_emergencia) {
        String sql = "SELECT * FROM eme_habilidad WHERE id_emergencia = :id_emergencia";
        List<Eme_Habilidad> listaEmeHabilidades;

        try (Connection conn = sql2o.open()) {
            listaEmeHabilidades = conn.createQuery(sql)
                    .addParameter("id_emergencia", id_emergencia)
                    .executeAndFetch(Eme_Habilidad.class);

            return listaEmeHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los eme_habilidad de la emergencia", e);
        }
    }

    @Override
    public List<Eme_Habilidad> getAllEmeHabilidadesByHabilidadId(Long id_habilidad) {
        String sql = "SELECT * FROM eme_habilidad WHERE id_habilidad = :id_habilidad";
        List<Eme_Habilidad> listaEmeHabilidades;

        try (Connection conn = sql2o.open()) {
            listaEmeHabilidades = conn.createQuery(sql)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetch(Eme_Habilidad.class);

            return listaEmeHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los eme_habilidad de la habilidad", e);
        }
    }

    @Override
    public void createEmeHabilidad(Eme_Habilidad eme_habilidad) {
        String sql = "INSERT INTO eme_habilidad (id_emergencia, id_habilidad) VALUES (:id_emergencia, :id_habilidad)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("id_emergencia", eme_habilidad.getIdEmergencia())
                    .addParameter("id_habilidad", eme_habilidad.getIdHabilidad())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            eme_habilidad.setIdEmeHabilidad(id);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el eme_habilidad", e);
        }
    }

    @Override
    public void updateEmeHabilidad(Eme_Habilidad eme_habilidad) {
        String sql = "UPDATE eme_habilidad SET id_emergencia = :id_emergencia, id_habilidad = :id_habilidad " +
                "WHERE id_eme_habilidad = :id_eme_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_emergencia", eme_habilidad.getIdEmergencia())
                    .addParameter("id_habilidad", eme_habilidad.getIdHabilidad())
                    .addParameter("id_eme_habilidad", eme_habilidad.getIdEmeHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el eme_habilidad", e);
        }
    }

    @Override
    public void deleteEmeHabilidad(Long id) {
        String sql = "DELETE FROM eme_habilidad WHERE id_eme_habilidad = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el eme_habilidad", e);
        }
    }
}
