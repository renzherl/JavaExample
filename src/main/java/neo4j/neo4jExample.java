package neo4j;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import java.io.File;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.ResourceIterable;

/**
 * Created by mi on 2018/7/16.
 */
public class neo4jExample {
    public static void main(String[] args){
        GraphDatabaseFactory dbFactory = new GraphDatabaseFactory();
        GraphDatabaseService db = dbFactory.newEmbeddedDatabase(new File("d:/TPNeo4jDB"));
        try(Transaction tx = db.beginTx()){

            Node javaNode = db.createNode(Tutorials.JAVA);
            javaNode.setProperty("TutorialID", "JAVA001");
            javaNode.setProperty("Title", "Learn Java");
            javaNode.setProperty("NoOfChapters", "25");
            javaNode.setProperty("Status", "Completed");

            Node scalaNode = db.createNode(Tutorials.SCALA);
            scalaNode.setProperty("TutorialID", "SCALA001");
            scalaNode.setProperty("Title", "Learn Scala");
            scalaNode.setProperty("NoOfChapters", "20");
            scalaNode.setProperty("Status", "Completed");

            Relationship relationship = javaNode.createRelationshipTo
                    (scalaNode,TutorialRelationships.JVM_LANGIAGES);
            relationship.setProperty("Id","1234");
            relationship.setProperty("OOPS","YES");
            relationship.setProperty("FP","YES");

            tx.success();
        }
        System.out.println("Create successfully");

        try(Transaction tx = db.beginTx()){
            ResourceIterable<Node> nIt = db.getAllNodes();
            nIt.forEach((node) -> showNodes(node));
            tx.success();
        }
        System.out.println("Show successfully");
        db.shutdown();
    }

    private static void showNodes(Node node){
        System.out.print(node.getId() + "--");
        node.getLabels().forEach((label) -> System.out.print(label + "--"));
        node.getAllProperties().entrySet().forEach((entity) -> {
            System.out.print(entity.getKey() + "--");
            System.out.println(entity.getValue());
        });
        node.getRelationships().forEach((rel) -> System.out.println(rel));
    }
}
