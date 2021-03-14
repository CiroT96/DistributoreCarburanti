import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
//Interfaccia grafica che implementa i metodi di pagamento
public class InterfacciaPagamento {

	protected Shell shlFinestraPagamento;
	private int cQuantitaPrezzo;
	private boolean tipod;
	private boolean tipoa;

	
	public InterfacciaPagamento(int q,boolean t)
	{
		this.cQuantitaPrezzo = q;
		this.tipod = t;
	}
	

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFinestraPagamento.open();
		shlFinestraPagamento.layout();
		while (!shlFinestraPagamento.isDisposed()) {
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
		shlFinestraPagamento = new Shell();
		shlFinestraPagamento.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlFinestraPagamento.setSize(246, 216);
		shlFinestraPagamento.setText("Finestra Pagamento");
		//A seguire, ci sono le implementazioni dei vari tipi di metodi di pagamento
		//Sia per il bancomat e carta di credito, viene utilizzato il tastierino numerico, che implementa 
		//il Pattern Facade
		Button CartaCredito = new Button(shlFinestraPagamento, SWT.NONE);
		CartaCredito.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Stai per effettuare un pagamento con Carta di Credito di un valore pari a: " + cQuantitaPrezzo + " Euro");
				System.out.println("Apertura inserimento codice in corso ...");
				tipoa = true;
				try
				{
					if(tipod == true)//Con questo controllo riesco a risalire a quale pompa sia stata cliccata inizialmente
					{
						shlFinestraPagamento.dispose();
						InterfacciaAccesso window = new InterfacciaAccesso(tipoa,tipod,cQuantitaPrezzo);
						window.open();
					}else
					{
						shlFinestraPagamento.dispose();
						InterfacciaAccesso window = new InterfacciaAccesso(tipoa,tipod,cQuantitaPrezzo);
						window.open();
					}
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		CartaCredito.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		CartaCredito.setBounds(10, 66, 95, 25);
		CartaCredito.setText("Carta di Credito");
		
		
		
		Button Bancomat = new Button(shlFinestraPagamento, SWT.NONE);
		Bancomat.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Stai per effettuare un pagamento con Bancomat di un valore pari a: " + cQuantitaPrezzo + " Euro");
				System.out.println("Apertura inserimento codice in corso ...");
				tipoa = true;
				try
				{
					if(tipod == true)//Con questo controllo riesco a risalire a quale pompa sia stata cliccata inizialmente
					{
						shlFinestraPagamento.dispose();
						InterfacciaAccesso window = new InterfacciaAccesso(tipoa,tipod,cQuantitaPrezzo);
						window.open();
					}else
					{
						shlFinestraPagamento.dispose();
						InterfacciaAccesso window = new InterfacciaAccesso(tipoa,tipod,cQuantitaPrezzo);
						window.open();
					}
				}catch(Exception e1)
				{
					e1.printStackTrace();
				}
				
			}
		});
		Bancomat.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		Bancomat.setBounds(129, 66, 95, 25);
		Bancomat.setText("Bancomat");
		//Il pagamento in contanti viene effettuato automaticamente, poiché non ha bisogno di nessun codice
		Button Contanti = new Button(shlFinestraPagamento, SWT.NONE);
		Contanti.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		Contanti.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Hai effettuato il pagamento in contanti di un valore pari a: " + cQuantitaPrezzo + " Euro");
				System.out.println("Ora puoi effettuare il tuo rifornimento. Apertura pompa in corso ...");
				if(tipod == true)//Con questo controllo riesco a risalire a quale pompa sia stata cliccata inizialmente
				{
					try
					{
						shlFinestraPagamento.dispose();
						DistributoreDieselBenzina window = new DistributoreDieselBenzina(cQuantitaPrezzo);
						window.open();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}else
				{
					try
					{
						shlFinestraPagamento.dispose();
						DistributoreGplMetano window1 = new DistributoreGplMetano(cQuantitaPrezzo);
						window1.open();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
					
				}
				
			}
		});
		Contanti.setBounds(10, 121, 95, 25);
		Contanti.setText("Contanti");
		
		Button Annulla = new Button(shlFinestraPagamento, SWT.NONE);
		Annulla.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					shlFinestraPagamento.dispose();
					System.out.println("Operazione annullata. Ripetere!");
					InterfacciaRifornimento window = new InterfacciaRifornimento(tipod);
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		Annulla.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		Annulla.setBounds(129, 121, 95, 25);
		Annulla.setText("Annulla");
		
		Label lblNewLabel = new Label(shlFinestraPagamento, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblNewLabel.setTouchEnabled(true);
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 12, SWT.NORMAL));
		lblNewLabel.setBounds(10, 10, 214, 50);
		lblNewLabel.setText("Qui puoi scegliere\r\nil metodo di pagamento");

	}
	public int getQuantita() 
	{
		return cQuantitaPrezzo;
	}
	public boolean getTipo()
	{
		return tipod;
	}

}
