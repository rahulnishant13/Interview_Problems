package Interviews;

public class PrintRGBUsingThreeThreads {
    private String threadZToRun = "r";
    private Boolean flag = true;
    private Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        PrintRGBUsingThreeThreads print = new PrintRGBUsingThreeThreads();
        Thread t1 = new Thread(print.new Print("r"));
        Thread t2 = new Thread(print.new Print("g"));
        Thread t3 = new Thread(print.new Print("b"));
        t1.start();
        t2.start();
        t3.start();
    }

    class Print implements Runnable{
        private String s;

        Print(String str){
            s = str;
        }

        @Override
        public void run() {
            while (flag) {
                try {
                    synchronized (lock) {
                        if (threadZToRun != s) {
                            lock.wait();
//                            System.out.println("wait over " + s);
                        } else {
                            System.out.println(s);

                            if (s == "r")
                                threadZToRun = "g";
                            else if (s == "g")
                                threadZToRun = "b";
                            else if (s == "b")
                                flag = false;

                            lock.notifyAll();
                        }
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
