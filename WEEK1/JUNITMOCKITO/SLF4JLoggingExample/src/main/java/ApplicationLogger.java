import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApplicationLogger {

    private static final Logger logger =
            LoggerFactory.getLogger(ApplicationLogger.class);

    public static void main(String[] args) {

        logger.error("Error: Invalid user credentials.");

        logger.warn("Warning: Password will expire in 5 days.");

    }
}