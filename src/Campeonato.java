import java.io.*;
import java.util.*;

public class Campeonato implements Jugable, Serializable {
    private String nombre;
    private Set<Equipo> equipos;
    private List<Partido> partidos;
    private Map<Equipo, Clasificacion> clasificacion;

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

    public Map<Equipo, Clasificacion> getClasificacion() {
        return clasificacion;
    }

    @Override
    public void agregarEquipo(Equipo equipo) {
        equipos.add(equipo);
        clasificacion.put(equipo, new Clasificacion(equipo)); // Inicializa equipo
    }

    @Override
    public void agregarPartido(Partido partido) {
        partidos.add(partido);
    }

    @Override
    public String mostrarClasificacion() {
        String resultado = "Clasificación del Campeonato: " + nombre + "\n"+
                            "Equipo"+"\tPts"+"\tPJ"+"\tPG"+"\tPP"+"\n";

        for (Clasificacion cla : obtenerClasificacion())
            resultado += cla.toString() + "\n";

        return resultado;
    }


    private List<Clasificacion> obtenerClasificacion(){
//        equipos.stream()
//                .peek(equipo -> clasificacion.put(equipo, new Clasificacion(equipo)))
//                .forEach(e -> {
//                    partidos.forEach(p -> {
//                        if (p.getGanador().equals(e))
//                            clasificacion.get(e).ganaPartido();
//                        else
//                            clasificacion.get(e).pierdePartido();
//                    });
//                });

        for(Equipo e : equipos)
            clasificacion.put(e, clasificacion.get(e));

        for(Equipo e : equipos)
            for(Partido p : partidos)
                if(p.getGanador().equals(e))
                    clasificacion.get(e).ganaPartido();
                else
                    clasificacion.get(e).pierdePartido();

        List<Clasificacion> clasificacionFinal = new ArrayList<>(clasificacion.values());
        Collections.sort(clasificacionFinal);

        return clasificacionFinal;
    }

    @Override
    public List<Equipo> mostrarGanador() {

        int max = obtenerClasificacion().get(0).getPuntos();

        List<Equipo> ganadores = new ArrayList<>();

        //buscamos todos los ganadores
        for(Clasificacion clasificacion :obtenerClasificacion()){
            if(clasificacion.getPuntos()==max)
                ganadores.add(clasificacion.getEquipo());
        }

        return ganadores;
    }


    @Override
    public String toString() {
        return "Campeonato: " + nombre + "\nEquipos: " + equipos + "\nPartidos: " + partidos;
    }
}
