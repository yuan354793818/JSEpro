package algorithm;

import org.junit.Test;

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
        buildPermutationV(new Character[]{'+', '-', '*', ' '}, 3).forEach(s -> System.out.println(i.getAndIncrement() + " " + s));
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
        int count=0;
        while (n > 0) {
            count += (n & 1);
            n>>=1;
        }
        return count==1;
    }

    // 减一相与为0
    public boolean isPowerOfTwo_unlimited(int n) {
        return (n>0)&&((((n-1)&n)==0));
    }

    //求最大容量水桶
    //动态规划
    //这里用到了动态规划，基本的表达式: area = min(height[i], height[j]) * (j - i)
    // 使用两个指针，值小的指针向内移动，
    // 这样就减小了搜索空间 因为面积取决于指针的距离与值小的值乘积，如果值大的值向内移动，
    // 距离一定减小，而求面积的另外一个乘数一定小于等于值小的值，因此面积一定减小，
    // 而我们要求最大的面积，因此值大的指针不动，而值小的指针向内移动遍历
    public int maxArea(int[] height) {
        int left=0,right=height.length-1;
        int maxArea=0;
        while (left < right) {
            int lHigh = height[left];
            int rHigh = height[right];
            maxArea=Math.max(maxArea,Math.min(lHigh, rHigh)*(right-left));
            if (lHigh > rHigh){
                right--;
            }else {
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
            for (int j = i+1; j < s.length()+1; j++) {
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
        int colNum=0;
        while (len>0){
            len-=numRows;
            colNum++;
            for (int i = 0; i < numRows-2; i++) {
                if (len<1)
                    break;
                len-=1;
                colNum++;
            }
        }
        char [][] matrix=new char[numRows][colNum];
        int x=0,y=0,cur=0;
        while (cur<s.length()) {
            for (int i = 0; i < numRows; i++) {
                if (cur>s.length()-1)
                    break;
                matrix[x++][y]=s.charAt(cur++);
            }
            x-=2;
            y++;
            for (int i = 0; i < numRows - 2; i++) {
                if (cur>s.length()-1)
                    break;
                matrix[x--][y++]=s.charAt(cur++);
            }
        }

        StringBuilder rst = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < colNum; j++) {
                char c = matrix[i][j];
                if (c !='\0'){
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
                if (bc!=1&&bc % 2 != 0) {
                    for (int j = 3; j <= Math.sqrt(bc); j++) {
                        if (bc % j == 0) {
                            is = false;
                            break;
                        }
                    }
                }else {
                    is=false;
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
                ,10);
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
        int rst=0;
        for (int i : nums) {
            rst^=i;
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
        int a= 0x55555555&i;
        int b=0xAAAAAAAA&i;
        if ((n^a)==0) {
            return true;
        }
        if ((n^b)==0) {
            return true;
        }
        return false;
    }

    public boolean hasAlternatingBits_Plus(int n) {
        int temp=n^(n>>1);
        return (temp&(temp+1))==0;
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

    public List<String> help(String s,int offset){
        if(offset>s.length()-1){
            List<String> l = new ArrayList<>();
            l.add(s);
            return l;
        }
        while (s.charAt(offset)>47&&s.charAt(offset)<58){
            offset++;
            if (offset>s.length()-1){
                List<String> l = new ArrayList<>();
                l.add(s);
                return l;
            }
        }
        char[] chars = s.toCharArray();
        if (chars[offset]>96){
            chars[offset]= (char) (chars[offset]-32);
        }else if (chars[offset]<91){
            chars[offset]= (char) (chars[offset]+32);
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
        int sSum=0,tSum=0;
        for (char c : s.toCharArray()) {
            sSum+=c;
        }
        for (char c : t.toCharArray()) {
            tSum+=c;
        }
        return (char) (tSum-sSum);
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
        int carry=0,sum=0;
        do {
            sum=a^b;
            carry=(a&b)<<1;
            if (carry != 0) {
                a=sum;
                b=carry;
            }
        }while (carry!=0);
       return sum;
    }

    @Test
    public void test1885() {
        System.out.println(getSum(3,36));
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
        int res=nums.length;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
            res^=i;
        }
        return res;
    }

    @Test
    public void test2007() {
        System.out.println(missingNumber(new int[]{0,2,3,4,1,6,7,8}));
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
        int a=0,b=0;
        for (int c : nums) {
            b=b^c&~a;
            a=a^c&~b;
        }
        return b;
    }

    //  [1,3,5,6], 5
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

    @Test
    public void test2() {
        int[] nums = {1, 3, 5, 6, 9};
        System.out.println(searchInsert(nums, 5));
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



