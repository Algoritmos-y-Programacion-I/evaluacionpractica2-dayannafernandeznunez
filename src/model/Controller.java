package model;

public class Controller {

    private Pillar[] pillars;

    public Controller() {
        pillars = new Pillar[4];

            pillars[0] = new Pillar("Biodiversidad");
            pillars[0].registerProject(new Project("1", "Conservación de Fauna", "Proyecto para proteger la fauna local", true));
            pillars[0].registerProject(new Project("2", "Reforestación", "Iniciativa de reforestación en el campus", true));
    
            pillars[1] = new Pillar("Agua");
            pillars[1].registerProject(new Project("3", "Captación de Agua", "Sistema de recolección de agua de lluvia", true));
            pillars[1].registerProject(new Project("4", "Uso Eficiente de Agua", "Campaña de concientización sobre el uso del agua", false));
    
            pillars[2] = new Pillar("Tratamiento de Basuras");
            pillars[2].registerProject(new Project("5", "Reciclaje en el Campus", "Implementación de puntos de reciclaje", true));
            pillars[2].registerProject(new Project("6", "Composteando", "Proyecto de compostaje de residuos orgánicos", true));
    
            pillars[3] = new Pillar("Energía");
            pillars[3].registerProject(new Project("7", "Energías Renovables", "Instalación de paneles solares", true));
            pillars[3].registerProject(new Project("8", "Ahorro Energético", "Campaña para reducir el consumo energético", false));
        
    }
    

    public boolean registerProjectInPillar(int pillarType, String id, String name, String description, boolean status) {
        if (pillarType >= 0 && pillarType < pillars.length) {
            return pillars[pillarType].registerProject(new Project(id, name, description, status));
        }
        return false;
    }

    public String queryProjectsByPillar(int pillarType) {
        if (pillarType >= 0 && pillarType < pillars.length) {
            return pillars[pillarType].getProjectList();
        }
        return "Pilar no encontrado.";
    }
    
}
