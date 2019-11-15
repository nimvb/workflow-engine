package com.example;

import com.example.model.base.BaseContext;
import com.example.service.criteria.ExampledStringBasedCriteria;
import com.example.service.processors.ConvertToUppercaseProcess;
import com.example.service.processors.PrintProcess;
import com.example.service.processors.ReductionProcess;
import com.example.service.processors.route.DirectFlowRouteProcess;
import com.example.service.processors.route.IntegerRouteProcess;
import com.example.service.processors.route.StringRouteProcess;
import com.example.service.strategies.route.DirectFlowRouteStrategy;
import com.example.service.strategies.route.IntegerFlowRouteStrategy;
import com.example.service.strategies.route.StringFlowRouteStrategy;
import com.example.service.util.AsyncUtil;
import com.example.service.workflow.IntegerWorkflow;
import com.example.service.workflow.StringWorkflow;

/**
 * Hello workflow!
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        StringWorkflow mainStringWorkflow  = new StringWorkflow();
        StringWorkflow printStringWorkflow = new StringWorkflow();
        printStringWorkflow.getLastProcessor()
                .link(new PrintProcess());
        mainStringWorkflow.getLastProcessor()
                .link(new ConvertToUppercaseProcess())
                .link(new StringRouteProcess(new StringFlowRouteStrategy()))
                .linkFlow(printStringWorkflow, new ExampledStringBasedCriteria("1"))
                .linkFlow(printStringWorkflow, new ExampledStringBasedCriteria("24"));
        mainStringWorkflow.execute("1,2,23,24");


        IntegerWorkflow assignmentFlow = new IntegerWorkflow();
        IntegerWorkflow reductionFlow  = new IntegerWorkflow();
        IntegerWorkflow printFlow      = new IntegerWorkflow();

        // Reduction flow
        reductionFlow.getLastProcessor()
                .link(new ReductionProcess())
                .link(new DirectFlowRouteProcess(new DirectFlowRouteStrategy()))
                .linkFlow
                        (
                                assignmentFlow,
                                context -> context
                        );

        // Print flow
        printFlow.getLastProcessor()
                .link(new PrintProcess());

        // Start flow
        assignmentFlow.getLastProcessor()
                .link(new IntegerRouteProcess(new IntegerFlowRouteStrategy()))
                .linkFlow
                        (
                                reductionFlow,
                                cntx -> {
                                    BaseContext<Integer> context = (BaseContext<Integer>) cntx;
                                    if (context.getContextData() > 1) {
                                        context.setDropped(false);
                                        return context;
                                    }
                                    context.setDropped(true);
                                    return context;
                                }
                        )
                .linkFlow
                        (
                                printFlow,
                                cntx -> {
                                    BaseContext<Integer> context = (BaseContext<Integer>) cntx;
                                    context.setDropped(false);
                                    return context;
                                }
                        );
        assignmentFlow.execute(511000);

        Thread.sleep(1000 * 10);
        AsyncUtil.getInstance().getExecutor().shutdown();


    }
}
