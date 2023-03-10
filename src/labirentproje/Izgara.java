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
import java.awt.Dimension;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JPanel;

import java.util.Random;
import java.util.ArrayList;


public class Izgara extends JPanel {
	
	
	
	public static int[][] urlOkuycu() throws IOException {

		ArrayList<String> url1 = new ArrayList<>();

		int matris1boyut = 0;

		URL url = new URL("http://bilgisayar.kocaeli.edu.tr/prolab2/url2.txt");

		URLConnection httpUrlConnection = url.openConnection();
		InputStream yaz = httpUrlConnection.getInputStream();
		BufferedReader oku = new BufferedReader(new InputStreamReader(yaz));
		String line = "";
		while ((line = oku.readLine()) != null) {

			matris1boyut = line.length();
			url1.add(line);

		}

		int matris1[][] = new int[matris1boyut][matris1boyut];

		for (int i = 0; i < matris1boyut; i++) {        
			for (int j = 0; j < matris1boyut; j++) {

				matris1[i][j] = Integer.parseInt(String.valueOf(url1.get(i).charAt(j)));
			}
		}



		oku.close();
		return matris1;
	}

//-----------------------------------------------------------------------------------------------------------------------------
	
	int satir;
	int sutun;
	int goz=30;
	int cerceveSatir;
	int cerceveSutun=sutun*goz;
	int engeldegisken=0;
	int i=0;
	int j=0;
	
	Hucre [][] hucre;
	Hucre baslangicHucresi,bitisHucresi,hareketHucresi;
	
	
	Random r =new Random();
	int baslangicNoktasiBelirle=r.nextInt(4);
	
	
	
	
	public Izgara() throws IOException
	{
		int prob1matris1[][]=urlOkuycu();
		
		satir=prob1matris1.length+2;
		sutun=prob1matris1.length+2;
		
		hucre=new Hucre[satir][sutun];
		cerceveSatir=satir*goz;
		cerceveSutun=sutun*goz;
		
//		
//		 for(int k=0;k<prob1matris1.length;k++)
//		        {
//		        	for(int l=0;l<prob1matris1.length;l++)
//		        	{
//		       System.out.print(prob1matris1[k][l]);
//		        		
//		        	}
//		        	
//		        	System.out.println();
//		        	
//		        }
//		 
		 
		 
	
		
		
		//panelin boyutunu ve rengini ayarla
		 
		this.setPreferredSize(new Dimension(cerceveSatir,cerceveSutun));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(satir,sutun));
		
		
		//hucreleri panele yerlestiriyoruz
		
		
		
		while(i<satir && j<sutun)
		{
			hucre[i][j]=new Hucre(i,j);
			this.add(hucre[i][j]);
			
			j ++;
			if(j==sutun)
			{
				j=0;
				i++;
			}
		}
		
		//baslangic ve bitis noktalarini izgarada belirleme
		
		 if(baslangicNoktasiBelirle==0)
		 {
			 BaslangicDugum(1,1);
			 BitisDugum(satir-2,satir-2);
			 
			 
		 }
		 else if(baslangicNoktasiBelirle==1)
		 {
			 BaslangicDugum(1,satir-2);
			 BitisDugum(satir-2,1);
		 }
		 else if(baslangicNoktasiBelirle==2)
		 {
			 BaslangicDugum(satir-2,1);
			 BitisDugum(1,satir-2);
			 
			 
		 }
		 else if(baslangicNoktasiBelirle==3)
		 {
			 BaslangicDugum(satir-2,satir-2);
			 BitisDugum(1,1);
		 }
		 
		 
//-----------------------------------------------------------------------------------------------------		 
		 //engel olusturuyoruz 
		
		 int a,b;
		 
		//cerceve boyaniyor
		 
		for(a=0;a<satir;a++)
		{
			Cerceve(0,a);
		}
		for(a=0;a<satir;a++)
		{
			Cerceve(a,0);
		}
		for(a=0;a<satir;a++)
		{
			Cerceve(a,satir-1);
		}
		
		for(a=1;a<satir-1;a++)
		{
			Cerceve(satir-1,a);
		}
		 
		 
		 
		 for( a=0;a<prob1matris1.length;a++)
		 {
			 for( b=0;b<prob1matris1.length;b++)
			 {
				 if(prob1matris1[a][b]==1)
				 {
					 EngelOlustur(a,b);
				 }
				 
			 }
		 } 
		 
			
			 for(a=0;a<prob1matris1.length;a++)
			 {
				 for( b=0;b<prob1matris1.length;b++)
				 {
					 if(prob1matris1[a][b]==2)
					 {
						 EngelOlustur(a,b);
						 b++;
						 engelYani(a, b);
						 
					 }
					 
					 
				 }
				 
				 
			 
				 
				 for(int p=0;p<prob1matris1.length;p++)
				 {
					 for( int m=0;m<prob1matris1.length;m++)
					 {
						 if(prob1matris1[p][m]==3)
						 {
							 if(p%2==0)
							
							 {
								 engelYani(p,m);
								 m++;
								 engelYani(p,m);
								 m++;
								 EngelOlustur(p,m);
							 }
							 else if((p%2)!=0)
							 {
								 EngelOlustur(p,m);
								 m++;
								 EngelOlustur(p,m);
								 m++;
								 EngelOlustur(p,m);
								 
							 }
							 
						 
						 }
						 
					 }
				 }
				 
				 
//-----------------------------------------------------------------------------------------------------				 
				 
			 		
			 
		 }
		
		
		
	}
	
	public void BaslangicDugum(int satir,int sutun)
	{
		hucre[satir][sutun].Baslangic();
		baslangicHucresi=hucre[satir][sutun];
		hareketHucresi=baslangicHucresi;
		
	}
	
	public void BitisDugum(int satir,int sutun)
	{
		hucre[satir][sutun].Bitis();
		bitisHucresi=hucre[satir][sutun];
		
		
	}
	
	public void EngelOlustur(int satir,int sutun)
	{
		hucre[satir+1][sutun+1].Engel();
		
		
	}
	
	public void engelYani(int satir,int sutun)
	{
		hucre[satir+1][sutun+1].EngelYani();
		
	}
	
	public void Cerceve(int satir,int sutun)
	{
		hucre[satir][sutun].Engel();
	}
	
	
	

}
