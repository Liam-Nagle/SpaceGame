package tradingGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Production extends JPanel {
	
	//Calls in Resources
	
	/**
	 * Default Generated Serial Version ID.
	 */
	private static final long serialVersionUID = 1L;

	private Resources resources = new Resources();
	
	//Buttons to mass buy Buildings
	
	private JRadioButton productionBtnOne = new JRadioButton("1");
	private JRadioButton productionBtnFive = new JRadioButton("5");
	private JRadioButton productionBtnTen = new JRadioButton("10");
	
	//Labels for Buildings Owned and Cost of Next Building.
	
	private JLabel cBuildingOwned = new JLabel("");
	private JLabel zBuildingOwned = new JLabel("");
	private JLabel xBuildingOwned = new JLabel("");
	private JLabel rfBuildingOwned = new JLabel("");
	private JLabel czBuildingOwned = new JLabel("");
	private JLabel cxBuildingOwned = new JLabel("");
	private JLabel cfBuildingOwned = new JLabel("");
	private JLabel zxBuildingOwned = new JLabel("");
	private JLabel zfBuildingOwned = new JLabel("");
	private JLabel xfBuildingOwned = new JLabel("");
	private JLabel massBuildingOwned = new JLabel("");
	
	private JLabel cBuildingCost = new JLabel("");
	private JLabel zBuildingCost = new JLabel("");
	private JLabel xBuildingCost = new JLabel("");
	private JLabel fBuildingCost = new JLabel("");
	private JLabel czBuildingCost = new JLabel("");
	private JLabel cxBuildingCost = new JLabel("");
	private JLabel cfBuildingCost = new JLabel("");
	private JLabel zxBuildingCost = new JLabel("");
	private JLabel zfBuildingCost = new JLabel("");
	private JLabel xfBuildingCost = new JLabel("");
	private JLabel massBuildingCost = new JLabel("");
	
	
	
	//Radio Button Values. For each Building.
	
	private int cAmount = 0;
	private int zAmount = 0;
	private int xAmount = 0;
	private int fAmount = 0;
	private int czAmount = 0;
	private int cxAmount = 0;
	private int cfAmount = 0;
	private int zxAmount = 0;
	private int zfAmount = 0;
	private int xfAmount = 0;
	private int mAmount = 0;
	
	//Total Building Count to display in Labels
	
	private int totalCarbonBuildings = 0;
	private int totalZeraBuildings = 0;
	private int totalXeroxBuildings = 0;
	private int totalFuelBuildings = 0;
	private int totalCZBuildings = 0;
	private int totalCXBuildings = 0;
	private int totalCFBuildings = 0;
	private int totalZXBuildings = 0;
	private int totalZFBuildings = 0;
	private int totalXFBuildings = 0;
	private int totalMassBuildings = 0;
	
	//Cost Of all Buildings. Cost for next Building is calculated within each button
	
	private int cInitialCost = 50;
	private int cCost = cInitialCost * cAmount; 
	private int zInitialCost = 50;
	private int zCost = zInitialCost * zAmount; 
	private int xInitialCost = 50;
	private int xCost = xInitialCost * xAmount; 
	private int fInitialCost = 50;
	private int fCost = fInitialCost * fAmount; 
	private int czInitialCost = 200;
	private int czCost = czInitialCost * czAmount;
	private int cxInitialCost = 200;
	private int cxCost = cxInitialCost * cxAmount; 
	private int cfInitialCost = 200;
	private int cfCost = cfInitialCost * cfAmount;
	private int zxInitialCost = 200;
	private int zxCost = zxInitialCost * zxAmount;
	private int zfInitialCost = 200; 
	private int zfCost = zfInitialCost * zfAmount;
	private int xfInitialCost = 200;
	private int xfCost = xfInitialCost * xfAmount;
	private int mInitialCost = 500;
	private int mCost = mInitialCost * mAmount;
	
	//Count for Upgrade 2 on each Building.
	
	private int cU2Count = 0;
	private int zU2Count = 0;
	private int xU2Count = 0;
	private int fU2Count = 0;
	private int czU2Count = 0;
	private int cxU2Count = 0;
	private int cfU2Count = 0;
	private int zxU2Count = 0;
	private int zfU2Count = 0;
	private int xfU2Count = 0;
	private int massU2Count = 0;

	/**
	 * Create the panel.
	 */
	public Production() {
		setLayout(null);
		
		productionBtnOne.setSelected(true);
		productionBtnOne.setBounds(61, 7, 40, 23);
		add(productionBtnOne);
		
		productionBtnFive.setBounds(105, 7, 40, 23);
		add(productionBtnFive);
		
		productionBtnTen.setBounds(149, 7, 46, 23);
		add(productionBtnTen);
		
		//Creates a button group to allow only one Production Button to be selected
		
		ButtonGroup productionGroup = new ButtonGroup();
		productionGroup.add(productionBtnOne);
		productionGroup.add(productionBtnFive);
		productionGroup.add(productionBtnTen);
		
		JButton carbonBuilding = new JButton("Carbon Generator");
		carbonBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																//Checking which button is selected to allow mass buying of Buildings.
					cAmount = 1;
				} else if (productionBtnFive.isSelected()) { 														// Sets amount to buy based on which button is selected
					cAmount = 5;
				} else {
					cAmount = 10;
				}
				
				if (resources.getGoldCoins() >= cCost) { 															//Checks if you can afford the building
					if (cU2Count > 0) { 																			//Checks to see if any Cost Upgrades have been brought.
						cInitialCost = cInitialCost + (totalCarbonBuildings * totalCarbonBuildings);
						cCost = cInitialCost * cAmount;
						if(cU2Count == 1) { 																		//Checks to see how many. If only 1 half the price.
							cCost= cCost / 2;
						} else { 																					//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							cCost = cCost / cU2Count;
						}
						totalCarbonBuildings = totalCarbonBuildings + cAmount; 										// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - cCost);		
						resources.setCarbonsec(resources.getCarbonsec() + cAmount); 								//Sets carbon/s label to correct number
						cBuildingOwned.setText(totalCarbonBuildings + ""); 											//Sets amount owned label to correct number
						int nextCost = cInitialCost + (totalCarbonBuildings * totalCarbonBuildings);
						cBuildingCost.setText(nextCost + "");
					} else {
						cInitialCost = cInitialCost + (totalCarbonBuildings * totalCarbonBuildings);
						cCost = cInitialCost * cAmount;
						totalCarbonBuildings = totalCarbonBuildings + cAmount; 										// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - cCost);
						resources.setCarbonsec(resources.getCarbonsec() + cAmount); 								//Sets carbon/s label to correct number
						cBuildingOwned.setText(totalCarbonBuildings + ""); 											//Sets amount owned label to correct number
						int nextCost = cInitialCost + (totalCarbonBuildings * totalCarbonBuildings);
						cBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cCost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins.
				}

			}
		});
		carbonBuilding.setBounds(10, 35, 238, 45);
		add(carbonBuilding);
		
		JButton zeraBuilding = new JButton("Zera Generator");
		zeraBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																//Checking which button is selected to allow mass buying of Buildings.
					zAmount = 1;
				} else if (productionBtnFive.isSelected()) { 														// Sets amount to buy based on which button is selected
					zAmount = 5;
				} else {
					zAmount = 10;
				}
				
				if (resources.getGoldCoins() >= zCost) { 															//Checks if you can afford the building
					if (zU2Count > 0) { 																			//Checks to see if any Cost Upgrades have been brought.
						zInitialCost = zInitialCost + (totalZeraBuildings * totalZeraBuildings);
						zCost = zInitialCost * zAmount;
						if(zU2Count == 1) { 																		//Checks to see how many. If only 1 half the price.
							zCost= zCost / 2;		
						} else { 																					//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							zCost = zCost / zU2Count;
						}
						totalZeraBuildings = totalZeraBuildings + zAmount; 											// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - zCost);
						resources.setZerasec(resources.getZerasec() + zAmount); 						
						zBuildingOwned.setText(totalZeraBuildings + "");
						int nextCost = zInitialCost + (totalZeraBuildings * totalZeraBuildings);
						zBuildingCost.setText(nextCost + "");
					} else {
					zInitialCost = zInitialCost + (totalZeraBuildings * totalZeraBuildings);
					zCost = zInitialCost * zAmount;
					totalZeraBuildings = totalZeraBuildings + zAmount; 												// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - zCost);
					resources.setZerasec(resources.getZerasec() + zAmount); 
					zBuildingOwned.setText(totalZeraBuildings + ""); 												//Sets amount owned label to correct number
					int nextCost = zInitialCost + (totalZeraBuildings * totalZeraBuildings);
					zBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + zCost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins.
				}
				
			}
		});
		zeraBuilding.setBounds(10, 81, 238, 45);
		add(zeraBuilding);
		
		JButton xeroxBuilding = new JButton("Xerox Generator");
		xeroxBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																//Checking which button is selected to allow mass buying of Buildings.
					xAmount = 1;
				} else if (productionBtnFive.isSelected()) { 														// Sets amount to buy based on which button is selected
					xAmount = 5;
				} else {
					xAmount = 10;
				}
				
				if (resources.getGoldCoins() >= xCost) { 															//Checks if you can afford the building
					if (xU2Count > 0) { 																			//Checks to see if any Cost Upgrades have been brought.
						xInitialCost = xInitialCost + (totalXeroxBuildings * totalZeraBuildings);
						xCost = xInitialCost * xAmount;
						if(xU2Count == 1) { 																		//Checks to see how many. If only 1 half the price.
							xCost= xCost / 2;
						} else { 																					//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							xCost = xCost / xU2Count;
						}
						totalXeroxBuildings = totalXeroxBuildings + xAmount; 										// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - xCost);
						resources.setXeroxsec(resources.getXeroxsec() + xAmount); 						
						xBuildingOwned.setText(totalXeroxBuildings + "");
						int nextCost = xInitialCost + (totalXeroxBuildings * totalXeroxBuildings);
						xBuildingCost.setText(nextCost + "");
					} else {
					xInitialCost = xInitialCost + (totalXeroxBuildings * totalXeroxBuildings);
					xCost = xInitialCost * xAmount;
					totalXeroxBuildings = totalXeroxBuildings + xAmount; 											// Adds buildings brought to total
					resources.setGoldCoins(resources.getGoldCoins() - xCost);
					resources.setXeroxsec(resources.getXeroxsec() + xAmount); 
					xBuildingOwned.setText(totalXeroxBuildings + ""); 												//Sets amount owned label to correct number
					int nextCost = xInitialCost + (totalXeroxBuildings * totalXeroxBuildings);
					xBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + xCost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins.
				}
				
			}
		});
		xeroxBuilding.setBounds(10, 127, 238, 45);
		add(xeroxBuilding);
		
		JButton fuelBuilding = new JButton("Fuel Generator");
		fuelBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																//Checking which button is selected to allow mass buying of Buildings.
					fAmount = 1;
				} else if (productionBtnFive.isSelected()) { 														// Sets amount to buy based on which button is selected
					fAmount = 5;
				} else {
					fAmount = 10;
				}
				
				if (resources.getGoldCoins() >= fCost) { 															//Checks if you can afford the building
					if (fU2Count > 0) { 																			//Checks to see if any Cost Upgrades have been brought.
						fInitialCost = fInitialCost + (totalFuelBuildings * totalFuelBuildings);
						fCost = fInitialCost * fAmount;
						if(fU2Count == 1) { 																		//Checks to see how many. If only 1 half the price.
							fCost= fCost / 2;
						} else { 																					//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							fCost = fCost / fU2Count;
						}
						totalFuelBuildings = totalFuelBuildings + fAmount; 											// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - fCost);
						resources.setFuelsec(resources.getFuelsec() + fAmount - (0.9 * fAmount)); 						
						rfBuildingOwned.setText(totalFuelBuildings + "");
						int nextCost = fInitialCost + (totalFuelBuildings * totalFuelBuildings);
						fBuildingCost.setText(nextCost + "");
					} else {
					fInitialCost = fInitialCost + (totalFuelBuildings * totalFuelBuildings);
					fCost = fInitialCost * fAmount;
					totalFuelBuildings = totalFuelBuildings + fAmount; 												// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - fCost);
					resources.setFuelsec(resources.getFuelsec() + (fAmount - (0.9 * fAmount)));
					rfBuildingOwned.setText(totalFuelBuildings + ""); 												//Sets amount owned label to correct number
					int nextCost = fInitialCost + (totalFuelBuildings * totalFuelBuildings);
					fBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + fCost + " Gold Coins");//Displays a dialog box if you don't have enough Gold Coins.
				}
				
			}
		});
		fuelBuilding.setBounds(10, 173, 238, 45);
		add(fuelBuilding);
		
		JButton czBuilding = new JButton("Carbon and Zera Generator");
		czBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																//Checking which button is selected to allow mass buying of Buildings.
					czAmount = 1;
				} else if (productionBtnFive.isSelected()) { 														// Sets amount to buy based on which button is selected
					czAmount = 5;
				} else {
					czAmount = 10;
				}
				
				if (resources.getGoldCoins() >= czCost) { 															//Checks to see if you have enough Resources to afford the building. Cost/2 split
					if (czU2Count > 0) { 																			//Checks to see if any Cost Upgrades have been brought.
						czInitialCost = czInitialCost + (totalCZBuildings * totalCZBuildings);
						czCost = czInitialCost * czAmount;
						if(czU2Count == 1) { 																		//Checks to see how many. If only 1 half the price.
							czCost= czCost / 2;
						} else { 																					//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							czCost = czCost / czU2Count;
						}
						totalCZBuildings = totalCZBuildings + czAmount; 											// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - czCost);
						resources.setCarbonsec(resources.getCarbonsec() + 2*czAmount); 						
						resources.setZerasec(resources.getZerasec() + 2*czAmount);
						czBuildingOwned.setText(totalCZBuildings + "");
						int nextCost = czInitialCost + (totalCZBuildings * totalCZBuildings);
						czBuildingCost.setText(nextCost + "");
					} else {
					czInitialCost = czInitialCost + (totalCZBuildings * totalCZBuildings);
					czCost = czInitialCost * czAmount;
					totalCZBuildings = totalCZBuildings + czAmount; 													// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - czCost);
					resources.setCarbonsec((resources.getCarbonsec()) + 2*czAmount);
					resources.setZerasec((resources.getZerasec()) + 2*czAmount);
					czBuildingOwned.setText(totalCZBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = czInitialCost + (totalCZBuildings * totalCZBuildings);
					czBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + czCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins.
				}
				
			}
		});
		czBuilding.setBounds(10, 219, 238, 45);
		add(czBuilding);
		
		JButton cxBuilding = new JButton("Carbon and Xerox Generator");
		cxBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					cxAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					cxAmount = 5;
				} else {
					cxAmount = 10;
				}
				
				if (resources.getGoldCoins() >= cxCost) { 																//Checks to see if you have enough Resources to afford the building
					if (cxU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						cxInitialCost = cxInitialCost + (totalCXBuildings * totalCXBuildings);
						cxCost = cxInitialCost * cxAmount;
						if(cxU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							cxCost= cxCost / 2;	
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							cxCost = cxCost / cxU2Count;
						}
						totalCXBuildings = totalCXBuildings + cxAmount; 												// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - cxCost);
						resources.setCarbonsec(resources.getCarbonsec() + 2*cxAmount); 						
						resources.setXeroxsec(resources.getXeroxsec() + 2*cxAmount);
						cxBuildingOwned.setText(totalCXBuildings + "");
						int nextCost = cxInitialCost + (totalCXBuildings * totalCXBuildings);
						cxBuildingCost.setText(nextCost + "");
					} else {
					cxInitialCost = cxInitialCost + (totalCXBuildings * totalCXBuildings);
					cxCost = cxInitialCost * cxAmount;
					totalCXBuildings = totalCXBuildings + cxAmount; 													// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - cxCost);
					resources.setCarbonsec((resources.getCarbonsec()) + 2*cxAmount);
					resources.setXeroxsec((resources.getXeroxsec()) + 2*cxAmount); 										
					cxBuildingOwned.setText(totalCXBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = cxInitialCost + (totalCXBuildings * totalCXBuildings);
					cxBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cxCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins.
				}
			}
		});
		cxBuilding.setBounds(10, 265, 238, 45);
		add(cxBuilding);
		
		JButton cfBuilding = new JButton("Carbon and Fuel Generator");
		cfBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					cfAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					cfAmount = 5;
				} else {
					cfAmount = 10;
				}
				
				if (resources.getGoldCoins() >= cfCost) { 																//Checks to see if you have enough Resources to afford the building. Cost/2 split
					if (cfU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						cfInitialCost = cfInitialCost + (totalCFBuildings * totalCFBuildings);
						cfCost = cfInitialCost * cfAmount;
						if(cfU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							cfCost= cfCost / 2;
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							cfCost = cfCost / cfU2Count;
						}
						totalCFBuildings = totalCFBuildings + cfAmount; 												// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - cfCost);
						resources.setCarbonsec(resources.getCarbonsec() + 2*cfAmount); 						
						resources.setFuelsec(resources.getFuelsec() + 2*cfAmount);
						cfBuildingOwned.setText(totalCFBuildings + "");
						int nextCost = cfInitialCost + (totalCFBuildings * totalCFBuildings);
						cfBuildingCost.setText(nextCost + "");
					} else {
					cfInitialCost = cfInitialCost + (totalCFBuildings * totalCFBuildings);
					cfCost = cfInitialCost * cfAmount;
					totalCFBuildings = totalCFBuildings + cfAmount; 													// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - cfCost);
					resources.setCarbonsec((resources.getCarbonsec()) + 2*cfAmount); 									
					resources.setFuelsec((resources.getFuelsec()) + 2*cfAmount); 										
					cfBuildingOwned.setText(totalCFBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = cfInitialCost + (totalCFBuildings * totalCFBuildings);
					cfBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cfCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins.
				}
			}
		});
		cfBuilding.setBounds(10, 311, 238, 45);
		add(cfBuilding);
		
		JButton zxBuilding = new JButton("Zera and Xerox Generator");
		zxBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					zxAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					zxAmount = 5;
				} else {
					zxAmount = 10;
				}
				
				if (resources.getGoldCoins() >= zxCost) { 																//Checks to see if you have enough Resources to afford the building. Cost/2 split
					if (zxU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						zxInitialCost = zxInitialCost + (totalZXBuildings * totalZXBuildings);
						zxCost = zxInitialCost * zxAmount;
						if(zxU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							zxCost= zxCost / 2;
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							zxCost = zxCost / zxU2Count;
						}
						totalZXBuildings = totalZXBuildings + zxAmount; 												// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - zxCost);
						resources.setZerasec(resources.getZerasec() + 2*zxAmount); 						
						resources.setXeroxsec(resources.getXeroxsec() + 2*zxAmount);
						zxBuildingOwned.setText(totalZXBuildings + "");
						int nextCost = zxInitialCost + (totalZXBuildings * totalZXBuildings);
						zxBuildingCost.setText(nextCost + "");
					} else {
					zxInitialCost = zxInitialCost + (totalZXBuildings * totalZXBuildings);
					zxCost = zxInitialCost * zxAmount;
					totalZXBuildings = totalZXBuildings + zxAmount; 													// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - zxCost);
					resources.setZerasec((resources.getZerasec()) + 2*zxAmount); 
					resources.setXeroxsec((resources.getXeroxsec()) + 2*zxAmount); 
					zxBuildingOwned.setText(totalZXBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = zxInitialCost + (totalZXBuildings * totalZXBuildings);
					zxBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + zxCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins.
				}
			}
		});
		zxBuilding.setBounds(10, 357, 238, 45);
		add(zxBuilding);
		
		JButton zfBuilding = new JButton("Zera and Fuel Generator");
		zfBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					zfAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					zfAmount = 5;
				} else {
					zfAmount = 10;
				}
				
				if (resources.getGoldCoins() >= zfCost) { 																//Checks to see if you have enough Resources to afford the building
					if (zfU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						zfInitialCost = zfInitialCost + (totalZFBuildings * totalZFBuildings);
						zfCost = zfInitialCost * zfAmount;
						if(zfU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							zfCost= zfCost / 2;
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							zfCost = zfCost / zfU2Count;
						}
						totalZFBuildings = totalZFBuildings + zfAmount; 												// Adds buildings brought to total 
						resources.setGoldCoins(resources.getGoldCoins() - zfCost);
						resources.setZerasec((resources.getZerasec()) + 2*zfAmount); 
						resources.setFuelsec((resources.getFuelsec()) + 2*zfAmount); 
						zfBuildingOwned.setText(totalZFBuildings + ""); 												//Sets amount owned label to correct number
						int nextCost = zfInitialCost + (totalZFBuildings * totalZFBuildings);
						zfBuildingCost.setText(nextCost + "");
					} else {
					zfInitialCost = zfInitialCost + (totalZFBuildings * totalZFBuildings);
					zfCost = zfInitialCost * zfAmount;
					totalZFBuildings = totalZFBuildings + zfAmount; 													// Adds buildings brought to total 
					resources.setGoldCoins(resources.getGoldCoins() - zfCost);
					resources.setZerasec((resources.getZerasec()) + 2*zfAmount);
					resources.setFuelsec((resources.getFuelsec()) + 2*zfAmount); 
					zfBuildingOwned.setText(totalZFBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = zfInitialCost + (totalZFBuildings * totalZFBuildings);
					zfBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + zfCost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins.
				}
			}
		});
		zfBuilding.setBounds(10, 403, 238, 45);
		add(zfBuilding);
		
		JButton xfBuilding = new JButton("Xerox and Fuel Generator");
		xfBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					xfAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					xfAmount = 5;
				} else {
					xfAmount = 10;
				}
				
				if (resources.getGoldCoins() >= xfCost) { 																//Checks to see if you have enough Resources to afford the building. Cost/2 split
					if (xfU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						xfInitialCost = xfInitialCost + (totalXFBuildings * totalXFBuildings);
						xfCost = xfInitialCost * xfAmount;
						if(xfU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							xfCost= xfCost / 2;
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							xfCost = xfCost / xfU2Count;
						}
						totalXFBuildings = totalXFBuildings + xfAmount; 												// Adds buildings brought to total
						resources.setGoldCoins(resources.getGoldCoins() - xfCost);
						resources.setXeroxsec((resources.getXeroxsec()) + 2*xfAmount); 						
						resources.setFuelsec((resources.getFuelsec()) + 2*xfAmount); 						
						xfBuildingOwned.setText(totalXFBuildings + "");	 												//Sets amount owned label to correct number
						int nextCost = xfInitialCost + (totalXFBuildings * totalXFBuildings);
						xfBuildingCost.setText(nextCost + "");
					} else {
					xfInitialCost = xfInitialCost + (totalXFBuildings * totalXFBuildings);
					xfCost = xfInitialCost * xfAmount;
					totalXFBuildings = totalXFBuildings + xfAmount; 													// Adds buildings brought to total
					resources.setGoldCoins(resources.getGoldCoins() - xfCost);
					resources.setXeroxsec((resources.getXeroxsec()) + 2*xfAmount); 
					resources.setFuelsec((resources.getFuelsec()) + 2*xfAmount);
					xfBuildingOwned.setText(totalXFBuildings + "");	 													//Sets amount owned label to correct number
					int nextCost = xfInitialCost + (totalXFBuildings * totalXFBuildings);
					xfBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + xfCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins.
				}
			}
		});
		xfBuilding.setBounds(10, 449, 238, 45);
		add(xfBuilding);
		
		JButton massBuilding = new JButton("MASS PRODUCTION");
		massBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (productionBtnOne.isSelected()) { 																	//Checking which button is selected to allow mass buying of Buildings.
					mAmount = 1;
				} else if (productionBtnFive.isSelected()) { 															// Sets amount to buy based on which button is selected
					mAmount = 5;
				} else {
					mAmount = 10;
				}
				
				if (resources.getGoldCoins() >= mCost) {
					if (massU2Count > 0) { 																				//Checks to see if any Cost Upgrades have been brought.
						mInitialCost = mInitialCost + (totalMassBuildings * totalMassBuildings);
						mCost = mInitialCost * mAmount;
						if(massU2Count == 1) { 																			//Checks to see how many. If only 1 half the price.
							mCost= mCost / 2;
						} else { 																						//If more than one then divide the price by the amount owned. 2 = Half 3 = 3rd etc.
							mCost = mCost / massU2Count;
						}
						totalMassBuildings = totalMassBuildings + mAmount;
						resources.setGoldCoins(resources.getGoldCoins() - mCost);
						resources.setCarbonsec((resources.getCarbonsec()) + mAmount);
						resources.setZerasec((resources.getZerasec()) + mAmount);
						resources.setXeroxsec((resources.getXeroxsec()) + mAmount);
						resources.setFuelsec((resources.getFuelsec()) + mAmount);
						massBuildingOwned.setText(totalMassBuildings + ""); 												//Sets amount owned label to correct number
						int nextCost = mInitialCost + (totalMassBuildings * totalMassBuildings);
						massBuildingCost.setText(nextCost + "");
					} else {
					mInitialCost = mInitialCost + (totalMassBuildings * totalMassBuildings);
					mCost = mInitialCost * mAmount;
					totalMassBuildings = totalMassBuildings + mAmount;
					resources.setGoldCoins(resources.getGoldCoins() - mCost);
					resources.setCarbonsec((resources.getCarbonsec()) + mAmount);
					resources.setZerasec((resources.getZerasec()) + mAmount);
					resources.setXeroxsec((resources.getXeroxsec()) + mAmount);
					resources.setFuelsec((resources.getFuelsec()) + mAmount);
					massBuildingOwned.setText(totalMassBuildings + ""); 													//Sets amount owned label to correct number
					int nextCost = mInitialCost + (totalMassBuildings * totalMassBuildings);
					massBuildingCost.setText(nextCost + "");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + mCost + " Gold Coins"); 	//Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		massBuilding.setBounds(10, 495, 238, 45);
		add(massBuilding);
		
		JButton cUpgradeOne = new JButton("U1");
		cUpgradeOne.setToolTipText("Double your Carbon/s");
		cUpgradeOne.addActionListener(new ActionListener() {
			double cU1Count = 1;																					//Count for Upgrade Brought
			double cost = 1500 * cU1Count;																			//Cost of the Upgrade
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {																//Checks if you can afford to buy it.
					cU1Count = cU1Count * 1.5;																		//Calculates the next cost of the Upgrade.
					resources.setCarbonsec(resources.getCarbonsec() * 2);											//Doubles your Carbon/s
					resources.setGoldCoins(resources.getGoldCoins() - cost);										//Removes the Gold coin cost.
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		cUpgradeOne.setBounds(513, 35, 56, 45);
		add(cUpgradeOne);
		
		JButton cUpgradeTwo = new JButton("U2");
		cUpgradeTwo.setToolTipText("Half the Cost of Carbon Generator");
		cUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 500;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalCarbonBuildings == 0) {																//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon' Generators first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						cU2Count++;																					//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalCarbonBuildings * totalCarbonBuildings + 1);						//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(cBuildingCost.getText());
						Cost = Cost / 2;
						cBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		cUpgradeTwo.setBounds(717, 35, 56, 45);
		add(cUpgradeTwo);
		
		JButton zUpgradeOne = new JButton("U1");
		zUpgradeOne.setToolTipText("Double your Zera/s");
		zUpgradeOne.addActionListener(new ActionListener() {
			double zU1Count = 1;
			double cost = 1500 * zU1Count;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					zU1Count = zU1Count * 1.5;
					resources.setZerasec(resources.getZerasec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		zUpgradeOne.setBounds(513, 81, 56, 45);
		add(zUpgradeOne);
		
		JButton zUpgradeTwo = new JButton("U2");
		zUpgradeTwo.setToolTipText("Half the Cost of Zera Generator");
		zUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 500;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalZeraBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Zera' Generators first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						zU2Count++;																					//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalZeraBuildings * totalZeraBuildings + 1);							//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(zBuildingCost.getText());
						Cost = Cost / 2;
						zBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		zUpgradeTwo.setBounds(717, 81, 56, 45);
		add(zUpgradeTwo);
		
		JButton xUpgradeOne = new JButton("U1");
		xUpgradeOne.setToolTipText("Double your Xerox/s");
		xUpgradeOne.addActionListener(new ActionListener() {
			double xU1Count = 1;
			double cost = 1500 * xU1Count;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					xU1Count = xU1Count * 1.5;
					resources.setXeroxsec(resources.getXeroxsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		xUpgradeOne.setBounds(513, 127, 56, 45);
		add(xUpgradeOne);
		
		JButton xUpgradeTwo = new JButton("U2");
		xUpgradeTwo.setToolTipText("Half the Cost of Xerox Generator");
		xUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 500;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalXeroxBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Xerox' Generators first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						xU2Count++;																					//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalXeroxBuildings * totalXeroxBuildings + 1);							//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(xBuildingCost.getText());
						Cost = Cost / 2;
						xBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		xUpgradeTwo.setBounds(717, 127, 56, 45);
		add(xUpgradeTwo);
		
		JButton fUpgradeOne = new JButton("U1");
		fUpgradeOne.setToolTipText("Double your Fuel/s");
		fUpgradeOne.addActionListener(new ActionListener() {
			double fU1Count = 1;
			double cost = 1500 * fU1Count;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					fU1Count = fU1Count * 1.5;
					resources.setFuelsec(resources.getFuelsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		fUpgradeOne.setBounds(513, 173, 56, 45);
		add(fUpgradeOne);
		
		JButton fUpgradeTwo = new JButton("U2");
		fUpgradeTwo.setToolTipText("Half the Cost of Fuel Generator");
		fUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 500;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalFuelBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Fuel' Generators first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						fU2Count++;																					//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalFuelBuildings * totalFuelBuildings + 1);							//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(fBuildingCost.getText());
						Cost = Cost / 2;
						fBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		fUpgradeTwo.setBounds(717, 173, 56, 45);
		add(fUpgradeTwo);
		
		JButton czUpgradeOne = new JButton("U1");
		czUpgradeOne.setToolTipText("Double Carbon and Zera/s");
		czUpgradeOne.addActionListener(new ActionListener() {
			double czU1Count = 1;
			double cost = 3000 * czU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					czU1Count = czU1Count * 1.5;
					resources.setCarbonsec(resources.getCarbonsec() * 2);
					resources.setZerasec(resources.getZerasec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		czUpgradeOne.setBounds(513, 219, 56, 45);
		add(czUpgradeOne);
		
		JButton czUpgradeTwo = new JButton("U2");
		czUpgradeTwo.setToolTipText("Half the Cost of Carbon and Zera Generator");
		czUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalCZBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Zera Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						czU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalCZBuildings * totalCZBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(czBuildingCost.getText());
						Cost = Cost / 2;
						czBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		czUpgradeTwo.setBounds(717, 219, 56, 45);
		add(czUpgradeTwo);
		
		JButton cxUpgradeOne = new JButton("U1");
		cxUpgradeOne.setToolTipText("Double Carbon and Xerox/s");
		cxUpgradeOne.addActionListener(new ActionListener() {
			double cxU1Count = 1;
			double cost = 3000 * cxU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					cxU1Count = cxU1Count * 1.5;
					resources.setCarbonsec(resources.getCarbonsec() * 2);
					resources.setXeroxsec(resources.getXeroxsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		cxUpgradeOne.setBounds(513, 265, 56, 45);
		add(cxUpgradeOne);
		
		JButton cxUpgradeTwo = new JButton("U2");
		cxUpgradeTwo.setToolTipText("Half the Cost of Carbon and Xerox Generator");
		cxUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalCXBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						cxU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalCXBuildings * totalCXBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(cxBuildingCost.getText());
						Cost = Cost / 2;
						cxBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		cxUpgradeTwo.setBounds(717, 265, 56, 45);
		add(cxUpgradeTwo);
		
		JButton cfUpgradeOne = new JButton("U1");
		cfUpgradeOne.setToolTipText("Double Carbon and Fuel/s");
		cfUpgradeOne.addActionListener(new ActionListener() {
			double cfU1Count = 1;
			double cost = 3000 * cfU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					cfU1Count = cfU1Count * 1.5;
					resources.setCarbonsec(resources.getCarbonsec() * 2);
					resources.setFuelsec(resources.getFuelsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		cfUpgradeOne.setBounds(513, 311, 56, 45);
		add(cfUpgradeOne);
		
		JButton cfUpgradeTwo = new JButton("U2");
		cfUpgradeTwo.setToolTipText("Half the Cost of Carbon and Fuel Generator");
		cfUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalCFBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						cfU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalCFBuildings * totalCFBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(cfBuildingCost.getText());
						Cost = Cost / 2;
						cfBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		cfUpgradeTwo.setBounds(717, 311, 56, 45);
		add(cfUpgradeTwo);
		
		JButton zxUpgradeOne = new JButton("U1");
		zxUpgradeOne.setToolTipText("Double Zera and Xerox/s");
		zxUpgradeOne.addActionListener(new ActionListener() {
			double zxU1Count = 1;
			double cost = 3000 * zxU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					zxU1Count = zxU1Count * 1.5;
					resources.setZerasec(resources.getZerasec() * 2);
					resources.setXeroxsec(resources.getXeroxsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		zxUpgradeOne.setBounds(513, 357, 56, 45);
		add(zxUpgradeOne);
		
		JButton zxUpgradeTwo = new JButton("U2");
		zxUpgradeTwo.setToolTipText("Half the Cost of Zera and Xerox Generator");
		zxUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalZXBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						zxU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalZXBuildings * totalZXBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(zxBuildingCost.getText());
						Cost = Cost / 2;
						zxBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		zxUpgradeTwo.setBounds(717, 357, 56, 45);
		add(zxUpgradeTwo);
		
		JButton zfUpgradeOne = new JButton("U1");
		zfUpgradeOne.setToolTipText("Double Zera and Fuel/s");
		zfUpgradeOne.addActionListener(new ActionListener() {
			double zfU1Count = 1;
			double cost = 3000 * zfU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					zfU1Count = zfU1Count * 1.5;
					resources.setZerasec(resources.getZerasec() * 2);
					resources.setFuelsec(resources.getFuelsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		zfUpgradeOne.setBounds(513, 403, 56, 45);
		add(zfUpgradeOne);
		
		JButton zfUpgradeTwo = new JButton("U2");
		zfUpgradeTwo.setToolTipText("Half the Cost of Zera and Fuel Generator");
		zfUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalZFBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						zfU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalZFBuildings * totalZFBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(zfBuildingCost.getText());
						Cost = Cost / 2;
						zfBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		zfUpgradeTwo.setBounds(717, 403, 56, 45);
		add(zfUpgradeTwo);
		
		JButton xfUpgradeOne = new JButton("U1");
		xfUpgradeOne.setToolTipText("Double Xerox and Fuel/s");
		xfUpgradeOne.addActionListener(new ActionListener() {
			double xfU1Count = 1;
			double cost = 3000 * xfU1Count;																			//Double the cost as it increases 2x the resources.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					xfU1Count = xfU1Count * 1.5;
					resources.setXeroxsec(resources.getXeroxsec() * 2);
					resources.setFuelsec(resources.getFuelsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		xfUpgradeOne.setBounds(513, 449, 56, 45);
		add(xfUpgradeOne);
		
		JButton xfUpgradeTwo = new JButton("U2");
		xfUpgradeTwo.setToolTipText("Half the Cost of Xerox and Fuel Generator");
		xfUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalXFBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						xfU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalXFBuildings * totalXFBuildings + 1);								//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(xfBuildingCost.getText());
						Cost = Cost / 2;
						xfBuildingCost.setText(Cost + "");	
					}
				}
			}
		});
		xfUpgradeTwo.setBounds(717, 449, 56, 45);
		add(xfUpgradeTwo);
		
		JButton massUpgradeOne = new JButton("U1");
		massUpgradeOne.setToolTipText("DOUBLE EVERYTHING");
		massUpgradeOne.addActionListener(new ActionListener() {
			double massU1Count = 1;
			double cost = 10000 * massU1Count;																			//Increased cost due to increased resource gain.
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= cost) {
					massU1Count = massU1Count * 1.5;
					resources.setCarbonsec(resources.getCarbonsec() * 2);
					resources.setZerasec(resources.getZerasec() * 2);
					resources.setXeroxsec(resources.getXeroxsec() * 2);
					resources.setFuelsec(resources.getFuelsec() * 2);
					resources.setGoldCoins(resources.getGoldCoins() - cost);
				} else {
					JOptionPane.showMessageDialog(null, "Not enough Gold Coins. You need: " + cost + " Gold Coins"); //Displays a dialog box if you don't have enough Gold Coins
				}
			}
		});
		massUpgradeOne.setBounds(513, 495, 56, 45);
		add(massUpgradeOne);
		
		JButton massUpgradeTwo = new JButton("U2");
		massUpgradeTwo.setToolTipText("Half the Cost of Mass Production");
		massUpgradeTwo.addActionListener(new ActionListener() {;
		private double u2Cost = 1000;
			public void actionPerformed(ActionEvent e) {
				
				if (resources.getGoldCoins() >= u2Cost) { 															//Checks if you can afford the building
					if (totalMassBuildings == 0) {																	//Makes sure you own a building before allowing you to half the cost.
						JOptionPane.showMessageDialog(null, "You must purchase some 'Carbon and Xerox Generators' first!");		//Displays a message if you don't.
					} else {
						resources.setGoldCoins(resources.getGoldCoins() - u2Cost);									//Removes the value from Gold Coins
						massU2Count++;																				//Increments the count for Upgrade 2.
						u2Cost = u2Cost * (totalMassBuildings * totalMassBuildings + 1);							//Calculates the next cost for another Upgrade
						int Cost = Integer.parseInt(massBuildingCost.getText());
						Cost = Cost / 2;
						massBuildingCost.setText(Cost + "");					
						}
				}
			}
		});
		massUpgradeTwo.setBounds(717, 495, 56, 45);
		add(massUpgradeTwo);
		
		zBuildingOwned.setBounds(260, 96, 98, 16);
		add(zBuildingOwned);
		
		xBuildingOwned.setBounds(260, 142, 98, 16);
		add(xBuildingOwned);
		
		cBuildingOwned.setBounds(260, 51, 98, 16);
		add(cBuildingOwned);
		
		rfBuildingOwned.setBounds(260, 188, 98, 16);
		add(rfBuildingOwned);
		
		czBuildingOwned.setBounds(260, 234, 98, 16);
		add(czBuildingOwned);
		
		cxBuildingOwned.setBounds(258, 280, 98, 16);
		add(cxBuildingOwned);
		
		cfBuildingOwned.setBounds(258, 326, 98, 16);
		add(cfBuildingOwned);
		
		zxBuildingOwned.setBounds(258, 372, 98, 16);
		add(zxBuildingOwned);
		
		zfBuildingOwned.setBounds(258, 418, 98, 16);
		add(zfBuildingOwned);
		
		xfBuildingOwned.setBounds(258, 464, 98, 16);
		add(xfBuildingOwned);
		
		massBuildingOwned.setBounds(258, 510, 98, 16);
		add(massBuildingOwned);
		
		cBuildingCost.setBounds(368, 50, 98, 16);
		add(cBuildingCost);
		
		JLabel lblBuildingsOwned = new JLabel("Buildings Owned");
		lblBuildingsOwned.setBounds(254, 11, 90, 14);
		add(lblBuildingsOwned);
		
		zBuildingCost.setBounds(368, 96, 98, 16);
		add(zBuildingCost);
		
		xBuildingCost.setBounds(368, 142, 98, 16);
		add(xBuildingCost);
		
		fBuildingCost.setBounds(368, 188, 98, 16);
		add(fBuildingCost);
		
		czBuildingCost.setBounds(368, 234, 98, 16);
		add(czBuildingCost);
		
		cxBuildingCost.setBounds(366, 280, 98, 16);
		add(cxBuildingCost);
		
		cfBuildingCost.setBounds(366, 326, 98, 16);
		add(cfBuildingCost);
		
		zxBuildingCost.setBounds(366, 372, 98, 16);
		add(zxBuildingCost);
		
		zfBuildingCost.setBounds(366, 418, 98, 16);
		add(zfBuildingCost);
		
		xfBuildingCost.setBounds(366, 464, 98, 16);
		add(xfBuildingCost);
		
		massBuildingCost.setBounds(366, 510, 98, 16);
		add(massBuildingCost);
		
		JLabel lblBuildingCost = new JLabel("Next Building Cost (1)");
		lblBuildingCost.setBounds(368, 11, 113, 14);
		add(lblBuildingCost);
		
	}
}
