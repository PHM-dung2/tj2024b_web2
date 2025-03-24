package example.day10._멀티스레드;

import java.awt.*;

public class 비프음1 implements Runnable {
    @Override // 재정의
    public void run(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for( int i = 0 ; i <= 5 ; i++ ){
            toolkit.beep(); // 비프음
            try{ Thread.sleep( 1000 ); }catch ( Exception e ){ System.out.println( e ); }
        } // for end
    } // f end

}
