package importtask.cs4224c;

import importtask.cs4224c.task.DropCollectionTask;
import importtask.cs4224c.task.ImportDataTask;
import importtask.cs4224c.util.Constant;
import importtask.cs4224c.util.ProjectConfig;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ImportTest {

    private final Logger logger = LoggerFactory.getLogger(ImportTest.class);

    private ProjectConfig config;

    @Before
    public void before() {
        System.setProperty(Constant.PROPERTY_KEY_ENV, Constant.ENV_TEST);
        config = ProjectConfig.getInstance().reload();
    }

    @Test
    public void testImportData() throws Exception {
        logger.info("Begin to import data.");

        logger.info("Run drop collection task");
        new DropCollectionTask().run();

        logger.info("Run Import Data Task");
        new ImportDataTask().run();

        validateDatabase();
    }

    private void validateDatabase() throws Exception {
        logger.info("Verifying collection size in DB");

        validateCollection("customer.csv");
        validateCollection("customer_partial.csv");
        validateCollection("customer_stats.csv");
        validateCollection("order_by_o_id.csv");
    }

    public void validateCollection(String tableFile) throws Exception {

    }

}
