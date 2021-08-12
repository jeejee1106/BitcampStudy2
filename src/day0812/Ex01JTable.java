package day0812;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
//JTable�� �������.
//�پ��� ������ Table�� ���� �� �ִ�.
public class Ex01JTable extends JFrame {
	JTable tb1, tb2, tb3, tb4;
	JTextArea area;

	public Ex01JTable() {
		super("JTable����");
		this.setBounds(600, 100, 700, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		this.setLayout(new GridLayout(2, 2, 5, 5)); //�⺻ Layout�� BorderLayouy. �׵����� Layout�� ��� ���ּ� ��.
													 //������ GridLayout�� �ẽ.
		//1. ��� ���� ������ Table �����
		tb1 = new JTable(5, 4); //��� �����ֱ�
		this.add(tb1);
		
		//2. �迭�� ���� ���� Table �����(Table ���� �� ������ �ֱ�)
		String[] title1 = {"�̸�", "����", "�ּ�"};
		String[][] data1 = {{"ĵ��", "23", "������"},{"�Ѹ�", "11", "�λ��"},{"�","25","�뱸��"}};
		tb2 = new JTable(data1, title1);
		this.add(new JScrollPane(tb2)); //JScrollPane ���� �߰������ title(����)�� ���´�.
		
		//3. Model�� �̿��� Table �����. (Model�� �̿��� Table ������ �߰�, ������ �����ϴ�.)
		DefaultTableModel model1 = new DefaultTableModel(data1, title1);
		tb3 = new JTable(model1);
		this.add(new JScrollPane(tb3));
		String[] addData1 = {"��ȣ��", "40", "���"};	//�߰��� ������ �ۼ�
		model1.addRow(addData1); //Model�� �̿��� Table�� ������ �߰�!
		
		Vector<String> addData2 = new Vector<String>();
		addData2.add("���缮");
		addData2.add("34");
		addData2.add("���ֵ�");
		model1.addRow(addData2); //Vector�� �̿��� Table�� ������ �߰�!

		area = new JTextArea();
		this.add(new JScrollPane(area));
		
		//JTable�� �޼��� ��� Ȯ��
		int rowCount1 = tb3.getRowCount();
		int rowCount2 = model1.getRowCount(); // .getRowCount() : �� ���� ����
		area.append("tb3�� �� ����" + rowCount1 + "\n");
		area.append("tb3�� �� ����" + rowCount2 + "\n");
		
		int columnCount = tb3.getColumnCount(); // .getColumnCount() : �� ���� ����
		area.append("tb3�� �� ����" + columnCount + "\n");
		
		area.append("1�� 1���� �� " + tb3.getValueAt(1, 1) + "\n"); // .getValueAt() : ������ ����� �����Ͱ� ���
		area.append("3�� 2���� �� " + tb3.getValueAt(3, 2) + "\n");
		area.append("3�� 2���� �� " + model1.getValueAt(3, 2) + "\n");
		
		//�͸� ����Ŭ������ �̿��� ���콺 �̺�Ʈ �����
		tb3.addMouseListener(new MouseAdapter() {     //MouseAdapterŬ������ �����ϰ�
			@Override
			public void mouseClicked(MouseEvent e) { //mouseClicked() �޼��� �������̵� ���ֱ�.
				super.mouseClicked(e);
				
				int row = tb3.getSelectedRow(); //Ŭ���� �� ��ȣ ���
				int col = tb3.getSelectedColumn(); //Ŭ���� �� ��ȣ ���
				
				area.append(row + "," + col + "=" + tb3.getValueAt(row, col) + "\n");
				
				
			}
		});
		
		
		
		
		//4. 
		
		
	}

	public static void main(String[] args) {
		new Ex01JTable();
	}

}
