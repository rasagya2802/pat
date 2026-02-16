import java.util.Scanner;

//leetcode 204
//leetcode 1780
//leetcode 3770
//leetcode 202
//leetcode 2344
//leetcode 54

public class Main {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] p = new boolean[n + 1];
    for (int i = 2; i <= n; i++) 
        p[i] = true;
    
    for (int i = 2; i * i <= n; i++) 
        if (p[i]) 
            for (int j = i * i; j <= n; j += i) 
                p[j] = false;
            
    for (int i = 2; i <= n; i++) 
        if (p[i]) System.out.print(i + " ");
  }
}

