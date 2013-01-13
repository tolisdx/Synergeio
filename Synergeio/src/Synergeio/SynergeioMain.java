package Synergeio;

import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SynergeioMain extends JFrame implements ActionListener {

	private JPanel cards;
	private JMenuBar menuBar;
	private JMenu pelatis,ypalliloi,kataxwrhshYpallilwn,ergasies,exit,save;
	private JMenuItem egrPelatiMenuItem, tropPelatiMenuItem,
			printPelatiMenuItem,saveAllMenuItem, exodosMenuItem, newTexnikosMenuItem,diathesimotitaMenuItem,
			newGrammateasMenuItem, programErgMenuItem,ektypwsiErgMenuItem,diekperaiwshErgMenuItem;
	CardLayout card;
	
	
	
	

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
		
		/**
		 *  Kentriko Parathyro
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
		
		/** Ta ypomenu tou pelati 
		 *  Eggrafh pelati, Tropopoihsh Pelati, Ektypwsh Pelati
		 */
		//Egrgafh pelati
		egrPelatiMenuItem = new JMenuItem("Εγγραφή Πελάτη");
		egrPelatiMenuItem.addActionListener(this);
		pelatis.add(egrPelatiMenuItem);

		//Tropopoihsh pelati 
		tropPelatiMenuItem = new JMenuItem("Τροποποίηση Πελάτη");
		tropPelatiMenuItem.addActionListener(this);
		pelatis.add(tropPelatiMenuItem);

		//Ektypwsh pelati
		printPelatiMenuItem = new JMenuItem("Εκτύπωση Πελάτη");
		printPelatiMenuItem.addActionListener(this);
		pelatis.add(printPelatiMenuItem);
		
		/**To ypomenu twn ypallilwn
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
		cards.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cards);
		
		JLabel lblNewLabel = new JLabel("Σύστημα Διαχείρισης Συνεργείου");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Book Antiqua", Font.PLAIN, 32));
		cards.add(lblNewLabel, "name_392319521884848");

	}

/***************************************************************************
 			*Energeies twn menu ths efarmoghs
 			* 	
****************************************************************************/
	//Energeies twn Menu 
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == egrPelatiMenuItem) {
			System.out.println("Eggrafh");
			
		} else if (e.getSource() == tropPelatiMenuItem) {
			System.out.println("Tropopoihshs");
			
		} else if (e.getSource() == printPelatiMenuItem) {
			System.out.println("Ektypwsh");
			
		} else if (e.getSource() == newTexnikosMenuItem) {
			
		} else if (e.getSource() == newGrammateasMenuItem) {
			
		} else if (e.getSource() == programErgMenuItem) {
			
		} else if(e.getSource() == ektypwsiErgMenuItem){
			
						
		} else if (e.getSource() == diekperaiwshErgMenuItem) {
				
		} else if (e.getSource() == saveAllMenuItem){
			
        }
		else if (e.getSource() == exodosMenuItem) {
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
