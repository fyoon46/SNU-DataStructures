package source.BST;

public class AVLTreeDemo {
    public static void main(String[] args) {
        System.out.println("AVL Tree!!");
        AVLTree avl = new AVLTree();
        System.out.println("isEmpty(): " + avl.isEmpty());

        avl.insert(10);
        avl.insert(20);
        avl.insert(5);
        avl.insert(80);
        avl.insert(90);
        avl.insert(30);
        avl.insert(40);
        avl.printPreOrder();

        avl.delete(80);
        System.out.println("Deleted!");
        avl.printPreOrder();


		int tmp = 755;
		AVLNode res = avl.search(tmp);
		if(res ==  AVLTree.NIL) {
            System.out.println("Search for " + tmp + " Failed");
		} else {
            System.out.println("Search for " + res.item + " succeeded" );
		}
		tmp = 5;
		res = avl.search(tmp);
		if(res ==  AVLTree.NIL) {
            System.out.println("Search for " + tmp + " Failed");
		} else {
            System.out.println("Search for " + res.item + " succeeded" );
		}
    }
} // 코드 11-3
