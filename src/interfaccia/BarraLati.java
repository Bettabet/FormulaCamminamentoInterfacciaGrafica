package interfaccia;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarraLati extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel latiJLabel;
	private JLabel angoliJLabel;
	private JTextField[] latiConosciutiFields;
	private JTextField[] angoliConosciutiFields;
	private JButton calcolaAreaButton;
	private LatiAngoliListener latiAngoliListener;
	
	
	public BarraLati(int numeroLati) {
		
		setLayout(new GridBagLayout());
		
		latiJLabel= new JLabel("Inserire tutti i lati in ordine: ");
		angoliJLabel= new JLabel("Inserire tutti gli angoli in ordine: ");
		latiJLabel.setFont(new Font(latiJLabel.getFont().getName(), latiJLabel.getFont().getStyle(), 20));
		angoliJLabel.setFont(new Font(angoliJLabel.getFont().getName(), angoliJLabel.getFont().getStyle(), 20));
		add(latiJLabel);
		
		
		GridBagConstraints gbc= new GridBagConstraints();
		
		latiConosciutiFields= new JTextField[numeroLati];
		for (int i=0; i<numeroLati; i++) { 
			latiConosciutiFields[i]= new JTextField(5);
			latiConosciutiFields[i].setFont(new Font(latiConosciutiFields[i].getFont().getName(), latiConosciutiFields[i].getFont().getStyle(), 20));
		}
		
		angoliConosciutiFields= new JTextField[numeroLati-1];
		for (int i=0; i<numeroLati-1; i++) { 
			angoliConosciutiFields[i]= new JTextField(5);
			angoliConosciutiFields[i].setFont(new Font(angoliConosciutiFields[i].getFont().getName(), angoliConosciutiFields[i].getFont().getStyle(), 20));
		}
		
		gbc.anchor=GridBagConstraints.FIRST_LINE_START;
		gbc.insets= new Insets(30, 10, 0, 10);
		add(latiJLabel,gbc);
		
		  for (int i=0; i<numeroLati; i++) { 
			  gbc.gridx=i+1; 
			  //gbc.gridy=0; 
			  gbc.weightx=0.01; 
			  gbc.weighty=0.01;
			  add(latiConosciutiFields[i], gbc);
			  }
		  
		  gbc.gridx=0;
		  gbc.gridy=1;
		  add(angoliJLabel,gbc);
		  
		  for (int i=0; i<numeroLati-1; i++) { 
			  gbc.gridx=i+1; 
			  //gbc.gridy=0; 
			  gbc.weightx=0.01; 
			  gbc.weighty=0.01;
			  add(angoliConosciutiFields[i], gbc);
			  }
		  
		  calcolaAreaButton= new JButton("Calcola Area");
		  calcolaAreaButton.setFont(new Font(calcolaAreaButton.getFont().getName(), calcolaAreaButton.getFont().getStyle(), 20));
		  
		  gbc.gridx=0;
		  gbc.gridy=2;
		  gbc.weightx=10;
		  gbc.weighty=10;
		  gbc.fill=GridBagConstraints.HORIZONTAL;
		  add(calcolaAreaButton, gbc);
		  
		  calcolaAreaButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (latiAngoliListener!=null) {
					double[] lati= new double[numeroLati];
					double[] angoli= new double[numeroLati-1];
					try {
						for (int i=0; i<numeroLati; i++) {
							lati[i]= Double.valueOf(latiConosciutiFields[i].getText());
						}
						for (int i=0; i<numeroLati-1; i++) {
							angoli[i]= Double.valueOf(angoliConosciutiFields[i].getText());
						}
					}
					catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(BarraLati.super.getParent(), "Input non corretto!", "Errore", JOptionPane.ERROR_MESSAGE);
						return ;
					}
					
					latiAngoliListener.calcolaArea(lati, angoli);
					
				}
				
			}
		});
		  
	}
	
	public void setLatiAngoliListener(LatiAngoliListener latiAngoliListener) {
		this.latiAngoliListener=latiAngoliListener;
	}
	
}
