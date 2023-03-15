package ThirdLesson.Ex1;

public class TestRunner {
    public static void main(String[] args) {
        SauceDemoTests tests = new SauceDemoTests();
        tests.setUp();
        tests.loginWithValidCredentials();
        tests.addItemToCart();
        //tests.removeItemFromCart();
        tests.sortItemsByPrice();
        tests.tearDown();
    }
}