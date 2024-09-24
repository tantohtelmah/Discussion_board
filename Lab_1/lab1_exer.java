package Lab_1;
import java.util.InputMismatchException;
import java.util.Scanner;

public class lab1_exer {
	// Post object
	public static class Post {
		// Fields (attributes)
		String author = null;
		String message = null;
	
		// Method
		public String createPost() {
			return "\"" + author + " says " + message + "\"";
		}
	}

	// Discussion Board object
	public class DiscussionBoard {

		// Class Attributes
		String[] postStrings = new String[10]; //Arrays of posts
		private int postCount = 0;
		String positiveAns[] = {"yes", "yeah", "yup"};
		Scanner scanner = new Scanner(System.in);
		boolean stillPosting = false;
		Post newPost = new Post();

		//Methods
		//Post new messages
		public void postNewMessage(){
			while (true){
				//Checking if the Discussion Board is full
				if (postCount >= postStrings.length) {
					System.out.println("Discussion Board is full. Sorry!");
					break;
				}
				System.out.println("Please enter your name:");
				newPost.author = scanner.nextLine();
				System.out.println("Please write your thoughts");
				newPost.message = scanner.nextLine();
				// System.out.println("\"" + newPost.author + " says: " + newPost.message + "\"");

				// Adding post to array(postStrings)
				postStrings[postCount] = newPost.createPost();
				postCount++;
				System.out.println("Your message has been posted.");
				
				// Another option to post
				System.out.println("Do you still want to post another message?");
				String stillPostingAns = scanner.nextLine().toLowerCase();
                            for (String positiveAn : positiveAns) {
                                if (stillPostingAns.equals(positiveAn)) {
                                    stillPosting = true;
                                    break;
                                }
								else if(!stillPostingAns.equals("no")){
									System.out.println("Invalid response, please use \"yes\" or \"no\", Thanks");
								}
                            }
				if (!stillPosting) {
					break;
				}
				stillPosting = false;
			}
		}

		
		
		
		//Prints all post
		public void printAllPosts(){
			System.out.println("Printing all posts...");
			try{
				Thread.sleep(500);
				for (int i = 0; i < postCount; i++){
					if (postStrings[i] != null) {
						System.out.println(postStrings[i]);
					}
				}
			}catch(InterruptedException e) {
				System.err.println("Thread was interrupted!");
			}
		}
		//prints all post in reverse order
		public void printReverse(){
			System.out.println("Printing all posts in reverse order...");
			for (int i = postCount - 1; i >= 0; i--) {
				if (postStrings[i] != null) {
					System.out.println(postStrings[i]);
				}
			}
		}
		// print number of post enetered so far
		public void printNumOfPosts(){
        	System.out.println("Number of posts entered so far: " + postCount);
		}
		//print all post from a user
		public void printPostOfUser(){
			System.out.println("Please enter name of user to view post");
			String postUserName = scanner.nextLine().toLowerCase();
			if (postCount == 0){
				System.out.println("Sorry the Discussion Board is empty");
			}
			boolean found = false;
			for (int i = 0; i < postCount; i++) {
				System.out.println("Hi");
				if (postStrings[i].toLowerCase() != null && postStrings[i].toLowerCase().startsWith("\"" + postUserName)) {
					System.out.println("Found post of " + postUserName + " at " + i + ".");
					System.out.println("Post: " + postStrings[i]);
					found = true;
				}
				else{
					System.out.println("rather here" + postStrings[i]);
				}
			}
			if (!found){
				System.out.println("Post Not found");
			}
		}

		//Print number of vowels
		public void printNumOfVowels(){
			int vowelCount = 0;
			for (int i = 0; i < postCount; i++) {
				String post = postStrings[i].toLowerCase();
				for (char c : post.toCharArray()) {
					if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
						vowelCount++;
					}
				}
			}
			System.out.println("Total number of vowels across all posts: " + vowelCount);
		}


		//Search case sensitive
		public void caseSensitiveSearch(String searchWord){
			boolean found = false;
			for (int i = 0; i < postCount; i++) {
				if (postStrings[i].contains(searchWord)) {
					System.out.println("Found in post " + (i + 1) + ": " + postStrings[i]);
					found = true;
				}
			}
			if (!found) {
				System.out.println("No posts contain the word \"" + searchWord + "\" (case-sensitive).");
			}
		}

		//Search case sensitive
		public void caseInSensitiveSearch(String searchWord){
			boolean found = false;
			for (int i = 0; i < postCount; i++) {
				if (postStrings[i].toLowerCase().contains(searchWord.toLowerCase())) {
					System.out.println("Found in post " + (i + 1) + ": " + postStrings[i]);
					found = true;
				}
			}
			if (!found) {
				System.out.println("No posts contain the word \"" + searchWord + "\" (case-sensitive).");
        }
		}

		//Exit Discussion Board
		public void exitDiscussionBoard(){
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		lab1_exer outer = new lab1_exer();
    	// Menu menu = outer.new Menu();
		DiscussionBoard discussionBoard = outer.new DiscussionBoard();

		while (true) {
            System.out.println("Choose an option:");
            System.out.println("(1) Post new message");
            System.out.println("(2) Print all posts");
            System.out.println("(3) Print all posts in reverse order");
            System.out.println("(4) Print number of posts entered so far");
            System.out.println("(5) Print all posts from a user");
            System.out.println("(6) Print the number of vowels across all posts");
            System.out.println("(7) Perform a search of posts containing a given word (case sensitive)");
            System.out.println("(8) Perform a search of posts containing a given word (case insensitive)");
            System.out.println("(9) End Program");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1 -> discussionBoard.postNewMessage();
                case 2 -> discussionBoard.printAllPosts();
                case 3 -> discussionBoard.printReverse();
                case 4 -> discussionBoard.printNumOfPosts();
                case 5 -> discussionBoard.printPostOfUser();
                case 6 -> discussionBoard.printNumOfVowels();
                case 7 -> {
                    System.out.println("Enter word: ");
                    String searchWord = scanner.nextLine();
                    discussionBoard.caseSensitiveSearch(searchWord);
                        }
                case 8 -> {
                    System.out.println("Enter word: ");
                            String searchWord = scanner.nextLine();
                            discussionBoard.caseInSensitiveSearch(searchWord);
                        }
                case 9 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                        }
                default -> {
					System.out.println("Invalid option. Please try again.");
					try {
						System.out.println("Invalid option. Please try again.");
					} catch (InputMismatchException e) {
						System.out.println("Error");
					}
				}
            }
        }
	}
}

