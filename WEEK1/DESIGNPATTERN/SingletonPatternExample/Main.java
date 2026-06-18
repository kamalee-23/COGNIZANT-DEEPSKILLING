public class Main {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        logger1.logMessage("Application started");

        Logger logger2 = Logger.getInstance();
        logger2.logMessage("Processing request");

        System.out.println("Logger1 HashCode: " + logger1.hashCode());
        System.out.println("Logger2 HashCode: " + logger2.hashCode());

        if (logger1 == logger2) {
            System.out.println("Singleton Pattern Verified: Only one instance exists");
        } else {
            System.out.println("Singleton Pattern Failed");
        }
    }
}