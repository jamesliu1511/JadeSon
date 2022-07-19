// Generated from JPath.g4 by ANTLR 4.10.1

	package com.jade.path.antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JPathParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, Literal=23, FLOAT=24, 
		INT=25, WS=26, NCName=27, Number=28;
	public static final int
		RULE_specialPath = 0, RULE_searchPath = 1, RULE_step = 2, RULE_all = 3, 
		RULE_predicate = 4, RULE_arrayExpr = 5, RULE_functionFetch = 6, RULE_fetchName = 7, 
		RULE_existCheck = 8, RULE_numSelect = 9, RULE_rangeSelect = 10, RULE_rangeExpr = 11, 
		RULE_chooseSelect = 12, RULE_conditionSelect = 13, RULE_conditionExpr = 14, 
		RULE_funValue = 15, RULE_funValueName = 16, RULE_subSearchPath = 17, RULE_functionCheck = 18, 
		RULE_functionName = 19, RULE_functionNodeName = 20, RULE_functionParam = 21, 
		RULE_variableReference = 22, RULE_numValue = 23;
	private static String[] makeRuleNames() {
		return new String[] {
			"specialPath", "searchPath", "step", "all", "predicate", "arrayExpr", 
			"functionFetch", "fetchName", "existCheck", "numSelect", "rangeSelect", 
			"rangeExpr", "chooseSelect", "conditionSelect", "conditionExpr", "funValue", 
			"funValueName", "subSearchPath", "functionCheck", "functionName", "functionNodeName", 
			"functionParam", "variableReference", "numValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'*'", "'['", "']'", "'?'", "'{'", "'}'", "'('", "','", "')'", 
			"'ft:'", "'@'", "'<'", "'>'", "'||'", "'&&'", "'<='", "'>='", "'=='", 
			"'fv:'", "'/'", "'fn:'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "Literal", 
			"FLOAT", "INT", "WS", "NCName", "Number"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "JPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JPathParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SpecialPathContext extends ParserRuleContext {
		public SearchPathContext searchPath() {
			return getRuleContext(SearchPathContext.class,0);
		}
		public StepContext step() {
			return getRuleContext(StepContext.class,0);
		}
		public SpecialPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitSpecialPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialPathContext specialPath() throws RecognitionException {
		SpecialPathContext _localctx = new SpecialPathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_specialPath);
		try {
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				searchPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				step();
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

	public static class SearchPathContext extends ParserRuleContext {
		public StepContext step() {
			return getRuleContext(StepContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public SearchPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_searchPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchPathContext searchPath() throws RecognitionException {
		SearchPathContext _localctx = new SearchPathContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_searchPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			step();
			setState(53);
			predicate();
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

	public static class StepContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public TerminalNode Literal() { return getToken(JPathParser.Literal, 0); }
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_step);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(55);
				match(NCName);
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(56);
				match(Literal);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				all();
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

	public static class AllContext extends ParserRuleContext {
		public AllContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_all; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(T__0);
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

	public static class PredicateContext extends ParserRuleContext {
		public ArrayExprContext arrayExpr() {
			return getRuleContext(ArrayExprContext.class,0);
		}
		public ConditionSelectContext conditionSelect() {
			return getRuleContext(ConditionSelectContext.class,0);
		}
		public ChooseSelectContext chooseSelect() {
			return getRuleContext(ChooseSelectContext.class,0);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_predicate);
		try {
			setState(72);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62);
				match(T__1);
				setState(63);
				arrayExpr();
				setState(64);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(T__3);
				setState(67);
				conditionSelect();
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 3);
				{
				setState(68);
				match(T__4);
				setState(69);
				chooseSelect();
				setState(70);
				match(T__5);
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

	public static class ArrayExprContext extends ParserRuleContext {
		public RangeSelectContext rangeSelect() {
			return getRuleContext(RangeSelectContext.class,0);
		}
		public NumSelectContext numSelect() {
			return getRuleContext(NumSelectContext.class,0);
		}
		public ConditionSelectContext conditionSelect() {
			return getRuleContext(ConditionSelectContext.class,0);
		}
		public FunctionFetchContext functionFetch() {
			return getRuleContext(FunctionFetchContext.class,0);
		}
		public ExistCheckContext existCheck() {
			return getRuleContext(ExistCheckContext.class,0);
		}
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public ArrayExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_arrayExpr);
		try {
			setState(80);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				rangeSelect();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				numSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				conditionSelect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				functionFetch();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				existCheck();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
				all();
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

	public static class FunctionFetchContext extends ParserRuleContext {
		public FetchNameContext fetchName() {
			return getRuleContext(FetchNameContext.class,0);
		}
		public List<FunctionNodeNameContext> functionNodeName() {
			return getRuleContexts(FunctionNodeNameContext.class);
		}
		public FunctionNodeNameContext functionNodeName(int i) {
			return getRuleContext(FunctionNodeNameContext.class,i);
		}
		public FunctionFetchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionFetch; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunctionFetch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionFetchContext functionFetch() throws RecognitionException {
		FunctionFetchContext _localctx = new FunctionFetchContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionFetch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			fetchName();
			setState(83);
			match(T__6);
			setState(84);
			functionNodeName();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(85);
				match(T__7);
				setState(86);
				functionNodeName();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(T__8);
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

	public static class FetchNameContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public FetchNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFetchName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchNameContext fetchName() throws RecognitionException {
		FetchNameContext _localctx = new FetchNameContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_fetchName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__9);
			setState(95);
			match(NCName);
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

	public static class ExistCheckContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public ExistCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existCheck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitExistCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistCheckContext existCheck() throws RecognitionException {
		ExistCheckContext _localctx = new ExistCheckContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_existCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__10);
			setState(98);
			match(NCName);
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

	public static class NumSelectContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(JPathParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathParser.INT, i);
		}
		public NumSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitNumSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumSelectContext numSelect() throws RecognitionException {
		NumSelectContext _localctx = new NumSelectContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_numSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(INT);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(101);
				match(T__7);
				setState(102);
				match(INT);
				}
				}
				setState(107);
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

	public static class RangeSelectContext extends ParserRuleContext {
		public List<RangeExprContext> rangeExpr() {
			return getRuleContexts(RangeExprContext.class);
		}
		public RangeExprContext rangeExpr(int i) {
			return getRuleContext(RangeExprContext.class,i);
		}
		public RangeSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitRangeSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeSelectContext rangeSelect() throws RecognitionException {
		RangeSelectContext _localctx = new RangeSelectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rangeSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			rangeExpr();
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(109);
				match(T__7);
				setState(110);
				rangeExpr();
				}
				}
				setState(115);
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

	public static class RangeExprContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(JPathParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathParser.INT, i);
		}
		public RangeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitRangeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeExprContext rangeExpr() throws RecognitionException {
		RangeExprContext _localctx = new RangeExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rangeExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(T__11);
			setState(117);
			match(INT);
			setState(118);
			match(T__7);
			setState(119);
			match(INT);
			setState(120);
			match(T__12);
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

	public static class ChooseSelectContext extends ParserRuleContext {
		public List<TerminalNode> NCName() { return getTokens(JPathParser.NCName); }
		public TerminalNode NCName(int i) {
			return getToken(JPathParser.NCName, i);
		}
		public ChooseSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chooseSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitChooseSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseSelectContext chooseSelect() throws RecognitionException {
		ChooseSelectContext _localctx = new ChooseSelectContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_chooseSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(NCName);
			setState(127);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(123);
				match(T__7);
				setState(124);
				match(NCName);
				}
				}
				setState(129);
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

	public static class ConditionSelectContext extends ParserRuleContext {
		public Token op;
		public List<ConditionExprContext> conditionExpr() {
			return getRuleContexts(ConditionExprContext.class);
		}
		public ConditionExprContext conditionExpr(int i) {
			return getRuleContext(ConditionExprContext.class,i);
		}
		public ConditionSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitConditionSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionSelectContext conditionSelect() throws RecognitionException {
		ConditionSelectContext _localctx = new ConditionSelectContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_conditionSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			conditionExpr();
			setState(135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__13 || _la==T__14) {
				{
				{
				setState(131);
				((ConditionSelectContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
					((ConditionSelectContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(132);
				conditionExpr();
				}
				}
				setState(137);
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

	public static class ConditionExprContext extends ParserRuleContext {
		public Token op;
		public NumValueContext numValue() {
			return getRuleContext(NumValueContext.class,0);
		}
		public SubSearchPathContext subSearchPath() {
			return getRuleContext(SubSearchPathContext.class,0);
		}
		public FunValueContext funValue() {
			return getRuleContext(FunValueContext.class,0);
		}
		public FunctionCheckContext functionCheck() {
			return getRuleContext(FunctionCheckContext.class,0);
		}
		public ConditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conditionExpr);
		int _la;
		try {
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__18:
			case Literal:
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case Literal:
				case NCName:
					{
					setState(138);
					subSearchPath();
					}
					break;
				case T__18:
					{
					setState(139);
					funValue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(142);
				((ConditionExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__15) | (1L << T__16) | (1L << T__17))) != 0)) ) {
					((ConditionExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(143);
				numValue();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				functionCheck();
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

	public static class FunValueContext extends ParserRuleContext {
		public FunValueNameContext funValueName() {
			return getRuleContext(FunValueNameContext.class,0);
		}
		public FunctionNodeNameContext functionNodeName() {
			return getRuleContext(FunctionNodeNameContext.class,0);
		}
		public FunValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueContext funValue() throws RecognitionException {
		FunValueContext _localctx = new FunValueContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_funValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			funValueName();
			setState(149);
			match(T__6);
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(150);
				functionNodeName();
				}
			}

			setState(153);
			match(T__8);
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

	public static class FunValueNameContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public FunValueNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funValueName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunValueName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueNameContext funValueName() throws RecognitionException {
		FunValueNameContext _localctx = new FunValueNameContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_funValueName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			match(T__18);
			setState(156);
			match(NCName);
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

	public static class SubSearchPathContext extends ParserRuleContext {
		public List<SpecialPathContext> specialPath() {
			return getRuleContexts(SpecialPathContext.class);
		}
		public SpecialPathContext specialPath(int i) {
			return getRuleContext(SpecialPathContext.class,i);
		}
		public SubSearchPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subSearchPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitSubSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubSearchPathContext subSearchPath() throws RecognitionException {
		SubSearchPathContext _localctx = new SubSearchPathContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_subSearchPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			specialPath();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(159);
				match(T__19);
				setState(160);
				specialPath();
				}
				}
				setState(165);
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

	public static class FunctionCheckContext extends ParserRuleContext {
		public FunctionNameContext functionName() {
			return getRuleContext(FunctionNameContext.class,0);
		}
		public List<FunctionParamContext> functionParam() {
			return getRuleContexts(FunctionParamContext.class);
		}
		public FunctionParamContext functionParam(int i) {
			return getRuleContext(FunctionParamContext.class,i);
		}
		public FunctionNodeNameContext functionNodeName() {
			return getRuleContext(FunctionNodeNameContext.class,0);
		}
		public FunctionCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCheck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunctionCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCheckContext functionCheck() throws RecognitionException {
		FunctionCheckContext _localctx = new FunctionCheckContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_functionCheck);
		int _la;
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(166);
				functionName();
				setState(167);
				match(T__6);
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << Literal) | (1L << Number))) != 0)) {
					{
					setState(168);
					functionParam();
					setState(173);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__7) {
						{
						{
						setState(169);
						match(T__7);
						setState(170);
						functionParam();
						}
						}
						setState(175);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(178);
				match(T__8);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180);
				functionName();
				setState(181);
				match(T__6);
				setState(182);
				functionNodeName();
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(183);
					match(T__7);
					setState(184);
					functionParam();
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(190);
				match(T__8);
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

	public static class FunctionNameContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__20);
			setState(195);
			match(NCName);
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

	public static class FunctionNodeNameContext extends ParserRuleContext {
		public SubSearchPathContext subSearchPath() {
			return getRuleContext(SubSearchPathContext.class,0);
		}
		public FunctionNodeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionNodeName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunctionNodeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNodeNameContext functionNodeName() throws RecognitionException {
		FunctionNodeNameContext _localctx = new FunctionNodeNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionNodeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			match(T__10);
			setState(198);
			subSearchPath();
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

	public static class FunctionParamContext extends ParserRuleContext {
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public TerminalNode Literal() { return getToken(JPathParser.Literal, 0); }
		public TerminalNode Number() { return getToken(JPathParser.Number, 0); }
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionParam);
		try {
			setState(203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				variableReference();
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(Literal);
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
				match(Number);
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

	public static class VariableReferenceContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathParser.NCName, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__21);
			setState(206);
			match(NCName);
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

	public static class NumValueContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(JPathParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JPathParser.INT, 0); }
		public NumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathVisitor ) return ((JPathVisitor<? extends T>)visitor).visitNumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumValueContext numValue() throws RecognitionException {
		NumValueContext _localctx = new NumValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_numValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==INT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static final String _serializedATN =
		"\u0004\u0001\u001c\u00d3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0001\u0000\u0001"+
		"\u0000\u0003\u00003\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004I\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005Q\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006X\b\u0006\n\u0006\f\u0006[\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\t\u0001\t\u0001\t\u0005\th\b\t\n\t\f\tk\t\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\np\b\n\n\n\f\ns\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f~"+
		"\b\f\n\f\f\f\u0081\t\f\u0001\r\u0001\r\u0001\r\u0005\r\u0086\b\r\n\r\f"+
		"\r\u0089\t\r\u0001\u000e\u0001\u000e\u0003\u000e\u008d\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0093\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u0098\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u00a2\b\u0011\n\u0011\f\u0011\u00a5\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00ac\b\u0012\n"+
		"\u0012\f\u0012\u00af\t\u0012\u0003\u0012\u00b1\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00ba\b\u0012\n\u0012\f\u0012\u00bd\t\u0012\u0001\u0012\u0001\u0012"+
		"\u0003\u0012\u00c1\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015"+
		"\u00cc\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0000\u0000\u0018\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.\u0000\u0003\u0001"+
		"\u0000\u000e\u000f\u0002\u0000\f\r\u0010\u0012\u0001\u0000\u0018\u0019"+
		"\u00d3\u00002\u0001\u0000\u0000\u0000\u00024\u0001\u0000\u0000\u0000\u0004"+
		":\u0001\u0000\u0000\u0000\u0006<\u0001\u0000\u0000\u0000\bH\u0001\u0000"+
		"\u0000\u0000\nP\u0001\u0000\u0000\u0000\fR\u0001\u0000\u0000\u0000\u000e"+
		"^\u0001\u0000\u0000\u0000\u0010a\u0001\u0000\u0000\u0000\u0012d\u0001"+
		"\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016t\u0001\u0000\u0000"+
		"\u0000\u0018z\u0001\u0000\u0000\u0000\u001a\u0082\u0001\u0000\u0000\u0000"+
		"\u001c\u0092\u0001\u0000\u0000\u0000\u001e\u0094\u0001\u0000\u0000\u0000"+
		" \u009b\u0001\u0000\u0000\u0000\"\u009e\u0001\u0000\u0000\u0000$\u00c0"+
		"\u0001\u0000\u0000\u0000&\u00c2\u0001\u0000\u0000\u0000(\u00c5\u0001\u0000"+
		"\u0000\u0000*\u00cb\u0001\u0000\u0000\u0000,\u00cd\u0001\u0000\u0000\u0000"+
		".\u00d0\u0001\u0000\u0000\u000003\u0003\u0002\u0001\u000013\u0003\u0004"+
		"\u0002\u000020\u0001\u0000\u0000\u000021\u0001\u0000\u0000\u00003\u0001"+
		"\u0001\u0000\u0000\u000045\u0003\u0004\u0002\u000056\u0003\b\u0004\u0000"+
		"6\u0003\u0001\u0000\u0000\u00007;\u0005\u001b\u0000\u00008;\u0005\u0017"+
		"\u0000\u00009;\u0003\u0006\u0003\u0000:7\u0001\u0000\u0000\u0000:8\u0001"+
		"\u0000\u0000\u0000:9\u0001\u0000\u0000\u0000;\u0005\u0001\u0000\u0000"+
		"\u0000<=\u0005\u0001\u0000\u0000=\u0007\u0001\u0000\u0000\u0000>?\u0005"+
		"\u0002\u0000\u0000?@\u0003\n\u0005\u0000@A\u0005\u0003\u0000\u0000AI\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0004\u0000\u0000CI\u0003\u001a\r\u0000DE\u0005"+
		"\u0005\u0000\u0000EF\u0003\u0018\f\u0000FG\u0005\u0006\u0000\u0000GI\u0001"+
		"\u0000\u0000\u0000H>\u0001\u0000\u0000\u0000HB\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000I\t\u0001\u0000\u0000\u0000JQ\u0003\u0014\n"+
		"\u0000KQ\u0003\u0012\t\u0000LQ\u0003\u001a\r\u0000MQ\u0003\f\u0006\u0000"+
		"NQ\u0003\u0010\b\u0000OQ\u0003\u0006\u0003\u0000PJ\u0001\u0000\u0000\u0000"+
		"PK\u0001\u0000\u0000\u0000PL\u0001\u0000\u0000\u0000PM\u0001\u0000\u0000"+
		"\u0000PN\u0001\u0000\u0000\u0000PO\u0001\u0000\u0000\u0000Q\u000b\u0001"+
		"\u0000\u0000\u0000RS\u0003\u000e\u0007\u0000ST\u0005\u0007\u0000\u0000"+
		"TY\u0003(\u0014\u0000UV\u0005\b\u0000\u0000VX\u0003(\u0014\u0000WU\u0001"+
		"\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\]\u0005\t\u0000\u0000]\r\u0001\u0000\u0000\u0000^_\u0005\n\u0000"+
		"\u0000_`\u0005\u001b\u0000\u0000`\u000f\u0001\u0000\u0000\u0000ab\u0005"+
		"\u000b\u0000\u0000bc\u0005\u001b\u0000\u0000c\u0011\u0001\u0000\u0000"+
		"\u0000di\u0005\u0019\u0000\u0000ef\u0005\b\u0000\u0000fh\u0005\u0019\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000ig\u0001\u0000"+
		"\u0000\u0000ij\u0001\u0000\u0000\u0000j\u0013\u0001\u0000\u0000\u0000"+
		"ki\u0001\u0000\u0000\u0000lq\u0003\u0016\u000b\u0000mn\u0005\b\u0000\u0000"+
		"np\u0003\u0016\u000b\u0000om\u0001\u0000\u0000\u0000ps\u0001\u0000\u0000"+
		"\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000r\u0015\u0001"+
		"\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tu\u0005\f\u0000\u0000uv\u0005"+
		"\u0019\u0000\u0000vw\u0005\b\u0000\u0000wx\u0005\u0019\u0000\u0000xy\u0005"+
		"\r\u0000\u0000y\u0017\u0001\u0000\u0000\u0000z\u007f\u0005\u001b\u0000"+
		"\u0000{|\u0005\b\u0000\u0000|~\u0005\u001b\u0000\u0000}{\u0001\u0000\u0000"+
		"\u0000~\u0081\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0019\u0001\u0000\u0000\u0000\u0081"+
		"\u007f\u0001\u0000\u0000\u0000\u0082\u0087\u0003\u001c\u000e\u0000\u0083"+
		"\u0084\u0007\u0000\u0000\u0000\u0084\u0086\u0003\u001c\u000e\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u001b\u0001\u0000\u0000\u0000\u0089\u0087\u0001\u0000\u0000\u0000\u008a"+
		"\u008d\u0003\"\u0011\u0000\u008b\u008d\u0003\u001e\u000f\u0000\u008c\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0007\u0001\u0000\u0000\u008f\u0090"+
		"\u0003.\u0017\u0000\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u0093\u0003"+
		"$\u0012\u0000\u0092\u008c\u0001\u0000\u0000\u0000\u0092\u0091\u0001\u0000"+
		"\u0000\u0000\u0093\u001d\u0001\u0000\u0000\u0000\u0094\u0095\u0003 \u0010"+
		"\u0000\u0095\u0097\u0005\u0007\u0000\u0000\u0096\u0098\u0003(\u0014\u0000"+
		"\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000"+
		"\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009a\u0005\t\u0000\u0000\u009a"+
		"\u001f\u0001\u0000\u0000\u0000\u009b\u009c\u0005\u0013\u0000\u0000\u009c"+
		"\u009d\u0005\u001b\u0000\u0000\u009d!\u0001\u0000\u0000\u0000\u009e\u00a3"+
		"\u0003\u0000\u0000\u0000\u009f\u00a0\u0005\u0014\u0000\u0000\u00a0\u00a2"+
		"\u0003\u0000\u0000\u0000\u00a1\u009f\u0001\u0000\u0000\u0000\u00a2\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000\u0000\u00a3\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a4#\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a6\u00a7\u0003&\u0013\u0000\u00a7\u00b0\u0005\u0007"+
		"\u0000\u0000\u00a8\u00ad\u0003*\u0015\u0000\u00a9\u00aa\u0005\b\u0000"+
		"\u0000\u00aa\u00ac\u0003*\u0015\u0000\u00ab\u00a9\u0001\u0000\u0000\u0000"+
		"\u00ac\u00af\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ae\u00b1\u0001\u0000\u0000\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00a8\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2\u00b3\u0005\t\u0000\u0000\u00b3\u00c1\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0003&\u0013\u0000\u00b5\u00b6\u0005\u0007\u0000\u0000\u00b6\u00bb"+
		"\u0003(\u0014\u0000\u00b7\u00b8\u0005\b\u0000\u0000\u00b8\u00ba\u0003"+
		"*\u0015\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000"+
		"\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000"+
		"\u0000\u0000\u00be\u00bf\u0005\t\u0000\u0000\u00bf\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c0\u00a6\u0001\u0000\u0000\u0000\u00c0\u00b4\u0001\u0000\u0000"+
		"\u0000\u00c1%\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005\u0015\u0000\u0000"+
		"\u00c3\u00c4\u0005\u001b\u0000\u0000\u00c4\'\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c6\u0005\u000b\u0000\u0000\u00c6\u00c7\u0003\"\u0011\u0000\u00c7)"+
		"\u0001\u0000\u0000\u0000\u00c8\u00cc\u0003,\u0016\u0000\u00c9\u00cc\u0005"+
		"\u0017\u0000\u0000\u00ca\u00cc\u0005\u001c\u0000\u0000\u00cb\u00c8\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc+\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0016"+
		"\u0000\u0000\u00ce\u00cf\u0005\u001b\u0000\u0000\u00cf-\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d1\u0007\u0002\u0000\u0000\u00d1/\u0001\u0000\u0000\u0000"+
		"\u00122:HPYiq\u007f\u0087\u008c\u0092\u0097\u00a3\u00ad\u00b0\u00bb\u00c0"+
		"\u00cb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}