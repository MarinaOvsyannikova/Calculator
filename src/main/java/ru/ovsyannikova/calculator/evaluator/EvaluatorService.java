package ru.ovsyannikova.calculator.evaluator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class EvaluatorService {
    public static double evaluate(String task) {
        ANTLRInputStream in = new ANTLRInputStream(task);
        SimpleCalcLexer lexer = new SimpleCalcLexer(in);
        CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
        SimpleCalcParser parser = new SimpleCalcParser(commonTokenStream);
        return parser.eval().value;
    }
}
