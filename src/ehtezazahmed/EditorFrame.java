package ehtezazahmed;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class EditorFrame extends JFrame{

	public static void main(String[] args) {
		EditorFrame f1 = new EditorFrame();
		f1.setTitle("GUI Based Latex Editor");
		f1.setIconImage(new ImageIcon("Icon/title.png").getImage());
		f1.setSize(600,600);
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
//		f1.pack();
	}
	
	JPanel mainPanel;
	JPanel subPanel;
	JPanel subSubPanel;
	
	JMenuBar menuBar;
	
	JMenu file;
	JMenuItem newFile;
	JMenuItem openFile;
	JMenuItem saveFile;
	JMenuItem saveAsFile;
	JMenuItem exitFile;
	
	JMenu edit;
	JMenuItem undo;
	JMenuItem redo;
	JMenuItem cutText;
	JMenuItem copyText;
	JMenuItem pasteText;

	JMenu view;
	JMenuItem toolbars;
	
	JMenu insert;
	JMenuItem section;
	JMenuItem subSection;
	JMenuItem paragraph;
	
	JMenu document;
	JMenuItem generatePDF;
	
	JMenu tools;
	JMenuItem spellCheck;
	JMenuItem grammarCheck;
	
	JMenu help;
	JMenuItem about;
	JMenuItem helpJMenuItem;
	
	
	JToolBar toolBar1;
	
	
	JButton newFileButton;
	JButton openFileButton;
	JButton saveFileButton;
	JButton saveAsFileButton;
	JButton generatePDFFileButton;
	
	JButton undoButton;
	JButton redoButton;
	
	JButton cutTextButton;
	JButton copyTextButton;
	JButton pasteTextButton;
	
	JButton boldButton;
	JButton italicButton;
	JButton underlineButton;
	
	JButton sectionButton;
	JButton subSetionButton;
	JButton paragraphButton;
	
	
	JToolBar toolBar2;
	JComboBox textSize;
	JComboBox textStyle;
	
	JButton spellCheckButton;
	JButton grammarCheckButton;
	
	
	
	public JTextArea field;
	public JScrollPane scroller;
	
	public String fontStyle = "Arail";
	public int fontName = Font.PLAIN;
	public int fontSize = 14;	
	public Font defaultFont;
	
	public JLabel status;
	
//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////CONSTRUCTOR STARTS////////////////////////////////////	
	
	public EditorFrame(){
		
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	
	createMenu();
	
	subPanel = new JPanel();
	add(subPanel, BorderLayout.CENTER);
	subPanel.setLayout(new BorderLayout());
	
	createToolBar1();

	subSubPanel = new JPanel();
	subPanel.add(subSubPanel, BorderLayout.CENTER);

	createToolBar2();
	
	JLabel label = new JLabel( new ImageIcon("Icon/banner.png"));
	subSubPanel.add(label,BorderLayout.CENTER);
	
	/*defaultFont = new Font(fontStyle, fontName,  fontSize);
	field.setFont(defaultFont);
	*/
	field = new JTextArea();
	field.setLineWrap(true);
	field.setWrapStyleWord(true);
	
	scroller = new JScrollPane(field);
	subSubPanel.add(scroller, BorderLayout.CENTER);
	
	status = new JLabel("GUI BASED LATEX EDITOR..");
	add(status, BorderLayout.SOUTH);//mainPanel south
	//////////////////////////////////////////MAIN PANEL END////////////////////////////////////////	
  
	createActionListener();
	
	}////////////////////////////////////////CONSTRUCTOR END/////////////////////////////////////////

	
	
	

//	public void setFieldText(String str){
//		field.setText(str);
//	}
//	
//	public String getFieldText(){
//		return field.getText().toString();
//	}
	
	
	
	public void createActionListener() {
	////////////////////////////////////////ACTION LISTENER START///////////////////////////////////	
	
////////////////////////////////////File Menu Start////////////////////////////////////////		
		Document doc = new Document();	 
		
		newFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.newDocument(subSubPanel, status, EditorFrame.this, field);	
			}
		});
	
		openFile.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.openDocument(status, EditorFrame.this, field);
			}
		});
		
		
		saveFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.saveDocument(status, EditorFrame.this, field);
			}
		});
		
		
		saveAsFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.saveAsDocument(status, EditorFrame.this, field);
			}
		});
		
		
		exitFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				doc.exitDocument(status, EditorFrame.this, field);
			}
		});
		
		//////////////////////////////////////////////////////////////////////////
		
		newFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.newDocument(subSubPanel, status, EditorFrame.this, field);	
			}
		});
	
		openFileButton.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.openDocument(status, EditorFrame.this, field);
			}
		});
		
		
		saveFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.saveDocument(status, EditorFrame.this, field);
			}
		});
		
		
		saveAsFileButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				doc.saveAsDocument(status, EditorFrame.this, field);
			}
		});
		
		
		
