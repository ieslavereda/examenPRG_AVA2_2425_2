package model;

import java.io.Serializable;

public class Clasificacion implements Comparable<Clasificacion>, Serializable {

    private Equipo equipo;
    private int partidosGanados;
    private int partidosPerdidos;

    public Clasificacion(Equipo equipo) {
        this.equipo = equipo;
        this.partidosGanados = 0;
        this.partidosPerdidos = 0;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public int getPuntos() {
        return partidosGanados*2+partidosPerdidos;
    }

    public int getPartidosJugados() {
        return partidosGanados+partidosPerdidos;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }


    public void ganaPartido(){
        this.partidosGanados++;
    }

    public void pierdePartido(){
        this.partidosPerdidos++;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Clasificacion cla)
            return this.equipo.equals(cla.equipo);

        return false;
    }

    @Override
    public String toString() {
        return  equipo.getNombre() + "\t" + getPuntos() + "\t" + getPartidosJugados() + "\t" + partidosGanados + "\t" + partidosPerdidos;
    }

    @Override
    public int compareTo(Clasificacion c) {
        if(getPuntos()!=c.getPuntos())
            return c.getPuntos()-getPuntos();
        if(getPartidosGanados()!=c.getPartidosGanados())
            return c.getPartidosGanados()-getPartidosGanados();

        return equipo.getNombre().compareToIgnoreCase(c.getEquipo().getNombre());
    }
}
