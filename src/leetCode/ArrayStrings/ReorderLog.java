package leetCode.ArrayStrings;

import java.util.*;

/**
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 */

public class ReorderLog {
    public static void main(String[] args) {
        String[] logs1 = {"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"};
        String[] logs2 = {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        System.out.println(Arrays.toString(reorderLogFile(logs2)));
    }

    private static String[] reorderLogFile(String[] logs) {
        if (logs.length == 0 || logs == null) return logs;

        List<String> strLog = new ArrayList<>();
        List<String> digLog = new ArrayList<>();
        for (String log : logs) {
            int index = log.indexOf(" ");
            char a = log.charAt(index+1);
            if(Character.isLetter(a)) strLog.add(log);
            else digLog.add(log);
        }

        Collections.sort(strLog, new XYZ()); // sorting the stringList using custom sorting logic

        String[] finalArray = new String[logs.length];
        int i = 0;
        for (String l : strLog) finalArray[i++] = l;
        for (String l : digLog) finalArray[i++] = l;

        return finalArray;

    }
}
class XYZ implements Comparator<String>{
    public int compare(String o1, String o2) {
       int space1 = o1.indexOf(" ");
		int space2 = o2.indexOf(" ");

		int val = o1.substring(space1 + 1).compareTo(o2.substring(space2 + 1));
		if(val == 0)
			return o1.substring(0, space1).compareTo(o2.substring(0, space2));
		return val;
    }
}
