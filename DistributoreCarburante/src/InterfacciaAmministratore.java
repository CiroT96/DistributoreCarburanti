import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.IOException;

import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//Interfaccia grafica che implementa le operazioni che può effettuare l'amministratore
public class InterfacciaAmministratore{

	protected Shell shlFinestraAmministratore;
	protected DistributoreDieselBenzina rid1 = new DistributoreDieselBenzina(0);
	protected DistributoreGplMetano rid2 = new DistributoreGplMetano(0);
	ControlloQuantitaDistributore opC = new ControlloQuantitaDistributore();
	GestioneFile opF = new GestioneFile();
	

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlFinestraAmministratore.open();
		shlFinestraAmministratore.layout();
		while (!shlFinestraAmministratore.isDisposed()) {
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
		shlFinestraAmministratore = new Shell();
		shlFinestraAmministratore.setImage(SWTResourceManager.getImage("C:\\Users\\R3200G\\Desktop\\Progetto.jpg"));
		shlFinestraAmministratore.setSize(425, 300);
		shlFinestraAmministratore.setText("Finestra Amministratore");
		//Si effettua il report dei distributori mediante l'utilizzo della gestione file, e vengono caricate
		//tutte le informazioni relative ad essi
		Button Report = new Button(shlFinestraAmministratore, SWT.NONE);
		Report.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				GestioneFile let = new GestioneFile();
				String dDiesel = null;
				String dBenzina = null;
				String dSuper = null;
				String dDieselHi = null;
				String dMetano = null;
				String dGpl = null;
				try {
					dDieselHi = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreHiDiesel.txt");
					dDiesel = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreDiesel.txt");
					dSuper = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSuper.txt");
					dBenzina = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreSenzaPiombo.txt");
					dMetano = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreMetano.txt");
					dGpl = let.LetturaDati("C:\\Users\\R3200G\\Desktop\\QuantitaDistributoreGpl.txt");
					
				} catch (IOException e1) {
					e1.printStackTrace();
					
				}
				
				System.out.println("Le quantita attuali di carburante all'interno dei distributori ==> ");
				System.out.println("-------------------------------------------------------");
				System.out.println("Distributore Hi Diesel: " + " " + dDieselHi + " Litri");
				System.out.println("Distributore Diesel: " + "    " + dDiesel + " Litri");
				System.out.println("Distributore Benzina: " +  "   " + dBenzina + " Litri");
				System.out.println("Distributore Super: " +  "     " + dSuper + " Litri");
				System.out.println("Distributore Metano: " + "    " + dMetano + " Litri");
				System.out.println("Distributore Gpl: " + "       " + dGpl + "  Litri");
				System.out.println("-------------------------------------------------------");
			}
		});
		Report.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		Report.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		Report.setBounds(31, 133, 230, 38);
		Report.setText("Report Distributori");
		
		//Qui invece, utilizzo i metodi di incapsulamento, nel nostro casto il get, per stampare i prezzi giornalieri
		//di tutti i carburanti
		
		Button Prezzo = new Button(shlFinestraAmministratore, SWT.NONE);
		Prezzo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				System.out.println("Prezzi attualemente caricati nel sistema ==> ");
				System.out.println("-------------------------------------------------------");
				System.out.println("Diesel:  " + rid1.getPrezzoDiesel() + " Euro" );
				System.out.println("Hi Diesel:  " + rid1.getPrezzoHiDiesel() + " Euro" );
				System.out.println("Super:  " + rid1.getPrezzoSuper() + " Euro" );
				System.out.println("Gpl:  " + rid2.getPrezzoGpl() + " Euro" );
				System.out.println("Metano:  " + rid2.getPrezzoMetano() + " Euro" );
				System.out.println("Senza Piombo:  " + rid1.getPrezzoSenzaPiombo() + " Euro" );
				System.out.println("-------------------------------------------------------");
				
				System.out.println("Si vuole aggiornare qualche prezzo? Nel caso di risposta positiva cliccare il bottone modifica.");
				
			}
		});
		Prezzo.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		Prezzo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		Prezzo.setText("Lista Prezzi Carburante");
		Prezzo.setBounds(31, 177, 230, 38);
		
		Label lblNewLabel = new Label(shlFinestraAmministratore, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 15, SWT.ITALIC));
		lblNewLabel.setBounds(31, 10, 253, 117);
		lblNewLabel.setText("Gestione amministrativa del \r\ndistributore carburanti.\r\nProcere con una delle \r\nseguenti funzioni");
		
		Button mPrezzo = new Button(shlFinestraAmministratore, SWT.NONE);
		mPrezzo.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		mPrezzo.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		//Evento, che permette all'utente di aprire un' interfaccia per ridefinire i prezzi di ogni carburante
		mPrezzo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					shlFinestraAmministratore.dispose();
					RedifinisciPrezzo window = new RedifinisciPrezzo();
					window.open();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		mPrezzo.setBounds(267, 178, 132, 37);
		mPrezzo.setText("Modifica Prezzo");
		
		Button lUtente = new Button(shlFinestraAmministratore, SWT.NONE);
		//Qui l'amministratore può vedere l'ultimo utente al quale sono stati assegnati i punti fedelta in maniera automatica
		lUtente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String nUtente = null;
				String nPunti = null;
				//Controllo e gestione dell'eccezzione di lettura dei dati all'interno del file
				try {
					nUtente = opF.LetturaDati("C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt");
					nPunti = opF.LetturaDati("C:\\Users\\R3200G\\Desktop\\ListaPunti.txt");
				} catch (IOException e1) {
					File file = new File("C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt");
					if (file.exists())
					System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt" + " esiste");
					else
						try {
							if (file.createNewFile())
							System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt" + " è stato creato");
							else
							System.out.println("Il file " + "C:\\Users\\R3200G\\Desktop\\ListaUtenti.txt" + " non può essere creato");
						} catch (IOException e2) {
							e2.printStackTrace();
						}
					e1.printStackTrace();
				}
				System.out.println("L'utente: " + nUtente + " ha guadagnato: " + nPunti + " Punti");
				
				
			}
		});
		lUtente.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW));
		lUtente.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		lUtente.setBounds(162, 221, 99, 38);
		lUtente.setText("Utente");
		//Bottono per tornare al meno principale
		Button tOperazioni = new Button(shlFinestraAmministratore, SWT.NONE);
		tOperazioni.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					shlFinestraAmministratore.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
				}catch(Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		tOperazioni.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		tOperazioni.setFont(SWTResourceManager.getFont("Segoe UI", 8, SWT.BOLD | SWT.ITALIC));
		tOperazioni.setBounds(290, 10, 87, 117);
		tOperazioni.setText("Chiudi Finestra");
		//Si controlla che la fornitura richiesta dall'amministratore, sia effettuata e completata solo se uno dei
		//distributori abbiamo un quantitativo di carburante infereriore a 10 Litri
		Button rFornitura = new Button(shlFinestraAmministratore, SWT.NONE);
		rFornitura.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				opC.checkFornitura();
				opC.rifornisciDistributore();
				
			}
		});
		rFornitura.setForeground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		rFornitura.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.BOLD | SWT.ITALIC));
		rFornitura.setBounds(267, 133, 132, 38);
		rFornitura.setText("Richiesta Fornitura");
		
		Label lblNewLabel_1 = new Label(shlFinestraAmministratore, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_YELLOW));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("Segoe UI", 9, SWT.ITALIC));
		lblNewLabel_1.setBounds(31, 221, 125, 30);
		lblNewLabel_1.setText("Aggiungi i punti del\r\nrifornimento all'utente");

	}
}
