package aqa_exam.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.*;

public class CustomListener implements ITestListener, ISuiteListener, IExecutionListener {

    private static final Logger LOGGER = LogManager.getLogger(CustomListener.class);

    @Override
    public void onStart(ITestContext context) {
        LOGGER.info("On Test Start: " + context.getName());
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        LOGGER.info("On Test Finish: " + context.getName());
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ISuite suite) {
        LOGGER.info("On Suite Start: " + suite.getName());
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void onFinish(ISuite suite) {
        LOGGER.info("On Suite Finish: " + suite.getName());
        ISuiteListener.super.onFinish(suite);
    }

    @Override
    public void onExecutionStart() {
        LOGGER.info("On Execution Start");
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onExecutionFinish() {
        LOGGER.info("On Execution Finish");
        IExecutionListener.super.onExecutionFinish();
    }
}
