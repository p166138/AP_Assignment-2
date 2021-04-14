public class ep {
    static int evencount=0;
    static int primecount=0;
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable1=()->{
            for (int i = 1; i <= 10000; i++) {
                if(i%2==0)
                {
                evencount+=1;
                }
            }
        };
        Runnable runnable2=()->{
            for (int i = 1; i <= 10000; i++) {
                boolean flag = false;
                for (int g = 2; g <= i / 2; ++g) {
                    if (i % g == 0) {
                      flag = true;
                      break;
                    }
                  }
                if(!flag)
                {
                primecount+=1;
                }
            }
        };



        
        Thread thread1=new Thread(runnable1);
        thread1.start();
        thread1.join();
        System.out.println("even count is "+evencount);

        Thread thread2=new Thread(runnable2);
        thread2.start();
        thread2.join();
        System.out.println("prime count is "+primecount);
    }
}