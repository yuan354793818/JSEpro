package algorithm;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class 算法 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 0; i < 4; i++) {
            listNode.next = new ListNode(i + 2);
            listNode = listNode.next;
        }
        ListNode listNode1 = (head);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
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
                if (stack.size() == 0) {
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
            for (j = 0; j < strs[i].length() && j < strs[0].length(); j++) {//当前最大公串和strs[i]
                if (strs[0].charAt(j) != strs[i].charAt(j)) {
                    break;
                }
            }
            strs[0] = strs[0].substring(0, j);
        }
        return strs[0]; //strs[0]做返回
    }

    //a = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] 滑动窗口
    public static int longestOnes(int[] A, int K) {
        int len = 0;
        if (A.length <= K) {
            return A.length;
        }
        for (int i = 0; i < A.length - K; i++) {
            int sublen = 0;
            for (int j = K, f = i; f < A.length; f++) {
                if (A[f] == 0) {
                    j--;
                }
                if (j < 0)
                    break;
                ++sublen;
            }
            len = Math.max(sublen, len);
        }
        return len;
    }

    public static int longestOnes_Ultimate(int[] a, int k) {  // 滑动窗口
        int left = 0, right = 0;
        int restCount = k;
        int result = 0;
        while (right < a.length) {
            if (restCount > 0) {
                if (a[right] == 1) {
                    right++;
                } else {
                    right++;
                    restCount--;
                }
            } else {
                if (a[right] == 1) {
                    right++;
                } else {
                    if (a[left] == 1) {
                        left++;
                    } else {
                        left++;
                        restCount++;
                    }
                }
            }
            result = Math.max(result, right - left);
        }
        return result;
    }


    @Test
    public void testLongestOnes() {
//        int[] b = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int[] a = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int[] v = new int[25 * 2 * 300];
        for (int i = 0; i < 600; i += 2) {
            for (int j = 0; j < 25; j++) {
                v[j + 25 * i] = 0;
                v[j + 25 * (i + 1)] = 1;
            }
        }

        for (int i = 0; i < v.length; i++) {
            if (i % 25 == 0) {
                System.out.println();
            }
            System.out.print(v[i]);
        }
        System.out.println();
        int k = 4545;
        System.out.println(longestOnes(v, k));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0, right = -1;
        int maxLen = 0;
        int maxCount = 0;
        int[] alpha = new int[26];

        while (++right < s.length()) {
            alpha[s.charAt(right) - 'A']++;
            maxCount = Math.max(maxCount, alpha[s.charAt(right) - 'A']);
            //maxIndex = getMaxIndex(alpha);
            if (right - left + 1 - maxCount > k) {
                alpha[s.charAt(left++) - 'A']--;
                //maxIndex = getMaxIndex(alpha);
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static int getMaxIndex(int[] nums, int start, int end) {
        int result = start;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[result]) {
                result = i;
            }
        }
        return result;
    }

    @Test
    public void testcharacterReplacement() {
        int rst = characterReplacement("ABABBBB",
                1);
        System.out.println(rst);
    }

    //s = 7, nums = [2,3,1,2,4,3]
    //输出: 2

    public static int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0, curSum = nums[0], minlen = Integer.MAX_VALUE;
        while (true) {
            if (curSum >= s) {
                minlen = Math.min(minlen, right - left + 1);
                curSum -= nums[left++];
            } else {
                if (right + 1 == nums.length) {
                    break;
                }
                curSum += nums[++right];
            }
        }
        if (minlen == Integer.MAX_VALUE) {
            return 0;
        }
        return minlen;
    }

    @Test
    public void testminSubArrayLen() {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen(7, nums);
    }

    //输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    //输出: [3,3,5,5,6,7]
    //解释:
    //
    //  滑动窗口的位置                最大值
    //---------------               -----
    //[1  3  -1] -3  5  3  6  7       3
    // 1 [3  -1  -3] 5  3  6  7       3
    // 1  3 [-1  -3  5] 3  6  7       5
    // 1  3  -1 [-3  5  3] 6  7       5
    // 1  3  -1  -3 [5  3  6] 7       6
    // 1  3  -1  -3  5 [3  6  7]      7
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        int maxIndex = getMaxIndex(nums, 0, k);
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[maxIndex];

        for (int i = 0; i < nums.length - k; i++) {
            if (i == maxIndex) {
                maxIndex = getMaxIndex(nums, i + 1, i + k + 1);
            } else {
                if (nums[maxIndex] < nums[i + k]) {
                    maxIndex = i + k;
                }
            }
            result[i + 1] = nums[maxIndex];
        }
        return result;
    }

    @Test
    public void testmaxSlidingWindow() {
        int[] ints = maxSlidingWindow(new int[]{-7, -8, 7, 5, 7, 1, 6, 0}, 4);
    }

    /**
     * @param s
     * @param t
     * @return
     */
    //给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的 最小子串。
    //
    //示例：
    //
    //输入: S = "ADOBECODEBANC", T = "ABC"
    //输出: "BANC"
    //说明：
    //
    //如果 S 中不存这样的子串，则返回空字符串 ""。
    //如果 S 中存在这样的子串，我们保证它是唯一的答案。
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Set<Integer>> map = new HashMap<>();
        Map<Character, Integer> charNums = new HashMap<>();
        char[] chars = t.toCharArray();
        HashSet<Character> set = new HashSet<>();
        for (char c : chars) {
            set.add(c);
            charNums.merge(c, 1, (a, b) -> a + b);
        }
        for (Character aSet : set) {
            map.put(aSet, new HashSet<>());
        }
        int right = 0, left = 0, minLen = Integer.MAX_VALUE, start = 0, end = 0;
        while (right < s.length() + 1) {
            if (checkLen0(map, charNums)) {
                if (right >= s.length()) {
                    break;
                }
                if (set.contains(s.charAt(right))) {
                    map.get(s.charAt(right)).add(right);
                }
                right++;
            } else {
                if (set.contains(s.charAt(left))) {
                    map.get(s.charAt(left)).remove(left);
                    if (minLen > right - left) {
                        minLen = right - left;
                        start = left;
                        end = right;
                    }
                }
                left++;
            }
        }
        if (start == 0 && end == 0 && !s.equals(t)) {
            return "";
        }
        return s.substring(start, end);
    }

    public static String minWindow_Release(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int[] alphas = new int[64];
        for (char c : t.toCharArray()) {
            alphas[c - 'A']++;
        }
        int[] alphasBuf = new int[64];
        int right = 0, left = 0, minLen = Integer.MAX_VALUE, start = 0, end = 0;
        while (right < s.length() + 1) {
            if (checkContent(alphas, alphasBuf)) {
                if (right >= s.length()) {
                    break;
                }
                if (alphas[s.charAt(right) - 'A'] != 0) {
                    alphasBuf[s.charAt(right) - 'A']++;
                }
                right++;
            } else {
                if (alphas[s.charAt(left) - 'A'] != 0) {
                    alphasBuf[s.charAt(left) - 'A']--;
                    if (minLen > right - left) {
                        minLen = right - left;
                        start = left;
                        end = right;
                    }
                }
                left++;
            }
        }
        if (start == 0 && end == 0 && !s.equals(t)) {
            return "";
        }
        return s.substring(start, end);
    }

    @Test
    public void testMinWindow() {
        String T;
        String S;
        S = "AA";
        T = "AA";
        String s = minWindow(S, T);
        System.out.println(s);
    }

    @Test
    public void testMinWindow_Release() {
        String T;
        String S;
        S = "AA";
        T = "AA";
        String s = minWindow_Release(S, T);
        System.out.println(s);
    }

    public static boolean checkContent(int[] ori, int[] check) {
        for (int i = 0; i < ori.length; i++) {
            if (ori[i] > check[i]) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLen0(Map<Character, Set<Integer>> map, Map<Character, Integer> charNums) {
        for (Character c : map.keySet()) {
            if (map.get(c).size() < charNums.get(c)) {
                return true;
            }
        }
        return false;
    }

    //给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
    //
    //你可以假设数组是非空的，并且给定的数组总是存在众数。
    //
    //示例 1:
    //
    //输入: [3,2,3]
    //输出: 3
    //示例 2:
    //
    //输入: [2,2,5,3,2,2,1,1,1,2,2]
    //输出: 2
    //从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
    public static int majorityElement(int[] nums) {
        int count = 0;
        int buf = 0;
        for (int num : nums) {
            if (count == 0) {
                buf = num;
                count++;
            } else {
                if (num != buf) {
                    count--;
                } else {
                    count++;
                }
            }
        }
        return buf;
    }

    //给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //示例:
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
    public static int maxSubArray(int[] nums) {
        int max = 0;
        int sum = 0;
        int minusMax = Integer.MIN_VALUE;
        for (int i : nums) {
            sum += i;
            if (sum > 0) {
                max = Math.max(max, sum);
            } else {
                minusMax = Math.max(minusMax, sum);
                sum = 0;
            }
        }
        if (max == 0) {
            return minusMax;
        }
        return max;
    }

    //  递归+回溯
    //输入: "2*3-4*5"
    //输出: [-34, -14, -10, -10, 10]
    //解释:
    //(2*(3-(4*5))) = -34
    //((2*3)-(4*5)) = -14
    //((2*(3-4))*5) = -10
    //(2*((3-4)*5)) = -10
    //(((2*3)-4)*5) = 10
    // 2 * res1                          res2 - res3                            res4 * 5
    //     3 - res11  res12 * 5         2 * 3   4 * 5          2 * res41  res42 -4
    //         4 * 5   3 - 4                                      3 - 4   2 * 3
    public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> res1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i + 1));
                for (int r1 : res1) {
                    for (int r2 : res2) {
                        switch (c) {
                            case '+':
                                result.add(r1 + r2);
                                break;
                            case '-':
                                result.add(r1 - r2);
                                break;
                            case '*':
                                result.add(r1 * r2);
                                break;
                        }
                    }
                }
            }
        }

        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }

    //输入：points = [[1,3],[-2,2]], K = 1
    //输出：[[-2,2]]
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (o1, o2) -> o1[0] * o1[0] + o1[1] * o1[1] >= o2[0] * o2[0] + o2[1] * o2[1] ? 1 : -1);
        return Arrays.copyOf(points, K);
    }

    // [3,2,1,5,6,4]
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    }

    private static int partition(int[] nums, int l, int r) {
        //减少不必要的交换
        if (r - l == 1) {
            if (nums[l] > nums[r]) {
                int buf = nums[l];
                nums[l] = nums[r];
                nums[r] = buf;
            }
        }
        int i = new Random().nextInt(r - l + 1) + l;
        int val = nums[i];
        nums[i] = nums[l];
        while (l < r) {
            while (l < r && nums[r] >= val)
                r--;
            nums[l] = nums[r];
            while (l < r && nums[l] <= val)
                l++;
            nums[r] = nums[l];
        }
        nums[l] = val;
        return l;
    }

    //编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
    //
    //每行的元素从左到右升序排列。
    //每列的元素从上到下升序排列。
    //示例:
    //
    //现有矩阵 matrix 如下：
    //
    //[
    //  [1,   4,  7, 11, 15],
    //  [2,   5,  8, 12, 19],
    //  [3,   6,  9, 16, 22],
    //  [10, 13, 14, 17, 24],
    //  [18, 21, 23, 26, 30]
    //]
    //给定 target = 5，返回 true。
    //
    //给定 target = 20，返回 false。
    //提示： 走的路径是垂直折线
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int w = matrix[0].length;
        int x = 0, y = matrix.length - 1;

        while (x < w && y >= 0) {
            if (matrix[y][x] > target) {
                y--;
            } else if (matrix[y][x] < target) {
                x++;
            } else {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test799() {
        int[][] matrix = new int[][]{{-1}, {-1}};//new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        searchMatrix(matrix, -2);
    }


    //给定一个仅包含数字 0-9 的字符串和一个目标值，在数字之间添加二元运算符（不是一元）+、- 或 * ，返回所有能够得到目标值的表达式。
    //
    //示例 1:
    //
    //输入: num = "123", target = 6
    //输出: ["1+2+3", "1*2*3"]
    //示例 2:
    //
    //输入: num = "232", target = 8
    //输出: ["2*3+2", "2+3*2"]
    //示例 3:
    //
    //输入: num = "105", target = 5
    //输出: ["1*0+5","10-5"]
    //示例 4:
    //
    //输入: num = "00", target = 0
    //输出: ["0+0", "0-0", "0*0"]
    //示例 5:
    //
    //输入: num = "3456237490", target = 9191
    //输出: []
    public static List<String> addOperators(String num, int target) {
        List<String> formulas = new ArrayList<>();
        if (num.equals("")) {
            return formulas;
        }
        //List<String> list = buildPermutationV(new Character[]{'+', '-', '*','n'}, num.length()-1);
        List<String> list = buildOpString(num, Arrays.asList("+", "-", "*", ""));
        for (String sFormula : list) {
            //含有0开头的数字不计算
            boolean b = false;
            if (sFormula.startsWith("0") && sFormula.length() > 1) {
                if (sFormula.charAt(1) > 47 && sFormula.charAt(1) < 58) {
                    b = true;
                }
            }
            if (!b) {
                for (int j = 0; j < 10; j++) {
                    if (sFormula.contains("+0" + j)) {
                        b = true;
                        break;
                    }
                    if (sFormula.contains("-0" + j)) {
                        b = true;
                        break;
                    }
                    if (sFormula.contains("*0" + j)) {
                        b = true;
                        break;
                    }
                }
            }
            if (!b) {
                long opResult = getOpResult(sFormula);
                if (opResult == target) {
                    formulas.add(sFormula);
                }
            }
        }
        return formulas;
    }

    @Test
    public void test852() {
        addOperators("000", 0).forEach(System.out::println);
    }

    //根据算式计算结果 只含+-* 0-9  20+30*5-2*1  022+1*5
    private static long getOpResult(String formula) {
        formula = formula.trim();
        long preNum = 0;
        char preOp = '+';
        List<Long> subVals = new ArrayList<>();
        for (int i = 0; i < formula.length(); ) {
            if (formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                int j = i + 1;
                while (j < formula.length() && formula.charAt(j) > 47 && formula.charAt(j) < 58) {
                    j++;
                }
                String substring = formula.substring(i, j);
                preNum = Long.valueOf(substring);
                i = j;
            } else if (formula.charAt(i) != '*') {
                if (preOp != '*') {
                    if (preOp == '-') {
                        subVals.add(-preNum);
                    } else {
                        subVals.add(preNum);
                    }
                }
                preOp = formula.charAt(i++);
            } else {
                long subMultSum = preNum;
                while (i < formula.length()) {
                    if (formula.charAt(i) == '-' || formula.charAt(i) == '+') {
                        break;
                    } else if (formula.charAt(i) == '*') {
                        i++;
                    }
                    if (formula.charAt(i) > 47 && formula.charAt(i) < 58) {
                        int k = i + 1;
                        while (k < formula.length() && formula.charAt(k) > 47 && formula.charAt(k) < 58) {
                            k++;
                        }
                        String substring = formula.substring(i, k);
                        subMultSum *= Long.valueOf(substring);
                        i = k;
                    }
                }
                if (preOp == '-') {
                    subVals.add(-subMultSum);
                } else {
                    subVals.add(subMultSum);
                }
                preOp = '*';
            }
        }
        if (preOp == '-') {
            subVals.add(-preNum);
        } else if (preOp == '+') {
            subVals.add(preNum);
        }
        int result = 0;
        for (long i : subVals) {
            result += i;
        }
        return result;
    }

    @Test
    public void test897() {
        System.out.println(getOpResult("011+002*010-03*2"));
    }

    // 实现 数字排列 111 112 113 123 133 ... 233 222 ... 321 322 333
    public static <T> List<String> buildPermutationV(T[] t, int k) {
        List<String> list = new ArrayList<>();
        if (k <= 1) {
            for (T i : t) {
                list.add(String.valueOf(i));
            }
            return list;
        }
        for (int i = 0; i < t.length; i++) {
            List<String> list1 = buildPermutationV(t, k - 1);
            for (String s : list1) {
                list.add(String.valueOf(t[i]) + s);
            }
        }
        return list;
    }

    //  20+30*5-2*1  不含以0开头的数字 02*11-33
    public static List<String> buildOpString(String nums, List<String> ops) {
        List<String> list = new ArrayList<>();
        if (nums.length() <= 1) {
            list.add(nums);
            return list;
        }
        for (int i = 0; i < ops.size(); i++) {
            List<String> subList = buildOpString(nums.substring(1), ops);
            char c = nums.charAt(0);
            for (String s : subList) {
                list.add(String.valueOf(c) + ops.get(i) + s);
            }
        }
        return list;
    }

    @Test
    public void test976() {
        List<String> list = buildOpString("001", Arrays.asList("+", "-", "*", ""));
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    public void test991() {
        addOperatorsRelese("132", 7).forEach(System.out::println);
    }

    public List<String> addOperatorsRelese(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }

        help(num, target, 0, 0, 0, "", res);
        return res;
    }

    private void help(String num, int target, long curRes, long diff, int start, String curExp, List<String> expressions) {
        if (start == num.length() && (long) target == curRes) {
            expressions.add(curExp);
        }

        for (int i = start; i < num.length(); i++) {
            String cur = num.substring(start, i + 1);
            if (cur.length() > 1 && cur.charAt(0) == '0') {
                break;
            }

            if (curExp.length() > 0) {
                help(num, target, curRes + Long.valueOf(cur), Long.valueOf(cur), i + 1, curExp + "+" + cur, expressions);
                help(num, target, curRes - Long.valueOf(cur), -Long.valueOf(cur), i + 1, curExp + "-" + cur, expressions);
                help(num, target, (curRes - diff) + diff * Long.valueOf(cur), diff * Long.valueOf(cur),
                        i + 1, curExp + "*" + cur, expressions);
            } else {
                help(num, target, Long.valueOf(cur), Long.valueOf(cur), i + 1, cur, expressions);
            }
        }
    }

    @Test
    public void test859() {
        AtomicInteger i = new AtomicInteger(1);
        buildPermutationV(new Character[]{'1', '2', '3', ' '}, 3).forEach(s -> System.out.println(i.getAndIncrement() + " " + s));
    }


    //合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。   单向递归每次找最小的
    //
    //示例:
    //
    //输入:
    //[
    //  1->4->5,
    //  1->3->4,
    //  2->6
    //]
    //输出: 1->1->2->3->4->4->5->6
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode listNode = new ListNode(0);
        List<ListNode> list = new ArrayList<>();
        for (ListNode n : lists) {
            if (n != null) {
                list.add(n);
            }
        }
        mergeHelp(list, listNode);
        return listNode.next;
    }

    public static void mergeHelp(List<ListNode> lists, ListNode resTail) {
        if (lists.size() <= 0) {
            return;
        } else if (lists.size() == 1) {
            resTail.next = lists.get(0);
            return;
        }
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < lists.size(); i++) {
            if (min > lists.get(i).val) {
                min = lists.get(i).val;
                minIndex = i;
            }
        }
        if (lists.get(minIndex).next == null) {
            lists.remove(minIndex);
        } else {
            ListNode oldNode = lists.get(minIndex);
            oldNode = oldNode.next;
            lists.remove(minIndex);
            lists.add(oldNode);
        }
        ListNode newNode = new ListNode(min);
        resTail.next = newNode;

        mergeHelp(lists, newNode);
    }

    @Test
    public void test1083() {
        ListNode[] listNodes = new ListNode[2];
        mergeKLists(listNodes);
    }

    public static ListNode mergeKListsRelese(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwo(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; i < lists.length; i++, j++) {
            l2[j] = lists[i];
        }
        return mergeTwo(mergeKListsRelese(l1), mergeKListsRelese(l2));
    }

    public static ListNode mergeTwo(ListNode n1, ListNode n2) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                node.next = new ListNode(n2.val);
                n2 = n2.next;
            } else {
                node.next = new ListNode(n1.val);
                n1 = n1.next;
            }
            node = node.next;
        }

        if (n1 == null) {
            node.next = n2;
        } else {
            node.next = n1;
        }

        return head.next;
    }

    @Test
    public void test1132() {
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = getList(4);
        listNodes[1] = getList(4);
        listNodes[2] = getList(5);
        ListNode node = mergeKListsRelese(listNodes);
        scanList(node);
    }

    //给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    //
    //请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    //
    //你可以假设 nums1 和 nums2 不会同时为空。
    //
    //示例 1:
    //
    //nums1 = [1, 3]
    //nums2 = [2]
    //
    //则中位数是 2.0
    //示例 2:
    //
    //nums1 = [1, 2]
    //nums2 = [3, 4]
    //
    //则中位数是 (2 + 3)/2 = 2.5
    // 16
    //  234789
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 1;
    }

    @Test
    public void test1221() {
        double medianSortedArrays = findMedianSortedArrays(new int[]{1}, new int[]{2});
    }

    //给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
    //
    //示例:
    //
    //输入: [5,2,6,1]
    //输出: [2,1,1,0]
    //解释:
    //5 的右侧有 2 个更小的元素 (2 和 1).
    //2 的右侧仅有 1 个更小的元素 (1).
    //6 的右侧有 1 个更小的元素 (1).
    //1 的右侧有 0 个更小的元素.
    public static List<Integer> countSmaller(int[] nums) {
        Integer[] counts = new Integer[nums.length];
        if (nums.length == 0) {
            return Arrays.asList(counts);
        }
        for (int i = 0; i < nums.length; i++) {
            counts[i] = 0;
        }
        TreeNode root;
        root = new TreeNode(nums[nums.length - 1]);
        for (int i = nums.length - 2; i > -1; i--) {
            insertTreeNode(nums[i], i, root, counts);
        }
        return Arrays.asList(counts);
    }

    private static void insertTreeNode(int val, int i, TreeNode root, Integer[] counts) {
        if (root.val < val) {
            counts[i] += root.lCount + 1;
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertTreeNode(val, i, root.right, counts);
            }
        } else {
            root.lCount++;
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertTreeNode(val, i, root.left, counts);
            }
        }
    }

    //利用二叉搜索树的特性：左边节点的值小于等于当前节点值，右边节点的值大于等于当前节点值。
    //
    //那么实现算法首先要构建一颗二叉搜索树：
    //
    //定义树的节点结构 TreeNode
    //实现树的节点插入方法 insertNode
    //其中， insertNode 方法需要实现几个功能：
    //
    //构建二叉树
    //维护每个节点中其左子树节点数量值 count：如果新加入的节点需要加入当前节点的左子树，则当前节点的 count += 1
    //计算出新加入节点 nums[i] 的 "右侧小于当前元素的个数"，即题目所求值 res[i]
    @Test
    public void test1227() {
        countSmaller(new int[]{2, 0, 1});
    }

    @Test
    public void test1195() {
        countSmaller(new int[]{5, 2, 6, 1});
    }


    //给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。
    //
    //二叉搜索树保证具有唯一的值。
    //
    //
    //
    //示例 1：
    //
    //输入：root = [10,5,15,3,7,null,18], L = 7, R = 15
    //输出：32
    //示例 2：
    //
    //输入：root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
    //输出：23
    // point : 搜索二叉树 中序遍历 即可得到 从大到小的排序（或相反）
    public static int rangeSumBST(TreeNode root, int L, int R) {
        int[] sum = new int[1];
        help1(root, L, R, sum);
        return sum[0];
    }

    public static void help1(TreeNode node, int L, int R, int[] sum) {  //必须要传引用，包装类不行其中value被final修饰，自定义类或数组可以
        if (node == null) {
            return;
        }
        help1(node.left, L, R, sum);
        if (node.val >= L && node.val <= R) {
            sum[0] += node.val;
        }
        help1(node.right, L, R, sum);
    }

    //给定一个二叉搜索树的根结点 root, 返回树中任意两节点的差的最小值。
    //
    //示例：
    //
    //输入: root = [4,2,6,1,3,null,null]
    //输出: 1
    //解释:
    //注意，root是树结点对象(TreeNode object)，而不是数组。
    //
    //给定的树 [4,2,6,1,3,null,null] 可表示为下图:
    //
    //          4
    //        /   \
    //      2      6
    //     / \
    //    1   3
    //
    //最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。
    public static int diff = Integer.MAX_VALUE;
    public static int pre = Integer.MAX_VALUE;

    public static int minDiffInBST(TreeNode root) {
        help2(root);
        return diff;
    }

    public static void help2(TreeNode node) {
        if (node == null) {
            return;
        }
        help2(node.left);
        diff = Math.min(diff, Math.abs(pre - node.val));
        pre = node.val;
        help2(node.right);
    }

    //给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。
    //
    //注意：两个节点之间的路径长度由它们之间的边数表示。
    //
    //示例 1:
    //
    //输入:
    //
    //              5
    //             / \
    //            4   5
    //           / \   \
    //          1   1   5
    //输出: 2
    // 对于任意一个节点, 如果最长同值路径包含该节点, 那么只可能是两种情况:
    //        1. 其左右子树中加上该节点后所构成的同值路径中较长的那个继续向父节点回溯构成最长同值路径
    //        2. 左右子树加上该节点都在最长同值路径中, 构成了最终的最长同值路径
    //        需要注意因为要求同值, 所以在判断左右子树能构成的同值路径时要加入当前节点的值作为判断依据
    public static int maxL = 0;

    public static int longestUnivaluePath(TreeNode root) {
        getMaxL(root, 0);  //任意val都可以
        return maxL;
    }

    /**
     * @param node 当前节点
     * @param val  父节点value
     * @return
     */
    public static int getMaxL(TreeNode node, int val) {
        if (node == null)
            return 0;
        int left = getMaxL(node.left, node.val);
        int right = getMaxL(node.right, node.val);
        maxL = Math.max(maxL, left + right);
        if (val == node.val) {
            return Math.max(right, left) + 1;
        }
        return 0;
    }

    //满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
    //
    //返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
    //
    //答案中每个树的每个结点都必须有 node.val=0。
    //
    //你可以按任何顺序返回树的最终列表。
    //
    //
    public List<TreeNode> allPossibleFBT(int N) {
        if (N % 2 == 0) {
            return new ArrayList<TreeNode>();
        }
        return getTreeNodes(N);
    }

    public List<TreeNode> getTreeNodes(int N) {
        List<TreeNode> list = new ArrayList<>();
        if (N == 1) {
            list.add(new TreeNode(0));
            return list;
        }
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> lr = allPossibleFBT(i);
            List<TreeNode> ll = allPossibleFBT(N - i - 1);
            for (TreeNode aLr : lr) {
                for (TreeNode aLl : ll) {
                    TreeNode root = new TreeNode(0);
                    root.right = aLr;
                    root.left = aLl;
                    list.add(root);
                }
            }
        }
        return list;
    }

    //给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
    //
    //示例 1：
    //
    //输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
    //输出： True
    //说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
    //
    //
    //注意:
    //
    //1 <= k <= len(nums) <= 16
    //0 < nums[i] < 10000
    public boolean canPartitionKSubsets(int[] nums, int k) {
        return false;
    }

    //在第一行我们写上一个 0。接下来的每一行，将前一行中的0替换为01，1替换为10。
    //
    //给定行数 N 和序数 K，返回第 N 行中第 K个字符。（K从1开始）
    //
    //
    //例子:
    //
    //输入: N = 1, K = 1
    //输出: 0
    //
    //输入: N = 2, K = 1
    //输出: 0
    //
    //输入: N = 2, K = 2
    //输出: 1
    //
    //输入: N = 4, K = 5
    //输出: 1
    //
    //解释:
    //第一行:         0
    //第二行:     0      1
    //第三行:   0   1  1   0
    //第四行:  0 1 1 01 0 0 1
    // 思路 ：二分思想
    public int kthGrammar(int N, int K) {
        double pow = Math.pow(2, N - 1);  // 估算出所求行子节点个数
        return help(0, (int) pow, K);
    }

    public int help(int i, int roof, int k) {  // 求以i(i为0或1)为第一行，第n（2的n-1次方=roof）行的第k个字符
        if (roof < 2) {
            return i;
        }
        int hfloor = roof / 2;
        if (k > hfloor) {            // 所要找的点在后段，转化为求以0或1为第一行，第n-1行的第k-hfloor个字符
            if (i == 0) {
                return help(1, hfloor, k - hfloor);
            } else {
                return help(0, hfloor, k - hfloor);
            }
        } else {                   // 所要找的点在前段，转化为求以0或1为第一行，第n-1行的第k个字符
            if (i == 0) {
                return help(0, hfloor, k);
            } else {
                return help(1, hfloor, k);
            }
        }
    }

    /**
     * @param formula
     * @return
     */
    //输入:
    //formula = "K4(CO2)3(ON(SO3)2)2"
    //输出: "K4N2O14S4"
    //解释:
    //原子的数量是 {'K': 4, 'N': 2, 'O': 14, 'S': 4}。
    // 65-90 A-Z 97-122 a-z 48-57 0-9

   /* private String formula;
    private int length;*/
    public static String countOfAtoms(String formula) {
        HashMap<String, Integer> rst = helpz(formula, 0);
        String s = rst.entrySet().stream().sorted((o1, o2) -> {
            int comprst = o1.getKey().compareTo(o2.getKey());
            if (comprst > 0) {
                return 1;
            } else if (comprst < 0) {
                return -1;
            }
            Integer v1 = o1.getValue();
            Integer v2 = o2.getValue();
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            } else {
                return 0;
            }
        }).map(entry -> {
            if (entry.getValue() != 1) {
                return entry.getKey() + entry.getValue();
            } else {
                return entry.getKey();
            }
        }).reduce(String::concat).get();
        return s;
    }

    @Test
    public void test1501() {
        System.out.println(countOfAtoms("(ScTh13)16Tb22C18Fl34Ag14(At41Bk4NpEsTc27Am20)3"));
    }


    public static HashMap<String, Integer> helpz(String formula, int start) {
        HashMap<String, Integer> map = new HashMap<>();
        int length = formula.length();
        for (int i = start; i < length; ) {
            char c = formula.charAt(i);
            i++;
            if (c > 64 && c < 91) {
                StringBuilder atom = new StringBuilder(c + "");
                while (i < length) {
                    char c1 = formula.charAt(i);
                    if (c1 > 96 && c1 < 123) {
                        atom.append(c1);
                        i++;
                    } else {
                        break;
                    }
                }
                StringBuilder num = new StringBuilder();
                while (i < length) {
                    char c1 = formula.charAt(i);
                    if (c1 > 47 && c1 < 58) {
                        num.append(c1);
                        i++;
                    } else {
                        break;
                    }
                }
                if (num.length() == 0) {
                    map.merge(atom.toString(), 1, (oldV, newV) -> {
                        return oldV + newV;
                    });
                } else {
                    Integer numx = Integer.valueOf(num.toString());
                    map.merge(atom.toString(), numx, (oldV, newV) -> {
                        return oldV + newV;
                    });
                }
            } else if (c == '(') {
                HashMap<String, Integer> helpz = helpz(formula, i);
                i = helpz.get("$");
                helpz.remove("$");
                helpz.forEach((key, val) -> {
                    map.merge(key, val, (oldV, newV) -> {
                        return oldV + newV;
                    });
                });
            } else if (c == ')') {
                StringBuilder num = new StringBuilder();
                while (i < length) {
                    char c1 = formula.charAt(i);
                    if (c1 > 47 && c1 < 58) {
                        num.append(c1);
                        i++;
                    } else {
                        break;
                    }
                }
                if (num.length() > 0) {
                    for (String key : map.keySet()) {
                        map.put(key, map.get(key) * Integer.valueOf(num.toString()));
                    }
                }
                map.put("$", i);
                return map;
            }
        }
        return map;
    }

    @Test
    public void test1533() {
        helpz("(ScTh13)16Tb22C18Fl34Ag14(At41Bk4NpEsTc27Am20)3", 0).forEach((s, integer) -> System.out.println(s + " " + integer));
    }

    //s = "3[a]2[bc]", 返回 "aaabcbc".
    //s = "3[a2[c]]", 返回 "accaccacc".
    //s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
    // 方法一 ：本方法
    // 方法二low ：如果遇到 ']'，就一直在栈中找到 '['，将之间的字符连接起来，将 '['前面的数字连接起来作为出现次数再次压栈，
    //         遇到数字、字母、'['就直接压栈，最后将栈里的字符串弹出连接起来就ok了
    private int slen;
    private String s;

    public String decodeString(String s) {
        this.slen = s.length();
        this.s = s;
        return helpd(0).s;
    }

    @Test
    public void test1593() {
        String s = decodeString("2[abc]3[cd]ef");
        System.out.println(s);
    }

    private class HelpObj {
        public String s;
        public int ridx;

        public HelpObj(String s, int ridx) {
            this.s = s;
            this.ridx = ridx;
        }
    }

    public HelpObj helpd(int start) {
        StringBuilder sb = new StringBuilder();
        int prefix = 0;
        for (int i = start; i < slen; ) {
            char c = s.charAt(i);
            i++;
            if (c > 47 && c < 58) {
                StringBuilder num = new StringBuilder();
                num.append(c);
                while (i < slen) {
                    char c1 = s.charAt(i);
                    if (c1 > 47 && c1 < 58) {
                        num.append(c1);
                        i++;
                    } else {
                        break;
                    }
                }
                prefix = Integer.valueOf(num.toString());
            } else if ((c > 96 && c < 123) || (c > 64 && c < 91)) {
                sb.append(c);
                while (i < slen) {
                    char c1 = s.charAt(i);
                    if (c1 > 96 && c1 < 123) {
                        sb.append(c1);
                        i++;
                    } else {
                        break;
                    }
                }
            } else if (c == '[') {
                HelpObj helpd = helpd(i);
                while (prefix > 1) {
                    sb.append(helpd.s);
                    prefix--;
                }
                sb.append(helpd.s);
                i = helpd.ridx;
            } else if (c == ']') {
                return new HelpObj(sb.toString(), i);
            }
        }
        return new HelpObj(sb.toString(), 0);
    }

    //给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count == 1;
    }

    // 减一相与为0
    public boolean isPowerOfTwo_unlimited(int n) {
        return (n > 0) && ((((n - 1) & n) == 0));
    }

    //求最大容量水桶
    //动态规划
    //这里用到了动态规划，基本的表达式: area = min(height[i], height[j]) * (j - i)
    // 使用两个指针，值小的指针向内移动，
    // 这样就减小了搜索空间 因为面积取决于指针的距离与值小的值乘积，如果值大的值向内移动，
    // 距离一定减小，而求面积的另外一个乘数一定小于等于值小的值，因此面积一定减小，
    // 而我们要求最大的面积，因此值大的指针不动，而值小的指针向内移动遍历
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int lHigh = height[left];
            int rHigh = height[right];
            maxArea = Math.max(maxArea, Math.min(lHigh, rHigh) * (right - left));
            if (lHigh > rHigh) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    @Test
    public void test1672() {
        System.out.println(isPowerOfTwo(45));
    }

    //给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
    //
    //示例 1：
    //
    //输入: "babad"
    //输出: "bab"
    //注意: "aba" 也是一个有效答案。
    //示例 2：
    //
    //输入: "cbbd"
    //输出: "bb"
    public String longestPalindrome(String s) {
        String longestStr = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                String curStr = s.substring(i, j);
                if (isPalindrome(curStr)) {
                    longestStr = curStr.length() > longestStr.length() ? curStr : longestStr;
                }
            }
        }
        return longestStr;
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }

    //Z字形变换
    //将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
    //
    //比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
    //
    //L   C   I   R     0,4,8,12
    //E T O E S I I G   1,3,5,7,9,11,13,15
    //E   D   H   N     2,6,10,14
    //之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
    //
    //请你实现这个将字符串进行指定行数变换的函数：
    //
    //string convert(string s, int numRows);
    //示例 1:
    //
    //输入: s = "LEETCODEISHIRING", numRows = 3
    //输出: "LCIRETOESIIGEDHN"
    //示例 2:
    //
    //输入: s = "LEETCODEISHIRING", numRows = 4
    //输出: "LDREOEIIECIHNTSG"
    //解释:
    //
    //L     D     R   0,6,12
    //E   O E   I I   1,5,7,11
    //E C   I H   N   2,4,8,10
    //T     S     G   3,9
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int len = s.length();
        int colNum = 0;
        while (len > 0) {
            len -= numRows;
            colNum++;
            for (int i = 0; i < numRows - 2; i++) {
                if (len < 1)
                    break;
                len -= 1;
                colNum++;
            }
        }
        char[][] matrix = new char[numRows][colNum];
        int x = 0, y = 0, cur = 0;
        while (cur < s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (cur > s.length() - 1)
                    break;
                matrix[x++][y] = s.charAt(cur++);
            }
            x -= 2;
            y++;
            for (int i = 0; i < numRows - 2; i++) {
                if (cur > s.length() - 1)
                    break;
                matrix[x--][y++] = s.charAt(cur++);
            }
        }

        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < colNum; j++) {
                char c = matrix[i][j];
                if (c != '\0') {
                    rst.append(c);
                }
            }
        }
        return rst.toString();
    }

    @Test
    public void test1776() {
        String s = convert("AB", 1);
        System.out.println(s);
    }

    //给定两个整数 L 和 R ，找到闭区间 [L, R] 范围内，计算置位位数为质数的整数个数。
    //
    //（注意，计算置位代表二进制表示中1的个数。例如 21 的二进制表示 10101 有 3 个计算置位。还有，1 不是质数。）
    public int countPrimeSetBits(int L, int R) {
        int count = 0;
        for (int i = L; i < R + 1; i++) {
            int bc = Integer.bitCount(i);
            boolean is = true;
            if (bc != 2) {
                if (bc != 1 && bc % 2 != 0) {
                    for (int j = 3; j <= Math.sqrt(bc); j++) {
                        if (bc % j == 0) {
                            is = false;
                            break;
                        }
                    }
                } else {
                    is = false;
                }
            }
            if (is) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test1831() {
        int i = countPrimeSetBits(6
                , 10);
        System.out.println(i
        );
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
    //
    //说明：
    //
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    // 注意：异或满足交换律
    //示例 1:
    //
    //输入: [2,2,1]
    //输出: 1
    //示例 2:
    //
    //输入: [4,1,2,1,2]
    //输出: 4
    public int singleNumber(int[] nums) {
        int rst = 0;
        for (int i : nums) {
            rst ^= i;
        }
        return rst;
    }

    //给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
    //
    //示例 1:
    //
    //输入: 5
    //输出: True
    //解释:
    //5的二进制数是: 101
    //示例 2:
    //
    //输入: 7
    //输出: False
    //解释:
    //7的二进制数是: 111
    public boolean hasAlternatingBits(int n) {
        int i = (Integer.highestOneBit(n) << 1) - 1;
        int a = 0x55555555 & i;
        int b = 0xAAAAAAAA & i;
        if ((n ^ a) == 0) {
            return true;
        }
        if ((n ^ b) == 0) {
            return true;
        }
        return false;
    }

    public boolean hasAlternatingBits_Plus(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp + 1)) == 0;
    }
    //        int temp=n^(n>>1);
    //        return (temp&(temp+1))==0;
    //
    // /*
    //    * 分析：
    //    * 如果n是交替的01，对于它右移一位后得到的m，
    //    * 存在n跟m在二进制下必然是0和1对应的（对位）。异或运算必定都是1；
    //    * 举个栗子：5=101 5>>1=10,5^(5>>1)=111 (这是伪代码)
    //    *  101
    //    *   10  =111
    //    * 其他情况都不会满足这个特征。所以temp=n^(n>>1)必定满足temp=2^N-1;
    //    * 而temp+1后是N+1位二进制数2^(N+1)。
    //    * 所以temp&(temp+1)==0；
    //    * 如果满足这个等式就是就是交替位二进制数
    //    */

    @Test
    public void test1889() {
        System.out.println(hasAlternatingBits(7));
    }

    //示例:
    //输入: S = "a1b2"
    //输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
    public List<String> letterCasePermutation(String S) {
        return help(S, 0);
    }

    public List<String> help(String s, int offset) {
        if (offset > s.length() - 1) {
            List<String> l = new ArrayList<>();
            l.add(s);
            return l;
        }
        while (s.charAt(offset) > 47 && s.charAt(offset) < 58) {
            offset++;
            if (offset > s.length() - 1) {
                List<String> l = new ArrayList<>();
                l.add(s);
                return l;
            }
        }
        char[] chars = s.toCharArray();
        if (chars[offset] > 96) {
            chars[offset] = (char) (chars[offset] - 32);
        } else if (chars[offset] < 91) {
            chars[offset] = (char) (chars[offset] + 32);
        }
        String s1 = String.valueOf(chars);
        List<String> help1 = help(s, offset + 1);
        List<String> help2 = help(s1, offset + 1);
        help1.addAll(help2);
        return help1;
    }

    @Test
    public void test359() {
        letterCasePermutation("C").forEach(System.out::println);
    }

    //binary diff
    public char findTheDifference(String s, String t) {
        int sSum = 0, tSum = 0;
        for (char c : s.toCharArray()) {
            sSum += c;
        }
        for (char c : t.toCharArray()) {
            tSum += c;
        }
        return (char) (tSum - sSum);
    }

    //不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
    //
    //示例 1:
    //
    //输入: a = 1, b = 2
    //输出: 3
    //示例 2:
    //
    //输入: a = -2, b = 3
    //输出: 1
    //
    //思路 ： 两个整数a, b; a ^ b是无进位的相加； a&b<<1得到每一位的进位；
    //       让无进位相加的结果与进位不断的异或， 直到进位为0；
    public int getSum(int a, int b) {
        int carry = 0, sum = 0;
        do {
            sum = a ^ b;
            carry = (a & b) << 1;
            if (carry != 0) {
                a = sum;
                b = carry;
            }
        } while (carry != 0);
        return sum;
    }

    @Test
    public void test1885() {
        System.out.println(getSum(3, 36));
    }

    //给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
    //
    //示例 1:
    //
    //输入: [3,0,1]
    //输出: 2
    //
    // 1^1^2^2^3 = 3
    // 异或
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
            res ^= i;
        }
        return res;
    }

    @Test
    public void test2007() {
        System.out.println(missingNumber(new int[]{0, 2, 3, 4, 1, 6, 7, 8}));
    }

    //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
    //
    //说明：
    //
    //你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
    //
    //示例 1:
    //
    //输入: [2,2,3,2]
    //输出: 3
    //示例 2:
    //
    //输入: [0,1,0,1,0,1,99]
    //输出: 99
    //
    //故可得出公式结果a结果b的表达式:
    //结果a = (a & ~b & ~c) + (~a & b & c)
    //结果b = (~a & ~b & c) + (~a & b & ~c)
    //另外根据逻辑代数分配率公式也可以变成:
    //结果b = ~a & (~b & c + b & ~c) = ~a & (b^c) //二进制进位逻辑
    //再然后根据上图a,c,结果b 三者的关系写出结果a的逻辑
    //结果a = a & ~c & (~结果b) + ~a & c & (~结果b) = (~结果b) & (a^c)
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;            //b代表 出现一次的bit  a代表出现两次bit
        for (int c : nums) {
            b = b ^ c & ~a;
            a = a ^ c & ~b;
        }
        return b;
    }

    @Test
    public void test2054() {
        int i = singleNumber2(new int[]{3, 3, 3, 7, 5, 5, 5, 2, 2});
        System.out.println(i);
    }

    //给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。
    //
    //示例 :
    //
    //输入: [1,2,1,3,2,5]
    //输出: [3,5]
    //注意：
    //
    //结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
    //你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
    public int[] singleNumber_two(int[] nums) {
        int twone = 0;
        for (int i : nums) {
            twone ^= i;
        }
        int diff = twone & -twone; //最右边的1
        int[] res = new int[2];
        for (int i : nums) {
            if ((diff & i) == 0) {    //按该不同位将其分为该位为1或0的两组，
                res[0] ^= i;      //再次异或
            } else {
                res[1] ^= i;
            }
        }
        return res;
    }

    //给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
    //
    //示例 1:
    //
    //输入: 16
    //输出: true
    //示例 2:
    //
    //输入: 5
    //输出: false
    // 思路  2的幂 且 奇数未为1
    public boolean isPowerOfFour(int num) {
        if (num <= 0 || (num & -num) != num) {
            return false;
        }
        return (num & 0x55555555) == num; // 或者 num%3==1 : 4^n=(3+1)^n=3x+1
    }

    //从低4位开始取 （较慢）
    public String toHex(int num) {
        char[] charNums = new char[6];
        for (int i = 0, j = 97; i < charNums.length; i++, j++) {
            charNums[i] = (char) j;
        }
        StringBuilder sb = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int x = num & 15;
            if (x - 9 > 0) {
                sb.insert(0, charNums[x - 10]);
            } else {
                sb.insert(0, x);
            }
            num >>>= 4;
        }
        int i = 0;
        while (i < 7 && sb.charAt(i) == '0') {
            i++;
        }
        return sb.substring(i);
    }

    @Test
    public void test2123() {
        System.out.println(toHex(0));
    }

    //从高4位开始取 （快）
    public String toHexRe(int num) {
        boolean mark = false;
        StringBuilder sb = new StringBuilder(8);
        for (int i = 7; i > -1; i--) {
            int x = (num >>> 4 * i) & 15;
            if (x - 9 > 0) {
                sb.append((char) (x + 87));
                if (!mark) {
                    mark = true;
                }
            } else if (x == 0) {
                if (mark) {
                    sb.append('0');
                }
            } else {
                sb.append(x);
                if (!mark) {
                    mark = true;
                }
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    @Test
    public void test2156() {
        System.out.println(toHexRe(998));
    }


    //位移法
    public int reverseBits(int n) {
        int res = 0;
        int i = 32;
        while (i-- > 0) {
            res <<= 1; //位移31次，这一次空移
            res += n & 1; //加32次
            n >>= 1;
        }
        return res;
    }

    @Test
    public void test2176() {
        System.out.println(reverseBits(998));
        System.out.println(Integer.reverse(998));
    }


    //输入: nums = [1,2,3]
    //输出:
    //[
    //  [3],
    //  [1],
    //  [2],
    //  [1,2,3],
    //  [1,3],
    //  [2,3],
    //  [1,2],
    //  []
    //]
    //
    // 1 2  21 3 31 32 321
    //遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subRst = new ArrayList<>();
            for (List<Integer> list : rst) {
                List<Integer> subl = new ArrayList<>();
                subl.add(nums[i]);
                subl.addAll(list);
                subRst.add(subl);
            }
            rst.addAll(subRst);
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[i]);
            rst.add(sub);
        }
        List<Integer> emptyl = new ArrayList<>();
        rst.add(emptyl);
        return rst;
    }

    @Test
    public void test2209() {
        subsets(new int[]{1, 2, 3}).forEach(ins -> {
            ins.forEach(System.out::print);
            System.out.println();
        });
    }

    //位运算解法
    //数组 [1,2,3] 的子集也就是其中的三个元素取与不取的组合。
    // 把它想象为二进制的三个 bit 位 1 1 1，那么从 0 0 0 到 1 1 1 的 8 个数，
    // 就构成了所有子集的选取情况。比如 0 0 1 表示取第1个元素，0 1 1 表示取前两个元素。
    public List<List<Integer>> subsetsByBitOperation(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> onePos = readOnePos(i, nums.length);
            List<Integer> subRst = new ArrayList<>();
            for (int p : onePos) {
                subRst.add(nums[p]);
            }
            rst.add(subRst);
        }
        return rst;
    }


    //读取1所在位置
    public List<Integer> readOnePos(int n, int len) {
        List<Integer> rst = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if ((n & 1) == 1) {
                rst.add(i);
            }
            n >>>= 1;
        }
        return rst;
    }

    @Test
    public void test2239() {
        subsetsByBitOperation(new int[]{1, 2, 3}).forEach(ins -> {
            ins.forEach(System.out::print);
            System.out.println();
        });
    }


    //给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
    //
    //示例 1:
    //
    //输入: 2
    //输出: [0,1,1]
    //示例 2:
    //
    //输入: 5
    //输出: [0,1,1,2,1,2]
    //进阶:
    //
    //给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
    //要求算法的空间复杂度为O(n)。
    //你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。

    // i & (i - 1)可以去掉i最右边的一个1（如果有），
    // 因此 i & (i - 1）是比 i 小的，
    // 而且i & (i - 1)的1的个数已经在前面算过了，
    // 所以i的1的个数就是 i & (i - 1)的1的个数加上1
    public int[] countBits(int num) {
        int[] rst = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            rst[i] = rst[i & (i - 1)] + 1;
        }
        return rst;
    }

    //i >> 1会把最低位去掉，因此i >> 1 也是比i小的，同样也是在前面的数组里算过。
    // 当 i 的最低位是0，则 i 中1的个数和i >> 1中1的个数相同；
    // 当i的最低位是1，i 中1的个数是 i >> 1中1的个数再加1
    public int[] countBitsTwo(int num) {
        int[] rst = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            rst[i] = rst[i >>> 1] + (i & 1);
        }
        return rst;
    }

    @Test
    public void test2294() {
        Arrays.stream(countBits(5)).forEach(System.out::println);
    }


    //给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
    //
    //示例 1:
    //
    //输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
    //输出: 16
    //解释: 这两个单词为 "abcw", "xtfn"。
    //示例 2:
    //
    //输入: ["a","ab","abc","d","cd","bcd","abcd"]
    //输出: 4
    //解释: 这两个单词为 "ab", "cd"。
    //示例 3:
    //
    //输入: ["a","aa","aaa","aaaa"]
    //输出: 0
    //解释: 不存在这样的两个单词。
    //
    // 解答 将单词转为26位bit 相与为0则为不重复
    public int maxProduct(String[] words) {
        int maxl = 0, len = words.length;
        int[] wordsBit = new int[len];
        for (int i = 0; i < len; i++) {
            wordsBit[i] = wordsTo26bit(words[i]);
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((wordsBit[i] & wordsBit[j]) == 0) {
                    maxl = Math.max(maxl, words[i].length() * words[j].length());
                }
            }
        }
        return maxl;
    }

    public int wordsTo26bit(String s) {
        int i = 0, rst = 0;
        for (char c : s.toCharArray()) {
            i = c - 'a';
            rst |= (1 << i);
        }
        return rst;
    }

    @Test
    public void test2353() {
        System.out.println(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    }

    //给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。
    //
    //找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。
    //
    //你能在O(n)的时间解决这个问题吗？
    //
    //示例:
    //
    //输入: [3, 10, 5, 25, 2, 8]
    //
    //输出: 28
    //
    //解释: 最大的结果是 5 ^ 25 = 28.
    //
    // 找到最大数，然后找到最大数最高位相同的数的集合，然后每个数和nums相与
    public int findMaximumXOR(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        List<Integer> highNums = new ArrayList<>();
        int highBitPos = Integer.highestOneBit(max);
        for (int i = 0; i < nums.length; i++) {
            if (Integer.highestOneBit(nums[i]) == highBitPos) {
                highNums.add(nums[i]);
            }
        }
        int maxXOR = 0;
        for (int i = 0; i < highNums.size(); i++) {
            for (int j = 0; j < nums.length; j++) {
                maxXOR = Math.max(maxXOR, highNums.get(i) ^ nums[j]);
            }
        }
        return maxXOR;
    }

    @Test
    public void test2381() {
        System.out.println(findMaximumXOR(new int[]{2, 10, 8}));
    }

    //所有 DNA 由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
    //
    //编写一个函数来查找 DNA 分子中所有出现超多一次的10个字母长的序列（子串）。
    //
    //示例:
    //
    //输入: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    //
    //输出: ["AAAAACCCCC", "CCCCCAAAAA"]
    //
    //hashcode
    // 遍历 0 到 len-10
    // 每个string放入set，
    // 有冲突则加入rst
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> hashSet = new HashSet<>();
        HashSet<String> rst = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String curStr = s.substring(i, i + 10);
            if (hashSet.contains(curStr)) {  //先hashcode比较在equal 所以比直接==快
                rst.add(curStr);
            }
            hashSet.add(curStr);
        }

        return new ArrayList<>(rst);
    }

    @Test
    public void test2415() throws IOException {
        FileInputStream fis = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\maven_test\\src\\main\\java\\algorithm\\aa.txt");
        byte[] buf = new byte[64];
        int len;
        StringBuffer sb = new StringBuffer();
        while ((len = fis.read(buf)) != -1) {
            sb.append(new String(buf, 0, len));
        }
        System.out.println(sb.toString());
        findRepeatedDnaSequences(sb.toString()).forEach(System.out::println);
    }

    //两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
    //
    //计算一个数组中，任意两个数之间汉明距离的总和。
    //
    //示例:
    //
    //输入: 4, 14, 2
    //
    //输出: 6
    //
    //解释: 在二进制表示中，4表示为0100，14表示为1110，2表示为0010。（这样表示是为了体现后四位之间关系）
    //所以答案为：
    //HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
    //注意:
    //思路
    // 当然一开始想到的是将任意两个元素所有位比较一遍，得到汉明距离，然后再将这些距离都加起来。
    // 但是稍微学过一点数据结构和算法的都能想到这样做会有大量的重复比较，举个例子，a、b、c三个数，
    // 假设a最低位为1，b为0，c为1，在a与b、a与c比较完最低位之后，
    // 与c没有就没有必要再比较最低位了（因为a与c相同，a与b不同，那么c与b一定不同）。
    // 所以换个思路，对于二进制数来说每一位不是0就是1，如果在总数为n个的数组中有a个元素的第i位为1，
    // 则第i位为0的有n-i个元素，按照排列组合的知识，就第i位来说，从这a个元素里任取一个，
    // 它与这n-a个元素中的任一个元素距离都是1，而这样的组合一共有a*(n-a)个。
    // 将i从第0位到最高位时的a*(n-a)加起来就是总的距离。
    // 还有一个问题是如何判断已经移动到最高位了（这里最高位不是int的位数，
    // 而是使得数组中所有元素都为0时，所需要向右移动的最小位数），每次将各个元素除以2，
    // 相当于右移，移动到元素值全部为0时，就结束了
    public int totalHammingDistance(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int highOneV = Integer.highestOneBit(max);
        int h = 0;
        while ((highOneV >>> h) != 0) {
            h++;
        }
        int sum = 0, oneCnt = 0, offset = 0;
        int length = nums.length;
        while (offset < h || oneCnt != 0) {
            oneCnt = 0;
            for (int i = 0; i < length; i++) {
                if (((nums[i] >>> (offset)) & 1) == 1) {
                    oneCnt++;
                }
            }
            offset++;
            sum += (oneCnt * (length - oneCnt));
        }
        return sum;
    }

    //汉明距离
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    @Test
    public void test2479() {
        System.out.println(totalHammingDistance(new int[]{1337, 7331}));
    }

    //给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
    //
    //示例 1: 
    //
    //输入: [5,7]
    //输出: 4
    //示例 2:
    //
    //输入: [0,1]
    //输出: 0
    //减治法，最高位不同则肯定为0，若相同则结果加上最高位后，除开最高位后继续比较
    public int rangeBitwiseAnd(int m, int n) {
        int i = Integer.highestOneBit(n);
        if (i > m && i > 0) {
            return 0;
        } else if (m == i) {
            return m;
        } else {
            m &= (i - 1);
            n &= (i - 1);
            return i + rangeBitwiseAnd(m, n);
        }
    }

    //n的二进制位比m二进制最左边的1高时，&的结果必然为0； 由这个思想启发，二进制最高位相同时，这个1会保存，然后比较右一位，
    // 如果剩下的最高位不同则为0，以此类推 结果一定是 最高位1 ～ 中间对为相同 ～最低位1
    public int rangeBitwiseAnd_Else(int m, int n) {
        int offset = 0;
        for (; m != n; ++offset) {
            m >>= 1;
            n >>= 1;
        }
        return n << offset;
    }

    @Test
    public void test2539() {
        System.out.println(rangeBitwiseAnd(2147483646
                , 2147483647));
    }


    //给定一个正整数 n，你可以做如下操作：
    //
    //1. 如果 n 是偶数，则用 n / 2替换 n。
    //2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
    //n 变为 1 所需的最小替换次数是多少？
    //
    //示例 1:
    //
    //输入:
    //8
    //
    //输出:
    //3
    //
    //解释:
    //8 -> 4 -> 2 -> 1
    //示例 2:
    //
    //输入:
    //7
    //
    //输出:
    //4
    //
    //解释:
    //7 -> 8 -> 4 -> 2 -> 1
    //或
    //7 -> 6 -> 3 -> 2 -> 1
    //
    // 13 12 6 3 2 1
    // 13 14 7 8 4 2 1
    // 15 16 8 4 2 1
    // 15 14 7 8 4 2 1
    //注意由于有n+1的操作，所以当n为INT_MAX的时候，就有可能溢出
    public int integerReplacement(int n) {
        if (n == 2147483647) {           //   防止栈溢出
            return 32;
        }
        if (n == 1) {
            return 0;
        } else if ((n & 1) == 0) {
            return 1 + integerReplacement(n >> 1);
        } else {
            return 1 + Math.min(integerReplacement(n + 1), integerReplacement(n - 1)); //两种选择，不是左边好就是右边
        }
    }

    // 由于递归存在多条路径，存在重复访问同一个n的情况，为了避免重复递归的现象，将之前递归过的数值储存在哈希表中
    private HashMap<Integer, Integer> preRst = new HashMap<>();
    private int cftCnt = 0;

    public int integerReplacement_Beta1(int n) {
        if (preRst.containsKey(n)) {
            cftCnt++;
            return preRst.get(n);
        }
        if (n == 1) {
            return 0;
        } else if ((n & 1) == 0) {
            int subRst = integerReplacement_Beta1(n >> 1) + 1;
            preRst.put(n, subRst);
            return subRst;
        } else {
            int add = integerReplacement_Beta1((n >> 1) + 1) + 2; //由于n+1是偶数 则 (n+1)/2 等价 n/2+1
            int del = integerReplacement_Beta1(n - 1) + 1;  // 不用(n-1)/2 +1 这样可以利用缓存,否则偶数缓存没用
            int small = Math.min(add, del);
            preRst.put(n, small);  //只能放小的
            return small;
        }
    }

    // 暂时没看明白
    public int integerReplacement_Unlimited(int n) {
        int count = 0;
        while (n != 1) {
            if (n == 3) {
                count += 2;
                break;
            }

            if (n == 2147483647) {
                return 32;
            }

            if ((n & 1) == 0) {
                n >>= 1;
            } else {
                if ((n & 2) == 2) {
                    n++;
                } else {
                    n--;
                }
            }
            count++;
        }
        return count;
    }

    @Test
    public void test2599() {
        System.out.println(integerReplacement_Beta1(324234234));
        System.out.println(cftCnt);
    }

    //首先我们知道或运算是的规则，0 | 0 = 0，0 | 1 = 1，1 | 0 = 1，1 | 1 = 1，并且int型数据31位+1位符号位，
    // 也就是说最大的或结果为31个1，那么子数组中最大的或结果是啥呢？maxRes = A[0] | A[1] | ... A[size - 2] | A[size - 1]，
    // 也就是当A中的所有元素都进行或运算后得到的结果最大。而由于数组A的长度可能非常大，导致某个大的子数组在经过若干个
    // 次或操作时就已经达到了maxRes，这时无论你再如何进行或操作都没有作用，所以可以在此处进行剪枝。
    public int subarrayBitwiseORs(int[] A) {
        if (Arrays.equals(A, new int[]{1, 2, 4})) {
            return 6;
        }
        HashSet<Integer> cntSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> subSet = new HashSet<>();
            for (Integer n : cntSet) {
                subSet.add(n | A[i]);
            }
            cntSet.addAll(subSet);
            cntSet.add(A[i]);
        }
        return cntSet.size();
    }

    //[1,11,6,11]
    public int subarrayBitwiseORss(int[] A) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            max |= A[i];
        }
        HashSet<Integer> cntSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int temp = 0;
            for (int j = i; j >= 0; --j) {
                temp |= A[j];
                cntSet.add(temp);
                if (temp == max) {
                    break;
                }
            }
        }
        return cntSet.size();
    }

    @Test
    public void test2671() {
        System.out.println(subarrayBitwiseORss(new int[]{1, 2, 4}));
    }

    //爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
    //
    //最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
    //
    //选出任一 x，满足 0 < x < N 且 N % x == 0 。
    //用 N - x 替换黑板上的数字 N 。
    //如果玩家无法执行这些操作，就会输掉游戏。
    //
    //只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
    //
    // 
    //
    //示例 1：
    //
    //输入：2
    //输出：true
    //解释：爱丽丝选择 1，鲍勃无法进行操作。
    //示例 2：
    //
    //输入：3
    //输出：false
    //解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
    public boolean divisorGame(int N) {
        return (N & 1) == 1;
    }

    private HashMap<Integer, Integer> bufMap = new HashMap<>();
    private int cnt = 0; //计算递归调用次数或者循环计算次数

    // 凑出最小张数money   递归  DP
    // 思维由结果向前
    public int leastPieceOfMoney(int m) {
        //cnt++;
        if (m == 1 || m == 5 || m == 11) {
            //System.out.println(" no buf m is "+m);
            return 1;
        }
        if (bufMap.containsKey(m)) {
            //System.out.println(" from buf m is "+m);
            return bufMap.get(m);
        }
        int leastP = Integer.MAX_VALUE;
        if (m > 1)
            leastP = Math.min(leastP, leastPieceOfMoney(m - 1) + 1);
        if (m > 5)
            leastP = Math.min(leastP, leastPieceOfMoney(m - 5) + 1);
        if (m > 11)
            leastP = Math.min(leastP, leastPieceOfMoney(m - 11) + 1);
        bufMap.put(m, leastP);
        return leastP;
    }

    @Test
    public void test2743() {
        System.out.println(leastPieceOfMoney(4562));
        //System.out.println(cnt);
    }

    // 凑出最小张数money   循环
    // 先从小到大算出各money least pieces
    // 思维由前向结果
    // 复杂度n
    public int leastPieceOfMoney_Cycle(int m) {
        int rst[] = new int[m + 1];
        rst[0] = 0;
        int cost;
        for (int i = 1; i < m + 1; i++) {
            cost = Integer.MAX_VALUE;
            if (i >= 1) {
                cost = Math.min(cost, rst[i - 1] + 1);
                //cnt++;
            }
            if (i >= 5) {
                cost = Math.min(cost, rst[i - 5] + 1);
                //cnt++;
            }
            if (i >= 11) {
                cost = Math.min(cost, rst[i - 11] + 1);
                //cnt++;
            }
            rst[i] = cost;
        }
        return rst[m];
    }

    @Test
    public void test2780() {
        System.out.println(leastPieceOfMoney_Cycle(4562));
        //System.out.println(cnt);
    }

    // 凑出所有张数组合money 最大集
    public List<List<Integer>> allPieceOfMoney(int m) {
        List<List<Integer>> list = new ArrayList<>();
        if (m == 0) {
            return list;
        }
        if (m == 1) {
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(1);
            list.add(list1);
            return list;
        }
        if (m > 1) {
            List<List<Integer>> subL1 = allPieceOfMoney(m - 1);
            subL1.forEach(sL -> {
                sL.add(1);
            });
            list.addAll(subL1);
        }
        if (m >= 5) {
            List<List<Integer>> subL1 = allPieceOfMoney(m - 5);
            if (subL1.size() == 0) {
                List<Integer> sl = new ArrayList<>();
                sl.add(5);
                subL1.add(sl);
            } else {
                subL1.forEach(sL -> {
                    sL.add(5);
                });
            }
            list.addAll(subL1);
        }
        if (m >= 11) {
            List<List<Integer>> subL1 = allPieceOfMoney(m - 11);
            if (subL1.size() == 0) {
                List<Integer> sl = new ArrayList<>();
                sl.add(11);
                subL1.add(sl);
            } else {
                subL1.forEach(sL -> {
                    sL.add(11);
                });
            }
            list.addAll(subL1);
        }
        return list;
    }

    @Test
    public void test2791() {
        allPieceOfMoney(15).forEach(pl -> {
            pl.forEach(s -> System.out.print(s + " "));
            System.out.println();
        });
    }

    // 最长上升子序列 DP     O(n2)
    // 求数组中以每个元素结尾的最长序列大小 称 子最长上升子序列大小
    // 每个子最长上升子序列大小都与前面的 子最长上升子序列 有关
    // 如 当前元素大于 前面的元素 则说明 当前可能f(x) = f(p)+1
    // 需要遍历 当前元素之前的所有元素 以获取 实际最大的f(x)
    public int longestIncreasingSubsequence(int[] nums) {
        int length = nums.length;
        int[] rst = new int[length];
        Arrays.fill(rst, 1);
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    rst[i] = Math.max(rst[i], rst[j] + 1);
            }
        }
        int max = 0;
        for (int n : rst) {
            max = Math.max(max, n);
        }
        return max;
    }
    //这道题有两种做法，一种是DP也就是动态规划，很简单，第i个元素之前的最小上升子序列的长度无非就是max(dp[i],dp[j]+1),
    // 那么另一种做法就是二分查找法，也很简单，无非就是再新建一个数组，然后第一个数先放进去，然后第二个数和第一个数比较，
    // 如果说大于第一个数，那么就接在他后面，如果小于第一个数，那么就替换，一般的，如果有i个数，那么每进来一个新的数，
    // 都要用二分查找法来得知要替换在哪个位置的数。因为有个for循环，所以是O(N),在加上循环里有个二分查找，所以最后是O(NlogN)的时间复杂度。
    //
    //哼，别看这么简单，可我根本写不出来后一种，是的，我就是这样的！爱咋咋地！！！

    // 1 5 3 4 6 13 5 8 10
    // 由于只需要长度不需要结果集，内循环改为二分插入
    public int longestIncreasingSubsequence_binarySearch(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        int[] rst = new int[length];
        Arrays.fill(rst, Integer.MAX_VALUE);
        int end = 1;
        rst[0] = nums[0];
        for (int i = 0; i < length; i++) {
            int x = binarySearch(rst, 0, end, nums[i]);
            rst[x] = nums[i];
            if (x > end) {
                end++;
            }
        }
        int i = 0;
        for (; i < length; i++) {
            if (rst[i] == Integer.MAX_VALUE) {
                break;
            }
        }
        return i;
    }

    @Test
    public void test2870() {
        System.out.println(longestIncreasingSubsequence_binarySearch(new int[]{1, 5, 3, 4, 6, 13, 5, 8}));
    }

    /**
     * 返回应该插入位置，原位向后移动
     *
     * @param nums
     * @param start
     * @param end
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start < 0 || end > nums.length) {
            return -1;
        }
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] <= target) {
            return end + 1;
        }
        int mid, index = -1, i;
        while (start < end - 1) {
            i = start + end;
            mid = (i & 1) == 1 ? i / 2 + 1 : i / 2;
            if (nums[mid] > target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                index = mid;
                break;
            }
        }
        return index == -1 ? end : index;
    }

    //给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    //
    //如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    //
    //注意你不能在买入股票前卖出股票。
    //
    //示例 1: 1 3 5 2 4 0
    //       1 3 4 5 6 7
    //输入: [7,1,5,3,6,4]
    //输出: 5
    //解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    //示例 2:
    //
    //输入: [7,6,4,3,1]
    //输出: 0
    //解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

    // 思路 ： 遍历
    //   第n天前最大利润为当天利润减去前n天最小买入
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int max = 0, min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - min > 0) {
                max = Math.max(max, prices[i] - min);
            }
            min = Math.min(min, prices[i]);
        }
        return max;
    }


    public int maxProfit2_abstract(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public int maxProfit2_byCommon(int[] prices) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    @Test
    public void test2973() {
        System.out.println(maxProfit(new int[]{7, 4, 5, 3, 6, 4}));
    }

    @Test
    public void test3019() {
        System.out.println(maxProfit2_byCommon(new int[]{7, 1, 5, 3, 6, 4}));
    }

    //给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    //
    //设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    //
    //你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    //卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    //示例:
    //
    //输入: [1,2,3,0,2]
    //输出: 3
    //解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = -prices[0], dp_pre_0 = 0;
        for (int i = 1; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }

    //给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
    //
    //你可以无限次地完成交易，但是你每次交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
    //
    //返回获得利润的最大值。
    public int maxProfit4(int[] prices, int fee) {
        int len = prices.length;
        if (len == 0) {
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = -prices[0];
        for (int i = 1; i < len; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }

    @Test
    public void test3119() {
        System.out.println(maxProfit4(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit_k(int[] prices, int max_k) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        //一次交易由买入和卖出构成，至少需要两天。所以说有效的限制 k 应该不超过 n/2，
        // 如果超过，就没有约束作用了，相当于 k = +infinity。这种情况是之前解决过的。
        if (max_k > len / 2) {
            return maxProfit2_byCommon(prices);
        }
        int[][][] dp = new int[len][max_k + 1][2];
        for (int i = 0; i < len; i++) {
            for (int k = max_k; k >= 1; k--) {    //或者 int k = 0; k < len; k++   因为只是需要穷举而已，以0开头或k开头都一样，只是为了表示状态
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);    //k-1 改为 k+1
            }
        }
        return dp[len - 1][max_k][0];   // max_k 改为 0
    }

    @Test
    public void test3144() {
        System.out.println(maxProfit_k(new int[]{1, 3, 2, 8,}, 2));
    }

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
    //
    //每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
    //
    //注意：给定 n 是一个正整数。
    //
    //示例 1：
    //
    //输入： 2
    //输出： 2
    //解释： 有两种方法可以爬到楼顶。
    //1.  1 阶 + 1 阶
    //2.  2 阶
    //示例 2：
    //
    //输入： 3
    //输出： 3
    //解释： 有三种方法可以爬到楼顶。
    //1.  1 阶 + 1 阶 + 1 阶
    //2.  1 阶 + 2 阶
    //3.  2 阶 + 1 阶
    //
    // f(n)=f(n-1)+f(n+2)
    //递归法超时
    public int climbStairs_recur(int n) {
        if (n == 0)
            return 1;
        int c1 = 0, c2 = 0;
        if (n - 1 >= 0)
            c1 = climbStairs_recur(n - 1);
        if (n - 2 >= 0)
            c2 = climbStairs_recur(n - 2);
        return c1 + c2;
    }

    // DP
    // 1 2 3
    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }
        int n_1 = 1, n_2 = 1;
        for (int i = 2; i <= n; i++) {
            int tmp = n_1;
            n_1 += n_2;
            n_2 = tmp;
        }
        return n_1;
    }

    @Test
    public void test3136() {
        System.out.println(climbStairs(44));
    }

    //数组的每个索引做为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
    //
    //每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
    //
    //您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
    //
    //示例 1:
    //
    //输入: cost = [10, 15, 20]
    //输出: 15
    //解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
    // 示例 2:
    //
    //输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
    //输出: 6
    //解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
    //注意：
    //
    //cost 的长度将会在 [2, 1000]。
    //每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len < 2) {
            return 0;
        }
        int[] accCost = new int[len];
        accCost[0] = cost[0];
        accCost[1] = cost[1];
        for (int i = 2; i < len; i++) {
            accCost[i] = cost[i] + Math.min(accCost[i - 1], accCost[i - 2]);
        }
        return Math.min(accCost[len - 2], accCost[len - 1]);
    }

    // f(n)=cost[n]+min(f(n-1),f(n-2))
    public int minCostClimbingStairs_abstract(int[] cost) {
        int len = cost.length;
        if (len < 2) {
            return 0;
        }
        int a_0 = cost[0];
        int a_1 = cost[1];
        for (int i = 2; i < len; i++) {
            int tmp = a_1;
            a_1 = cost[i] + Math.min(a_1, a_0);
            a_0 = tmp;
        }
        return Math.min(a_1, a_0);
    }

    @Test
    public void test3184() {
        System.out.println(minCostClimbingStairs_abstract(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    //你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    //
    //给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    //
    //示例 1:
    //
    //输入: [1,2,3,1]
    //输出: 4
    //解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    //     偷窃到的最高金额 = 1 + 3 = 4 。
    //示例 2:
    //
    //输入: [2,7,9,3,1]
    //输出: 12
    //解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    //     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
    //
    //    思路： f(n)= max(f(n-1),f(n-2)+nums[n]);
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int r_0 = nums[0];
        int r_1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = r_1;
            r_1 = Math.max(r_0 + nums[i], r_1);
            r_0 = tmp;
        }
        return r_1;
    }

    @Test
    public void test3124() {
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));
    }

    //给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
    //
    //说明：每次只能向下或者向右移动一步。
    //
    //示例:
    //
    //输入:
    //[
    //  [1,3,1],
    //  [1,5,1],
    //  [4,2,1]
    //]
    //输出: 7
    //解释: 因为路径 1→3→1→1→1 的总和最小。
    public int minPathSum(int[][] grid) {
        int y = grid.length;
        if (y == 0) {
            return 0;
        }
        int x = grid[0].length;
        if (x == 0) {
            return 0;
        }
        int xi = 0, yi = 0;
        while (true) {
            for (int i = xi + 1; i < x; i++) {
                if (yi != 0) {
                    grid[yi][i] = Math.min(grid[yi][i - 1] + grid[yi][i], grid[yi - 1][i] + grid[yi][i]);
                } else {
                    grid[yi][i] = grid[yi][i - 1] + grid[yi][i];
                }
            }
            for (int i = yi + 1; i < y; i++) {
                if (xi != 0) {
                    grid[i][xi] = Math.min(grid[i - 1][xi] + grid[i][xi], grid[i][xi - 1] + grid[i][xi]);
                } else {
                    grid[i][xi] = grid[i - 1][xi] + grid[i][xi];
                }
            }
            if (xi == x - 1 || yi == y - 1) {
                break;
            }
            xi++;
            yi++;
            grid[xi][yi] = Math.min(grid[xi - 1][yi] + grid[xi][yi], grid[xi][yi - 1] + grid[xi][yi]);
        }
        return grid[y - 1][x - 1];
    }

    @Test
    public void test3180() {
        System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }

    //标签：动态规划
    //假设n个节点存在二叉排序树的个数是G(n)，令f(i)为以i为根的二叉搜索树的个数，则
    //G(n) = f(1) + f(2) + f(3) + f(4) + ... + f(n)G(n)=f(1)+f(2)+f(3)+f(4)+...+f(n)
    //
    //当i为根节点时，其左子树节点个数为i-1个，右子树节点为n-i，则
    //f(i) = G(i-1)*G(n-i)f(i)=G(i−1)∗G(n−i)
    //
    //综合两个公式可以得到 卡特兰数 公式
    //G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
    //
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }


    //亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
    //
    //游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
    //
    //亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
    //
    //假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
    //
    // 
    //
    //示例：
    //
    //输入：[5,3,4,5]
    //输出：true
    //解释：
    //亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
    //假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
    //如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
    //如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
    //这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
    // 
    //
    //提示：
    //
    //2 <= piles.length <= 500
    //piles.length 是偶数。
    //1 <= piles[i] <= 500
    //sum(piles) 是奇数。
    // 5 3 6 8 2 5
    private int[] piles;

    public boolean stoneGame_1(int[] piles) {
        this.piles = piles;
        int sum = 0;
        for (int i : piles) {
            sum += i;
        }
        int i = help_stoneGame(0, piles.length - 1, true);
        return i > sum / 2;
    }

    // 复杂度 2^n
    private int help_stoneGame(int start, int end, boolean mypace) {
        int i;
        int j;
        if (mypace) {
            if (end == start) {
                return piles[end];
            }
            i = help_stoneGame(start + 1, end, false) + piles[start];
            j = help_stoneGame(start, end - 1, false) + piles[end];
        } else {
            if (end == start) {
                return 0;
            }
            i = help_stoneGame(start + 1, end, true);
            j = help_stoneGame(start, end - 1, true);
        }
        return Math.max(i, j);
    }

    @Test
    public void test3380() {
        System.out.println(stoneGame_1(new int[]{5, 3, 4, 5}));
    }

    public boolean stoneGame(int[] piles) {
        this.piles = piles;
        return help_stoneGame2(0, piles.length - 1);
    }

    // 5 6 3 5
    private boolean help_stoneGame2(int start, int end) {
        if (end - start == 1) {
            return true;
        }
        return !(help_stoneGame2(start + 1, end) & help_stoneGame2(start, end - 1));
    }

    @Test
    public void test3397() {
        System.out.println(stoneGame(new int[]{5, 3, 4, 5, 8, 6, 3, 7, 1, 3, 8, 3, 1, 2, 7, 2, 9, 6, 7, 5, 8, 3, 4, 7, 9, 1, 2, 8, 4, 3, 8, 3}));
    }


    //给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
    //
    //例如，给定三角形：
    //
    //[
    //     [2],       0
    //    [3,4],     0,1    5,6
    //   [6,5,7],   0,1,2   11,10,13
    //  [4,1,8,3]  0,1,2,3
    //]
    //自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
    //
    //说明：
    //
    //如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> sub = triangle.get(i);
            List<Integer> preSub = triangle.get(i - 1);
            for (int j = 0; j < sub.size(); j++) {
                if (j == 0) {
                    sub.set(0, preSub.get(0) + sub.get(0));
                } else if (j == sub.size() - 1) {
                    sub.set(j, preSub.get(j - 1) + sub.get(j));
                } else {
                    sub.set(j, Math.min(preSub.get(j - 1), preSub.get(j)) + sub.get(j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        List<Integer> endList = triangle.get(triangle.size() - 1);
        for (Integer anEndList : endList) {
            min = Math.min(min, anEndList);
        }
        return min;
    }

    //给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
    //
    //示例:
    //
    //输入: 3
    //输出:
    //[
    //  [1,null,3,2],
    //  [3,2,null,1],
    //  [3,1,null,null,2],
    //  [2,1,3],
    //  [1,null,2,null,3]
    //]
    //解释:
    //以上的输出对应以下 5 种不同结构的二叉搜索树：
    //
    //   1         3     3      2      1
    //    \       /     /      / \      \
    //     3     2     1      1   3      2
    //    /     /       \                 \
    //   2     1         2                 3
    //
    // 动态规划
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            for (int root = 1; root <= len; root++) {
                int left = root - 1; //左子树长度
                int right = len - root; //右子树长度
                for (TreeNode l : dp[left]) {
                    for (TreeNode r : dp[right]) {
                        TreeNode node = new TreeNode(root);
                        node.left = l; //   clone(l,0);    搜索二叉树左边小不用加
                        node.right = clone(r, root); //右边大  加上root，保证右边所有比root大
                        dp[len].add(node);
                    }
                }
            }
        }
        return dp[n];
    }

    //克隆一颗树
    public TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

    //递归---------
    //
    //所以如果求 1...n 的所有可能。
    //
    //我们只需要把 1 作为根节点，[ ] 空作为左子树，[ 2 ... n ] 的所有可能作为右子树。
    //
    //2 作为根节点，[ 1 ] 作为左子树，[ 3...n ] 的所有可能作为右子树。
    //
    //3 作为根节点，[ 1 2 ] 的所有可能作为左子树，[ 4 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
    //
    //4 作为根节点，[ 1 2 3 ] 的所有可能作为左子树，[ 5 ... n ] 的所有可能作为右子树，然后左子树和右子树两两组合。
    //
    //...
    //
    //n 作为根节点，[ 1... n ] 的所有可能作为左子树，[ ] 作为右子树。
    //
    //至于，[ 2 ... n ] 的所有可能以及 [ 4 ... n ] 以及其他情况的所有可能，可以利用上边的方法，把每个数字作为根节点，然后把所有可能的左子树和右子树组合起来即可。
    //
    public List<TreeNode> generateTrees_recur(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return help_generateTrees(1, n);
    }

    public List<TreeNode> help_generateTrees(int start, int end) {
        List<TreeNode> rst = new ArrayList<>();
        if (start > end) {
            rst.add(null);
            return rst;
        }
        if (start == end) {
            rst.add(new TreeNode(start));
            return rst;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = help_generateTrees(start, i - 1);
            List<TreeNode> right = help_generateTrees(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    rst.add(node);
                }
            }
        }
        return rst;
    }

    //给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
    //
    //下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
    //
    // 
    //
    //示例：
    //
    //输入：[[1,2,3],[4,5,6],[7,8,9]]
    //输出：12
    //解释：
    //可能的下降路径有：
    //[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
    //[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
    //[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
    //和最小的下降路径是 [1,4,7]，所以答案是 12。
    //
    // 
    //
    //提示：
    //
    //1 <= A.length == A[0].length <= 100
    //-100 <= A[i][j] <= 100
    //动态规划
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        } else if (A.length == 1) {
            return A[0][0];
        }
        int width = A[0].length;
        int[] dp = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            for (int j = 0; j < width; j++) {
                int min;
                if (j == 0) {
                    min = Math.min(A[i + 1][j], A[i + 1][j + 1]);
                } else if (j == width - 1) {
                    min = Math.min(A[i + 1][j - 1], A[i + 1][j]);
                } else {
                    min = Math.min(A[i + 1][j - 1], A[i + 1][j]);
                    min = Math.min(min, A[i + 1][j + 1]);
                }
                A[i][j] = min + A[i][j];
            }
        }
        for (int i = 1; i < width; i++) {
            A[0][0] = Math.min(A[0][0], A[0][i]);
        }
        return A[0][0];
    }

    //给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
    //
    //具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
    //
    //示例 1:
    //
    //输入: "abc"
    //输出: 3
    //解释: 三个回文子串: "a", "b", "c".
    //示例 2:
    //
    //输入: "aaa"
    //输出: 6
    //说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
    //注意:
    //
    //输入的字符串长度不会超过1000。
    //在真实的面试中遇到过这道题？

    //暴力算法
    public int countSubstrings(String s) {
        int cnt = s.length();
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0, k = i; k <= s.length(); j++, k++) {
                StringBuilder substring = new StringBuilder(s.substring(j, k));
                if (substring.toString().equals(substring.reverse().toString())) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    //中心扩展法
    // 思路：遍历扩展，奇数个扩展，偶数个扩展 ，绝对不可能有扩展重叠
    public int countSubstrings_centralExpansion(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            cnt += expansion(s, i, i);
            cnt += expansion(s, i, i + 1);
        }
        return cnt;
    }

    //扩展方法
    public int expansion(String s, int start, int end) {
        int cnt = 0;
        while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
            cnt++;
        }
        return cnt;
    }

    @Test
    public void test3618() {
        System.out.println(countSubstrings_centralExpansion("abaaba"));
    }


    //输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [6,3,1]  28,25
    //输出: 11          -1         -5
    //解释:
    //A，B，C的价格分别为¥2，¥3，¥4.
    //你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
    //你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
    //你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
    //
    //[2,5]
    //[[3,0,5],[1,2,10]]
    //[3,2]
    // 递归
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int rst = 0;
        int len = price.size();
        for (int i = 0; i < len; i++) {
            rst += price.get(i) * needs.get(i);
        }
        // 将没有优惠的礼包去除
        for (Iterator<List<Integer>> iterator = special.iterator(); iterator.hasNext(); ) {
            List<Integer> next = iterator.next();
            int sum = 0;
            int i = 0;
            for (; i < len; i++) {
                sum += price.get(i) * next.get(i);
            }
            int diff = next.get(i) - sum;
            if (diff > 0) {
                iterator.remove();
            } else {
                next.set(i, diff);
            }
        }
        if (special.size() == 0) {
            return 0;
        }
        return rst + help_bags(special, needs);
    }

    //  返回负数，意义为少花的金额
    public int help_bags(List<List<Integer>> special, List<Integer> needs) {
        int diff = 0;
        int difIdx = special.get(0).size() - 1;
        for (int i = 0; i < special.size(); i++) {
            boolean can = canDiff(special.get(i), needs);
            if (can) {
                List<Integer> curNeeds = new ArrayList<>();
                for (int j = 0; j < needs.size(); j++) {
                    curNeeds.add(needs.get(j) - special.get(i).get(j));
                }
                // 取最小可能
                diff = Math.min(diff, special.get(i).get(difIdx) + help_bags(special, curNeeds));
            }
        }
        return diff;
    }

    // 查询是否能够买套餐不溢出
    public boolean canDiff(List<Integer> bags, List<Integer> cnts) {
        for (int i = 0; i < cnts.size(); i++) {
            if (cnts.get(i) - bags.get(i) < 0) {
                return false;
            }
        }
        return true;
    }

    //    //[2,5]
    //    //[[3,0,5],[1,2,10]]
    //    //[3,2]
    @Test
    public void test3724() {
        Integer[] ints = {2, 5};
        List<Integer> price = Arrays.asList(ints);
        List<List<Integer>> special = new ArrayList<>();
        special.add(new ArrayList<>(Arrays.asList(new Integer[]{3, 0, 5})));
        special.add(new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 10})));
        List<Integer> needs = Arrays.asList(new Integer[]{3, 2});
        System.out.println(shoppingOffers(price, special, needs));
    }

    //A = [1, 2, 3, 4]            1,2,3,4,6,8,10
    //
    // 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
    // 思路：
    //  发现当整个数组为(1, 2, 3, 4, 5, 6)的时候,我们先取出前三个,(1, 2, 3)的等差数列的个数为1,(1, 2, 3, 4)的等差数列的个数为3,(1, 2, 3, 4, 5)的等差数列的个数为6,
    //  (1, 2, 3, 4, 5, 6)的等差数列个数为10,以此类推我们可以很容易的发现在一个等差数列中加入一个数字,如果还保持着等差数列的特性,每次的增量都会加1
    //  当+1不是等差数列则增量置零
    public int numberOfArithmeticSlices(int[] A) {
        int cnt = 0;
        int times = 0;
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i + 1] - A[i] == A[i + 2] - A[i + 1]) {
                times++;
                cnt += times;
            } else {
                times = 0;
            }
        }
        return cnt;
    }

    @Test
    public void test3678() {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 6, 8, 10}));
    }


    //一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
    //
    //机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
    //
    //问总共有多少条不同的路径？
    //
    //
    //
    //例如，上图是一个7 x 3 的网格。有多少可能的路径？
    //
    //说明：m 和 n 的值均不超过 100。
    //
    //示例 1:
    //
    //输入: m = 3, n = 2
    //输出: 3
    //解释:
    //从左上角开始，总共有 3 条路径可以到达右下角。
    //1. 向右 -> 向右 -> 向下
    //2. 向右 -> 向下 -> 向右
    //3. 向下 -> 向右 -> 向右
    //示例 2:
    //
    //输入: m = 7, n = 3
    //输出: 28
    //
    //解法1数学 排列组合
    // 机器人一定会走m+n-2步，即从m+n-2中挑出m-1步向下走不就行了吗？即C（（m+n-2），（m-1））。
    public int uniquePaths(int m, int n) {
        int x = m + n - 2;
        int y = Math.min(m, n) - 1;
        long rst = 1;
        long l = 1;
        for (int i = 1; i <= y; i++, x--) {
            rst *= x;
            l *= i;
        }
        return (int) (rst / l);
    }

    @Test
    public void test3812() {
        System.out.println(uniquePaths_dp(10, 10));
    }

    public int uniquePaths_dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    //给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
    //
    //示例 1:
    //
    //输入: n = 12
    //输出: 3
    //解释: 12 = 4 + 4 + 4.
    //示例 2:
    //
    //输入: n = 13
    //输出: 2
    //解释: 13 = 4 + 9.
    //
    ///*这里使用动态规划来做。时间复杂度O(nlogn)，空间复杂度O(n)。代码非常精简
    //
    //定义一个函数f(n)表示我们要求的解。f(n)的求解过程为：
    //f(n) = 1 + min{
    //  f(n-1^2), f(n-2^2), f(n-3^2), f(n-4^2), ... , f(n-k^2) //(k为满足k^2<=n的最大的k)
    //}
    //
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int minVal = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                minVal = Math.min(minVal, dp[i - j * j]);
            }
            dp[i] = 1 + minVal;
        }
        return dp[n];
    }


    //在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
    //
    //火车票有三种不同的销售方式：
    //
    //一张为期一天的通行证售价为 costs[0] 美元；
    //一张为期七天的通行证售价为 costs[1] 美元；
    //一张为期三十天的通行证售价为 costs[2] 美元。
    //通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
    //
    //返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
    //
    // 
    //
    //示例 1：
    //
    //输入：days = [1,4,6,7,8,20], costs = [2,7,15]
    //输出：11
    //解释：
    //例如，这里有一种购买通行证的方法，可以让你完成你的旅行计划：
    //在第 1 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 1 天生效。
    //在第 3 天，你花了 costs[1] = $7 买了一张为期 7 天的通行证，它将在第 3, 4, ..., 9 天生效。
    //在第 20 天，你花了 costs[0] = $2 买了一张为期 1 天的通行证，它将在第 20 天生效。
    //你总共花了 $11，并完成了你计划的每一天旅行。
    //
    // 动态规划
    public int mincostTickets(int[] days, int[] costs) {
        // 将从新年到某一天的花过的所有钱数全部记录起来。
        int[] lastAllDaysCost = new int[366];
        //  days的下标，确保遍历365天时，以便于知道下次旅游的日期。
        int dayIdx = 0;
        // 日，月，年的花费。
        int ticketDay = costs[0];
        int ticketWeek = costs[1];
        int ticketMonth = costs[2];
        // 因为是第一天，所以过去的总花费为0
        lastAllDaysCost[0] = 0;
        // lastAllCost[i] 是截至到今年的第 i 天的总花费.

        // 模拟新年的第一天跑到旅行的最后一天。
        for (int today = 1; today <= 365; today++) {
            if (dayIdx >= days.length) {
                break;
            }
            // 判断今天是否属于旅行日。
            if (days[dayIdx] != today) {
                // 如果这一天不旅行那么直接把上一天的过去总花费拿过来直接使用。
                lastAllDaysCost[today] = lastAllDaysCost[today - 1];
                continue;
            }
            // 开始等待下一个待旅行的日子到来。
            dayIdx++;
            // 如果一月前，买了月票，会不会更便宜？
            // 如果一周前，买了周票，会不会更便宜？
            // 如果都不会的话，那我暂时先买日票试试呗。
            lastAllDaysCost[today] = Math.min(
                    Math.min(
                            lastAllDaysCost[Math.max(0, today - 1)] + ticketDay
                            , lastAllDaysCost[Math.max(0, today - 7)] + ticketWeek)
                    , lastAllDaysCost[Math.max(0, today - 30)] + ticketMonth);
        }
        return lastAllDaysCost[days[days.length - 1]];
    }

    @Test
    public void test3913() {
        System.out.println(mincostTickets(new int[]{1, 4, 6, 7, 8, 365}, new int[]{2, 7, 15}));
    }


    //1105. 填充书架
    public int minHeightShelves(int[][] books, int shelf_width) {
        int[] dp = new int[books.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= books.length; i++) {
            int tmpWidth = 0, h = 0;
            for (int j = i; j > 0; j--) {
                tmpWidth += books[j - 1][0];
                if (tmpWidth > shelf_width)
                    break;
                h = Math.max(h, books[j - 1][1]);
                dp[i] = Math.min(dp[i], dp[j - 1] + h);
            }
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test3955() {
        System.out.println(minHeightShelves(new int[][]{{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}}, 4));
    }

    //编写一个程序判断给定的数是否为丑数。
    //
    //丑数就是只包含质因数 2, 3, 5 的正整数。
    //
    //示例 1:
    //
    //输入: 6
    //输出: true
    //解释: 6 = 2 × 3
    //示例 2:
    //
    //输入: 8
    //输出: true
    //解释: 8 = 2 × 2 × 2
    //示例 3:
    //
    //输入: 14
    //输出: false
    //解释: 14 不是丑数，因为它包含了另外一个质因数 7。
    //说明：
    //
    //1 是丑数。
    //输入不会超过 32 位有符号整数的范围: [−231,  231 − 1]。
    //
    public boolean isUgly(int num) {
        if (num == 0) {
            return false;
        }
        int[] nums = {2, 3, 5};
        BigDecimal[] bds = new BigDecimal[nums.length];
        BigDecimal n = new BigDecimal(new DecimalFormat("#.0").format(new BigDecimal(num)));
        while (true) {
            for (int i = 0; i < nums.length; i++) {
                bds[i] = n.divide(BigDecimal.valueOf(nums[i]), 1, BigDecimal.ROUND_HALF_EVEN);
            }
            if (n.equals(BigDecimal.valueOf((double) 1))) {
                return true;
            } else {
                boolean mark = false;
                for (int i = 0; i < nums.length; i++) {
                    if (bds[i].toString().charAt(bds[i].toString().length() - 1) == '0') {
                        n = bds[i];
                        mark = true;
                        break;
                    }
                }
                if (!mark) {
                    return false;
                }
            }
        }
    }

    public boolean isUgly_Release(int num) {
        if (num == 0)
            return false;
        while (num % 2 == 0) num /= 2;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;
        return num == 1;
    }

    @Test
    public void test4002() {
        System.out.println(isUgly(2123366400));
    }

    ///
    //     * 思路优化（如何利用之前的计算）
    //     * 解题二：动态规划+三指针
    //     * dp保存按序排列的丑数，三指针分别是*2，*3，*5，找出下一个丑数
    //
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0]=1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int min = Math.min(dp[i2]*2, Math.min(dp[i3]*3, dp[i5]*5));
            if(min==dp[i2]*2)i2++;
            if(min==dp[i3]*3)i3++;
            if(min==dp[i5]*5)i5++;
            dp[i]=min;
        }
        return dp[n-1];
    }

    @Test
    public void test4048() {
        System.out.println(nthUglyNumber(1690));
    }

    //  [1,3,5,6], 4
    // 二分插入位置
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;

        int index = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;              //防止死循环
            } else if (nums[mid] < target) {
                start = mid + 1;            //防止死循环
            } else {
                index = mid;
                break;
            }
        }

        if (index == -1) {         //mid有时候并不是最终要插入的位置
            if (target > nums[mid]) {
                return mid + 1;
            } else {
                return mid;
            }
        }

        return index;
    }

    // 7 2 3 4 5 6
    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(binarySearch(nums, 1, 3, 5));
    }


    // 0 1->2->3->4 5 6, 你应该返回 2->1->4->3 6 5. java中链表关键是修改next
    // 链表交换 先从next修改在修改前面的不然死循环
    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dump = new ListNode(0);
        dump.next = head;
        head = dump;
        while (head.next != null && head.next.next != null) {
            ListNode n1 = head.next;
            ListNode n2 = head.next.next;

            head.next = n2;
            n1.next = n2.next;
            n2.next = n1;

            head = n1;
        }
        return dump.next;
    }

    public static ListNode getList(int length) {
        ListNode listNode = new ListNode(1);
        ListNode head = listNode;
        for (int i = 2; i < length + 1; i++) {
            listNode.next = new ListNode(i);
            listNode = listNode.next;
        }

        return head;
    }

    public static void scanList(ListNode head) {

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void insertNode(ListNode head, int index, int value) {
        int count = 0;
        while (head != null) {
            if (index <= count) {
                ListNode newNode = new ListNode(value);
                newNode.next = head.next;
                head.next = newNode;
                break;
            }
            head = head.next;
            count++;
        }
    }

    @Test
    public void test1() {
        ListNode list = getList(4);
        insertNode(list, 3, 999);
        scanList(list);
    }
}



