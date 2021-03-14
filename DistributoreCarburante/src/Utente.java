import java.io.IOException;
//Classe Utente che implementa le operazioni di assegnazione dei punti fedeltà
public class Utente {
	
	private double codiceUtente;
	private int quantitaPunti;
	GestioneFile op = new GestioneFile();
	
	public Utente(double cUtente,int quantita)
	{
		this.quantitaPunti = quantita;
		this.codiceUtente = cUtente;
		
	}
	//Vado a scrivere nel file i punti guadagnati dall'ultimo cliente che ha utilizzato la pompa
	public void stampaPunti()
	{
		
		try {
			op.ScritturaDati("C:\\Users\\R3200G\\Desktop\\ListaPunti.txt",Integer.toString(quantitaPunti));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			op.ScritturaDati("C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt",Double.toString(codiceUtente));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getPunti()
	{
		return quantitaPunti;
	}

	public double getCodiceUtente() {
		return codiceUtente;
	}

	public void setCodiceUtente(int codiceUtente) {
		this.codiceUtente = codiceUtente;
		
	}


}
