import entity.MultiBarEntity;
import extend.PathConfig;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame {

	public Test() {
		final JLabel label = new JLabel("lable");
		JButton button = new JButton("click");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(String.valueOf(new Random().nextInt(101)));
			}
		});
		this.setLayout(new FlowLayout());
		this.add(label);
		this.add(button);
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.setTitle("test");
		t.setSize(200, 100);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setVisible(true);
	}
	@org.junit.Test
	public void path() {
		//要切割的字符串
		String  s  = "123.jpg,113.jpg,121.jpg,122.jpg,131.jpg!";
		String  sub =  "";
		System.out.println("编译前："+s);
		//调用方法
		sub = s.replaceAll( "!","");//.replaceAll( ",122.jpg|122.jpg,","");
		System.out.println("编译后："+sub);
	}

	@org.junit.Test
	public void t() {
		MultiBarEntity multiBarEntity = new MultiBarEntity();
		multiBarEntity.setModel(2);
		System.out.println(multiBarEntity);
		MultiBarEntity multiBarEntity1 = new MultiBarEntity();
		System.out.println(multiBarEntity1);
	}

	@org.junit.Test
	public void testStr(){
		String str = "d:\\test\\tests\\test\\asdfjdsalfkjda;dfl";
		int i = str.lastIndexOf("\\");
		String substring = str.substring(0, i);
		System.out.println(substring);

	}
}