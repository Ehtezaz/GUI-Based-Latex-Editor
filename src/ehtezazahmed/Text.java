package ehtezazahmed;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

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
	
	public void boldText(JTextArea field, JLabel status, Font f){
	//	field.setFont(new Font(fontStyle, fontName, fontSize));
	}
	
	public void italicText(JTextArea field, JLabel status){
		
	}

	public void underlineText(JTextArea field, JLabel status){
		
	}
	
//////////////////////////////////////////////////////////////////////
	
	
}
