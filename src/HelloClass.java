public class PriceChecker {
    public static void main(String[] args) {
        // Assuming final price after tax is stored in a variable named finalPrice
        double finalPrice = 123.45; 

        // Round the final price to the nearest integer
        int roundedPrice = (int) Math.round(finalPrice);

        if (roundedPrice % 2 == 0) {
            System.out.println("The final price is an even number, and the value is: " + roundedPrice);
        } else {
            System.out.println("The final price is an odd number, and the value is: " + roundedPrice);
        }
    }
}