/////////////////////////////File Ends///////////////////////////////////////

////////////////////////////EDIT MENU CUT COPY PASTE 'Start'//////////////////////////////////////
		Text text = new Text();
		
	/*	
		cutTextButton.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
			}
		});*/
		
		

		cutText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.cutText(field, status);
			}
		});
		
		copyText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.copyText(field, status);
			}
		});
		
		pasteText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.pasteText(field, status);
			}
		});
		
		
		
//////////////////////////////////////////////////////////////////////////////////
		
		cutTextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.cutText(field, status);
			}
		});
		
		copyTextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.copyText(field, status);
			}
		});
		
		pasteTextButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				text.pasteText(field, status);
			}
		});
		
		

////////////////////////////CUT COPY PASTE ends//////////////////////////////////////		

////////////////////////////bOLD iTALIC uNDERLINE stART//////////////////////////////////////		

		boldButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				text.boldText(field, status);
			}
		});
		
		
////////////////////////////bOLD iTALIC uNDERLINE stART//////////////////////////////////////		
		
		
		
		
	////////////////////////////////////////ACTION LISTENER END/////////////////////////////////////		
}


	public void createToolBar2() {
	/////////////////////////////////////TOOLBAR2 STARTS///////////////////////////////////////
		
		BorderLayout brdl = new BorderLayout();	
		subSubPanel.setLayout(brdl);
		
		toolBar2 = new JToolBar();
		subSubPanel.add(toolBar2, BorderLayout.NORTH);
		
		String size[] = { "8", "9", "10", "11", "12"};
		textSize = new JComboBox(size);
		toolBar2.add(textSize);
		
		toolBar2.addSeparator();
		
		String style[] = { "Arial", "Calibri", "Times New Roman", "Serif", "San-Sarif"};
		textStyle = new JComboBox(style);
		toolBar2.add(textStyle);
		toolBar2.addSeparator();
		
		spellCheckButton = new JButton();
		spellCheckButton.setIcon(new ImageIcon("Icon/spellcheck.png"));
		grammarCheckButton = new JButton();
		grammarCheckButton.setIcon(new ImageIcon("Icon/grammar.png"));
		
		toolBar2.add(spellCheckButton);
		toolBar2.add(grammarCheckButton);
		
		toolBar2.setFloatable(false);
	
	}///////////////////////////////////////TOOLBAR2 END////////////////////////////////////////////	



	public void createToolBar1() {
	////////////////////////////////////TOOLBAR1 STARTS///////////////////////////////////////	
		
		toolBar1 = new JToolBar();
		subPanel.add(toolBar1, BorderLayout.NORTH);
		
		newFileButton = new JButton();
		newFileButton.setIcon(new ImageIcon("Icon/new.png"));
		openFileButton = new JButton();
		openFileButton.setIcon(new ImageIcon("Icon/file-open.png"));
		saveFileButton = new JButton();
		saveFileButton.setIcon(new ImageIcon("Icon/save.png"));
		saveAsFileButton = new JButton();
		saveAsFileButton.setIcon(new ImageIcon("Icon/save.png"));
		generatePDFFileButton = new JButton();
		generatePDFFileButton.setIcon(new ImageIcon("Icon/pdf.png"));
			
		toolBar1.add(newFileButton);
		toolBar1.add(openFileButton);
		toolBar1.add(saveFileButton);
		toolBar1.add(saveAsFileButton);
		toolBar1.add(generatePDFFileButton);
		
		toolBar1.addSeparator();
	
		cutTextButton = new JButton();
		cutTextButton.setIcon(new ImageIcon("Icon/cut.png"));
		copyTextButton = new JButton();
		copyTextButton.setIcon(new ImageIcon("Icon/copy.png"));
		pasteTextButton = new JButton();
		pasteTextButton.setIcon(new ImageIcon("Icon/paste.png"));
		
		toolBar1.add(cutTextButton);
		toolBar1.add(copyTextButton);
		toolBar1.add(pasteTextButton);
		
		toolBar1.addSeparator();
		
		boldButton = new JButton();
		boldButton.setIcon(new ImageIcon("Icon/bold.png"));
		italicButton = new JButton();
		italicButton.setIcon(new ImageIcon("Icon/italic.png"));
		underlineButton = new JButton();
		underlineButton.setIcon(new ImageIcon("Icon/underline.png"));
		
		toolBar1.add(boldButton);
		toolBar1.add(italicButton);
		toolBar1.add(underlineButton);
		
		toolBar1.setFloatable(false);
		
	/////////////////////////////////////TOOLBAR1 ENDS/////////////////////////////////////////	
}


		public void createMenu() {
		////////////////////////////////////////MENU BAR STARTS///////////////////////////////////////
			
			menuBar = new JMenuBar();
			
			file = new JMenu("File");
			newFile = new JMenuItem("New");
			openFile = new JMenuItem("Open");
			saveFile = new JMenuItem("Save");
			saveAsFile = new JMenuItem("Save As");
			exitFile = new JMenuItem("Exit");
			
			file.add(newFile);
			file.addSeparator();
			file.add(openFile);
			file.addSeparator();
			file.add(saveFile);
			file.add(saveAsFile);
			file.addSeparator();
			file.add(exitFile);
			
			edit = new JMenu("Edit");
			undo = new JMenuItem("Undo");
			redo = new JMenuItem("Redo");
			cutText = new JMenuItem("Cut");
			copyText = new JMenuItem("Copy");
			pasteText = new JMenuItem("Paste");
		
			edit.add(undo);
			edit.add(redo);
			edit.addSeparator();
			edit.add(cutText);
			edit.add(copyText);
			edit.add(pasteText);
			
			view = new JMenu("View");
			toolbars = new JMenuItem("Toolbar");
			view.add(toolbars);
			
			insert = new JMenu("Insert");
			section = new JMenuItem("Section");
			subSection = new JMenuItem("Subsection");
			paragraph = new JMenuItem("Paragraph");
			insert.add(section);
			insert.add(subSection);
			insert.addSeparator();
			insert.add(paragraph);
			
			document = new JMenu("Document");
			generatePDF = new JMenuItem("Generate PDF");
			document.add(generatePDF);
			
			tools = new JMenu("Tool");
			spellCheck = new JMenuItem("Spell Check");
			grammarCheck = new JMenuItem("Grammar Check");
			tools.add(spellCheck);
			tools.add(grammarCheck);
			
			help = new JMenu("Help");
			helpJMenuItem = new JMenuItem("Help");
			about = new JMenuItem("About");
			help.add(helpJMenuItem);
			help.addSeparator();
			help.add(about);
			
			menuBar.add(file);
			menuBar.add(edit);
			menuBar.add(view);
			menuBar.add(insert);
			menuBar.add(document);
			menuBar.add(tools);
			menuBar.add(help);
			add(menuBar, BorderLayout.NORTH);
		
		/////////////////////////////////////MENU BAR END/////////////////////////////////////////
	}
	
}////////////////////////////////////////////////END/////////////////////////////////////////////