package proba;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class main {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			main window = new main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Usporedba klasifikatora");
		
		Button btnPregledKlasifikatora = new Button(shell, SWT.NONE);
		btnPregledKlasifikatora.setBounds(28, 10, 380, 30);
		btnPregledKlasifikatora.setText("Pregled klasifikatora");
		
		Button btnPregledPodataka = new Button(shell, SWT.NONE);
		btnPregledPodataka.setBounds(28, 46, 380, 30);
		btnPregledPodataka.setText("Pregled podataka");
		
		Button btnRangiranjeKlasifikatora = new Button(shell, SWT.NONE);
		btnRangiranjeKlasifikatora.setBounds(28, 82, 380, 30);
		btnRangiranjeKlasifikatora.setText("Rangiranje klasifikatora");
		
		Button btnDodavanjeNovihPodataka = new Button(shell, SWT.NONE);
		btnDodavanjeNovihPodataka.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			 dodPod nw = new dodPod();
			 nw.noviProz();
			}
		});
		
		btnDodavanjeNovihPodataka.setBounds(28, 118, 380, 30);
		btnDodavanjeNovihPodataka.setText("Dodavanje novih podataka");
		
		Button btnDodavanjeNovihKlasifikatora = new Button(shell, SWT.NONE);
		btnDodavanjeNovihKlasifikatora.setBounds(28, 156, 380, 30);
		btnDodavanjeNovihKlasifikatora.setText("Dodavanje novih klasifikatora");

	}
}
