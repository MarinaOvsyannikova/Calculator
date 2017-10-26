package ru.ovsyannikova.calculator.testutils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.ovsyannikova.calculator.testutils.requests.EvaluationTestRequest;

public class CalculatorTestUtils {

    private static final String CALCULATOR_URL = "/calculate";
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ResultActions postExpression(MockMvc mockMvc, Object postBody) throws Exception {
        return mockMvc
                .perform(MockMvcRequestBuilders
                        .post(CALCULATOR_URL)
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .content(OBJECT_MAPPER.writeValueAsBytes(postBody))
                );
    }

    public static ResultActions postExpressionWithStatus(MockMvc mockMvc, EvaluationTestRequest evaluationTestRequest, int status) throws Exception {
        return postExpression(mockMvc, evaluationTestRequest)
                .andExpect(MockMvcResultMatchers.status().is(status));
    }
}
