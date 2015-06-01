
public class ChangeValue {
	//this function will change the values or strings in jTextArea1
		 public javax.swing.JTextArea changevalue(javax.swing.JTextArea ta,String tobechange, String changeinto)
		 {
			   int start = ta.getText().indexOf(tobechange);
		        if (start >= 0 && tobechange.length() > 0){
		        	ta.replaceRange(changeinto, start, start
		              + tobechange.length());
		        }
		        
		      return ta;  
		 }
}
