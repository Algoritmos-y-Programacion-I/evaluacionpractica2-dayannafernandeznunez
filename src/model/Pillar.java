package model;

public class Pillar {

    private String name;
    private Project[] projects;
    private int projectCount;

    public Pillar(String name) {
        this.name = name;
        projects = new Project[50]; // Máximo 50 proyectos
        projectCount = 0;
    }

    public boolean registerProject(Project newProject) {
        if (projectCount < 50) {
            projects[projectCount] = newProject;
            projectCount++;
            return true;
        }
        return false;
    }

    public String getProjectList() {
        StringBuilder list = new StringBuilder();
        if (projectCount == 0) {
            return "No hay proyectos registrados en este pilar.";
        }
        for (int i = 0; i < projectCount; i++) {
            list.append(projects[i].toString()).append("\n");
        }
        return list.toString();
    }

    public String getName() {
        return name;
    }
}
