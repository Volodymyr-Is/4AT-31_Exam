package aqa_exam;

import org.testng.*;

public class CustomListener implements ITestListener, ISuiteListener, IExecutionListener {
//    ITestListener method (3, 4); ISuiteListener, IExecutionListener,IInvoke...(3, 6)


    @Override
    public void onStart(ITestContext context) {
        System.out.println("On Test Start: " + context.getName());
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Test Finish: " + context.getName());
        ITestListener.super.onFinish(context);
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("On Suite Start: " + suite.getName());
        ISuiteListener.super.onStart(suite);
    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("On Suite Finish: " + suite.getName());
        ISuiteListener.super.onFinish(suite);
    }

    @Override
    public void onExecutionStart() {
        System.out.println("On Execution Start");
        IExecutionListener.super.onExecutionStart();
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("On Execution Finish");
        IExecutionListener.super.onExecutionFinish();
    }
}
