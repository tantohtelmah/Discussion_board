
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

	public class menu {
		String post = ""
	}




	public static class DiscussionBoard {

		int i, y = 0;
		String positiveAns[] = {"yes", "yeah", "yup"};
		String[] posStrings = new String[10];
		Scanner scanner = new Scanner(System.in);
		boolean stillPosting = false;


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
					posStrings[y] = newPost.createPost();
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
			for (i = 0; i < posStrings.length; i++){
				System.out.println(posStrings[i]);
			}
		}

		//prints all post in reverse order

		// print number of post enetered so far

		//print all post from a user
		public void printPostOfUser(){
			for (i = 0; posStrings.length < i; i++){
				if (posStrings[i] == null){
					System.out.println("Sorry Discussion Board is empty");
					break;
				}
			}
			System.out.println("Please enter name of user to view post");
			String postUserName = scanner.nextLine().toLowerCase();
			boolean found = false;
			for (i = 0; i < posStrings.length; i++) {
				if (posStrings[i] != null && posStrings[i].startsWith(postUserName)) {
					System.out.println(i);
					System.out.println(posStrings[i]);
					found = true;
				}
			}
			if (!found){
				System.out.println("Post Not found");
			}
		}
	}

		

		
	// 	while(true) {
	// 		System.out.println("Do you wish to post or view a post?");
	// 		String optionToPerform = scanner.nextLine().toLowerCase();

			
	// 		else if (optionToPerform.equals("view a post")) {
				
	// 			for (i = 0; posStrings.length < i; i++){
	// 				if (posStrings[i] == null){
	// 					System.out.println("Sorry Discussion Board is empty");
	// 					break;
	// 				}
	// 			}
	// 			System.out.println("Please enter name of user to view post");
	// 			String postUserName = scanner.nextLine().toLowerCase();
	// 			boolean found = false;
	// 			for (i = 0; i < posStrings.length; i++) {
	// 				if (posStrings[i] != null && posStrings[i].startsWith(postUserName)) {
	// 					System.out.println(i);
	// 					System.out.println(posStrings[i]);
	// 					found = true;
	// 				}
	// 			}
	// 			if (!found){
	// 				System.out.println("Post Not found");
	// 				break;
	// 			}
	// 		}
	// 		j++;
	// 	}
		
	// }
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DiscussionBoard discussionBoard = new DiscussionBoard();
		while (true) { 
			System.out.println("Do you wish to post or view post?");
			String optionToPerform = scanner.nextLine().toLowerCase();
			if (optionToPerform.equals("post")){
				discussionBoard.postNewMessage();
			}
			else if(optionToPerform.equals("view post")){
				System.out.println("Select which format you would like to see the post displayed...");
				System.out.println("1. All posts");
				System.out.println("2. All posts in reverse order");
				System.out.println("3. Number of posts enetered");
				System.out.println("4. All posts from a specific user");
				System.out.println("5. Print the number of vowels across all posts");
				String optionToPerformPrint = scanner.nextLine().toLowerCase();

			}
		}}

	}
}
