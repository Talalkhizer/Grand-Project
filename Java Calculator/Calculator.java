import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator implements ActionListener  {
JFrame f;
JTextField tf;
JButton[] num_Button=new JButton[10];
JButton[] func_Button=new JButton[9];
JButton addButton,subButton,mulButton,divButton;
JButton decButton,equButton,delButton,clrButton,negButton;
JPanel panel;

Font myFont=new Font("ink Free",Font.BOLD,30);

double num1=0,num2=0,res=0;
char operator;

	Calculator(){
		f=new JFrame("Calculator");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(420, 550);
		f.setLayout(new BorderLayout());
		
		tf=new JTextField();
		tf.setBounds(50, 25, 300, 50);
		tf.setFont(myFont);
		tf.setEditable(false);//work when clicked on a Button
		
		addButton=new JButton("+");
		subButton=new JButton("-");
		mulButton=new JButton("*");
		divButton=new JButton("/");
		decButton=new JButton(".");
		equButton=new JButton("=");
		delButton=new JButton("del");
		clrButton=new JButton("clr");
		negButton=new JButton("(-)");
		
		func_Button[0]=addButton;
		func_Button[1]=subButton;
		func_Button[2]=mulButton;
		func_Button[3]=divButton;
		func_Button[4]=decButton;
		func_Button[5]=equButton;
		func_Button[6]=delButton;
		func_Button[7]=clrButton;
		func_Button[8]=negButton;
		
		for(int i=0;i<9;i++) {
			func_Button[i].addActionListener(this);
			func_Button[i].setFont(myFont);
			func_Button[i].setFocusable(false);
		}
		
		for(int i=0;i<10;i++) {
num_Button[i]=new JButton(String.valueOf(i));
num_Button[i].addActionListener(this);
num_Button[i].setFont(myFont);
num_Button[i].setFocusable(false);
		}
		
		//delButton.setBounds(50, 430, 145, 50);
		//setBounds(205, 430, 145, 50);
		
		panel=new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.setBackground(Color.yellow);
		
		//Row 1st Buttons
		panel.add(num_Button[1]);
		panel.add(num_Button[2]);
		panel.add(num_Button[3]);
		panel.add(addButton);
		
		//Row 2nd Buttons
		panel.add(num_Button[4]);
		panel.add(num_Button[5]);
		panel.add(num_Button[6]);
		panel.add(subButton);
		
		//Row 3rd Buttons
		panel.add(num_Button[7]);
		panel.add(num_Button[8]);
		panel.add(num_Button[9]);
		panel.add(mulButton);
		
		panel.add(num_Button[0]);
		panel.add(decButton);
		panel.add(equButton);
		panel.add(divButton);
		panel.add(negButton);
		
		f.add(panel,BorderLayout.CENTER);
		f.add(delButton,BorderLayout.SOUTH);
		f.add(clrButton,BorderLayout.EAST);
		f.add(tf,BorderLayout.NORTH);
		f.add(negButton,BorderLayout.WEST);		
		f.setVisible(true);
}

	
	
	
	
	
	public static void main(String[]args) {
		Calculator calc=new Calculator();
	}

	
	public void actionPerformed(ActionEvent e) {
	for(int i=0;i<10;i++) {
		if(e.getSource()==num_Button[i]) {
			tf.setText(tf.getText().concat(String.valueOf(i)));
		}
	}
	if(e.getSource()==decButton) {
		tf.setText(tf.getText().concat("."));
	}
	if(e.getSource()==addButton) {
		num1=Double.parseDouble(tf.getText());
		operator='+';
		tf.setText("");	
	}
	if(e.getSource()==subButton) {
		num1=Double.parseDouble(tf.getText());
		operator='-';
		tf.setText("");	
	}
	if(e.getSource()==mulButton) {
		num1=Double.parseDouble(tf.getText());
		operator='*';
		tf.setText("");	
	}
	if(e.getSource()==divButton) {
		num1=Double.parseDouble(tf.getText());
		operator='/';
		tf.setText("");	
	}
	if(e.getSource()==equButton) {
		num2=Double.parseDouble(tf.getText());
		
		switch(operator) {
		case'+':
			res=num1+num2;
			break;
		case'-':
			res=num1-num2;
			break;
		case'*':
			res=num1*num2;
			break;
		case'/':
			res=num1/num2;
			break;
		}
		tf.setText(String.valueOf(res));
		num1=res;
	}
	if(e.getSource()==clrButton) {
	tf.setText("");
	}
	if(e.getSource()==delButton) {
		String str=tf.getText();
		tf.setText("");
		for(int i=0;i<str.length()-1;i++) {
			tf.setText(tf.getText()+str.charAt(i));
		}
	
	
	}
	if(e.getSource()==negButton) {
		double temp=Double.parseDouble(tf.getText());
		temp*=-1;
		tf.setText(String.valueOf(temp));
	}
}
}
