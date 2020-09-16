package jack.find;

public class BinaryFind {
    public static int GetNumberOfK(int [] array , int k) {
        int left = 0;
        int right = array.length - 1;
        int mid = (left + right) / 2;
        while(left < right){
            if(array[mid] == k){
                break;
            }else if(array[mid] < k){
                left = mid + 1;
                mid = (left + right) / 2;
            }else{
                right = mid - 1;
                mid = (left + right) / 2;
            }
        }

        // 统计次数
        int count = 0;
        if(array[mid] == k){
            count++;
            int s = 1;

            while((mid - s >= 0 && array[mid - s] == k) || (mid + s < array.length && array[mid + s] == k)){
                if(mid - s >= 0 && array[mid - s] == k){
                    count++;
                }
                if(mid + s < array.length && array[mid + s] == k){
                    count++;
                }
                s++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,3,3,3,3,4,5};
        int k = 6;
        System.out.println(GetNumberOfK(a, k));
    }
}
