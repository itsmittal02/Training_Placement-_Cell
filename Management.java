import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Management extends JFrame implements ActionListener{
          JLabel header,body;
		  JButton jb,jb1,jb2,jb3;
		  Font f;
		  Management(String s){
		  super(s);
		  setLayout(null);
		  
		  header=new JLabel(new ImageIcon("mk.jpg"));
		  body=new JLabel(new ImageIcon("man_body.jpg"));
		  f = new Font("Courier New Lucida Console",Font.BOLD,18);
		  
		  jb=new JButton("Student Panel");
		  jb.setFont(f);
		  jb1=new JButton("Company Panel");
		  jb1.setFont(f);
		  jb2=new JButton("Search");
		  jb2.setFont(f);
		  jb3=new JButton("Logout");
		  jb3.setFont(f);
		  
		  header.setBounds(0,0,950,200);
		   
		  body.setBounds(0,200,950,800);
		  jb.setBounds(50,350,150,30);
		  jb1.setBounds(210,350,150,30);
		  jb2.setBounds(370,350,150,30);
		  jb3.setBounds(540,350,150,30);
		  
		  jb.addActionListener(this);
		  jb1.addActionListener(this);
		  jb2.addActionListener(this);
		  jb3.addActionListener(this);
		  
		  add(jb);
		  add(jb1);
		  add(jb2);
		  add(jb3);
		  add(header);
		  add(body);
		  }
		  
		  public void actionPerformed(ActionEvent et){
			 if(et.getSource()==jb){
		        Student ob=new  Student("Student Panel");
			    ob.setSize(950,1000);
			    ob.setVisible(true);
			      //this.setVisible(false);
			 }
			
			else if(et.getSource()==jb1){
		      Company ob=new Company(" Company  Panel");
			  ob.setSize(950,1000);
			  ob.setVisible(true);
			 // this.setVisible(false);
			 }
			
			
			else if(et.getSource()==jb2){
		        Search ob=new  Search("Search Panel");
			    ob.setSize(950,1000);
			    ob.setVisible(true);
			    //this.setVisible(false);
			  }
			  
			  
			else if(et.getSource()==jb3){
		        Login ob=new   Login(" Login Frame");
			   ob.setSize(950,1000);
			   ob.setVisible(true);
			  // this.setVisible(false);
			  }
			  
			 
		}
		 
	 	 public static void main(String []arr){
		      Management ob=new  Management("Management Frame");
			  ob.setSize(950,1000);
			  ob.setVisible(true);
			  }  
}