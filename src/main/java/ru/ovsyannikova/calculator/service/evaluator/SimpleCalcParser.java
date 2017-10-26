// Generated from /home/andromeda/IdeaProjects/Calculator/src/main/java/ru/ovsyannikova/calculator/service/evaluator/SimpleCalc.g4 by ANTLR 4.7
package ru.ovsyannikova.calculator.service.evaluator;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleCalcParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, DOT=3, DIV=4, PLUS=5, MINUS=6, MULT=7, POWER=8, NUMBER=9, 
		DIGIT=10, WS=11;
	public static final int
		RULE_eval = 0, RULE_additionExp = 1, RULE_multiplyExp = 2, RULE_powerExp = 3, 
		RULE_unaryExp = 4, RULE_atomExp = 5;
	public static final String[] ruleNames = {
		"eval", "additionExp", "multiplyExp", "powerExp", "unaryExp", "atomExp"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'.'", "'/'", "'+'", "'-'", "'*'", "'^'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "LPAREN", "RPAREN", "DOT", "DIV", "PLUS", "MINUS", "MULT", "POWER", 
		"NUMBER", "DIGIT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "SimpleCalc.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleCalcParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EvalContext extends ParserRuleContext {
		public double value;
		public AdditionExpContext exp;
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitEval(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_eval);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			((EvalContext)_localctx).exp = additionExp();
			((EvalContext)_localctx).value =  ((EvalContext)_localctx).exp.value;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AdditionExpContext extends ParserRuleContext {
		public double value;
		public MultiplyExpContext m1;
		public MultiplyExpContext m2;
		public List<MultiplyExpContext> multiplyExp() {
			return getRuleContexts(MultiplyExpContext.class);
		}
		public MultiplyExpContext multiplyExp(int i) {
			return getRuleContext(MultiplyExpContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(SimpleCalcParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(SimpleCalcParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(SimpleCalcParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(SimpleCalcParser.MINUS, i);
		}
		public AdditionExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterAdditionExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitAdditionExp(this);
		}
	}

	public final AdditionExpContext additionExp() throws RecognitionException {
		AdditionExpContext _localctx = new AdditionExpContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_additionExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(15);
			((AdditionExpContext)_localctx).m1 = multiplyExp();
			((AdditionExpContext)_localctx).value =   ((AdditionExpContext)_localctx).m1.value;
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS || _la==MINUS) {
				{
				setState(25);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case PLUS:
					{
					setState(17);
					match(PLUS);
					setState(18);
					((AdditionExpContext)_localctx).m2 = multiplyExp();
					_localctx.value += ((AdditionExpContext)_localctx).m2.value;
					}
					break;
				case MINUS:
					{
					setState(21);
					match(MINUS);
					setState(22);
					((AdditionExpContext)_localctx).m2 = multiplyExp();
					_localctx.value -= ((AdditionExpContext)_localctx).m2.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiplyExpContext extends ParserRuleContext {
		public double value;
		public PowerExpContext a1;
		public PowerExpContext a2;
		public List<PowerExpContext> powerExp() {
			return getRuleContexts(PowerExpContext.class);
		}
		public PowerExpContext powerExp(int i) {
			return getRuleContext(PowerExpContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(SimpleCalcParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(SimpleCalcParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(SimpleCalcParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(SimpleCalcParser.DIV, i);
		}
		public MultiplyExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplyExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterMultiplyExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitMultiplyExp(this);
		}
	}

	public final MultiplyExpContext multiplyExp() throws RecognitionException {
		MultiplyExpContext _localctx = new MultiplyExpContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_multiplyExp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			((MultiplyExpContext)_localctx).a1 = powerExp(0);
			((MultiplyExpContext)_localctx).value =   ((MultiplyExpContext)_localctx).a1.value;
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DIV || _la==MULT) {
				{
				setState(40);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MULT:
					{
					setState(32);
					match(MULT);
					setState(33);
					((MultiplyExpContext)_localctx).a2 = powerExp(0);
					_localctx.value *= ((MultiplyExpContext)_localctx).a2.value;
					}
					break;
				case DIV:
					{
					setState(36);
					match(DIV);
					setState(37);
					((MultiplyExpContext)_localctx).a2 = powerExp(0);
					_localctx.value /= ((MultiplyExpContext)_localctx).a2.value;
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PowerExpContext extends ParserRuleContext {
		public double value;
		public PowerExpContext p;
		public UnaryExpContext u1;
		public UnaryExpContext u2;
		public UnaryExpContext u;
		public TerminalNode POWER() { return getToken(SimpleCalcParser.POWER, 0); }
		public List<UnaryExpContext> unaryExp() {
			return getRuleContexts(UnaryExpContext.class);
		}
		public UnaryExpContext unaryExp(int i) {
			return getRuleContext(UnaryExpContext.class,i);
		}
		public PowerExpContext powerExp() {
			return getRuleContext(PowerExpContext.class,0);
		}
		public PowerExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_powerExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterPowerExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitPowerExp(this);
		}
	}

	public final PowerExpContext powerExp() throws RecognitionException {
		return powerExp(0);
	}

	private PowerExpContext powerExp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PowerExpContext _localctx = new PowerExpContext(_ctx, _parentState);
		PowerExpContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_powerExp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(46);
				((PowerExpContext)_localctx).u1 = unaryExp();
				((PowerExpContext)_localctx).value =   ((PowerExpContext)_localctx).u1.value;
				setState(48);
				match(POWER);
				setState(49);
				((PowerExpContext)_localctx).u2 = unaryExp();
				((PowerExpContext)_localctx).value =  Math.pow(((PowerExpContext)_localctx).u1.value, ((PowerExpContext)_localctx).u2.value);
				}
				break;
			case 2:
				{
				setState(52);
				((PowerExpContext)_localctx).u = unaryExp();
				((PowerExpContext)_localctx).value =   ((PowerExpContext)_localctx).u.value;
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(65);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PowerExpContext(_parentctx, _parentState);
					_localctx.p = _prevctx;
					_localctx.p = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_powerExp);
					setState(57);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					((PowerExpContext)_localctx).value =   ((PowerExpContext)_localctx).p.value;
					setState(59);
					match(POWER);
					setState(60);
					((PowerExpContext)_localctx).u = unaryExp();
					((PowerExpContext)_localctx).value =  Math.pow(((PowerExpContext)_localctx).p.value, ((PowerExpContext)_localctx).u.value);
					}
					} 
				}
				setState(67);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryExpContext extends ParserRuleContext {
		public double value;
		public AtomExpContext a;
		public UnaryExpContext u;
		public TerminalNode MINUS() { return getToken(SimpleCalcParser.MINUS, 0); }
		public AtomExpContext atomExp() {
			return getRuleContext(AtomExpContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(SimpleCalcParser.PLUS, 0); }
		public UnaryExpContext unaryExp() {
			return getRuleContext(UnaryExpContext.class,0);
		}
		public UnaryExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterUnaryExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitUnaryExp(this);
		}
	}

	public final UnaryExpContext unaryExp() throws RecognitionException {
		UnaryExpContext _localctx = new UnaryExpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unaryExp);
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(MINUS);
				setState(69);
				((UnaryExpContext)_localctx).a = atomExp();
				((UnaryExpContext)_localctx).value =  -((UnaryExpContext)_localctx).a.value;
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				match(PLUS);
				setState(73);
				((UnaryExpContext)_localctx).a = atomExp();
				((UnaryExpContext)_localctx).value =  ((UnaryExpContext)_localctx).a.value;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				((UnaryExpContext)_localctx).a = atomExp();
				((UnaryExpContext)_localctx).value =  ((UnaryExpContext)_localctx).a.value;
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(MINUS);
				setState(80);
				((UnaryExpContext)_localctx).u = unaryExp();
				((UnaryExpContext)_localctx).value =  -((UnaryExpContext)_localctx).u.value;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83);
				match(PLUS);
				setState(84);
				((UnaryExpContext)_localctx).u = unaryExp();
				((UnaryExpContext)_localctx).value =  ((UnaryExpContext)_localctx).u.value;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtomExpContext extends ParserRuleContext {
		public double value;
		public Token n;
		public AdditionExpContext exp;
		public TerminalNode NUMBER() { return getToken(SimpleCalcParser.NUMBER, 0); }
		public TerminalNode LPAREN() { return getToken(SimpleCalcParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(SimpleCalcParser.RPAREN, 0); }
		public AdditionExpContext additionExp() {
			return getRuleContext(AdditionExpContext.class,0);
		}
		public AtomExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).enterAtomExp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SimpleCalcListener ) ((SimpleCalcListener)listener).exitAtomExp(this);
		}
	}

	public final AtomExpContext atomExp() throws RecognitionException {
		AtomExpContext _localctx = new AtomExpContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_atomExp);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				((AtomExpContext)_localctx).n = match(NUMBER);
				((AtomExpContext)_localctx).value =  Double.parseDouble((((AtomExpContext)_localctx).n!=null?((AtomExpContext)_localctx).n.getText():null));
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				match(LPAREN);
				setState(92);
				((AtomExpContext)_localctx).exp = additionExp();
				setState(93);
				match(RPAREN);
				((AtomExpContext)_localctx).value =  ((AtomExpContext)_localctx).exp.value;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return powerExp_sempred((PowerExpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean powerExp_sempred(PowerExpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\re\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\7\4+\n\4\f\4\16\4.\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\5\5:\n\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E\13\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\6\5\6Z\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7c\n\7\3\7\2\3\b\b\2\4\6\b\n"+
		"\f\2\2\2i\2\16\3\2\2\2\4\21\3\2\2\2\6 \3\2\2\2\b9\3\2\2\2\nY\3\2\2\2\f"+
		"b\3\2\2\2\16\17\5\4\3\2\17\20\b\2\1\2\20\3\3\2\2\2\21\22\5\6\4\2\22\35"+
		"\b\3\1\2\23\24\7\7\2\2\24\25\5\6\4\2\25\26\b\3\1\2\26\34\3\2\2\2\27\30"+
		"\7\b\2\2\30\31\5\6\4\2\31\32\b\3\1\2\32\34\3\2\2\2\33\23\3\2\2\2\33\27"+
		"\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3\2\2\2\36\5\3\2\2\2\37\35"+
		"\3\2\2\2 !\5\b\5\2!,\b\4\1\2\"#\7\t\2\2#$\5\b\5\2$%\b\4\1\2%+\3\2\2\2"+
		"&\'\7\6\2\2\'(\5\b\5\2()\b\4\1\2)+\3\2\2\2*\"\3\2\2\2*&\3\2\2\2+.\3\2"+
		"\2\2,*\3\2\2\2,-\3\2\2\2-\7\3\2\2\2.,\3\2\2\2/\60\b\5\1\2\60\61\5\n\6"+
		"\2\61\62\b\5\1\2\62\63\7\n\2\2\63\64\5\n\6\2\64\65\b\5\1\2\65:\3\2\2\2"+
		"\66\67\5\n\6\2\678\b\5\1\28:\3\2\2\29/\3\2\2\29\66\3\2\2\2:C\3\2\2\2;"+
		"<\f\4\2\2<=\b\5\1\2=>\7\n\2\2>?\5\n\6\2?@\b\5\1\2@B\3\2\2\2A;\3\2\2\2"+
		"BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\7\b\2\2GH\5\f\7"+
		"\2HI\b\6\1\2IZ\3\2\2\2JK\7\7\2\2KL\5\f\7\2LM\b\6\1\2MZ\3\2\2\2NO\5\f\7"+
		"\2OP\b\6\1\2PZ\3\2\2\2QR\7\b\2\2RS\5\n\6\2ST\b\6\1\2TZ\3\2\2\2UV\7\7\2"+
		"\2VW\5\n\6\2WX\b\6\1\2XZ\3\2\2\2YF\3\2\2\2YJ\3\2\2\2YN\3\2\2\2YQ\3\2\2"+
		"\2YU\3\2\2\2Z\13\3\2\2\2[\\\7\13\2\2\\c\b\7\1\2]^\7\3\2\2^_\5\4\3\2_`"+
		"\7\4\2\2`a\b\7\1\2ac\3\2\2\2b[\3\2\2\2b]\3\2\2\2c\r\3\2\2\2\n\33\35*,"+
		"9CYb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}