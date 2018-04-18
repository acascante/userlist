package userlist;

import java.util.Scanner;

import controllers.UserCheckerController;
import domains.CheckUserResponse;


/**
 * @author aocc
 *
 */
public class UserListMain {

	public static void main(String[] args) {

		UserCheckerController controller = new UserCheckerController();
		CheckUserResponse checkUserResponse = new CheckUserResponse();
		
		Scanner scanner = new Scanner(System.in);
		scanner.useDelimiter("\\n");
		String username = new String();
		boolean check = true;
		 
		while (check) {
			System.out.println("\n\nUsername: ");
			username = scanner.nextLine();
			checkUserResponse = controller.checkUsername(username);
			System.out.println(checkUserResponse.getMessage());
			if(checkUserResponse.getResult()) {
				// Valid user, Add new user to the list
				controller.getUsers().add(username);				
			} else {
				// Invalid user, print option
				if(!checkUserResponse.getOptions().isEmpty()) {
					System.out.println("\nSugestions");
					System.out.println(checkUserResponse.getOptions());
				}
			}
			System.out.println("\n\nContinue y/n: ");
			if (!"Y".equals(scanner.nextLine().toUpperCase())) {
				check = false;
			}
		}
		scanner.close();
    }
}
