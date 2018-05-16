package prog_projekt;

import org.eclipse.swt.widgets.Display;
import java.sql.*;

import javax.swing.*;
import java.io.*;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.swt.custom.ScrolledComposite;

public class DodPodatak {

	protected Shell shlDodajNoviPodatak;
	JFileChooser fileC = new JFileChooser();
	private Text text;
	String path = null;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void noviProz() {
		try {
			DodPodatak window = new DodPodatak();
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
		shlDodajNoviPodatak.open();
		shlDodajNoviPodatak.layout();
		while (!shlDodajNoviPodatak.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	void createContents() {
		shlDodajNoviPodatak = new Shell();
		shlDodajNoviPodatak.setSize(450, 300);
		shlDodajNoviPodatak.setText("Dodaj novi podatak");
		
		
		Label lblNewLabel = new Label(shlDodajNoviPodatak, SWT.NONE);
		lblNewLabel.setBounds(10, 46, 412, 20);
		lblNewLabel.setText("*odabrana datoteka*");
		
		Button btnNewButton = new Button(shlDodajNoviPodatak, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fileC.setCurrentDirectory(new File(System.getProperty("user.home")));
				if(e.getSource()==btnNewButton) {
					int res = fileC.showOpenDialog(fileC);
					
					if(res==JFileChooser.APPROVE_OPTION){
						File file = fileC.getSelectedFile();
						lblNewLabel.setText(file.getAbsolutePath().toString());
					
						path = file.getAbsolutePath().toString();
					
					}
				}				
			}
			
		});
		btnNewButton.setBounds(10, 10, 90, 30);
		btnNewButton.setText("Odaberi");
		
		text = new Text(shlDodajNoviPodatak, SWT.BORDER);
		text.setBounds(10, 113, 174, 26);
		
		Label lblNapiiIdJavnog = new Label(shlDodajNoviPodatak, SWT.NONE);
		lblNapiiIdJavnog.setBounds(10, 87, 174, 20);
		lblNapiiIdJavnog.setText("Napi\u0161i ID javnog podatka");
		
		Button btnPohrani = new Button(shlDodajNoviPodatak, SWT.NONE);
		btnPohrani.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				upis();
				
			}
		});
		btnPohrani.setBounds(10, 145, 90, 30);
		btnPohrani.setText("Pohrani");
		
		
		

	}
	
	void upis() {
		 try { 
	            String url = "jdbc:mysql://localhost:3306/database"; 
	            Connection conn = DriverManager.getConnection(url,"root",""); 
	            Statement st = conn.createStatement(); 
	            st.executeUpdate("INSERT INTO `javni_pod` (`ID`, `path`) " + 
	                "VALUES ('" + text.getText() + "','" + path + "')"); 
	           
	            conn.close(); 
	        } catch (Exception e) { 
	            System.err.println("Got an exception! "); 
	            System.err.println(e.getMessage()); 
	        } 
	}
	
	
}
