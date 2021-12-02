

	package genericUtilities;

	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.util.Date;
	import java.util.Random;

	public class JavaUtility {
	 /**
	  * 
	  * @return
	  */
	public static String getRandomData() {
	  Random random = new Random();
	  int randomdata = random.nextInt(1000);
	  return ""+randomdata;
	  
	}
	}