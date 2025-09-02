package util;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Utlity {
    public static void main(String[] args) {
        int firstNameLength = 5;
        String randomFirstName = generateRandomFirstName();
        System.out.println("Random Capitalized First Name: " + randomFirstName);

        String randomLastName = generateRandomLastName();
        System.out.println("Random Capitalized Last Name: " + randomLastName);

        String dynamicEmail = generateDynamicEmail();
        System.out.println("Dynamic Email: " + dynamicEmail);

        String dynamicPhoneNumber = generateEgyptianPhoneNumber();
        System.out.println("Dynamic Egyptian Phone Number: " + dynamicPhoneNumber);

        String dynamicPassword = generateDynamicPassword();
        System.out.println("Dynamic Password: " + dynamicPassword);
    }

    public static String generateRandomFirstName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 5;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        return sb.substring(0, 1).toUpperCase() + sb.substring(1); // Capitalize the first letter
    }
    public static String generateRandomLastName() {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        int length = 7;
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(letters.length());
            sb.append(letters.charAt(index));
        }
        String lastName = sb.toString();
        return lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
    }

    public static String generateDynamicEmail() {

        String uniqueId = UUID.randomUUID().toString().substring(0, 8);

        String dynamicEmail = "user" + uniqueId + "@example.com";

        return dynamicEmail;
    }

    public static String generateEgyptianPhoneNumber() {
        final AtomicInteger counter = new AtomicInteger(0);
        String[] egyptianPrefixes = {"010", "011", "012", "015"};
        String prefix = egyptianPrefixes[(int) (Math.random() * egyptianPrefixes.length)];

        int randomNumber = (int) (Math.random() * 10000000);

        AtomicInteger uniqueValue = counter;

        return "+20" + prefix + String.format("%07d", randomNumber) + uniqueValue;
    }
    public static String generateDynamicPassword() {
        String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String smallLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?";
        String allCharacters = capitalLetters + smallLetters + numbers + specialCharacters;

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        password.append(capitalLetters.charAt(random.nextInt(capitalLetters.length())));
        password.append(smallLetters.charAt(random.nextInt(smallLetters.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));

        int remainingLength = 7 - password.length();
        for (int i = 0; i < remainingLength; i++) {
            password.append(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        ArrayList<Object> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle((java.util.List<?>) characters);
        StringBuilder shuffled = new StringBuilder();
        for (Object c : characters) {
            shuffled.append(c);
        }
        return shuffled.toString();
    }

    public static void openBrowserNetworkTab() throws AWTException {

        Robot robot = new Robot();
        robot.delay(2000); // Wait for the browser window to be active
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_I);
        robot.delay(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_I);

        for (int i = 0; i < 3; i++) {
            robot.keyPress(KeyEvent.VK_CONTROL);

            robot.keyPress(KeyEvent.VK_CLOSE_BRACKET);
            robot.keyRelease(KeyEvent.VK_CLOSE_BRACKET);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(200);
        }
    }
}