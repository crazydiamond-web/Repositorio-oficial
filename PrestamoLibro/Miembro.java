package PrestamoLibro;

public class Miembro {
    String nombre;
    int id;

    Miembro(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
    }

    void mostrarInfo() {
        System.out.println("Nombre del miembro: " + this.nombre);
        System.out.println("ID del miembro: " + this.id);
    }
}
