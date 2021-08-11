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
//�޺��ڽ��� �迭 �ƴϸ� ���͸� �ַ� ����.
public class Ex04comboBox extends JFrame implements ItemListener, ActionListener{
	JComboBox<String> combo;
	String[] names = {"ĵ��", "��", "�Ƚ��", "�Ѹ�"};
	JTextField tfName;
	JButton btnAdd, btnDel;
	JLabel lblResult;
	int idx=-1; //���� ���ְ� �ʱ�ȭ ���·� �θ� �ڵ����� 0���� �ʱ�ȭ �Ǽ�
				//�迭�� 0��° ���� �ҷ������� ������ �ʱ�ȭ ���� -1�� ��. 

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

		combo = new JComboBox<String>(names); //�޺��ڽ� combo�� StringŸ���� �迭�� names�� �־��شٴ� ��.
		combo.setBounds(30, 30, 100, 30);
		this.add(combo);

		tfName = new JTextField();
		tfName.setBounds(30, 90, 100, 30);
		this.add(tfName);

		btnAdd = new JButton("�߰�");
		btnAdd.setBounds(150, 90, 80, 30);
		this.add(btnAdd);

		btnDel = new JButton("����");
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
			String text = (tfName.getText().trim()); //�������Ÿ� ���ϸ� ���鸸 �Է����� ���� �߰��� �ȴ�.
			if(text.length()==0) {
				JOptionPane.showMessageDialog(this, "�̸��� �Է� �� �߰� ��ư�� ��������.");
			} else {
				combo.addItem(text);
				tfName.setText(""); //�̸��� �߰��ϰ� �� ���� �̸��� �߰��ϱ� ���� 
									//�ؽ�Ʈ �ʵ忡 ""�� �༭(setText) �ؽ�Ʈ �ʵ带 �����ϰ�(?) �ϰڴ�.
			}
			
		} else if(ob==btnDel) {
			if(idx==-1) {
				JOptionPane.showMessageDialog(this, "������ �׸��� ������ �ּ���.");
			} else {
				try {
				combo.removeItemAt(idx);
				lblResult.setText("�ش� �׸��� �����߽��ϴ�.");
				} catch(ArrayIndexOutOfBoundsException e1) {
					lblResult.setText("������ �׸��� �����ϴ�.");
				}
			}
			
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		idx = combo.getSelectedIndex();
//		String item = combo.getSelectedItem().toString(); //������ ���� ��������(null) ������ ����.
		String item = (String)combo.getSelectedItem(); //��� ������ ���� ��� ������ ���� �ʴ´�.
		
		lblResult.setText(idx + "�� �ε����� " + item + "����!");
	}

}
