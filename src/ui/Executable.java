package ui;

import java.util.Scanner;
import model.Controller;

public class Executable {

    private Controller control;
    private Scanner reader;

    public Executable() {
        control = new Controller();
        reader = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Executable exe = new Executable();
        exe.menu();
    }

    public void menu() {
        boolean flag = true;

        do {
            System.out.println("\nBienvenido a Icesi Sostenible!");
            System.out.println("\nMENU PRINCIPAL");
            System.out.println("----------------------");
            System.out.println("1) Registrar un Proyecto en un Pilar");
            System.out.println("2) Consultar Proyectos por Pilar");
            System.out.println("0) Salir");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    registerProject();
                    break;
                case 2:
                    showProjectsByPillar();
                    break;
                case 0:
                    System.out.println("Gracias por usar nuestros servicios. Adios!");
                    System.out.println("Esperamos verte pronto nuevamente!");
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente");
                    System.out.println("Por favor seleccione (En numero 1,2,0, su opcion deseada)");
                    break;
            }

        } while (flag);
    }

    public void registerProject() {
        reader.nextLine(); // Limpiar el buffer

        System.out.print("Ingrese el ID del Proyecto: ");
        String id = reader.nextLine();

        System.out.print("Ingrese el nombre del Proyecto: ");
        String name = reader.nextLine();

        System.out.print("Ingrese la descripción del Proyecto: ");
        String description = reader.nextLine();

        System.out.print("Ingrese el estado del Proyecto (true=activo, false=inactivo): ");
        boolean status = reader.nextBoolean();

        System.out.println("Ingrese el tipo de Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía): ");
        System.out.println("Ingrese solo por favor el numero del pilar al cual desea registar el proyecto");
        int pillarType = reader.nextInt();

        if (control.registerProjectInPillar(pillarType, id, name, description, status)) {
            System.out.println("Proyecto registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el proyecto. Verifique el tipo de pilar.");
        }
    }

    public void showProjectsByPillar() {
        System.out.println("Ingrese el tipo de Pilar (0: Biodiversidad, 1: Agua, 2: Tratamiento de Basuras, 3: Energía): ");
        System.out.println("Ingrese solo por favor el numero del pilar al cual desea consultar los proyectos");
        int pillarType = reader.nextInt();
        String projects = control.queryProjectsByPillar(pillarType);
        System.out.println(projects);
    }
    
}
