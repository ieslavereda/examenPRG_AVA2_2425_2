import model.Campeonato;
import model.Equipo;
import model.Jugable;
import model.Jugador;

import java.io.*;

public class GestorFicheros {

    public static void guardarCampeonato(String fichero, Jugable campeonato){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fichero))){
            objectOutputStream.writeObject(campeonato);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Jugable cargarCampeonato(String fichero){
        Jugable campeonato=null;
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fichero))){
            campeonato = (Jugable) objectInputStream.readObject();
        } catch (Exception e){
            e.printStackTrace();
        }
        return campeonato;
    }

    public static void guardarEquiposCampeonatoCSV(String fichero, Campeonato campeonato){
        try(BufferedWriter br = new BufferedWriter(new FileWriter(fichero))){
            for(Equipo equipo:campeonato.getEquipos()){
                String linea = campeonato.getNombre() + ";" + equipo.getNombre();
                for(Jugador jugador: equipo.obtenerJugadores()){
                     linea += ";" + jugador.getNombre();
                }
                br.write(linea);
                br.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
