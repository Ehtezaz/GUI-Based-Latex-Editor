package ehtezazahmed;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.font.TextAttribute;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.plaf.ToolBarUI;

public class Text extends JFrame{
	
	Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	
	public Text() {
		
	}
	
	
/////////////////////////////cut copy paste/////////////////////////////////////////
	
	public void cutText(JTextArea field, JLabel status){
		String selectedText = field.getSelectedText();
		StringSelection clipString = new StringSelection(selectedText);
		clip.setContents(clipString,clipString);
		field.replaceRange("", field.getSelectionStart(), field.getSelectionEnd());
		status.setText("Text Cut..");
	}
	
	public void copyText(JTextArea field, JLabel status){
		String selectedText = field.getSelectedText();
		StringSelection clipString = new StringSelection(selectedText);
		clip.setContents(clipString,clipString);
		status.setText("Text Copied..");
	}
	
	public void pasteText(JTextArea field, JLabel status){
		Transferable dataTransfer = clip.getContents(clip);
		try {
			if(dataTransfer.isDataFlavorSupported(DataFlavor.stringFlavor)){
				String selectedData = (String) dataTransfer.getTransferData(DataFlavor.stringFlavor);
				field.replaceSelection(selectedData);
				status.setText("Text Paste..");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Exception: "+ e);
		}
	}
	
/////////////////////////////////////////////////////////////////////////////////////////	

	
///////////////////////////////bold italic underline/////////////////////////////////////	
	private String fontStyle;
	private int fontName;
	private int fontSize;
	
	
	public void boldText(JTextArea field, JLabel status, Font defaultFont){
		fontName = Font.BOLD;
		defaultFont = new Font(fontStyle, fontName, fontSize);
		field.setFont(defaultFont);
		status.setText("Bold..");
	}
	
	public void italicText(JTextArea field, JLabel status, Font defaultFont){
		fontName = Font.ITALIC;
		defaultFont = new Font(fontStyle, fontName, fontSize);
		field.setFont(defaultFont);
		status.setText("Italic..");
	}

/*	public void underlineText(JTextArea field, JLabel status){
		  String s = "\"www.java2s.com\" is great.";

		    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
		        RenderingHints.VALUE_ANTIALIAS_ON);
		    Font plainFont = new Font("Times New Roman", Font.PLAIN, 24);

		    AttributedString as = new AttributedString(s);
		    as.addAttribute(TextAttribute.FONT, plainFont);
		    as.addAttribute(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON, 1,
		        15);
		
		JLabel label = new JLabel("Underlined Label");
		Font font = label.getFont();
		Map attributes = font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		label.setFont(font.deriveFont(attributes));
		
		Map<TextAttribute, Object> map = new Hashtable<TextAttribute, Object>();
			map.put(TextAttribute.KERNING,
			TextAttribute.KERNING_ON);
			defaultFont = defaultFont.deriveFont(map);
			field.setFont(defaultFont);
		status.setText("Underline..");
	}
	
//////////////////////////////////////////////////////////////////////
*/	
	
}
