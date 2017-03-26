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

        s1= longestUniqueSubstring(s1);
        System.out.println(s1);

        int[] arr = {2, 2, 3, 3, 4, 6, 6};
        int result = getSingleNum(arr, 0, arr.length - 1);
        if (result == 0) {
            System.out.println("not found");
        } else {
            System.out.println(result);
        }

        s = "{{as(s)Ss}}" ;
        System.out.println(isBalanced(s));
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
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }

            // get longest palindrome with center of i, i+1
            tmp = helper(s, i, i + 1);          /* for Nikki , return ikki */
            if (tmp.length() > longest.length()) {
                longest = tmp;
            }
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
        String longest = s.substring(0,1);   /* N , subString() does not include chartAt(1)   */
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
                longest = s.substring(i,j);
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
                if(s.charAt(i) == ')'){
                    if(result != '('){
                        return false;
                    }
                }
                if(s.charAt(i) == ']'){
                    if(result != '['){
                        return false;
                    }
                }
                if(s.charAt(i) == '}'){
                    if(result != '{'){
                        return false;
                    }
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}