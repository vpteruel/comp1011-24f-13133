public class AnonymousRunnable {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello, World!");
            }
        };

        // creating a thread and passing the Runnable to it
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
