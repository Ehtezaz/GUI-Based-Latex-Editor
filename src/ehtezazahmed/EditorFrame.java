package ehtezazahmed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.BoxLayout;
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
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

import com.sun.javafx.css.Style;

public class EditorFrame extends JFrame{
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		EditorFrame f1 = new EditorFrame();
		f1.setTitle("GUI Based Latex Editor");
		f1.setIconImage(new ImageIcon("Icon/title.png").getImage());
		f1.setSize(800,600);
		f1.setMinimumSize(new Dimension(500,600));
		f1.setLocationRelativeTo(null);
		f1.setVisible(true);
//		f1.pack();
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	JPanel mainPanel;
	JPanel subPanel;
	JPanel subSubPanel;
	JPanel sourcePanel;
	
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
		
	ExtendedButton newFileButton;
	ExtendedButton openFileButton;
	ExtendedButton saveFileButton;
	ExtendedButton saveAsFileButton;
	ExtendedButton generatePDFFileButton;
	
	ExtendedButton undoButton;
	ExtendedButton redoButton;
	
	ExtendedButton cutTextButton;
	ExtendedButton copyTextButton;
	ExtendedButton pasteTextButton;
	
	ExtendedButton boldButton;
	ExtendedButton italicButton;
	ExtendedButton underlineButton;
	
	ExtendedButton sectionButton;
	ExtendedButton subSectionButton;
	ExtendedButton paragraphButton;
	
	
	private JToolBar toolBar2;
	
	private JComboBox textSize;
	private JComboBox textStyle;
	
	ExtendedButton spellCheckButton;
	ExtendedButton grammarCheckButton;
	
	private JTextArea sourceArea;
	private JScrollPane sourceScroller;
	
	
	public static JTextPane field;
	private JScrollPane scroller;
		
	public Font defaultFont;
	
	public static String fontStyle;
	public static int fontName;
	public static int fontSize;
	
	public static JLabel status;
	
	static StyledDocument styledDocument;
	
//////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////CONSTRUCTOR STARTS////////////////////////////////////	
	
	public EditorFrame(){
		
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	add(mainPanel);
	
	EditorFrame.styledDocument = new DefaultStyledDocument();
	
    //addStylesToDocument(styledDocument);
	//mainPanel.setBackground(Color.BLUE);
	
    
	createMenu();
	
	subPanel = new JPanel();
	mainPanel.add(subPanel, BorderLayout.CENTER);
	subPanel.setLayout(new BorderLayout());
	//subPanel.setBackground(Color.GREEN);
	
	createToolBar1();

	subSubPanel = new JPanel();
	//subSubPanel.setBackground(Color.BLUE);
	subPanel.add(subSubPanel, BorderLayout.CENTER);

	sourceArea = new JTextArea();
	sourceArea.setLineWrap(true);
	sourceArea.setWrapStyleWord(true);
	sourceArea.setBackground(Color.DARK_GRAY);
	sourceArea.setForeground(Color.WHITE);
	sourceArea.setEditable(false);
	
	sourceScroller = new JScrollPane(sourceArea);
	sourceScroller.setPreferredSize(new Dimension(250,150));
	
	sourcePanel = new JPanel();
	sourcePanel.setLayout(new BorderLayout());
	sourcePanel.setBackground(Color.GRAY);
	
	subPanel.add(sourcePanel, BorderLayout.SOUTH);
	sourcePanel.add(sourceScroller,BorderLayout.CENTER);
	
	createToolBar2();
	
	/*JLabel label = new JLabel( new ImageIcon("Icon/banner.png"));
	subSubPanel.add(label,BorderLayout.CENTER);
	*/
	
	field = new JTextPane(styledDocument);
	//field.setLineWrap(true);
	//field.setWrapStyleWord(true);
	
	defaultFont = new Font("Arial", Font.PLAIN, 12);
	field.setFont(defaultFont);
	
	scroller = new JScrollPane(field);
	subSubPanel.add(scroller, BorderLayout.CENTER);
	
	status = new JLabel("GUI BASED LATEX EDITOR..");
	mainPanel.add(status, BorderLayout.SOUTH);//mainPanel south
	
	createActionListener();
	
	}////////////////////////////////////////CONSTRUCTOR END////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

	/*public void addStylesToDocument(StyledDocument styledDocument) {
        Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
        Style s = styledDocument.addStyle("bold", def);
        StyleConstants.setBold(s, true);
    }*/
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////

