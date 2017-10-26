package ru.ovsyannikova.calculator.testutils;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class StatisticsTestUtils {

    private static final String OPERATIONS_STATISTICS_URL = "/operation";

    public static ResultActions getOperationStatistics(MockMvc mockMvc, String operation) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders
                        .get(OPERATIONS_STATISTICS_URL)
                        .param("operation", operation)
                );
    }

    public static ResultActions getOperationStatisticsWithStatus(MockMvc mockMvc, String operation, int expectedStatus) throws Exception {
        return getOperationStatistics(mockMvc, operation)
                .andExpect(MockMvcResultMatchers.status().is(expectedStatus));
    }
}
