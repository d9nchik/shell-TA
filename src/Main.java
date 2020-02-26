public class Main {
    public static void main(String[] args) {
        System.out.println("Вхідні данні: ");
        int[] arr = array(50_000);
        double startTime = System.currentTimeMillis();
        sort(arr);
        showArray(arr);
        double endTime = System.currentTimeMillis();
        double totalTime = endTime - startTime;
        System.out.print("Wasted time: " + totalTime);
    }

    public static void sort(int[] arr) {
        for (int inc = (int) (Math.log(arr.length) / Math.log(2)); inc >= 1; inc = inc / 2)
            for (int step = 0; step < inc; step++)
                insertionSort(arr, step, inc);

    }

    private static void insertionSort(int[] arr, int start, int inc) {
        int tmp;
        for (int i = start; i < arr.length - 1; i += inc)
            for (int j = Math.min(i + inc, arr.length - 1); j - inc >= 0; j = j - inc)
                if (arr[j - inc] > arr[j]) {
                    tmp = arr[j];
                    arr[j] = arr[j - inc];
                    arr[j - inc] = tmp;
                } else break;
    }

    public static int[] array(int size) {
        int[] arr = new int[size];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = size - k - 1;
        }
        return arr;
    }

    public static void showArray(int[] arr) {
        for (int k = 0; k < arr.length; k++) {
            if (k % 100 != 99)
                System.out.print(arr[k] + ", ");
            else
                System.out.println(arr[k]);
        }
    }
}
