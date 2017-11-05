package importtask.cs4224c.task;

import importtask.cs4224c.util.Collection;
import importtask.cs4224c.util.CollectionPool;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DropCollectionTask implements Runnable {

    private final Logger logger = LoggerFactory.getLogger(DropCollectionTask.class);

    public static void main(String[] args) {
        Runnable task = new DropCollectionTask();
        task.run();
    }


    @Override
    public void run() {
        CollectionPool.getInstance().getCollection(Collection.Customer).deleteMany(new Document());
        CollectionPool.getInstance().getCollection(Collection.District).deleteMany(new Document());
        CollectionPool.getInstance().getCollection(Collection.OrderItem).deleteMany(new Document());
        CollectionPool.getInstance().getCollection(Collection.Stock).deleteMany(new Document());
    }
}
