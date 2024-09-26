// Класс, представляющий узел бинарного дерева
public class TreeNode {
    private int value;       // Значение, хранимое в узле
    private TreeNode left;   // Левый дочерний узел
    private TreeNode right;  // Правый дочерний узел

    // Конструктор для создания узла с заданным значением
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    // Геттеры и сеттеры для доступа к полям
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
