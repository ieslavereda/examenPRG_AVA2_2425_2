public class ClasificacionItem implements Comparable<ClasificacionItem> {

    private Equipo equipo;
    private int partidosGanados;
    private int partidosPerdidos;

    public ClasificacionItem(Equipo equipo) {
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

        if (obj instanceof ClasificacionItem cla)
            return this.equipo.equals(cla.equipo);

        return false;
    }

    @Override
    public String toString() {
        return  equipo.getNombre() + "\t" + getPuntos() + "\t" + getPartidosJugados() + "\t" + partidosGanados + "\t" + partidosPerdidos;
    }

    @Override
    public int compareTo(ClasificacionItem c) {
        if(getPuntos()==c.getPuntos()){
            return c.getPartidosGanados()-getPartidosGanados();
        }else
            return c.getPuntos()-getPuntos();
    }
}
