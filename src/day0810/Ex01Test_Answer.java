package day0810;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ex01Test_Answer extends JFrame {
	JButton btnAdd;
	JLabel lblResult;
	JTextField tfnum1, tfnum2;
	Icon icon1 = new ImageIcon("D:\\bitjava0719\\image\\c1.png");
	Icon icon2 = new ImageIcon("D:\\bitjava0719\\image\\c2.png");
	
	
	public Ex01Test_Answer() {
		super("8��9�� ���� �ؼ�");
		setLocation(700,100); //x,y
		setSize(300,300); //w,h  setBounds  ��� �� �ΰ��� �� ���� �ִ�.
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDesign();
		setVisible(true); //�׻� ���� �ؿ� ���� �ϱ�....
	}
	
	public void setDesign() {
		setLayout(null);
		JLabel lbl1 = new JLabel("����1");
		JLabel lbl2 = new JLabel("����2");
		lbl1.setBounds(20, 20, 50, 30);
		lbl2.setBounds(20, 60, 50, 30);
		add(lbl1); add(lbl2);
		
		tfnum1 = new JTextField();
		tfnum1.setBounds(70, 20, 60, 30);
		tfnum2 = new JTextField();
		tfnum2.setBounds(70, 60, 60, 30);
		add(tfnum1); add(tfnum2);
		
		btnAdd = new JButton("���ϱ�",icon1);
		btnAdd.setBounds(30, 110, 150, 40);
		add(btnAdd);
		
		lblResult = new JLabel("��� ������ ��", JLabel.CENTER);
		lblResult.setBounds(10, 170, 250, 60);
		lblResult.setBorder(new TitledBorder("���Ȯ��"));
		lblResult.setFont(new  Font("", Font.BOLD, 25));
		add(lblResult);
		
		//��ư�̺�Ʈ�ε� �͸� ����Ŭ���� �������� ������
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int su1 = Integer.parseInt(tfnum1.getText().trim());
					int su2 = Integer.parseInt(tfnum2.getText().trim());
					int sum = su1+su2;
					
					String s = su1 + "+" + su2 + "=" + sum;
					lblResult.setText(s);
				
				} catch(NumberFormatException e2) {
					lblResult.setText("���ڰ� �����־��");
				}
				
			}
		});
	}
	

	public static void main(String[] args) {
		new Ex01Test_Answer();

	}

}
