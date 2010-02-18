/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package farm;

import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Chris
 */
public class Chicken {
	public String color;
	public String speckles;
	public Chicken parentA;
	public Chicken parentB;

	public static int generations = 0;

	private ArrayList history = new ArrayList();

	private String[] colors = {
		"red",
		"white",
		"grey",
		"black",
		"blue",
		"orange",
		"yellow",
		"magenta",
		"purple",
		"skyblue",
		"brown",
		"darkbrown",
		"lightbrown",
	};

	public Chicken breed(Chicken c) {
		Chicken chick = new Chicken();

		chick.history = (ArrayList) this.history.clone();
		// Merge
		for(int i = 0; i < c.history.size(); i++) {
			chick.history.add(c.history.get(i));
		}

		// The specles can be any color of the past generations
		Random r = new Random();
		boolean mutation = r.nextInt(100) > 90;

		String s_color;
		if(mutation) {
			s_color = this.colors[r.nextInt(this.colors.length)];
		} else {
			s_color = (String) this.history.get(r.nextInt(this.history.size()));
		}

		chick.parentA = this;
		chick.parentB = c;

		chick.speckles = s_color;

		return chick;
	}

	public Chicken() {
		Random r = new Random();
		this.color = this.colors[r.nextInt(this.colors.length)];
		
		if(Chicken.generations == 0) {
			this.speckles = this.colors[r.nextInt(this.colors.length)];
			this.history.add(this.speckles);
		}

		this.history.add(this.color);
	}
}
