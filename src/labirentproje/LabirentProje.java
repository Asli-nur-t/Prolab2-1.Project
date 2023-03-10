/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labirentproje;

  import java.io.IOException;

import javax.swing.JFrame;


/**
 *
 * @author aslinurtopcu
 */
public class LabirentProje {

	public static void main(String[] args) throws IOException {
		
		JFrame frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(new Izgara());
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	

}

    
}
