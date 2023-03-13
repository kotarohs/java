import java.util.Scanner;

public class A1 {
    private String gender;
    private String firstName;
    private String lastName;
    private String aadharNumber;

    public void getClientInfo() {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your gender, first name, and last name separated by spaces: ");
        String clientInput = input.nextLine();
        String[] clientFields = clientInput.split(" ");

        gender = clientFields[0];
        firstName = clientFields[1];
        lastName = clientFields[2];

        System.out.println("Gender: " + gender);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

        boolean validAadharNumber = false;
        while (!validAadharNumber) {
            System.out.print("Please enter your Aadhar number (format: DDDD-DDDD-DDDD-DDDD, numbers only): ");
            String aadharInput = input.nextLine();
            if (aadharInput.matches("\\d{4}-\\d{4}-\\d{4}-\\d{4}")) {
                validAadharNumber = true;
                aadharNumber = aadharInput.replace("-", " ");
            } else {
                System.out.println("Invalid input: Aadhar number must be in format DDDD-DDDD-DDDD-DDDD, numbers only");
            }
        }

        System.out.println("Aadhar Number: " + aadharNumber);
    }

    public static void main(String[] args) {
        A1 client = new A1();
        client.getClientInfo();
    }
}
