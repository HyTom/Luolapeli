
import Logiikka.Pelilogiikka.Peli;
import UI.PeliSovellus;

public class Main {

    public static void main(String[] args) {
        Peli peli = new Peli();
        PeliSovellus peliSovellus = new PeliSovellus(peli);
        peliSovellus.aloita();

    }

}
