package cert.java.ejemploparamari;

public class Test {
    public static void main(String[] args) {
        Persona mariangel = new Persona();
        mariangel.nombre = "Mariangel";
        mariangel.apellido = "Bendig Bonilla";
        mariangel.edad = 17;

        System.out.println("Hola " + mariangel.nombre + " " + mariangel.apellido);
    }
}
