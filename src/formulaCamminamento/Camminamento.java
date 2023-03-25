package formulaCamminamento;

public class Camminamento {
	
	private double[] latiConosciuti;
	private double[] angoliConosciuti;
	
	public Camminamento(double[] latiConosciuti, double[] angoliConosciuti) {
		this.latiConosciuti=latiConosciuti;
		this.angoliConosciuti=angoliConosciuti;
	}
	
	public double calcoloArea() {
		double area=0;
		double sumAngoli=0;
		for (int j=0; j<=latiConosciuti.length-2; j++) {
			for (int i=j+1; i<=latiConosciuti.length-1; i++) {
				for (int h=j; h<=i-1; h++) {
					 sumAngoli+=angoliConosciuti[h];
				}
				area+= Math.pow(-1, j+i+1) * latiConosciuti[j] * latiConosciuti[i] * Math.sin(Math.toRadians(sumAngoli));
				sumAngoli=0;
			}
		}
		area/=2;
		return area;
	}

}
