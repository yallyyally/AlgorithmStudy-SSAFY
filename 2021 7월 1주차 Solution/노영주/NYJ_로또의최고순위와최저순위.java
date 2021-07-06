import java.util.*;
class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zero=0;
        int[] prize = {6,6,5,4,3,2,1};
        int count=0;

        Arrays.sort(win_nums);

        for(int i=0;i<lottos.length;i++){
            if(lottos[i]==0){
                zero++;
                continue;
            }
            int tmp = Bsearch(win_nums,lottos[i]);
            if(tmp!=-1)
                count++;
        }
        answer[0]=prize[count+zero];
        answer[1]=prize[count];


        return answer;
    }

    static int Bsearch(int[] arr, int target){
        int low=0,high=arr.length-1;
        int mid;

        while(low<=high){
            mid = (low+high)/2;

            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                high=mid-1;
            else 
                low=mid+1;

        }
        return -1;
    }
}