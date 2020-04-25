
/*
I didn't check for condition that if whole array is in decensding order.
I didn't handle condition , if reversePoint is secondLast element.
Special Case : 
if array is in decending order.
*/
public class Solution {
    public int[] nextPermutation(int[] A) {
        int reversePoint = A.length - 1;
        for(int i = A.length - 1; i >= 1 ; i--) {
            if(A[i - 1] < A[i]){
                reversePoint = i - 1 ;
                break; 
            }
        }
        for(int i = reversePoint + 1; i < A.length; i++) {
            if(A[i] < A[reversePoint]) {
                swap(i - 1 , reversePoint, A);
                break;
            }else if(i == A.length - 1){
                swap(i, reversePoint, A); 
                break;
            }
        }
        if(reversePoint != A.length - 1)
            reverseArray(reversePoint + 1, A);
        else
            reverseArray(0, A);
        return A; 
    }
    void reverseArray(int index, int A[]){
        int start = index; 
        int end = A.length - 1;
        while(start <= end) {
            swap(start, end, A); 
            start++;
            end--;
        }
    }
    void swap(int i, int reversePoint, int A[]) {
        int temp = A[i];
        A[i] = A[reversePoint];
        A[reversePoint] = temp;
    }
}
