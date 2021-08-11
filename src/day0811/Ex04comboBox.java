package day0811;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
//콤보박스는 배열 아니면 벡터를 주로 쓴다.
public class Ex04comboBox extends JFrame implements ItemListener, ActionListener{
	JComboBox<String> combo;
	String[] names = {"캔디", "앤", "안쏘니", "둘리"};
	JTextField tfName;
	JButton btnAdd, btnDel;
	JLabel lblResult;
	int idx=-1; //값을 안주고 초기화 상태로 두면 자동으로 0으로 초기화 되서
				//배열의 0번째 값이 불러와지기 때문에 초기화 값을 -1로 줌. 

	public Ex04comboBox() {
		super("ComboBox");
		this.setBounds(800, 100, 400, 400);
		this.getContentPane().setBackground(Color.white);
		this.setDesign();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void setDesign() {
		this.setLayout(null);

		combo = new JComboBox<String>(names); //콤보박스 combo에 String타입의 배열인 names를 넣어준다는 뜻.
		combo.setBounds(30, 30, 100, 30);
		this.add(combo);

		tfName = new JTextField();
		tfName.setBounds(30, 90, 100, 30);
		this.add(tfName);

		btnAdd = new JButton("추가");
		btnAdd.setBounds(150, 90, 80, 30);
		this.add(btnAdd);

		btnDel = new JButton("삭제");
		btnDel.setBounds(250, 90, 80, 30);
		this.add(btnDel);

		lblResult = new JLabel("Result", JLabel.CENTER);
		lblResult.setBorder(new LineBorder(Color.pink,8));
		lblResult.setBounds(20,230,350,60);
		this.add(lblResult);
		
		combo.addItemListener(this);
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
	}

	public static void main(String[] args) {
		new Ex04comboBox();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object ob = e.getSource();
		if(ob==btnAdd) {
			String text = (tfName.getText().trim()); //공백제거를 안하면 공백만 입력했을 때도 추가가 된다.
			if(text.length()==0) {
				JOptionPane.showMessageDialog(this, "이름을 입력 후 추가 버튼을 누르세요.");
			} else {
				combo.addItem(text);
				tfName.setText(""); //이름을 추가하고 그 다음 이름을 추가하기 위해 
									//텍스트 필드에 ""을 줘서(setText) 텍스트 필드를 깨끗하게(?) 하겠다.
			}
			
		} else if(ob==btnDel) {
			if(idx==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 항목을 선택해 주세요.");
			} else {
				try {
				combo.removeItemAt(idx);
				lblResult.setText("해당 항목을 삭제했습니다.");
				} catch(ArrayIndexOutOfBoundsException e1) {
					lblResult.setText("삭제할 항목이 없습니다.");
				}
			}
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		idx = combo.getSelectedIndex();
//		String item = combo.getSelectedItem().toString(); //선택할 값이 없어지면(null) 에러가 난다.
		String item = (String)combo.getSelectedItem(); //얘는 선택할 값이 없어도 에러가 나지 않는다.
		
		lblResult.setText(idx + "번 인덱스의 " + item + "선택!");
	}

}
