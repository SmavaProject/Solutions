package problems.medium;

import java.util.HashMap;

public class DesignFileSystem {
    /***
     * #1166. Design File System
     * https://leetcode.com/problems/design-file-system/
     */
    class FileSystem {

        HashMap<String, Integer> map;
        public FileSystem() {
            this.map = new HashMap<>();
        }

        public boolean createPath(String path, int value) {
            if(!this.map.containsKey(path)){
                String[] pathes = path.split("/");
                if(pathes.length>2 && value==1){ //path: "/leet" , pathes: ["","leet"]
                    return false;
                }

                if(value!=1){
                    //check parent exists for all not 1 values
                    StringBuilder sb = new StringBuilder();
                    for(int i = 0; i<= pathes.length-2; i++){
                        sb.append(pathes[i]);
                        if(i!=pathes.length-2) sb.append("/");
                    }
                    if(sb.length() >0 && !map.containsKey(sb.toString()))
                        return false;

                }
                this.map.put(path, value);
                return true;
            }else{
                return false;
            }
        }

        public int get(String path) {
            if(!this.map.containsKey(path)){
                return -1;
            }else{
                return map.get(path);
            }
        }
    }
}
