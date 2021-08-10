package day0810;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Ex03Radio extends JFrame implements ActionListener{
	JRadioButton rbWoman, rbMen;
	JRadioButton rbRed, rbBlue, rbPink;
	JLabel lblResult;
	JRadioButton[] rbBgColor = new JRadioButton[6];
	String[] strcolor = {"���", "��ȫ", "�ʷ�", "�ϴ�", "������", "������"};
	Color[] bgcolor = {new Color(255,255,187), new Color(255,219,237), new Color(193,255,193), new Color(202,255,255), new Color(255,196,136), new Color(202,202,255)};

	public Ex03Radio(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //���� ������Ʈ ���� �� �̺�Ʈ ���� �ڵ�
		this.setVisible(true);
	}

	public void setDesign() {
		setLayout(null);
		rbMen = new JRadioButton("����",true); //true�� �ָ�  RadioButton�� ������ �Ǿ ������ �ȴ�.
		rbMen.setBounds(20, 30, 60, 30);
		rbMen.setOpaque(false);
		add(rbMen);

		rbWoman = new JRadioButton("����");
		rbWoman.setBounds(100, 30, 60, 30);
		rbWoman.setOpaque(false);
		add(rbWoman);

		// RadioButton�� �׷����� �����
		ButtonGroup bgGender = new ButtonGroup();
		bgGender.add(rbMen);
		bgGender.add(rbWoman); //��ư���� �׷����� ��� �� �� �ϳ��� ������ �ǵ��� ����!!!!!!

		//������ư�� �̺�Ʈ�߰�
		rbMen.addActionListener(this);
		rbWoman.addActionListener(this);

		//�󺧻���
		lblResult = new JLabel("Loding.....");
		lblResult.setFont(new Font("���", Font.BOLD, 17));
		lblResult.setBorder(new LineBorder(Color.pink,5));
		lblResult.setBounds(20, 290, 340, 60);
		lblResult.setOpaque(true);
		add(lblResult);

		//������ ������ �ٲٴ� ��ư�� �����غ���
		rbRed = new JRadioButton("����",true);
		rbRed.setBounds(20, 70, 60, 30);
		rbRed.setOpaque(false);
		rbRed.addActionListener(this);
		add(rbRed);
		
		rbBlue = new JRadioButton("�Ķ�");
		rbBlue.setBounds(100, 70, 60, 30);
		rbBlue.setOpaque(false);
		rbBlue.addActionListener(this);
		add(rbBlue);
		
		rbPink = new JRadioButton("��ȫ");
		rbPink.setBounds(180, 70, 60, 30);
		rbPink.setOpaque(false);
		rbPink.addActionListener(this);
		add(rbPink);
		
		ButtonGroup bgColor = new ButtonGroup();
		bgColor.add(rbRed);
		bgColor.add(rbBlue);
		bgColor.add(rbPink);
		
		lblResult.setForeground(Color.red);
		
		//���� ������ �ٲ��ִ� ������ư�߰�
		ButtonGroup bg = new ButtonGroup();
		int xpos = 5;
		for(int i = 0; i<rbBgColor.length; i++) {
			int idx = i;
			rbBgColor[i] = new JRadioButton(strcolor[i]);
			bg.add(rbBgColor[i]);
			rbBgColor[i].setBounds(xpos, 120, 70, 30);
			rbBgColor[i].setOpaque(false);
			add(rbBgColor[i]);
			xpos+=70;
			
			//�̺�Ʈ�� �͸���Ŭ���� ���·� ������
			rbBgColor[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					lblResult.setBackground(bgcolor[idx]);
				}
			});
		}
		
	}

	public static void main(String[] args) {
		new Ex03Radio("Radio");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==rbMen) {
			lblResult.setText("���� �����Դϴ�.");
		} else if(ob==rbWoman) {
			lblResult.setText("���� �����Դϴ�.");
		} else if(ob==rbRed) {
			lblResult.setForeground(Color.red);
		} else if(ob==rbBlue) {
			lblResult.setForeground(Color.blue);
		} else if(ob==rbPink) {
			lblResult.setForeground(Color.pink);
		}

	}

}
