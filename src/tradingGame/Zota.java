package tradingGame;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/*
 * Zota - Scarce in Carbon / They buy + sell for more because they don't have much of it.
        - Standard in Zera, Xerox and Rocket Fuel.
        - No Abundant resources.
 */


public class Zota extends JPanel {
	
	//Pulls the resources into this panel

	/**
	 * Default Generated Serial Version ID.
	 */
	private static final long serialVersionUID = 1L;

	private Resources resources = new Resources();

	//Sets the default buy and sell prices of resources on this planet
	
	public static double buyCarbonPrice = 20;
	public static double sellCarbonPrice = buyCarbonPrice / 1.5;
	public static double buyZeraPrice = 10;
	public static double sellZeraPrice = buyZeraPrice / 1.5;
	public static double buyXeroxPrice = 10;
	public static double sellXeroxPrice = buyXeroxPrice / 1.5;
	public static double buyFuelPrice = 150;
	public static double sellFuelPrice = buyFuelPrice / 1.5;
	
	//Text Fields for user inputs to buy/sell X amount. 
	
	private JTextField buyXCarbonAmount;
	private JTextField buyXZeraAmount;
	private JTextField buyXXeroxAmount;
	private JTextField buyXFuelAmount;
	private JTextField sellXCarbonAmount;
	private JTextField sellXZeraAmount;
	private JTextField sellXXeroxAmount;
	private JTextField sellXFuelAmount;
	
	//Decimal format to have the numbers display better rather than being infinite decimals long. Limits them all to 1.
	
	private DecimalFormat df2 = new DecimalFormat(".#");
	
	//Initiating labels to display buy and sell values of resources to this planet. Using the decimal format to keep it clean
	
	private JLabel buyCarbonLabel = new JLabel(df2.format(buyCarbonPrice) + "gc Per Carbon");
	private JLabel buyZeraLabel = new JLabel(df2.format(buyZeraPrice) + "gc Per Zera");
	private JLabel buyXeroxLabel = new JLabel(df2.format(buyXeroxPrice) + "gc Per Xerox");
	private JLabel buyFuelLabel = new JLabel(df2.format(buyFuelPrice) + "gc Per Fuel");
	private JLabel sellCarbonLabel = new JLabel(df2.format(sellCarbonPrice) + "gc Per Carbon");
	private JLabel sellZeraLabel = new JLabel(df2.format(sellZeraPrice) + "gc Per Zera");
	private JLabel sellXeroxLabel = new JLabel(df2.format(sellXeroxPrice) + "gc Per Xerox");
	private JLabel sellFuelLabel = new JLabel(df2.format(sellFuelPrice)  + "gc Per Fuel");
	

	/**
	 * Create the panel.
	 */
	public Zota() {
		setLayout(null);
		setBackground(new Color(214,217,223));
		
		//tries to change the "look" of the program. Which changes the design and overall look of all the buttons and fields etc.
		
		try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, this can be used to set to a different GUI.
        }
		
		
		
		/*
		 * Buy button with an ActionListener. Checks if you have enough gold coins to purchase the resource. If so, sets the resource and gold coins appropriately.
		 * This is similar with all buy buttons. Changing the prices, resource and gold coins accordingly. 
		 */
		
