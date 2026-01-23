import java.util.*;

class AllInOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Print all natural numbers
        int n = sc.nextInt();
        for(int i=1;i<=n;i++)
            System.out.print(i+" ");
        System.out.println();

        // 2. Print reverse natural numbers
        for(int i=n;i>=1;i--)
            System.out.print(i+" ");
        System.out.println();

        // 3. Print tables
        for(int i=1;i<=10;i++){
            for(int j=1;j<=10;j++)
                System.out.print(i*j+"\t");
            System.out.println();
        }

        // 4. Print ASCII values
        for(int i=65;i<=122;i++)
            System.out.println((char)i+" = "+i);

        // 5. Factorial
        int num = sc.nextInt();
        int fact = 1;
        for(int i=1;i<=num;i++)
            fact *= i;
        System.out.println(fact);

        // 6. Reverse digits
        int rnum = sc.nextInt();
        int rev = 0;
        while(rnum>0){
            int d = rnum%10;
            rev = rev*10 + d;
            rnum /= 10;
        }
        System.out.println(rev);

        // 7. Prime or not
        int p = sc.nextInt();
        int count = 0;
        for(int i=1;i<=p;i++)
            if(p%i==0) count++;
        if(count==2) System.out.println("Prime");
        else System.out.println("Not Prime");

        // 8. HCF of 3 numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int h = gcd(gcd(a,b),c);
        System.out.println(h);

        // 9. Count positive, negative, zero
        int pos=0, neg=0, zero=0;
        char ch;
        do{
            int x = sc.nextInt();
            if(x>0) pos++;
            else if(x<0) neg++;
            else zero++;
            ch = sc.next().charAt(0);
        }while(ch=='y');
        System.out.println(pos+" "+neg+" "+zero);

        // 10. Numbers divisible by 9 between k and n
        int k = sc.nextInt();
        int m = sc.nextInt();
        int sum=0, cnt=0;
        for(int i=k;i<=m;i++){
            if(i%9==0){
                sum+=i;
                cnt++;
            }
        }
        System.out.println(cnt+" "+sum);

        // 11. Hexadecimal to Decimal
        String hex = sc.next();
        int dec = Integer.parseInt(hex,16);
        System.out.println(dec);

        // 12. Fibonacci series
        int f = sc.nextInt();
        int x=0,y=1;
        for(int i=1;i<=f;i++){
            System.out.print(x+" ");
            int z = x+y;
            x=y;
            y=z;
        }
        System.out.println();

        // 13. Strong number
        int sn = sc.nextInt();
        int temp = sn, s=0;
        while(sn>0){
            int d = sn%10;
            s += factorial(d);
            sn/=10;
        }
        if(s==temp) System.out.println("Strong");
        else System.out.println("Not Strong");

        // 14. Perfect numbers from 1 to n
        int pn = sc.nextInt();
        for(int i=1;i<=pn;i++){
            int sm=0;
            for(int j=1;j<i;j++)
                if(i%j==0) sm+=j;
            if(sm==i) System.out.println(i);
        }

        // 15. Palindrome
        int pal = sc.nextInt();
        int t = pal, r=0;
        while(pal>0){
            int d = pal%10;
            r = r*10 + d;
            pal/=10;
        }
        if(t==r) System.out.println("Palindrome");
        else System.out.println("Not Palindrome");
    }

    static int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }

    static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++)
            f*=i;
        return f;
    }
}
