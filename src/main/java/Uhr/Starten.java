package Uhr;

@SuppressWarnings("serial")
public class Starten extends JFrameUhr{


	public static void start() {

		boolean on;
		on = true;

		try {
			while (on) {
				java.util.Date now = new java.util.Date();
				java.text.SimpleDateFormat sfd = new java.text.SimpleDateFormat("HH:mm:ss");
				String ausgabe = sfd.format(now);
				System.out.println(ausgabe);
				Thread.sleep(1000);

			}
		} catch (Exception e) {
			System.out.println("Got an exception!");
		}
	}
}