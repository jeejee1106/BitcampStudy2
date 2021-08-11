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

public class Ex02CheckBox extends JFrame implements ItemListener, ActionListener{ //현재클래스에 ItemListner넣음
	JCheckBox cbDriver, cbBold;
	JCheckBox[] cbHobby = new JCheckBox[4];
	JButton btnHobby;
	JLabel lblResult;


	public Ex02CheckBox(String title) {
		super(title);
		this.setBounds(800,100,400,400);
		this.getContentPane().setBackground(new Color(253,248,142));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setDesign(); //각종 컴포넌트 부착 및 이벤트 설정 코드
		this.setVisible(true);
	}

	public void setDesign() {
		setLayout(null);
		cbDriver = new JCheckBox("운전면허");
		cbDriver.setBounds(20, 20, 100, 30);
		cbDriver.setOpaque(false);
		cbDriver.addItemListener(this); //현재 클래스에 있으니까 현재클래스의 인스턴스인 this
		add(cbDriver);

		cbBold = new JCheckBox("라벨을 굵게"); //체크시 결과값 : 진하게, 크기20
		cbBold.setBounds(20, 60, 150, 30);
		cbBold.setOpaque(false);
		cbBold.addItemListener(this);
		add(cbBold);

		lblResult = new JLabel("Have a Nice Day!!", JLabel.CENTER);
		lblResult.setBounds(20, 280, 330, 50);
		lblResult.setBorder(new LineBorder(Color.pink,5));
		add(lblResult);

		String[] hobby = {"운동", "게임", "여행", "음악감상"};
		int xpos = 20;
		for(int i = 0; i<cbHobby.length; i++) {
			cbHobby[i] = new JCheckBox(hobby[i]);
			cbHobby[i].setBounds(xpos, 100, 80, 30);
			cbHobby[i].setOpaque(false);
			add(cbHobby[i]);
			xpos+=80;
		}

		btnHobby = new JButton("나의 취미 알아보기");
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
		if(ob==cbDriver) {			//isSelected()는 true, false값을 반환하는 메소드. 체크하면 true, 체크해제하면 false
			String s = "체크상태" + cbDriver.isSelected() + "텍스트:" + cbDriver.getText(); //cdDriver의 텍스트를 가져오겠다.불러오겠다.
			lblResult.setText(s);
		} else if(ob==cbBold) {
			if(cbBold.isSelected()){
				lblResult.setFont(new Font("",Font.BOLD,20));
			} else {
				lblResult.setFont(new Font("",Font.PLAIN,12));
			}
		}
	}

	//취미 출력하기 : 카운트를 해서 인덱스를 값을 가져오는 방법.
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btnHobby) {
			int select = 0;
			String s = "나의 취미는 ";
			for(int i = 0; i<cbHobby.length; i++) {
				if(cbHobby[i].isSelected()) {
					select++;
					s+="[" +cbHobby[i].getText() + "]";
				}
			}
//			for(JCheckBox cb : cbHobby) { //향상된 for문으로도 해봤다.
//				if(cb.isSelected()) {
//					select++;
//					s+="[" +cb.getText() + "]";
//					
//				}
//			}
			if(select==0) {
				s = "저는 취미가 없어요";
			} else {
				s+="입니다.";
			}
			lblResult.setText(s);
		}
	}

	


}
