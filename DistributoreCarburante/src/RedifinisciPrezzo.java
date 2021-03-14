import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//Interfaccia grafica che implementa le operazioni di ridefinizione dei prezzi 
public class RedifinisciPrezzo extends InterfacciaAmministratore {

	protected Shell shlRedifisciPrezzoCarburante;
	private Text tPrezzo;
	private GestioneFile op1 = new GestioneFile();


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlRedifisciPrezzoCarburante.open();
		shlRedifisciPrezzoCarburante.layout();
		while (!shlRedifisciPrezzoCarburante.isDisposed()) {
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
		shlRedifisciPrezzoCarburante = new Shell();
		shlRedifisciPrezzoCarburante.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlRedifisciPrezzoCarburante.setSize(360, 230);
		shlRedifisciPrezzoCarburante.setText("Redifisci Prezzo Carburante");
		//Utilizzo una textfield per inserire il valore del prezzo che bisogna aggiornare
		tPrezzo = new Text(shlRedifisciPrezzoCarburante, SWT.BORDER);
		tPrezzo.setBounds(9, 39, 76, 21);
		
		
		//Qui utilizziamo i bottoni per inserire il valore della text field. Ciò che facciamo è aggiornare tutti
		//i valori, di quelli che cambiamo, dei prezzi del carburante, andando ad aggiornare i file
		Button pHiDiesel = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pHiDiesel.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_CYAN));
		pHiDiesel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e)
			{
				float pHDiesel = 0;
					//Gestione eccezione inserimento valore non valido
					try
					{
						pHDiesel = Float.parseFloat(tPrezzo.getText());
						}catch(NumberFormatException e1){
							System.out.println("Il valore inserito non è valido");
						}
					//Gestione eccezione scrittura di dati all'interno del file
					try 
					{
							op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt",Float.toString(pHDiesel));
							rid1.setPrezzoHiDiesel(Float.parseFloat(tPrezzo.getText()));
					} catch (IOException e1) { // Nel caso non esiste il file, si alza l'eccezione, e ne crea uno al momento
					File file = new File("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt");
					if (file.exists()) {
						System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt" + " esiste");
					}
					else{
						try {
							if (file.createNewFile())
							System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt" + " è stato creato");
							else
							System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreHiDiesel.txt" + " non può essere creato");
							} catch (IOException e2){
							e2.printStackTrace();
								}
						}
				
					}
				System.out.println("Il prezzo base del Hi Diesel e' stato modificato. Nuovo valore: " + rid1.getPrezzoHiDiesel() + " Euro");
				}
		});
		pHiDiesel.setBounds(91, 66, 100, 25);
		pHiDiesel.setText("Prezzo Hi Diesel");
		
		Button pDiesel = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pDiesel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		pDiesel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float pDiesel;
				pDiesel = Float.parseFloat(tPrezzo.getText());
				try {
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreDiesel.txt",Float.toString(pDiesel));
					rid1.setPrezzoDiesel(Float.parseFloat(tPrezzo.getText()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("Il prezzo base del Diesel e' stato modificato. Nuovo valore: " + rid1.getPrezzoDiesel() + " Euro");
				
				
			}
		});
		pDiesel.setBounds(9, 66, 75, 25);
		pDiesel.setText("Prezzo Diesel");
		
		Button pSuper = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pSuper.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		pSuper.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float pSuper;
				pSuper = Float.parseFloat(tPrezzo.getText());
				try {
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreSuper.txt",Float.toString(pSuper));
					rid1.setPrezzoBenzinaSuper(Float.parseFloat(tPrezzo.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Il prezzo base della Benzina Super e' stato modificato. Nuovo valore: " + rid1.getPrezzoSuper() + " Euro");
			}
		});
		pSuper.setBounds(197, 66, 131, 25);
		pSuper.setText("Prezzo Benzina Super");
		
		Button pSenzaPiombo = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pSenzaPiombo.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		pSenzaPiombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float pSPiombo;
				pSPiombo = Float.parseFloat(tPrezzo.getText());
				try {
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreSenzaPiombo.txt",Float.toString(pSPiombo));
					rid1.setPrezzoSenzaPiombo(Float.parseFloat(tPrezzo.getText()));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Il prezzo base del Senza Piombo e' stato modificato. Nuovo valore: " + rid1.getPrezzoSenzaPiombo() + " Euro");
			}
		});
		pSenzaPiombo.setBounds(197, 97, 131, 25);
		pSenzaPiombo.setText("Prezzo Senza Piombo");
		
		Button pMetano = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pMetano.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		pMetano.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float pMetano;
				pMetano = Float.parseFloat(tPrezzo.getText());
				try {
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreMetano.txt",Float.toString(pMetano));
					rid2.setPrezzoMetano(Float.parseFloat(tPrezzo.getText()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("Il prezzo base del Metano e' stato modificato. Nuovo valore: " + rid2.getPrezzoMetano() + " Euro");
			}
		});
		pMetano.setBounds(91, 97, 99, 25);
		pMetano.setText("Prezzo Metano");
		
		Button pGpl = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		pGpl.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		pGpl.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float pGpl;
				pGpl = Float.parseFloat(tPrezzo.getText());
				try {
					op1.ScritturaDati("C:\\Users\\R3200G\\Desktop\\PrezzoDistributoreGpl.txt",Float.toString(pGpl));
					rid2.setPrezzoGpl(Float.parseFloat(tPrezzo.getText()));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.out.println("Il prezzo base del GPL e' stato modificato. Nuovo valore: " + rid2.getPrezzoGpl() + " Euro");
			}
		});
		pGpl.setBounds(9, 97, 76, 25);
		pGpl.setText("Prezzo Gpl");
		
		Label label = new Label(shlRedifisciPrezzoCarburante, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label.setFont(SWTResourceManager.getFont("Segoe UI", 11, SWT.ITALIC));
		label.setBounds(10, 10, 318, 23);
		label.setText("Qui puoi ridefinire i prezzi di qualsiasi carburante");
		
		Button tOperazione = new Button(shlRedifisciPrezzoCarburante, SWT.NONE);
		tOperazione.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_RED));
		tOperazione.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shlRedifisciPrezzoCarburante.dispose();
				InterfacciaAmministratore window = new InterfacciaAmministratore();
				window.open();
				
			}
		});
		tOperazione.setBounds(10, 156, 318, 25);
		tOperazione.setText("Termina Operazione Modifica Prezzo Carburante");

	}
}
