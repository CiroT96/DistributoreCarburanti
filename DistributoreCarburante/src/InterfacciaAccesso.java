import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//Interfaccia grafica che implmenta il nostro tastierino numerico
public class InterfacciaAccesso{

	protected Shell shlInserimentoCodice;
	private Text text;
	private boolean tUtente;
	private boolean tDib;
	private int codice;
	private int cQuantitaPrezzo;

	
	public InterfacciaAccesso(boolean t,boolean d,int q)
	{
		this.tUtente = t;
		this.tDib = d;
		this.cQuantitaPrezzo = q;
	}
	
	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlInserimentoCodice.open();
		shlInserimentoCodice.layout();
		while (!shlInserimentoCodice.isDisposed()) {
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
		shlInserimentoCodice = new Shell();
		shlInserimentoCodice.setSize(336, 277);
		shlInserimentoCodice.setText("Inserisci Codice");
		
		Button ButtonN1 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("1");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN1.setBounds(10, 97, 75, 25);
		ButtonN1.setText("1");
		
		Button ButtonN2 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("2");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN2.setBounds(121, 97, 75, 25);
		ButtonN2.setText("2");
		
		Button ButtonN3 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("3");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN3.setBounds(232, 97, 75, 25);
		ButtonN3.setText("3");
		
		Button ButtonN4 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("4");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN4.setBounds(10, 128, 75, 25);
		ButtonN4.setText("4");
		
		Button ButtonN5 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("5");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN5.setBounds(121, 128, 75, 25);
		ButtonN5.setText("5");
		
		Button ButtonN6 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("6");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN6.setBounds(232, 128, 75, 25);
		ButtonN6.setText("6");
		
		Button ButtonN7 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("7");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN7.setBounds(10, 159, 75, 25);
		ButtonN7.setText("7");
		
		Button ButtonN8 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("8");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN8.setBounds(121, 159, 75, 25);
		ButtonN8.setText("8");
		
		Button ButtonN9 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("9");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN9.setBounds(232, 159, 75, 25);
		ButtonN9.setText("9");
		
		Button ButtonN0 = new Button(shlInserimentoCodice, SWT.NONE);
		ButtonN0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				text.setText("1");
				codice = Integer.parseInt(text.getText());
			}
		});
		ButtonN0.setBounds(121, 190, 75, 25);
		ButtonN0.setText("0");
		
		Button bAnnulla = new Button(shlInserimentoCodice, SWT.NONE);
		bAnnulla.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try
				{
					shlInserimentoCodice.dispose();
					InterfacciaLogin window = new InterfacciaLogin();
					window.open();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		bAnnulla.setBounds(10, 190, 75, 25);
		bAnnulla.setText("Annulla");
		
		Button bConferma = new Button(shlInserimentoCodice, SWT.NONE);
		bConferma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {;
				Facade facade = new Facade(tDib,cQuantitaPrezzo);
				if(tUtente == true)
				{
					shlInserimentoCodice.dispose();
					facade.codAmm(codice);
				}else
				{
					shlInserimentoCodice.dispose();
					facade.codCarta(codice);
				}
				
			}
		});
		bConferma.setBounds(232, 190, 75, 25);
		bConferma.setText("Conferma");
		
		Label lblNewLabel = new Label(shlInserimentoCodice, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.ITALIC));
		lblNewLabel.setBounds(10, 10, 297, 54);
		lblNewLabel.setText("Inserisci Codice");
		
		text = new Text(shlInserimentoCodice, SWT.BORDER);
		text.setBounds(10, 70, 297, 21);

	}
}
