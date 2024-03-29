package fmt.Math;

public class MinimumFactorization {
    /**
     * We know that the final number generated, res, should be such that its digits should have a product equal to the
     * given number a. In other words, the digits of res will be the factors of the given number a. Thus, our problem
     * reduces to finding the factors(not necessarily prime) of a and finding their smallest possible arrangement. Thus,
     * we start with trying with the largest possible factor 9, obtain as many such counts of this factor as possible in
     * res and place such factors obtained at its least significant positions. Then, we go on decrementing the number
     * currently considered as the possible factor and if it is a factor, we keep on placing it at relatively more
     * significant positions in res. We go on getting such factors till we are done considering all the numbers from 9
     * to 2. At the end, res gives the required result.
     */
    public int smallestFactorization(int a) {
        if (a < 2)
            return a;
        long res = 0, mul = 1;
        for (int i = 9; i >= 2; i--) {
            while (a % i == 0) {
                a /= i;
                res = mul * i + res;
                mul *= 10;
            }
        }
        return a < 2 && res <= Integer.MAX_VALUE ? (int) res : 0;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFactorization().smallestFactorization(15));
        System.out.println(new MinimumFactorization().smallestFactorization(26));
    }
}
