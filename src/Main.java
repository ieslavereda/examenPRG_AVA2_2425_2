public class Main {
    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato("Liga Comarcal - Camp de Túria");

        // Crear equipos
        Equipo equipo1 = new EquipoBaloncesto("Pobla");
        equipo1.agregarJugador(new JugadorBaloncesto("Pepe Gómez", Posicion.ALERO));
        equipo1.agregarJugador(new JugadorBaloncesto("Antonio David", Posicion.PIVOT));
        equipo1.agregarJugador(new JugadorBaloncesto("Miquel Jordano", Posicion.ALERO));
        equipo1.agregarJugador(new JugadorBaloncesto("Manuel Pimienta", Posicion.ALERO));
        equipo1.agregarJugador(new JugadorBaloncesto("Dionisio Man", Posicion.PIVOT));

        Equipo equipo2 = new EquipoBaloncesto("Eliana");
        equipo2.agregarJugador(new JugadorBaloncesto("Luna Curra", Posicion.BASE));
        equipo2.agregarJugador(new JugadorBaloncesto("Blanca Romero", Posicion.ALERO));
        equipo2.agregarJugador(new JugadorBaloncesto("Pepa Cano", Posicion.PIVOT));
        equipo2.agregarJugador(new JugadorBaloncesto("Andrea Ramírez", Posicion.ALERO));
        equipo2.agregarJugador(new JugadorBaloncesto("Davinia López", Posicion.PIVOT));

        Equipo equipo3 = new EquipoBaloncesto("Lliria");
        equipo1.agregarJugador(new JugadorBaloncesto("Vicent Peris", Posicion.ALERO));
        equipo1.agregarJugador(new JugadorBaloncesto("Joaquín Sáez", Posicion.PIVOT));
        equipo1.agregarJugador(new JugadorBaloncesto("Josep Romero", Posicion.BASE));
        equipo1.agregarJugador(new JugadorBaloncesto("Carmelo Gómez", Posicion.ALERO));
        equipo1.agregarJugador(new JugadorBaloncesto("Nancho Nuovo", Posicion.PIVOT));

        // Agregar equipos al campeonato
        campeonato.agregarEquipo(equipo1);
        campeonato.agregarEquipo(equipo2);
        campeonato.agregarEquipo(equipo3);

        System.out.println(((EquipoBaloncesto)equipo2).getJugadoresPorPosicion());
        System.out.println(equipo1);

        // Crear partidos
        Partido partido1 = new Partido(equipo1, equipo2);
        partido1.setResultado(110, 105);

        Partido partido2 = new Partido(equipo2, equipo1);
        partido2.setResultado(98, 98); // Empate

        Partido partido3 = new Partido(equipo3, equipo1);
        partido3.setResultado(100, 108);

        Partido partido4 = new Partido(equipo1, equipo3);
        partido4.setResultado(100, 98);

        Partido partido5 = new Partido(equipo2, equipo3);
        partido5.setResultado(100, 98);

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
        campeonato.mostrarClasificacion();

        // Mostrar detalles del campeonato
        System.out.println(campeonato);
    }
}