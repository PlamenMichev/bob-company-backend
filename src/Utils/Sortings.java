package Utils;

import Model.ConstructionProject;

import java.util.ArrayList;

/**
 * Class used for utility methods regarding sorting
 */
public class Sortings
{

    /**
     * Implementation of QuickSort
     * @param arr the array to be sorted
     * @param p first position
     * @param r last position
     */
    public static void SortAscendingOnName(ArrayList<ConstructionProject> arr, int p, int r)
    {
        if(p<r) // 1 comparison
        {
            int q = partitionName(arr, p, r); // 1 initialization, 1 call of function partition ==> O(n)
            SortAscendingOnName(arr, p, q-1); // 1 recursion
            SortAscendingOnName(arr, q+1, r); // 1 recursion
        }
        // T(n) = 2 + n + 2*T(n/2)
        // a = 2, b = 2, k = 1 ==> a = b
        // T(n) = O( n^1*log(n) ) = n*log(n)
    }

    /**
     * Partition algorithm used for QuickSort
     * @param arr the array to be partitioned
     * @param p first position
     * @param r last position
     * @return position of the last movement
     */
    public static int partitionName(ArrayList<ConstructionProject> arr, int p, int r)
    {
        ConstructionProject aux; // 1 declaration
        String x = arr.get(r).getName();// 1 initialization + 1 .get() + 1 .getName()
        int i = p-1; // 1 initialization
        for(int j = p; j < r; j++) // 1 initialization, r-p comparisons, r-p incrementation
                                    // the loop runs r-p times
        {
            if(arr.get(j).getName().compareTo(x) <= 0) // 1 comparison + 1 .get() + 1 .getName() + 1 .compareTo() + 1 comparison
            {
                i++; // 1 incrementation
                aux = arr.get(i); // 1 giving of value, 1 .get()
                arr.set(i, arr.get(j)); // 1 .set(), 1 .get()
                arr.set(j, aux); // 1 .set()
            }
        }
        aux = arr.get(i+1); // 1 giving of value, 1 .get()
        arr.set(i+1, arr.get(r)); // 1 .set(), 1 .get()
        arr.set(r, aux); // 1 .set()
        return i+1; // 1 return

        // 1 + 3 + 1 + 1 + r-p ( 2 + 4 + 1 + 2 + 2 + 1) + 2 + 2 + 1 + 1 = 12 + 12 * (r-p)
        // ==> O(n)
    }

    /**
     * Implementation of QuickSort
     * @param arr the array to be sorted
     * @param p first position
     * @param r last position
     */
    public static void SortAscendingOnType(ArrayList<ConstructionProject> arr, int p, int r)
    {
        if(p<r) // 1 comparison
        {
            int q = partitionType(arr, p, r); // 1 initialization, 1 call of function partition ==> O(n)
            SortAscendingOnName(arr, p, q-1); // 1 recursion
            SortAscendingOnName(arr, q+1, r); // 1 recursion
        }
        // T(n) = 2 + n + 2*T(n/2)
        // a = 2, b = 2, k = 1 ==> a = b
        // T(n) = O( n^1*log(n) ) = n*log(n)
    }

    /**
     * Partition algorithm used for QuickSort
     * @param arr the array to be partitioned
     * @param p first position
     * @param r last position
     * @return position of the last movement
     */
    public static int partitionType(ArrayList<ConstructionProject> arr, int p, int r)
    {
        ConstructionProject aux; // 1 declaration
        String x = arr.get(r).getType();// 1 initialization + 1 .get() + 1 .getType()
        int i = p-1; // 1 initialization
        for(int j = p; j < r; j++) // 1 initialization, r-p comparisons, r-p incrementation
        // the loop runs r-p times
        {
            if(arr.get(j).getType().compareTo(x) < 0) // 1 comparison + 1 .get() + 1 .getType() + 1 .compareTo() + 1 comparison
            {
                i++; // 1 incrementation
                aux = arr.get(i); // 1 giving of value, 1 .get()
                arr.set(i, arr.get(j)); // 1 .set(), 1 .get()
                arr.set(j, aux); // 1 .set()
            }
        }
        aux = arr.get(i+1); // 1 giving of value, 1 .get()
        arr.set(i+1, arr.get(r)); // 1 .set(), 1 .get()
        arr.set(r, aux); // 1 .set()
        return i+1; // 1 return

        // 1 + 3 + 1 + 1 + r-p ( 2 + 4 + 1 + 2 + 2 + 1) + 2 + 2 + 1 + 1 = 12 + 12 * (r-p)
        // ==> O(n)
    }

