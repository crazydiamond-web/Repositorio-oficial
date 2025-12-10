package PrestamoLibro;

public class Main {
    public static void main(String[] args) {

        Libro l1 = new Libro("Dragon ball", "Akira Toriyama", "-13(Volumen 1):978-4088512594", false);
        Miembro m1 = new Miembro("Yordany", 1237203);

        l1.mostrarInfo();
        m1.mostrarInfo();
    }
}
