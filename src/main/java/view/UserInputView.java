package view;

import dao.DataBase;
import entity.Flag;
import extend.PathConfig;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.WDWUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class UserInputView extends JFrame implements ActionListener{
	private JRadioButton radioMode1 = new JRadioButton("模板1");// 定义一个单选按钮
	private JRadioButton radioMode1_1 = new JRadioButton("模板1_1");// 定义一个单选按钮
	private JRadioButton radioMode2 = new JRadioButton("模板2");// 定义一个单选按钮
	private JRadioButton radioMode3_1 = new JRadioButton("模板3_1");// 定义一个单选按钮
	private JRadioButton radioMode3_2 = new JRadioButton("模板3_2");// 定义一个单选按钮
	private JRadioButton radioMode4 = new JRadioButton("模板4");// 定义一个单选按钮
	private JRadioButton radioMode5 = new JRadioButton("模板5");// 定义一个单选按钮
	private JRadioButton radioMode6_1 = new JRadioButton("模板6_1");// 定义一个单选按钮
	private JRadioButton radioMode6_2 = new JRadioButton("模板6_2");// 定义一个单选按钮

	private JButton inputButton = new JButton("导入文件");
	private JButton generateModelButton = new JButton("生成模板");
	private JButton resetButton = new JButton("重置");
	private JPanel mPanel = new JPanel(new BorderLayout());// /定义一个面板
	private ButtonGroup buttonGroup;
	private String mChooserFileName = "请导入文件";
	private JPanel buttonPanel;
	private String excelFilePath = "";
	private boolean hasChooseFile = false;
	private int model =1;
	private final String ERR_MESSAGE = "选择文件与模板冲突！";
	private JPanel lablePanel;
	private JLabel jLabelPath;
	private JPanel radiroPanel;
	private String stateTop = "已选择模板1";
//	private String currentDirectoryPath = "D:/";
	public UserInputView() {
		setLookAndFeel();
		addRadiobutton();
		init();
		setVisible(true);
	}

	private void init() {
		setTitle("教育分析");
		setLocationRelativeTo(null);
//		setVisible(true);//可见
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close的方式
		setSize(450, 270);

	}

	private void addRadiobutton(){

	 jLabelPath= new JLabel("生成文件路径为："+ PathConfig.WORDPATH);
		radiroPanel = new JPanel();
		radiroPanel.setPreferredSize(new Dimension(0, 120));
		radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));// 定义一个面板的边框显示条
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioMode1);
		buttonGroup.add(radioMode1_1);
		buttonGroup.add(radioMode2);
		buttonGroup.add(radioMode3_1);
		buttonGroup.add(radioMode3_2);
		buttonGroup.add(radioMode4);
		buttonGroup.add(radioMode5);
		buttonGroup.add(radioMode6_1);
		buttonGroup.add(radioMode6_2);

		radiroPanel.add(radioMode1);
		radiroPanel.add(radioMode1_1);
		radiroPanel.add(radioMode2);
		radiroPanel.add(radioMode3_1);
		radiroPanel.add(radioMode3_2);
		radiroPanel.add(radioMode4);
		radiroPanel.add(radioMode5);
		radiroPanel.add(radioMode6_1);
		radiroPanel.add(radioMode6_2);

		radioMode1.addActionListener(this);
		radioMode2.addActionListener(this);
		radioMode3_1.addActionListener(this);
		radioMode3_2.addActionListener(this);
		radioMode4.addActionListener(this);
		radioMode5.addActionListener(this);
		radioMode6_1.addActionListener(this);
		radioMode6_2.addActionListener(this);
		radioMode1_1.addActionListener(this);

		radioMode1.setSelected(true);

		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(0, 100));
		buttonPanel.setBorder(BorderFactory.createTitledBorder(mChooserFileName));// 定义一个面板的边框显示条
		buttonPanel.add(inputButton);
		buttonPanel.add(generateModelButton);
		buttonPanel.add(resetButton);
		inputButton.addActionListener(this);
		generateModelButton.addActionListener(this);
		resetButton.addActionListener(this);

		lablePanel = new JPanel();
		lablePanel.add(jLabelPath);
		mPanel.add(BorderLayout.NORTH,radiroPanel);
		mPanel.add(BorderLayout.CENTER,buttonPanel);
		mPanel.add(BorderLayout.SOUTH,lablePanel);
		this.add(mPanel);

	}



	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		new UserInputView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		switch (e.getActionCommand()) {

			case "模板1":
				stateTop = "已选择模板1";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 1;
				break;


			case "模板2":
				stateTop = "已选择模板2";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 2;
				break;
			case "模板3_1":
				stateTop = "已选择模板3_1";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 3;
				break;
			case "模板3_2":
				stateTop = "已选择模板3_2";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 4;
				break;
			case "模板4":
				stateTop = "已选择模板4";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 5;
				break;
			case "模板5":
				stateTop = "已选择模板5";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 6;
				break;
			case "模板6_1":
				stateTop = "已选择模板6_1";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 7;
				break;
			case "模板6_2":
				stateTop = "已选择模板6_2";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 8;
				break;

			case "导入文件":


				JFileChooser excelFileChooser = new JFileChooser(Flag.inputPath);
				System.out.println("chooser");
				int result = excelFileChooser.showOpenDialog(this);
				File excelFile = excelFileChooser.getSelectedFile();
				System.out.println("chooser2");
				if (result == JFileChooser.APPROVE_OPTION) {
					if (excelFile.renameTo(excelFile)) {
						mChooserFileName = "当前文件为:" + excelFile.getName();
						WDWUtil wdwUtil = new WDWUtil();
						if (wdwUtil.validateExcel(excelFile.getPath())) {
							hasChooseFile = true;
							mChooserFileName = "当前文件为:" + excelFile.getName();
							buttonPanel.setBorder(BorderFactory.createTitledBorder(mChooserFileName));
							excelFilePath = excelFile.getPath();
							Flag.inputPath = excelFilePath.substring(0, excelFilePath.lastIndexOf("\\"));
							System.out.println(excelFilePath);

						}else {
							JOptionPane.showMessageDialog(null, wdwUtil.getErrorInfo()+",请重新添加");
						}

					} else {
						JOptionPane.showMessageDialog(null, "文件正在使用请关闭");
					}
				} else if (result == JFileChooser.CANCEL_OPTION) {
					System.out.println("cancel");
					return;
				}
				break;
			case "生成模板":
				if (hasChooseFile) {
					try {

						System.out.println(model);
						System.out.println(Flag.wordPath);
						DataBase.generatePattern(model, excelFilePath);
							jLabelPath.setText("生成文件路径为："+ Flag.wordPath);
					} catch (Exception e1) {
						stateTop = "生成失败，请检查模板与文件是否匹配"+e1.getMessage();
						radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
						e1.printStackTrace();

					}
				}else{
					JOptionPane.showMessageDialog(null, "请先导入Excel文件");
				}
				break;
			case "重置":
				hasChooseFile = false;
				mChooserFileName = "请导入文件";
				buttonPanel.setBorder(BorderFactory.createTitledBorder(mChooserFileName));
				excelFilePath = "";
				radioMode1.setSelected(true);
				Flag.wordPath = PathConfig.WORDROOT;
				Flag.isFirst = true;
				model = 1;
				jLabelPath.setText("生成文件路径为："+ PathConfig.WORDPATH);
				stateTop = "已选择模板1";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				break;
			case "模板1_1":
				stateTop = "已选择模板1_1";
				radiroPanel.setBorder(BorderFactory.createTitledBorder(stateTop));
				model = 9;
				break;

		}
	}
}
