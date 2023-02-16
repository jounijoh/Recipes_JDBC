package program;

import java.util.List;

public class aikasplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String h;
		String m;

		String aika = "h21";
		int onkoH = aika.indexOf('h');
		System.out.println(onkoH + "hindex");
		if (onkoH > -1) {
			String[] ajat = aika.split("h");

			h = ajat[0].trim();
			m = ajat[1].trim().replace("min", "");
			
			System.out.println(h +"h"+ m + "min");
		}
	}

}
