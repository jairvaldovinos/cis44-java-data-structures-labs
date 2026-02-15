public class Main {
    public static void main(String[] args) {
        System.out.println("=== Matrix Demo ===\n");

        // Create 3x3 matrices
        Matrix m1 = new Matrix(3, 3);
        m1.populateRandom();
        System.out.println("Matrix m1:");
        System.out.println(m1);

        Matrix m2 = new Matrix(3, 3);
        m2.populateRandom();
        System.out.println("Matrix m2:");
        System.out.println(m2);

        // Add matrices
        Matrix sum = m1.add(m2);
        System.out.println("m1 + m2:");
        System.out.println(sum);

        // Multiply matrices
        Matrix product = m1.multiply(m2);
        System.out.println("m1 * m2:");
        System.out.println(product);

        // Show exception handling: adding matrices of different sizes
        try {
            Matrix m3 = new Matrix(2, 3);
            m3.populateRandom();
            System.out.println("Trying to add m1 + m3:");
            m1.add(m3);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // Show exception handling: multiplying incompatible matrices
        try {
            Matrix m4 = new Matrix(4, 2);
            m4.populateRandom();
            Matrix m5 = new Matrix(3, 3);
            m5.populateRandom();
            System.out.println("Trying to multiply m4 * m5:");
            m4.multiply(m5);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
