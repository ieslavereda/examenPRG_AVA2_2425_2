import java.io.Serializable;
import java.util.Objects;

public abstract class Jugador implements Comparable<Jugador>, Serializable {
    private String nombre;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


    @Override
    public String toString() {
        return "Jugador: "+nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return Objects.equals(nombre, jugador.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }


    @Override
    public int compareTo(Jugador jugador) {
        return nombre.compareTo(jugador.getNombre());
    }

}
