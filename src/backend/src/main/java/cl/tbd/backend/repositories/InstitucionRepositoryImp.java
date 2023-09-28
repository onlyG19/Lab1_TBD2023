package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Institucion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitucionRepositoryImp implements InstitucionRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Institucion> getAllInstituciones() {
        String sql = "SELECT * FROM institucion";
        List<Institucion> listaInstituciones;

        try (Connection conn = sql2o.open()) {
            listaInstituciones = conn.createQuery(sql).executeAndFetch(Institucion.class);

            return listaInstituciones;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener todas las instituciones", e);
        }
    }

    @Override
    public Institucion getInstitucionById(Long id) {
        String sql = "SELECT * FROM institucion WHERE id_institucion = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Institucion.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al obtener la institución por ID", e);
        }
    }



}
