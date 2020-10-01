package tradingGame;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JLabel;
import tradingGame.Resources;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.BevelBorder;

public class MainMenu {

	private JFrame frame;
	
	// Variables to store total Resources + Resources/s

	private Resources resources;
	
	//JPanel classes. Production View, Planets and Global Market.
	
	private static Zota zota = new Zota();
	private static Intu intu = new Intu();
	private static Elaria elaria = new Elaria();
	private static Pezlis pezlis = new Pezlis();
	private GlobalMarket globalMarket = new GlobalMarket();
	private Production productionView = new Production();
	
	//Labels to display Resources/s
	
	private JLabel zeraPerSec = new JLabel();
	private JLabel xeroxPerSec = new JLabel();
	private JLabel carbonPerSec = new JLabel();
	private JLabel fuelPerSec = new JLabel();
	
	//Labels to display total Resources
	
	private JLabel zeraAmount = new JLabel();
	private JLabel xeroxAmount = new JLabel();
	private JLabel carbonAmount = new JLabel();
	private JLabel fuelAmount = new JLabel();
	private JLabel goldCoinsAmount = new JLabel();
	
	//Event Label
	
	private static JLabel eventNotificationLabel = new JLabel();
	
	//Planet Buttons
	
	private static JButton btnPlanet1 = new JButton("Zota");
	private static JButton btnPlanet2 = new JButton("Intu");
	private static JButton btnPlanet3 = new JButton("Elaria");
	private static JButton btnPlanet4 = new JButton("Pezlis");
	
	//Toggle Buttons for the "main" menus
	
	private JToggleButton btnGlobalMarket = new JToggleButton("Global Market");
	private JToggleButton btnProductionMenu = new JToggleButton("Production Menu");
	private JToggleButton btnTravel = new JToggleButton("Travel");
	
	//Panels that are used within MainMenu
	
	private JPanel notificationBar = new JPanel();
	private JPanel resourcePanel = new JPanel();
	private JPanel travelView = new JPanel();
	private JPanel panel = new JPanel();
	
	//Counts to allow the opening and closing of all Panels inside the program.
	
	private int pButtonCount = 0;
	private int gButtonCount = 0;
	private int tButtonCount = 0;
	private int p1ButtonCount = 0; 
	private int p2ButtonCount = 0;
	private int p3ButtonCount = 0;
	private int p4ButtonCount = 0;
	
	private java.util.Timer t = new java.util.Timer();
	private static java.util.Timer t2 = new java.util.Timer();
	private java.util.Timer t3 = new java.util.Timer();
	
	//random event delays. Between 20-60 seconds. Change these values to change the period of time they occur in.
	
	private static int delay1 = 20;
	private static int delay2 = 60;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		resources = new Resources();
		initialize();
		
