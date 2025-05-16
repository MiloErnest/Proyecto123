

class Heroe extends Personaje{
    public Heroe() {
        super(" Heroe ", 100, 100, 10, 0.2, 0.1, 1.5);
    }

    @Override
    public void usarHabilidadEspecial(Personaje objetivo) {
        System.out.println(nombre + " usa la habilidad especial"+ "ataque critico garantizado ");
        int damage = (int) (ataqueBase * multiplicadorCritico);
        objetivo.recibirDamage(damage);
        System.out.println(nombre + " ataco a " + objetivo.nombre + " causando " + damage + " de damage");
    }
}

