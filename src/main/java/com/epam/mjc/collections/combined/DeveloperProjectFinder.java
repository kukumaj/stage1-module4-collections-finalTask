package com.epam.mjc.collections.combined;

import java.util.*;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Set<String>> entry : projects.entrySet()
        ) {
            if (entry.getValue().contains(developer)) {
                list.add(entry.getKey());
            }
        }
        Collections.reverse(list);
        list.sort(new LengthNameComparator());

        return list;
    }
}

class LengthNameComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int size1 = o1.length();
        int size2 = o2.length();
        if (size1 < size2) {
            return 1;
        } else if (size1 > size2) {
            return -1;
        }
        return 0;
    }
}
