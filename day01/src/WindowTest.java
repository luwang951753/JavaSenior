/**
 * @Author lw
 * @Create2020-03-05 15:04
 */

/**
 * 例子:创建三个窗口卖标，总票数为100张，使用继承Thread类的方式
 * 存在线程的安全问题，待解决
 */
public class WindowTest{

    public static void main(String[] args) {
        window t1 = new window();
        window t2 = new window();
        window t3 = new window();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class window extends Thread{
    private static int ticket =100;

    @Override
    public void run() {
        while(true){
            if(ticket > 0){
                System.out.println(getName()+":卖票，票号为:"+ticket);
                ticket--;
            }else{
                break;
            }
        }
    }
}
