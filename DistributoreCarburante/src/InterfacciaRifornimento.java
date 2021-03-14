import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//Interfaccia grafica che implementa le operazioni per il calcolo del valore da rifornire
public class InterfacciaRifornimento {

	protected Shell shlQuantitativoCarburante;
	private int cQuantitaEuro;
	private boolean tipod;
	private int cQuantitaPunti;
	
	public InterfacciaRifornimento(boolean t)
	{
		this.tipod=t;
	}


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlQuantitativoCarburante.open();
		shlQuantitativoCarburante.layout();
		while (!shlQuantitativoCarburante.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlQuantitativoCarburante = new Shell();
		shlQuantitativoCarburante.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlQuantitativoCarburante.setSize(450, 300);
		shlQuantitativoCarburante.setText("Quantitativo Carburante");
		//In seguito, ci sono tutti bottoni che implementa un taglio del valore di rifornimento(5 Euro, 10 Euro, Pieno)
		//vengono effettuati i controlli, dove il valore del rifornimento non scenda al di sotto dello 0,
		//oppure il valore massimo, cioè quello del pieno
		Button btnM5£ = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnM5£.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cQuantitaEuro = cQuantitaEuro - 5;
				cQuantitaPunti = cQuantitaPunti - 5;
				System.out.println("Per ora il valore del rifornimento è pari a : " + cQuantitaEuro);
				if(cQuantitaEuro < 0)
				{
					System.out.println("Valore inserito non valido");
					cQuantitaEuro = 0;
					System.out.println("Il valore del rifornimento è impostato a 0. Puoi solo aumentare l'importo: " + cQuantitaEuro);
				}
			}
		});
		btnM5£.setBounds(73, 73, 75, 35);
		btnM5£.setText("-5,00");
		
		Button btnP5£ = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnP5£.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
		
				cQuantitaEuro = cQuantitaEuro + 5;
				cQuantitaPunti = cQuantitaPunti + 5;
				System.out.println("Per ora il rifornimento è pari al valore di: " + cQuantitaEuro);
				if(cQuantitaEuro > 100)
				{
					System.out.println("Valore inserito supera il valore massimo");
					cQuantitaEuro = 100;
					System.out.println("Il valore è impostato sul pieno puoi solo dimininuire l'importo: " + cQuantitaEuro);
				}
				
			}
		});
		btnP5£.setBounds(267, 73, 75, 35);
		btnP5£.setText("+5,00");
		
		Button btnM10£ = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnM10£.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cQuantitaEuro = cQuantitaEuro - 10;
				cQuantitaPunti = cQuantitaPunti - 10;
				System.out.println("Per ora il rifornimento è pari al valore di: " + cQuantitaEuro);
				if(cQuantitaEuro < 0)
				{
					System.out.println("Valore inserito non valido");
					cQuantitaEuro = 0;
					System.out.println("Il valore è impostato a 0 puoi solo aumentare l'importo: " + cQuantitaEuro);
				}
				
				
			}
		});
		btnM10£.setBounds(73, 121, 75, 35);
		btnM10£.setText("-10,00");
		
		Button btnP10£ = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnP10£.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cQuantitaEuro = cQuantitaEuro + 10;
				cQuantitaPunti = cQuantitaPunti + 10;
				System.out.println("Per ora il rifornimento è pari al valore di: " + cQuantitaEuro);
				if(cQuantitaEuro > 100)
				{
					System.out.println("Valore inserito supera il valore massimo");
					cQuantitaEuro = 100;
					System.out.println("Il valore è impostato sul pieno puoi solo dimininuire l'importo: " + cQuantitaEuro);
				}
			}
		});
		btnP10£.setBounds(267, 121, 75, 35);
		btnP10£.setText("+10,00");
		
		Button btnAnnulla = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnAnnulla.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					shlQuantitativoCarburante.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnAnnulla.setBounds(73, 169, 75, 35);
		btnAnnulla.setText("Annulla");
		
		Button btnPieno = new Button(shlQuantitativoCarburante, SWT.NONE);
		btnPieno.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				cQuantitaEuro = cQuantitaEuro + 100;
				cQuantitaPunti = cQuantitaPunti + 100;
				System.out.println("Per ora il rifornimento è pari al valore di: " + cQuantitaEuro);
				System.out.println("Hai richiesto il pieno. Procedi al pagamento");
				if(cQuantitaEuro > 100)
				{
					System.out.println("Valore inserito supera il valore massimo");
					cQuantitaEuro = 100;
					System.out.println("Il valore è impostato sul pieno puoi solo dimininuire l'importo: " + cQuantitaEuro);
				}
			}
		});
		btnPieno.setBounds(267, 169, 75, 35);
		btnPieno.setText("Pieno");
		
		Label quantita = new Label(shlQuantitativoCarburante, SWT.NONE);
		quantita.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.NORMAL));
		quantita.setBounds(73, 33, 269, 35);
		quantita.setText("Quanto si vuole rifornire?");
		
		Button cPagamento = new Button(shlQuantitativoCarburante, SWT.NONE);
		cPagamento.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(cQuantitaEuro == 0)
				{
					System.out.println("Non puoi procedere al pagamento fin quando non viene aggiunto un valore per il rifornimento!!");
				}
				else
				{
					//Istanzio un oggetto utente, dove assegno un codice utente randomico e il valore dei punti fedelta guadagnati
					double cUtente;
					cUtente =(int)(Math.random()*10000);
					System.out.println(cUtente);
					Utente u =new Utente(cUtente,cQuantitaPunti);
					u.stampaPunti();
					try
					{
						shlQuantitativoCarburante.dispose();
						InterfacciaPagamento window = new InterfacciaPagamento(cQuantitaEuro,tipod);
						window.open();
					}catch(Exception e2) {
						e2.printStackTrace();
					}
					
				}
			}
		});
		cPagamento.setBounds(73, 226, 269, 25);
		cPagamento.setText("Procedi al Pagamento");
		
		

	}
	
	public int getQuantita()
	{
		return cQuantitaEuro;
		
	}
	
	public boolean getTipo()
	{
		return tipod;
		
	}
	

}