		public void createMenu() {////////////MENU BAR STARTS///////////////////////////////////////
		
			
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
			
			mainPanel.add(menuBar, BorderLayout.NORTH);	
	}/////////////////////////////////////MENU BAR END/////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		public void createToolBar1() {///////////////////TOOLBAR1 STARTS///////////////////////////////////////
			
			
			toolBar1 = new JToolBar();
			subPanel.add(toolBar1, BorderLayout.NORTH);
			
			newFileButton = new ExtendedButton("New Document");
			newFileButton.setIcon(new ImageIcon("Icon/new.png"));
			openFileButton = new ExtendedButton("Open File");
			openFileButton.setIcon(new ImageIcon("Icon/file-open.png"));
			saveFileButton = new ExtendedButton("Save File");
			saveFileButton.setIcon(new ImageIcon("Icon/save.png"));
			saveAsFileButton = new ExtendedButton("Save As");
			saveAsFileButton.setIcon(new ImageIcon("Icon/save.png"));
			generatePDFFileButton = new ExtendedButton("Generate PDF");
			generatePDFFileButton.setIcon(new ImageIcon("Icon/pdf.png"));
				
			toolBar1.add(newFileButton);
			toolBar1.add(openFileButton);
			toolBar1.add(saveFileButton);
			toolBar1.add(saveAsFileButton);
			toolBar1.add(generatePDFFileButton);
			
			toolBar1.addSeparator();
		
			cutTextButton = new ExtendedButton("Cut Button");
			cutTextButton.setIcon(new ImageIcon("Icon/cut.png"));
			copyTextButton = new ExtendedButton("Copy Button");
			copyTextButton.setIcon(new ImageIcon("Icon/copy.png"));
			pasteTextButton = new ExtendedButton("Paste Button");
			pasteTextButton.setIcon(new ImageIcon("Icon/paste.png"));
			
			toolBar1.add(cutTextButton);
			toolBar1.add(copyTextButton);
			toolBar1.add(pasteTextButton);
			
			toolBar1.addSeparator();
			
			boldButton = new ExtendedButton("Bold Button");
			boldButton.setIcon(new ImageIcon("Icon/bold.png"));
			italicButton = new ExtendedButton("Italic Button");
			italicButton.setIcon(new ImageIcon("Icon/italic.png"));
			underlineButton = new ExtendedButton("Underline Button");
			underlineButton.setIcon(new ImageIcon("Icon/underline.png"));
			
			toolBar1.add(boldButton);
			toolBar1.add(italicButton);
			toolBar1.add(underlineButton);
			
