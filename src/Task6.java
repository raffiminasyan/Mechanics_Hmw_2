import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input parameters
        double M1, M2, M3, u1, u2, u3, L, dt;

        // Input masses
        System.out.print("Enter mass of M1 (kg): ");
        M1 = scanner.nextDouble();
        System.out.print("Enter mass of M2 (kg): ");
        M2 = scanner.nextDouble();
        System.out.print("Enter mass of M3 (kg): ");
        M3 = scanner.nextDouble();

        // Input initial velocities
        System.out.print("Enter initial velocity of M1 (m/s): ");
        u1 = scanner.nextDouble();
        System.out.print("Enter initial velocity of M2 (m/s): ");
        u2 = scanner.nextDouble();
        System.out.print("Enter initial velocity of M3 (m/s): ");
        u3 = scanner.nextDouble();

        // Input rope length
        System.out.print("Enter rope length (m): ");
        L = scanner.nextDouble();

        // Input time step
        System.out.print("Enter time step (s): ");
        dt = scanner.nextDouble();

        // Simulation
        double D_max = 0; // Max displacement of M1
        double a1, a2, a3; // Accelerations
        double x1 = 0; // Initial displacement of M1

        while (true) {
            // Calculate accelerations
            a1 = (M2 * u2 * u2 - M3 * u3 * u3) / (M1 + M2 + M3);
            a2 = (u1 * u1 - u3 * u3) / L;
            a3 = (2 * M2 * u2 * u2 - M1 * u1 * u1) / (M1 + M2 + M3);

            // Update velocities
            u1 += a1 * dt;
            u2 += a2 * dt;
            u3 += a3 * dt;

            // Update displacements
            x1 += u1 * dt;
            if (x1 > D_max) {
                D_max = x1;
            }

            // Check if M3 hits the ground
            if (u3 <= 0) {
                break;
            }
        }

        System.out.println("Maximal distance D M1 moves from its original position: " + D_max + " meters");

        scanner.close();
    }
}
