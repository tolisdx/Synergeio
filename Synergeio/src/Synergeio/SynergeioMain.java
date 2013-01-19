package Synergeio;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SynergeioMain extends JFrame implements ActionListener {

	private JPanel cards, panelEgrPelati, panelTropPelati,panelEktPelati, panelNewTexnikos,
	panelNewGrammateas,panelDiathesimotita, panelProgramErgasia, panelEktypwshErg;
private JMenuBar menuBar;
private JMenu pelatis, ypalliloi, kataxwrhshYpallilwn, ergasies, exit,
	save;
private JMenuItem egrPelatiMenuItem, tropPelatiMenuItem,
	printPelatiMenuItem, saveAllMenuItem, exodosMenuItem,
	newTexnikosMenuItem, diathesimotitaMenuItem, newGrammateasMenuItem,
	programErgMenuItem, ektypwsiErgMenuItem, diekperaiwshErgMenuItem;
private JTextField onomaTextField, epithetoTextField, dieythinsiTextField,
	thlTextField, ATTextField, tropPelatisTF, onomaprintTF,
	epithetoprintTF, dieythinsiprintTF, thlprintTF, ATprintTF,
	printPelatisTF, onomaTropTF, epithetoTropTF, dieythinsiTropTF,
	thlTropTF, ATTropTF, onomaTexnikouTF, epithetoTexnikouTF,
	dieythinsiTexnikouTF, thlTexnikouTF, atTexnikouTF, meraTF, mhnasTF,
	etosTF, apoWraTF, apoLeptaTF, ewsWraTF, ewsLeptaTF, atProgErgTF,
	onomaTF, epithetoTF, asfalTextField, atTexnikouPrintTF, onomaTexnikouPrintTF,
	epithetoTexnikouPrintTF,atDiathesimotitaTF,onomaDiathesimotitaTF,
	epithetoDiathesimotitaTF,gramOnomaTF,gramDieythinsiTF,gramEpithetoTF,
	gramThlTF,gramAtTF;
private JButton addpelatiButton, clearpelatiFormButton, tropopoihshButton,
	printPelatisButton, esgTexnikosButton,
	anazitisiatDiathesimotitaButton, addDiathesimotitaButton,
	searchAtProgErgButton, addErgasiaButton, printErgButton, searchTropButton, clearTexnikosFormButton,
	 eisagwsiGramButton,clearGrammForm;
private String onoma, epitheto, dieythinsi, thl, AT, asfalistiki,
	printPelatis, tropPelatis, atProgErg;
private Boolean flag, flag2;
private JComboBox<String> eidikotitaTexnikouCB, eidosErgasiasCB;
private JLabel synergeioLB,onomaPelatiLB,epithetoPelatiLB,thlPelatiLB,dieythinsiPelatiLB,
	atPelatiLB,asfalistikhLB,tropPelatiLB,onomaTropLB,epithetoTropLB,dieythinsiTropLB,
	thlTropLB,atTropLB,onomaPrintLB,epithetoPrintLB,dieythinsiPrintLB,thlPrintLB,atPrintLB,
	printLB,labelDiathesimotita,labelTexnikos,label_36,label_37, label_33, label_34,label_38,label_39,label_40,label_41;
private JTextArea printErgtextArea;

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

		//Panel Ektypwshs Pelati
		panelEktPelati = new JPanel();
		panelEktPelati.setBackground(new Color(255, 255, 224));
		cards.add(panelEktPelati, "Ektypwsi Pelati");
		panelEktPelati.setLayout(null);

		onomaPrintLB = new JLabel("Όνομα");
		onomaPrintLB.setBounds(10, 126, 65, 14);
		panelEktPelati.add(onomaPrintLB);

		onomaprintTF = new JTextField();
		onomaprintTF.setEditable(false);
		onomaprintTF.setColumns(10);
		onomaprintTF.setBounds(96, 123, 86, 20);
		panelEktPelati.add(onomaprintTF);

		epithetoprintTF = new JTextField();
		epithetoprintTF.setEditable(false);
		epithetoprintTF.setColumns(10);
		epithetoprintTF.setBounds(96, 149, 86, 20);
		panelEktPelati.add(epithetoprintTF);

		epithetoPrintLB = new JLabel("Επίθετο");
		epithetoPrintLB.setBounds(10, 152, 46, 14);
		panelEktPelati.add(epithetoPrintLB);

		dieythinsiPrintLB = new JLabel("Διεύθυνση");
		dieythinsiPrintLB.setBounds(10, 190, 65, 14);
		panelEktPelati.add(dieythinsiPrintLB);

		dieythinsiprintTF = new JTextField();
		dieythinsiprintTF.setEditable(false);
		dieythinsiprintTF.setColumns(10);
		dieythinsiprintTF.setBounds(96, 187, 86, 20);
		panelEktPelati.add(dieythinsiprintTF);

		thlprintTF = new JTextField();
		thlprintTF.setEditable(false);
		thlprintTF.setColumns(10);
		thlprintTF.setBounds(96, 229, 86, 20);
		panelEktPelati.add(thlprintTF);

		thlPrintLB = new JLabel("Τηλέφωνο");
		thlPrintLB.setBounds(10, 232, 65, 14);
		panelEktPelati.add(thlPrintLB);

		atPrintLB = new JLabel("Αρ. Ταυτότητας");
		atPrintLB.setBounds(10, 274, 76, 14);
		panelEktPelati.add(atPrintLB);

		ATprintTF = new JTextField();
		ATprintTF.setEditable(false);
		ATprintTF.setColumns(10);
		ATprintTF.setBounds(96, 271, 86, 20);
		panelEktPelati.add(ATprintTF);

		printLB = new JLabel("Εισάγετε τον Αρ. Ταυτότητας Πελάτη που θέλετε να εκτυπώσετε :");
		printLB.setBounds(10, 57, 409, 14);
		panelEktPelati.add(printLB);

		printPelatisTF = new JTextField();
		printPelatisTF.setColumns(10);
		printPelatisTF.setBounds(10, 76, 111, 20);
		panelEktPelati.add(printPelatisTF);
				
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

		//Panel Diathesimotita
				panelDiathesimotita = new JPanel();
				panelDiathesimotita.setBackground(new Color(255, 255, 224));
				cards.add(panelDiathesimotita, "Diathesimotita Texnikou");
				panelDiathesimotita.setLayout(null);

				JLabel label_17 = new JLabel("Διαθεσιμότητα Τεχνικού");
				label_17.setFont(new Font("Book Antiqua", Font.PLAIN, 22));
				label_17.setBounds(149, 0, 281, 37);
				panelDiathesimotita.add(label_17);

				atDiathesimotitaTF = new JTextField();
				atDiathesimotitaTF.setColumns(10);
				atDiathesimotitaTF.setBounds(10, 78, 111, 20);
				panelDiathesimotita.add(atDiathesimotitaTF);

				labelTexnikos = new JLabel("Τεχνικός :");
				labelTexnikos.setBounds(10, 114, 60, 14);
				panelDiathesimotita.add(labelTexnikos);

				onomaDiathesimotitaTF = new JTextField();
				onomaDiathesimotitaTF.setEditable(false);
				onomaDiathesimotitaTF.setColumns(10);
				onomaDiathesimotitaTF.setBounds(62, 109, 86, 20);
				panelDiathesimotita.add(onomaDiathesimotitaTF);

				epithetoDiathesimotitaTF = new JTextField();
				epithetoDiathesimotitaTF.setEditable(false);
				epithetoDiathesimotitaTF.setColumns(10);
				epithetoDiathesimotitaTF.setBounds(158, 109, 99, 20);
				panelDiathesimotita.add(epithetoDiathesimotitaTF);

				labelDiathesimotita = new JLabel(
						"Εισάγετε τον Αρ. Ταυτότητας Τεχνικού για να προσθέσετε νέα διαθεσιμότητα :");
				labelDiathesimotita.setBounds(10, 59, 467, 14);
				panelDiathesimotita.add(labelDiathesimotita);

				meraTF = new JTextField();
				meraTF.setBounds(116, 157, 39, 20);
				panelDiathesimotita.add(meraTF);
				meraTF.setColumns(10);

				JLabel lblNewLabel_4 = new JLabel("ΗΗ/ΜΜ/ΕΕΕΕ");
				lblNewLabel_4.setBounds(10, 160, 96, 14);
				panelDiathesimotita.add(lblNewLabel_4);

				mhnasTF = new JTextField();
				mhnasTF.setColumns(10);
				mhnasTF.setBounds(184, 157, 39, 20);
				panelDiathesimotita.add(mhnasTF);

				etosTF = new JTextField();
				etosTF.setColumns(10);
				etosTF.setBounds(244, 157, 53, 20);
				panelDiathesimotita.add(etosTF);

				JLabel label_18 = new JLabel("/");
				label_18.setBounds(163, 160, 11, 14);
				panelDiathesimotita.add(label_18);

				JLabel label_19 = new JLabel("/");
				label_19.setBounds(233, 160, 11, 14);
				panelDiathesimotita.add(label_19);

				JLabel label_20 = new JLabel("πχ. 25/ 01 /2013");
				label_20.setBounds(321, 160, 96, 14);
				panelDiathesimotita.add(label_20);

				JLabel label_21 = new JLabel("Από Ώρα (ΩΩ:ΛΛ)");
				label_21.setBounds(10, 202, 96, 14);
				panelDiathesimotita.add(label_21);

				apoWraTF = new JTextField();
				apoWraTF.setBounds(116, 199, 23, 20);
				panelDiathesimotita.add(apoWraTF);
				apoWraTF.setColumns(10);

				JLabel label_22 = new JLabel(":");
				label_22.setBounds(149, 202, 6, 14);
				panelDiathesimotita.add(label_22);

				apoLeptaTF = new JTextField();
				apoLeptaTF.setColumns(10);
				apoLeptaTF.setBounds(159, 199, 23, 20);
				panelDiathesimotita.add(apoLeptaTF);

				JLabel label_23 = new JLabel("Έως Ώρα (ΩΩ:ΛΛ)");
				label_23.setBounds(10, 245, 96, 14);
				panelDiathesimotita.add(label_23);

				JLabel label_24 = new JLabel(":");
				label_24.setBounds(149, 242, 6, 14);
				panelDiathesimotita.add(label_24);

				ewsWraTF = new JTextField();
				ewsWraTF.setColumns(10);
				ewsWraTF.setBounds(116, 239, 23, 20);
				panelDiathesimotita.add(ewsWraTF);

				ewsLeptaTF = new JTextField();
				ewsLeptaTF.setColumns(10);
				ewsLeptaTF.setBounds(159, 239, 23, 20);
				panelDiathesimotita.add(ewsLeptaTF);

				JLabel label_25 = new JLabel("πχ. 16:30");
				label_25.setBounds(192, 245, 64, 14);
				panelDiathesimotita.add(label_25);

				JLabel label_26 = new JLabel("πχ. 16:30");
				label_26.setBounds(192, 202, 64, 14);
				panelDiathesimotita.add(label_26);
		
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

		//Panel programmatismos ergasias
		panelProgramErgasia = new JPanel();
		panelProgramErgasia.setBackground(new Color(255, 255, 224));
		cards.add(panelProgramErgasia, "Programmatismos Ergasias");
		panelProgramErgasia.setLayout(null);

		JLabel label_27 = new JLabel("Εισάγετε τον Αρ. Ταυτότητας Πελάτη για τον οποίο θα προγραμματιστεί εργασία :");
		label_27.setBounds(10, 79, 409, 14);
		panelProgramErgasia.add(label_27);

		atProgErgTF = new JTextField();
		atProgErgTF.setColumns(10);
		atProgErgTF.setBounds(10, 98, 111, 20);
		panelProgramErgasia.add(atProgErgTF);

		JLabel label_28 = new JLabel("Επιλογή Εργασίας :");
		label_28.setBounds(10, 181, 99, 14);
		panelProgramErgasia.add(label_28);

		eidosErgasiasCB = new JComboBox<String>();
		eidosErgasiasCB.setModel(new DefaultComboBoxModel<String>(new String[] {
						"Αλλαγή Λαδιών", "Έλεγχος Φώτων", "Αλλαγή Φτερού" }));
		eidosErgasiasCB.setBounds(136, 178, 117, 20);
		panelProgramErgasia.add(eidosErgasiasCB);

		JLabel label_29 = new JLabel("Πελάτης :");
		label_29.setBounds(10, 134, 60, 14);
		panelProgramErgasia.add(label_29);

		onomaTF = new JTextField();
		onomaTF.setEditable(false);
		onomaTF.setBounds(62, 129, 86, 20);
		panelProgramErgasia.add(onomaTF);
		onomaTF.setColumns(10);

		epithetoTF = new JTextField();
		epithetoTF.setEditable(false);
		epithetoTF.setColumns(10);
		epithetoTF.setBounds(158, 129, 99, 20);
		panelProgramErgasia.add(epithetoTF);

		//Panel ektypwsh ergasias
		panelEktypwshErg = new JPanel();
		panelEktypwshErg.setBackground(new Color(255, 255, 224));
		cards.add(panelEktypwshErg, "Ektypwsh Ergasiwn");
		panelEktypwshErg.setLayout(null);

		label_33 = new JLabel(
				"Εισάγετε τον Αρ. Ταυτότητας Τεχνικού για να τυπώσετε τις προγραμματισμένες εργασίες του :");
		label_33.setBounds(10, 34, 467, 14);
		panelEktypwshErg.add(label_33);

		atTexnikouPrintTF = new JTextField();
		atTexnikouPrintTF.setColumns(10);
		atTexnikouPrintTF.setBounds(10, 53, 111, 20);
		panelEktypwshErg.add(atTexnikouPrintTF);

		label_34 = new JLabel("Τεχνικός :");
		label_34.setBounds(10, 89, 60, 14);
		panelEktypwshErg.add(label_34);

		onomaTexnikouPrintTF = new JTextField();
		onomaTexnikouPrintTF.setEditable(false);
		onomaTexnikouPrintTF.setColumns(10);
		onomaTexnikouPrintTF.setBounds(62, 84, 86, 20);
		panelEktypwshErg.add(onomaTexnikouPrintTF);

		epithetoTexnikouPrintTF = new JTextField();
		epithetoTexnikouPrintTF.setEditable(false);
		epithetoTexnikouPrintTF.setColumns(10);
		epithetoTexnikouPrintTF.setBounds(158, 84, 99, 20);
		panelEktypwshErg.add(epithetoTexnikouPrintTF);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 137, 594, 183);
		panelEktypwshErg.add(scrollPane);

		printErgtextArea = new JTextArea();
		scrollPane.setViewportView(printErgtextArea);
		printErgtextArea.setAutoscrolls(false);
		printErgtextArea.setEditable(false);
		printErgtextArea.setFont(new Font("Arial Black", Font.PLAIN, 12));

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

		// ******************************Button Ektypwsh pelati***********************************//
				printPelatisButton = new JButton("Εκτύπωση");
				printPelatisButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						ektypwshPelati();
					}
				});
				printPelatisButton.setBounds(136, 75, 102, 23);
				panelEktPelati.add(printPelatisButton);
				
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

		// *******************************Button kataxwrish Diathesimotitas Texnikou***************************//
				addDiathesimotitaButton = new JButton("Καταχώρηση");
				addDiathesimotitaButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						kataxwrhshDiathesimotitas();
					}
				});
				addDiathesimotitaButton.setBounds(208, 297, 117, 23);
				panelDiathesimotita.add(addDiathesimotitaButton);

				// ***************************Button anazhthsh AT texnikou gia Diathesimotita*****************************//
				anazitisiatDiathesimotitaButton = new JButton("Αναζήτηση");
				anazitisiatDiathesimotitaButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						anazitisiAtDiathseimotita();
					}
				});
				anazitisiatDiathesimotitaButton.setBounds(131, 77, 117, 23);
				panelDiathesimotita.add(anazitisiatDiathesimotitaButton);
	

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
	
	
	// ***************************Button anazhthsh AT pelati gia programmatismo ergasias*********************//
			// anazhthsh AT pelati gia programmatismo ergasias
			searchAtProgErgButton = new JButton("Αναζήτηση");
			searchAtProgErgButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					anazitisiPelatiProgram();
				}
			});
			searchAtProgErgButton.setBounds(136, 97, 117, 23);
			panelProgramErgasia.add(searchAtProgErgButton);

			// *******************************Button prosthiki ergasias ******************************//
			addErgasiaButton = new JButton("Καταχώρηση Εργασίας");
			addErgasiaButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					kataxwrhshErgasias();
				}

			});
			addErgasiaButton.setBounds(191, 297, 167, 23);
			panelProgramErgasia.add(addErgasiaButton);
	
	
	// ********************************Button ektypwsh ergasiwn ******************************//
			printErgButton = new JButton("Εκτύπωση");
			printErgButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ektypwshErgasiwn();
				}
			});
			printErgButton.setBounds(205, 113, 111, 23);
			panelEktypwshErg.add(printErgButton);
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

	// **********************************Methodos Ektypwsh Pelati*************************************************************//
		public void ektypwshPelati() {
			// εκτύπωση στοιχείων πελάτη
			flag = false;
			printPelatis = printPelatisTF.getText();
			// αναζήτηση στους πελάτες και εκτύπωση αυτού που ζητήθηκε
			for (Customer element : customers) {
				if (printPelatis.compareTo(element.getAT()) == 0) {
					onomaprintTF.setText(element.getOnoma());
					epithetoprintTF.setText(element.getEpitheto());
					dieythinsiprintTF.setText(element.getDieythinsi());
					thlprintTF.setText(element.getThl());
					ATprintTF.setText(element.getAT());

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
					"Ο τεχνικός καταχωρήθηκε.Προσθέστε τις διαθέσιμες ώρες του.",
					"Καταχώρηση τεχνικού", JOptionPane.INFORMATION_MESSAGE);
			diathesimotitaTexikou = t;
			labelDiathesimotita.setVisible(false);
			atDiathesimotitaTF.setVisible(false);
			labelTexnikos.setVisible(false);
			onomaDiathesimotitaTF.setVisible(false);
			epithetoDiathesimotitaTF.setVisible(false);
			anazitisiatDiathesimotitaButton.setVisible(false);
			((CardLayout) cards.getLayout()).show(cards, "Diathesimotita Texnikou");
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
	
	// ************************************Methodos Kataxwrhshs Diathesimotitas***********************************//
		public void kataxwrhshDiathesimotitas() {

			// Calendar cal=new GregorianCalendar();
			int etos = Integer.parseInt(etosTF.getText());
			int mhnas = Integer.parseInt(mhnasTF.getText()) - 1; // sth Java oi mhnes xekinoun apo 0
																	// gi auto afairoume -1
			int mera = Integer.parseInt(meraTF.getText());
			int wraApo = Integer.parseInt(apoWraTF.getText());
			int leptaApo = Integer.parseInt(apoLeptaTF.getText());
			int wraEos = Integer.parseInt(ewsWraTF.getText());
			int leptaEos = Integer.parseInt(ewsLeptaTF.getText());

			// dhmioyrgia diathesimotitas gia ton texniti
			Diathesimotita a = new Diathesimotita(etos, mhnas, mera, wraApo,
					leptaApo, wraEos, leptaEos);
			diathesimotitaTexikou.addToDiathesimotita(a);
			JOptionPane.showMessageDialog(cards,
					"Επιτυχής Καταχώρηση Διαθεσιμότητας.",
					"Καταχώρηση Διαθεσιμότητας", JOptionPane.INFORMATION_MESSAGE);
			Object[] options = { "Ναί", "Όχι" };
			int option = JOptionPane
					.showOptionDialog(
							cards,
							"Θέλετε να καταχωρήσετε άλλη ημερομηνία διαθεσιμότητας για τον τεχνικό;",
							"Νέα καταχώρηση διαθεσιμότητας",
							JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (option == JOptionPane.OK_OPTION) {
				etosTF.setText("");
				mhnasTF.setText("");
				meraTF.setText("");
				apoWraTF.setText("");
				apoLeptaTF.setText("");
				ewsWraTF.setText("");
				ewsLeptaTF.setText("");
				((CardLayout) cards.getLayout()).show(cards,
						"Diathesimotita Texnikou");
			} else {
				clearTexnikosFormButton.doClick();
				etosTF.setText("");
				mhnasTF.setText("");
				meraTF.setText("");
				apoWraTF.setText("");
				apoLeptaTF.setText("");
				ewsWraTF.setText("");
				ewsLeptaTF.setText("");
				atDiathesimotitaTF.setText("");
				onomaDiathesimotitaTF.setText("");
				epithetoDiathesimotitaTF.setText("");
				((CardLayout) cards.getLayout()).show(cards, "Arxikh");
			}
		}
	
	// **********************************Methodos Anazhthshs AT Texnikou gia Diathesimotita*********************************//
		public void anazitisiAtDiathseimotita() {
			flag = false;
			String at = atDiathesimotitaTF.getText();
			// Texnikos t = null;
			// anazhthsh texnikou
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i) instanceof Texnikos) {
					if (employees.get(i).getAT().equals(at)) {
						diathesimotitaTexikou = (Texnikos) employees.get(i);
						onomaDiathesimotitaTF.setText(employees.get(i).getOnoma());
						epithetoDiathesimotitaTF.setText(employees.get(i)
								.getEpitheto());
						flag = true;
						break;
					}
				}
			}
			if (flag == false) {
				JOptionPane.showMessageDialog(cards,
						"Τα στοιχεία που δώσατε δεν αντιστοιχούν σε Τεχνικό",
						"Ο τεχνικός δε βρέθηκε!", JOptionPane.ERROR_MESSAGE);
			}
		}

		// ************************************Methodos Anazitishs AT Pelati gia programmatismo ergasias*************************//
		public void anazitisiPelatiProgram() {
			// anazitish pelati gia kataxwrhsh ergasias
			flag = false;
			atProgErg = atProgErgTF.getText();
			// Customer c = null;
			// αναζήτηση στους πελάτες και εκτύπωση αυτού που ζητήθηκε
			for (Customer element : customers) {
				if (atProgErg.compareTo(element.getAT()) == 0) {
					onomaTF.setText(element.getOnoma());
					epithetoTF.setText(element.getEpitheto());
					// c=(Customer) element;
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

		// **********************************Methodos Kataxwrhshs Ergasias********************************************************//
		public void kataxwrhshErgasias() {
			// kataxwrhsh ergasias
			flag = false;
			flag2 = false;
			atProgErg = atProgErgTF.getText();
			Customer c = null;
			// anazitish stous pelates
			for (int i = 0; i < customers.size(); i++) {
				if (customers.get(i).getAT().equals(atProgErg)) {
					c = customers.get(i);
					flag = true;
					break;
					/*
					 * for (Customer element : customers) { if
					 * (atProgErg.compareTo(element.getAT()) == 0) { c = (Customer)
					 * element; flag = true;
					 */
				}
			}
			// an o pelatis vrethike
			if (flag == true) {
				Texnikos t;
				Ergasia erg = null;
				if (employees.isEmpty()) {
					JOptionPane.showMessageDialog(cards,
							"Δεν υπάρχουν τεχνικοί στο συνεργείο.",
							"Δε βρέθηκε τεχικός", JOptionPane.INFORMATION_MESSAGE);
				} else {
					for (Employee emplo : employees) {
						if (emplo instanceof Texnikos) { // an o ypallhlos einai
															// texnikos
							System.out.println(emplo.getAT());
							t = (Texnikos) emplo;
							Vector<Diathesimotita> av = t.getDiathesimotita();
							if (!av.isEmpty()) {
								flag2 = false;
								// if(av.elements().)
								for (int i = 0; i < av.size(); i++) {
									// av.elements()
									Calendar c1 = av.get(i).getGC1();
									int h1 = c1.get(Calendar.HOUR_OF_DAY);
									int m1 = c1.get(Calendar.MINUTE);

									if (eidosErgasiasCB.getSelectedIndex() == 0)
										// programmatismos allagis ladiwn
										erg = new AllagiLadiwn(
												c1.get(Calendar.YEAR),
												c1.get(Calendar.MONTH),
												c1.get(Calendar.DAY_OF_MONTH), h1,
												m1);
									else if (eidosErgasiasCB.getSelectedIndex() == 1)
										// programmatismos allagis fwtwn
										erg = new AllagiFwtwn(
												c1.get(Calendar.YEAR),
												c1.get(Calendar.MONTH),
												c1.get(Calendar.DAY_OF_MONTH), h1,
												m1);
									else if (eidosErgasiasCB.getSelectedIndex() == 2)
										// programmatismos allagis fterou
										erg = new AllagiFterou(
												c1.get(Calendar.YEAR),
												c1.get(Calendar.MONTH),
												c1.get(Calendar.DAY_OF_MONTH), h1,
												m1);

									// prosthiki ergasias se pelati kai texniko
									c.addErgasia(erg);
									t.addErgasia(erg);
									System.out.println("tis prosthesa");
									// diagrafi diathesimotitas apo ton texniko
									t.removeFromDiathesimotita(i);
									// break;
								}
								JOptionPane.showMessageDialog(cards,
										"Η εργασία καταχωρήθηκε. ", "",
										JOptionPane.INFORMATION_MESSAGE);
								break;
							} else {
								flag2 = true;

							}

						}

					}
					if (flag2 == true) {
						JOptionPane
								.showMessageDialog(
										cards,
										"Δεν υπάρχει διαθέσιμος τεχνικός να εκτελέσει την εργασία.",
										"Δε βρέθηκε διαθέσιμος τεχικός",
										JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
			// an o pelatis de vrethike msg
			if (flag == false) {
				JOptionPane.showMessageDialog(cards,
						"Τα στοιχεία που δώσατε δεν αντιστοιχούν σε πελάτη",
						"Ο πελάτης δε βρέθηκε!", JOptionPane.ERROR_MESSAGE);
			}
		}

		// *********************************Methodos Ektypwsh Ergasiwn**************************************************//

		public void ektypwshErgasiwn() {
			// ektypwsh progrmmatismenw ergasiwn
			printErgtextArea.setText("");
			flag = false;
			String at = atTexnikouPrintTF.getText();
			Texnikos t = null;
			// anazitish texnikou
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i) instanceof Texnikos) {
					if (employees.get(i).getAT().equals(at)) {
						t = (Texnikos) employees.get(i);
						onomaTexnikouPrintTF.setText(employees.get(i).getOnoma());
						epithetoTexnikouPrintTF.setText(employees.get(i).getEpitheto());
						flag = true;
						break;
					}
				}
			}
			// an o texnikos vrethike ektypwsh twn ergasiwn pou anatehikan
			if (flag == true) {
				Vector<Ergasia> v = t.getErgasies();
				for (int j = 0; j < v.size(); j++) {
					printErgtextArea.append(v.get(j).toString() + "\n");
				}
			} else
				JOptionPane.showMessageDialog(cards,
						"Τα στοιχεία που δώσατε δεν αντιστοιχούν σε Τεχνικό",
						"Ο τεχνικός δε βρέθηκε!", JOptionPane.ERROR_MESSAGE);
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
			((CardLayout) cards.getLayout()).show(cards, "Ektypwsi Pelati");			
		} else if (e.getSource() == newTexnikosMenuItem) {
			((CardLayout) cards.getLayout()).show(cards, "New Texnikos");
		} else if (e.getSource() == diathesimotitaMenuItem) {
			labelDiathesimotita.setVisible(true);
			atDiathesimotitaTF.setVisible(true);
			labelTexnikos.setVisible(true);
			onomaDiathesimotitaTF.setVisible(true);
			epithetoDiathesimotitaTF.setVisible(true);
			anazitisiatDiathesimotitaButton.setVisible(true);
			((CardLayout) cards.getLayout()).show(cards,
					"Diathesimotita Texnikou");
					
		} else if (e.getSource() == newGrammateasMenuItem) {
			((CardLayout) cards.getLayout()).show(cards, "New Grammateas");
		} else if (e.getSource() == programErgMenuItem) {
			((CardLayout) cards.getLayout()).show(cards,
					"Programmatismos Ergasias");
		} else if (e.getSource() == ektypwsiErgMenuItem) {
			((CardLayout) cards.getLayout()).show(cards, "Ektypwsh Ergasiwn");

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
