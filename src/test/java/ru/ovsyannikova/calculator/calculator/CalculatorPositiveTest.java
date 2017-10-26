package ru.ovsyannikova.calculator.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.ovsyannikova.calculator.service.Evaluator;
import ru.ovsyannikova.calculator.testutils.CalculatorTestUtils;
import ru.ovsyannikova.calculator.testutils.requests.EvaluationTestRequest;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorPositiveTest {


    @Autowired
    WebApplicationContext webApplicationContext;

    @Autowired
    private static Evaluator evaluator;

    private MockMvc mockMvc;

    @Parameterized.Parameter()
    public String expression;

    @Parameterized.Parameter(value = 1)
    public int expectedStatus;

    @Parameterized.Parameter(value = 2)
    public Number expectedResult;

    @Before
    public void setUp() throws Exception {
        new TestContextManager(getClass()).prepareTestInstance(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();

        // TODO add unary '+'
        // TODO add Returning "Number", not only double, and change all integer cases as expected returning integers
        // TODO After adding Number add few cases with doubles and mixed values

        // simple
        params.add(new Object[] { "1",                      200,   1.0   });
        params.add(new Object[] {   "4.5",                  200,    4.5  });

        // grouping
        params.add(new Object[] { "(1)",                    200,   1.0   });
        params.add(new Object[] { "((1))",                  200,   1.0   });
        params.add(new Object[] { "(((1)))",                200,   1.0   });
        params.add(new Object[] {"((3.7))",                 200,   3.7   });


        // unary operators
        params.add(new Object[] { "-1",                     200,   -1.0  });
        params.add(new Object[] { "--1",                    200,   1.0   });
        params.add(new Object[] { "---1",                   200,   -1.0  });
        params.add(new Object[] { "+1",                     200,   1.0   });
        params.add(new Object[] { "++1",                    200,   1.0   });
        params.add(new Object[] { "+++1",                   200,   1.0   });
        params.add(new Object[] { "-+-1",                   200,   1.0   });
        params.add(new Object[] { "+-+1",                   200,   -1.0  });

        // addition
        params.add(new Object[] { "1+1",                    200,   2.0   });
        params.add(new Object[] { "1+2",                    200,   3.0   });
        params.add(new Object[] { "1+2+3",                  200,   6.0   });
        params.add(new Object[] {"2.15+2.15",               200,   4.3   });

        // multiplication
        params.add(new Object[] { "1*2",                    200,   2.0   });
        params.add(new Object[] { "1*2*3",                  200,   6.0   });
        params.add(new Object[] {"2.5*2.5",                 200,   6.25  });
        params.add(new Object[] {"2.5*2.5*2.5",             200,   15.625});


        // division
        params.add(new Object[] { "2/1",                    200,   2.0   });
        params.add(new Object[] { "2/2",                    200,   1.0   });
        params.add(new Object[] { "4/2",                    200,   2.0   });
        params.add(new Object[] { "12/2/3",                 200,   2.0   });
        params.add(new Object[] { "3.5/2)",                 200,   1.75  });

        // power
        params.add(new Object[] { "2^2",                    200,   4.0   });
        params.add(new Object[] { "2^2^3",                  200,   64.0  });
        params.add(new Object[] { "(2+1)^(1+1)",            200,   9      });
        params.add(new Object[] { "2^-2",                   200,   0.25 });

        // priority
        params.add(new Object[] { "2+3*10/5-5^2",          200,  -17.0  });
        params.add(new Object[] { "(2+((3*10)/5))-(5^2)",  200,  -17.0  });

        // base example cases from task itself
        params.add(new Object[] { "(-7*8+9-(9/4.5))^2",    200,   2401  });
        params.add(new Object[] { "9*1+4.5",               200,   13.5  });

        return params;
    }


    @Test
    public void test() throws Exception {
        CalculatorTestUtils
                .postExpression(mockMvc, new EvaluationTestRequest(expression))
                .andDo(this::printResult)
                .andExpect(MockMvcResultMatchers.status().is(expectedStatus))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(expectedResult));

    }

    private void printResult(MvcResult result) throws UnsupportedEncodingException {
        String response = result.getResponse().getContentAsString();
        String error = result.getResponse().getErrorMessage();
        System.out.println("Expression:");
        System.out.println(String.format("'%s'", expression));
        System.out.println("Result:");
        System.out.println(response);
        System.out.println(error);
    }
}

