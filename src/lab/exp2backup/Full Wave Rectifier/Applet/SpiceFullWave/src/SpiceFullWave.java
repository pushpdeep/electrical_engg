
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;


public class SpiceFullWave extends JApplet {

	String [] fonts = getToolkit().getFontList(); 
	SpiceFullWave.MyPane myPane;
	javax.swing.JTextArea jTextArea1;
	JScrollPane areaScrollPane;
	javax.swing.JTextArea spiceArea;
	
	String title = "Full Wave Rectifier";
	String text="";
	String basic = "";
	String changed_value="";
	String change_value_into="";
	String start = "This TestArea will show the netlist written in '.cir' file,"+
	"this '.cir' file named as 'spice.cir' and run by NGspice console shown here"+
			"Please click on 'Load Netlist' file to view the netlist";
   
    Image ngspice,circuit,output,out1,out2,out3,out4,out5,out6,out7,out8,out9,out10;
    int out = 0,para=0;
    
    javax.swing.JLabel spice_image;    
    javax.swing.JButton loadnetlist;
    javax.swing.JButton runspice;
    javax.swing.JButton default_con;
    javax.swing.JButton add_cap;
    
    
   //can change
    String[] value1 = { "R2 5 0 1K", "R2 5 0 10K" };
    String[] value2 = {"C1 5 0 0u", "C1 5 0 4.7u", "C1 5 0 47u", "C1 5 0 100u" };
    String printval1 = "Value of RL", printval2 = "Value of C1";
    public JComboBox<String> val1;
    public JComboBox<String> val2;
    
    //for resizing Applet components
    int applet_x=850,applet_y=550;
    int netlist_x = (applet_x/2)+applet_x/40,netlist_y=(applet_y/2)+(applet_y/9);
    int out_x =applet_x-netlist_x-20,out_y=netlist_y;
    int ngspice_x=netlist_x,ngspice_y=applet_y-netlist_y-40;
    int spice_area_x=15,spice_area_y=504;

	public void init(){
		// setSize(765, 470);
		 setSize(applet_x, applet_y);
		//setBackground(new Color(239, 248, 255));
		setBackground(new Color(240, 245, 254));
		setLayout(null);
	    try {     
        	components();
            } catch (Exception ex) {
        	             ex.printStackTrace();
        	         }
	}
	
	public void start(){
		
	}
	
