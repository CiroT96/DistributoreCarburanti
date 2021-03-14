import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//Interfaccia grafica che implementa le operazioni dell'utente
public class InterfacciaLogin {

	protected Shell shlDistributoreCarburanti;
	private boolean tipod;
	private boolean tipoa;
	
	/**
	 * Launch the application.
	 * @param args
	 * @throws IOException 
	 */
	//Main di partenza dell'applicazione, vengono caricati tutti i dati relativi al distributore carburanti
	public static void main(String[] args) throws IOException {
		System.out.println("Benvenuti al distributore Carburanti.");
		ControlloQuantitaDistributore op = new ControlloQuantitaDistributore();
		op.checkFornitura();//Viene controllato che tutti i distributori siano riforniti con almeno 10 litri di carburante
		if(op.getErrore() == true)// Se non sussiste la condizione precedente, il distributore non parte e viene chiesto subito 
		{						  //l'intervento dell'amministratore
			try
			{
				System.out.println("C'è un problema. Serve assistenza Amministratore!!");
				System.out.println("Inserire codice amministratore per accedere..");
				InterfacciaAccesso window = new InterfacciaAccesso(false, false, 0);
				window.open();
			}catch(Exception e) {
				e.printStackTrace();
			}	
		}else// Nel caso contrario, l'applicazione parte tranquillamente con l'interfaccia iniziale
		{
			try {
				System.out.println("Procedere con il rifornimento, selezionando una delle pompe...");
			InterfacciaLogin window = new InterfacciaLogin();
			window.open();
			} catch (Exception e) {
			e.printStackTrace();
		}
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlDistributoreCarburanti.open();
		shlDistributoreCarburanti.layout();
		while (!shlDistributoreCarburanti.isDisposed()) {
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
		shlDistributoreCarburanti = new Shell();
		shlDistributoreCarburanti.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shlDistributoreCarburanti.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlDistributoreCarburanti.setSize(397, 358);
		shlDistributoreCarburanti.setText("Distributore Carburanti");
		//In questa parte di codice, si sceglie che tipo di rifornimento si vuole effettuare: <Pompa1> o <Pompa2>
		Button Pompa1 = new Button(shlDistributoreCarburanti, SWT.NONE);
		Pompa1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					shlDistributoreCarburanti.dispose();
					tipod = true; // Permette al programma, quando passa al rifornimento, che tipo di pompa sia stata scelta
					InterfacciaRifornimento window = new InterfacciaRifornimento(tipod);
					window.open();
				}catch(Exception e3) {
					e3.printStackTrace();
				}
			}
		});
		Pompa1.setBounds(10, 34, 114, 88);
		Pompa1.setText("Pompa 1");
		
		Button Pompa2 = new Button(shlDistributoreCarburanti, SWT.NONE);
		Pompa2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
						shlDistributoreCarburanti.dispose();
						tipod=false;// Permette al programma, quando passa al rifornimento, che tipo di pompa sia stata scelta
						InterfacciaRifornimento window = new InterfacciaRifornimento(tipod);
						window.open();
				}catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		Pompa2.setBounds(191, 34, 114, 88);
		Pompa2.setText("Pompa 2");
		//Per entrare in modalità amministratore, ho aggiunto un evento doppio click sulla scritta 
		//"Seleziona la pompa per proseguire", per rendere nascosto questo tipo di opzione
		Label AccessoAmm = new Label(shlDistributoreCarburanti, SWT.NONE);
		AccessoAmm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				System.out.println("Benvenuto Amministratore.");
				System.out.println("Completare Login per accedere alle funzioni dell'amministratore :==>");
				
				try
				{
					tipoa=false;//Indica alla classe Interfaccia Accesso, che tipo di accesso deve gestire, Amministratore o Utente
					shlDistributoreCarburanti.dispose();
					InterfacciaAccesso window = new InterfacciaAccesso(tipoa, tipod,0);
					window.open();
				}catch(Exception e1){
					e1.printStackTrace();
				}		
			}
		});
		AccessoAmm.setFont(SWTResourceManager.getFont("Segoe UI", 25, SWT.NORMAL));
		AccessoAmm.setBounds(10, 128, 295, 149);
		AccessoAmm.setText("Seleziona\r\nla pompa\r\nper proseguire");
		
		Label Diesel = new Label(shlDistributoreCarburanti, SWT.NONE);
		Diesel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW));
		Diesel.setBounds(130, 34, 55, 15);
		Diesel.setText("Diesel");
		
		Label Benzina = new Label(shlDistributoreCarburanti, SWT.NONE);
		Benzina.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		Benzina.setBounds(130, 55, 55, 15);
		Benzina.setText("Benzina");
		
		Label Metano = new Label(shlDistributoreCarburanti, SWT.NONE);
		Metano.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		Metano.setBounds(311, 34, 55, 15);
		Metano.setText("Metano");
		
		Label GPL = new Label(shlDistributoreCarburanti, SWT.NONE);
		GPL.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		GPL.setBounds(311, 55, 55, 15);
		GPL.setText("GPL");

	}
	public boolean getTipoDistributore() 
	{
		return tipod;
	}
}
