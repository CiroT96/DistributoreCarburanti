//Classe Facade, che gestisce i vari accessi(Amministratore/Utente) mediante l'implementazione del Pattern Facade

public class Facade {
	
	
	private Accesso login;
	private Accesso codice;
	
	public Facade(boolean d,int q) {
		login = new CodiceCarta(d,q);
		codice = new CodiceAmministratore();
	}
	


	

	
	public void codAmm(int cod)
	{
		login.inserisciCodice(cod);
	}
	
	public void codCarta(int cod)
	{
		codice.inserisciCodice(cod);
	}
	
}
