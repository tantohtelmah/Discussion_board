package Lab_1;
import java.util.Scanner;

public class lab1_exer {
	// Post object
	public static class Post {
		// Fields (attributes)
		String author = null;
		String message = null;
	
		// Method
		public String createPost() {
			return author + " " + message;
		}
	}

	// Discussion Board object
	public class DiscussionBoard {

		//Attributes
		int i, y = 0;
		String positiveAns[] = {"yes", "yeah", "yup"};
		String[] postStrings = new String[10]; //Arrays of posts
		Scanner scanner = new Scanner(System.in);
		boolean stillPosting = false;

		//Methods
		//Post new messages
		public void postNewMessage(){
			y = 0;
			while (true){
				Post newPost = new Post();
				System.out.println("Please enter your name:");
				newPost.author = scanner.nextLine();
				System.out.println("Please write your thoughts");
				newPost.message = scanner.nextLine();
				System.out.println("\"" + newPost.author + " says: " + newPost.message + "\"");
				System.out.println("Do yo still want to post another message?");
				try {
					postStrings[y] = newPost.createPost();
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("Discussion Board is full. Sorry!" + e.getMessage());
					break;
				}
				
				String stillPostingAns = scanner.nextLine();
				for (i = 0; i < positiveAns.length; i++) {
					if (stillPostingAns.toLowerCase().equals(positiveAns[i])) {
						stillPosting = true;
						break;
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
			for (i = 0; i < postStrings.length; i++){
				System.out.println(postStrings[i]);
			}
		}
		//prints all post in reverse order
		public void printReverse(){
			//code
		}
		// print number of post enetered so far
		public void printNUmOfPost(){
			//code
		}
		//print all post from a user
		public void printPostOfUser(){
			for (i = 0; postStrings.length < i; i++){
				if (postStrings[i] == null){
					System.out.println("Sorry Discussion Board is empty");
					break;
				}
			}
			System.out.println("Please enter name of user to view post");
			String postUserName = scanner.nextLine().toLowerCase();
			boolean found = false;
			for (i = 0; i < postStrings.length; i++) {
				if (postStrings[i] != null && postStrings[i].startsWith(postUserName)) {
					System.out.println(i);
					System.out.println(postStrings[i]);
					found = true;
				}
			}
			if (!found){
				System.out.println("Post Not found");
			}
		}

		//Print number of vowels
		public void printNumOfVowels(){
			//code
		}

		//Search case sensitive
		public void caseSensitiveSearch(){
			//code
		}

		//Search case sensitive
		public void caseInSensitiveSearch(){
			//code
		}
	}

	public class Menu {
		DiscussionBoard discussionBoard = new DiscussionBoard();
		String post = "post";
		String[] prints = {"All posts", "All posts in reverse order", "Number of posts enetered", "All posts from a specific user", "Print the number of vowels across all posts"};

		public void printPost(String menuOption){
			if(menuOption.equals(prints[0])){
				discussionBoard.printAllPosts();
			}
			else if(menuOption.equals(prints[1])){
				discussionBoard.printReverse();
			}
			else if(menuOption.equals(prints[2])){
				discussionBoard.printNUmOfPost();
			}
			else if(menuOption.equals(prints[3])){
				discussionBoard.printPostOfUser();
			}
			else if(menuOption.equals(prints[4])){
				discussionBoard.printNumOfVowels();
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		lab1_exer outer = new lab1_exer();
    	Menu menu = outer.new Menu();
		DiscussionBoard discussionBoard = outer.new DiscussionBoard();

		while (true) { 
			System.out.println("Do you wish to post, view a post or search through the posts with a given word?");
			String optionToPerform = scanner.nextLine().toLowerCase();
			if (optionToPerform.equals(menu.post)){
				discussionBoard.postNewMessage();
			}
			else if(optionToPerform.equals("view post")){
				System.out.println("Select which format you would like to see the post displayed...");
				String optionToPerformPrint = scanner.nextLine().toLowerCase();
				for (int i = 0; menu.prints.length < i; i++){
					if (optionToPerformPrint.equals(menu.prints[i])){
						menu.printPost(optionToPerform);
					}
				}
			}else if(optionToPerform.contains("search")){
				System.out.println("Would you like a case sensitive search or a case insentive search");
				try {
					String caseSearchOption = scanner.nextLine().toLowerCase();
					if (caseSearchOption.contains("sensitive")){
						discussionBoard.caseSensitiveSearch();
					}
					else if(caseSearchOption.contains("insensitive")){
						discussionBoard.caseInSensitiveSearch();
					}
				} finally {
					scanner.close();
				}
			}
		}
	}
}

