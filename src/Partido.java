public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int puntosLocal;
    private int puntosVisitante;

    public Partido(Equipo equipoLocal, Equipo equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = 0;
        this.puntosVisitante = 0;
    }

    public void setResultado(int puntosLocal, int puntosVisitante) {
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    @Override
    public String toString() {
        return equipoLocal.getNombre() + " " + puntosLocal + " - " + puntosVisitante + " " + equipoVisitante.getNombre();
    }
}
