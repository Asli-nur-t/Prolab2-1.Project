
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

}

    int[][] Labirent; 

    final static int ArkaPlanKodu = 0;
    final static int DuvarKodu = 1;
    final static int YolKodu = 2;
    final static int BosKod = 3;
    final static int ZiyaretKodu = 4;

    Color[] renk;
    int satir = 41; 
    int sutun = 41; 
    int border = 0; // Labirent ile panelin kenarı arasındaki minimum piksel sayısı
    int sleepTime = 5000; //bir labirenti çözdükten sonra diğerini yapmadan önce bekleme süresi
    int speedSleep = 30; //labirent çözmedeki kısa gecikme
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
            Color.red,
            new Color(140, 242, 139)
    };
    setBackground(renk[ArkaPlanKodu]);
    setPreferredSize(new Dimension(blokBoyutu * sutun, blokBoyutu * satir));
    new Thread(this).start();
}

    void boyutKontrol() {
         if (getWidth() != en || getHeight() != boy) {
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
        for (int j = 0; j < sutun; j++)
            for (int i = 0; i < satir; i++) {
                if (Labirent[i][j] < 0){
                    g.setColor(renk[BosKod]);
                  g.drawLine(0, 0, 41, 41);
                          
                }
                
                else
                    g.setColor(renk[Labirent[i][j]]);
                g.fillRect((j * w) + sol, (i * h) + ust, w, h);
                //g.drawArc(i, i, 100, 100, 0, 0);
               // g.fill3DRect(i, i, 10, 40, LabVar);
            }
    }
}


   public void run() {
   
    try {
        Thread.sleep(1000);
    } 
    catch (InterruptedException e) {
    }
    while (true) {
        LabirentYap();
        LabirentiCoz(1, 1);
        synchronized (this) {
            try {
                wait(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        LabVar = false;
        
        repaint();
    }
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
    repaint();
    
    int r;
    for (i = duvarSay - 1; i > 0; i--) {
        r = (int) (Math.random() * i); 
      //  DuvarKir(duvarSatir[r], duvarSutun[r]);
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
        repaint();
        
    } else if (sat % 2 == 0 && Labirent[sat - 1][sut] != Labirent[sat + 1][sut]) {
        
        doldur(sat - 1, sut, Labirent[sat - 1][sut], Labirent[sat + 1][sut]);
        Labirent[sat][sut] = Labirent[sat + 1][sut];
        repaint();
        
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


   boolean LabirentiCoz(int sat, int sut) {
    
    if (Labirent[sat][sut] == BosKod) {
        Labirent[sat][sut] = YolKodu; 
        repaint();
        if (sat == satir - 2 && sut == sutun - 2){
            
            return true; 
        }
        try {
            Thread.sleep(speedSleep);
        } catch (InterruptedException e) {
        }
        if (LabirentiCoz(sat - 1, sut) ||   LabirentiCoz(sat, sut - 1) ||  LabirentiCoz(sat + 1, sut) || LabirentiCoz(sat, sut + 1))
            return true;
       
        Labirent[sat][sut] = ZiyaretKodu; 
        repaint();
        
        synchronized (this) {
            try {
                wait(speedSleep);
            } catch (InterruptedException e) {
            }
        }
    }
    return false;
   }
}
