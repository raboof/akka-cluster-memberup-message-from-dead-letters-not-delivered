import akka.actor.*;
import akka.cluster.*;
import com.typesafe.config.*;

public class Main {

    public final static int DEFAULT_PORT = 2700;

    public static void main(String[] args) throws Exception {
        new Main().start();
    }

    private void start() throws Exception {

        Config conf = ConfigFactory.parseString("akka.cluster.seed-nodes=[\"akka.tcp://ClusterSystem@127.0.0.1:" + DEFAULT_PORT + "\"]")
                .withFallback(ConfigFactory.parseString("akka.remote.netty.tcp.port=" + DEFAULT_PORT))
                .withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ClusterSystem", conf);
        // ClusterMonitorFrame frame = new ClusterMonitorFrame(system, port);

        /* Create and display the form */
        //system.actorOf(Props.create(ClusterStatusWatcher.class, frame), "clusterStatusWatcherActor");
        //ActorRef clusterMember = system.actorOf(Props.create(ClusterMember.class), "clusterMemberActor");

        Runnable r = () -> {};

        Cluster.get(system).registerOnMemberUp(r);

        // EventQueue.invokeLater(() -> frame.setVisible(true));
    }


}
