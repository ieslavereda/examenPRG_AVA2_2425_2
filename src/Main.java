import model.*;

public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato("Autonomico");

        // Crear equipos
        Equipo equipo1 = new EquipoBaloncesto("Pobla BC");
        equipo1.agregarJugador(new Jugador("Pepe G.", Posicion.ALERO));
        equipo1.agregarJugador(new Jugador("Antonio D.", Posicion.PIVOT));
        equipo1.agregarJugador(new Jugador("Miquel J.", Posicion.ALERO));
        equipo1.agregarJugador(new Jugador("Manuel P.", Posicion.ALERO));
        equipo1.agregarJugador(new Jugador("Dionisio M.", Posicion.PIVOT));

        EquipoBaloncesto equipo2 = new EquipoBaloncesto("Eliana BC");
        equipo2.agregarJugador(new Jugador("Luna C.", Posicion.BASE));
        equipo2.agregarJugador(new Jugador("Blanca R.", Posicion.ALERO));
        equipo2.agregarJugador(new Jugador("Pepa C.", Posicion.PIVOT));
        equipo2.agregarJugador(new Jugador("Andrea R.", Posicion.ALERO));
        equipo2.agregarJugador(new Jugador("Davinia L.", Posicion.PIVOT));

        Equipo equipo3 = new EquipoBaloncesto("Lliria BC");
        equipo3.agregarJugador(new Jugador("Vicent P.", Posicion.ALERO));
        equipo3.agregarJugador(new Jugador("Joaquín S.", Posicion.PIVOT));
        equipo3.agregarJugador(new Jugador("Josep R.", Posicion.BASE));
        equipo3.agregarJugador(new Jugador("Carmelo G.", Posicion.ALERO));
        equipo3.agregarJugador(new Jugador("Nancho N.", Posicion.PIVOT));

        // Agregar equipos al campeonato
        campeonato.agregarEquipo(equipo1);
        campeonato.agregarEquipo(equipo2);
        campeonato.agregarEquipo(equipo3);

        System.out.println(equipo2.getJugadoresPorPosicion());
        System.out.println(equipo1);

        // Crear partidos
        Partido partido1 = new Partido(equipo1, equipo2);
        try {
            partido1.setResultado(110, 105);


            Partido partido2 = new Partido(equipo2, equipo1);
            partido2.setResultado(98, 99);

            Partido partido3 = new Partido(equipo3, equipo1);
            partido3.setResultado(100, 108);

            Partido partido4 = new Partido(equipo1, equipo3);
            partido4.setResultado(90, 98);

            Partido partido5 = new Partido(equipo2, equipo3);
            partido5.setResultado(97, 98);

            Partido partido6 = new Partido(equipo3, equipo2);
            partido6.setResultado(100, 98);


            // Agregar partidos al campeonato
            campeonato.agregarPartido(partido1);
            campeonato.agregarPartido(partido2);
            campeonato.agregarPartido(partido3);
            campeonato.agregarPartido(partido4);
            campeonato.agregarPartido(partido5);
            campeonato.agregarPartido(partido6);

            // Mostrar clasificación
            System.out.println(campeonato.mostrarClasificacion());

            // Mostrar detalles del campeonato
            System.out.println(campeonato);

            GestorFicheros.guardarCampeonato("campeonato.dat", campeonato);
            Jugable campeonato1 = GestorFicheros.cargarCampeonato("campeonato.dat");

            System.out.println(campeonato1);
            GestorFicheros.guardarEquiposCampeonatoCSV("fichero.csv", campeonato);

            System.out.println("Los equipos ganadores son:");
            for (Equipo e : campeonato1.mostrarGanador())
                System.out.println(e.getNombre());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}