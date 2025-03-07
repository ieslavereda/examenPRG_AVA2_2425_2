package model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Jugador implements Comparable<Jugador>, Serializable {

    public static final Comparator<Jugador> POR_POSICION = new Comparator<Jugador>() {
        @Override
        public int compare(Jugador j1, Jugador j2) {
            if(j1.getPosicion()!=j2.getPosicion())
                return j1.getPosicion().compareTo(j2.getPosicion());

            return j1.getNombre().compareToIgnoreCase(j2.getNombre());
        }
    };

    private String nombre;
    private Posicion posicion;

    public Jugador(String nombre,Posicion posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
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
