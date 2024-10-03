import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    //冒泡排序的非递归实现 O(n)-O(n^2)
    public static void bubblesort(int[] a) {
        int j = a.length - 1;
        do {
            int x = 0;
            for (int i = 0; i < j; i++) {
                if (a[i] > a[i + 1]) {
                    int t = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = t;
                    x = i;
                }
            }
            j = x;
        } while (j != 0);
    }

    //选择排序 O(n^2)
    //选择轮数a.length-1；
    // 交换的索引位置right初始为a.length-1，每次递减
    public static void selectionsort(int[] a) {
        for (int right = a.length - 1; right > 0; right--) {
            int max = right;
            for (int i = 0; i < right; i++) {
                if (a[i] > a[max]) {
                    max = i;
                }
            }
            if (max != right) {
                swap(a, max, right);
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

//堆排序O(n)
    //建立大顶堆
    //每次将堆顶（最大值）元素交换到末尾，调整堆顶元素（下潜），让他重新符合大顶堆的特性

    //建堆方法
    private static void heapify(int[] array, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            down(array, i, size);
        }
    }

    //下潜的递归实现
    private static void down(int[] array, int parent, int size) {
        int left = parent * 2 + 1;
        int right = left + 1;
        int max = parent;
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        if (max != parent) {
            swap(array, max, parent);
            down(array, max, size);
        }
    }

    //下潜的非递归实现
    private static void down2(int[] array, int parent, int size) {
        while (true) {
            int left = parent * 2 + 1;
            int right = left + 1;
            int max = parent;
            if (left < size && array[left] > array[max]) {
                max = left;
            }
            if (right < size && array[right] > array[max]) {
                max = right;
            }
            if (max == parent) {
                break;
            }
            swap(array, max, parent);
            parent = max;
        }
    }

    //堆排序
    public static void heapsort(int[] a) {
        heapify(a, a.length);
        for (int right = a.length - 1; right > 0; right--) {
            swap(a, 0, right);
            down(a, 0, right);
        }
    }

    //插入排序 O(n)-O(n^2)
    //将数组分为两部分，【0-low-1】【low-a.length-1】 前面是已经排序部分 后面是未排序部分
    //每次从未排序的区域取出low位置的元素，插入到已排序区域
    public static void insertsort(int[] a) {
        for (int low = 1; low < a.length; low++) {
            int t = a[low];
            int i = low - 1;
            while (i >= 0 && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            if (i != low - 1) {
                a[i + 1] = t;
            }
        }
    }

    //希尔排序（改良版插入排序）O(n)-O(n*logn)
    //分组实现插入，每组的元素间隙称为gap
    //每轮排序后gap逐渐变小，直到gap为1完成排序
    //对插入排序的优化，让元素更加迅速的交换到最终位置
    public static void shellsort(int[] a) {
        for (int gap = a.length >> 1; gap >= 1; gap = gap >> 1) {
            for (int low = gap; low < a.length; low++) {
                int t = a[low];
                int i = low - gap;
                while (i >= 0 && t < a[i]) {
                    a[i + gap] = a[i];
                    i -= gap;
                }
                if (i != low - gap) {
                    a[i + gap] = t;
                }
            }
        }
    }

//归并排序O（nlogn） 分而治之 缺点：空间占用大
    //分： 每次从中间切一刀，处理数据减少一半
    //治：当数据仅剩下一个时可以认为有序
    //合：两个有序结果 可以进行合并排序（合并有序数组）


    //合并有序数组的merge方法
    /*
    a1原始数组
    i-iend 第一个有序范围
    j-jeng 第二个有序范围
    a2临时数组
    */
    public static void merge(int[] a1, int i, int iend, int j, int jend, int[] a2) {
        int k = i;
        while (i <= iend && j <= jend) {
            if (a1[i] < a1[j]) {
                a2[k] = a1[i];
                i++;
            } else {
                a2[k] = a1[j];
                j++;
            }
            k++;
        }
        if (i > iend) {
            System.arraycopy(a1, j, a2, k, jend - j + 1);
        }
        if (j > jend) {
            System.arraycopy(a1, i, a2, k, iend - i + 1);
        }

    }

    //递归版本的归并排序 自上而下 updown
    public static void mergesort(int[] a1) {
        int[] a2 = new int[a1.length];
        split(a1, 0, a1.length - 1, a2);

    }

    private static void split(int[] a1, int left, int right, int[] a2) {
        //2. 治
        if (right - left <= 32) {
            //插入排序和归并排序的结合， 因为插入适合小规模数据，归并适合大规模数据
            //经过改良 这个结合的算法可以打败jdk自己提供的Arrays，sort（）方法
            insertion(a1, left, right);
            return;
        }
        //1. 分
        int m = (left + right) >>> 1;
        split(a1, left, m, a2);
        split(a1, m + 1, right, a2);
        //3.合
        merge(a1, left, m, m + 1, right, a2);
        System.arraycopy(a2, left, a1, left, right - left + 1);
    }

    //改装的插入排序代码，目的是在“治“这一步中，
    // 没必要等到分到只剩下一个元素才认为有序，可以利用插入排序在处理数据量小的数据中的优势，让他先排序
    public static void insertion(int[] a, int left, int right) {
        for (int low = left + 1; low <= right; low++) {
            int t = a[low];
            int i = low - 1;
            while (i >= left && t < a[i]) {
                a[i + 1] = a[i];
                i--;
            }
            if (i != low - 1) {
                a[i + 1] = t;
            }
        }
    }

    //非递归版本的归并排序 自下而上 bottomup
    public static void mergesort2(int[] a1) {
        int n = a1.length;
        int[] a2 = new int[n];
        for (int width = 1; width < n; width *= 2) {//width     代表了有序区间的宽度，取值为1，2，4，8......
            for (int left = 0; left < n; left += 2 * width) {
                int right = Math.min(left + 2 * width - 1, n - 1);
                //System.out.printf("width %d [%d,%d]%n",width,left,right);
                int m = Math.min(left + width - 1, n - 1);
                merge(a1, left, m, m + 1, right, a2);
            }
            System.arraycopy(a2, 0, a1, 0, n);
        }
    }

    //单边循环快排（lomuto 洛穆托分区方案）
    /*
核心思想： 每轮找一个基准点元素，把比他小的放到左边，比他大的放到右边，称为分区
1. 选择最后边的元素作为基准点
2.j指针负责找到比基准点小的元素，一旦找到与i进行交换
3.i指针指向大于基准点元素的左边界，也是每次交换的目标索引
4.最后基准点与i交换 i即为分区位置
     */
    public static void lomutosort(int[] a) {
        quick(a, 0, a.length - 1);
    }

    private static void quick(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition3(a, left, right);//基准点元素的索引
        quick(a, left, p - 1);
        quick(a, p + 1, right);
    }

    //分区方法：
    private static int partition(int[] a, int left, int right) {
        int pv = a[right];//基准点元素的值
        int i = left;
        int j = left;
        while (j < right) {
            if (a[j] < pv) {
                if (i != j) {
                    swap(a, i, j);
                }
                i++; //如果当前的值小于基准点的值 也就是i没有找到，此时i才会向下走 这里本质上就是快慢指针
            }
            j++;
        }
        swap(a, i, right);
        return i;
    }

    //双边循环分区
    /*
    要点：
    选择最左侧元素作为基准点
    j找比基准点小的，i找比基准点大的，一旦找到，二者进行交换
    i从左向右
    j从右向左
    最后基准点与i交换，i即为基准点最终索引
     */
    //只是分区方法不同，其他的和单边一样
    /*
    注意事项：
    1.内循环也要加i<j 的条件
    2.要先处理j,再处理i，因为最后那个swap方法，如果交换顺序会找到i错误的位置
    3.随机元素作为基准点
    4.重复元素的处理
     */
    private static int partition2(int[] a, int left, int right) {
        int randomInBoundary = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        int pv = a[randomInBoundary];
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && a[j] > pv) {
                j--;
            }
            while (i < j && a[i] <= pv) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, left, i);
        return i;
    }

    // 可以处理重复元素 快排天花板了 可以同样加入插入算法，来优化数据量不大的情况
    private static int partition3(int[] a, int left, int right) {
        int randomnumb = ThreadLocalRandom.current().nextInt(right - left + 1) + left;
        int pv = a[randomnumb];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && a[j] > pv) {
                j--;
            }
            while (i <= j && a[i] < pv) {
                i++;
            }
            if (i <= j) {
                swap(a, i, j);
                i++;
                j--;
            }
        }
        swap(a, left, j);
        return j;
    }

    //计数排序 基于非比较的排序  适用于十几万以内的范围 成绩最好
    /*
    找到最大值，创建一个大小为最大值加1的count数组
    count数组的索引对应原始数组的元素，用来统计该元素的出现次数
    遍历count数组，根据数组索引以及出现次数 生成排序后内容count数组的索引是已经排好序的
    注意： 让原始数组最小值映射到count【0】 最大映射到count数组最右侧
     */
    public static void countingsort(int[] a) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        int[] count = new int[max - min + 1];
        for (int v : a) {
            count[v - min]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                a[k++] = i + min;
                count[i]--;
            }
        }
    }

    //桶排序
    public static void bucketsort(int[] a, int range) {
        int max = a[0];
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
            if (a[i] < min) {
                min = a[i];
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int i : a) {
            buckets[(i - min) / range].add(i);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            int[] array = new int[bucket.size()];
            for (int i = 0; i < bucket.size(); i++) {
                array[i] = bucket.get(i);
            }
            insertsort(array);
            for (int v : array) {
                a[k] = v;
                k++;
            }
        }
    }

    //基数排序 最低有效数字(least significant digit)
    public static void radixsort(String[] a, int length) {
        //1.准备桶
        ArrayList<String>[] buckets = new ArrayList[128];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        //2.进行多轮按位桶排序
        for (int i = length - 1; i >= 0; i--) {
            //将字符串放入合适的桶
            for (String s : a) {
                buckets[s.charAt(i)].add(s);
            }
            //重新取出排好序的字符串，放回原来的数组
            int k = 0;
            for (ArrayList<String> bucket : buckets) {
                for (String string : bucket) {
                    a[k++] = string;
                }
                bucket.clear();
            }
        }
    }

    //E01 根据另一个数组次序排序
    public static int[] relativesortarray(int[] arr1, int[] arr2) {
        int[] count = new int[1001];
        for (int i : arr1) {
            count[i]++;
        }
        int k = 0;
        int[] result = new int[arr1.length];
        for (int i : arr2) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[k++] = i;
                count[i]--;
            }
        }
        return result;
    }

    //E02 按照出现频率排序  如果出现多个值的出现频率相同 再降序排序 数据在【-100，100】之内
    public static int[] frrequencysort(int[] nums) {
        int[] count = new int[201];
        for (int i : nums) {
            count[i + 100]++;
        }
        //设置比较器 频率升序，然后按照数值降序
        //流不能直接在intarray中使用，需要先转换成包装类型的流才能利用比较器
        return Arrays.stream(nums).boxed().sorted((a, b) -> {
            int af = count[a + 100];
            int bf = count[b + 100];
            if (af < bf) {
                return -1;
            } else if (af > bf) {
                return 1;
            } else {
                return b - a;
            }

        }).mapToInt(Integer::intValue).toArray();//比较完成 还原成基本类型的整数流

    }

    //E03 最大间距 解法1：桶排序
    public static int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max1 = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max1) {
                max1 = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[(max1 - min) / 1 + 1];
        for (int i1 = 0; i1 < buckets.length; i1++) {
            buckets[i1] = new ArrayList<>();
        }
        for (int i1 : nums) {
            buckets[(i1 - min) / 1].add(i1);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            int[] array = new int[bucket.size()];
            for (int i1 = 0; i1 < bucket.size(); i1++) {
                array[i1] = bucket.get(i1);
            }
            insertsort(array);
            for (int v : array) {
                nums[k] = v;
                k++;
            }
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }

    //解法2：基数排序
    public static int maximumGap2(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int m = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m, nums[i]);//数组中最大值，根据这个建立桶
        }
        ArrayList<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
        }
        int n = 1;//为了获取更高位的数字
        while (n <= m) {
            for (int i : nums) {
                buckets[i / n % 10].add(i);//先除以1；10；100 在取余数来获取个十百千位上的值
            }
            int k = 0;
            //把桶中的数据再放回数组中
            for (ArrayList<Integer> bucket : buckets) {
                // System.out.println(Arrays.toString(buckets));
                for (Integer i : bucket) {
                    nums[k++] = i;
                }
                bucket.clear();
            }
            n = n * 10;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i] - nums[i - 1]);
        }
        return max;
    }


    //解法3：优化桶排序
    public static int maximumGap3(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max) {
                max = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        //主要是调整桶的个数 期望的桶的个数就是数组长度，因为期望每个桶一个数据
        /*
        range 的计算： （max-min）/range+1=nums.length;
         */
        int range = Math.max((max - min) / (nums.length - 1), 1);
        ArrayList<Integer>[] buckets = new ArrayList[(max - min) / range + 1];
        for (int i1 = 0; i1 < buckets.length; i1++) {
            buckets[i1] = new ArrayList<>();
        }
        for (int i1 : nums) {
            buckets[(i1 - min) / range].add(i1);
        }
        int k = 0;
        for (ArrayList<Integer> bucket : buckets) {
            int[] array = new int[bucket.size()];
            for (int i1 = 0; i1 < bucket.size(); i1++) {
                array[i1] = bucket.get(i1);
            }
            insertsort(array);
            for (int v : array) {
                nums[k] = v;
                k++;
            }
        }
        int r = 0;
        for (int i = 1; i < nums.length; i++) {
            r = Math.max(r, nums[i] - nums[i - 1]);
        }
        return r;
    }

    //解法4：终极优化，桶内不需要排序，只需要直到最大值和最小
    // 在有空桶的情况下，桶间的间距最大
    public static int maximumGap4(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max1 = nums[0];
        int min = nums[0];
        for (int i1 = 1; i1 < nums.length; i1++) {
            if (nums[i1] > max1) {
                max1 = nums[i1];
            }
            if (nums[i1] < min) {
                min = nums[i1];
            }
        }
        //调整桶的个数比元素个数多一个
        int range = Math.max((max1 - min) / (nums.length), 1);
        int bucketsize=(max1-min)/range +1;
        System.out.println(range+"/t"+bucketsize);
        pair[] buckets = new pair[(max1 - min) / range + 1];
        //放入数据
        for (int v : nums) {
            if (buckets[(v - min) / range] == null) {
                buckets[(v - min) / range] = new pair();
            }
            buckets[(v - min) / range].add(v);
        }
        for (pair bucket : buckets) {
            System.out.println(bucket);
        }
        int r = 0;
        int lastmax = buckets[0].max;
        for (int i = 1; i < buckets.length; i++) {
            pair bucket = buckets[i];
            if (bucket != null) {
                r = Math.max(r, bucket.min - lastmax);
                lastmax = bucket.max;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(a));
        frrequencysort(a);
        System.out.println(Arrays.toString(a));
        String[] s = {"13954470203", "15964504511", "15178566541", "13564965432", "15854489652", "13856698562"};
        radixsort(s, 11);
        System.out.println(Arrays.toString(s));
        int[] arr1 = {3, 2, 1, 2, 2, 2, 1, 5, 4};
        int[] arr2 = {2, 3, 1};
        System.out.println(Arrays.toString(relativesortarray(arr1, arr2)));
        int[] nums1 = {10,15,20,25,40,100,24};
        System.out.println(maximumGap4(nums1));

    }

    static class pair {
        int max = 0;
        int min = 1000000000;

        void add(int v) {//记录每个桶内最大最小值
            max = Math.max(v, max);
            min = Math.min(v, min);
        }

        @Override
        public String toString() {
            return "pair{" + max +
                    ", " +
                    min +
                    '}';
        }
    }
}