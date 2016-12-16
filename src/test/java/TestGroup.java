import com.ihavecar.carmock.core.Frame;
import com.ihavecar.carmock.work.FrameWork;
import com.ihavecar.carmock.work.FrameWorkGroup;
import com.ihavecar.carmock.work.QueueFrameWorkGroup;
import com.ihavecar.carmock.work.SleepThreadQueueFrameWork;

/**
 * Created by lsz on 2016/12/2.
 */
public class TestGroup {
    public static void main(String[] args) {
        FrameWorkGroup  group = new QueueFrameWorkGroup(
               new SleepThreadQueueFrameWork(1,1000,"test-1"),
               new SleepThreadQueueFrameWork(2,2000,"test-2")
        );

        for (int i = 0; i < 6 ; i++){
            int finalI = i;
            group.putWorkFrame(new TestFrame(group,i));
        }
        group.start();
    }

}
class  TestFrame implements Frame{
    FrameWork work;
    int i = 0;
    public TestFrame(FrameWork work,int i ){
        this.work = work;
        this.i = i ;
    }

    @Override
    public void run() {
        System.out.println(i+"---"+Thread.currentThread().getName());
        this.work.putWorkFrame(this);
   }

    @Override
    public void setDoEntiry(Object entiry) {

    }
}
