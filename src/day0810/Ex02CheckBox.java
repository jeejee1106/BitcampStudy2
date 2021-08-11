package day0810;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Ex02CheckBox extends JFrame implements ItemListener, ActionListener{ //����Ŭ������ ItemListner����
	JCheckBox cbDriver, cbBold;
	JCheckBox[] cbHobby = new JCheckBox[4];
	JButton btnHobby;
	JLabel lblResult;


	public Ex02CheckBox(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}

	public void setDesign() {
		setLayout(null);
		cbDriver = new JCheckBox("��������");
		cbDriver.setBounds(20, 20, 100, 30);
		cbDriver.setOpaque(false);
		cbDriver.addItemListener(this); //���� Ŭ������ �����ϱ� ����Ŭ������ �ν��Ͻ��� this
		add(cbDriver);

		cbBold = new JCheckBox("���� ����"); //üũ�� ����� : ���ϰ�, ũ��20
		cbBold.setBounds(20, 60, 150, 30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this);
		add(cbBold);

		lblResult = new JLabel("Have a Nice Day!!", JLabel.CENTER);
		lblResult.setBounds(20, 280, 330, 50);
		lblResult.setBorder(new LineBorder(Color.pink,5));
		add(lblResult);

		String[] hobby = {"�", "����", "����", "���ǰ���"};
		int xpos = 20;
		for(int i = 0; i<cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(hobby[i]);
			cbHobby[i].setBounds(xpos, 100, 80, 30);
			cbHobby[i].setOpaque(false);
			add(cbHobby[i]);
			xpos+=80;
		}

		btnHobby = new JButton("���� ��� �˾ƺ���");
		btnHobby.setBounds(60,140,200,30);
		add(btnHobby);
		btnHobby.addActionListener(this);
	}

	public static void main(String[] args) {
		new Ex02CheckBox("Check & Radio");
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();
		if(ob==cbDriver) {			//isSelected()�� true, false���� ��ȯ�ϴ� �޼ҵ�. üũ�ϸ� true, üũ�����ϸ� false
			String s = "üũ����" + cbDriver.isSelected() + "�ؽ�Ʈ:" + cbDriver.getText(); //cdDriver�� �ؽ�Ʈ�� �������ڴ�.�ҷ����ڴ�.
			lblResult.setText(s);
		} else if(ob==cbBold) {
			if(cbBold.isSelected()){
				lblResult.setFont(new Font("",Font.BOLD,20));
			} else {
				lblResult.setFont(new Font("",Font.PLAIN,12));
			}
		}
	}

	//��� ����ϱ� : ī��Ʈ�� �ؼ� �ε����� ���� �������� ���.
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btnHobby) {
			int select = 0;
			String s = "���� ��̴� ";
			for(int i = 0; i<cbHobby.length; i++) {
				if(cbHobby[i].isSelected()) {
					select++;
					s+="[" +cbHobby[i].getText() + "]";
				}
			}
//			for(JCheckBox cb : cbHobby) { //���� for�����ε� �غô�.
//				if(cb.isSelected()) {
//					select++;
//					s+="[" +cb.getText() + "]";
//					
//				}
//			}
			if(select==0) {
				s = "���� ��̰� �����";
			} else {
				s+="�Դϴ�.";
			}
			lblResult.setText(s);
		}
	}

	


}
