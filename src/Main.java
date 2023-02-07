import java.awt.*;
import javax.swing.JFrame;

public class Main extends Canvas{
    public void paint(Graphics g) {

        setBackground(Color.GRAY);

        Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(3)); // Ширина линий
        drawArm(new int[]{480-50,480-150,480-155,480-55,480-45,480-40,480-43,480-25,480-23,480-40,480-30,480-35}, new int[] {290,330,315,280,260,263,275,270,277,285,300,305}, Color.WHITE, Color.black, g2); // Правая рука, для Х из общей ширины вычитаем уже ранее подобранные значения, получаем симметричную руку
        drawOvalWithBorder(100,400,280, 230, Color.WHITE, Color.black, g2);
        drawOvalWithBorder(130,250,220, 200, Color.WHITE, Color.black, g2);
        drawOvalWithBorder(160,140,160, 140, Color.WHITE, Color.black, g2);
        drawOvalWithBorder(150,140,180, 20, Color.WHITE, Color.black, g2);
        g2.setColor(Color.white);
        g2.fillRoundRect(190, 70, 100, 75, 20, 15); // Заливка шляпы
        g2.setColor(Color.black);
        g2.drawRoundRect(190, 70, 100, 75, 20, 15); // Контур шляпы
        g2.drawLine(190,130,290,130);
        drawArm(new int[]{50,150,155,55,45,40,43,25,23,40,30,35}, new int[] {290,330,315,280,260,263,275,270,277,285,300,305}, Color.WHITE, Color.black, g2); // Левая рука
        for (int i = 0; i < 90; i = i + 30)
            drawOvalWithBorder(260,320+i,10, 10, Color.black, Color.black, g2); // Пуговицы
        for (int i = 0; i < 80; i = i + 40) {
            drawOvalWithBorder(230 + i, 180, 20, 15, Color.WHITE, Color.black, g2); // Глаза
            drawOvalWithoutBorder(240 + i, 182, 10, 10, Color.black, g2); // Зрачки
        }
        drawOvalWithoutBorder(230,230,60, 30, Color.BLACK, g2); // Рот
        drawOvalWithoutBorder(220,228,80, 20, Color.WHITE, g2); // Перекрытие для рта
        g2.setColor(Color.RED);
        g2.fillPolygon(new int[]{260,350,255}, new int[] {230,220,215}, 3); // Заливка носа
        g2.setColor(Color.black);
        g2.drawPolyline(new int[]{260,350,255}, new int[] {230,220,215}, 3); // Контур носа

    }

    public void drawOvalWithBorder (int x, int y, int width, int height, Color colorOval, Color colorBorder, Graphics2D g2){ // Метод для рисования залитого овала и его бордюра разными цветами
        g2.setColor(colorOval);
        g2.fillOval(x,y,width,height);
        g2.setColor(colorBorder);
        g2.drawOval(x,y,width,height);
    }

    public void drawArm (int [] i, int [] y, Color colorOval, Color colorBorder, Graphics2D g2) { // Метод для рисования рук
        g2.setColor(colorOval);
        g2.fillPolygon(i, y, i.length);
        g2.setColor(colorBorder);
        g2.drawPolygon(i, y, i.length);
    }

    public void drawOvalWithoutBorder (int x, int y, int width, int height, Color colorOval, Graphics2D g2){ // Метод для рисования залитого овала без бордера
        g2.setColor(colorOval);
        g2.fillOval(x,y,width,height);
    }

    public static void main(String[] args) {
        Main m = new Main();
        JFrame f = new JFrame();
        f.setTitle("Снеговик");
        f.add(m);
        f.setSize(500,700);
        f.setVisible(true);
    }

}