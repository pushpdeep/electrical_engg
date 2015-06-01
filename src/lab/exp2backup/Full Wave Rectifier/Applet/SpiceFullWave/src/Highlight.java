import java.awt.Color;

import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;


public class Highlight {

	public javax.swing.JTextArea highlighter(javax.swing.JTextArea ta, String highlight)
	 {
		 Highlighter highlighter = ta.getHighlighter();
        HighlightPainter painter = 
        new DefaultHighlighter.DefaultHighlightPainter(Color.PINK);
        int p10 = ta.getText().indexOf(highlight);
        int p11 = p10 + highlight.length();
        try{
        highlighter.addHighlight(p10, p11, painter);
        //set cursor position to the highlighted value
        ta.setCaretPosition(ta.getText().indexOf(highlight));
        }
        catch(Exception e)
        {}
        return ta;
	 }
	
}
