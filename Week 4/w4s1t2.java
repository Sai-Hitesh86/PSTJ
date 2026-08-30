 import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0)
		{
			String s = sc.next();
			int n = s.length();
			int[] freq = new int[26];

			for (int i = 0; i < n / 2; i++)
			{
				freq[s.charAt(i) - 'a']++;
				freq[s.charAt(n - 1 - i) - 'a']--;
			}

			boolean lapindrome = true;

			for (int i = 0; i < 26; i++)
			{
				if (freq[i] != 0)
				{
					lapindrome = false;
					break;
				}
			}

			System.out.println(lapindrome ? "YES" : "NO");
		}
	}
}