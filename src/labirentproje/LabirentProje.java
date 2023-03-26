/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labirentproje;

import java.awt.Dimension;
  import java.io.IOException;
import javax.swing.JButton;

import javax.swing.JFrame;


/**
 *
 * @author aslinurtopcu
 */
 class LabirentProje {
                

	 static void LabirentProje () throws IOException {
		//JFrame GirisEkran = new GirisEkran();
		JFrame frame=new JFrame();
                LoggerLab.logInfo("Problem 1 için frame açıldı.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.setResizable(false);
               // frame.add(new Hucre(1,1));
                frame.setPreferredSize(new Dimension(1000,1000));
		frame.add(new Izgara());
                
                
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
                Problem1.FrameSilme(frame);
           
                

}
        
        

    
}