	public void components(){
		
		 myPane = new SpiceFullWave.MyPane();	
	     setContentPane(myPane);
	     setLayout(null);
	  
	    val1 = new JComboBox<String>();
	    for(int i = 0; i < value1.length; i++) val1.addItem(value1[i]);
	 	val1.setBounds( netlist_x+applet_x/20, applet_y-40, applet_x/9-10, 20 );
	 	myPane.add(val1);  
	 	val1.setVisible(false);
	     
	 	val2 = new JComboBox<String>();
	    for(int i = 0; i < value2.length; i++) val2.addItem(value2[i]);
	 	val2.setBounds( netlist_x+applet_x/5-10, applet_y-40, applet_x/9-10, 20 );
	 	myPane.add(val2); 
	 	val2.setVisible(false);
	 	
	  ReadImage img = new ReadImage();
	 // ngspice = img.readimage("data/ngspice.jpg").getScaledInstance(370, 155, Image.SCALE_SMOOTH);
	  ngspice = img.readimage("data/ngspice.jpg").getScaledInstance(ngspice_x, ngspice_y, Image.SCALE_SMOOTH);
	  ReadImage img1 = new ReadImage();
     // circuit = img1.readimage("data/circuit.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);;
      circuit = img1.readimage("data/circuit.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);;
      ReadImage img2 = new ReadImage();
      out1 = img2.readimage("data/output1.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out2 = img2.readimage("data/output2.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out3 = img2.readimage("data/output3.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out4 = img2.readimage("data/output4.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out5 = img2.readimage("data/output5.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out6 = img2.readimage("data/output6.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out7 = img2.readimage("data/output7.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out8 = img2.readimage("data/output8.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out9 = img2.readimage("data/output9.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      out10 = img2.readimage("data/output10.jpg").getScaledInstance(out_x, out_y, Image.SCALE_SMOOTH);
      
      jTextArea1 = new javax.swing.JTextArea();
	  spiceArea = new javax.swing.JTextArea();
	 	
	     jTextArea1.setText(start);
         jTextArea1.setEditable(false);
         jTextArea1.setLineWrap(true);
         jTextArea1.setWrapStyleWord(true);
         jTextArea1.setFont(new Font("Serif", Font.ITALIC,17));
         jTextArea1.setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.WHITE));
         jTextArea1.setCaretPosition(0); 
         jTextArea1.setBackground(new Color(240, 245, 254));
         areaScrollPane = new JScrollPane(jTextArea1);
         areaScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         areaScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        //areaScrollPane.setBounds(8,30,370,270);
         areaScrollPane.setBounds(8,30,netlist_x,netlist_y);
         myPane.add(areaScrollPane);
         
         
         spiceArea.setText("");
         spiceArea.setEditable(false);
         spiceArea.setLineWrap(true);
         spiceArea.setWrapStyleWord(true);
         spiceArea.setFont(new Font("Verdana", Font.LAYOUT_LEFT_TO_RIGHT,13));
         spiceArea.setForeground(Color.black);
         spiceArea.setCaretPosition(0);
         spiceArea.setBounds(spice_area_x,spice_area_y,410,15);
         myPane.add(spiceArea);
         
         
         loadnetlist = new javax.swing.JButton();
         runspice = new javax.swing.JButton();
         default_con = new javax.swing.JButton();
         
         
         loadnetlist.setDoubleBuffered(true);
         loadnetlist.setName("loadnetlist");
         loadnetlist.setText("Load Netlist");
         loadnetlist.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 loadnetlist(evt);
             }
         });
         myPane.add(loadnetlist);
        // loadnetlist.setBounds(440, 325, 120, 20);
         loadnetlist.setBounds(netlist_x+20, (netlist_y+50), applet_x/7, 20);
         
         runspice.setDoubleBuffered(true);
         runspice.setName("Run spice");
         runspice.setText("Run");
         runspice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runspice(evt);
            }
        });
        myPane.add(runspice);        
        //runspice.setBounds(600, 410, 120, 20);
        runspice.setBounds(applet_x-(applet_x/7)-20, applet_y-40, applet_x/7, 20);
        runspice.setVisible(false);
         
        default_con.setDoubleBuffered(true);
        default_con.setName("default_con");
        default_con.setText("Default");
        default_con.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
            	 default_con(evt);
             }
         });
         myPane.add(default_con);
         default_con.setBounds(applet_x-(applet_x/7)-20, (netlist_y+50), applet_x/7, 20);
         default_con.setVisible(false);
         
       /*  add_cap.setDoubleBuffered(true);
         add_cap.setName("add_cap");
         add_cap.setText("Set to Default");
         add_cap.addActionListener(new java.awt.event.ActionListener() {
              public void actionPerformed(java.awt.event.ActionEvent evt) {
            	  add_cap(evt);
              }
          });
          myPane.add(add_cap);
          add_cap.setBounds(applet_x-(applet_x/7)-20, (netlist_y+50), applet_x/7, 20);
          add_cap.setVisible(false);*/
	}
	
	 private void loadnetlist(java.awt.event.ActionEvent evt)         
     {
		 out = 0;
		 para =1;
			 Spice s = new Spice();
			 jTextArea1.setText(s.Spice);
	         jTextArea1.setCaretPosition(0); 
	         
	         default_con.setVisible(true);
	         runspice.setVisible(true);
	         val1.setVisible(true);
	         val2.setVisible(true);
	         
	         repaint();
     }
	 
	 private void runspice(java.awt.event.ActionEvent evt)         
     {
		 out = 1;
		 para=1;
		 ReadImage img2 = new ReadImage();
		 
		 if(val1.getSelectedIndex()==0&&val2.getSelectedIndex()==0){
       //  output = img2.readimage("data/output1.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);
		 output = out1;
		 }//1
		 else if(val1.getSelectedIndex()==0&&val2.getSelectedIndex()==1){
			output = out2; 
			 //output = img2.readimage("data/output2.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//2
		 else if(val1.getSelectedIndex()==0&&val2.getSelectedIndex()==2){
			// output = img2.readimage("data/output3.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);
			 output = out3;
		 }//3
		 else if(val1.getSelectedIndex()==0&&val2.getSelectedIndex()==3){
			output=out4;
			//output = img2.readimage("data/output4.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//4
		 else if(val1.getSelectedIndex()==0&&val2.getSelectedIndex()==4){
			output=out5;// output = img2.readimage("data/output5.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//5
		 else if(val1.getSelectedIndex()==1&&val2.getSelectedIndex()==0){
			output=out6;// output = img2.readimage("data/output6.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//6
		 else if(val1.getSelectedIndex()==1&&val2.getSelectedIndex()==1){
			output=out7;// output = img2.readimage("data/output7.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//7
		 else if(val1.getSelectedIndex()==1&&val2.getSelectedIndex()==2){
			output=out8;// output = img2.readimage("data/output8.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//8
		 else if(val1.getSelectedIndex()==1&&val2.getSelectedIndex()==3){
			output=out9;// output = img2.readimage("data/output9.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
		 }//9
		 else if(val1.getSelectedIndex()==1&&val2.getSelectedIndex()==4){
			output=out10;// output = img2.readimage("data/output9.jpg").getScaledInstance(370, 270, Image.SCALE_SMOOTH);	 
			 }//10
		 else{
			 
		 }
		 
		 Spice s = new Spice();
		 jTextArea1.setText(s.Spice);
		 ChangeValue cv = new ChangeValue();
		 jTextArea1 = cv.changevalue(jTextArea1, (String)val1.getItemAt(0), (String)val1.getSelectedItem());
		 jTextArea1 = cv.changevalue(jTextArea1, (String)val2.getItemAt(0), (String)val2.getSelectedItem());
		 Highlight hl = new Highlight();
	     jTextArea1 = hl.highlighter(jTextArea1, (String)val2.getSelectedItem());
	     jTextArea1 = hl.highlighter(jTextArea1, (String)val1.getSelectedItem());
	     //Highlight hl = new Highlight();
	     
	     //to set spice.cir in ngspice ui
		 spiceArea.setText("spice.cir");
		 spiceArea = hl.highlighter(spiceArea, "spice.cir");
         default_con.setVisible(true);
        
         repaint();
     
     }
	 
	 private void default_con(java.awt.event.ActionEvent evt)       
     {
		 out = 0;
		 para=0;
			 Spice s = new Spice();
			 jTextArea1.setText(start);
	         jTextArea1.setCaretPosition(0); 
	         
	         default_con.setVisible(false);
	         runspice.setVisible(false);
	         val1.setVisible(false);
	         val2.setVisible(false);
	         spiceArea.setText("");
		         repaint(); 
	        
     }	 
	 
	 
	public void stop(){
		
	}
	

	public class MyPane extends JPanel{
	
		public void paintComponent(Graphics g) {
			
			 g.setColor(Color.black);
			//FOR NETLIST AND INSTRUCTION PANEL
			 g.drawRect(5, 27,netlist_x+5, netlist_y+5);
			// FOR CIRCUIT AND OUTPUT PANEL
			 g.drawRect(netlist_x+10, 27,out_x+5, out_y+5);
			 //FOR NGSPICE IMAGE BOX
			 g.drawRect(5, netlist_y+32,netlist_x+5, ngspice_y+5);
			 //FOR BUTTON PANEL
			 g.drawRect(netlist_x+10, netlist_y+32,out_x+5, ngspice_y+5);
			 
			 g.setColor(Color.red);
			 g.setFont(new Font(fonts[2], Font.ITALIC, 14));
			 g.drawString("Instructions / Netlist", 10, 20);
			 g.drawString("Circuit / Output", applet_x-110, 20);
			 g.setColor(Color.black);
			 g.setFont(new Font(fonts[3], Font.BOLD, 20));
			 g.drawString(title, (applet_x/2)-100, 20);
			 g.setColor(Color.black);
			 g.setFont(new Font(fonts[1], Font.BOLD, 12));
			 if(para==1)
				 {
				 g.drawString("Try Changing the values, then click 'Run'", netlist_x+applet_x/11, netlist_y+applet_y/5);
				 g.drawString(printval1, netlist_x+applet_x/20, applet_y-60);
				 g.drawString(printval2, netlist_x+applet_x/5, applet_y-60);
				 }
			 else{}
              // g.drawImage(ngspice,8,307,this);
               g.drawImage(ngspice,8,netlist_y+35,this);
                         
                 if(out==0){
               //  g.drawImage(circuit,387,30,this);
               g.drawImage(circuit,netlist_x+13,30,this);
                 		   }
                 else if(out==1)
                 {
                 g.drawImage(output,netlist_x+13,30,this); 
                 }
                 else{}
            
		 }
		
	}
	
	
}

