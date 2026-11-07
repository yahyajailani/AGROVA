import java.awt.*; import java.awt.image.BufferedImage; import java.io.File;
/** Membuat gambar lanskap (PNG) dari Art. Dijalankan sekali; hasilnya dipakai sebagai icon JLabel di form. */
public class Export {
  static void out(String f, int w, int h, int ov) throws Exception {
    BufferedImage im = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); Graphics2D g = im.createGraphics();
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    agrova.util.Art.paint(g, 0, 0, w, h, 0.7);
    g.setPaint(new GradientPaint(0, 0, new Color(8, 40, 26, ov), w, h, new Color(8, 40, 26, Math.min(255, ov + 40)))); g.fillRect(0, 0, w, h); g.dispose();
    javax.imageio.ImageIO.write(im, "png", new File(f));
  }
  public static void main(String[] a) throws Exception {
    out(a[0] + "/login_brand.png", 540, 720, 140); out(a[0] + "/daftar_brand.png", 480, 760, 140); out(a[0] + "/beranda_hero.png", 1180, 330, 130);
    System.exit(0);
  }
}
