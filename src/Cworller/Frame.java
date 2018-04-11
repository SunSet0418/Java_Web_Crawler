package Cworller;

import Cworller.GetHtml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Frame extends JFrame {

	private JPanel contentPane;

	private int type = 0;

	JTextArea result = new JTextArea();
	JTextArea csstext = new JTextArea();

	GetHtml code = new GetHtml();
	Alert alert = new Alert();
	Logger logger = new Logger();
	Save filesave = new Save();
	JLabel urllabel = new JLabel("URL : ");
	JTextArea url = new JTextArea();
	JButton https = new JButton("HTTPS");

	JLabel status = new JLabel("Program Status Success");
	JButton parsing = new JButton("GET");
	JButton log = new JButton("검색기록");
	JLabel lblCssSelector = new JLabel("CSS Selector : ");
	JLabel lblAttr = new JLabel("Attr : ");
	JButton save = new JButton("파일저장");
	ButtonGroup radiogroup = new ButtonGroup();
	JButton http = new JButton("HTTP");
	JRadioButton radioButton = new JRadioButton("텍스트");
	JRadioButton radioButton_1 = new JRadioButton("속성값 불러오기");
	JTextArea cssselector = new JTextArea();
	JTextArea attr = new JTextArea();

	public Frame() {
		setTitle("HTML Parser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		contentPane = new JPanel();


		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		urllabel.setBounds(6, 6, 36, 16);
		contentPane.add(urllabel);


		url.setBounds(46, 6, 844, 16);
		contentPane.add(url);


		lblCssSelector.setBounds(6, 34, 92, 16);
		contentPane.add(lblCssSelector);

		radioButton.addItemListener(new MyItemListener());
		radiogroup.add(radioButton);
		radioButton.setBounds(208, 744, 65, 23);
		contentPane.add(radioButton);


		radioButton_1.addItemListener(new MyItemListener());
		radiogroup.add(radioButton_1);
		radioButton_1.setBounds(276, 744, 117, 23);
		contentPane.add(radioButton_1);


		attr.setBounds(46, 62, 844, 16);
		contentPane.add(attr);


		cssselector.setBounds(96, 34, 794, 16);
		contentPane.add(cssselector);


		parsing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(url.getText().equals("")){
					status.setText("URL을 입력하세요");
					alert.alert("URL을 입력하세요");
				}
				else{
					if((!(url.getText().indexOf(4)==':')&&!(url.getText().substring(0,4).equals("http")))||(!(url.getText().indexOf(5)==':')&&!(url.getText().substring(0,4).equals("http")))){
						status.setText("프로토콜을 선택해주세요");
						alert.alert("프로토콜을 선택해주세요");
					}
					else{
						if(url.getText().equals("http://")||url.getText().equals("https://")){
							status.setText("HOST를 입력하세요");
							alert.alert("HOST를 입력하세요");
						}
						else{
							String link = url.getText();
							String html = code.getHtml(link).toString();
							if(type == 1){
								String text = code.getData(cssselector.getText());
								csstext.setText(text);
							}
							else if(type == 2){
								String text = code.getAttr(cssselector.getText(), attr.getText());
								csstext.setText(text);
							}
							result.setText(html);
							status.setText("파싱완료");
							alert.show("파싱완료");
							logger.save(url.getText());
						}
					}
				}

			}
		});
		parsing.setBounds(902, 8, 92, 70);
		contentPane.add(parsing);


		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(result.getText().equals("")){
					status.setText("저장할 파일이 없습니다");
					alert.alert("저장할 파일이 없습니다");
				}
				else {
					filesave.saver(result.getText());
					status.setText("저장왼료");
				}
			}
		});
		save.setBounds(877, 743, 117, 29);
		contentPane.add(save);


		http.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(url.getText().equals("")){
					url.setText("http://");
					status.setText("SET http");
				}
				else{
					String temp = url.getText();
					url.setText("http://"+temp);
					status.setText("SET http");
				}
			}
		});
		http.setBounds(6, 743, 92, 29);
		contentPane.add(http);


		https.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(url.getText().equals("")){
					url.setText("https://");
					status.setText("SET https");
				}
				else{
					String temp = url.getText();
					url.setText("https://"+temp);
					status.setText("SET https");
				}
			}
		});
		https.setBounds(102, 743, 92, 29);
		contentPane.add(https);

		JScrollPane viewhtml = new JScrollPane(result);
		viewhtml.setBounds(6, 85, 988, 319);
		contentPane.add(viewhtml);

		JScrollPane selector = new JScrollPane(csstext);
		selector.setBounds(6, 416, 988, 320);
		contentPane.add(selector);


		status.setBounds(588, 748, 171, 16);
		contentPane.add(status);


		log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("검색기록 Open");
				logger.list();
			}
		});
		log.setBounds(759, 743, 117, 29);
		contentPane.add(log);


		lblAttr.setBounds(6, 62, 41, 16);
		contentPane.add(lblAttr);

		result.setEditable(false);
		csstext.setEditable(false);

		setVisible(true);

	}

	class MyItemListener implements java.awt.event.ItemListener{

		@Override
		public void itemStateChanged(ItemEvent e) {

			if(e.getStateChange()==ItemEvent.DESELECTED){
				return;
			}

			if(radioButton.isSelected()){
				type = 1;
			}
			else if(radioButton_1.isSelected()){
				type = 2;
			}

		}
	}
}
