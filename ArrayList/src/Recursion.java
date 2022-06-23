public class Recursion {
    public static int fib(int n){
        if (n < 2) return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static int factorial(int n){
        if (n <= 2) return n;
        else
            return n * factorial(n - 1);
    }


    public static void main(String[] args) {
        System.out.println(fib(23));
        System.out.println(factorial(5));
    }
}
