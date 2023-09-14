package week1.day1;

public class Mobile {
	
	public void sendMessage() {
		System.out.println("Send message");
	}	
	public void shareDocument() {
		System.out.println("Share document");
	}
	public void makeCall() {
		System.out.println("Make call");
	}
	public static void main(String[] args) {
		
		Mobile onePlus = new Mobile();
		onePlus.sendMessage();
		onePlus.shareDocument();
		onePlus.makeCall();
	
}
}
