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

public class Hucre extends JButton implements ActionListener {

	
	Hucre ata;
	int satir;
	int sutun;
	int gMaliyer;
	int hMaliyet;
	int fMaliyet;
	boolean baslangic;
	boolean bitis;
	boolean engel;
	boolean open;
	boolean kontrol;
	
	
	public Hucre (int satir,int sutun)
	{
		this.satir=satir;
		this.sutun=sutun;
		
		setBackground(Color.white);
		setForeground(Color.black);
                  setBorderPainted(false);
            setOpaque(true);
		addActionListener(this);
		
	}
	
    //baslangic dugumu tanimlayan fonksiyon
	public void Baslangic()
	{
		setBackground(Color.green);
                  setBorderPainted(false);
            setOpaque(true);
		//setForeground(Color.white);
		//setText("BASLANGİC");
		baslangic=true;
	}
	
	//bitis dugum tanımlayan fonksiyon
	public void Bitis()
	{
		setBackground(Color.red);
                  setBorderPainted(false);
            setOpaque(true);
		//setForeground(Color.white);
		//setText("BİTİS");
		bitis=true;
	}
	
	//engel olusturma
	public void Engel()
	{
		setBackground(Color.black);
                  setBorderPainted(false);
            setOpaque(true);
		engel=true;
		
		
	}
	
	public void EngelYani()
	{
		setBackground(Color.yellow);
                  setBorderPainted(false);
            setOpaque(true);
	}
	

	
	//buton aksiyonu sonucu  hucre turuncu rengi alır
	@Override
	public void actionPerformed(ActionEvent e) {
		
		 setBackground(Color.orange); 
		  setBorderPainted(false);
            setOpaque(true);
		
	}

	
	
}
