
package labirentproje;

/**
 *
 * @author aslinurtopcu
 */
import java.awt.*;
import javax.swing.*;

public class KullaniciLabirenti extends JPanel implements Runnable{


    public static void main(String[] args) {
        JFrame KullaniciEkrani=new JFrame();
         KullaniciEkrani.setContentPane(new KullaniciEkrani());
         LoggerLab.logInfo("2.Problem başlatıldı");
         LoggerLab.logInfo("Program başlatıldı");
       //  KullaniciEkrani.FrameSilme(KullaniciEkrani);
         
}
    
    

    int[][] Labirent; 

    final static int ArkaPlanKodu = 0;
    final static int DuvarKodu = 1;
    final static int YolKodu = 2;
    final static int BosKod = 3;
    final static int ZiyaretKodu = 4;

    Color[] renk;
    int satir = 11; 
    int sutun = 11; 
    int border = 0; // Labirent ile panelin kenarı arasındaki minimum piksel sayısı
    int sleepTime = 500; //bir labirenti çözdükten sonra diğerini yapmadan önce bekleme süresi
    int speedSleep = 100; //labirent çözmedeki kısa gecikme
    int blokBoyutu = KullaniciEkrani.getLabSize()/satir; 

    int en = -1; // panel eni
    int boy = -1; //panel boyu sizeKontrol vercek

    int toplamEn; 
    int toplamBoy; 
    int sol; 
    int ust;
    boolean LabVar = false; 
    
    public KullaniciLabirenti() {
    renk = new Color[] {
            new Color(97, 138, 170),
            new Color(59, 61, 53),
            new Color(252, 133, 255),//asıl yolun rengi
            Color.WHITE,
            new Color(140, 242, 139)
    };
    setBackground(renk[ArkaPlanKodu]);
    setPreferredSize(new Dimension(blokBoyutu * sutun, blokBoyutu * satir));
    new Thread(this).start();
}

    void boyutKontrol() {
         if (getWidth() != en || getHeight() != boy) {
             LoggerLab.logInfo("boyut konrol edildi");
        en = getWidth();
        boy = getHeight();
        int w = (en - 2 * border) / sutun;
        int h = (boy - 2 * border) / satir;
        sol = (en - w * sutun) / 2;
        ust = (boy - h * satir) / 2;
        toplamEn = w * sutun;
        toplamBoy = h * satir;
    }
}
    @Override
    synchronized protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        boyutKontrol();
        LabirentCiz(g);
    }

   

