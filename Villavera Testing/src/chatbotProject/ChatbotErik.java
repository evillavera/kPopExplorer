package chatbotProject;

public class ChatbotErik implements Topic {

	private String[] keywords;
	private String goodbyeWord;
	private String secretWord;
	private boolean chatting;
	
	public ChatbotErik() {
		String[] temp = {"food","entertainment","internet","video games"};
		keywords = temp;
		goodbyeWord = "bye";
		secretWord = "pie";
	}

	public boolean isTriggered(String response) {
		for(int i = 0; i < keywords.length; i++) {
			if(ChatbotMain.findKeyword(response, keywords[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}

	public void startChatting(String response) {
		ChatbotMain.print("Hey! It sounds like you and I have a common interest! Let's talk some more!");
		chatting = true;
		while(chatting) {
			response = ChatbotMain.getInput();
			if(ChatbotMain.findKeyword(response, goodbyeWord, 0) >= 0) {
				chatting = false;
				ChatbotMain.chatbot.startTalking();
			}else if(ChatbotMain.findKeyword(response, secretWord, 0) >= 0) {
				ChatbotMain.print("Oh my goodness! You guessed my favorite things ever. We are friends now.");
			}else {
				ChatbotMain.print("Huh, I don't really get you. Tell me something else?");
			}
		}
	}

	
}
