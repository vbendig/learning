package cert.java.inheritance;

class Document {
    int pages;
    Document(int pages) {
        this.pages = pages;
    }

    public static void main(String[] args) {
        System.out.println("test");
    }
}

class Word extends Document {
    String type;
    Word(String type) {
        super(20); //default pages
        this.type = type;
    }

    Word(int pages, String type) {
        this(type);
        super.pages = pages;
    }

    public static void main(String[] args) {
        System.out.println("another test");
    }
}

public class Test {
    public static void main(String[] args) {
        Document obj = new Word(25, "TEXT");
        obj.main(args);
        System.out.println(String.join(",", ((Word)obj).type, obj.pages + ""));
    }
}
