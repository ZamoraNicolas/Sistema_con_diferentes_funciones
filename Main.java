import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        Menu menu = new Menu(estudiantes);
    }
}

class Menu {
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Estudiante> estudiantes;

    public Menu(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;

        while (true) {
            System.out.println("Bienvenido al sistema de gestion de estudiantes");
            System.out.println("1. Registrar estudiantes");
            System.out.println("2. Ingresar calificaciones");
            System.out.println("3. Mostrar reporte");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if(opcion==1){
                    Estudiante();
            }
            else if(opcion==2){
                    Calificaciones();
            }
            else if(opcion==3){
                    Reporte();
            }
            else if(opcion==4){
                    System.out.println("El proceso ha sido finalizado");
            }
            else if ((opcion!=1)||(opcion!=2)||(opcion!=3)||(opcion!=4)){
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void Estudiante() {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el apellido del estudiante: ");
        String apellido = scanner.nextLine();

        System.out.print("Ingrese la edad del estudiante: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre, apellido, edad);
        estudiantes.add(estudiante);
    }

    private void Calificaciones() {
        System.out.println("Ingrese las calificaciones:");
        for (Estudiante estudiante : estudiantes) {
            System.out.print("Calificación de: " + estudiante.getNombre()+ " ");
            int calificacion = scanner.nextInt();
            estudiante.setCalificacion(calificacion);
        }
    }

    private void Reporte() {
        System.out.println("Reporte de estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            estudiante.mostrarInformacion();
            if (estudiante.getPromedio() > 80) {
                System.out.println("Promedio: Alto(Aprobado)");
            } 
            else if((estudiante.getPromedio() > 60)&&(estudiante.getPromedio() < 80)) {
                System.out.println("Promedio: Regular (Aprobado)");
            }
            else if (estudiante.getPromedio() < 60) {
                System.out.println("Promedio: Bajo(Reprobado)");
            } 
            
            
           
        }
    }
}

interface Identificacion {
    void identificacion();
}

class Estudiante implements Identificacion {
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Integer> calificaciones;

    public Estudiante(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(int calificacion) {
        calificaciones.add(calificacion);
    }

    public double getPromedio() {
        int suma = 0;
        for (int calificacion : calificaciones) {
            suma = suma + calificacion;
        }
        return (int) suma / calificaciones.size();
    }

    public void mostrarInformacion() {
        System.out.println("El estudiante: " + nombre+ " "+ apellido+ " que tiene "+edad+ " años, tiene un promedio de " + getPromedio());
    }

    @Override
    public void identificacion() {
        System.out.println("Identificación de Estudiante");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
    }
}

