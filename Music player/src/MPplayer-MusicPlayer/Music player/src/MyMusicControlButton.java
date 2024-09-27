import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class MyMusicControlButton extends JButton{
    public static Color backgroundColor;
    Image image;
    public MyMusicControlButton(String text){
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        backgroundColor = new Color(110,110,110,50);
        setBackground(backgroundColor);
        MouseListener l = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                backgroundColor = new Color(110,110,110,100);
                setBackground(backgroundColor);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                backgroundColor = new Color(110,110,110,50);
                setBackground(backgroundColor);
            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        };
        addMouseListener(l);
    }
    @Override
    public void paintComponent(Graphics g){
        g.setColor(getBackground());
        // g.fillRect(1,1,getWidth()-2,getHeight()-2);
        if(getWidth() > getHeight())
        {
            g.drawImage(image, (getWidth()-getHeight())/2,getHeight()/4/2,getHeight()*3/4,getHeight()*3/4,this);
        }
        else
        {
            g.drawImage(image, getWidth()/4/2,(getHeight()/-getWidth())/2,getWidth()*3/4,getWidth()*3/4,this);
        }
        //super.paintComponent(g);
    }
    public void setImage(String path) {
        image = new ImageIcon(path).getImage();
    }
    public void setSquareEdgeLength(int length) {
        setSize(length, length);
    }
}
