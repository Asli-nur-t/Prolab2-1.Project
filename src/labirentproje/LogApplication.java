/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirentproje;

/**
 *
 * @author aslinurtopcu
 */

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogApplication {
    private static final Logger LOGGER = Logger.getLogger(KullaniciLabirenti.class.getName());
    
    public static void main(String[] args) {
        try {
            // log iletilerini "Labirent2Log.log" adlı bir dosyaya yazan bir FileHandler oluşturur
            FileHandler fileHandler = new FileHandler("Labirent2Log.log");
            
            // log iletilerini biçimlendirmek için bir SimpleFormatter kullanmak üzere fileHandler'ı yapılandırır
            fileHandler.setFormatter(new SimpleFormatter());
            
            //Tüm mesajları loga kaydetmek için log düzeyini Level.ALL olarak ayarlar
            LOGGER.setLevel(Level.ALL);
            
            // fileHandler'ı loga ekler
            LOGGER.addHandler(fileHandler);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error initializing logger", e);
        }
        
        //Bazı iletileri farklı log düzeylerinde loga kaydeder
        LOGGER.severe("This is a severe message");
        LOGGER.warning("This is a warning message");
        LOGGER.info("This is an info message");
        LOGGER.config("This is a config message");
        LOGGER.fine("This is a fine message");
        LOGGER.finer("This is a finer message");
        LOGGER.finest("This is the finest message");
    }
}
