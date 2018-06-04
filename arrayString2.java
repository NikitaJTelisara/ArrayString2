import java.util.HashSet;

public class arrayString2 {
    public static void main(String[] args) {
        String s = "Nikita";
        System.out.println(s.substring(0, s.length()));  /*Nikita */
        String s1 = longestPalindrome(s);
        System.out.println(s1);

        s1 = "abcabced";
        int a = lengthOfLongestUniqueSubstring(s1);
        System.out.println(a);

        s1 = longestUniqueSubstring(s1);
        System.out.println(s1);

        int[] arr = {2, 2, 3, 3, 4, 6, 6};
        int result = getSingleNum(arr, 0, arr.length - 1);
        if (result == 0) {
            System.out.println("not found");
        } else {
            System.out.println(result);
        }

        s = "{{as(s)Ss}}";
        System.out.println(isBalanced(s));

        int n = 98;
        System.out.println("Max gap in 1s of binary rep of :" + n + " is " + getMaxBinaryGap(98));

        String ss = "(a){a{[a+b]";
        int res = lengthOfLongestValidParen(ss);
        System.out.println(res);
        ss = "(){{[]}}[][{}]";
        res = lengthOfLongestValidParen(ss);
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);   /* N , subString() does not include chartAt(1)   */
        for (int i = 0; i < s.length(); i++) {
            // get longest palindrome with center of i
            String tmp = helper(s, i, i);    /* for Niki , return iki */
            longest = (tmp.length() > longest.length()?tmp:longest);
            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);          /* for Nikki , return ikki */
            longest = (tmp.length() > longest.length()?tmp:longest);
        }
        return longest;
    }

    public static String helper(String s, int begin, int end) {
        while (begin >= 0 && end <= s.length() - 1 && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }
        return s.substring(begin + 1, end);
    }

/* Time complexity = O(n^2), space complext  O(1)        */

    /* get length on longest subsstring with unique elements
   input : awedds Expected output :4
    */
    public static int lengthOfLongestUniqueSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longest = 1;   /* N , subString() does not include chartAt(1)   */
        for (int i = 0; i <= s.length() - 1; i++) {
            //System.out.println("i"+i);
            int tempLength = helper1(s, i);
            if (tempLength > longest) {
                longest = tempLength;
            }
        }
        return longest;
    }

    public static int helper1(String s, int i) {
        int longest = 1;
        HashSet tab = new HashSet();
        for (int j = i; j <= s.length() - 1; j++) {
            if (!tab.contains(s.charAt(j))) {
                tab.add(s.charAt(j));
                longest = tab.size();
            } else {
                return longest;
            }
        }
        return longest;
    }


    /* get longest unique subsstring with unique elements
   input : awedds Expected output :awed
    */
    public static String longestUniqueSubstring(String s) {
        if (s.isEmpty()) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        String longest = s.substring(0, 1);   /* N , subString() does not include chartAt(1)   */
        for (int i = 0; i <= s.length() - 1; i++) {
            String temp = helper3(s, i);
            if (temp.length() > longest.length()) {
                longest = temp;
            }
        }
        return longest;
    }

    public static String helper3(String s, int i) {
        String longest = s.substring(i);
        HashSet tab = new HashSet();
        for (int j = i; j <= s.length() - 1; j++) {
            if (!tab.contains(s.charAt(j))) {
                tab.add(s.charAt(j));
                longest = s.substring(i, j);
            } else {
                return longest;
            }
        }
        return longest;
    }

    public static int getSingleNum(int[] arr, int l, int h) {
        int mid = l + (h - l) / 2;
        if (l == h) {
            return arr[l];
        }
        if ((arr[mid] != arr[mid - 1]) && (arr[mid] != arr[mid + 1])) {
            return arr[mid];
        }
        if (arr[mid] == arr[mid + 1]) {
            if (mid % 2 == 1) {
                return (getSingleNum(arr, l, mid - 1));
            }
            if (mid % 2 == 0) {
                return (getSingleNum(arr, mid, h));
            }
        }
        if (arr[mid] == arr[mid - 1]) {
            if (mid % 2 == 1) {
                return (getSingleNum(arr, mid + 1, h));
            }
            if (mid % 2 == 0) {
                return (getSingleNum(arr, l, mid));
            }
        }
        return 0;
    }

    public static boolean isBalanced(String s) {
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                char result = stack.pop().data;
                if (s.charAt(i) == ')') {
                    if (result != '(') {
                        return false;
                    }
                }
                if (s.charAt(i) == ']') {
                    if (result != '[') {
                        return false;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (result != '{') {
                        return false;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    
    /*
    public static boolean isBala(String str) {
        Stack s1 = new Stack();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                s1.push(str.charAt(i));
            }
            if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
                if (s1.pop().data != getChar(str.charAt(i))) {
                    return false;
                }
            }
        }
        return s1.isEmpty();
    }

    public static char getChar(char x1) {
        char x = ' ';
        switch (x1) {
            case '}':
                x = '{';
                break;
            case ']':
                x = '[';
                break;
            case ')':
                x = '(';
                break;
        }
        return x;
    }*/


    /* BinaryGap
Find longest sequence of zeros in binary representation of an integer.*/
    public static int getMaxBinaryGap(int n) {
        int result = 0;
        int count = 0;
        // Integer.toString(100,8) // prints 144 --octal representation
        //Integer.toString(100,16) //prints 64 --Hex representation
        String binary = Integer.toString(n, 2); // prints 1100100 --binary representation
        System.out.println(binary);
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                count++;
            } else {
                count = 0;
            }
            result = Math.max(count, result);
        }
        return result;
    }
    // 0(n)
    
    /* public static int getMax(int x) {
        String str = Integer.toString(x,2);
        int count = 0;
        int result = 0;
        for(int  i=0; i<str.length();i++){
            if(str.charAt(i) == '0'){
                 count++;
            }else {
                result = Math.max(result,count);
                count = 0;
            }
        }
        return result;
    }
*/

    /*
        Find longest valid Parentheses*/
    public static int lengthOfLongestValidParen(String s) {
        int result = 0;
        int count = 0;
        char paren = ' ';
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || (s.charAt(i) == '{')) {
                stack.push(s.charAt(i));
                count = 0;
            } else {
                if (s.charAt(i) == ')') {
                    paren = '(';
                } else if (s.charAt(i) == ']') {
                    paren = '[';
                } else if (s.charAt(i) == '}') {
                    paren = '{';
                }
                char a = stack.pop().data;
                if (paren != a) {
                    return -1;  // invalid paren
                } else {
                    count++;
                }
            }
            result = Math.max(count, result);
        }
        return result;
    }
    // 0(n)
    /* 
    public static int lengthOfLongestValidParen(String str) {
        Stack s1 = new Stack();
        int count = 0;
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '(') {
                s1.push(str.charAt(i));
            }
            if (str.charAt(i) == '}' || str.charAt(i) == ']' || str.charAt(i) == ')') {
                if (s1.pop().data == getChar(str.charAt(i))) {
                   count++;
                }else {
                    return -1;
                }
            }
            result = Math.max(result,count);
        }
        return result;
    }*/
}
