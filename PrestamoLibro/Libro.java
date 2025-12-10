 package PrestamoLibro;

 public class Libro {
        String titulo;
        String autor;
        String isbn;
        boolean estaPrestado;

        Libro(String titulo, String autor, String isbn, boolean estaPrestado) {
            this.titulo = titulo;
            this.autor = autor;
            this.isbn = isbn;
            this.estaPrestado = estaPrestado;
        }

        void mostrarInfo() {
            System.out.println("Título: " + this.titulo);
            System.out.println("Autor: " + this.autor);
            System.out.println("ISBN: " + this.isbn);
            System.out.println("¿Prestado?: " + this.estaPrestado);
        }

        void prestar() {
            this.estaPrestado = true;
            System.out.println("El libro fue prestado.");
        }

        void devolver() {
            this.estaPrestado = false;
            System.out.println("El libro fue devuelto.");
        }
    }