    public static void SortAscendingOnBudget(ArrayList<ConstructionProject> arr, int p, int r)
    {
        if(p<r) // 1 comparison
        {
            int q = partitionBudget(arr, p, r); // 1 initialization, 1 call of function partition ==> O(n)
            SortAscendingOnName(arr, p, q-1); // 1 recursion
            SortAscendingOnName(arr, q+1, r); // 1 recursion
        }
        // T(n) = 2 + n + 2*T(n/2)
        // a = 2, b = 2, k = 1 ==> a = b
        // T(n) = O( n^1*log(n) ) = n*log(n)
    }

    /**
     * Partition algorithm used for QuickSort
     * @param arr the array to be partitioned
     * @param p first position
     * @param r last position
     * @return position of the last movement
     */
    public static int partitionBudget(ArrayList<ConstructionProject> arr, int p, int r)
    {
        ConstructionProject aux; // 1 declaration
        double x = arr.get(r).getBudget();// 1 initialization + 1 .get() + 1 .getBudget()
        int i = p-1; // 1 initialization
        for(int j = p; j < r; j++) // 1 initialization, r-p comparisons, r-p incrementation
        // the loop runs r-p times
        {
            if(arr.get(j).getBudget() < x) // 1 comparison + 1 .get() + 1 .getBudget() + 1 .compareTo() + 1 comparison
            {
                i++; // 1 incrementation
                aux = arr.get(i); // 1 giving of value, 1 .get()
                arr.set(i, arr.get(j)); // 1 .set(), 1 .get()
                arr.set(j, aux); // 1 .set()
            }
        }
        aux = arr.get(i+1); // 1 giving of value, 1 .get()
        arr.set(i+1, arr.get(r)); // 1 .set(), 1 .get()
        arr.set(r, aux); // 1 .set()
        return i+1; // 1 return

        // 1 + 3 + 1 + 1 + r-p ( 2 + 4 + 1 + 2 + 2 + 1) + 2 + 2 + 1 + 1 = 12 + 12 * (r-p)
        // ==> O(n)
    }

    public static void SortAscendingOnTimeline(ArrayList<ConstructionProject> arr, int p, int r)
    {
        if(p<r) // 1 comparison
        {
            int q = partitionTimeline(arr, p, r); // 1 initialization, 1 call of function partition ==> O(n)
            SortAscendingOnName(arr, p, q-1); // 1 recursion
            SortAscendingOnName(arr, q+1, r); // 1 recursion
        }
        // T(n) = 2 + n + 2*T(n/2)
        // a = 2, b = 2, k = 1 ==> a = b
        // T(n) = O( n^1*log(n) ) = n*log(n)
    }

    /**
     * Partition algorithm used for QuickSort
     * @param arr the array to be partitioned
     * @param p first position
     * @param r last position
     * @return position of the last movement
     */
    public static int partitionTimeline(ArrayList<ConstructionProject> arr, int p, int r)
    {
        ConstructionProject aux; // 1 declaration
        double x = arr.get(r).getTimeline();// 1 initialization + 1 .get() + 1 .getTimeline()
        int i = p-1; // 1 initialization
        for(int j = p; j < r; j++) // 1 initialization, r-p comparisons, r-p incrementation
        // the loop runs r-p times
        {
            if(arr.get(j).getTimeline() < x) // 1 comparison + 1 .get() + 1 .getTimeline() + 1 .compareTo() + 1 comparison
            {
                i++; // 1 incrementation
                aux = arr.get(i); // 1 giving of value, 1 .get()
                arr.set(i, arr.get(j)); // 1 .set(), 1 .get()
                arr.set(j, aux); // 1 .set()
            }
        }
        aux = arr.get(i+1); // 1 giving of value, 1 .get()
        arr.set(i+1, arr.get(r)); // 1 .set(), 1 .get()
        arr.set(r, aux); // 1 .set()
        return i+1; // 1 return

        // 1 + 3 + 1 + 1 + r-p ( 2 + 4 + 1 + 2 + 2 + 1) + 2 + 2 + 1 + 1 = 12 + 12 * (r-p)
        // ==> O(n)
    }
}
