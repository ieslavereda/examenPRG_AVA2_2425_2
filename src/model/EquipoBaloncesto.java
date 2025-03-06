package model;

import java.util.ArrayList;
import java.util.List;

public class EquipoBaloncesto extends Equipo{

    public EquipoBaloncesto(String nombre) {
        super(nombre);
    }

    public List<JugadorBaloncesto> getJugadoresPorPosicion(){
        List<JugadorBaloncesto> jugadores = new ArrayList<>();
        //Se lo pedimos así?? porque no sabrán castearlo en general
        for(Jugador jugador:getJugadores()){
            jugadores.add((JugadorBaloncesto) jugador);
        }
        jugadores.sort(JugadorBaloncesto.POR_POSICION);
        return jugadores;
    }

}
