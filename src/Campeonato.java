import java.io.*;
import java.util.*;

public class Campeonato implements Jugable, Serializable {
    private String nombre;
    private Set<Equipo> equipos;
    private List<Partido> partidos;
    private Map<Equipo, Integer> clasificacion;

    public Campeonato(String nombre) {
        this.nombre = nombre;
        this.equipos = new HashSet<>();
        this.partidos = new ArrayList<>();
        this.clasificacion = new TreeMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }

    public Map<Equipo, Integer> getClasificacion() {
        return clasificacion;
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
    public String mostrarClasificacion() {
        String resultado = "Clasificación del Campeonato: " + nombre + "\n"+
                            "Equipo"+"\tPts"+"\tPJ"+"\tPG"+"\tPP"+"\n";

        for (ClasificacionItem cla : obtenerClasificacion())
            resultado += cla.toString() + "\n";

        return resultado;
    }


    private List<ClasificacionItem> obtenerClasificacion(){
        Map<Equipo, ClasificacionItem> clasificacion = new HashMap<>();

        equipos.stream()
                .peek(equipo -> clasificacion.put(equipo, new ClasificacionItem(equipo)))
                .forEach(e -> {
                    partidos.forEach(p -> {
                        if (p.getGanador().equals(e))
                            clasificacion.get(e).ganaPartido();
                        else
                            clasificacion.get(e).pierdePartido();

                    });
                });

        List<ClasificacionItem> clasificacionFinal = new ArrayList<>(clasificacion.values());
        Collections.sort(clasificacionFinal);

        return clasificacionFinal;
    }

    @Override
    public List<Equipo> mostrarGanador() {

//        return obtenerClasificacion().get(0);

        List<Equipo> ganadores = new ArrayList<>();
        List<Integer> puntos = new ArrayList<>(clasificacion.values());
        Collections.sort(puntos);
        int max = puntos.get(puntos.size() - 1);
        for (Equipo equipos1 : clasificacion.keySet()) {
            if (clasificacion.get(equipos1) == max)
                ganadores.add(equipos1);
        }
        return ganadores;
    }


    @Override
    public String toString() {
        return "Campeonato: " + nombre + "\nEquipos: " + equipos + "\nPartidos: " + partidos;
    }
}