void LabirentCiz(Graphics g) {
    
    if (LabVar) {
        int w = toplamEn / sutun; 
        int h = toplamBoy / satir;
        for (int j = 0; j < sutun; j++) {
            for (int i = 0; i < satir; i++) {
                if (Labirent[i][j] < 0){
                    g.setColor(renk[BosKod]);
                } else {
                    g.setColor(renk[Labirent[i][j]]);
                }
                g.fillRect((j * w) + sol, (i * h) + ust, w, h);

                // birim karelere çizgi ekler
                g.setColor(Color.BLACK);
                g.drawLine((j * w) + sol, (i * h) + ust, (j * w) + sol + w, (i * h) + ust); // üst line
                g.drawLine((j * w) + sol, (i * h) + ust, (j * w) + sol, (i * h) + ust + h); // sol line
                g.drawLine((j * w) + sol + w, (i * h) + ust, (j * w) + sol + w, (i * h) + ust + h); // sağ line
                g.drawLine((j * w) + sol, (i * h) + ust + h, (j * w) + sol + w, (i * h) + ust + h); // aşağı line
                 LoggerLab.logInfo("Labirent ızgarası çizildi.");
              
            }
        }
    }
}


   public void run() {
   
        LabirentYap();
        LabirentiCoz(1, 1);
        
        
        LabVar = true;
        repaint();
  
}


       void LabirentYap() {
    
    if (Labirent == null)
        Labirent = new int[satir][sutun];
    int i, j;
    int bosSay = 0; 
    int duvarSay = 0; 
    int[] duvarSatir = new int[(satir* sutun) / 2]; 
    int[] duvarSutun = new int[(satir * sutun) / 2];
    for (i = 0; i < satir; i++) 
        for (j = 0; j < sutun; j++)
            Labirent[i][j] = DuvarKodu;
    for (i = 1; i < satir - 1; i += 2) 
        for (j = 1; j < sutun - 1; j += 2) {
            bosSay++;
            Labirent[i][j] = -bosSay; 
            if (i < satir - 2) { 
                duvarSatir[duvarSay] = i + 1;
                duvarSutun[duvarSay] = j;
                duvarSay++;
            }
            if (j < sutun - 2) {
                duvarSatir[duvarSay] = i;
                duvarSutun[duvarSay] = j + 1;
                duvarSay++;
            }
        }
    LabVar = true;
     LoggerLab.logInfo("Labirent oluşturuldu.");
    repaint();
    
    int r;
    for (i = duvarSay - 1; i > 0; i--) {
        r = (int) (Math.random() * i); 
        DuvarKir(duvarSatir[r], duvarSutun[r]);
        duvarSatir[r] = duvarSatir[i];
        duvarSutun[r] = duvarSutun[i];
    }
    for (i = 1; i < satir - 1; i++) 
        for (j = 1; j < sutun - 1; j++)
            if (Labirent[i][j] < 0)
                Labirent[i][j] = BosKod;
}


    synchronized void DuvarKir(int sat, int sut) {
    
    if (sat % 2 == 1 && Labirent[sat][sut - 1] != Labirent[sat][sut + 1]) {
        
        doldur(sat, sut - 1, Labirent[sat][sut - 1], Labirent[sat][sut + 1]);
        Labirent[sat][sut] = Labirent[sat][sut + 1];
        LoggerLab.logInfo("Labirent oluşturuluyor.");
        repaint();
        
    } else if (sat % 2 == 0 && Labirent[sat - 1][sut] != Labirent[sat + 1][sut]) {
        
        doldur(sat - 1, sut, Labirent[sat - 1][sut], Labirent[sat + 1][sut]);
        Labirent[sat][sut] = Labirent[sat + 1][sut];
        repaint();
        setBackground(Color.CYAN);
        
    }
}


   void doldur(int sat, int sut, int konum, int donusKonum) {
    
    if (Labirent[sat][sut] == konum) {
        Labirent[sat][sut] = donusKonum;
        doldur(sat + 1, sut, konum, donusKonum);
        doldur(sat - 1, sut, konum, donusKonum);
        doldur(sat, sut + 1, konum, donusKonum);
        doldur(sat, sut - 1, konum, donusKonum);
    }
}

   static int sayac2=0;
   boolean LabirentiCoz(int sat, int sut) {
    
    if (Labirent[sat][sut] == BosKod) {
        Labirent[sat][sut] = YolKodu; 
        repaint();
       
        if (sat == satir - 2 && sut == sutun - 2){ 
             LoggerLab.logInfo("Hedefe ulaşıldı.");
            return true; //amaca ulaştı
           
        }
        try {
             LoggerLab.logInfo("Hedefe aranıyor.");
            sayac2++;
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
        if (LabirentiCoz(sat - 1, sut) || LabirentiCoz(sat, sut - 1) ||  LabirentiCoz(sat + 1, sut) || LabirentiCoz(sat, sut + 1)){
             LoggerLab.logInfo("Hedefe ulaşıldı.");
            return true;
        }
        Labirent[sat][sut] = ZiyaretKodu; 
        repaint();
      
        synchronized (this) {
            try {
                
                wait(50);
            } catch (InterruptedException e) {
            }
        }
    }
    
    return false;
   }
   
   
	static public int Saydir2(){
            System.out.println(sayac2);
            return sayac2+1;
            
        }
}
