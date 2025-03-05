import java.util.List;

public interface Jugable {
    void agregarEquipo(Equipo equipo);
    void agregarPartido(Partido partido);
    String mostrarClasificacion();
    List<Equipo> mostrarGanador();

}
