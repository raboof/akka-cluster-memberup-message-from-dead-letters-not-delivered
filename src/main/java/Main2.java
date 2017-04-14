import akka.actor.*;
import akka.cluster.*;
import com.typesafe.config.*;
import javax.swing.JOptionPane;

public class Main2 {

    public static void main(String[] args) throws Exception {
        new Main2().start();
    }

    private void start() throws Exception {

        Config conf = ConfigFactory.parseString("akka.cluster.seed-nodes=[\"akka.tcp://ClusterSystem@127.0.0.1:" + Main.DEFAULT_PORT + "\"]")
                .withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("ClusterSystem", conf);
        // ClusterMonitorFrame frame = new ClusterMonitorFrame(system, port);

        /* Create and display the form */
        //system.actorOf(Props.create(ClusterStatusWatcher.class, frame), "clusterStatusWatcherActor");
        //ActorRef clusterMember = system.actorOf(Props.create(ClusterMember.class), "clusterMemberActor");

        Runnable r = () -> {};

        Cluster.get(system).registerOnMemberUp(r);
    }
}
