/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirentproje;

/**
 *
 * @author aslinurtopcu
 */


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

public class LoggerLab {
    
    private static final Logger LOGGER = Logger.getLogger(Robot.class.getName());
    private static final ConsoleHandler HANDLER = new ConsoleHandler();
    private static final String LOG_FILE_NAME = "LoggerLabirent.txt";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    private File logFile;
    private BufferedWriter writer;

    public LoggerLab() {
    logFile = new File(LOG_FILE_NAME);
    try {
        writer = new BufferedWriter(new FileWriter(logFile, true));
    } catch (IOException e) {
        LOGGER.log(Level.SEVERE, "Error creating FileWriter for log file: " + LOG_FILE_NAME, e);
        // optionally, you could throw a custom exception or rethrow the original exception here
    }
}


    public void log(String message) {
        String timestamp = LocalDateTime.now().format(DATE_TIME_FORMATTER);
        String logMessage = timestamp + " - " + message;
        try {
            writer.write(logMessage);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void setup() {
        
        
        LOGGER.setLevel(Level.FINE);
        
        
        HANDLER.setLevel(Level.FINE);
        
        
        LOGGER.addHandler(HANDLER);
        
        
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
