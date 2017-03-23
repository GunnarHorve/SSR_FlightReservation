package GUI;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;

import Models.Flight;

public class welcome extends JFrame {

	JPanel contentPane;
	JComboBox comboBox, comboBox_1;
	JRadioButton rdbtnOneWay, rdbtnRoundWay, rdbtnNewRadioButton, rdbtnNewRadioButton_1;
	DateChooserJButton datepicker;
	JSpinner spinner,spinner_1;
	JButton btncheck;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcome frame = new welcome();
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
	public welcome() {
		setFont(new Font("Times New Roman", Font.PLAIN, 18));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel txtpnDepartAirport = new JLabel();
		txtpnDepartAirport.setText("Depart Airport");
		GridBagConstraints gbc_txtpnDepartAirport = new GridBagConstraints();
		gbc_txtpnDepartAirport.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnDepartAirport.gridx = 0;
		gbc_txtpnDepartAirport.gridy = 1;
		contentPane.add(txtpnDepartAirport, gbc_txtpnDepartAirport);
		
		String[] airports = {"Please Choose from Below","Hartsfield-Jackson Atlanta International","Ted Stevens Anchorage International Airport","Austin-Bergstrom International","Baltimore/Washington International",
				"Logan International","Charlotte Douglas International","Chicago Midway Airport","Chicago O'Hare International","Cincinnati/Northern Kentucky International","Cleveland Hopkins International",
				"Port Columbus International","Dallas/Ft. Worth International - DFW Airport","Denver International Airport","Detroit Metropolitan Wayne County Airport","Fort Lauderdale/Hollywood International",
				"Southwest Florida International","Bradley International","Hawaii Honolulu International","George Bush Intercontinental","William P. Hobby Airport","Indianapolis International","Kansas City International",
				"McCarran International","Los Angeles International","Memphis International","Miami International Airport","Minneapolis/St. Paul International","Nashville International","Louis Armstrong International",
				"John F. Kennedy International","LaGuardia International","Newark Liberty International","Metropolitan Oakland International","Ontario International","Orlando International","Philadelphia International","Sky Harbor International",
				"Pittsburgh International","Portland International","Raleigh-Durham International","Sacramento International","Salt Lake City International","San Antonio International","Lindbergh Field International","San Francisco International",
				"Mineta San Jos�� International","John Wayne Airport, Orange County","Seattle-Tacoma International","Lambert-St. Louis International","Tampa International","Dulles International Airport","Ronald Reagan Washington National"};
		JComboBox comboBox = new JComboBox(airports);
		comboBox.setForeground(Color.BLUE);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 1;
		contentPane.add(comboBox, gbc_comboBox);
		
		JLabel txtpnArrivalAirport = new JLabel();
		txtpnArrivalAirport.setText("Arrival Airport");
		GridBagConstraints gbc_txtpnArrivalAirport = new GridBagConstraints();
		gbc_txtpnArrivalAirport.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnArrivalAirport.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnArrivalAirport.gridx = 0;
		gbc_txtpnArrivalAirport.gridy = 2;
		contentPane.add(txtpnArrivalAirport, gbc_txtpnArrivalAirport);
		
		JComboBox comboBox_1 = new JComboBox(airports);
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 2;
		contentPane.add(comboBox_1, gbc_comboBox_1);
		
		JRadioButton rdbtnRoundWay = new JRadioButton("round way");
		GridBagConstraints gbc_rdbtnRoundWay = new GridBagConstraints();
		gbc_rdbtnRoundWay.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnRoundWay.gridx = 0;
		gbc_rdbtnRoundWay.gridy = 3;
		//rdbtnRoundWay.setActionCommand("round way");
		contentPane.add(rdbtnRoundWay, gbc_rdbtnRoundWay);
		
		JRadioButton rdbtnOneWay = new JRadioButton("one way");
		GridBagConstraints gbc_rdbtnOneWay = new GridBagConstraints();
		gbc_rdbtnOneWay.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnOneWay.gridx = 1;
		gbc_rdbtnOneWay.gridy = 3;
		//rdbtnOneWay.setActionCommand("one way");
		contentPane.add(rdbtnOneWay, gbc_rdbtnOneWay);
		rdbtnOneWay.setSelected(true);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnRoundWay);
		group.add(rdbtnOneWay);
		
		
		JLabel txtpnStopover = new JLabel();
		txtpnStopover.setText("Stopover");
		GridBagConstraints gbc_txtpnStopover = new GridBagConstraints();
		gbc_txtpnStopover.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnStopover.fill = GridBagConstraints.VERTICAL;
		gbc_txtpnStopover.gridx = 0;
		gbc_txtpnStopover.gridy = 4;
		contentPane.add(txtpnStopover, gbc_txtpnStopover);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, null, 2, 1));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 4;
		contentPane.add(spinner, gbc_spinner);
		
		JLabel txtpnDataOfTravel = new JLabel();
		txtpnDataOfTravel.setText("Data of travel");
		GridBagConstraints gbc_txtpnDataOfTravel = new GridBagConstraints();
		gbc_txtpnDataOfTravel.gridheight = 2;
		gbc_txtpnDataOfTravel.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnDataOfTravel.gridx = 0;
		gbc_txtpnDataOfTravel.gridy = 5;
		contentPane.add(txtpnDataOfTravel, gbc_txtpnDataOfTravel);
		
		DateChooserJButton datepicker = new DateChooserJButton();
		datepicker.setBackground(new Color(102, 204, 255));
		datepicker.setForeground(new Color(255, 255, 255));
		datepicker.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		datepicker.setAlignmentY(HEIGHT);
		GridBagConstraints gbc_datepicker = new GridBagConstraints();
		gbc_datepicker.gridheight = 2;
		gbc_datepicker.ipadx = 3;
		gbc_datepicker.ipady = 1;
		gbc_datepicker.fill = GridBagConstraints.BOTH;
		gbc_datepicker.insets = new Insets(0, 0, 5, 5);
		gbc_datepicker.gridx = 1;
		gbc_datepicker.gridy = 5;
		//gbc_datepicker.weighty=6;
		contentPane.add(datepicker, gbc_datepicker);
		
		JLabel txtpnSeatClass = new JLabel();
		txtpnSeatClass.setText("Seat Class");
		GridBagConstraints gbc_txtpnSeatClass = new GridBagConstraints();
		gbc_txtpnSeatClass.insets = new Insets(0, 0, 5, 5);
		gbc_txtpnSeatClass.gridx = 0;
		gbc_txtpnSeatClass.gridy = 7;
		contentPane.add(txtpnSeatClass, gbc_txtpnSeatClass);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 7;
		contentPane.add(panel, gbc_panel);
		ButtonGroup group1 = new ButtonGroup();
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("First Class");
		
		panel.add(rdbtnNewRadioButton_2);
		//rdbtnNewRadioButton.setActionCommand("first");
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Coach");
		
		panel.add(rdbtnNewRadioButton_1_1);
		//rdbtnNewRadioButton_1.setActionCommand("coach");
		rdbtnNewRadioButton_1_1.setSelected(true);
		group1.add(rdbtnNewRadioButton_2);
		group1.add(rdbtnNewRadioButton_1_1);
		txtpnStopover.setText("Number of Tickets");
		
		
		JButton btnCheck = new JButton("check");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.util.Date date=datepicker.getDate();
				System.out.println(date.toString());
				List <Flight> result= QueryManager.queryManager.getFlights_noDep(comboBox_1.getSelectedItem().toString(), date);
				for (Flight flight:result){System.out.println(flight.toString());}

				System.out.println(result);
				if ((rdbtnRoundWay.isSelected())){
					if (rdbtnNewRadioButton_2.isSelected()){
						System.out.println("roundwaytravel, firstclass seat");
						
						//List <Flight> result= QueryManager.queryManager.getFlights_noDep(comboBox.getSelectedItem().toString(), date);
						
					}
					
					if (rdbtnNewRadioButton_1_1.isSelected()) {System.out.println("roundwaytravel, coach seat");}
					//
				}
				else
					if(rdbtnNewRadioButton_1_1.isSelected()){
					System.out.println("onewaytravel, coach seat");
					
					
				}
					else if(rdbtnNewRadioButton_2.isSelected()) {System.out.println("onewaytravel, first seat");}
			
			
			
			}
			
		});
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCheck.insets = new Insets(0, 0, 0, 64);
		gbc_btnCheck.gridx = 1;
		gbc_btnCheck.gridy = 9;
		contentPane.add(btnCheck, gbc_btnCheck);
		
	}
	
}