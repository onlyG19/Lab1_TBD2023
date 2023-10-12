package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Coordinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void createCoordinador(Coordinador coordinador) {
        final String sql =
                "INSERT INTO coordinador(nombre,apellido,estado_salud,password,email,id_institucion)" +
                        "VALUES (:nombre, :apellido, :estado_salud, :password, :email, :id_institucion)";
        try (Connection conn = sql2o.open()) {
            // Verificar si el correo electrónico ya existe
            String checkEmailSQL = "SELECT COUNT(*) FROM coordinador WHERE email = :email";
            int emailCount = conn.createQuery(checkEmailSQL)
                    .addParameter("email", coordinador.getEmail())
                    .executeScalar(Integer.class);

            if (emailCount > 0) {
                throw new RuntimeException("El correo electrónico ya está en uso");
            }


            Integer idInteger = (Integer) conn.createQuery(sql)
                    .addParameter("nombre", coordinador.getNombre())
                    .addParameter("apellido", coordinador.getApellido())
                    .addParameter("estado_salud", coordinador.getEstado_salud())
                    .addParameter("password", coordinador.getPassword())
                    .addParameter("email", coordinador.getEmail())
                    .addParameter("id_institucion", coordinador.getId_institucion())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            coordinador.setId_coordinador(id);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Error al crear el coordinador", e);
        }


    }


    @Override
    public List<Coordinador> getAllCoordinador() {
        final String sql = "SELECT * FROM coordinador";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(Coordinador.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    @Override
    public Coordinador getCoordinadorById(Long id){
        String sql = "SELECT * FROM coordinador WHERE id_coordinador = :cid";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("cid", id)
                    .executeAndFetchFirst(Coordinador.class);


        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public String updateCoordinador(Long id, Coordinador coordinador) {
        String updateSql = "UPDATE coordinador " +
                "SET nombre = :coordinadorNombre,apellido = :coordinadorApellido, estado_salud = :coordinadorEstado_salud,"
                + "password =:coordinadorPassword, email =:coordinadorCorreo_electronico, id_institucion =:coordinadorId_institucion, "
                + "updated_at = :coordinadorFechaActualizacion " +
                "WHERE id_coordinador = :coordinadorID";
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        try (Connection con = sql2o.open()) {
            Coordinador antiguo = con.createQuery("SELECT * FROM coordinador where id_coordinador = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Coordinador.class);

            //Se verifica si existe la tupla que se desea actualizar
            if (antiguo == null) {
                return ("No existe el coordinador con id: " + id);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("coordinadorID", id);

            if (coordinador.getNombre() != null) {
                consulta.addParameter("coordinadorNombre", coordinador.getNombre());
            } else {
                consulta.addParameter("coordinadorNombre", antiguo.getNombre());
            }
            if (coordinador.getApellido() != null) {
                consulta.addParameter("coordinadorApellido", coordinador.getApellido());
            } else {
                consulta.addParameter("coordinadorApellido", antiguo.getApellido());
            }
            if (coordinador.getEstado_salud() != null) {
                consulta.addParameter("coordinadorEstado_salud", coordinador.getEstado_salud());
            } else {
                consulta.addParameter("coordinadorEstado_salud", antiguo.getEstado_salud());
            }
            if (coordinador.getPassword() != null) {
                consulta.addParameter("coordinadorPassword", coordinador.getPassword());
            } else {
                consulta.addParameter("coordinadorPassword", antiguo.getPassword());
            }
            if (coordinador.getEmail() != null) {
                consulta.addParameter("coordinadorCorreo_electronico", coordinador.getEmail());
            } else {
                consulta.addParameter("coordinadorCorreo_electronico", antiguo.getEmail());
            }
            if (coordinador.getId_institucion() != null) {
                consulta.addParameter("coordinadorId_institucion", coordinador.getId_institucion());
            } else {
                consulta.addParameter("coordinadorId_institucion", antiguo.getId_institucion());
            }


            //Se cambia la fecha de actualizacion
            consulta.addParameter("coordinadorFechaActualizacion",timestamp);

            consulta.executeUpdate();

            return ("El coordinador de id: " + id + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }




    @Override
    public String deleteCoordinador(Long id) {
        String deleteSql = "DELETE FROM coordinador e WHERE e.id_coordinador = "+id;

        try(Connection conn = sql2o.open()){

            Coordinador tupla = conn.createQuery("SELECT * FROM coordinador where id_coordinador = :idE")
                    .addParameter("idE", id)
                    .executeAndFetchFirst(Coordinador.class);
            if(tupla == null){
                return ("No existe el coordinador con id: " + id);
            }

            conn.createQuery(deleteSql)
                    .executeUpdate();
            return "Se ha eliminado el coordinador " +id;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Coordinador findOneByEmail(String email) {
        String sql = "SELECT * FROM coordinador WHERE email = :email";
        Connection conn = sql2o.open();
        return conn.createQuery(sql)
                .addParameter("email", email)
                .executeAndFetchFirst(Coordinador.class);
    }
}

