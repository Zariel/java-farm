/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farm;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chris
 */
public class Main {
	public static ArrayList chickens = new ArrayList();

	/**
	* @param args the command line arguments
	*/

	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			chickens.add(new Chicken());
		}

		ArrayList mates = new ArrayList();

		int day = 0;
		Random r = new Random();
		Chicken chick;

		while(day < 10) {
			// 4 Chickens,
			mates.clear();
			for(int i = 0; i < chickens.size(); i++) {
				chick = (Chicken) chickens.get(i);

				int chance = r.nextInt(100);
				if(!mates.contains(chick)) {
					if(chance > 60) {
						Object mate;
						for(int j = 0; j < chickens.size(); j++) {
							mate = chickens.get(j);
							if(!mates.contains(mate)) {
								Chicken baby = chick.breed((Chicken) mate);
								chickens.add(baby);

								mates.add(chick);
								mates.add((Chicken) mate);
								mates.add(baby);

								break;
							}
						}
					}
				} else {
					break;
				}
			}
			day++;
		}

		Chicken c = (Chicken) chickens.get(0);
		System.out.println(chickens.size());
		for(int i = 0; i < chickens.size(); i++) {
			c = (Chicken) chickens.get(i);
			System.out.println(c.color + " " + c.speckles);
		}
	}

}