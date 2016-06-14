package ehtezazahmed;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * 
 * @author Ehtezaz Ahmed
 *
 */
public class Document extends JFrame {
	
	File currentFile;	 
	JFileChooser fileSelect;
////////////////////////////////////////////////////////////
	public Document() {
		fileSelect = new JFileChooser();
	}
////////////////////////////////////// NEW FILE /////////////////////////////////////////////////////////////////	
	
	public void newDocument(JPanel p,JLabel status,JFrame ef,JTextArea field) {
		if(JOptionPane.showConfirmDialog(null, "Are you sure to create new file..") == 0){
			
			field.setText(" ");
			ef.setTitle("EZ's Text Editor - " + "New Document");
			status.setText("New file created..");
			currentFile = null;
		}
	}

/////////////////////////////////////// OPEN FILE ////////////////////////////////////////////////////////////////	
	
public void openDocument( JLabel status,JFrame ef,JTextArea field) {
		if(JOptionPane.showConfirmDialog(null, "Are you sure to close current file..") == 0){
			
			int openResult = fileSelect.showOpenDialog(null);
			if(openResult == JFileChooser.APPROVE_OPTION){
				File file = fileSelect.getSelectedFile();
				onOpenFile(file, status, ef, field);
				status.setText("File Opened..");
			}	 
		}
	}
	 
//////////////////////////////////////// SAVE FILE ///////////////////////////////////////////////////////////////	

	public void saveDocument(JLabel status,JFrame ef,JTextArea field){
		
		if(currentFile == null){
			int saveResult = fileSelect.showSaveDialog(null);
			if(saveResult == JFileChooser.APPROVE_OPTION){
				 onSaveFile(fileSelect.getSelectedFile(), field.getText(), status, ef, field);
				 status.setText("File saved..");
			}
		}
		else{
			onSaveFile(currentFile, field.getText(), status, ef, field);
			status.setText("Current file saved..");
		}
	}

///////////////////////////////////////// SAVE AS FILE ///////////////////////////////////////////////////////////	
	
	public void saveAsDocument(JLabel status,JFrame ef,JTextArea field) 		 {
		
			int saveResult = fileSelect.showSaveDialog(null);
				onSaveFile(fileSelect.getSelectedFile(), field.getText(), status, ef, field); 
				 status.setText("File saved..");
	}

///////////////////////////////////////// EXIT FILE /////////////////////////////////////////////////////////////

	public void exitDocument(JLabel status,JFrame ef,JTextArea field) {
		System.exit(0);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////onOpenFile///////////////////////////////////////////////////////////////////

	public void onOpenFile(File file, JLabel status,JFrame ef,JTextArea field){
		//outer if-else starts..		
		if(file.canRead()){
			String filePath = file.getPath();
			String fileContents = "";
			// inner if-else starts		
			if(filePath.endsWith(".txt")){
				try {
					Scanner sc = new Scanner( new FileInputStream(file));
					while(sc.hasNextLine()){
						fileContents += sc.nextLine();
					}
					sc.close();
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(null, "Exception: "+ e);
				}

				field.setText(fileContents);
				ef.setTitle("EZ's Text Editor" + filePath);
				status.setText("File Opened..");
			} else{
				JOptionPane.showMessageDialog(null, "File Type is not suppoerted..\nOnly .txt file type is supported");
			} 
			// inner if-else ends		
		}
		else{
			JOptionPane.showMessageDialog(null, "Could not open File..");
		}
		// outer if-else ends
		
	}
	
////////////////////////////////////////onSaveFile///////////////////////////////////////////////////////////////	
	
	public void onSaveFile(File file, String contents, JLabel status,JFrame ef,JTextArea field) {
		BufferedWriter writer = null;
		String filePath = file.getPath();
		if(!filePath.endsWith(".txt")){
			filePath += ".txt";
		}
		
		try{
			writer = new BufferedWriter(new FileWriter(filePath));
			writer.write(contents);
			writer.close();
			field.setText(contents);
			ef.setTitle("EZ's Text Editor - " + filePath);
			currentFile = file;
			status.setText("Document Saved..");
		}
		
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Exception: "+ e);
		}
	}	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void newEditor(){
		EditorFrame f1 = new EditorFrame();
		f1.setTitle("GUI Based Latex Editor");
		f1.setIconImage(new ImageIcon("Icon/title.png").getImage());
		f1.setSize(600,600);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
	}	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
}
