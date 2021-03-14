import java.io.IOException;
//In questa classe vengono effettuati tutti i controlli relativi alla quantita di carburante che
//è all'interno dei distributori
public class ControlloQuantitaDistributore {
	
	private float quantitaDiesel;
	private float quantitaHiDiesel;
	private float quantitaSenzaPiombo;
	private float quantitaSuper;
	private float quantitaMetano;
	private float quantitaGpl;
	private boolean errore;
	private GestioneFile warning = new GestioneFile();
	//Anche qui, c'è la gestione dei file, in modo tale da inserire all'interno dei file, il quantitativo di carburante aggiunto
	public ControlloQuantitaDistributore()
	{
		try {
			quantitaDiesel = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreDiesel.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			quantitaHiDiesel = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreHiDiesel.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			quantitaSenzaPiombo = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSenzaPiombo.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			quantitaSuper = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSuper.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			quantitaMetano = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreMetano.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			quantitaGpl = Float.parseFloat(warning.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreGpl.txt"));
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void checkFornitura()
	{
		if(quantitaDiesel < 10)
		{
			
			System.out.println("Il distributore del Diesel ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		if(quantitaHiDiesel < 10)
		{
			
			System.out.println("Il distributore del dieselHi ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		
		if(quantitaSenzaPiombo < 10)
		{
			
			System.out.println("Il distributore del SenzaPiombo ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		
		if(quantitaSuper < 10)
		{
			
			System.out.println("Il distributore del Super ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		
		if(quantitaMetano < 10)
		{
			
			System.out.println("Il distributore del Metano ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		
		if(quantitaGpl < 10)
		{
			
			System.out.println("Il distributore del Gpl ha una quantita di carburante inferiore a 10. Chiedere fornitura..");
			errore = true;
		}
		
		
	}
	
	public void rifornisciDistributore()
	{
		if(errore == true)
		{
			
			if(quantitaHiDiesel < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreHiDiesel.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(quantitaDiesel < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreDiesel.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if(quantitaSenzaPiombo < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSenzaPiombo.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(quantitaSuper < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSuper.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(quantitaMetano < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreMetano.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(quantitaGpl < 10)
			{
				try {
					warning.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreGpl.txt","10000");
				} catch (IOException e) {
					e.printStackTrace();
				}
				

			}
			System.out.println("Rifornimento avvenuto con successo");
		}
		
		else
		{
			System.out.println("Tutti i distributori hanno una quantita di carburante maggiore di 10.");
		}
	}
	
	public boolean getErrore()
	{
		return errore;
	}
	
	

}
