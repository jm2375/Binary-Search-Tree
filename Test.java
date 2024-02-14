import java.util.Random;

public class Test {

    public static void main(String[] args) {

        BinaryTree<Integer> tree = new BinarySearchTree<>();
        Random rand = new Random();
        int num = args.length == 1 ? Integer.parseInt(args[0]) : 11;
        long start, stop;
        
        System.out.println("Insert:");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(10);
            
            tree.insert(n);
            System.out.print(n + ": ");
            
            for (Integer j : tree) {
                System.out.print(j + " ");
            }
            
            System.out.println();
        }
        
        stop = System.currentTimeMillis();
        System.out.println("Insert Time: " + (stop - start) + " ms");
        
        System.out.println("\nSearch:");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(10);
            System.out.println(n + " " + (tree.search(n) ? "Found" : "Not Found"));
        }
        
        stop = System.currentTimeMillis();
        System.out.println("Search Time: " + (stop - start) + " ms");
        
        System.out.println("\nRemove:");
        start = System.currentTimeMillis();
        for (int i = 0; i < num; ++i) {
            int n = rand.nextInt(10);
            
            tree.remove(n);
            System.out.print(n + ": ");
            for (Integer j : tree) {
                System.out.print(j + " ");
            }
            
            System.out.println();
        }
        
        stop = System.currentTimeMillis();
        System.out.println("Remove Time: " + (stop - start) + " ms");
    }
}
