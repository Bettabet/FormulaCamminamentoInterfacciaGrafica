package interfaccia;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import formulaCamminamento.Camminamento;

public class FrameCamminamento extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private PrimaBarra primaBarra;
	
	private BarraLati barraLati;
	
	private JLabel areaJLabel;
	
	public FrameCamminamento() {
		
		super("Formula di Camminamento");
		
        BorderLayout layout= new BorderLayout();
        
		setLayout(layout);
		
		primaBarra= new PrimaBarra();
		
		add(primaBarra, BorderLayout.PAGE_START);
		
		primaBarra.setCreaBarraLati(new CreaBarraLati() {
			@Override
			public void creaBarraLati(int lati) {
				if (barraLati!=null) {
					FrameCamminamento.this.remove(barraLati);
					if (areaJLabel!=null) {
						FrameCamminamento.this.remove(areaJLabel);
					}
					FrameCamminamento.this.pack();
				}
				barraLati= new BarraLati(lati);
				add(barraLati, BorderLayout.LINE_START);
				FrameCamminamento.this.pack();
				setSize(1700,900);
				barraLati.setLatiAngoliListener(new LatiAngoliListener() {
					@Override
					public void calcolaArea(double[] lati, double[] angoli) {
						if (areaJLabel!=null) {
							FrameCamminamento.this.remove(areaJLabel);
							FrameCamminamento.this.pack();
						}
						Camminamento camminamento= new Camminamento(lati, angoli);
						double area= camminamento.calcoloArea();
						areaJLabel= new JLabel("L'area della figura e': " + area);
						areaJLabel.setFont(new Font(areaJLabel.getFont().getName(), areaJLabel.getFont().getStyle(), 40));
						add(areaJLabel, BorderLayout.PAGE_END);
						FrameCamminamento.this.pack();
						setSize(1700,900);
					}
				});
			}
		});
		
        setSize(1700,900);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
