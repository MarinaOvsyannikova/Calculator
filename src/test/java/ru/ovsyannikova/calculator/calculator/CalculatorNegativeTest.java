package ru.ovsyannikova.calculator.calculator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.ovsyannikova.calculator.testutils.CalculatorTestUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

@RunWith(Parameterized.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CalculatorNegativeTest {

    @Value("${local.server.port}")
    private int localServerPort;

    @Autowired
    WebApplicationContext webApplicationContext;

//    @Autowired
//    private TestRestTemplate testRestTemplate;

    @Parameterized.Parameter(value = 0)
    public Object expression;

    @Parameterized.Parameter(value = 1)
    public int expectedStatus;

//    private TestContextManager testContextManager;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        new TestContextManager(getClass()).prepareTestInstance(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Collection<Object[]> params = new ArrayList<>();

        // TODO on some wrong cases returns 200 cause Evaluator not throws exceptions!!!

        params.add(new Object[] {   null,             400      });
        params.add(new Object[] {   "",               400      });


        params.add(new Object[] {   "%",             400      });
        params.add(new Object[] {   "@",             400      });
        params.add(new Object[] {   "&",             400      });
        params.add(new Object[] {   "###",           400      });


        params.add(new Object[] {   ")",              400      });
        params.add(new Object[] {   "))",             400      });
        params.add(new Object[] {   "(",              400      });
        params.add(new Object[] {   "((",             400      });
        params.add(new Object[] {   ")(",             400      });
        params.add(new Object[] {   ")(()",           400      });
        params.add(new Object[] {   "+",              400      });
        params.add(new Object[] {   "-",              400      });
        params.add(new Object[] {   "*",              400      });
        params.add(new Object[] {   "/",              400      });
        params.add(new Object[] {   "^",              400      });
        params.add(new Object[] {   "()",             400      });


        params.add(new Object[] {   "1)",             400      });
        params.add(new Object[] {   "(1",             400      });

        params.add(new Object[] {   "*1",             400      });
        params.add(new Object[] {   "1*",             400      });

        params.add(new Object[] {   "/1",             400      });
        params.add(new Object[] {   "1/",             400      });
        params.add(new Object[] {   "1/0",            400      });

        params.add(new Object[] {   "^1",             400      });
        params.add(new Object[] {   "1^",             400      });

        return params;
    }


    @Test
    public void test() throws Exception {
        CalculatorTestUtils
                .postExpression(mockMvc, expression)
                .andDo(this::printResult)
                .andExpect(MockMvcResultMatchers.status().is(expectedStatus));
    }

    private void printResult(MvcResult result) throws UnsupportedEncodingException {
        String response = result.getResponse().getContentAsString();
        String error = result.getResponse().getErrorMessage();
        System.out.println("Result:");
        System.out.println(response);
        System.out.println(error);
    }
}

