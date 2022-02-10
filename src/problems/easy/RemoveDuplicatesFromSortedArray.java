package problems.easy;

public class RemoveDuplicatesFromSortedArray {
    /***
     *  #26. Remove Duplicates from Sorted Array - EASY
     *  https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     *  Solution:
     *  https://www.educative.io/courses/grokking-the-coding-interview/mEEA22L5mNA
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        /**
         * Каждый шаг двигается по elementToCheck и проверяет весь массив, а nonDuplicate стоит на том месте где закончились уникальные елементы
         * Если nums[nonDuplicate] == nums[elementToCheck] -то мы вообще ничего не делаем, просто пропускаем все повторные и ждем когда они закончатся
         * Когда повторные закончились - на следующее место после nonDuplicate копируем новый неповторный элемент
         */

        int nonDuplicate = 0;
        for (int elementToCheck = 0; elementToCheck < nums.length; elementToCheck++){
            if(nums[nonDuplicate] != nums[elementToCheck]){
                nonDuplicate++;
                nums[nonDuplicate] = nums[elementToCheck];
            }
        }
        return nonDuplicate+1;
    }

    /**
     * Тоже работает
     */

    public int removeDuplicates1(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sorted = 0;
        int duplicated = 1;
        int totalNumberOfDuplicates = 0;
        while (duplicated < nums.length -totalNumberOfDuplicates){
            if(nums[sorted] == nums[duplicated]){
                while(duplicated < nums.length && nums[sorted] == nums[duplicated]){
                    duplicated++;
                }
                int numberOfDupplicates = duplicated - sorted - 1;
                totalNumberOfDuplicates += numberOfDupplicates;

                int replacementIndex = sorted+1;
                while(duplicated<nums.length){
                    nums[replacementIndex] = nums[duplicated];
                    duplicated++;
                    replacementIndex++;
                }
                //reset suplicated index
                duplicated = sorted + 1;

            }else{
                duplicated++;
                sorted++;
            }

        }
        return sorted + 1;

    }
}
