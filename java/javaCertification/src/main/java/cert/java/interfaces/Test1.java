package cert.java.interfaces;
interface MoreOrLessProfitable {
    double profitPercentage = 12.0;
}

interface Profitable extends MoreOrLessProfitable{
    double profitPercentage = 42.0;
}

class Business implements Profitable {
    double profitPercentage = 50.0; //Line n1
    public String toString(){
        return "Business";
    }
}

class Pizzeria extends Business {
    public String toString(){
        return "Pizzeria";
    }
}

class PizzeriaItaliana extends Pizzeria {
    public String toString(){
        return "PizzeriaItaliana";
    }
}

public class Test1 {
    public static void main(String[] args) {
        Profitable obj = new Business(); //Line n2
        Profitable pizzeria = new Pizzeria();
        System.out.println(obj.profitPercentage); //Line n3
        System.out.println(((Business) obj).profitPercentage); //Line n3

        System.out.println(obj);
        System.out.println(pizzeria);
        System.out.println((Business)pizzeria);
        System.out.println(pizzeria.profitPercentage);

        MoreOrLessProfitable poorPizzeria = new Pizzeria();
        System.out.println(poorPizzeria.profitPercentage);

        Pizzeria pizzeriaItalia = new PizzeriaItaliana();
        System.out.println(pizzeriaItalia.profitPercentage);
    }
}
