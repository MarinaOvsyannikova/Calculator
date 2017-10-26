package ru.ovsyannikova.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.net.HttpURLConnection;

import ru.ovsyannikova.calculator.testutils.CalculatorTestUtils;
import ru.ovsyannikova.calculator.testutils.StatisticsTestUtils;
import ru.ovsyannikova.calculator.testutils.requests.EvaluationTestRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticsTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testShouldCountAdditionOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "+";
        String expr = "1 + 1";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    @Test
    public void testShouldCountSubtractionOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "-";
        String expr = "1 - 1";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    @Test
    public void testShouldCountMultiplicationOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "*";
        String expr = "1 * 1";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    @Test
    public void testShouldCountDivisionOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "/";
        String expr = "1 / 1";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    @Test
    public void testShouldCountPowerOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "^";
        String expr = "1 ^ 1";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    @Test
    public void testShouldCountGroupOperations() throws Exception {
        // TODO Create classes like CalculatorTestUtils for getting various statistics for operations
        // TODO WARNING! Be sure with GET requests to statistics. They may be cached cause of idempotent nature in accordance with RFC.
        String operation = "group";
        String expr = "(1)";
        getOpsStats(operation, 0);
        postExpr(expr);
        getOpsStats(operation, 1);
        postExpr(expr);
        getOpsStats(operation, 2);
    }

    private ResultActions getOpsStats(String operation, int count) throws Exception {
        return StatisticsTestUtils
                .getOperationStatisticsWithStatus(mockMvc, operation, HttpURLConnection.HTTP_OK)
                .andExpect(MockMvcResultMatchers.jsonPath("$.counter").value(count));
    }

    private ResultActions postExpr(String expr) throws Exception {
        return CalculatorTestUtils
                .postExpressionWithStatus(mockMvc, new EvaluationTestRequest(expr), HttpURLConnection.HTTP_OK);
    }
}

