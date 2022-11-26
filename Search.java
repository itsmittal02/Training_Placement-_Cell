import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.DefaultTableModel;
public class  Search extends JFrame implements ActionListener{
        JComboBox jc;
        JButton jb,jb1,jb2; 
		Connection cn=null;
		Font f;
		DefaultTableModel dtm = null;
		JTable jt=null;
		JScrollPane js=null;
		JLabel header,body;
   	    Search(String s){
	       super(s);
	        setLayout(null);
		    f = new Font("Courier New Lucida Console",Font.BOLD,15);
		    jc = new JComboBox();
			jc.setFont(f);
			jb = new JButton("Search");
			jb1 = new JButton("Exit");
			jb2 = new JButton("Logout");
			header=new JLabel(new ImageIcon("search_panel.jpg"));
			header.setBounds(0,0,950,220);
			
			body=new JLabel(new ImageIcon("search_body.jpg"));
			body.setBounds(0,220,950,780);
			
			
		   jb.setFont(f); 
		   jb1.setFont(f); 
		   jb2.setFont(f); 
		   jc.setBounds(100,300,150,30);
		   jb.setBounds(290,300,100,30);
           jb2.setBounds(420,300,120,30);	
           jb1.setBounds(550,300,120,30);		   
		   add(jc); 
		   add(jb);
		    add(jb1);
			 add(jb2);
		   
		   dtm=new DefaultTableModel();
		   jt=new JTable();
		   jt.setFont(f);
		   
		   dtm.addColumn("Student-ID");
		   dtm.addColumn("Student_Name");
		   dtm.addColumn("Email");
		   dtm.addColumn("Number");
			
		   jb.addActionListener(this);
		   jb1.addActionListener(this);
		   jb2.addActionListener(this);
			try{
 				Class.forName("com.mysql.jdbc.Driver");
			    cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecb","root","");
				Statement st=cn.createStatement();
				ResultSet rs=st.executeQuery("select * from company");
					while(rs.next()){
						 jc.addItem(rs.getString("company_name"));
					}
				}

                 				
			     catch(ClassNotFoundException e){
				System.out.println("Driver : "+ e.getMessage());
				//JOptionPane.showMessageDialog(null, e.getMessage());
			    }
			    catch(SQLException e){
					System.out.println("SQL :  "+e.getMessage());
			     } 
			
				jt.setModel(dtm);
				js= new JScrollPane(jt);
				js.setBounds(50,380,700,250);
				add(js);
				add(header);
				add(body);


			
		  }
		 
	public void actionPerformed(ActionEvent et){
		   dtm.setRowCount(0);
		   if(et.getSource()==jb1){
			   Management d = new Management("Management Record");
			   d.setSize(950,1000);
			   d.setVisible(true);
			   this.setVisible(false);
		   }
		   
		   else if(et.getSource()==jb2){
			   Login d=new Login("Login Record");
			   d.setSize(1000,1000);
			   d.setVisible(true);
			   this.setVisible(false);
		   }
			   
		else{   
		   int percentage=0;
		   int back=0;
		   String company_name=(String)jc.getSelectedItem();
		   try{
			   Statement st=cn.createStatement();
			   ResultSet rs= st.executeQuery("select * from company where company_name='"+company_name+"'"); 
		       if(rs.next()){
				   percentage=rs.getInt("percentage");
				   back=rs.getInt("back");
			   }
			   //System.out.println(percentage+" "+back);
			   Statement st1=cn.createStatement();
			   int flag=0;
			   ResultSet rs1=st.executeQuery("select * from record where tenth_percent>="+percentage+" AND twelfth_percent>="+percentage+" AND btech_percent>="+percentage+" AND back<="+back);
			   while(rs1.next()){
				   flag=1;
				   dtm.addRow(new Object[]{rs1.getString(1),rs1.getString(2),rs1.getString(4),rs1.getString(5)});
				   //System.out.println(rs1.getString(1)+" "rs.getString(2)+" "rs.getString(3)+" "+rs.getString(4));
			    }
			   
			   if(flag==0){
				   JOptionPane.showMessageDialog(null,"Record Not Found");
				  /* Search d = new Search("Search");
					d.setSize(950,1000);
					d.setVisible(true);
					this.setVisible(false);*/
				   
			    }
				cn.close();
		    }
		    catch(Exception e){
		   JOptionPane.showMessageDialog(null, e.getMessage());
		   } 
		      
	    }  
	}
		   public static void main(String []arr){
						   Search dr = new  Search ("Insert Record");
						   dr.setSize(950,1000);
							dr.setVisible(true);
					  } 
}	 