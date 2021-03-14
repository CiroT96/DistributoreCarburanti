//Classe appartenente all'implemtazione del Pattern State
public class RifornimentoContext implements Stato {
	private Stato rifStato;
	//Qui avviene il cambio di stato del rifornimento
	public void setStato(Stato stato)
	{
		this.rifStato = stato;
	}
	
	public Stato getStato()
	{
		return this.rifStato;
	}
	
	public void faiRifornimento()
	{
		this.rifStato.faiRifornimento();
	}

	
	
	
}
