package Uhr;

public class Stoppen {

	public static void stopp(){
		
	java.util.Date now = new java.util.Date();
    java.text.SimpleDateFormat sfd = new java.text.SimpleDateFormat("HH:mm:ss");
	String ausgabe = sfd.format(now);
    System.out.println(ausgabe); 	
}
}
