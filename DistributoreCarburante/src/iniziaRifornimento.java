//Classe che implemeta il Pattern State, andando ad effettuare l'override del metodo nell'interfaccia Stato
//calcolando tutti le informazioni relative al rifornimento
public class iniziaRifornimento implements Stato 
{

	private float qRif;
	private int costo;
	private float PREZZO;
	private String tipoc;
	
	public iniziaRifornimento() {};
	
	public iniziaRifornimento(int q,float p,String c)
	{
		qRif = 0.0F;
		this.costo = q;
		this.PREZZO = p;
		this.tipoc = c;
	}
	
	@Override
	public void faiRifornimento() 
	{
		System.out.println("RIFORNIMENTO IN CORSO...");
		System.out.println("Calcolo il valore del rifornimento con i dati inseriti sottostanti: ");
		System.out.println("Prezzo del carburante " + tipoc + " ad oggi " + PREZZO + " Euro/Litro");
		System.out.println("Valore da rifornire " + costo + " Euro");
		
		qRif = costo / PREZZO;
		
		System.out.println("Quantita rifornita: " + qRif + " Litri");
	}
}
