package org.donnchadh.projecteuler.problems.p0xxx.p00xx.p007x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem79 {
    public static void main(String[] args) {
        int[] successfullAttempts = { 319, 680, 180, 690, 129, 620, 762, 689, 762, 318, 368, 710, 720, 710, 629, 168,
                160, 689, 716, 731, 736, 729, 316, 729, 729, 710, 769, 290, 719, 680, 318, 389, 162, 289, 162, 718,
                729, 319, 790, 680, 890, 362, 319, 760, 316, 729, 380, 319, 728, 716, };
        List<Integer> code = new ArrayList<Integer>();
        code.add(3);
        code.add(1);
        code.add(9);
        Map<Integer,Set<Integer>> pairs = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < 10; i++) {
            pairs.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < successfullAttempts.length; i++) {
            pairs.get(successfullAttempts[i]/100).add((successfullAttempts[i]/10)%10);
            pairs.get(successfullAttempts[i]/100).add(successfullAttempts[i]%10);
            pairs.get((successfullAttempts[i]/10)%10).add(successfullAttempts[i]%10);
        }
        int position = 0;
        while (position <= code.size()) {
            boolean found = false;
            for (int i = 0; i < 10; i++) {
                if ((position == code.size() || pairs.get(i).contains(code.get(position))) && (position == 0 || pairs.get(code.get(position-1)).contains(i))) {
                    code.add(position, i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                position++;
            }
        }
        System.out.println(code);
    }
}
