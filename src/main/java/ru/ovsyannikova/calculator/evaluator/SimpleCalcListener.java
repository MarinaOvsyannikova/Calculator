// Generated from /home/andromeda/IdeaProjects/Calculator/src/main/java/ru/ovsyannikova/calculator/evaluator/SimpleCalc.g4 by ANTLR 4.7
package ru.ovsyannikova.calculator.evaluator;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleCalcParser}.
 */
public interface SimpleCalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#eval}.
	 * @param ctx the parse tree
	 */
	void enterEval(SimpleCalcParser.EvalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#eval}.
	 * @param ctx the parse tree
	 */
	void exitEval(SimpleCalcParser.EvalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExp(SimpleCalcParser.AdditionExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#additionExp}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExp(SimpleCalcParser.AdditionExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void enterMultiplyExp(SimpleCalcParser.MultiplyExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#multiplyExp}.
	 * @param ctx the parse tree
	 */
	void exitMultiplyExp(SimpleCalcParser.MultiplyExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#powerExp}.
	 * @param ctx the parse tree
	 */
	void enterPowerExp(SimpleCalcParser.PowerExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#powerExp}.
	 * @param ctx the parse tree
	 */
	void exitPowerExp(SimpleCalcParser.PowerExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExp(SimpleCalcParser.UnaryExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#unaryExp}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExp(SimpleCalcParser.UnaryExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCalcParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void enterAtomExp(SimpleCalcParser.AtomExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCalcParser#atomExp}.
	 * @param ctx the parse tree
	 */
	void exitAtomExp(SimpleCalcParser.AtomExpContext ctx);
}