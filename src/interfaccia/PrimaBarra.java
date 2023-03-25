package interfaccia;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class PrimaBarra extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel numeroLatiJLabel;
	private JSpinner numeroLatiJSpinner;
	private JButton creaLatiButton;
	private CreaBarraLati barraLati;
		

	public PrimaBarra() {
		
		setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));
		
		numeroLatiJLabel= new JLabel("Numero lati conosciuti: ");
		numeroLatiJLabel.setFont(new Font(numeroLatiJLabel.getFont().getName(), numeroLatiJLabel.getFont().getStyle(), 20));
		
		numeroLatiJSpinner= new JSpinner();
		SpinnerNumberModel modelloModel= new SpinnerNumberModel(2,2,9,1);
		numeroLatiJSpinner.setModel(modelloModel);
		numeroLatiJSpinner.setFont(new Font(numeroLatiJLabel.getFont().getName(), numeroLatiJLabel.getFont().getStyle(), 20));
		
		creaLatiButton= new JButton("Crea");
		creaLatiButton.setFont(new Font(numeroLatiJLabel.getFont().getName(), numeroLatiJLabel.getFont().getStyle(), 17));
		creaLatiButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (barraLati!=null) {
					int numeroLati=(int) numeroLatiJSpinner.getValue();
					barraLati.creaBarraLati(numeroLati);
				}
			}
		});
		
		add(numeroLatiJLabel);
		add(numeroLatiJSpinner);
		add(creaLatiButton);
	}
	
	
    public void setCreaBarraLati(CreaBarraLati barraLati) {
		this.barraLati=barraLati;
	}

}
