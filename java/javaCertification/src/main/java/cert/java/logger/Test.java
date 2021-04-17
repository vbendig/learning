package cert.java.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    private static Logger logger;

    static {
        String path = Test.class.getClassLoader()
                .getResource("logging.properties")
                .getFile();
        System.setProperty("java.util.logging.config.file", path);
        logger = Logger.getLogger(Test.class.getName());
    }
    public static void main(String[] args) {
        logger.setLevel(Level.FINEST);
        logger.finest("Finest Hola Mundo");
        logger.fine("Fine Hola Mundo");
        logger.info("Hola Mundo");
        logger.config("Config Hola Mundo");
        logger.warning("Finest Hola Mundo");
        logger.severe("Severe Hola Mundo");

        logger.log(Level.INFO, "Hola {0}", "Mundo!");
    }
}
