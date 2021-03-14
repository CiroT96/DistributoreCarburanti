 import java.io.IOException;
//Classe del Pattern Facade
public class CodiceCarta implements Accesso{
	//Si effettua l'override del metodo dell'interfaccia Accesso
	//Controlla che il codice inserito dal tastierino numerico corrisponda a quello nel file della codici Carte
	
	GestioneFile op1 = new GestioneFile();
	private int cQuantitaPrezzo;
	private boolean tipod;
	private int lettura;
	
	public CodiceCarta(boolean d, int q)//Conservo le informazioni utili al rifornimento
	{
		this.tipod = d;
		this.cQuantitaPrezzo = q;
	}
	
	@Override
	public void inserisciCodice(int c) {
		try {
			lettura = Integer.parseInt(op1.LetturaDati("C:\\\\Users\\\\R3200G\\\\Desktop\\\\CodiceCarta.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(lettura == c) {
			System.out.println("Codice inserito corretto. Pompa per il rifornimento pronta.");
			if(tipod == true)
			{
				try
				{
					DistributoreDieselBenzina window = new DistributoreDieselBenzina(cQuantitaPrezzo);
					window.open();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}else
			{
				try
				{
					DistributoreGplMetano window = new DistributoreGplMetano(cQuantitaPrezzo);
					window.open();
				}catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		}else
		{
			System.out.println("Codice inserito non corretto. Ri-Inseririsci il codice.");
		} 
	}

}
