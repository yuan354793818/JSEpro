import java.util.*;

public class 算法 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head=listNode;
        for (int i = 0; i < 4; i++) {
            listNode.next = new ListNode(i+2);
            listNode=listNode.next;
        }
        ListNode listNode1 = swapPairs(head);

        while (listNode1!= null) {
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }


    //给定 nums = [2, 7, 11, 15], target = 9
    //
    //因为 nums[0] + nums[1] = 2 + 7 = 9
    //所以返回 [0, 1]
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{i, map.get(complement)};
            }
        }
        return null;
    }

    //输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
    //输出：7 -> 0 -> 8
    //原因：342 + 465 = 807
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode tail = new ListNode(0);
        int a = 0;
        int b = 0;
        int carry = 0;
        while (l1 != null || l2 != null) {

            a = (l1 == null) ? 0 : l1.val;
            b = (l2 == null) ? 0 : l2.val;

            int sum = a + b + carry;

            carry = sum / 10;

            ListNode node = null;

            if (carry > 0) {
                node = new ListNode(sum - 10);
            } else {
                node = new ListNode(sum);
            }

            if (head == null) {
                head = node;
            }

            tail.next = node;
            tail = tail.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            tail.next = new ListNode(carry);
        }

        return head;
    }

    // "abcabcbb"  "apzivnhwqapyttsmaboaqhcqn"
    public static int lengthOfLongestSubstring(String s) {
        List<Character> characters = new ArrayList<Character>();

        for (char c : s.toCharArray()) {
            characters.add(c);
        }

        int maxl = 0;
        HashSet<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                if (maxl < set.size()) {
                    maxl = set.size();
                }

            } else {
                int mark = i;
                char c = s.charAt(i);
                int x = 0;
                while (true) {
                    x = i;
                    i = characters.indexOf(c);
                    if (i >= mark) {
                        i = x;
                        break;
                    }
                    characters.set(i, null);
                }

                set.clear();

            }
        }

        return maxl;
    }

    // "abcabcbb"  "lkjapzivnhwqapyttsmaboaqhcqn"
    public static int 滑动窗口(String s) {
        int len = s.length();
        int maxl = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> set = new HashSet<Character>();
        while (i < len && j < len) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxl = Math.max(maxl, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return maxl;
    }

    //如果 s[j]s[j] 在 [i, j)[i,j) 范围内有与 j'j
//′
//  重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j'][i，j]
//′
//  范围内的所有元素，并将 ii 变为 j' + 1j
//′
// +1。
    public static int 滑动窗口优化(String s) {
        int len = s.length();
        int maxl = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();// 不同字符的最靠右位置
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
               // i = Math.max(map.get(s.charAt(j)), i);
                i = map.get(s.charAt(j));
            }

            maxl = Math.max(maxl, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return maxl;
    }

    //  -6 -5 -2 -1 1 2 3 4 9
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> list = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1, k = len - 1; ; ) {
                if (j >= k) {
                    break;
                }
                if (nums[i] + nums[j] < -nums[k]) {
                    j++;
                } else {
                    if (nums[i] + nums[j] == -nums[k]) {
                        List<Integer> sub1 = new ArrayList<Integer>();
                        sub1.add(nums[i]);
                        sub1.add(nums[j]);
                        sub1.add(nums[k]);
                        list.add(sub1);
                    }
                    k--;
                }
            }
        }
        return new ArrayList<List<Integer>>(list);
    }

    public static int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        String subs = str.trim();
        if (subs.equals("")) {
            return 0;
        }

        boolean isMinus = false;
        char c = subs.charAt(0);
        if (c == '-') {
            subs = subs.substring(1);
            isMinus = true;
        } else if (c == '+') {
            subs = subs.substring(1);
        }

        byte[] bytes = subs.getBytes();
        int value = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] < 48 | bytes[i] > 57) {
                break;
            }
            int x = Integer.valueOf(subs.substring(i, i + 1));

            if (value > Integer.MAX_VALUE / 10 || value == Integer.MAX_VALUE / 10 && x > 7) {
                if (isMinus) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            value = value * 10 + x;
        }

        if (isMinus) {
            return -value;
        } else {
            return value;
        }
    }


    // (sdasd)[[4533]{ss}]
    public static boolean isValid(String s) {
        String s1 = s.replaceAll(" ", "");

        Stack<Character> stack = new Stack<Character>();

        Set<Character> lset = new HashSet<Character>();
        Set<Character> rset = new HashSet<Character>();

        lset.add('{');
        lset.add('[');
        lset.add('(');
        rset.add('}');
        rset.add(']');
        rset.add(')');

        for (int i = 0; i < s.length(); i++) {
            if (lset.contains(s1.charAt(i))) {
                stack.push(s1.charAt(i));
            } else if (rset.contains(s1.charAt(i))) {
                if (stack.size()== 0) {
                    return false;
                }
                char c = s1.charAt(i);
                switch (c) {
                    case ']':
                        if (stack.pop() == '[') {
                            break;
                        } else {
                            return false;
                        }
                    case '}':
                        if (stack.pop() == '{') {
                            break;
                        } else {
                            return false;
                        }
                    case ')':
                        if (stack.pop() == '(') {
                            break;
                        } else {
                            return false;
                        }
                }
            }
        }

        return stack.size() == 0;
    }

    // ["flower","flow","flight"]
    // ["dog","racecar","car"]
    //["a","a","b"]
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 1; i < strs.length; i++) {
            int j;
            for (j = 0; j < strs[i].length()&&j<strs[0].length(); j++) {//当前最大公串和strs[i]
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            strs[0] = strs[0].substring(0, j);
        }
        return strs[0]; //strs[0]做返回
    }

    //1->2->3->4 5 6, 你应该返回 2->1->4->3 6 5.
    public static ListNode swapPairs(ListNode head) {

        ListNode ln=head.next;

        ListNode n2=new ListNode(head.next.val);
        ListNode n1=new ListNode(head.val);
        String buf = "sad";
        n2.next=n1;
        n1=n2;
        n2=n2.next;

        ListNode s1=null;
        ListNode s2=null;

        while (true) {
            if (ln.next != null) {
                s1=ln.next;
            }else {
                break;
            }
            ln=ln.next;
            if (ln.next != null) {
                s2=ln.next;
            }else {
                n2.next=s1;
                break;
            }
            ln=ln.next;

            n2.next=s2;
            n2=n2.next;
            n2.next=s1;
            n2=n2.next;
        }

        return n1;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
