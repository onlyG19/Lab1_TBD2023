package cl.tbd.backend.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import cl.tbd.backend.models.Vol_Habilidad;

@Repository
public class Vol_HabilidadRepositoryImp implements Vol_HabilidadRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Vol_Habilidad> getAllVolHabilidades() {
        String sql = "SELECT * FROM vol_habilidad";
        List<Vol_Habilidad> listaVolHabilidades;

        try (Connection conn = sql2o.open()) {
            listaVolHabilidades = conn.createQuery(sql).executeAndFetch(Vol_Habilidad.class);
            
            return listaVolHabilidades;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todos los vol_habilidades", e);
        }
    }

    @Override
    public Vol_Habilidad getVolHabilidadById(Long id) {
        String sql = "SELECT * FROM vol_habilidad WHERE id_vol_habilidad = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Vol_Habilidad.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener el vol_habilidad por ID", e);
        }
    }

    @Override
    public List<Vol_Habilidad> getAllVolHabilidadesByVoluntarioId(Long id_voluntario) {
        String sql = "SELECT * FROM vol_habilidad WHERE id_voluntario = :id_voluntario";
        List<Vol_Habilidad> listaVolHabilidades;

        try (Connection conn = sql2o.open()) {
            listaVolHabilidades = conn.createQuery(sql)
                    .addParameter("id_voluntario", id_voluntario)
                    .executeAndFetch(Vol_Habilidad.class);

            return listaVolHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los vol_habilidad del voluntario", e);
        }
    }

    @Override
    public List<Vol_Habilidad> getAllVolHabilidadesByHabilidadId(Long id_habilidad) {
        String sql = "SELECT * FROM vol_habilidad WHERE id_habilidad = :id_habilidad";
        List<Vol_Habilidad> listaVolHabilidades;

        try (Connection conn = sql2o.open()) {
            listaVolHabilidades = conn.createQuery(sql)
                    .addParameter("id_habilidad", id_habilidad)
                    .executeAndFetch(Vol_Habilidad.class);

            return listaVolHabilidades;
        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Error al obtener los vol_habilidad de la habilidad", e);
        }
    }

    @Override
    public void createVolHabilidad(Vol_Habilidad vol_habilidad) {
        String sql = "INSERT INTO vol_habilidad (id_voluntario, id_habilidad) VALUES (:id_voluntario, :id_habilidad)";

        try (Connection conn = sql2o.open()) {
            Integer idInteger = (Integer) conn.createQuery(sql, true)
                    .addParameter("id_voluntario", vol_habilidad.getIdVoluntario())
                    .addParameter("id_habilidad", vol_habilidad.getIdHabilidad())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            vol_habilidad.setIdVolHabilidad(id);;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al crear el vol_habilidad", e);
        }
    }

    @Override
    public void updateVolHabilidad(Vol_Habilidad vol_Habilidad) {
        String sql = "UPDATE vol_habilidad SET id_voluntario = :id_voluntario, id_habilidad = :id_habilidad WHERE id_vol_habilidad = :id_vol_habilidad";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id_voluntario", vol_Habilidad.getIdVoluntario())
                    .addParameter("id_habilidad", vol_Habilidad.getIdHabilidad())
                    .addParameter("id_vol_habilidad", vol_Habilidad.getIdVolHabilidad())
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el vol_habilidad", e);
        }
    }
    
    @Override
    public void deleteVolHabilidad(Long id) {
        String sql = "DELETE FROM vol_habilidad WHERE id_vol_habilidad = :id";

        try (Connection conn = sql2o.open()) {
            conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el vol_habilidad", e);
        }
    }
}
