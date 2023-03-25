/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirentproje;

/**
 *
 * @author aslinurtopcu
 */
import java.util.logging.*;

public class LoggerLab {
    
    private static final Logger LOGGER = Logger.getLogger(Robot.class.getName());
    private static final ConsoleHandler HANDLER = new ConsoleHandler();
    
    public static void setup() {
        
        // set the log level to FINE
        LOGGER.setLevel(Level.FINE);
        
        // set the console handler to FINE
        HANDLER.setLevel(Level.FINE);
        
        // add the console handler to the logger
        LOGGER.addHandler(HANDLER);
        
        // set the formatter for the console handler
        HANDLER.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return "[" + record.getLevel() + "] " + record.getMessage() + "\n";
            }
        });
    }
    
    public static void logInfo(String message) {
        LOGGER.info(message);
    }
    
    public static void logWarning(String message) {
        LOGGER.warning(message);
    }
    
    public static void logFine(String message) {
        LOGGER.fine(message);
    }
    
    public static void logFiner(String message) {
        LOGGER.finer(message);
    }
    
    public static void logFinest(String message) {
        LOGGER.finest(message);
    }
}
