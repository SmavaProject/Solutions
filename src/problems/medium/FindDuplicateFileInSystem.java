package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateFileInSystem {
    /***
     * #609. Find Duplicate File in System
     * https://leetcode.com/problems/find-duplicate-file-in-system/
     */
    public List<List<String>> findDuplicate(String[] paths) {
        //<content, [path, file name]>
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(String path: paths){
            String[] curr = path.split(" ");//first element - path, every other - file with its content
            for(int i = 1; i< curr.length; i++){
                String[] nameAndContent = curr[i].split("\\(");
                String name = nameAndContent[0];
                String content = nameAndContent[1].substring(0, nameAndContent[1].length()-1); //we dont need the ")"
                ArrayList<String> currOccurencies = map.getOrDefault(content, new ArrayList<>());
                currOccurencies.add(curr[0]+"/"+name);
                map.put(content, currOccurencies);
            }

        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(String content: map.keySet()){
            ArrayList<String> pathsForContent = map.get(content);
            if(pathsForContent.size()>1){
                ArrayList<String> r = new ArrayList<>();
                for(String path: pathsForContent){
                    r.add(path);
                }
                result.add(r);
            }
        }
        return result;
    }
}