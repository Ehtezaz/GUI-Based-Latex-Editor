package ehtezazahmed;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class ExtendedButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExtendedButton(String text){
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				EditorFrame.status.setText(" ");
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				EditorFrame.status.setText(text);
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});	
	}
}
