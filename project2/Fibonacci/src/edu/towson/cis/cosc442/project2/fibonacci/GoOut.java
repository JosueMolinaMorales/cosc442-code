package edu.towson.cis.cosc442.project2.fibonacci;

public class GoOut {
	public boolean goOut(int hoursStudied, int moneyInWallet, boolean friendsAround, String dayOfWeek) {
		boolean canGoOut = false;
		int studyHours = 5;
		int moneyNeeded = 20;
		
		if ( (moneyInWallet >= moneyNeeded) || (dayOfWeek.equals("Thursday") && friendsAround) ) {
			canGoOut = true;
		}
		
		if ( (hoursStudied >= studyHours) && (moneyInWallet >= moneyNeeded) && friendsAround) {
			canGoOut = true;
		}
		
		return canGoOut;
	}
}
