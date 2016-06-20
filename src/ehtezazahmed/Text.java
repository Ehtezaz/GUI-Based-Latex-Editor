package ehtezazahmed;

import java.awt.Color;
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

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.plaf.ToolBarUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledEditorKit;

public class Text extends JFrame{
	
	Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
	
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	
	public Text() {
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////cut copy paste/////////////////////////////////////////
	
	public void cutText(JTextPane field, JLabel status){
		if(field.getSelectedText() != null){
			String selectedText = field.getSelectedText();
			StringSelection clipString = new StringSelection(selectedText);
			clip.setContents(clipString,clipString);
			field.replaceSelection("");
			//field.replaceRange("", field.getSelectionStart(), field.getSelectionEnd());
			status.setText("Text Cut..");
		}
	}
	
	public void copyText(JTextPane field, JLabel status){
		if(field.getSelectedText() != null){
			String selectedText = field.getSelectedText();
			StringSelection clipString = new StringSelection(selectedText);
			clip.setContents(clipString,clipString);
			status.setText("Text Copied..");
		}
	}
	
	public void pasteText(JTextPane field, JLabel status){
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
/////////////////////////////////////////////////////////////////////////////////////////
	
///////////////////////////////bold italic underline/////////////////////////////////////	
	
	
	public void boldText(JTextPane field, JLabel status, Font defaultFont) throws BadLocationException{
		if(field.getSelectedText() != null){	
	
			//Document doc = field.getStyleDocument();

			String str = field.getSelectedText();
			int start = EditorFrame.field.getSelectionStart();
			int end = EditorFrame.field.getSelectionEnd();
			
			StyleContext sc = new StyleContext();
			Style style = sc.addStyle("yourStyle", null);

			Font font = new Font("Arial", Font.BOLD, 18);

		//	StyleConstants.setForeground(style, Color.RED);
			StyleConstants.setFontFamily(style, font.getFamily());
			StyleConstants.setBold(style, true);

			field.getStyledDocument().insertString(end - str.length(), str, style);
			//this.getTextPane().getStyledDocument().insertString(selectionEnd - text.length(), text, style);
			
			//StyledEditorKit.BoldAction;
			//	EditorFrame.fontName = Font.BOLD;
	//		defaultFont = new Font(EditorFrame.fontStyle, EditorFrame.fontName, EditorFrame.fontSize);
			
			/*int start = EditorFrame.field.getSelectionStart();
			int end = EditorFrame.field.getSelectionEnd();
			
			field.replaceSelection(field.getSelectedText(),start,end);
			*/
			
			EditorFrame.field.setFont(defaultFont);
			
/*			field.addCaretListener(new CaretListener() {
			
			@Override
			public void caretUpdate(CaretEvent event) {
				int dot = event.getDot();
	            int mark = event.getMark();
	            if (dot != mark) {
	                if (dot < mark) {
	                    int temp = dot;
	                    dot = mark;
	                    mark = temp;
	                }
	                boldSelectedText(mark, dot);
	            }// TODO Auto-generated method stub
				
			}

			private void boldSelectedText(int mark, int dot) {
				try {
	                int length = dot - mark;
	                String s = EditorFrame.field.getText(mark, length);
	                EditorFrame.styledDocument.remove(mark, length);
	                EditorFrame.styledDocument.insertString(mark, s,
	                        EditorFrame.styledDocument.getStyle("bold"));
	            } catch (BadLocationException e) {
	                e.printStackTrace();
	            }
				
			}
		});*/
			status.setText("Bold..");
		}
	}
	
	public void italicText(JTextPane field, JLabel status, Font defaultFont){
		EditorFrame.fontName = Font.ITALIC;
		defaultFont = new Font(EditorFrame.fontStyle, EditorFrame.fontName, EditorFrame.fontSize);
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
	
/////////////////////////////////////////////////////////////////////////////////////////	
/////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////JCombobox text Size and Text Style START///////////////////////////////////////////////////////////////////////////////////////////
	
	public void addTextSize(JComboBox textSize, JTextPane field, Font defaultFont, JLabel status){
	EditorFrame.fontSize = (int) textSize.getSelectedItem();
		defaultFont = new Font(EditorFrame.fontStyle, EditorFrame.fontName, EditorFrame.fontSize);
		field.setFont(defaultFont);
		status.setText("Text Size.." + EditorFrame.fontSize);
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////
	
	public void addTextStyle(JComboBox textStyle, JTextPane field, Font defaultFont,  JLabel status){
		EditorFrame.fontStyle = (String) textStyle.getSelectedItem();
		defaultFont = new Font(EditorFrame.fontStyle, EditorFrame.fontName, EditorFrame.fontSize);
		field.setFont(defaultFont);
		status.setText("Text Size.." + EditorFrame.fontStyle);
	}
	
	
//////////////////////////////JCombobox text Size and Text Style END//////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
}//////////////////////////////////////////////////////////Class End//////////////////////////////////////////////////////////////////////////
