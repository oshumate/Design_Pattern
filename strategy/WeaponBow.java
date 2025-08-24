package strategy;

public class WeaponBow extends WeaponBehavior {
    @Override
    public void attack() {
        System.out.println("Shooting an Arrow\n");

        int width = 120;          
        int totalTimeMs = 4000;  
        int delayMs = totalTimeMs / width;

        for (int i = 0; i < width; i++) {
            StringBuilder frame = new StringBuilder();

            frame.append(")"); // bow stays fixed at start

            for (int j = 0; j < i; j++) frame.append(" ");
            frame.append("--->");

            System.out.print("\r" + frame);
            System.out.flush();

            long end = System.nanoTime() + (delayMs * 1_000_000L);
            while (System.nanoTime() < end) {  }
        }
        System.out.println();
    }
}
