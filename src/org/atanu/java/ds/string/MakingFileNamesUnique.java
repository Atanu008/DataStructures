package org.atanu.java.ds.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/making-file-names-unique/description/
//Leetcode 1487
public class MakingFileNamesUnique {

    public String[] getFolderNames(String[] names) {

        int n = names.length;
        Map<String, Integer> freq = new HashMap<>();
        String[] result = new String[n];
        int index = 0;

        for(String name : names){
            //If it is the first occurance mark its occurance
            if(!freq.containsKey(name)){
                freq.put(name, 1);
                result[index++] = name;
            }else{
                int val = freq.get(name);
                //Check in map by forming next String if possible
                while(freq.containsKey(name +"(" + val +")")){
                    val++;
                }
                String newName = name +"(" + val +")";
                freq.put(newName, 1); // Mark the new String occurances freq as One
                result[index++] = newName;
                freq.put(name,  val + 1); // This tricky so if new name comes which is same then we can accomodate it from next (val + 1) only , as the previuos ones are alreday taken. we can do just 1 , but in that case it would be TLE
            }
        }

        return result;
    }

    public static void main(String[] args) {

        MakingFileNamesUnique makingFileNamesUnique = new MakingFileNamesUnique();
        String[] names = {"gta","gta(1)","gta","avalon"};
        String[] result = makingFileNamesUnique.getFolderNames(names);
        //Explanation: Let's see how the file system creates folder names:
        //"gta" --> not assigned before, remains "gta"
        //"gta(1)" --> not assigned before, remains "gta(1)"
        //"gta" --> the name is reserved, system adds (k), since "gta(1)" is also reserved, systems put k = 2. it becomes "gta(2)"
        //"avalon" --> not assigned before, remains "avalon"
        System.out.println(Arrays.toString(result));
        names = new String[]{"onepiece", "onepiece(1)", "onepiece(2)", "onepiece(3)", "onepiece"};
        result = makingFileNamesUnique.getFolderNames(names);
        System.out.println(Arrays.toString(result));
    }
}
