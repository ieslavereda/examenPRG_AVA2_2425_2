import java.util.Comparator;

public class JugadorBaloncesto extends Jugador{

    public static final Comparator<JugadorBaloncesto> POR_POSICION = new Comparator<JugadorBaloncesto>() {
        @Override
        public int compare(JugadorBaloncesto jugador1, JugadorBaloncesto jugador2) {
            if(jugador1.getPosicion()==jugador2.getPosicion())
                return jugador1.getNombre().compareTo(jugador2.getNombre());
            return jugador1.getPosicion().compareTo(jugador2.getPosicion());
        }
    };

    private Posicion posicion;

    public JugadorBaloncesto(String nombre, Posicion posicion) {
        super(nombre);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + posicion;
    }
}
