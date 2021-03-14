import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//In questa classe vengono effettuare tutte le operazioni relative al rifornimento
public class DistributoreGplMetano {

	protected Shell shlTipoDiRifornimento;
	private int cQuantitaPrezzo;
	private float PREZZO_METANO;
	private float PREZZO_GPL;
	private float cQuantitaDistributoreGpl;
	private float cQuantitaDistributoreMetano;
	private GestioneFile op1 = new GestioneFile();
	
	//Vengono caricati nelle rispettive variabili, tutti i prezzi dei carburanti ed le quantita di carburante all'interno
	//dei distributori(effettuando anche un cast a float poichè all'interno dei file sono presenti delle stringhe)
	public DistributoreGplMetano(int p)
	{
		this.cQuantitaPrezzo = p;
		try
		{
			this.cQuantitaDistributoreGpl = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreGpl.txt"));
			this.cQuantitaDistributoreMetano = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreMetano.txt"));
			this.PREZZO_METANO = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreMetano.txt"));
			this.PREZZO_GPL = Float.parseFloat(op1.LetturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreGpl.txt"));
		}catch(Exception e) {
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
		shlTipoDiRifornimento.setSize(236, 164);
		shlTipoDiRifornimento.setText("Distributore Metano o Gpl");
		//Tutti i bottoni che seguono, vengono utilizzati per effettuare il rifornimento, gestito dal Pattern State,
		//ed aggiornare ad ogni rifornimento tutte le quantita dei distributori utilizzati
		Button Metano = new Button(shlTipoDiRifornimento, SWT.NONE);
		Metano.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_METANO,"Metano");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreMetano = cQuantitaDistributoreMetano - (cQuantitaPrezzo/PREZZO_METANO);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreMetano.txt",Float.toString(cQuantitaDistributoreMetano));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				shlTipoDiRifornimento.dispose();
				InterfacciaLogin window = new InterfacciaLogin();
				window.open();
			}
		});
		Metano.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		Metano.setBounds(24, 42, 75, 25);
		Metano.setText("Metano");
		
		Button Gpl = new Button(shlTipoDiRifornimento, SWT.NONE);
		Gpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				erogaRifornimento rif = new erogaRifornimento(cQuantitaPrezzo,PREZZO_GPL,"GPL");
				rif.effettuaRifornimento();
				
				cQuantitaDistributoreGpl = cQuantitaDistributoreGpl - (cQuantitaPrezzo/PREZZO_GPL);
				try {
					
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreGpl.txt",Float.toString(cQuantitaDistributoreGpl));
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				shlTipoDiRifornimento.dispose();
				InterfacciaLogin window = new InterfacciaLogin();
				window.open();
			}
		});
		Gpl.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		Gpl.setBounds(128, 42, 75, 25);
		Gpl.setText("GPL");

	}
	
	//tutti i metodi di incapsulamento della classe
	public float getPrezzoMetano()
	{
		return PREZZO_METANO;
	}
	
	public float getPrezzoGpl()
	{
		return PREZZO_GPL;
	}
	
	public void setPrezzoMetano(float P_M)
	{
		this.PREZZO_METANO = P_M;
	}
	
	public void setPrezzoGpl(float P_G)
	{
		this.PREZZO_GPL = P_G;
	}

}
