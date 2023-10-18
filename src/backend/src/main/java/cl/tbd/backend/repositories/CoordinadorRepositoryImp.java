package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Coordinador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CoordinadorRepositoryImp implements CoordinadorRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public void createCoordinador(Coordinador coordinador) {
        final String sql =
                "INSERT INTO coordinador(nombre_coordinador, apellido_coordinador, password_coordinador," +
                        "email_coordinador,id_institucion)" +
                        "VALUES (:nombre_coordinador, :apellido_coordinador, :password_coordinador, :email_coordinador" +
                        ", :id_institucion)";
        try (Connection conn = sql2o.open()) {
            // Verificar si el correo electrónico ya existe
            String checkEmailSQL = "SELECT COUNT(*) FROM coordinador WHERE email_coordinador = :email_coordinador";
            int emailCount = conn.createQuery(checkEmailSQL)
                    .addParameter("email_coordinador", coordinador.getEmailCoordinador())
                    .executeScalar(Integer.class);

            if (emailCount > 0) {
                throw new RuntimeException("El correo electrónico ya está en uso");
            }

            Integer idInteger = (Integer) conn.createQuery(sql)
                    .addParameter("nombre_coordinador", coordinador.getNombreCoordinador())
                    .addParameter("apellido_coordinador", coordinador.getApellidoCoordinador())
                    .addParameter("password_coordinador", coordinador.getPasswordCoordinador())
                    .addParameter("email_coordinador", coordinador.getEmailCoordinador())
                    .addParameter("id_institucion", coordinador.getIdInstitucion())
                    .executeUpdate()
                    .getKey();

            Long id = idInteger.longValue();
            coordinador.setIdCoordinador(id);

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
    public Coordinador getCoordinadorById(Long id_coordinador){
        String sql = "SELECT * FROM coordinador WHERE id_coordinador = :id_coordinador";

        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .addParameter("id_coordinador", id_coordinador)
                    .executeAndFetchFirst(Coordinador.class);


        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    // Revisar el formato de update, que es distinto a los otros
    @Override
    public String updateCoordinador(Long id_coordinador, Coordinador coordinador) {
        String updateSql = "UPDATE coordinador " +
                "SET nombre_coordinador = :nombre_coordinador, apellido_coordinador = :apellido_coordinador, " +
                "password_coordinador =:password_coordinador, email_coordinador =:email_coordinador, " +
                "id_institucion =:id_institucion WHERE id_coordinador = :id_coordinador";

        try (Connection con = sql2o.open()) {
            Coordinador antiguo = con.createQuery("SELECT * FROM coordinador " +
                            "WHERE id_coordinador = :id_coordinador")
                    .addParameter("id_coordinador", id_coordinador)
                    .executeAndFetchFirst(Coordinador.class);

            //Se verifica si existe la tupla que se desea actualizar
            if (antiguo == null) {
                return ("No existe el coordinador con id: " + id_coordinador);
            }

            //Se ejectua la actualizacion, llenando los parametros de la consulta segun corresponda
            Query consulta = con.createQuery(updateSql);
            consulta.addParameter("id_coordinador", id_coordinador);

            if (coordinador.getNombreCoordinador() != null) {
                consulta.addParameter("nombre_coordinador", coordinador.getNombreCoordinador());
            } else {
                consulta.addParameter("nombre_coordinador", antiguo.getNombreCoordinador());
            }
            if (coordinador.getApellidoCoordinador() != null) {
                consulta.addParameter("apellido_coordinador", coordinador.getApellidoCoordinador());
            } else {
                consulta.addParameter("apellido_coordinador", antiguo.getApellidoCoordinador());
            }
            if (coordinador.getIdInstitucion() != null) {
                consulta.addParameter("id_institucion", coordinador.getIdInstitucion());
            } else {
                consulta.addParameter("id_institucion", antiguo.getIdInstitucion());
            }
            if (coordinador.getPasswordCoordinador() != null) {
                consulta.addParameter("password_coordinador", coordinador.getPasswordCoordinador());
            } else {
                consulta.addParameter("password_coordinador", antiguo.getPasswordCoordinador());
            }
            if (coordinador.getEmailCoordinador() != null) {
                consulta.addParameter("email_coordinador", coordinador.getEmailCoordinador());
            } else {
                consulta.addParameter("email_coordinador", antiguo.getEmailCoordinador());
            }

            consulta.executeUpdate();

            return ("El coordinador de id: " + id_coordinador + " se actualizo correctamente");

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public String deleteCoordinador(Long id_coordinador) {
        String deleteSql = "DELETE FROM coordinador WHERE id_coordinador = :id_coordinador";

        try(Connection conn = sql2o.open()){

            Coordinador tupla = conn.createQuery("SELECT * FROM coordinador " +
                            "where id_coordinador = :id_coordinador")
                    .addParameter("id_coordinador", id_coordinador)
                    .executeAndFetchFirst(Coordinador.class);
            if(tupla == null){
                return ("No existe el coordinador con id: " + id_coordinador);
            }

            conn.createQuery(deleteSql)
                    .addParameter("id_coordinador", id_coordinador)
                    .executeUpdate();
            return "Se ha eliminado el coordinador " + id_coordinador;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    @Override
    public Coordinador getCoordinadorByEmail(String email_coordinador) {
        String sql = "SELECT * FROM coordinador WHERE email_coordinador = :email_coordinador";
        Connection conn = sql2o.open();
        return conn.createQuery(sql)
                .addParameter("email_coordinador", email_coordinador)
                .executeAndFetchFirst(Coordinador.class);
    }
}

