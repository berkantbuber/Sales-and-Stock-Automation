package test;

import javax.swing.SwingUtilities;

import DAL.ProductDAL;
import FE.LoginFE;
import FE.MainDisplay;


public class Run {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				//new MainDisplay();
				new LoginFE();
	 			new ProductDAL().GetAll();
				
			}
		});
		

	}

}