			toolBar1.setFloatable(false);
				
		}/////////////////////////////////////TOOLBAR1 ENDS/////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		public void createToolBar2() {////////////TOOLBAR2 STARTS///////////////////////////////////////

			BorderLayout brdl = new BorderLayout();	
			subSubPanel.setLayout(brdl);

			toolBar2 = new JToolBar();
			subSubPanel.add(toolBar2, BorderLayout.NORTH);

			String size[] = { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24"};
			textSize = new JComboBox(size);
			textSize.setMaximumSize( textSize.getPreferredSize() ); 
			toolBar2.add(textSize);

			toolBar2.addSeparator();

			String style[] = { "Arial", "Calibri", "Times New Roman", "Serif", "San-Sarif"};
			textStyle = new JComboBox(style);
			textStyle.setMaximumSize( textStyle.getPreferredSize() );
			toolBar2.add(textStyle);
			toolBar2.addSeparator();

			sectionButton = new ExtendedButton("Section Button");
			sectionButton.setIcon(new ImageIcon("Icon/section.png"));
			subSectionButton = new ExtendedButton("Subsection Button");
			subSectionButton.setIcon(new ImageIcon("Icon/subsection.png"));
			paragraphButton = new ExtendedButton("Paragraph Button");
			paragraphButton.setIcon(new ImageIcon("Icon/paragraph.png"));

			spellCheckButton = new ExtendedButton("Spell Check Button");
			spellCheckButton.setIcon(new ImageIcon("Icon/spellcheck.png"));
			grammarCheckButton = new ExtendedButton("Grammar Check Button");
			grammarCheckButton.setIcon(new ImageIcon("Icon/grammar.png"));


			toolBar2.add(sectionButton);
			toolBar2.add(subSectionButton);
			toolBar2.add(paragraphButton);
			toolBar2.addSeparator();
			toolBar2.add(spellCheckButton);
			toolBar2.add(grammarCheckButton);

			toolBar2.setFloatable(false);

		}///////////////////////////////////////TOOLBAR2 END////////////////////////////////////////////	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		public void createActionListener() {///ACTION LISTENER START//////////////////////////////////
		
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
			
			generatePDFFileButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//doc.generatePDF();
					doc.createTEX(sourceArea, status);
				}
			});
			
	/////////////////////////////File Ends///////////////////////////////////////
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			
			field.addKeyListener(new KeyListener() {
				
				@Override
				public void keyTyped(KeyEvent e) {
					// TODO Auto-generated method stub
					String str = field.getText();
					sourceArea.setText(str);
				}
				
				@Override
				public void keyReleased(KeyEvent e) {
					// TODO Auto-generated method stub
					String str = field.getText();
					sourceArea.setText(str);
					
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					// TODO Auto-generated method stub
					
					
				}
			});
			
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
	////////////////////////////EDIT MENU CUT COPY PASTE 'Start'//////////////////////////////////////
			Text text = new Text();
			
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
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////bOLD iTALIC uNDERLINE stART//////////////////////////////////////		

			boldButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//int start = field.getSelectionStart();
					//int end = field.getSelectionEnd();
					
					
					//field.setFont(new Font(fontStyle, Font.BOLD, 12));
					try {
						text.boldText(EditorFrame.field, status, defaultFont);
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			
			//boldButton.addActionListener(new StyledEditorKit.BoldAction());
			
			
			/*italicButton.addActionListener(new ActionListener() {
		
				@Override
				public void actionPerformed(ActionEvent e) {
					//field.setFont(new Font(fontStyle, Font.ITALIC, 12));
					text.italicText(field, status, defaultFont);
				}
			});*/
			italicButton.addActionListener(new StyledEditorKit.ItalicAction());
			
			/*
			underlineButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//text.underlineText(field, status);
				}
			});*/
			
			underlineButton.addActionListener(new StyledEditorKit.UnderlineAction());
			
	////////////////////////////bOLD iTALIC uNDERLINE ENDs//////////////////////////////////////		
			
			
			
/////////////////////////////////////COMBOBOX TEXT STYLE AND SIZE START//////////////////////////////////////////////////////////////////////
			
			textStyle.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					text.addTextStyle(textStyle, field, defaultFont, status);
				}
			});
			
			textSize.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					text.addTextSize(textSize, field, defaultFont, status);
				}
			});
			
/////////////////////////////////////COMBOBOX TEXT STYLE AND SIZE END/////////////////////////////////////////////
			
			
/////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////HELP MENU Start/////////////////////////////////////////////////////////////////
			
			helpJMenuItem.addActionListener(new ActionListener() {
				
			@Override 
				public void actionPerformed(ActionEvent arg0) {
						JTextArea textArea;
						
						textArea = new JTextArea("GUI Based Editor Help for Short Perid of time..\n"
								+ "\n \\documentclass{article}"
								+ "\n \\begin{document}"
								+ "\n Hello World"
								+ "\n \\textbf{Bold}"
								+ "\n \\textit{Italic}"
								+ "\n \\underline{Underline}"
								+ "\n FONT SIZE"
								+ "\n FONT STYLE"
								+ "\n \\"
								+ "\n \\"
								+ "\n \\section{''section''}	"
								+ "\n \\subsection{''subsection''}"
								+ "\n \\paragraph{''paragraph''}"
								+ "\n \\end{document}"
								);
						textArea.setLineWrap(true);
						textArea.setWrapStyleWord(true);
						textArea.setEditable(false);
						JScrollPane sc = new JScrollPane(textArea);
						
						JFrame frame = new JFrame();
						frame.setTitle("GUI Based Latex Editor Help..");
						frame.add(sc, BorderLayout.CENTER);
						frame.setIconImage(null);
						frame.setSize(400,300);
						frame.setMinimumSize(new Dimension(300,200));
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
					}
			});
			
			about.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
						JTextArea textArea;
						textArea = new JTextArea("EZ's Text Editor for Short Perid of time.. ");
						textArea.setWrapStyleWord(true);
						textArea.setLineWrap(true);
						textArea.setEditable(false);
							
						JFrame frame = new JFrame();
						frame.setTitle("GUI Based Latex Editor About..");
						frame.add(textArea, BorderLayout.CENTER);
						frame.setIconImage(null);
						frame.setSize(300,200);
						frame.setMinimumSize(new Dimension(300,200));
						frame.setLocationRelativeTo(null);
						frame.setVisible(true);
				}
			});
////////////////////////////////////HELP MENU ENDS/////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////
			
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
			
	}////////////////////////////////////////ACTION LISTENER END/////////////////////////////////////

		
}/////////////////////////////////////////EDITORFRAME CLASS ENDs/////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////