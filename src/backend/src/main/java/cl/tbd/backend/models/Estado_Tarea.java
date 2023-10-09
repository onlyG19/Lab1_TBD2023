package cl.tbd.backend.models;

public class Estado_Tarea {
    private Long id_estado_tarea;
    private String nombre_estado;

    public Estado_Tarea(Long id_estado_tarea, String nombre_estado) {
        this.id_estado_tarea = id_estado_tarea;
        this.nombre_estado = nombre_estado;
    }

    public Estado_Tarea(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }

    public Long getIdEstado_Tarea() {
        return id_estado_tarea;
    }

    public void setIdEstado_Tarea(Long id_estado_tarea) {
        this.id_estado_tarea = id_estado_tarea;
    }

    public String getName() {
        return nombre_estado;
    }

    public void setName(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
}
