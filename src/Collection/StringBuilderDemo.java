package Collection;

public class StringBuilderDemo {
    public static void main(String[] args) throws InterruptedException {
//        StringBuilder string = new StringBuilder();
        StringBuffer string = new StringBuffer();
        MultiThreadTestString(string);
    }

    private static void MultiThreadTestString(StringBuilder stringBuilder) throws InterruptedException {
        long time = System.currentTimeMillis();
        for (int i = 0; i<10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<1000; i++) {
                        stringBuilder.append("a");
                    }
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(stringBuilder.length());
        System.out.println(System.currentTimeMillis() - time);
    }

    private static void MultiThreadTestString(StringBuffer stringBuffer) throws InterruptedException {
        long time = System.currentTimeMillis();
        for (int i = 0; i<10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i<1000; i++) {
                        stringBuffer.append("a");
                    }
                }
            }).start();
        }
        Thread.sleep(100);
        System.out.println(stringBuffer.length());
        System.out.println(System.currentTimeMillis() - time);
    }
}
