import java.util.*;

public class Campeonato implements Jugable{
    private String nombre;
    private Set<Equipo> equipos;
    private List<Partido> partidos;
    private Map<Equipo, Integer> clasificacion;

    public Campeonato(String nombre) {
        this.nombre = nombre;
        this.equipos = new HashSet<>();
        this.partidos = new ArrayList<>();
        this.clasificacion = new TreeMap<>(); //<-- esto lo facilitaremos
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
        clasificacion.put(equipo, 0); // Inicializa los puntos del equipo a 0
    }

    @Override
    public void agregarPartido(Partido partido) {
        partidos.add(partido);
        actualizarClasificacion(partido);
    }

    private void actualizarClasificacion(Partido partido) {
        int puntosLocal = partido.getPuntosLocal();
        int puntosVisitante = partido.getPuntosVisitante();

        if (puntosLocal > puntosVisitante) {
            clasificacion.put(partido.getEquipoLocal(), clasificacion.get(partido.getEquipoLocal()) + 3);
        } else if (puntosLocal < puntosVisitante) {
            clasificacion.put(partido.getEquipoVisitante(), clasificacion.get(partido.getEquipoVisitante()) + 3);
        } else {
            clasificacion.put(partido.getEquipoLocal(), clasificacion.get(partido.getEquipoLocal()) + 1);
            clasificacion.put(partido.getEquipoVisitante(), clasificacion.get(partido.getEquipoVisitante()) + 1);
        }
    }

    @Override
    public void mostrarClasificacion() {
        System.out.println("Clasificación del Campeonato: " + nombre);
        for(Equipo equipos1: clasificacion.keySet()){
            System.out.println(equipos1.getNombre() + " - Puntos: " + clasificacion.get(equipos1));
        }
    }

    @Override
    public String toString() {
        return "Campeonato: " + nombre + "\nEquipos: " + equipos + "\nPartidos: " + partidos;
    }
}
