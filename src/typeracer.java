import java.util.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;

class Helper extends TimerTask{
	public static int i = 0;
	public void run() {
		//		System.out.println("Timer ran " + ++i);
	}
}

public class typeracer {

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public static void main(String[] args) {

		//methods
		Random rand = new Random();
		Timer timer = new Timer();
		TimerTask task = new Helper();
		timer.schedule(task, 1000, 1000);
		Scanner sc = new Scanner(System.in);
		typeracerArray typeracerarray = new typeracerArray();
		Scanner uselesss = new Scanner(System.in);
		String[] array = typeracerarray.getStringArray();

		//variables		
		int acc = 100;
		int input;
		String word;
		int accuracy = 100;
		double time;
		double numbofchar=0;
		double wpm = 0;
		int incorrectCount = 0;
		System.out.println("");
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		System.out.println("****                                                             ****");
		System.out.println("****                         TYPERACER                           ****");
		System.out.println("****                                                             ****");
		System.out.println("*********************************************************************");
		System.out.println("*********************************************************************");
		System.out.println("\nPRESS ENTER TO START");
		String useless = uselesss.nextLine();
		double startTime = System.currentTimeMillis();
		String[] typing = new String[20];
		for(int i=0; i<typing.length; i++) {
			typing[i] = array[rand.nextInt(array.length)];
			System.out.print(typing[i]+" ");
			if(i==9) {
				System.out.print("\n");
			}
		}


		for(int i=0; i<typing.length; i++) {
			for(int j = 0; j<typing[i].length(); j++) {

				if(typing[i].charAt(j) != ' ') {
					numbofchar++;
				}
			}
		}

		numbofchar = numbofchar--;

		System.out.print("\n\n\t>");	

		for(int i = 0; i<typing.length; i++) {
			word = sc.next();
			if(!word.equals(typing[i])) {
				accuracy = accuracy-100/typing.length;
				incorrectCount++;
			}
		}

		double endTime = System.currentTimeMillis();
		time = (endTime - startTime);
		double rawwpm = (((numbofchar/5)/(time/1000)) * 60);
		double minusamount = (rawwpm * ((numbofchar/typing.length)/100)-1);
		wpm = rawwpm;
		wpm = wpm - (minusamount * incorrectCount);

		if(wpm < 0) {
			wpm = 0;
		}

		df2.setRoundingMode(RoundingMode.UP);
		System.out.println("\nAccuracy: " + accuracy + "\nWPM: " + df2.format(wpm)
		+ "\nRaw WPM: " + df2.format(rawwpm));

		if(accuracy<80&&accuracy>=50) {
			System.out.print("\nSLOW DOWN!!!");
		}
		else if(accuracy<50) {
			System.out.print("\nStop Trolling");
		}
		System.out.println("\n\nMade By Shin"+"\n\nClick Enter to Leave Typeracer");
		useless = uselesss.nextLine();
		System.exit(0);
	}
}