import java.util.Random;

abstract class Personaje {

    protected String nombre;
    protected int salud;
    protected int saludMaxima;
    protected int ataqueBase;
    protected double probabilidadEsquivar;
    protected double probabilidadCritico;
    protected double multiplicadorCritico;

    public Personaje(String nombre, int salud, int saludMaxima, int ataqueBase, double probabilidadEsquivar, double probabilidadCritico, double multiplicadorCritico) {
        this.nombre = nombre;
        this.salud = salud;
        this.saludMaxima = saludMaxima;
        this.ataqueBase = ataqueBase;
        this.probabilidadEsquivar = probabilidadEsquivar;
        this.probabilidadCritico = probabilidadCritico;
        this.multiplicadorCritico = multiplicadorCritico;
    }

    public boolean estaVivo() {
        return salud > 0;
    }
    public void atacar(Personaje objetivo ){
        Random random = new Random();

        if (random.nextDouble() < objetivo.probabilidadEsquivar){
            System.out.println(nombre + " esquivo el ataque");
            return;
        }

        int damage= ataqueBase;
        boolean esCritico = random.nextDouble() < probabilidadCritico;

if (esCritico) {
            damage = (int) (damage * multiplicadorCritico);
            System.out.println(nombre + " ATAQUE CRITICO ");
        }

objetivo.recibirDamage(damage);
        System.out.println(nombre + "ataco a " + objetivo.nombre + " causando " + damage + " de damage");
    }

    public void recibirDamage(int damage){
        salud = Math.max(0 , salud- damage);
    }

    public abstract void usarHabilidadEspecial(Personaje objetivo);

    public void mostrarEstadisticas(){
        System.out.println(nombre + " tiene " + salud + " de salud");
        System.out.println(nombre + " tiene " + saludMaxima + " de salud maxima");
        System.out.println(nombre + " tiene " + ataqueBase + " de ataque base");
        System.out.println(nombre + " tiene " + probabilidadEsquivar + " de probabilidad de esquivar");
        System.out.println(nombre + " tiene " + probabilidadCritico + " de probabilidad de critico");
        System.out.println(nombre + " tiene " + multiplicadorCritico + " de multiplicador de critico");

    }
    public int getSalud() {
        return salud;
    }

}
