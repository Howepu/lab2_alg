import java.util.Optional;
import java.util.Scanner;

// Основной класс для запуска программы
public class BinaryTreeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества узлов
        System.out.print("Введите количество узлов (N > 0): ");
        int N = scanner.nextInt();
        if (N <= 0) {
            System.out.println("N должно быть больше 0.");
            return;
        }

        // Ввод значений узлов
        int[] values = new int[N];
        System.out.println("Введите " + N + " значений:");
        for (int i = 0; i < N; i++) {
            values[i] = scanner.nextInt();
        }

        // Создание начального дерева
        Optional<TreeNode> root = createInitialTree(values);
        if (root.isEmpty()) {
            System.out.println("Не удалось создать дерево.");
            return;
        }

        System.out.println("Исходное дерево:");
        printTree(root.get(), "");

        // Преобразование дерева
        transformTree(root.get());
        System.out.println("\nПреобразованное дерево:");
        printTree(root.get(), "");
    }

    // Метод для создания начального дерева
    private static Optional<TreeNode> createInitialTree(int[] values) {
        if (values.length == 0) {
            return Optional.empty();
        }

        TreeNode root = new TreeNode(values[0]);
        TreeNode current = root;
        boolean addRight = true;

        for (int i = 1; i < values.length; i++) {
            TreeNode newNode = new TreeNode(values[i]);
            if (addRight) {
                current.setRight(newNode);
            } else {
                current.setLeft(newNode);
            }
            current = newNode;
            addRight = !addRight; // Чередуем добавление правого и левого дочернего узла
        }

        return Optional.of(root);
    }

    // Метод для преобразования дерева: +1 для листьев, -1 для внутренних узлов
    private static void transformTree(TreeNode node) {
        if (node == null) return;

        if (node.getLeft() == null && node.getRight() == null) {
            node.setValue(node.getValue() + 1); // Узел является листом
        } else {
            node.setValue(node.getValue() - 1); // Узел является внутренним
            transformTree(node.getLeft());
            transformTree(node.getRight());
        }
    }

    // Метод для печати дерева в виде структуры
    private static void printTree(TreeNode node, String prefix) {
        if (node != null) {
            System.out.println(prefix + node.getValue());
            printTree(node.getLeft(), prefix + "L-- ");
            printTree(node.getRight(), prefix + "R-- ");
        }
    }
}
