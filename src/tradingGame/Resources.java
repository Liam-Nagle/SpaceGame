package tradingGame;

import java.text.DecimalFormat;
import java.util.Observable;

public class Resources extends Observable {
	
	public static double zera = 100;
	public static double xerox = 100;
	public static double carbon = 100;
	public static double fuel = 10;
	public static double goldCoins = 100000;
	public static double zerasec = 0;
	public static double xeroxsec = 0;
	public static double carbonsec = 0;
	public static double fuelsec = 0;
	
	private static DecimalFormat df2 = new DecimalFormat(".#");

	/**
	 * Constructor can be used to set values of all fields.
	 */
	public Resources(double zera, double xerox, double carbon, double fuel, double goldCoins, double zerasec, double xeroxsec, double carbonsec, double fuelsec) {
		Resources.zera = zera;
		Resources.xerox = xerox;
		Resources.carbon = carbon;
		Resources.fuel = fuel;
		Resources.goldCoins = goldCoins;
		Resources.zerasec = zerasec;
		Resources.xeroxsec = xeroxsec;
		Resources.carbonsec = carbonsec;
		Resources.fuelsec = fuelsec;
	}
	
	/**
	 * Default constructor. All values are default.
	 */
	public Resources() {
		
	}

	public double getZera() {
		return zera;
	}


	public void setZera(double zera) {
		this.zera = zera;
	}


	public double getXerox() {
		return xerox;
	}


	public void setXerox(double xerox) {
		this.xerox = xerox;
	}


	public double getCarbon() {
		return carbon;
	}


	public void setCarbon(double carbon) {
		this.carbon = carbon;
	}


	public double getFuel() {
		return fuel;
	}


	public void setFuel(double fuel) {
		String dx = df2.format(fuel); //Formatting to make sure only 1 decimal place is displayed. 
		this.fuel = Double.valueOf(dx);
	}


	public double getGoldCoins() {
		return goldCoins;
	}


	public void setGoldCoins(double goldCoins) {
		String dx = df2.format(goldCoins); //Formatting to make sure only 1 decimal place is displayed. 
		this.goldCoins = Double.valueOf(dx);
	}


	public double getZerasec() {
		return zerasec;
	}


	public void setZerasec(double zerasec) {
		this.zerasec = zerasec;
	}


	public double getXeroxsec() {
		return xeroxsec;
	}


	public void setXeroxsec(double xeroxsec) {
		this.xeroxsec = xeroxsec;
	}


	public double getFuelsec() {
		return fuelsec;
	}


	public void setFuelsec(double fuelsec) {
		String dx = df2.format(fuelsec); //Formatting to make sure only 1 decimal place is displayed. 
		this.fuelsec = Double.valueOf(dx);
	}


	public double getCarbonsec() {
		return carbonsec;
	}


	public void setCarbonsec(double carbonsec) {
		this.carbonsec = carbonsec;
	}

}
