package Synergeio;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SynergeioMain extends JFrame implements ActionListener {

	private JPanel cards, panelEgrPelati, panelTropPelati,panelNewTexnikos,
			panelNewGrammateas;
	private JMenuBar menuBar;
	private JMenu pelatis, ypalliloi, kataxwrhshYpallilwn, ergasies, exit,
			save;
	private JMenuItem egrPelatiMenuItem, tropPelatiMenuItem,
			printPelatiMenuItem, saveAllMenuItem, exodosMenuItem,
			newTexnikosMenuItem, diathesimotitaMenuItem, newGrammateasMenuItem,
			programErgMenuItem, ektypwsiErgMenuItem, diekperaiwshErgMenuItem;
	private JTextField onomaTextField, epithetoTextField, dieythinsiTextField,
			thlTextField, ATTextField, tropPelatisTF, onomaTropTF, epithetoTropTF, dieythinsiTropTF,
			thlTropTF, ATTropTF, onomaTexnikouTF, epithetoTexnikouTF,
			dieythinsiTexnikouTF, thlTexnikouTF, atTexnikouTF, asfalTextField, gramOnomaTF,gramDieythinsiTF,gramEpithetoTF,
			gramThlTF,gramAtTF;
	private JButton addpelatiButton, clearpelatiFormButton, tropopoihshButton,
			esgTexnikosButton,
			searchTropButton, clearTexnikosFormButton,
			 eisagwsiGramButton,clearGrammForm;
	private String onoma, epitheto, dieythinsi, thl, AT, asfalistiki,
			tropPelatis;
	private Boolean flag;
	private JComboBox<String> eidikotitaTexnikouCB;
	private JLabel synergeioLB,onomaPelatiLB,epithetoPelatiLB,thlPelatiLB,dieythinsiPelatiLB,
			atPelatiLB,asfalistikhLB,tropPelatiLB,onomaTropLB,epithetoTropLB,dieythinsiTropLB,
			thlTropLB,atTropLB,label_36,label_37, label_38,label_39,label_40,label_41;
	
	// vector pelates
	Vector<Customer> customers = new Vector<Customer>();
	// vector ypallhloi
	Vector<Employee> employees = new Vector<Employee>();

	CardLayout card;
	Texnikos diathesimotitaTexikou;
	
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

					SynergeioMain frame = new SynergeioMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SynergeioMain() {
		setResizable(false);

		/**
		 * Kentriko Parathyro
		 */
		setTitle("Σύστημα Διαχείρισης Συνεργείου");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 400);

		/**
		 * Mpara menu
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		/**
		 * Menu Pelatis
		 */
		pelatis = new JMenu("Πελάτης");
		menuBar.add(pelatis);

		/**
		 * Ta ypomenu tou pelati Eggrafh pelati, Tropopoihsh Pelati, Ektypwsh
		 * Pelati
		 */
		// Egrgafh pelati
		egrPelatiMenuItem = new JMenuItem("Εγγραφή Πελάτη");
		egrPelatiMenuItem.addActionListener(this);
		pelatis.add(egrPelatiMenuItem);

		// Tropopoihsh pelati
		tropPelatiMenuItem = new JMenuItem("Τροποποίηση Πελάτη");
		tropPelatiMenuItem.addActionListener(this);
		pelatis.add(tropPelatiMenuItem);

		// Ektypwsh pelati
		printPelatiMenuItem = new JMenuItem("Εκτύπωση Πελάτη");
		printPelatiMenuItem.addActionListener(this);
		pelatis.add(printPelatiMenuItem);

		/**
		 * To ypomenu twn ypallilwn
		 * 
		 * Kataxwrhsh ypallilwn -->Texnikos h Grammateas,
		 */
		ypalliloi = new JMenu("Υπάλληλοι");
		menuBar.add(ypalliloi);

		kataxwrhshYpallilwn = new JMenu("Καταχώρηση Υπαλλήλων");
		ypalliloi.add(kataxwrhshYpallilwn);

		newTexnikosMenuItem = new JMenuItem("Τεχνικός");
		newTexnikosMenuItem.addActionListener(this);
		kataxwrhshYpallilwn.add(newTexnikosMenuItem);

		newGrammateasMenuItem = new JMenuItem("Γραμματέας");
		newGrammateasMenuItem.addActionListener(this);
		kataxwrhshYpallilwn.add(newGrammateasMenuItem);

		diathesimotitaMenuItem = new JMenuItem("Διαθεσιμότητα Τεχνικών");
		diathesimotitaMenuItem.addActionListener(this);
		ypalliloi.add(diathesimotitaMenuItem);

		ergasies = new JMenu("Εργασίες");
		menuBar.add(ergasies);

		programErgMenuItem = new JMenuItem("Προγραμματισμός Εργασιών");
		programErgMenuItem.addActionListener(this);
		ergasies.add(programErgMenuItem);

		ektypwsiErgMenuItem = new JMenuItem("Εκτύπωση Εργασιών");
		ektypwsiErgMenuItem.addActionListener(this);
		ergasies.add(ektypwsiErgMenuItem);

		diekperaiwshErgMenuItem = new JMenuItem("Διεκπεραίωση Εργασίας");
		diekperaiwshErgMenuItem.addActionListener(this);
		ergasies.add(diekperaiwshErgMenuItem);

		save = new JMenu("Αποθήκευση");
		menuBar.add(save);

		saveAllMenuItem = new JMenuItem("Αποθήκευση Κατάστασης");
		saveAllMenuItem.addActionListener(this);
		save.add(saveAllMenuItem);

		exit = new JMenu("Έξοδος");
		menuBar.add(exit);

		exodosMenuItem = new JMenuItem("Έξοδος απο την Εφαρμογή");
		exodosMenuItem.addActionListener(this);
		exit.add(exodosMenuItem);
		card = new CardLayout();
		cards = new JPanel(new CardLayout());
		cards.setBackground(new Color(255, 255, 224));
		cards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cards);

		synergeioLB = new JLabel("Σύστημα Διαχείρισης Συνεργείου");
		synergeioLB.setBackground(new Color(255, 255, 224));
		synergeioLB.setHorizontalAlignment(SwingConstants.CENTER);
		synergeioLB.setFont(new Font("Book Antiqua", Font.PLAIN, 32));
		cards.add(synergeioLB, "Arxikh");

		//Panel eggrafis Pelati
		panelEgrPelati = new JPanel();
		panelEgrPelati.setBackground(new Color(255, 255, 224));
		cards.add(panelEgrPelati, "Eggrafi Pelati");
		panelEgrPelati.setLayout(null);
		

		onomaPelatiLB = new JLabel("Όνομα");
		onomaPelatiLB.setBounds(28, 62, 96, 14);
		panelEgrPelati.add(onomaPelatiLB);

		onomaTextField = new JTextField();
		onomaTextField.setBounds(143, 56, 96, 20);
		panelEgrPelati.add(onomaTextField);
		onomaTextField.setColumns(10);

		epithetoPelatiLB = new JLabel("Επίθετο");
		epithetoPelatiLB.setBounds(28, 93, 96, 14);
		panelEgrPelati.add(epithetoPelatiLB);

		epithetoTextField = new JTextField();
		epithetoTextField.setBounds(143, 87, 96, 20);
		panelEgrPelati.add(epithetoTextField);
		epithetoTextField.setColumns(10);

		dieythinsiPelatiLB = new JLabel("Διεύθυνση");
		dieythinsiPelatiLB.setBounds(28, 126, 96, 14);
		panelEgrPelati.add(dieythinsiPelatiLB);

		dieythinsiTextField = new JTextField();
		dieythinsiTextField.setBounds(143, 120, 96, 20);
		panelEgrPelati.add(dieythinsiTextField);
		dieythinsiTextField.setColumns(10);

		thlPelatiLB = new JLabel("Τηλέφωνο");
		thlPelatiLB.setBounds(28, 157, 96, 14);
		panelEgrPelati.add(thlPelatiLB);

		thlTextField = new JTextField();
		thlTextField.setBounds(143, 151, 96, 20);
		panelEgrPelati.add(thlTextField);
		thlTextField.setColumns(10);

		atPelatiLB = new JLabel("Αρ. Ταυτότητας");
		atPelatiLB.setBounds(28, 188, 96, 14);
		panelEgrPelati.add(atPelatiLB);

		ATTextField = new JTextField();
		ATTextField.setBounds(143, 182, 96, 20);
		panelEgrPelati.add(ATTextField);
		ATTextField.setColumns(10);

		asfalistikhLB = new JLabel("Ασφαλιστική Εταιρία");
		asfalistikhLB.setBounds(28, 228, 110, 14);
		panelEgrPelati.add(asfalistikhLB);

		asfalTextField = new JTextField();
		asfalTextField.setColumns(10);
		asfalTextField.setBounds(143, 225, 96, 20);
		panelEgrPelati.add(asfalTextField);

		//Panel Tropopoihshs Pelati
		panelTropPelati = new JPanel();
		panelTropPelati.setBackground(new Color(255, 255, 224));
		cards.add(panelTropPelati, "Tropopoihsh Pelati");
		panelTropPelati.setLayout(null);

		tropPelatiLB = new JLabel("Εισάγετε τον Αρ. Ταυτότητας Πελάτη που θέλετε να τροποποιήσετε :");
		tropPelatiLB.setBounds(10, 68, 406, 14);
		panelTropPelati.add(tropPelatiLB);

		tropPelatisTF = new JTextField();
		tropPelatisTF.setBounds(10, 84, 111, 20);
		panelTropPelati.add(tropPelatisTF);
		tropPelatisTF.setColumns(10);

		onomaTropLB = new JLabel("Όνομα");
		onomaTropLB.setBounds(10, 162, 86, 14);
		panelTropPelati.add(onomaTropLB);

		onomaTropTF = new JTextField();
		onomaTropTF.setColumns(10);
		onomaTropTF.setBounds(10, 179, 86, 20);
		panelTropPelati.add(onomaTropTF);

		epithetoTropLB = new JLabel("Επίθετο");
		epithetoTropLB.setBounds(147, 162, 86, 14);
		panelTropPelati.add(epithetoTropLB);
		
		epithetoTropTF = new JTextField();
		epithetoTropTF.setColumns(10);
		epithetoTropTF.setBounds(147, 179, 86, 20);
		panelTropPelati.add(epithetoTropTF);

		dieythinsiTropLB = new JLabel("Διεύθυνση");
		dieythinsiTropLB.setBounds(10, 234, 86, 14);
		panelTropPelati.add(dieythinsiTropLB);

		dieythinsiTropTF = new JTextField();
		dieythinsiTropTF.setColumns(10);
		dieythinsiTropTF.setBounds(10, 249, 86, 20);
		panelTropPelati.add(dieythinsiTropTF);

		thlTropTF = new JTextField();
		thlTropTF.setColumns(10);
		thlTropTF.setBounds(147, 249, 86, 20);
		panelTropPelati.add(thlTropTF);

		thlTropLB = new JLabel("Τηλέφωνο");
		thlTropLB.setBounds(147, 234, 86, 14);
		panelTropPelati.add(thlTropLB);

		atTropLB = new JLabel("Αρ. Ταυτότητας");
		atTropLB.setBounds(281, 234, 99, 14);
		panelTropPelati.add(atTropLB);

		ATTropTF = new JTextField();
		ATTropTF.setColumns(10);
		ATTropTF.setBounds(281, 249, 99, 20);
		panelTropPelati.add(ATTropTF);

		
		//Panel Neos Texnikos
		panelNewTexnikos = new JPanel();
		panelNewTexnikos.setBackground(new Color(255, 255, 224));
		cards.add(panelNewTexnikos, "New Texnikos");
		panelNewTexnikos.setLayout(null);

		JLabel label_16 = new JLabel("Εισαγωγή Τεχνικού");
		label_16.setBounds(152, 0, 243, 34);
		label_16.setForeground(Color.BLACK);
		label_16.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
		panelNewTexnikos.add(label_16);

		JLabel label_15 = new JLabel("ΕιδικότηταΤεχνικού");
		label_15.setBounds(0, 68, 100, 14);
		panelNewTexnikos.add(label_15);

		eidikotitaTexnikouCB = new JComboBox<String>();
		eidikotitaTexnikouCB.setBounds(105, 65, 95, 20);
		eidikotitaTexnikouCB.setModel(new DefaultComboBoxModel<String>(new String[] {
				"Ηλεκτρολόγος", "Μηχανικός", "Φανοποιός" }));
		panelNewTexnikos.add(eidikotitaTexnikouCB);

		JLabel label_10 = new JLabel("Όνομα");
		label_10.setBounds(0, 96, 100, 14);
		panelNewTexnikos.add(label_10);

		onomaTexnikouTF = new JTextField();
		onomaTexnikouTF.setBounds(105, 90, 86, 20);
		onomaTexnikouTF.setColumns(10);
		panelNewTexnikos.add(onomaTexnikouTF);

		JLabel label_11 = new JLabel("Επίθετο");
		label_11.setBounds(0, 121, 100, 14);
		panelNewTexnikos.add(label_11);

		epithetoTexnikouTF = new JTextField();
		epithetoTexnikouTF.setBounds(105, 115, 86, 20);
		epithetoTexnikouTF.setColumns(10);
		panelNewTexnikos.add(epithetoTexnikouTF);

		JLabel label_12 = new JLabel("Διεύθυνση");
		label_12.setBounds(0, 146, 100, 14);
		panelNewTexnikos.add(label_12);

		dieythinsiTexnikouTF = new JTextField();
		dieythinsiTexnikouTF.setBounds(105, 140, 86, 20);
		dieythinsiTexnikouTF.setColumns(10);
		panelNewTexnikos.add(dieythinsiTexnikouTF);

		JLabel label_13 = new JLabel("Τηλέφωνο");
		label_13.setBounds(0, 171, 100, 14);
		panelNewTexnikos.add(label_13);

		thlTexnikouTF = new JTextField();
		thlTexnikouTF.setBounds(105, 165, 86, 20);
		thlTexnikouTF.setColumns(10);
		panelNewTexnikos.add(thlTexnikouTF);

		JLabel label_14 = new JLabel("Αρ. Ταυτότητας");
		label_14.setBounds(0, 196, 100, 14);
		panelNewTexnikos.add(label_14);

		atTexnikouTF = new JTextField();
		atTexnikouTF.setBounds(105, 190, 86, 20);
		atTexnikouTF.setColumns(10);
		panelNewTexnikos.add(atTexnikouTF);

		
		//Panel Grammateas
		panelNewGrammateas = new JPanel();
		panelNewGrammateas.setBackground(new Color(255, 255, 224));
		cards.add(panelNewGrammateas, "New Grammateas");
		panelNewGrammateas.setLayout(null);

		label_36 = new JLabel("Εισαγωγή Στοιχείων Γραμματέα");
		label_36.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
		label_36.setBounds(129, 0, 364, 32);
		panelNewGrammateas.add(label_36);

		label_37 = new JLabel("Όνομα");
		label_37.setBounds(10, 89, 100, 14);
		panelNewGrammateas.add(label_37);

		gramOnomaTF = new JTextField();
		gramOnomaTF.setColumns(10);
		gramOnomaTF.setBounds(115, 83, 86, 20);
		panelNewGrammateas.add(gramOnomaTF);

		label_38 = new JLabel("Επίθετο");
		label_38.setBounds(10, 114, 100, 14);
		panelNewGrammateas.add(label_38);

		label_39 = new JLabel("Διεύθυνση");
		label_39.setBounds(10, 139, 100, 14);
		panelNewGrammateas.add(label_39);

		gramDieythinsiTF = new JTextField();
		gramDieythinsiTF.setColumns(10);
		gramDieythinsiTF.setBounds(115, 133, 86, 20);
		panelNewGrammateas.add(gramDieythinsiTF);

		gramEpithetoTF = new JTextField();
		gramEpithetoTF.setColumns(10);
		gramEpithetoTF.setBounds(115, 108, 86, 20);
		panelNewGrammateas.add(gramEpithetoTF);

		label_40 = new JLabel("Τηλέφωνο");
		label_40.setBounds(10, 164, 100, 14);
		panelNewGrammateas.add(label_40);

		gramThlTF = new JTextField();
		gramThlTF.setColumns(10);
		gramThlTF.setBounds(115, 158, 86, 20);
		panelNewGrammateas.add(gramThlTF);

		gramAtTF = new JTextField();
		gramAtTF.setColumns(10);
		gramAtTF.setBounds(115, 183, 86, 20);
		panelNewGrammateas.add(gramAtTF);

		label_41 = new JLabel("Αρ. Ταυτότητας");
		label_41.setBounds(10, 189, 100, 14);
		panelNewGrammateas.add(label_41);

	

		/************************************************************************************
		 * Ta buttons ths efarmoghs
		 * 
		 ************************************************************************************/

		// ***************************Button eisagwgh pelati******************************//
		addpelatiButton = new JButton("Εισαγωγή");
		addpelatiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eisagwgiPelati(); // call eisagwgi pelati

			}
		});
		addpelatiButton.setBounds(165, 297, 110, 23);
		panelEgrPelati.add(addpelatiButton);

		// ***********************Button katharismos formas pelati****************************//
		clearpelatiFormButton = new JButton("Καθαρισμός");
		clearpelatiFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onomaTextField.setText("");
				epithetoTextField.setText("");
				dieythinsiTextField.setText("");
				thlTextField.setText("");
				ATTextField.setText("");
				asfalTextField.setText("");
			}
		});
		clearpelatiFormButton.setBounds(302, 297, 126, 23);
		panelEgrPelati.add(clearpelatiFormButton);

		// ***********************Button Anazitisi pelati gia tropopoihsh************************** //
		searchTropButton = new JButton("Αναζήτηση");
		searchTropButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anazitisiPelatiTrop();
			}
		});
		searchTropButton.setBounds(131, 83, 105, 23);
		panelTropPelati.add(searchTropButton);

		// ***************************Button tropopoihsh pelati**********************************//
		tropopoihshButton = new JButton("Τροποίηση");
		tropopoihshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tropopoihshPelati();
			}
		});
		tropopoihshButton.setBounds(200, 297, 118, 23);
		panelTropPelati.add(tropopoihshButton);

		
		// ********************************Button Eisagwghs Stoixeiwn Texnikou**************************************//
		esgTexnikosButton = new JButton("Εισαγωγή");
		esgTexnikosButton.setBounds(171, 253, 79, 23);
		esgTexnikosButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eisagwghTexnikou();

			}
		});
		panelNewTexnikos.add(esgTexnikosButton);

		// *******************************Button katharismos formas Texnikou**************************//
		clearTexnikosFormButton = new JButton("Καθαρισμός");
		clearTexnikosFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onomaTexnikouTF.setText("");
				epithetoTexnikouTF.setText("");
				dieythinsiTexnikouTF.setText("");
				thlTexnikouTF.setText("");
				atTexnikouTF.setText("");
			}
		});
		clearTexnikosFormButton.setBounds(255, 253, 126, 23);
		panelNewTexnikos.add(clearTexnikosFormButton);

		
	

		//****************************Button eisagwghs Grammatea*************************************************//
		eisagwsiGramButton = new JButton("Εισαγωγή");
		eisagwsiGramButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				eisagwgiGrammatea();
			}
		});
		eisagwsiGramButton.setBounds(170, 297, 79, 23);
		panelNewGrammateas.add(eisagwsiGramButton);
		
		//*****************************Button katharismos formas grammates***************************************//
		clearGrammForm = new JButton("Καθαρισμός");
		clearGrammForm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				gramOnomaTF.setText("");
				gramEpithetoTF.setText("");
				gramDieythinsiTF.setText("");
				gramThlTF.setText("");
				gramAtTF.setText("");
			}
		});
		clearGrammForm.setBounds(254, 297, 126, 23);
		panelNewGrammateas.add(clearGrammForm);
	}

	/*********************************************************************************
	 * Methodoi Efarmoghs *
	 *********************************************************************************/
	
