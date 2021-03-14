import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//In questa classe vengono effettuare tutte le operazioni relative al rifornimento
public class DistributoreDieselBenzina {

	protected Shell shlTipoDiRifornimento;
	private int cQuantitaPrezzo;
	private float PREZZO_SENZA_PIOMBO;
	private float PREZZO_HI_DIESEL;
	private float PREZZO_DIESEL;
	private float PREZZO_BENZINA_SUPER;
	private float cQuantitaDistributoreHiDiesel;
	private float cQuantitaDistributoreDiesel;
	private float cQuantitaDistributoreSuper;
	private float cQuantitaDistributoreSenzaPiombo;
	private GestioneFile op1 = new GestioneFile();
	
	
	//Vengono caricati nelle rispettive variabili, tutti i prezzi dei carburanti ed le quantita di carburante all'interno
	//dei distributori(effettuando anche un cast a float poichè all'interno dei file sono presenti delle stringhe)
	public DistributoreDieselBenzina(int p)
	{
		this.cQuantitaPrezzo = p;
		try {
			this.cQuantitaDistributoreHiDiesel = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreHiDiesel.txt"));
			this.cQuantitaDistributoreDiesel = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreDiesel.txt"));
			this.cQuantitaDistributoreSuper = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSuper.txt"));
			this.cQuantitaDistributoreSenzaPiombo = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSenzaPiombo.txt"));
			this.PREZZO_HI_DIESEL = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt"));
			this.PREZZO_DIESEL = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreDiesel.txt"));
			this.PREZZO_SENZA_PIOMBO = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreSenzaPiombo.txt"));
			this.PREZZO_BENZINA_SUPER = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreSuper.txt"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlTipoDiRifornimento.open();
		shlTipoDiRifornimento.layout();
		while (!shlTipoDiRifornimento.isDisposed()) {
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
		shlTipoDiRifornimento = new Shell();
		shlTipoDiRifornimento.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlTipoDiRifornimento.setSize(450, 299);
		shlTipoDiRifornimento.setText("Distributore Diesel o Benzina");
		//Tutti i bottoni che seguono, vengono utilizzati per effettuare il rifornimento, gestito dal Pattern State,
		//ed aggiornare ad ogni rifornimento tutte le quantita dei distributori utilizzati
		Button HiDiesel = new Button(shlTipoDiRifornimento, SWT.NONE);
		HiDiesel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_HI_DIESEL,"Hi Diesel");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreHiDiesel = cQuantitaDistributoreHiDiesel - (cQuantitaPrezzo/PREZZO_HI_DIESEL);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreHiDiesel.txt",Float.toString(cQuantitaDistributoreHiDiesel));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				try
				{
					shlTipoDiRifornimento.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
		

			}
		});
		HiDiesel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		HiDiesel.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		HiDiesel.setBounds(21, 41, 136, 45);
		HiDiesel.setText("Hi Diesel");
		
		Button Diesel = new Button(shlTipoDiRifornimento, SWT.NONE);
		Diesel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_DIESEL,"Diesel");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreDiesel = cQuantitaDistributoreDiesel - (cQuantitaPrezzo/PREZZO_DIESEL);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreDiesel.txt",Float.toString(cQuantitaDistributoreDiesel));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try
				{
					shlTipoDiRifornimento.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
		

			}
		});
		Diesel.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		Diesel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW));
		Diesel.setBounds(21, 138, 136, 45);
		Diesel.setText("Diesel");
		
		Button SenzaPiombo = new Button(shlTipoDiRifornimento, SWT.NONE);
		SenzaPiombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_SENZA_PIOMBO,"Senza Piombo");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreSenzaPiombo = cQuantitaDistributoreSenzaPiombo - (cQuantitaPrezzo/PREZZO_SENZA_PIOMBO);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSenzaPiombo.txt",Float.toString(cQuantitaDistributoreSenzaPiombo));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				try
				{
					shlTipoDiRifornimento.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			

			}
		});
		SenzaPiombo.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		SenzaPiombo.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		SenzaPiombo.setBounds(268, 41, 136, 45);
		SenzaPiombo.setText("Senza Piombo");
		
		Button Super = new Button(shlTipoDiRifornimento, SWT.NONE);
		Super.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_BENZINA_SUPER,"Super");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreSuper = cQuantitaDistributoreSuper - (cQuantitaPrezzo/PREZZO_BENZINA_SUPER);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSuper.txt",Float.toString(cQuantitaDistributoreSuper));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				
				try
				{
					shlTipoDiRifornimento.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		Super.setFont(SWTResourceManager.getFont("Segoe UI", 16, SWT.NORMAL));
		Super.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		Super.setToolTipText("Super");
		Super.setBounds(268, 138, 136, 45);
		Super.setText("Super");

	}
	
	//tutti i metodi di incapsulamento della classe
	
	public float getPrezzoSenzaPiombo()
	{
		return PREZZO_SENZA_PIOMBO;
	}
	
	public float getPrezzoHiDiesel()
	{
		return PREZZO_HI_DIESEL;
	}
	
	public float getPrezzoSuper()
	{
		return PREZZO_BENZINA_SUPER;
	}
	
	public float getPrezzoDiesel()
	{
		return PREZZO_DIESEL;
	}
	
	public void setPrezzoSenzaPiombo(float P_SP)
	{
		this.PREZZO_SENZA_PIOMBO = P_SP;
	}
	
	public void setPrezzoHiDiesel(float P_HD)
	{
		this.PREZZO_HI_DIESEL = P_HD;
	}
	
	public void setPrezzoBenzinaSuper(float P_BS)
	{
		this.PREZZO_BENZINA_SUPER = P_BS;
	}
	
	public void setPrezzoDiesel(float P_D)
	{
		this.PREZZO_DIESEL = P_D;
	}
	
	
}
