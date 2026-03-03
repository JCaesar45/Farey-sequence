import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FareySequence {
    
    public static List<String> farey(int n) {
        List<Fraction> sequence = new ArrayList<>();
        
        // Generate all reduced fractions a/b where 0 <= a <= b <= n
        for (int b = 1; b <= n; b++) {
            for (int a = 0; a <= b; a++) {
                // Check if fraction is reduced (gcd(a,b) == 1)
                if (gcd(a, b) == 1) {
                    sequence.add(new Fraction(a, b));
                }
            }
        }
        
        // Sort by value
        Collections.sort(sequence, Comparator.comparingDouble(f -> f.value));
        
        // Format as strings
        List<String> result = new ArrayList<>();
        for (Fraction f : sequence) {
            result.add(f.num + "/" + f.den);
        }
        
        return result;
    }
    
    // Helper class to store fraction
    static class Fraction {
        int num;
        int den;
        double value;
        
        Fraction(int num, int den) {
            this.num = num;
            this.den = den;
            this.value = (double) num / den;
        }
    }
    
    // Helper function to calculate GCD
    private static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println(farey(3));   // [0/1, 1/3, 1/2, 2/3, 1/1]
        System.out.println(farey(4));   // [0/1, 1/4, 1/3, 1/2, 2/3, 3/4, 1/1]
        System.out.println(farey(5));   // [0/1, 1/5, 1/4, 1/3, 2/5, 1/2, 3/5, 2/3, 3/4, 4/5, 1/1]
    }
}
