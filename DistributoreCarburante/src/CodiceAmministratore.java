import java.io.IOException;
//Classe del Pattern Facade
public class CodiceAmministratore implements Accesso {
	GestioneFile op1 = new GestioneFile();
	//Si effettua l'override del metodo dell'interfaccia Accesso
	//Controlla che il codice inserito dal tastierino numerico corrisponda a quello nel file della psw Amministratore
	@Override
	public void inserisciCodice(int c) {
		int lettura = 0;
		try {
			lettura = Integer.parseInt(op1.LetturaDati("C:\\\\Users\\\\R3200G\\\\Desktop\\\\PswAmministratore.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(lettura == c) {
			System.out.println("Codice inserito corretto. Accesso all'area amministratore consentita.");
			try
			{
				InterfacciaAmministratore window = new InterfacciaAmministratore();
				window.open();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else
		{
			System.out.println("Codice inserito non corretto. Accesso all'area amministratore non consentita");
		} 
		
		
	}

}
