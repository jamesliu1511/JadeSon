// Generated from JPathProcessor.g4 by ANTLR 4.7.2

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
public class JPathProcessorParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, Literal=23, FLOAT=24, 
		INT=25, Whitespace=26, NCName=27, Number=28;
	public static final int
		RULE_locationPath = 0, RULE_specialPath = 1, RULE_searchPath = 2, RULE_step = 3, 
		RULE_all = 4, RULE_predicate = 5, RULE_arrayExpr = 6, RULE_functionFetch = 7, 
		RULE_fetchName = 8, RULE_existCheck = 9, RULE_numSelect = 10, RULE_rangeSelect = 11, 
		RULE_rangeExpr = 12, RULE_chooseSelect = 13, RULE_conditionSelect = 14, 
		RULE_conditionExpr = 15, RULE_funValue = 16, RULE_funValueName = 17, RULE_subSearchPath = 18, 
		RULE_functionCheck = 19, RULE_functionName = 20, RULE_functionNodeName = 21, 
		RULE_functionParam = 22, RULE_variableReference = 23, RULE_numValue = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"locationPath", "specialPath", "searchPath", "step", "all", "predicate", 
			"arrayExpr", "functionFetch", "fetchName", "existCheck", "numSelect", 
			"rangeSelect", "rangeExpr", "chooseSelect", "conditionSelect", "conditionExpr", 
			"funValue", "funValueName", "subSearchPath", "functionCheck", "functionName", 
			"functionNodeName", "functionParam", "variableReference", "numValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'*'", "'['", "']'", "'?'", "'{'", "'}'", "'('", "','", 
			"')'", "'ft:'", "'@'", "'<'", "'>'", "'||'", "'&&'", "'<='", "'>='", 
			"'=='", "'fv:'", "'fn:'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "Literal", 
			"FLOAT", "INT", "Whitespace", "NCName", "Number"
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
	public String getGrammarFileName() { return "JPathProcessor.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JPathProcessorParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class LocationPathContext extends ParserRuleContext {
		public List<SpecialPathContext> specialPath() {
			return getRuleContexts(SpecialPathContext.class);
		}
		public SpecialPathContext specialPath(int i) {
			return getRuleContext(SpecialPathContext.class,i);
		}
		public LocationPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitLocationPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LocationPathContext locationPath() throws RecognitionException {
		LocationPathContext _localctx = new LocationPathContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_locationPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			specialPath();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(51);
				match(T__0);
				setState(52);
				specialPath();
				}
				}
				setState(57);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitSpecialPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialPathContext specialPath() throws RecognitionException {
		SpecialPathContext _localctx = new SpecialPathContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_specialPath);
		try {
			setState(60);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				searchPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(59);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchPathContext searchPath() throws RecognitionException {
		SearchPathContext _localctx = new SearchPathContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_searchPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			step();
			setState(63);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public TerminalNode Literal() { return getToken(JPathProcessorParser.Literal, 0); }
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_step);
		try {
			setState(68);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				match(NCName);
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(Literal);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__1);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_predicate);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(72);
				match(T__2);
				setState(73);
				arrayExpr();
				setState(74);
				match(T__3);
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__4);
				setState(77);
				conditionSelect();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				match(T__5);
				setState(79);
				chooseSelect();
				setState(80);
				match(T__6);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_arrayExpr);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				rangeSelect();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(85);
				numSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				conditionSelect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87);
				functionFetch();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(88);
				existCheck();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(89);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunctionFetch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionFetchContext functionFetch() throws RecognitionException {
		FunctionFetchContext _localctx = new FunctionFetchContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_functionFetch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			fetchName();
			setState(93);
			match(T__7);
			setState(94);
			functionNodeName();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(95);
				match(T__8);
				setState(96);
				functionNodeName();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
			match(T__9);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public FetchNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFetchName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchNameContext fetchName() throws RecognitionException {
		FetchNameContext _localctx = new FetchNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_fetchName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__10);
			setState(105);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public ExistCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existCheck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitExistCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistCheckContext existCheck() throws RecognitionException {
		ExistCheckContext _localctx = new ExistCheckContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_existCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__11);
			setState(108);
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
		public List<TerminalNode> INT() { return getTokens(JPathProcessorParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathProcessorParser.INT, i);
		}
		public NumSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitNumSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumSelectContext numSelect() throws RecognitionException {
		NumSelectContext _localctx = new NumSelectContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(INT);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(111);
				match(T__8);
				setState(112);
				match(INT);
				}
				}
				setState(117);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitRangeSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeSelectContext rangeSelect() throws RecognitionException {
		RangeSelectContext _localctx = new RangeSelectContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_rangeSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
			rangeExpr();
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(119);
				match(T__8);
				setState(120);
				rangeExpr();
				}
				}
				setState(125);
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
		public List<TerminalNode> INT() { return getTokens(JPathProcessorParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathProcessorParser.INT, i);
		}
		public RangeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitRangeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeExprContext rangeExpr() throws RecognitionException {
		RangeExprContext _localctx = new RangeExprContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rangeExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(T__12);
			setState(127);
			match(INT);
			setState(128);
			match(T__8);
			setState(129);
			match(INT);
			setState(130);
			match(T__13);
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
		public List<TerminalNode> NCName() { return getTokens(JPathProcessorParser.NCName); }
		public TerminalNode NCName(int i) {
			return getToken(JPathProcessorParser.NCName, i);
		}
		public ChooseSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chooseSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitChooseSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseSelectContext chooseSelect() throws RecognitionException {
		ChooseSelectContext _localctx = new ChooseSelectContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_chooseSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(NCName);
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(133);
				match(T__8);
				setState(134);
				match(NCName);
				}
				}
				setState(139);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitConditionSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionSelectContext conditionSelect() throws RecognitionException {
		ConditionSelectContext _localctx = new ConditionSelectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conditionSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			conditionExpr();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__14 || _la==T__15) {
				{
				{
				setState(141);
				((ConditionSelectContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
					((ConditionSelectContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				conditionExpr();
				}
				}
				setState(147);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionExpr);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
			case T__19:
			case Literal:
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(150);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__1:
				case Literal:
				case NCName:
					{
					setState(148);
					subSearchPath();
					}
					break;
				case T__19:
					{
					setState(149);
					funValue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(152);
				((ConditionExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
					((ConditionExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(153);
				numValue();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueContext funValue() throws RecognitionException {
		FunValueContext _localctx = new FunValueContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_funValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			funValueName();
			setState(159);
			match(T__7);
			setState(161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(160);
				functionNodeName();
				}
			}

			setState(163);
			match(T__9);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public FunValueNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funValueName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunValueName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueNameContext funValueName() throws RecognitionException {
		FunValueNameContext _localctx = new FunValueNameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_funValueName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__19);
			setState(166);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitSubSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubSearchPathContext subSearchPath() throws RecognitionException {
		SubSearchPathContext _localctx = new SubSearchPathContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_subSearchPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			specialPath();
			setState(173);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(169);
				match(T__0);
				setState(170);
				specialPath();
				}
				}
				setState(175);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunctionCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCheckContext functionCheck() throws RecognitionException {
		FunctionCheckContext _localctx = new FunctionCheckContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_functionCheck);
		int _la;
		try {
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				functionName();
				setState(177);
				match(T__7);
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__21) | (1L << Literal) | (1L << Number))) != 0)) {
					{
					setState(178);
					functionParam();
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__8) {
						{
						{
						setState(179);
						match(T__8);
						setState(180);
						functionParam();
						}
						}
						setState(185);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(188);
				match(T__9);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				functionName();
				setState(191);
				match(T__7);
				setState(192);
				functionNodeName();
				setState(197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(193);
					match(T__8);
					setState(194);
					functionParam();
					}
					}
					setState(199);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(200);
				match(T__9);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(T__20);
			setState(205);
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
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunctionNodeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNodeNameContext functionNodeName() throws RecognitionException {
		FunctionNodeNameContext _localctx = new FunctionNodeNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_functionNodeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__11);
			setState(208);
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
		public TerminalNode Literal() { return getToken(JPathProcessorParser.Literal, 0); }
		public TerminalNode Number() { return getToken(JPathProcessorParser.Number, 0); }
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_functionParam);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				variableReference();
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(211);
				match(Literal);
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(212);
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
		public TerminalNode NCName() { return getToken(JPathProcessorParser.NCName, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			match(T__21);
			setState(216);
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
		public TerminalNode FLOAT() { return getToken(JPathProcessorParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JPathProcessorParser.INT, 0); }
		public NumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathProcessorVisitor ) return ((JPathProcessorVisitor<? extends T>)visitor).visitNumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumValueContext numValue() throws RecognitionException {
		NumValueContext _localctx = new NumValueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_numValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36\u00df\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\7\28\n\2\f\2\16\2;\13\2\3\3\3\3\5\3?\n\3\3\4\3"+
		"\4\3\4\3\5\3\5\3\5\5\5G\n\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7U\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\3\t\3\t\7"+
		"\td\n\t\f\t\16\tg\13\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\7\ft\n\f\f\f\16\fw\13\f\3\r\3\r\3\r\7\r|\n\r\f\r\16\r\177\13\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\7\17\u008a\n\17\f\17\16\17\u008d"+
		"\13\17\3\20\3\20\3\20\7\20\u0092\n\20\f\20\16\20\u0095\13\20\3\21\3\21"+
		"\5\21\u0099\n\21\3\21\3\21\3\21\3\21\5\21\u009f\n\21\3\22\3\22\3\22\5"+
		"\22\u00a4\n\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u00ae\n\24"+
		"\f\24\16\24\u00b1\13\24\3\25\3\25\3\25\3\25\3\25\7\25\u00b8\n\25\f\25"+
		"\16\25\u00bb\13\25\5\25\u00bd\n\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u00c6\n\25\f\25\16\25\u00c9\13\25\3\25\3\25\5\25\u00cd\n\25\3\26"+
		"\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\5\30\u00d8\n\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\2\2\33\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\2\5\3\2\21\22\4\2\17\20\23\25\3\2\32\33\2\u00df\2\64\3\2\2\2\4"+
		">\3\2\2\2\6@\3\2\2\2\bF\3\2\2\2\nH\3\2\2\2\fT\3\2\2\2\16\\\3\2\2\2\20"+
		"^\3\2\2\2\22j\3\2\2\2\24m\3\2\2\2\26p\3\2\2\2\30x\3\2\2\2\32\u0080\3\2"+
		"\2\2\34\u0086\3\2\2\2\36\u008e\3\2\2\2 \u009e\3\2\2\2\"\u00a0\3\2\2\2"+
		"$\u00a7\3\2\2\2&\u00aa\3\2\2\2(\u00cc\3\2\2\2*\u00ce\3\2\2\2,\u00d1\3"+
		"\2\2\2.\u00d7\3\2\2\2\60\u00d9\3\2\2\2\62\u00dc\3\2\2\2\649\5\4\3\2\65"+
		"\66\7\3\2\2\668\5\4\3\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2"+
		":\3\3\2\2\2;9\3\2\2\2<?\5\6\4\2=?\5\b\5\2><\3\2\2\2>=\3\2\2\2?\5\3\2\2"+
		"\2@A\5\b\5\2AB\5\f\7\2B\7\3\2\2\2CG\7\35\2\2DG\7\31\2\2EG\5\n\6\2FC\3"+
		"\2\2\2FD\3\2\2\2FE\3\2\2\2G\t\3\2\2\2HI\7\4\2\2I\13\3\2\2\2JK\7\5\2\2"+
		"KL\5\16\b\2LM\7\6\2\2MU\3\2\2\2NO\7\7\2\2OU\5\36\20\2PQ\7\b\2\2QR\5\34"+
		"\17\2RS\7\t\2\2SU\3\2\2\2TJ\3\2\2\2TN\3\2\2\2TP\3\2\2\2U\r\3\2\2\2V]\5"+
		"\30\r\2W]\5\26\f\2X]\5\36\20\2Y]\5\20\t\2Z]\5\24\13\2[]\5\n\6\2\\V\3\2"+
		"\2\2\\W\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2"+
		"\2^_\5\22\n\2_`\7\n\2\2`e\5,\27\2ab\7\13\2\2bd\5,\27\2ca\3\2\2\2dg\3\2"+
		"\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2ge\3\2\2\2hi\7\f\2\2i\21\3\2\2\2jk\7"+
		"\r\2\2kl\7\35\2\2l\23\3\2\2\2mn\7\16\2\2no\7\35\2\2o\25\3\2\2\2pu\7\33"+
		"\2\2qr\7\13\2\2rt\7\33\2\2sq\3\2\2\2tw\3\2\2\2us\3\2\2\2uv\3\2\2\2v\27"+
		"\3\2\2\2wu\3\2\2\2x}\5\32\16\2yz\7\13\2\2z|\5\32\16\2{y\3\2\2\2|\177\3"+
		"\2\2\2}{\3\2\2\2}~\3\2\2\2~\31\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\17\2"+
		"\2\u0081\u0082\7\33\2\2\u0082\u0083\7\13\2\2\u0083\u0084\7\33\2\2\u0084"+
		"\u0085\7\20\2\2\u0085\33\3\2\2\2\u0086\u008b\7\35\2\2\u0087\u0088\7\13"+
		"\2\2\u0088\u008a\7\35\2\2\u0089\u0087\3\2\2\2\u008a\u008d\3\2\2\2\u008b"+
		"\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\35\3\2\2\2\u008d\u008b\3\2\2"+
		"\2\u008e\u0093\5 \21\2\u008f\u0090\t\2\2\2\u0090\u0092\5 \21\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094"+
		"\37\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u0099\5&\24\2\u0097\u0099\5\"\22"+
		"\2\u0098\u0096\3\2\2\2\u0098\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b"+
		"\t\3\2\2\u009b\u009c\5\62\32\2\u009c\u009f\3\2\2\2\u009d\u009f\5(\25\2"+
		"\u009e\u0098\3\2\2\2\u009e\u009d\3\2\2\2\u009f!\3\2\2\2\u00a0\u00a1\5"+
		"$\23\2\u00a1\u00a3\7\n\2\2\u00a2\u00a4\5,\27\2\u00a3\u00a2\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\7\f\2\2\u00a6#\3\2\2\2"+
		"\u00a7\u00a8\7\26\2\2\u00a8\u00a9\7\35\2\2\u00a9%\3\2\2\2\u00aa\u00af"+
		"\5\4\3\2\u00ab\u00ac\7\3\2\2\u00ac\u00ae\5\4\3\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\'\3\2\2\2"+
		"\u00b1\u00af\3\2\2\2\u00b2\u00b3\5*\26\2\u00b3\u00bc\7\n\2\2\u00b4\u00b9"+
		"\5.\30\2\u00b5\u00b6\7\13\2\2\u00b6\u00b8\5.\30\2\u00b7\u00b5\3\2\2\2"+
		"\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00bf\7\f\2\2\u00bf\u00cd\3\2\2\2\u00c0\u00c1\5*"+
		"\26\2\u00c1\u00c2\7\n\2\2\u00c2\u00c7\5,\27\2\u00c3\u00c4\7\13\2\2\u00c4"+
		"\u00c6\5.\30\2\u00c5\u00c3\3\2\2\2\u00c6\u00c9\3\2\2\2\u00c7\u00c5\3\2"+
		"\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca"+
		"\u00cb\7\f\2\2\u00cb\u00cd\3\2\2\2\u00cc\u00b2\3\2\2\2\u00cc\u00c0\3\2"+
		"\2\2\u00cd)\3\2\2\2\u00ce\u00cf\7\27\2\2\u00cf\u00d0\7\35\2\2\u00d0+\3"+
		"\2\2\2\u00d1\u00d2\7\16\2\2\u00d2\u00d3\5&\24\2\u00d3-\3\2\2\2\u00d4\u00d8"+
		"\5\60\31\2\u00d5\u00d8\7\31\2\2\u00d6\u00d8\7\36\2\2\u00d7\u00d4\3\2\2"+
		"\2\u00d7\u00d5\3\2\2\2\u00d7\u00d6\3\2\2\2\u00d8/\3\2\2\2\u00d9\u00da"+
		"\7\30\2\2\u00da\u00db\7\35\2\2\u00db\61\3\2\2\2\u00dc\u00dd\t\4\2\2\u00dd"+
		"\63\3\2\2\2\259>FT\\eu}\u008b\u0093\u0098\u009e\u00a3\u00af\u00b9\u00bc"+
		"\u00c7\u00cc\u00d7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}