import com.ihavecar.carmock.config.Global;

/**
 * Created by lsz on 2016/12/14.
 */
public class TestConfig {
    public static void main(String[] args) {
        System.out.println(Global.getConfig().getString("road.freepath"));
    }
}