		JButton buy1Carbon = new JButton("1"); 
		buy1Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= buyCarbonPrice) {
					resources.setCarbon(resources.getCarbon() + 1);
					resources.setGoldCoins(resources.getGoldCoins() - buyCarbonPrice);
				}
				
			}
		});
		buy1Carbon.setBounds(138, 168, 53, 22);
		add(buy1Carbon);
		
		JButton buy5Carbon = new JButton("5");
		buy5Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyCarbonPrice * 5) ) {
					resources.setCarbon(resources.getCarbon() + 5);
					resources.setGoldCoins(resources.getGoldCoins() - (buyCarbonPrice * 5));
					
				}
				
			}
		});
		buy5Carbon.setBounds(197, 168, 53, 22);
		add(buy5Carbon);
		
		JButton buy10Carbon = new JButton("10");
		buy10Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyCarbonPrice * 10)) {
					resources.setCarbon(resources.getCarbon() + 10);
					resources.setGoldCoins(resources.getGoldCoins() - (buyCarbonPrice * 10));
					
				}
				
			}
		});
		buy10Carbon.setBounds(256, 168, 53, 22);
		add(buy10Carbon);
		
		JButton buy50Carbon = new JButton("50");
		buy50Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyCarbonPrice * 50)) {
					resources.setCarbon(resources.getCarbon() + 50);
					resources.setGoldCoins(resources.getGoldCoins() - (buyCarbonPrice * 50));
					
				}
				
			}
		});
		buy50Carbon.setBounds(315, 168, 53, 22);
		add(buy50Carbon);
		
		JButton buy100Carbon = new JButton("100");
		buy100Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyCarbonPrice * 100)) {
					resources.setCarbon(resources.getCarbon() + 100);
					resources.setGoldCoins(resources.getGoldCoins() - (buyCarbonPrice * 100));
				}
				
			}
		});
		buy100Carbon.setBounds(374, 168, 57, 22);
		add(buy100Carbon);
		
		/*
		 * Buy X Button with an ActionListener. This reads the input from the user from a JTextField, then uses that value to calculate how much to buy. 
		 * The resource and gold coin values are then updated appropriately. This is similar to every buy X Button, the price, resource and gold coins
		 * change accordingly. 
		 */
		
		JButton buyXCarbon = new JButton("Buy X");
		buyXCarbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = buyXCarbonAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getGoldCoins() >= (buyCarbonPrice * xAmount)) {
					resources.setCarbon(resources.getCarbon() + xAmount);
					resources.setGoldCoins(resources.getGoldCoins() - (buyCarbonPrice * xAmount));
				}
				
			}
		});
		buyXCarbon.setBounds(436, 168, 69, 22);
		add(buyXCarbon);
		
		JButton buy1Zera = new JButton("1");
		buy1Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= buyZeraPrice) {
					resources.setZera(resources.getZera() + 1);
					resources.setGoldCoins(resources.getGoldCoins() - buyZeraPrice);
					
				}
				
			}
		});
		buy1Zera.setBounds(138, 196, 53, 22);
		add(buy1Zera);
		
		JButton buy5Zera = new JButton("5");
		buy5Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyZeraPrice * 5)) {
					resources.setZera(resources.getZera() + 5);
					resources.setGoldCoins(resources.getGoldCoins() - (buyZeraPrice * 5));
					
				}
				
			}
		});
		buy5Zera.setBounds(197, 196, 53, 22);
		add(buy5Zera);
		
		JButton buy10Zera = new JButton("10");
		buy10Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyZeraPrice * 10)) {
					resources.setZera(resources.getZera() + 10);
					resources.setGoldCoins(resources.getGoldCoins() - (buyZeraPrice * 10));
					
				}
				
			}
		});
		buy10Zera.setBounds(256, 196, 53, 22);
		add(buy10Zera);
		
		JButton buy50Zera = new JButton("50");
		buy50Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyZeraPrice * 50)) {
					resources.setZera(resources.getZera() + 50);
					resources.setGoldCoins(resources.getGoldCoins() - (buyZeraPrice * 50));
					
				}
				
			}
		});
		buy50Zera.setBounds(315, 196, 53, 22);
		add(buy50Zera);
		
		JButton buy100Zera = new JButton("100");
		buy100Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyZeraPrice * 100)) {
					resources.setZera(resources.getZera() + 100);
					resources.setGoldCoins(resources.getGoldCoins() - (buyZeraPrice * 100));
					
				}
				
			}
		});
		buy100Zera.setBounds(374, 196, 57, 22);
		add(buy100Zera);
		
		JButton buyXZera = new JButton("Buy X");
		buyXZera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = buyXZeraAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getGoldCoins() >= (buyZeraPrice * xAmount)) {
					resources.setZera(resources.getZera() + xAmount);
					resources.setGoldCoins(resources.getGoldCoins() - (buyZeraPrice * xAmount));
				}
				
			}
		});
		buyXZera.setBounds(436, 196, 69, 22);
		add(buyXZera);
		
		JButton buy1Xerox = new JButton("1");
		buy1Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= buyXeroxPrice) {
					resources.setXerox(resources.getXerox() + 1);
					resources.setGoldCoins(resources.getGoldCoins() - buyXeroxPrice);
					
				}
				
			}
		});
		buy1Xerox.setBounds(138, 224, 53, 22);
		add(buy1Xerox);
		
		JButton buy5Xerox = new JButton("5");
		buy5Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyXeroxPrice * 5)) {
					resources.setXerox(resources.getXerox() + 5);
					resources.setGoldCoins(resources.getGoldCoins() - (buyXeroxPrice * 5));
					
				}
				
			}
		});
		buy5Xerox.setBounds(197, 224, 53, 22);
		add(buy5Xerox);
		
		JButton buy10Xerox = new JButton("10");
		buy10Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyXeroxPrice * 10)) {
					resources.setXerox(resources.getXerox() + 10);
					resources.setGoldCoins(resources.getGoldCoins() - (buyXeroxPrice * 10));
					
				}
				
			}
		});
		buy10Xerox.setBounds(256, 224, 53, 22);
		add(buy10Xerox);
		
		JButton buy50Xerox = new JButton("50");
		buy50Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyXeroxPrice * 50)) {
					resources.setXerox(resources.getXerox() + 50);
					resources.setGoldCoins(resources.getGoldCoins() - (buyXeroxPrice * 50));
					
				}
				
			}
		});
		buy50Xerox.setBounds(315, 224, 53, 22);
		add(buy50Xerox);
		
		JButton buy100Xerox = new JButton("100");
		buy100Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyXeroxPrice * 100)) {
					resources.setXerox(resources.getXerox() + 100);
					resources.setGoldCoins(resources.getGoldCoins() - (buyXeroxPrice * 100));
					
				}
				
			}
		});
		buy100Xerox.setBounds(374, 224, 57, 22);
		add(buy100Xerox);

		JButton buyXXerox = new JButton("Buy X");
		buyXXerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = buyXXeroxAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getGoldCoins() >= (buyXeroxPrice * xAmount)) {
					resources.setXerox(resources.getXerox() + xAmount);
					resources.setGoldCoins(resources.getGoldCoins() - (buyXeroxPrice * xAmount));
				}
				
			}
		});
		buyXXerox.setBounds(436, 224, 69, 22);
		add(buyXXerox);
		
		JButton buy1Fuel = new JButton("1");
		buy1Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= buyFuelPrice) {
					resources.setFuel(resources.getFuel() + 1);
					resources.setGoldCoins(resources.getGoldCoins() - buyFuelPrice);
					
				}
				
			}
		});
		buy1Fuel.setBounds(138, 252, 53, 22);
		add(buy1Fuel);
		
		JButton buy5Fuel = new JButton("5");
		buy5Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyFuelPrice * 5)) {
					resources.setFuel(resources.getFuel() + 5);
					resources.setGoldCoins(resources.getGoldCoins() - (buyFuelPrice * 5));
					
				}
				
			}
		});
		buy5Fuel.setBounds(197, 252, 53, 22);
		add(buy5Fuel);
		
		JButton buy10Fuel = new JButton("10");
		buy10Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyFuelPrice * 10)) {
					resources.setFuel(resources.getFuel() + 10);
					resources.setGoldCoins(resources.getGoldCoins() - (buyFuelPrice * 10));
					
				}
				
			}
		});
		buy10Fuel.setBounds(256, 252, 53, 22);
		add(buy10Fuel);
		
		JButton buy50Fuel = new JButton("50");
		buy50Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyFuelPrice * 50)) {
					resources.setFuel(resources.getFuel() + 50);
					resources.setGoldCoins(resources.getGoldCoins() - (buyFuelPrice * 50));
					
				}
				
			}
		});
		buy50Fuel.setBounds(315, 252, 53, 22);
		add(buy50Fuel);
		
		JButton buy100Fuel = new JButton("100");
		buy100Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getGoldCoins() >= (buyFuelPrice * 100)) {
					resources.setFuel(resources.getFuel() + 100);
					resources.setGoldCoins(resources.getGoldCoins() - (buyFuelPrice * 100));
					
				}
				
			}
		});
		buy100Fuel.setBounds(374, 252, 57, 22);
		add(buy100Fuel);
		
		JButton buyXFuel = new JButton("Buy X");
		buyXFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = buyXFuelAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getGoldCoins() >= (buyFuelPrice * xAmount)) {
					resources.setFuel(resources.getFuel() + xAmount);
					resources.setGoldCoins(resources.getGoldCoins() - (buyFuelPrice * xAmount));
				}
				
			}
		});
		buyXFuel.setBounds(436, 252, 69, 22);
		add(buyXFuel);
		
		JButton sell1Carbon = new JButton("1");
		sell1Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getCarbon() >= 1) {
					resources.setCarbon(resources.getCarbon() - 1);
					resources.setGoldCoins(resources.getGoldCoins() + sellCarbonPrice);
					
				}
			}
		});
		sell1Carbon.setBounds(138, 387, 53, 22);
		add(sell1Carbon);
		
		JButton sell5Carbon = new JButton("5");
		sell5Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getCarbon() >= 5) {
					resources.setCarbon(resources.getCarbon() - 5);
					resources.setGoldCoins(resources.getGoldCoins() + (sellCarbonPrice * 5));
					
				}
			}
		});
		sell5Carbon.setBounds(197, 387, 53, 22);
		add(sell5Carbon);
		
		JButton sell10Carbon = new JButton("10");
		sell10Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getCarbon() >= 10) {
					resources.setCarbon(resources.getCarbon() - 10);
					resources.setGoldCoins(resources.getGoldCoins() + (sellCarbonPrice * 10));
					
				}
			}
		});
		sell10Carbon.setBounds(256, 387, 53, 22);
		add(sell10Carbon);
		
		JButton sell50Carbon = new JButton("50");
		sell50Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getCarbon() >= 50) {
					resources.setCarbon(resources.getCarbon() - 50);
					resources.setGoldCoins(resources.getGoldCoins() + (sellCarbonPrice * 50));
					
				}
			}
		});
		sell50Carbon.setBounds(315, 387, 53, 22);
		add(sell50Carbon);
		
		JButton sell100Carbon = new JButton("100");
		sell100Carbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getCarbon() >= 100) {
					resources.setCarbon(resources.getCarbon() - 100);
					resources.setGoldCoins(resources.getGoldCoins() + (sellCarbonPrice * 100));
					
				}
			}
		});
		sell100Carbon.setBounds(374, 387, 57, 22);
		add(sell100Carbon);
		
		JButton sellXCarbon = new JButton("Sell X");
		sellXCarbon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = sellXCarbonAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getCarbon() >= xAmount) {
					resources.setCarbon(resources.getCarbon() - xAmount);
					resources.setGoldCoins(resources.getGoldCoins() + (sellCarbonPrice * xAmount));
				}
				
			}
		});
		sellXCarbon.setBounds(436, 387, 69, 22);
		add(sellXCarbon);
		
		JButton sell1Zera = new JButton("1");
		sell1Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getZera() >= 1) {
					resources.setZera(resources.getZera() - 1);
					resources.setGoldCoins(resources.getGoldCoins() + sellZeraPrice);
					
				}
			}
		});
		sell1Zera.setBounds(138, 415, 53, 22);
		add(sell1Zera);
		
		JButton sell5Zera = new JButton("5");
		sell5Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getZera() >= 5) {
					resources.setZera(resources.getZera() - 5);
					resources.setGoldCoins(resources.getGoldCoins() + (sellZeraPrice * 5));
					
				}
			}
		});
		sell5Zera.setBounds(197, 415, 53, 22);
		add(sell5Zera);
		
		JButton sell10Zera = new JButton("10");
		sell10Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getZera() >= 10) {
					resources.setZera(resources.getZera() - 10);
					resources.setGoldCoins(resources.getGoldCoins() + (sellZeraPrice * 10));
					
				}
			}
		});
		sell10Zera.setBounds(256, 415, 53, 22);
		add(sell10Zera);
		
		JButton sell50Zera = new JButton("50");
		sell50Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getZera() >= 50) {
					resources.setZera(resources.getZera() - 50);
					resources.setGoldCoins(resources.getGoldCoins() + (sellZeraPrice * 50));
					
				}
			}
		});
		sell50Zera.setBounds(315, 415, 53, 22);
		add(sell50Zera);
		
		JButton sell100Zera = new JButton("100");
		sell100Zera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getZera() >= 100) {
					resources.setZera(resources.getZera() - 100);
					resources.setGoldCoins(resources.getGoldCoins() + (sellZeraPrice * 100));
					
				}
			}
		});
		sell100Zera.setBounds(374, 415, 57, 22);
		add(sell100Zera);
		
		JButton sellXZera = new JButton("Sell X");
		sellXZera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = sellXCarbonAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getZera() >= xAmount) {
					resources.setZera(resources.getZera() - xAmount);
					resources.setGoldCoins(resources.getGoldCoins() + (sellZeraPrice * xAmount));
				}
				
			}
		});
		sellXZera.setBounds(436, 415, 69, 22);
		add(sellXZera);
		
		JButton sell1Xerox = new JButton("1");
		sell1Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getXerox() >= 1) {
					resources.setXerox(resources.getXerox() - 1);
					resources.setGoldCoins(resources.getGoldCoins() + sellXeroxPrice);
					
				}
			}
		});
		sell1Xerox.setBounds(138, 443, 53, 22);
		add(sell1Xerox);
		
		JButton sell5Xerox = new JButton("5");
		sell5Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getXerox() >= 5) {
					resources.setXerox(resources.getXerox() - 5);
					resources.setGoldCoins(resources.getGoldCoins() + (sellXeroxPrice * 5));
					
				}
			}
		});
		sell5Xerox.setBounds(197, 443, 53, 22);
		add(sell5Xerox);
		
		JButton sell10Xerox = new JButton("10");
		sell10Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getXerox() >= 10) {
					resources.setXerox(resources.getXerox() - 10);
					resources.setGoldCoins(resources.getGoldCoins() + (sellXeroxPrice * 10));
					
				}
			}
		});
		sell10Xerox.setBounds(256, 443, 53, 22);
		add(sell10Xerox);
		
		JButton sell50Xerox = new JButton("50");
		sell50Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getXerox() >= 50) {
					resources.setXerox(resources.getXerox() - 50);
					resources.setGoldCoins(resources.getGoldCoins() + (sellXeroxPrice * 50));
					
				}
			}
		});
		sell50Xerox.setBounds(315, 443, 53, 22);
		add(sell50Xerox);
		
		JButton sell100Xerox = new JButton("100");
		sell100Xerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getXerox() >= 100) {
					resources.setXerox(resources.getXerox() - 100);
					resources.setGoldCoins(resources.getGoldCoins() + (sellXeroxPrice * 100));
					
				}
			}
		});
		sell100Xerox.setBounds(374, 443, 57, 22);
		add(sell100Xerox);
		
		JButton sellXXerox = new JButton("Sell X");
		sellXXerox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = sellXXeroxAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getXerox() >= xAmount) {
					resources.setXerox(resources.getXerox() - xAmount);
					resources.setGoldCoins(resources.getGoldCoins() + (sellXeroxPrice * xAmount));
				}
				
			}
		});
		sellXXerox.setBounds(436, 443, 69, 22);
		add(sellXXerox);
		
		JButton sell1Fuel = new JButton("1");
		sell1Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getFuel() >= 1) {
					resources.setFuel(resources.getFuel() - 1);
					resources.setGoldCoins(resources.getGoldCoins() + sellFuelPrice);
					
				}
			}
		});
		sell1Fuel.setBounds(138, 471, 53, 22);
		add(sell1Fuel);
		
		JButton sell5Fuel = new JButton("5");
		sell5Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getFuel() >= 5) {
					resources.setFuel(resources.getFuel() - 5);
					resources.setGoldCoins(resources.getGoldCoins() + (sellFuelPrice * 5));
					
				}
			}
		});
		sell5Fuel.setBounds(197, 471, 53, 22);
		add(sell5Fuel);
		
		JButton sell10Fuel = new JButton("10");
		sell10Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getFuel() >= 10) {
					resources.setFuel(resources.getFuel() - 10);
					resources.setGoldCoins(resources.getGoldCoins() + (sellFuelPrice * 10));
					
				}
			}
		});
		sell10Fuel.setBounds(256, 471, 53, 22);
		add(sell10Fuel);
		
		JButton sell50Fuel = new JButton("50");
		sell50Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getFuel() >= 50) {
					resources.setFuel(resources.getFuel() - 50);
					resources.setGoldCoins(resources.getGoldCoins() + (sellFuelPrice * 50));
					
				}
			}
		});
		sell50Fuel.setBounds(315, 471, 53, 22);
		add(sell50Fuel);
		
		JButton sell100Fuel = new JButton("100");
		sell100Fuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (resources.getFuel() >= 100) {
					resources.setFuel(resources.getFuel() - 100);
					resources.setGoldCoins(resources.getGoldCoins() + (sellFuelPrice * 100));
					
				}
			}
		});
		sell100Fuel.setBounds(374, 471, 57, 22);
		add(sell100Fuel);
		
		JButton sellXFuel = new JButton("Sell X");
		sellXFuel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String text = sellXFuelAmount.getText();
				int xAmount = Integer.parseInt(text);
				
				if (resources.getFuel() >= xAmount) {
					resources.setFuel(resources.getFuel() - xAmount);
					resources.setGoldCoins(resources.getGoldCoins() + (sellFuelPrice * xAmount));
				}
				
			}
		});
		sellXFuel.setBounds(436, 471, 69, 22);
		add(sellXFuel);
		
		sellCarbonLabel.setBounds(578, 387, 121, 22);
		add(sellCarbonLabel);
		
		sellZeraLabel.setBounds(578, 415, 101, 22);
		add(sellZeraLabel);
		
		sellXeroxLabel.setBounds(578, 443, 101, 22);
		add(sellXeroxLabel);
		
		sellFuelLabel.setBounds(578, 471, 101, 22);
		add(sellFuelLabel);
		
		buyCarbonLabel.setBounds(578, 168, 121, 22);
		add(buyCarbonLabel);
		
		buyZeraLabel.setBounds(578, 196, 101, 22);
		add(buyZeraLabel);
		
		buyXeroxLabel.setBounds(578, 224, 101, 22);
		add(buyXeroxLabel);
		
		buyFuelLabel.setBounds(578, 252, 101, 22);
		add(buyFuelLabel);
		
		//Text fields where the user inputs a value to be submitted when buying/selling X amount of a resource.
		
		buyXCarbonAmount = new JTextField();
		buyXCarbonAmount.setBounds(510, 169, 57, 22);
		add(buyXCarbonAmount);
		buyXCarbonAmount.setColumns(10);
		
		buyXZeraAmount = new JTextField();
		buyXZeraAmount.setColumns(10);
		buyXZeraAmount.setBounds(510, 197, 57, 22);
		add(buyXZeraAmount);
		
		buyXXeroxAmount = new JTextField();
		buyXXeroxAmount.setColumns(10);
		buyXXeroxAmount.setBounds(510, 225, 57, 22);
		add(buyXXeroxAmount);
		
		buyXFuelAmount = new JTextField();
		buyXFuelAmount.setColumns(10);
		buyXFuelAmount.setBounds(510, 253, 57, 22);
		add(buyXFuelAmount);
		
		sellXCarbonAmount = new JTextField();
		sellXCarbonAmount.setColumns(10);
		sellXCarbonAmount.setBounds(510, 387, 57, 22);
		add(sellXCarbonAmount);
		
		sellXZeraAmount = new JTextField();
		sellXZeraAmount.setColumns(10);
		sellXZeraAmount.setBounds(510, 415, 57, 22);
		add(sellXZeraAmount);
		
		sellXXeroxAmount = new JTextField();
		sellXXeroxAmount.setColumns(10);
		sellXXeroxAmount.setBounds(510, 443, 57, 22);
		add(sellXXeroxAmount);
		
		sellXFuelAmount = new JTextField();
		sellXFuelAmount.setColumns(10);
		sellXFuelAmount.setBounds(510, 471, 57, 22);
		add(sellXFuelAmount);
		
		JLabel lblBuy = new JLabel("BUY");
		lblBuy.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblBuy.setBounds(315, 279, 69, 39);
		add(lblBuy);
		
		JLabel lblSell = new JLabel("SELL");
		lblSell.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblSell.setBounds(310, 336, 85, 39);
		add(lblSell);

	}
	
	/*
	 * Below are get and set functions for all the resource buy and sell prices. The set functions also automatically format the price to 1 decimal place
	 * and update the label to be the correct price after it has been set.
	 */
	
	public double getBuyCarbonPrice() {
		return buyCarbonPrice;
	}


	public void setBuyCarbonPrice(double buyCarbonPrice) {
		String dx = df2.format(buyCarbonPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.buyCarbonPrice = Double.valueOf(dx);
		buyCarbonLabel.setText(df2.format(buyCarbonPrice) + "gc Per Carbon");
	}


	public double getSellCarbonPrice() {
		return sellCarbonPrice;
	}


	public void setSellCarbonPrice(double sellCarbonPrice) {
		String dx = df2.format(sellCarbonPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.sellCarbonPrice = Double.valueOf(dx);
		sellCarbonLabel.setText(df2.format(sellCarbonPrice) + "gc Per Carbon");
	}


	public double getBuyZeraPrice() {
		return buyZeraPrice;
	}


	public void setBuyZeraPrice(double buyZeraPrice) {
		String dx = df2.format(buyZeraPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.buyZeraPrice = Double.valueOf(dx);
		buyZeraLabel.setText(df2.format(buyZeraPrice) + "gc Per Zera");
	}


	public double getSellZeraPrice() {
		return sellZeraPrice;
	}


	public void setSellZeraPrice(double sellZeraPrice) {
		String dx = df2.format(sellZeraPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.sellZeraPrice = Double.valueOf(dx);
		sellZeraLabel.setText(df2.format(sellZeraPrice) + "gc Per Zera");
	}


	public double getBuyXeroxPrice() {
		return buyXeroxPrice;
	}


	public void setBuyXeroxPrice(double buyXeroxPrice) {
		String dx = df2.format(buyXeroxPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.buyXeroxPrice = Double.valueOf(dx);
		buyXeroxLabel.setText(df2.format(buyXeroxPrice) + "gc Per Xerox");
	}


	public double getSellXeroxPrice() {
		return sellXeroxPrice;
	}


	public void setSellXeroxPrice(double sellXeroxPrice) {
		String dx = df2.format(sellXeroxPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.sellXeroxPrice = Double.valueOf(dx);
		sellXeroxLabel.setText(df2.format(sellXeroxPrice) + "gc Per Xerox");
	}


	public double getBuyFuelPrice() {
		return buyFuelPrice;
	}


	public void setBuyFuelPrice(double buyFuelPrice) {
		String dx = df2.format(buyFuelPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.buyFuelPrice = Double.valueOf(dx);
		buyFuelLabel.setText(df2.format(buyFuelPrice) + "gc Per Fuel");
	}


	public double getSellFuelPrice() {
		return sellFuelPrice;
	}


	public void setSellFuelPrice(double sellFuelPrice) {
		String dx = df2.format(sellFuelPrice); //Formatting to make sure only 1 decimal place is displayed. 
		Zota.sellFuelPrice = Double.valueOf(dx);
		sellFuelLabel.setText(df2.format(sellFuelPrice) + "gc Per Fuel");
	}
	
	/**
	 * Reset prices back to the default values set in this function.
	 */
	
	public void resetPrices() {
		setBuyCarbonPrice(20);
		setSellCarbonPrice(getBuyCarbonPrice() / 1.5);
		setBuyZeraPrice(10);
		setSellZeraPrice(getBuyZeraPrice() / 1.5);
		setBuyXeroxPrice(10);
		setSellXeroxPrice(getBuyXeroxPrice() / 1.5);
		setBuyFuelPrice(150);
		setSellFuelPrice(getBuyFuelPrice() / 1.5);
	}

	
	
}
