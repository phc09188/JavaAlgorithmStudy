package Algorithm_practice;

public class BinarySearch {
    //유무 판단
    public boolean binarySearch(int[] arr, int n, int a){
        int first = 0;
        int last = n-1;
        int mid = 0;
        while(first<=last){
            mid = (first + last)/2;
            if(arr[mid] == a){
                return true;
            }
            if(arr[mid] <= a){
                first = mid+1;
            }else{
                last = mid -1;
            }
        }
        return false;
    }
    // 해당 값의 개수를 구할 때 사용하는 upper와 lower
    public int upperBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo <hi){
            int mid = (lo+hi)/2;
            if(key<arr[mid]){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }
        return lo;
    }
    public int lowerBound(int[] arr, int key){
        int lo = 0;
        int hi = arr.length;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(lo<=hi){
                hi = mid;
            }else{
                lo = mid +1;
            }
        }
        return lo;
    }
}
