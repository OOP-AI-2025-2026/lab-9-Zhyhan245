package ua.opnu;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.HashSet;
import java.util.HashMap;

public class Task {
    public static void main(String[] args) {

    }

    public void removeShorterStrings(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            String first = list.get(i);
            String second = list.get(i + 1);

            if (first.length() < second.length()) {
                list.remove(i);
            } else if (first.length() > second.length()) {
                list.remove(i + 1);
            } else {
                list.remove(i);
            }
        }
    }

    public void stutter(List<String> list) {
        for (int i = 0; i < list.size(); i += 2) {
            String s = list.get(i);
            list.add(i + 1, s);
        }
    }

    public void switchPairs(List<String> list) {
        for (int i = 0; i < list.size() - 1; i += 2) {
            String temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
        }
    }

    public void removeDuplicates(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
    }

    public void markLength4(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 4) {
                list.add(i, "****");
                i++;
            }
        }
    }

    public boolean isPalindrome(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            return true;
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            stack.push(num);
            queue.offer(num);
        }

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            int fromStack = stack.pop();
            if (num != fromStack) {
                queue.offer(num);
                for (int j = i + 1; j < size; j++) {
                    queue.offer(queue.poll());
                }
                return false;
            }
            queue.offer(num);
        }

        return true;
    }

    public void reorder(Queue<Integer> q) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int x = q.remove();
                if (x < 0) {
                    stack.push(x);
                } else {
                    q.add(x);
                }
            }

            while (!stack.isEmpty()) {
                q.add(stack.pop());
            }
        }



        public void rearrange(Queue<Integer> queue) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            int num = queue.poll();
            if (num % 2 == 0) {
                queue.offer(num);
            } else {
                stack.push(num);
            }
        }

        int oddCount = stack.size();
        ArrayDeque<Integer> tempStack = new ArrayDeque<>();
        for (int i = 0; i < oddCount; i++) {
            tempStack.push(stack.pop());
        }

        while (!tempStack.isEmpty()) {
            queue.offer(tempStack.pop());
        }
    }

    public int maxLength(Set<String> set) {
        int max = 0;
        for (String s : set) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        return max;
    }

    public void removeEvenLength(Set<String> set) {
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.length() % 2 == 0) {
                it.remove();
            }
        }
    }

    public int numInCommon(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }

    public boolean isUnique(Map<String, String> map) {
        Set<String> seenValues = new HashSet<>();

        for (String value : map.values()) {
            if (!seenValues.add(value)) {
                return false;
            }
        }

        return true;
    }

    public Map<String, Integer> intersect(Map<String, Integer> map1, Map<String, Integer> map2) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if (map2.containsKey(key) && map2.get(key).equals(value)) {
                result.put(key, value);
            }
        }

        return result;
    }

    public Map<String, Integer> reverse(Map<Integer, String> map) {
        Map<String, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();

            result.merge(value, key, Math::max);
        }

        return result;
    }

    public int rarest(Map<String, Integer> map) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (Integer value : map.values()) {
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }

        int rarestValue = Integer.MAX_VALUE;
        int minFreq = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int value = entry.getKey();
            int count = entry.getValue();

            if (count < minFreq || (count == minFreq && value < rarestValue)) {
                minFreq = count;
                rarestValue = value;
            }
        }

        return rarestValue;
    }

    public int maxOccurrences(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int maxCount = 0;

        for (Integer num : list) {
            int count = freq.getOrDefault(num, 0) + 1;
            freq.put(num, count);
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

}

