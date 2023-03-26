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
import java.io.IOException;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Robot {
	
	ArrayList <Integer> yol1BoyaSatir = new ArrayList<>(); 
	ArrayList <Integer> yol1BoyaSutun = new ArrayList<>(); 
	ArrayList <Integer> yol1BoyaSatirEnk = new ArrayList<>(); 
	ArrayList <Integer> yol1BoyaSutunEnk = new ArrayList<>(); 
        
        LoggerLab logger = new LoggerLab();
  
	int x=0;
	
	
public 	Timer zaman=new Timer();
public 	Timer zaman2=new Timer();

	Hucre [][]hucre;
	static int sayac=0;
	int p=0;
	
	
	
	
	Robot (Hucre [][]hucre)
	{
		this.hucre=hucre;
		
	}
	
  
	
	
	
   public boolean gidilebilirHucre(int [][] matris1,int satir,int sutun)
   {
	  
	   return (satir>=0 && satir<matris1.length && sutun>=0 && sutun< matris1.length && matris1[satir][sutun]==0);
	   
   }
   
   
   
   
   
   
   public boolean Yol1(int[][] matris1,boolean [][]ziyaretEdilen, int i,int j,int x,int y)
   
   
   //baslangic sol us  bitis sag alt
   //iJ==0 0 x=19 y=19
   //i ve j bulundugumuz indis 
   // x ve y hedef
   
   {
	   if(i==x && j==y)
	   { 
		   return true ;
	   }
	   
	 
	   if(gidilebilirHucre(matris1, i, j))
	   {
		  
		   ziyaretEdilen[i][j]=true;
		   
		   
		   boolean flag=true;
		   
		   for(int m=0;m<yol1BoyaSatir.size();m++)
		   {
			   
			   if(yol1BoyaSatir.get(m)== i+1 && yol1BoyaSutun.get(m)== j+1)
			   {        
				   flag =false;
				   break;
			   }
		   }
		   
		   if(flag==true)
		   {        sayac ++;
			   yol1BoyaSatir.add(i+1);
			   yol1BoyaSutun.add(j+1);
		   }
		   
		   
		   // hucre[i+1][j+1].setBackground(Color.cyan);
		  
		
		
		   
		 //once asagi sonra sag
		   
		   if(Yol1(matris1,ziyaretEdilen,i+1,j,x,y))
		   {
			   
			   yol1BoyaSatirEnk.add(i+2);
			   yol1BoyaSutunEnk.add(j+1);
			   //hucre[i+2][j+1].Ilerleme();
			   return true;
		   }
		   
		   if(Yol1(matris1,ziyaretEdilen,i,j+1,x,y))
		   {
			   
			   
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+2);
			  // hucre[i+1][j+2].Ilerleme();
			   return true;
		   }
		   
		   ziyaretEdilen[i][j]=true;
                   
		   return false;
		   
		   
	   }
		   
	  
	   return false;
   }
   
   
   
   
 
   
   
   public boolean Yol2(int[][] matris1,boolean [][]ziyaretEdilen, int i,int j,int x,int y)
   
   //basla sag alt bitis sol ust 
   //i ve j bulundugumuz indis 
   // x ve y hedef
   // 
   {
	   if(i==x && j==y)
	   { 
		   return true ;
	   }
	   
	   if(gidilebilirHucre(matris1, i, j))
	   {
		   
		   ziyaretEdilen[i][j]=true;
           
  
		   boolean flag=true;
		   
		   for(int m=0;m<yol1BoyaSatir.size();m++)
		   {
			   
			   if(yol1BoyaSatir.get(m)== i+1 && yol1BoyaSutun.get(m)== j+1)
			   {
				   flag =false;
				   break;
			   }
		   }
		   
		   if(flag==true)
		   {        sayac ++;
			   yol1BoyaSatir.add(i+1);
			   yol1BoyaSutun.add(j+1);
		   }
		   
		   
		   
		   
		 
		  // hucre[i+1][j+1].setBackground(Color.cyan);
		   
		   //once yukari sonra sol
		   
		   
		   
		   if(Yol2(matris1,ziyaretEdilen,i-1,j,x,y))
		   {
			   
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			   
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		   if(Yol2(matris1,ziyaretEdilen,i,j-1,x,y))
		   {
			
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		 
		   
		   ziyaretEdilen[i][j]=true;
		   return false;
		   
		   
	   }
		   
	  
	   return false;
   }
   
   
   
   
   
public boolean Yol3(int[][] matris1,boolean [][]ziyaretEdilen, int i,int j,int x,int y)
   
   //i ve j bulundugumuz indis 
   // x ve y hedef
   {
	   if(i==x && j==y)
	   { 
		   return true ;
	   }
	   
	   if(gidilebilirHucre(matris1, i, j))
	   {
		   
          ziyaretEdilen[i][j]=true;
          
		   
		   boolean flag=true;
		   
		   for(int m=0;m<yol1BoyaSatir.size();m++)
		   {
			   
			   if(yol1BoyaSatir.get(m)== i+1 && yol1BoyaSutun.get(m)== j+1)
			   {
				   flag =false;
				   break;
			   }
		   }
		   
		   if(flag==true)
		   {sayac ++;
			   yol1BoyaSatir.add(i+1);
			   yol1BoyaSutun.add(j+1);
		   }
		   
		   
		
		
		   
		  // hucre[i+1][j+1].setBackground(Color.cyan);
		   
		   //once asagi sonra sol
		   if(Yol3(matris1,ziyaretEdilen,i+1,j,x,y))
		   {
			  
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		   if(Yol3(matris1,ziyaretEdilen,i,j-1,x,y))
		   {
			   
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		   ziyaretEdilen[i][j]=true;
		   return false;
		   
		   
	   }
		   
	  
	   return false;
   }





public boolean Yol4(int[][] matris1,boolean [][]ziyaretEdilen, int i,int j,int x,int y)

//i ve j bulundugumuz indis 
// x ve y hedef
{
	   if(i==x && j==y)
	   { 
		   return true ;
	   }
	   
	   if(gidilebilirHucre(matris1, i, j))
	   {
		  
		   
          ziyaretEdilen[i][j]=true;
          
		   
		   boolean flag=true;
		   
		   for(int m=0;m<yol1BoyaSatir.size();m++)
		   {
			   
			   if(yol1BoyaSatir.get(m)== i+1 && yol1BoyaSutun.get(m)== j+1)
			   {
				   flag =false;
				   break;
			   }
		   }
		   
		   if(flag==true)
		   {sayac++;
			   yol1BoyaSatir.add(i+1);
			   yol1BoyaSutun.add(j+1);
		   }
		   
		   
		   
		 //  hucre[i+1][j+1].setBackground(Color.cyan);
		   
		   //once sag sonra yukarı
		   if(Yol4(matris1,ziyaretEdilen,i,j+1,x,y))
		   {
			
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		   if(Yol4(matris1,ziyaretEdilen,i-1,j,x,y))
		   {
			   
			   yol1BoyaSatirEnk.add(i+1);
			   yol1BoyaSutunEnk.add(j+1);
			  // hucre[i+1][j+1].Ilerleme();
			   return true;
		   }
		   
		   ziyaretEdilen[i][j]=true;
		   return false;
		   
		   
	   }
		   
	  
	   return false;
}

   



   
   public void EnKisaYol(int [][]matris1,int baslangicSatir, int baslangicSutun,int bitisSatir,int bitisSutun)
   {
	   boolean [][]ziyaretE=new boolean [matris1.length][matris1.length];
	   
	   for(int i=0;i<ziyaretE.length;i++)
	   {
		   for(int j=0;j<ziyaretE.length;j++)
		   {
			   ziyaretE[i][j]=false;
			   
		   }
	   }
	   
	   
	   if(baslangicSatir==1 && baslangicSutun==1)
	   {
		   
		  Yol1(matris1,ziyaretE,baslangicSatir-1,baslangicSutun-1,bitisSatir-1,bitisSutun-1);
	   }
	   
	   else if(baslangicSatir==matris1.length &&baslangicSutun==matris1.length)
	   {
		   Yol2(matris1,ziyaretE,baslangicSatir-1,baslangicSutun-1,bitisSatir-1,bitisSutun-1);
	   }
	   else if(baslangicSatir==1 && baslangicSutun==matris1.length)
	   {
		   Yol3(matris1,ziyaretE,baslangicSatir-1,baslangicSutun-1,bitisSatir-1,bitisSutun-1);
	   }
	   else if(baslangicSatir==matris1.length && baslangicSutun==1)
	   {
		   Yol4(matris1,ziyaretE,baslangicSatir-1,baslangicSutun-1,bitisSatir-1,bitisSutun-1);
	   }
	   
	   
	   

           
           
	 
	   zaman.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				BulutKaldir();
				  hucre[yol1BoyaSatir.get(x)][yol1BoyaSutun.get(x)].setBackground(Color.cyan);
				  System.out.println(yol1BoyaSatir.get(x) +" "+yol1BoyaSutun.get(x));
				 // System.out.println(x);
				  x++;
                                  
                                 
                                  
				  if(x==yol1BoyaSatir.size())
				  {
					  zaman.cancel();
                                          
                                            logger.log("Hedefe Ulaşıldı.");
                                            LoggerLab.logFine("Hedefe Ulaşıldı.");
					  for(int a=0;a<yol1BoyaSutunEnk.size();a++)
					  {
                                              
						  hucre[yol1BoyaSatirEnk.get(a)][yol1BoyaSutunEnk.get(a)].setBackground(Color.pink);
						 if(a==yol1BoyaSutunEnk.size()-1)
                                                  logger.log("En kısa yol çizildi...");
					  }
                                          
                                           for(int i=0;i<matris1.length+2;i++)
						 {
							 for(int j=0;j<matris1.length+2;j++)
							 {
								 hucre[i][j].setVisible(true);
							 }
						 }
                                          
					  System.out.println(sayac);
                                
                                      
                                 
				  }
				
			}
		},1,500);
	   
           
           
           
          
	   
           if(Problem1.kontrolHiz==0){
       
          zaman.schedule(new TimerTask() {
			
			@Override
			public void run() {
				
				BulutKaldir();
				  hucre[yol1BoyaSatir.get(x)][yol1BoyaSutun.get(x)].setBackground(Color.cyan);
				  System.out.println(yol1BoyaSatir.get(x) +" "+yol1BoyaSutun.get(x));
				 // System.out.println(x);
				  x++;
                                  
                                 
                                  
				  if(x==yol1BoyaSatir.size())
				  {
					  zaman.cancel();
                                          

					  for(int a=0;a<yol1BoyaSutunEnk.size();a++)
					  {
						  hucre[yol1BoyaSatirEnk.get(a)][yol1BoyaSutunEnk.get(a)].setBackground(Color.pink);
						  
					  }
                                          
                                           for(int i=0;i<matris1.length+2;i++)
						 {
							 for(int j=0;j<matris1.length+2;j++)
							 {
								 hucre[i][j].setVisible(true);
                                                                
                                                                 LoggerLab.logFine("Doğru yol bulundu.");
                                                                 logger.log("Doğru yol bulundu.");
							 }
						 }
                                           
                                           Problem1.kontrolHiz=1;
                                          
					  System.out.println(sayac);
                                
                                      
                                 
				  }
				
			}
		},1,1);
       
           
	   
           }
            
	   
	   
   }
   
   
    public void BulutKaldir()
    {
   
    	hucre[yol1BoyaSatir.get(x)][yol1BoyaSutun.get(x)].setVisible(true);
    	
    	hucre[yol1BoyaSatir.get(x)-1][yol1BoyaSutun.get(x)-1].setVisible(true);
    	hucre[yol1BoyaSatir.get(x)-1][yol1BoyaSutun.get(x)].setVisible(true);
    	hucre[yol1BoyaSatir.get(x)-1][yol1BoyaSutun.get(x)+1].setVisible(true);
    	
    	
    	hucre[yol1BoyaSatir.get(x)][yol1BoyaSutun.get(x)-1].setVisible(true);
    	hucre[yol1BoyaSatir.get(x)][yol1BoyaSutun.get(x)+1].setVisible(true);
    	
    	
    	hucre[yol1BoyaSatir.get(x)+1][yol1BoyaSutun.get(x)-1].setVisible(true);
    	hucre[yol1BoyaSatir.get(x)+1][yol1BoyaSutun.get(x)].setVisible(true);
    	hucre[yol1BoyaSatir.get(x)+1][yol1BoyaSutun.get(x)+1].setVisible(true);
    	
    	
    	
    }
	   

   
	static public int Saydir(){
            System.out.println(sayac);
            return sayac;
            
        }

	
}
