package ru.ovsyannikova.calculator.service;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.springframework.stereotype.Service;
import ru.ovsyannikova.calculator.service.evaluator.SimpleCalcLexer;
import ru.ovsyannikova.calculator.service.evaluator.SimpleCalcParser;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;

@Service
public class Evaluator {

    public EvaluationResult getResult(String task) throws IOException {
        CodePointCharStream in = CharStreams.fromReader(new StringReader(task));
        SimpleCalcLexer lexer = new SimpleCalcLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        SimpleCalcParser parser = new SimpleCalcParser(commonTokenStream);
        EvaluationResult result = evaluate(task, parser);
        return prepareNumbers(result, commonTokenStream);
    }

    private EvaluationResult evaluate(String task, SimpleCalcParser parser) {
        return new EvaluationResult(task, parser.eval().value, new HashMap<>());
    }

    private EvaluationResult prepareNumbers(EvaluationResult result, CommonTokenStream commonTokenStream) {
        HashMap<Number, Integer> hashMap = new HashMap<>();
        List<Token> array = commonTokenStream.getTokens();
        for (Token o: array) {
            if (o.getType() == 9) {
                Double number = Double.parseDouble(o.getText());
                if(hashMap.get(number) == null)
                    hashMap.put(number, 1);
                Integer count = hashMap.get(number);
                hashMap.put(number, count + 1);
            }
        }
        result.setNumberAmounts(hashMap);
        return result;
    }
}
