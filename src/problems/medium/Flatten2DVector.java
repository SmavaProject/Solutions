package problems.medium;

public class Flatten2DVector {
    /***
     * #251. Flatten 2D Vector
     * https://leetcode.com/problems/flatten-2d-vector/
     */

    int firstDimentionIndex;
    int secondDimentionIndex;
    int[][] vec;


    public Flatten2DVector(int[][] vec) {
        this.vec = vec;
        this.firstDimentionIndex = 0;
        this.secondDimentionIndex = 0;
    }

    public int next() {
        //two options to get next:
        //the same 1D and next in 2D
        //next in 1D and 0 in 2D

        //if we reached the end of a current inner vector - move to the next one
        goToTheNextInnerVector();

        //currently two pointers should be on a right place
        //increment ony 2dimention (post increment) after returning the value
        return  vec[firstDimentionIndex][secondDimentionIndex++];
    }

    public void goToTheNextInnerVector(){
        while(firstDimentionIndex<vec.length && secondDimentionIndex == vec[firstDimentionIndex].length){
            secondDimentionIndex = 0;
            firstDimentionIndex++;
        }
    }

    public boolean hasNext() {
        goToTheNextInnerVector();
        return firstDimentionIndex < vec.length;
    }
}
