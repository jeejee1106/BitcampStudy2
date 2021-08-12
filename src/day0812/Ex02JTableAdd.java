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
		super("Table 연습 #2");
		this.setBounds(700,100,400,400);
		this.setDesign();
		this.tableReadData(); //테이블 생성 후 파일 데이터 추가
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() { //종료 시 테이블 데이터 저장
			@Override
			public void windowClosing(WindowEvent e) {
				tableDataSave();
				JOptionPane.showMessageDialog(Ex02JTableAdd.this, "셋팅값 저장 후 종료합니다.");
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
				//마지막 한 글자 콜론 제거
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
				model.addRow(data); //모델로 불러오는 것은 배열형태도 가능하다.
//				String sang = data[0];
//				int su = Integer.parseInt(data[1]);
//				int dan = Integer.parseInt(data[2]);
//				int total = Integer.parseInt(su)*Integer.parseInt(dan);
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "불러올 파일이 없어요");
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
		JLabel lbl1 = new JLabel("상품명");
		JLabel lbl2 = new JLabel("수량");
		JLabel lbl3 = new JLabel("단가");
		
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
		
		btnAdd = new JButton("추가");
		btnAdd.setBounds(50, 120, 100, 30);
		this.add(btnAdd);
		btnAdd.addActionListener(this);
		
		btnDel = new JButton("삭제");
		btnDel.setBounds(170, 120, 100, 30);
		this.add(btnDel);
		btnDel.addActionListener(this);
		
		
		String[] title = {"상품명", "수량", "단가", "총 금액"};
		model = new DefaultTableModel(title,0); //0은 행 갯수임
		table = new JTable(model);
		
		JScrollPane js = new JScrollPane(table); //제목이 나오게 Table을 만들어야 하기 때문에 JScrollPane()을사용함.
		js.setBounds(20,170,350,180);
		this.add(js);
		
		//table클릭시 선택한 번호를 selectRow에 저장
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				
				selectRow = table.getSelectedRow(); //행번호 저장
				
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
				JOptionPane.showMessageDialog(this, "3개의 값을 모두 입력해 주세요.");
				return;
			}
			int total = 0;
			try {
				total = Integer.parseInt(su)*Integer.parseInt(dan);
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "수량이나 단가에 문자가 섞여있어요\n" + e1.getMessage());
				return;
			}
			NumberFormat nf = NumberFormat.getInstance();
			Vector<String> data = new Vector<String>();
			data.add(sang);
			data.add(su);
			data.add(dan);
			data.add(nf.format(total));
			
			//테이블에 추가
			model.addRow(data);
			tfSang.setText("");
			tfSu.setText("");
			tfDan.setText("");
			
		} else if(ob==btnDel) {
			if(selectRow==-1) {
				JOptionPane.showMessageDialog(this, "삭제할 항목을 선택해주세요");
			} else {
				model.removeRow(selectRow);
				selectRow = -1;
			}
			
			
		}
		
		
		
		
	}

}
