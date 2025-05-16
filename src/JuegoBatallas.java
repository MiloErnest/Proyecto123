import java.util.Random;
import java.util.Scanner;

public class JuegoBatallas {
    public static void main(String[] args) {

 new JuegoBatallas().iniciarJuego();
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Btalla de heroes y orcos");
        System.out.println("1. elige a tu heroe, mayor probabilidad de critico ");
        System.out.println("2. elige a tu orco, mayor probabilidad de esquivar ");
        System.out.println("opcion :");
        int opcion = scanner.nextInt();

        Personaje jugador = (opcion == 1) ? new Heroe() : new Orco() ;
        Personaje enemigo = (opcion == 1) ? new Orco() : new Heroe();

        System.out.println("estadisticas de los personajes ");
        jugador.mostrarEstadisticas();

        System.out.println("comeinza la batalla ");
        realizarCombate(jugador, enemigo);

        scanner.close();


    }

    private void realizarCombate(Personaje jugador, Personaje enemigo) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int turno = 1;

        while (jugador.estaVivo() && enemigo.estaVivo()) {

            System.out.println("\n=== turno " + turno);

            System.out.println("1. ATACAR");
            System.out.println("2. Usar Habilidad Especial");
            System.out.println("elige una opcion :");
            int accion = scanner.nextInt();

            if (accion == 1) {
                jugador.atacar(enemigo);
            } else {
                jugador.usarHabilidadEspecial(enemigo);
            }

            if (!enemigo.estaVivo()) {
                System.out.println("el enemigo esta muerto");
                break;
            }

            System.out.println("turno del enemigo ");
            if (random.nextDouble() < 0.3) {
                enemigo.usarHabilidadEspecial(jugador);
            } else {
                enemigo.atacar(jugador);
            }
            if (!jugador.estaVivo()) {
                System.out.println("has sido derrotado ");
                break;
            }

            System.out.println("\n estado despues del turno " + turno + " :");
            System.out.println("salud " + jugador.getSalud());
            System.out.println(" - salud enemiga" + enemigo.getSalud());

            turno++;
        }
        scanner.close();
    }
}
