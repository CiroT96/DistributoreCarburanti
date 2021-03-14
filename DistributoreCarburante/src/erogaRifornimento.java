//Classe che si occupa di starta il rifornimento, andando ad utilizzari l'implmentazione Pattern State
public class erogaRifornimento {
	
	private int quantita;
	private float PREZZO;
	private String tipoc;
	
	erogaRifornimento(int q,float p,String c)
	{
		this.quantita = q;
		this.PREZZO = p;
		this.tipoc = c;
	}
	
	public void effettuaRifornimento()
	{
				RifornimentoContext context = new RifornimentoContext();
				Stato rifStart = new iniziaRifornimento(quantita,PREZZO,tipoc);
				Stato rifStop = new terminaRifornimento();
				context.setStato(rifStart);
				context.faiRifornimento();
				context.setStato(rifStop);
				context.faiRifornimento();

	}

}
