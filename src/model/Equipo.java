package model;

import java.io.Serializable;
import java.util.*;

public abstract class Equipo implements Comparable<Equipo>, Serializable {

    private String nombre;
    private Set<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new TreeSet<>();
    }

    public void agregarJugador(Jugador jugador) {
        jugadores.add(jugador);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> obtenerJugadores() {
        List<Jugador> jugadoresList = new ArrayList<>(jugadores);
        Collections.sort(jugadoresList);
        return jugadoresList;
    }

    @Override
    public String toString() {
        return "model.Equipo: " + nombre + " Jugadores: " + jugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Equipo equipo) {
        return nombre.compareToIgnoreCase(equipo.getNombre());
    }

}
