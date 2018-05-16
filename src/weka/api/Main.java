package prog_projekt;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;


//Weka handles .arff (attribute relation file format) and .csv formats
import weka.classifiers.Evaluation;
//import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

//TODO: use classloader from java libs to get classes by name???

public class Main {
	Shell shell;
	public static void main(String[] args) { 
		try {

			DataSource source = new DataSource("C:\\Users\\vitom\\Desktop\\iris.arff");
			
			Instances trainDataset = source.getDataSet();
			
			trainDataset.setClassIndex(trainDataset.numAttributes() - 1);
			
			J48 tree = new J48();
			
			tree.buildClassifier(trainDataset);
			
			Evaluation eval = new Evaluation(trainDataset);
			
			DataSource source1 = new DataSource("C:\\Users\\vitom\\Desktop\\iris-test.arff");
			Instances testDataset = source1.getDataSet();
			testDataset.setClassIndex(testDataset.numAttributes() - 1);
			
			eval.evaluateModel(tree, trainDataset);
			
			System.out.println(eval.toSummaryString("Eval results:\n", false));
			System.out.println(eval.toMatrixString("=== Overall confusion matrix ===\n"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("IO exception has been thrown, maybe this file does not exist.");
		}
	
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	//OVA ZAGRADA JE KRAJ PUBLIC STATIC VOID MAIN	
	}	
	

		
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
			 DodPodatak nw = new DodPodatak();
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
