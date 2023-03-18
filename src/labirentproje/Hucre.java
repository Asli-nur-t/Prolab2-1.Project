/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labirentproje;

/**
 *
 * @author aslinurtopcu
 */

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Hucre extends JButton  {

	
	
	int satir;
	int sutun;
	boolean engel;
	
	
	
	public Hucre (int satir,int sutun)
	{
		this.satir=satir;
		this.sutun=sutun;
		
		setBackground(Color.white);
               
		setForeground(Color.black);
                //setBorderPainted(false);
                setOpaque(true);
		//addActionListener(this);
		
	}}

