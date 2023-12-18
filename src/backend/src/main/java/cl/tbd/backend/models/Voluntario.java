package cl.tbd.backend.models;

import org.bson.Document;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.util.List;

public class Voluntario {

    @BsonId
    ObjectId _id;

    private List<Document> habilidades;
    private String nombreVoluntario;
    private String apellidoVoluntario;
    private String telefono_voluntario;
    private String direccion_voluntario;
    private String fecha_nacimiento_voluntario;
    private String disponibilidad_voluntario;
    private String password_voluntario;
    private String email_voluntario;

    // Constructor vacío
    public Voluntario() {

    }

    public Voluntario(List<Document> hablidades,String nombre_voluntario, String apellido_voluntario,
                      String telefono_voluntario, String direccion_voluntario, String fecha_nacimiento_voluntario,
                      String disponibilidad_voluntario, String password_voluntario, String email_voluntario) {
        this.habilidades = hablidades;
        this.nombreVoluntario = nombre_voluntario;
        this.apellidoVoluntario = apellido_voluntario;
        this.telefono_voluntario = telefono_voluntario;
        this.direccion_voluntario = direccion_voluntario;
        this.fecha_nacimiento_voluntario = fecha_nacimiento_voluntario;
        this.disponibilidad_voluntario = disponibilidad_voluntario;
        this.password_voluntario = password_voluntario;
        this.email_voluntario = email_voluntario;
    }

    public ObjectId getId() {
        return this._id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    public List<Document> getHabilidades(){
        return this.habilidades;
    }

    public void setHabilidades(List<Document> newHabilidades){
        this.habilidades = newHabilidades;
    }

    public String getNombreVoluntario() {
        return nombreVoluntario;
    }

    public void setNombreVoluntario(String nombre_voluntario) {
        this.nombreVoluntario = nombre_voluntario;
    }

    public String getApellidoVoluntario() {
        return apellidoVoluntario;
    }

    public void setApellidoVoluntario(String apellido_voluntario) {
        this.apellidoVoluntario = apellido_voluntario;
    }

    public String getTelefonoVoluntario() {
        return telefono_voluntario;
    }

    public void setTelefonoVoluntario(String telefono_voluntario) {
        this.telefono_voluntario = telefono_voluntario;
    }

    public String getDireccionVoluntario() {
        return direccion_voluntario;
    }

    public void setDireccionVoluntario(String direccion_voluntario) {
        this.direccion_voluntario = direccion_voluntario;
    }

    public String getFechaNacimientoVoluntario() {
        return fecha_nacimiento_voluntario;
    }

    public void setFechaNacimientoVoluntario(String fecha_nacimiento_voluntario) {
        this.fecha_nacimiento_voluntario = fecha_nacimiento_voluntario;
    }

    public String getDisponibilidadVoluntario() {
        return disponibilidad_voluntario;
    }

    public void setDisponibilidadVoluntario(String disponibilidad_voluntario) {
        this.disponibilidad_voluntario = disponibilidad_voluntario;
    }

    public String getPasswordVoluntario() {
        return password_voluntario;
    }

    public void setPasswordVoluntario(String password_voluntario) {
        this.password_voluntario = password_voluntario;
    }

    public String getEmailVoluntario() {
        return email_voluntario;
    }

    public void setEmailVoluntario(String email_voluntario) {
        this.email_voluntario = email_voluntario;
    }

}
