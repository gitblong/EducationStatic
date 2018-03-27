import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class PaintDemo extends JFrame{
	/**
	* 
	*/
	private static final long serialVersionUID = -95348909224392777L;
	JPanel c=canvas();
	public PaintDemo(){
		this.setTitle("Small point paint test");
		int w=300,h=300;
		this.setSize(w, h);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(w,h);
		this.setLocation(screenSize.width / 2 - w / 2,
				screenSize.height / 2 - h / 2);
		this.setLayout(null);
		
		this.add(this.c);
		this.c.setBounds(0, 0, 300, 300);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
this.setVisible(true);
	}
	public JPanel canvas() {
		JPanel panel = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void paint(Graphics g) {
				super.paint(g);
				g.fillOval(100, 100, 100, 100);
			}
		};
		return panel;
	}
	
	/**
	* @param args
	*/
	public static void main(String[] args) {
		new PaintDemo();
	}
}