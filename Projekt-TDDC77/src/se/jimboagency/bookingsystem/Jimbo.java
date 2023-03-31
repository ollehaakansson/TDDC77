package se.jimboagency.bookingsystem;
import se.jimboagency.bookingsystem.logic.LogicManager;
import se.jimboagency.bookingsystem.ui.*;

public class Jimbo {

	public static void main(String[] args) {
		
		LogicManager logicManager = new LogicManager(args);
		UIManager uiManager = new UIManager(logicManager);
		
		uiManager.login(args);
	}

}