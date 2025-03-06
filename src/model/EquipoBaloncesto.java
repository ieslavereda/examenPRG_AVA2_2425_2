package model;

import java.util.ArrayList;
import java.util.List;

public class EquipoBaloncesto extends Equipo {

    public EquipoBaloncesto(String nombre) {
        super(nombre);
    }

    public List<Jugador> getJugadoresPorPosicion(){
        List<Jugador> jugadores = new ArrayList<>(obtenerJugadores());
        jugadores.sort(Jugador.POR_POSICION);
        return jugadores;
    }

}
