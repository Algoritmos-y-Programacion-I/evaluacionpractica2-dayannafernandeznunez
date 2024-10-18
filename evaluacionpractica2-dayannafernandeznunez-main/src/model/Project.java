package model;

public class Project {

    private String id;
    private String name;
    private String description;
    private boolean status;

    public Project(String id, String name, String description, boolean status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public boolean getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nombre: " + name + ", Estado: " + (status ? "Activo" : "Inactivo");
    }
}