//******************************Methodos eisagwgh Pelati*************************************//
	public void eisagwgiPelati() {
		
		flag = true;
		onoma = onomaTextField.getText();
		epitheto = epithetoTextField.getText();
		dieythinsi = dieythinsiTextField.getText();
		thl = thlTextField.getText();
		AT = ATTextField.getText();
		asfalistiki = asfalTextField.getText();
		for (Customer element : customers) {
			if (AT.compareTo(element.getAT()) == 0) {
				JOptionPane.showMessageDialog(cards,
						"Ο αριθμός ταυτότητας του πελάτη υπάρχει ήδη!",
						"Ο πελάτης υπάρχει!", JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		}
		if (flag == true) {
			Customer c = new Customer(onoma, epitheto, dieythinsi, thl, AT,
					asfalistiki);
			customers.add(c);
			JOptionPane.showMessageDialog(cards, "Επιτυχής καταχώρηση πελάτη!",
					"Ο πελάτης καταχωρήθηκε", JOptionPane.INFORMATION_MESSAGE);
			clearpelatiFormButton.doClick();

		}
	}

	// *********************************Methodos anazitisi pelati gia tropopoihsh************************************************//
	public void anazitisiPelatiTrop() {
		flag = false;
		tropPelatis = tropPelatisTF.getText();
		// anazitish stous pelates kai ektypwsh autou pou zhthike
		for (Customer element : customers) {
			if (tropPelatis.compareTo(element.getAT()) == 0) {
				onomaTropTF.setText(element.getOnoma());
				epithetoTropTF.setText(element.getEpitheto());
				dieythinsiTropTF.setText(element.getDieythinsi());
				thlTropTF.setText(element.getThl());
				ATTropTF.setText(element.getAT());
				flag = true;
			}
		}

		// an o pelatis de vrethike msg
		if (flag == false) {
			JOptionPane.showMessageDialog(cards,
					"Τα στοιχεία που δώσατε δεν αντιστοιχούν σε πελάτη",
					"Ο πελάτης δε βρέθηκε!", JOptionPane.ERROR_MESSAGE);
		}
	}

	// *********************************Methodos Tropopoihshs Pelati***********************************************************//
	public void tropopoihshPelati() {
		flag = false;
		tropPelatis = tropPelatisTF.getText();
		// anazitish stous pelates kai emfanish gia tropopoihsh
		for (Customer element : customers) {
			if (tropPelatis.compareTo(element.getAT()) == 0) {
				onoma = onomaTropTF.getText();
				element.setOnoma(onoma);
				epitheto = epithetoTropTF.getText();
				element.setEpitheto(epitheto);
				dieythinsi = dieythinsiTropTF.getText();
				element.setDieythinsi(dieythinsi);
				thl = thlTropTF.getText();
				element.setThl(thl);
				AT = ATTropTF.getText();
				element.setAT(AT);
				flag = true;
			}
		}

		// an o pelatis de vrethike msg
		if (flag == false) {
			JOptionPane.showMessageDialog(cards,
					"Τα στοιχεία που δώσατε δεν αντιστοιχούν σε πελάτη",
					"Ο πελάτης δε βρέθηκε!", JOptionPane.ERROR_MESSAGE);
		}
	}

	
	// *********************************Methodos Eisagwghs Texnikou**********************************************************//
	public void eisagwghTexnikou() {
		flag=true;
		onoma = onomaTexnikouTF.getText();
		epitheto = epithetoTexnikouTF.getText();
		dieythinsi = dieythinsiTexnikouTF.getText();
		thl = thlTexnikouTF.getText();
		AT = atTexnikouTF.getText();
		int eidikotita = eidikotitaTexnikouCB.getSelectedIndex();
		
		for (Employee emplo : employees) {
			if (AT.compareTo(emplo.getAT()) == 0) {
				JOptionPane.showMessageDialog(cards,
						"Ο αριθμός ταυτότητας τεχνικού υπάρχει ήδη!",
						"Ο τεχνικός υπάρχει!", JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		}
		if (flag == true) {
		// Dhmiourgeia texnikou
		Texnikos t = null;
		// An einai Hlektrologos
		if (eidikotita == 0) {
			t = new Hlektrologos(onoma, epitheto, dieythinsi, thl, AT);
		}
		// An einai Mhxanikow
		else if (eidikotita == 1) {
			t = new Mixanikos(onoma, epitheto, dieythinsi, thl, AT);

		}
		// An einai fanopoios
		else if (eidikotita == 2) {
			t = new Fanopoios(onoma, epitheto, dieythinsi, thl, AT);
		}
		employees.add(t);
		JOptionPane.showMessageDialog(cards,
				"Ο τεχνικός καταχωρήθηκε.",
				"Καταχώρηση τεχνικού", JOptionPane.INFORMATION_MESSAGE);
		
		}
	}
//*************************************Methodos Eisagwghs Grammatea***********************************//
	public void eisagwgiGrammatea() {
		// Methodos eisagwgh Pelati
		flag = true;
		onoma = gramOnomaTF.getText();
		epitheto = gramEpithetoTF.getText();
		dieythinsi = gramDieythinsiTF.getText();
		thl = gramThlTF.getText();
		AT = gramAtTF.getText();
		
		for (Employee emplo : employees) {
			if (AT.compareTo(emplo.getAT()) == 0) {
				JOptionPane.showMessageDialog(cards,
						"Ο αριθμός ταυτότητας Γραμματέα υπάρχει ήδη!",
						"Ο/Η Γραμματέας υπάρχει!", JOptionPane.ERROR_MESSAGE);
				flag = false;
			}
		}
		if (flag == true) {
			Grammateas g = new Grammateas(onoma, epitheto, dieythinsi, thl, AT);
			employees.add(g);
			JOptionPane.showMessageDialog(cards, "Επιτυχής καταχώρηση γραμματέα!",
					"Ο/Η γραμματέας καταχωρήθηκε", JOptionPane.INFORMATION_MESSAGE);
			clearGrammForm.doClick();

		}
	}
	
	


		

	/***************************************************************************
	 * Energeies twn menu ths efarmoghs
	 * 
	 ****************************************************************************/
	// Energeies twn Menu
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == egrPelatiMenuItem) {
			// Katharimos twv textfields
			 clearpelatiFormButton.doClick();
			((CardLayout) cards.getLayout()).show(cards, "Eggrafi Pelati");
		} else if (e.getSource() == tropPelatiMenuItem) {
			
			((CardLayout) cards.getLayout()).show(cards, "Tropopoihsh Pelati");
		} else if (e.getSource() == printPelatiMenuItem) {
						
		} else if (e.getSource() == newTexnikosMenuItem) {
			((CardLayout) cards.getLayout()).show(cards, "New Texnikos");
					
		} else if (e.getSource() == newGrammateasMenuItem) {
			((CardLayout) cards.getLayout()).show(cards, "New Grammateas");
		} else if (e.getSource() == programErgMenuItem) {
			
		} else if (e.getSource() == ektypwsiErgMenuItem) {
			

		} else if (e.getSource() == diekperaiwshErgMenuItem) {
			
		} else if (e.getSource() == saveAllMenuItem) {
			
		} else if (e.getSource() == exodosMenuItem) {
			System.out.println("Exodos");
			Object[] options = { "Ναί", "Όχι" };
			int option = JOptionPane.showOptionDialog(cards,
					"Θέλετε να κλείσετε την εφαρμογή;", "Έξοδος",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
					null, options, options[0]);
			if (option == JOptionPane.OK_OPTION) {
				System.exit(0);
			}
		}
	}
}
