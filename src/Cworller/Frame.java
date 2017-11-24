package Cworller;

import Cworller.GetHtml;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Frame extends JFrame {

	private JPanel contentPane;

	public Frame() {
		setTitle("HTML Parser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 800);
		JTextArea result = new JTextArea();
		contentPane = new JPanel();
		GetHtml code = new GetHtml();
		Alert alert = new Alert();
		Logger logger = new Logger();
		Save filesave = new Save();
		JLabel status = new JLabel("Program Status Success");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel urllabel = new JLabel("URL : ");
		urllabel.setBounds(6, 6, 36, 16);
		contentPane.add(urllabel);

		JTextArea url = new JTextArea();
		url.setBounds(46, 6, 844, 16);
		contentPane.add(url);

		JButton parsing = new JButton("GET");
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
							result.setText(html);
							status.setText("파싱완료");
							alert.show("파싱완료");
							logger.save(url.getText());
						}
					}
				}

			}
		});
		parsing.setBounds(902, 1, 92, 29);
		contentPane.add(parsing);

		JButton save = new JButton("파일저장");
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

		JButton http = new JButton("HTTP");
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

		JButton https = new JButton("HTTPS");
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



		JScrollPane scrollPane = new JScrollPane(result);
		scrollPane.setBounds(6, 29, 988, 711);
		contentPane.add(scrollPane);


		status.setBounds(588, 748, 171, 16);
		contentPane.add(status);

		JButton log = new JButton("검색기록");
		log.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("Show 검색기록");
				logger.list();
			}
		});
		log.setBounds(759, 743, 117, 29);
		contentPane.add(log);

		result.setEditable(false);

		setVisible(true);

	}
}
