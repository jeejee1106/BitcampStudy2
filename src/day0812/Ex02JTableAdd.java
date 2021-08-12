package day0812;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex02JTableAdd extends JFrame implements ActionListener{
	JTextField tfSang, tfSu, tfDan;
	JButton btnAdd, btnDel;
	DefaultTableModel model;
	JTable table;
	int selectRow = -1;
	
	static final String FILENAME = "D:\\bitjava0719\\javawork\\TableData.txt";
	
	public Ex02JTableAdd() {
		super("Table ���� #2");
		this.setBounds(700,100,400,400);
		this.setDesign();
		this.tableReadData(); //���̺� ���� �� ���� ������ �߰�
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() { //���� �� ���̺� ������ ����
			@Override
			public void windowClosing(WindowEvent e) {
				tableDataSave();
				JOptionPane.showMessageDialog(Ex02JTableAdd.this, "���ð� ���� �� �����մϴ�.");
				System.exit(0);
			}
		
		});
		
		this.setVisible(true);
	}
	
	public void tableDataSave() {
		FileWriter fw = null;
//		int total = Integer.parseInt(su)*Integer.parseInt(dan);
		try {
			fw = new FileWriter(FILENAME);
			for(int i =0; i<table.getRowCount(); i++) {
				String s = "";
				for(int j = 0; j<table.getColumnCount(); j++) {
					s+=table.getValueAt(i, j)+":";
				}
				//������ �� ���� �ݷ� ����
				s=s.substring(0,s.length()-1);
				fw.write(s+"\n");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw==null); fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void tableReadData() {
		FileReader fr = null;
		BufferedReader br = null;
		
		
		try {
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			 
//			tfSu = Integer.parseInt(br.readLine());
//			tfDan = Integer.parseInt(br.readLine());
			
			while(true) {
				String s = br.readLine();
				if(s==null) {
					break;
				}
				String[] data = s.split(":");
				model.addRow(data); //�𵨷� �ҷ����� ���� �迭���µ� �����ϴ�.
//				String sang = data[0];
//				int su = Integer.parseInt(data[1]);
//				int dan = Integer.parseInt(data[2]);
//				int total = Integer.parseInt(su)*Integer.parseInt(dan);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "�ҷ��� ������ �����");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br==null); br.close();
				if(fr==null); fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private void setDesign() {
		this.setLayout(null);
		JLabel lbl1 = new JLabel("��ǰ��");
		JLabel lbl2 = new JLabel("����");
		JLabel lbl3 = new JLabel("�ܰ�");
		
		lbl1.setBounds(30, 20, 80, 30);
		this.add(lbl1);
		lbl2.setBounds(150, 20, 80, 30);
		this.add(lbl2);
		lbl3.setBounds(270, 20, 80, 30);
		this.add(lbl3);
		
		tfSang = new JTextField();
		tfSang.setBounds(20, 60, 100, 30);
		this.add(tfSang);
		
		tfSu = new JTextField();
		tfSu.setBounds(140, 60, 70, 30);
		this.add(tfSu);
		
		tfDan = new JTextField();
		tfDan.setBounds(250, 60, 70, 30);
		this.add(tfDan);
		
		btnAdd = new JButton("�߰�");
		btnAdd.setBounds(50, 120, 100, 30);
		this.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnDel = new JButton("����");
		btnDel.setBounds(170, 120, 100, 30);
		this.add(btnDel);
		btnDel.addActionListener(this);
		
		
		String[] title = {"��ǰ��", "����", "�ܰ�", "�� �ݾ�"};
		model = new DefaultTableModel(title,0); //0�� �� ������
		table = new JTable(model);
		
		JScrollPane js = new JScrollPane(table); //������ ������ Table�� ������ �ϱ� ������ JScrollPane()�������.
		js.setBounds(20,170,350,180);
		this.add(js);
		
		//tableŬ���� ������ ��ȣ�� selectRow�� ����
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				selectRow = table.getSelectedRow(); //���ȣ ����
				
			}
		});
		
	}

	public static void main(String[] args) {
		
		new Ex02JTableAdd();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btnAdd) {
			String sang = tfSang.getText().trim();
			String su = tfSu.getText().trim();
			String dan = tfDan.getText().trim();
			if(sang.length()==0 || su.length()==0 || dan.length()==0) {
				JOptionPane.showMessageDialog(this, "3���� ���� ��� �Է��� �ּ���.");
				return;
			}
			int total = 0;
			try {
				total = Integer.parseInt(su)*Integer.parseInt(dan);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "�����̳� �ܰ��� ���ڰ� �����־��\n" + e1.getMessage());
				return;
			}
			NumberFormat nf = NumberFormat.getInstance();
			Vector<String> data = new Vector<String>();
			data.add(sang);
			data.add(su);
			data.add(dan);
			data.add(nf.format(total));
			
			//���̺� �߰�
			model.addRow(data);
			tfSang.setText("");
			tfSu.setText("");
			tfDan.setText("");
			
		} else if(ob==btnDel) {
			if(selectRow==-1) {
				JOptionPane.showMessageDialog(this, "������ �׸��� �������ּ���");
			} else {
				model.removeRow(selectRow);
				selectRow = -1;
			}
			
			
		}
		
		
		
		
	}

}
