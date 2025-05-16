import java.util.Random;

class Orco extends Personaje{
    public Orco() {
        super("Orco", 120, 100, 14, 0.1, 0.2, 1.5);
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        System.out.println(" Orco Habilidad Especial Furia Asesinaaaaaaaaaaaaa doblou atack ");

        if (new Random().nextDouble() > objetivo.probabilidadEsquivar) {

            int damage = ataqueBase;
            objetivo.recibirDamage(damage);
            System.out.println(nombre + " ataco a " + objetivo.nombre + " causando " + damage + " de damage");
        }else {
            System.out.println(nombre + " esquivo el ataque furioso de gorda orca ");
        }


    }
}
