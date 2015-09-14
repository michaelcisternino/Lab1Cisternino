/* @author Michael Cisternino
 * Lab 1
 * September 14, 2015
 */

package socialSecurity;

import org.apache.poi.ss.formula.functions.FinanceLib;
import java.util.Scanner;

/* 
 * Main accepts inputs from the user, that is how many years the user plans to work,
 * his expected average return on investment before and after retirement, how long
 * he would like to draw from the investment, what income is required, and his expected
 * social security income. It then implements PV and PMT functions from FinanceLib to
 * calculate how much money must be saved monthly to have enough money saved for
 * this desired social security amount.
 */

public class Main {

/* main uses Scanner to accept inputs from the user and plugs them into the PV and PMT
 * functions from FinanceLib.
 */
	public static void main(String[] args) {
			boolean t;
			double f;
			double p;
			Scanner scan = new Scanner(System.in);
			double n;
			System.out.println("How many years do you plan to work?");
			n=scan.nextDouble();
			double r;
			System.out.println("What is your expected average return on investment?");
			r=scan.nextDouble();
			double q;
			System.out.println("What is your expected average return on investment after retiring?");
			q=scan.nextDouble();
			double x;
			System.out.println("How long would you like to draw from the investment?");
			x=scan.nextDouble();
			double y;
			System.out.println("What income is required?");
			y=scan.nextDouble();
			double s;
			System.out.println("What is your expected SSI income?");
			s=scan.nextDouble();
			
			double PV;
			// pv is a present value formula from FinanceLib
			q = (q / 12);
			x = x * 12;
			y = y-s;
			f = 0;
			t = false;
			
			PV = FinanceLib.pv(q,x,y,f,t);
			
			double PMT;
			//pmt is a loan formula from FinanceLib
			r = (r / 12);
			n = n * 12;
			p = 0;
			f = PV;
			t = false;
			
			PMT = FinanceLib.pmt(r,  n,  p, f, t);
			System.out.println("You must save $" + PMT + " monthly to have $" + PV + " dollars saved.");
			
	}
	 
}