		/*
		 * Timer task that loops to allow the update of resource production when buying buildings and/or upgrades.
		 */
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				resources.setCarbon(resources.getCarbon() + resources.getCarbonsec());
				resources.setZera(resources.getZera() + resources.getZerasec());
				resources.setXerox(resources.getXerox() + resources.getXeroxsec());
				resources.setFuel(resources.getFuel() + resources.getFuelsec());
			}
		}, 1000, 1000);
		
		t3.schedule(new TimerTask() {
			@Override
			public void run() {
				updateLabels();
			}
		}, 100, 100);
		
		
		
		new Task().run(); 
	
	}
		
	/**
	 * Initialise the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1085, 777);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu Menu = new JMenu("Menu");
		menuBar.add(Menu);
		
		JMenuItem saveGame = new JMenuItem("Save Game");
		saveGame.setHorizontalAlignment(SwingConstants.CENTER);
		Menu.add(saveGame);
		
		JMenuItem loadGame = new JMenuItem("Load Game");
		loadGame.setHorizontalAlignment(SwingConstants.CENTER);
		Menu.add(loadGame);
		frame.getContentPane().setLayout(null);
		
		notificationBar.setBorder(null);
		notificationBar.setBounds(0, 677, 1069, 39);
		notificationBar.setBackground(Color.RED);
		frame.getContentPane().add(notificationBar);
		
		eventNotificationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		eventNotificationLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		eventNotificationLabel.setVisible(false);
		eventNotificationLabel.setForeground(Color.WHITE);
		notificationBar.add(eventNotificationLabel);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		
		panel.setBounds(0, 0, 1069, 64);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		btnGlobalMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(globalMarket);
				globalMarket.setBounds(245, 63, 824, 654);
				
				if (gButtonCount == 0) {
					menuClose();
					gButtonCount = 1;
					globalMarket.setVisible(true);
					btnGlobalMarket.setSelected(true);
				} else if (gButtonCount == 1) {
					gButtonCount = 0;
					globalMarket.setVisible(false);
				}
			}
		});
		btnGlobalMarket.setBounds(865, 5, 194, 50);
		panel.add(btnGlobalMarket);
		
		btnProductionMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getContentPane().add(productionView);
				productionView.setBounds(245, 63, 824, 654);
				
				if (pButtonCount == 0) {
					menuClose();
					pButtonCount = 1;
					productionView.setVisible(true);
					btnProductionMenu.setSelected(true);
				} else if (pButtonCount == 1) {
					pButtonCount = 0;
					productionView.setVisible(false);
				}
			}
		});
		btnProductionMenu.setBounds(10, 5, 194, 50);
		panel.add(btnProductionMenu);
		
		btnTravel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tButtonCount == 0) {
					menuClose();
					tButtonCount = 1;
					travelView.setVisible(true);
					btnTravel.setSelected(true);
				} else if (tButtonCount == 1) {
					tButtonCount = 0;
					travelView.setVisible(false);
				}
			}
		});
		btnTravel.setBounds(216, 5, 194, 50);
		panel.add(btnTravel);
		
		travelView.setBorder(null);
		travelView.setBounds(245, 63, 824, 654);
		frame.getContentPane().add(travelView);
		travelView.setVisible(false);
		travelView.setLayout(null);
	
		btnPlanet1.setBounds(311, 128, 194, 50);
		btnPlanet1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(zota);
				zota.setBounds(245, 63, 824, 654);
				
				if (p1ButtonCount == 0) {
					menuClose();
					p1ButtonCount = 1;
					zota.setVisible(true);
				} else if (p1ButtonCount == 1) {
					p1ButtonCount = 0;
					zota.setVisible(false);
				}
			}
		});
		travelView.add(btnPlanet1);
		
		
		btnPlanet2.setBounds(311, 189, 194, 50);
		btnPlanet2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(intu);
				intu.setBounds(245, 63, 824, 654);
				
				if (p2ButtonCount == 0) {
					menuClose();
					p2ButtonCount = 1;
					intu.setVisible(true);
				} else if (p2ButtonCount == 1) {
					p2ButtonCount = 0;
					intu.setVisible(false);
				}
			}
		});
		travelView.add(btnPlanet2);
		

		btnPlanet3.setBounds(311, 250, 194, 50);
		btnPlanet3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(elaria);
				elaria.setBounds(245, 63, 824, 654);
				
				if (p3ButtonCount == 0) {
					menuClose();
					p3ButtonCount = 1;
					elaria.setVisible(true);
				} else if (p3ButtonCount == 1) {
					p3ButtonCount = 0;
					elaria.setVisible(false);
				}
			}
		});
		travelView.add(btnPlanet3);
		
		
		btnPlanet4.setBounds(311, 311, 194, 50);
		btnPlanet4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().add(pezlis);
				pezlis.setBounds(245, 63, 824, 654);
				
				if (p4ButtonCount == 0) {
					menuClose();
					p4ButtonCount = 1;
					pezlis.setVisible(true);
				} else if (p4ButtonCount == 1) {
					p4ButtonCount = 0;
					pezlis.setVisible(false);
				}
			}
		});
		travelView.add(btnPlanet4);

		resourcePanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		resourcePanel.setBounds(0, 63, 245, 654);
		frame.getContentPane().add(resourcePanel);
		resourcePanel.setLayout(null);
		
		JLabel carbonLabel = new JLabel("Carbon");
		carbonLabel.setHorizontalAlignment(SwingConstants.LEFT);
		carbonLabel.setBounds(10, 200, 77, 22);
		resourcePanel.add(carbonLabel);
		
		JLabel zeraLabel = new JLabel("Zera");
		zeraLabel.setHorizontalAlignment(SwingConstants.LEFT);
		zeraLabel.setBounds(10, 228, 77, 22);
		resourcePanel.add(zeraLabel);
		
		JLabel xeroxLabel = new JLabel("Xerox");
		xeroxLabel.setHorizontalAlignment(SwingConstants.LEFT);
		xeroxLabel.setBounds(10, 256, 77, 22);
		resourcePanel.add(xeroxLabel);
		
		JLabel fuelLabel = new JLabel("Fuel");
		fuelLabel.setHorizontalAlignment(SwingConstants.LEFT);
		fuelLabel.setBounds(10, 284, 77, 22);
		resourcePanel.add(fuelLabel);
		
		JLabel goldCoinsLabel = new JLabel("Gold Coins");
		goldCoinsLabel.setHorizontalAlignment(SwingConstants.LEFT);
		goldCoinsLabel.setBounds(10, 312, 77, 22);
		resourcePanel.add(goldCoinsLabel);
		
		goldCoinsAmount.setText("0");
		goldCoinsAmount.setBounds(99, 312, 53, 22);
		resourcePanel.add(goldCoinsAmount);
		
		fuelAmount.setText("10");
		fuelAmount.setBounds(99, 284, 53, 22);
		resourcePanel.add(fuelAmount);
		
		xeroxAmount.setText("100");
		xeroxAmount.setBounds(99, 256, 53, 22);
		resourcePanel.add(xeroxAmount);
		
		zeraAmount.setText("100");
		zeraAmount.setBounds(99, 228, 53, 22);
		resourcePanel.add(zeraAmount);
		
		carbonAmount.setText("100");
		carbonAmount.setBounds(99, 200, 53, 22);
		resourcePanel.add(carbonAmount);
		
		carbonPerSec.setText("0/s");
		carbonPerSec.setBounds(164, 200, 53, 22);
		resourcePanel.add(carbonPerSec);
		
		zeraPerSec.setText("0/s");
		zeraPerSec.setBounds(164, 228, 53, 22);
		resourcePanel.add(zeraPerSec);
		
		xeroxPerSec.setText("0/s");
		xeroxPerSec.setBounds(164, 256, 53, 22);
		resourcePanel.add(xeroxPerSec);
		
		fuelPerSec.setText("0/s");
		fuelPerSec.setBounds(164, 284, 53, 22);
		resourcePanel.add(fuelPerSec);
		
	}
	
	private void menuClose() {
		gButtonCount = 0;
		globalMarket.setVisible(false);
		btnGlobalMarket.setSelected(false);
		pButtonCount = 0;
		productionView.setVisible(false);
		btnProductionMenu.setSelected(false);
		tButtonCount = 0;
		travelView.setVisible(false);
		btnTravel.setSelected(false);
		p1ButtonCount = 0;
		zota.setVisible(false);
		p2ButtonCount = 0;
		intu.setVisible(false);
		p3ButtonCount = 0;
		elaria.setVisible(false);
		p4ButtonCount = 0;
		pezlis.setVisible(false);
	}
	
	
	/**
	 *  Updates all the labels to display the correct values of resources.
	 */
	
	public void updateLabels() {
		zeraAmount.setText(resources.getZera() + "");
		xeroxAmount.setText(resources.getXerox() + "");
		carbonAmount.setText(resources.getCarbon() + "");
		fuelAmount.setText(resources.getFuel() + "");
		goldCoinsAmount.setText(resources.getGoldCoins() + "");
		zeraPerSec.setText(resources.getZerasec() + "/s");
		xeroxPerSec.setText(resources.getXeroxsec() + "/s");
		carbonPerSec.setText(resources.getCarbonsec() + "/s");
		fuelPerSec.setText(resources.getFuelsec() + "/s");
		

	}
	
	/*
	 * Timer for Random Events to occur
	 */
	
	static class Task extends TimerTask {

		@Override
		public void run() {
			int delay = ((ThreadLocalRandom.current().nextInt(delay1, delay2 + 1)) * 1000); //Random Event occurs between 20-60 seconds. Change the variables within .NextInt to change this. 
			int random = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
				if (random == 1) {		//Random event 1, war between 2 planets.
					resetPrices();
					int x = (ThreadLocalRandom.current().nextInt(1, 4 + 1));
					int y = (ThreadLocalRandom.current().nextInt(1, 4 + 1));
					randomEventWar(x, y);
				} else if (random == 2) {		//Random event 2, no event occurs over this time period.
					resetPrices();
					int randomHeadline = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
					switch (randomHeadline) {
					case 1: eventNotificationLabel.setText("The galaxy is a little boring right now...");
					break;
					case 2: eventNotificationLabel.setText("Nothing interesting here.");
					break;
					case 3: eventNotificationLabel.setText("If something doesn't happen, I may need a new job.");
					break;
					}
				} else if (random == 3) {		//Random event 3, fuel factory/storage explosion.
					resetPrices();
					int x = (ThreadLocalRandom.current().nextInt(1, 4 + 1));
					randomEventExplosion(x);
				}
            t2.schedule(new Task(), delay);
            
		}
	}
	
	public static void randomEventWar(int x, int y) {
		if (x == y) { //Checks to see if both "planets" are the same. If they are break out into Civil War.
			int randomHeadline = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
			switch (randomHeadline) {
			case 1: eventNotificationLabel.setText("Fighting in " + planetSwitch(x) + ". Trading is prohibited.");
					eventNotificationLabel.setVisible(true);
			break;
			case 2: eventNotificationLabel.setText("Civil war in " + planetSwitch(x) + ". Travelling here is not permitted.");
					eventNotificationLabel.setVisible(true);
			break;
			case 3: eventNotificationLabel.setText(planetSwitch(x) + " breaks into civil war!" + " The Universal Alliance bans travel.");
					eventNotificationLabel.setVisible(true);
			break;
			}
			
				if (x == 1) { //Depending on what Planet it is, disable the travel function to the planet to stop the player from travelling while at Civil War. 	
					resetButtons();
					btnPlanet1.setEnabled(false);
				} else if (x == 2) {	
					resetButtons();
					btnPlanet2.setEnabled(false);
				} else if (x == 3) {	
					resetButtons();
					btnPlanet3.setEnabled(false);
				} else if (x == 4) {
					resetButtons();
					btnPlanet4.setEnabled(false);
				}
				
		} else {
			int randomHeadline = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
			switch (randomHeadline) {
			case 1: eventNotificationLabel.setText(planetSwitch(x) + " & " + planetSwitch(y) + " are at war!");
					eventNotificationLabel.setVisible(true);
			break;
			case 2:	eventNotificationLabel.setText(planetSwitch(x) + " declares war on " + planetSwitch(y));
					eventNotificationLabel.setVisible(true);
			break;
			case 3: eventNotificationLabel.setText("War outbreaks between " + planetSwitch(x) + " & " + planetSwitch(y));
					eventNotificationLabel.setVisible(true);
			break;
			}
		if (x == 1) {
			zota.setBuyFuelPrice(zota.getBuyFuelPrice() * 100); 			//They need it for war so they don't want you to buy it. Hence x100 price.
			zota.setSellFuelPrice(zota.getSellFuelPrice() * 1.2); 			//Will buy it off you for slightly more.
			zota.setBuyCarbonPrice(zota.getBuyCarbonPrice() * 50); 			//Zota is scarce in carbon therefore don't want to sell it to you for cheap during war.
			zota.setSellCarbonPrice(zota.getSellCarbonPrice() * 1.5);		//Zota is scarce in carbon therefore buy it off you for more during war.
																			//Zera and Xerox don't change as they have enough of this to last through a war.
		} else if (x == 2) {
			intu.setBuyFuelPrice(intu.getBuyFuelPrice() * 100);				//They need it for war so they don't want you to buy it. Hence x100 price.
			intu.setSellFuelPrice(intu.getSellFuelPrice() * 1.5);			//Will buy it off you for slightly more due to being scarce in Fuel.
			intu.setBuyCarbonPrice(intu.getBuyCarbonPrice() * 1.1);			//Abundant in Carbon so price goes up slightly.
			intu.setSellCarbonPrice(intu.getSellCarbonPrice() * 1.1);		//Abundant in Carbon so price goes up slightly.
																			//Zera and Xerox don't change as they have enough of this resource to last through the war.
		} else if (x == 3) {
			elaria.setBuyFuelPrice(elaria.getBuyFuelPrice() * 100);			//They need it for war so they don't want you to buy it. Hence x100 price.
			elaria.setSellFuelPrice(elaria.getSellFuelPrice() * 1.2);		//Will buy it off you for slightly more.
																			//Everything else is standard as they have enough of every resource to last through a war.
		} else if (x == 4) {
			pezlis.setBuyFuelPrice(pezlis.getBuyFuelPrice() * 100);			//They need it for war so they don't want you to buy it. Hence x100 price.
			pezlis.setSellFuelPrice(pezlis.getSellFuelPrice() * 1.2);		//Will buy it off you for slightly more.
			pezlis.setBuyZeraPrice(pezlis.getBuyZeraPrice() * 1.1);			//Abundant in Zera so price goes up slightly.
			pezlis.setSellZeraPrice(pezlis.getSellZeraPrice() * 1.1);		//Abundant in Zera so price goes up slightly.
			pezlis.setBuyCarbonPrice(pezlis.getBuyCarbonPrice() * 50);  	//Scarce in Carbon therefore they sell for a lot more. As they don't want people buying it.
			pezlis.setSellCarbonPrice(pezlis.getSellCarbonPrice() * 1.5);	//Scarce in Carbon therefore buy it for more during war.
			pezlis.setBuyXeroxPrice(pezlis.getBuyXeroxPrice() * 50);		//Scarce in Xerox therefore they sell for a lot more. As they don't want people buying it.
			pezlis.setSellXeroxPrice(pezlis.getSellXeroxPrice() * 1.5);		//Scarce in Xerox therefore buy it for more during war.
		}
		
		//Below is the same as above. Just depends which planet is which way around.
		
		if (y == 1) {
			zota.setBuyFuelPrice(zota.getBuyFuelPrice() * 100); 
			zota.setSellFuelPrice(zota.getSellFuelPrice() * 1.2); 			
			zota.setBuyCarbonPrice(zota.getBuyCarbonPrice() * 50); 			
			zota.setSellCarbonPrice(zota.getSellCarbonPrice() * 1.5);		
																			
		} else if (y == 2) {
			intu.setBuyFuelPrice(intu.getBuyFuelPrice() * 100);				
			intu.setSellFuelPrice(intu.getSellFuelPrice() * 1.5);			
			intu.setBuyCarbonPrice(intu.getBuyCarbonPrice() * 1.1);		
			intu.setSellCarbonPrice(intu.getSellCarbonPrice() * 1.1);		
																			
		} else if (y == 3) {
			elaria.setBuyFuelPrice(elaria.getBuyFuelPrice() * 100);			
			elaria.setSellFuelPrice(elaria.getSellFuelPrice() * 1.2);		
																			
		} else if (y == 4) {
			pezlis.setBuyFuelPrice(pezlis.getBuyFuelPrice() * 100);			
			pezlis.setSellFuelPrice(pezlis.getSellFuelPrice() * 1.2);		
			pezlis.setBuyZeraPrice(pezlis.getBuyZeraPrice() * 1.1);			
			pezlis.setSellZeraPrice(pezlis.getSellZeraPrice() * 1.1);		
			pezlis.setBuyCarbonPrice(pezlis.getBuyCarbonPrice() * 50);  	
			pezlis.setSellCarbonPrice(pezlis.getSellCarbonPrice() * 1.5);	
			pezlis.setBuyXeroxPrice(pezlis.getBuyXeroxPrice() * 50);		
			pezlis.setSellXeroxPrice(pezlis.getSellXeroxPrice() * 1.5);		
		}
		}
	}
	
	public static void randomEventExplosion(int x) {
		int randomHeadline = (ThreadLocalRandom.current().nextInt(1, 3 + 1));
		switch (randomHeadline) {
		case 1: eventNotificationLabel.setText("Major fuel factory explosion on " + planetSwitch(x));
		break;
		case 2: eventNotificationLabel.setText("BOOM! Fatal explosion of " + planetSwitch(x) + " fuel factory");
		break;
		case 3: eventNotificationLabel.setText(planetSwitch(x) + "'s largest fuel store destroyed in wicked blast");
		break;
		case 4: eventNotificationLabel.setText("Blast on " + planetSwitch(x) + "leaves fuel supplies low!");
		break;
		}
		eventNotificationLabel.setVisible(true);
		switch(x) {
		case 1: zota.setBuyFuelPrice(zota.getBuyFuelPrice() * 100);
				zota.setSellFuelPrice(zota.getSellFuelPrice() * 3);
		break;
		case 2: intu.setBuyFuelPrice(intu.getBuyFuelPrice() * 100);
				intu.setSellFuelPrice(zota.getSellFuelPrice() * 3);
		break;
		case 3: elaria.setBuyFuelPrice(elaria.getBuyFuelPrice() * 100);
				elaria.setSellFuelPrice(zota.getSellFuelPrice() * 3);
		break;
		case 4: pezlis.setBuyFuelPrice(pezlis.getBuyFuelPrice() * 100);
				pezlis.setSellFuelPrice(zota.getSellFuelPrice() * 3);
		break;
		}
	}

	/**
	 * 
	 * @param x Int value which returns a different planet. 1-4.
	 * @return Returns a different planet name based on the Int value given.
	 */
	
	public static String planetSwitch (int x) {
		switch (x) {
		case 1: return "Zota";
		case 2: return "Intu";
		case 3: return "Elaria";
		case 4: return "Pezlis";
		default: return "INVALID";
		}
	}
	
	/**
	 * Resets prices to default on all planets when called.
	 */
	
	public static void resetPrices() {
		zota.resetPrices();
		intu.resetPrices();
		elaria.resetPrices();
		pezlis.resetPrices();
	}
	
	/**
	 * Sets all buttons to be enabled.
	 */
	
	public static void resetButtons() {
		btnPlanet1.setEnabled(true);
		btnPlanet2.setEnabled(true);
		btnPlanet3.setEnabled(true);
		btnPlanet4.setEnabled(true);
	}
}
