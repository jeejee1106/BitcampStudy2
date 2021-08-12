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
//JTable을 배워보자.
//다양한 형태의 Table을 만들 수 있다.
public class Ex01JTable extends JFrame {
	JTable tb1, tb2, tb3, tb4;
	JTextArea area;

	public Ex01JTable() {
		super("JTable연습");
		this.setBounds(600, 100, 700, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDesign();
		this.setVisible(true);
	}
	
	private void setDesign() {
		this.setLayout(new GridLayout(2, 2, 5, 5)); //기본 Layout은 BorderLayouy. 그동안은 Layout을 모두 없애서 씀.
													 //오늘은 GridLayout을 써봄.
		//1. 행과 열을 지정한 Table 만들기
		tb1 = new JTable(5, 4); //행렬 정해주기
		this.add(tb1);
		
		//2. 배열에 값을 넣은 Table 만들기(Table 생성 시 데이터 넣기)
		String[] title1 = {"이름", "나이", "주소"};
		String[][] data1 = {{"캔디", "23", "강남구"},{"둘리", "11", "부산시"},{"헨리","25","대구시"}};
		tb2 = new JTable(data1, title1);
		this.add(new JScrollPane(tb2)); //JScrollPane 으로 추가해줘야 title(제목)이 나온다.
		
		//3. Model을 이용해 Table 만들기. (Model을 이용한 Table 생성은 추가, 수정이 가능하다.)
		DefaultTableModel model1 = new DefaultTableModel(data1, title1);
		tb3 = new JTable(model1);
		this.add(new JScrollPane(tb3));
		String[] addData1 = {"강호동", "40", "도곡동"};	//추가할 데이터 작성
		model1.addRow(addData1); //Model을 이용한 Table에 데이터 추가!
		
		Vector<String> addData2 = new Vector<String>();
		addData2.add("유재석");
		addData2.add("34");
		addData2.add("제주도");
		model1.addRow(addData2); //Vector를 이용한 Table에 데이터 추가!

		area = new JTextArea();
		this.add(new JScrollPane(area));
		
		//JTable과 메서드 몇가지 확인
		int rowCount1 = tb3.getRowCount();
		int rowCount2 = model1.getRowCount(); // .getRowCount() : 행 갯수 세기
		area.append("tb3의 행 갯수" + rowCount1 + "\n");
		area.append("tb3의 행 갯수" + rowCount2 + "\n");
		
		int columnCount = tb3.getColumnCount(); // .getColumnCount() : 열 갯수 세기
		area.append("tb3의 열 갯수" + columnCount + "\n");
		
		area.append("1행 1열의 값 " + tb3.getValueAt(1, 1) + "\n"); // .getValueAt() : 지정한 행렬의 데이터값 얻기
		area.append("3행 2열의 값 " + tb3.getValueAt(3, 2) + "\n");
		area.append("3행 2열의 값 " + model1.getValueAt(3, 2) + "\n");
		
		//익명 내부클래스를 이용한 마우스 이벤트 만들기
		tb3.addMouseListener(new MouseAdapter() {     //MouseAdapter클래스를 생성하고
			@Override
			public void mouseClicked(MouseEvent e) { //mouseClicked() 메서드 오버라이드 해주기.
				super.mouseClicked(e);
				
				int row = tb3.getSelectedRow(); //클릭한 행 번호 얻기
				int col = tb3.getSelectedColumn(); //클릭한 열 번호 얻기
				
				area.append(row + "," + col + "=" + tb3.getValueAt(row, col) + "\n");
				
				
			}
		});
		
		
		
		
		//4. 
		
		
	}

	public static void main(String[] args) {
		new Ex01JTable();
	}

}
