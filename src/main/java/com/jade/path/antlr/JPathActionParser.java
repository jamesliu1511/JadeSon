// Generated from JPathAction.g4 by ANTLR 4.10.1

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
public class JPathActionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, Literal=24, 
		FLOAT=25, INT=26, WS=27, NCName=28, Number=29;
	public static final int
		RULE_locationPath = 0, RULE_functionProcessor = 1, RULE_processorParam = 2, 
		RULE_specialName = 3, RULE_processor = 4, RULE_specialPath = 5, RULE_searchPath = 6, 
		RULE_step = 7, RULE_all = 8, RULE_predicate = 9, RULE_arrayExpr = 10, 
		RULE_functionFetch = 11, RULE_fetchName = 12, RULE_existCheck = 13, RULE_numSelect = 14, 
		RULE_rangeSelect = 15, RULE_rangeExpr = 16, RULE_chooseSelect = 17, RULE_conditionSelect = 18, 
		RULE_conditionExpr = 19, RULE_funValue = 20, RULE_funValueName = 21, RULE_subSearchPath = 22, 
		RULE_functionCheck = 23, RULE_functionName = 24, RULE_functionNodeName = 25, 
		RULE_functionParam = 26, RULE_variableReference = 27, RULE_numValue = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"locationPath", "functionProcessor", "processorParam", "specialName", 
			"processor", "specialPath", "searchPath", "step", "all", "predicate", 
			"arrayExpr", "functionFetch", "fetchName", "existCheck", "numSelect", 
			"rangeSelect", "rangeExpr", "chooseSelect", "conditionSelect", "conditionExpr", 
			"funValue", "funValueName", "subSearchPath", "functionCheck", "functionName", 
			"functionNodeName", "functionParam", "variableReference", "numValue"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'", "'['", "']'", "'('", "','", "')'", "'@'", "'fm:'", "'*'", 
			"'?'", "'{'", "'}'", "'ft:'", "'<'", "'>'", "'||'", "'&&'", "'<='", "'>='", 
			"'=='", "'fv:'", "'fn:'", "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"Literal", "FLOAT", "INT", "WS", "NCName", "Number"
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
	public String getGrammarFileName() { return "JPathAction.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JPathActionParser(TokenStream input) {
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
		public FunctionProcessorContext functionProcessor() {
			return getRuleContext(FunctionProcessorContext.class,0);
		}
		public LocationPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_locationPath; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitLocationPath(this);
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
			setState(58);
			specialPath();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(59);
				match(T__0);
				setState(60);
				specialPath();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(66);
				match(T__1);
				setState(67);
				functionProcessor();
				setState(68);
				match(T__2);
				}
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

	public static class FunctionProcessorContext extends ParserRuleContext {
		public ProcessorContext processor() {
			return getRuleContext(ProcessorContext.class,0);
		}
		public List<ProcessorParamContext> processorParam() {
			return getRuleContexts(ProcessorParamContext.class);
		}
		public ProcessorParamContext processorParam(int i) {
			return getRuleContext(ProcessorParamContext.class,i);
		}
		public FunctionProcessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionProcessor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionProcessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionProcessorContext functionProcessor() throws RecognitionException {
		FunctionProcessorContext _localctx = new FunctionProcessorContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionProcessor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			processor();
			setState(73);
			match(T__3);
			setState(74);
			processorParam();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(75);
				match(T__4);
				setState(76);
				processorParam();
				}
				}
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(82);
			match(T__5);
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

	public static class ProcessorParamContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public VariableReferenceContext variableReference() {
			return getRuleContext(VariableReferenceContext.class,0);
		}
		public TerminalNode Literal() { return getToken(JPathActionParser.Literal, 0); }
		public SpecialNameContext specialName() {
			return getRuleContext(SpecialNameContext.class,0);
		}
		public TerminalNode INT() { return getToken(JPathActionParser.INT, 0); }
		public ProcessorParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processorParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitProcessorParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessorParamContext processorParam() throws RecognitionException {
		ProcessorParamContext _localctx = new ProcessorParamContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_processorParam);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				match(T__6);
				setState(85);
				match(NCName);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				variableReference();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
				match(Literal);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(88);
				specialName();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89);
				match(INT);
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

	public static class SpecialNameContext extends ParserRuleContext {
		public TerminalNode Literal() { return getToken(JPathActionParser.Literal, 0); }
		public SpecialNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitSpecialName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialNameContext specialName() throws RecognitionException {
		SpecialNameContext _localctx = new SpecialNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_specialName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__6);
			setState(93);
			match(Literal);
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

	public static class ProcessorContext extends ParserRuleContext {
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public ProcessorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_processor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitProcessor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProcessorContext processor() throws RecognitionException {
		ProcessorContext _localctx = new ProcessorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_processor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__7);
			setState(96);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitSpecialPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SpecialPathContext specialPath() throws RecognitionException {
		SpecialPathContext _localctx = new SpecialPathContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_specialPath);
		try {
			setState(100);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				searchPath();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SearchPathContext searchPath() throws RecognitionException {
		SearchPathContext _localctx = new SearchPathContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_searchPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			step();
			setState(103);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public TerminalNode Literal() { return getToken(JPathActionParser.Literal, 0); }
		public AllContext all() {
			return getRuleContext(AllContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitStep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_step);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(NCName);
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(Literal);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitAll(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AllContext all() throws RecognitionException {
		AllContext _localctx = new AllContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_all);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_predicate);
		try {
			setState(122);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(T__1);
				setState(113);
				arrayExpr();
				setState(114);
				match(T__2);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(T__9);
				setState(117);
				conditionSelect();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				match(T__10);
				setState(119);
				chooseSelect();
				setState(120);
				match(T__11);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayExprContext arrayExpr() throws RecognitionException {
		ArrayExprContext _localctx = new ArrayExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayExpr);
		try {
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				rangeSelect();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				numSelect();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				conditionSelect();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				functionFetch();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				existCheck();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(129);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionFetch(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionFetchContext functionFetch() throws RecognitionException {
		FunctionFetchContext _localctx = new FunctionFetchContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_functionFetch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			fetchName();
			setState(133);
			match(T__3);
			setState(134);
			functionNodeName();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(135);
				match(T__4);
				setState(136);
				functionNodeName();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__5);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public FetchNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fetchName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFetchName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FetchNameContext fetchName() throws RecognitionException {
		FetchNameContext _localctx = new FetchNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fetchName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__12);
			setState(145);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public ExistCheckContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_existCheck; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitExistCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExistCheckContext existCheck() throws RecognitionException {
		ExistCheckContext _localctx = new ExistCheckContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_existCheck);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__6);
			setState(148);
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
		public List<TerminalNode> INT() { return getTokens(JPathActionParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathActionParser.INT, i);
		}
		public NumSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitNumSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumSelectContext numSelect() throws RecognitionException {
		NumSelectContext _localctx = new NumSelectContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(INT);
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(151);
				match(T__4);
				setState(152);
				match(INT);
				}
				}
				setState(157);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitRangeSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeSelectContext rangeSelect() throws RecognitionException {
		RangeSelectContext _localctx = new RangeSelectContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rangeSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			rangeExpr();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(159);
				match(T__4);
				setState(160);
				rangeExpr();
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

	public static class RangeExprContext extends ParserRuleContext {
		public List<TerminalNode> INT() { return getTokens(JPathActionParser.INT); }
		public TerminalNode INT(int i) {
			return getToken(JPathActionParser.INT, i);
		}
		public RangeExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeExpr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitRangeExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RangeExprContext rangeExpr() throws RecognitionException {
		RangeExprContext _localctx = new RangeExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rangeExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			match(T__13);
			setState(167);
			match(INT);
			setState(168);
			match(T__4);
			setState(169);
			match(INT);
			setState(170);
			match(T__14);
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
		public List<TerminalNode> NCName() { return getTokens(JPathActionParser.NCName); }
		public TerminalNode NCName(int i) {
			return getToken(JPathActionParser.NCName, i);
		}
		public ChooseSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chooseSelect; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitChooseSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChooseSelectContext chooseSelect() throws RecognitionException {
		ChooseSelectContext _localctx = new ChooseSelectContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_chooseSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			match(NCName);
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(173);
				match(T__4);
				setState(174);
				match(NCName);
				}
				}
				setState(179);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitConditionSelect(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionSelectContext conditionSelect() throws RecognitionException {
		ConditionSelectContext _localctx = new ConditionSelectContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_conditionSelect);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			conditionExpr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__15 || _la==T__16) {
				{
				{
				setState(181);
				((ConditionSelectContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__15 || _la==T__16) ) {
					((ConditionSelectContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(182);
				conditionExpr();
				}
				}
				setState(187);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_conditionExpr);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
			case T__20:
			case Literal:
			case NCName:
				enterOuterAlt(_localctx, 1);
				{
				setState(190);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__8:
				case Literal:
				case NCName:
					{
					setState(188);
					subSearchPath();
					}
					break;
				case T__20:
					{
					setState(189);
					funValue();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(192);
				((ConditionExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
					((ConditionExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				numValue();
				}
				break;
			case T__21:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueContext funValue() throws RecognitionException {
		FunValueContext _localctx = new FunValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_funValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			funValueName();
			setState(199);
			match(T__3);
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(200);
				functionNodeName();
				}
			}

			setState(203);
			match(T__5);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public FunValueNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funValueName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunValueName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunValueNameContext funValueName() throws RecognitionException {
		FunValueNameContext _localctx = new FunValueNameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_funValueName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__20);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitSubSearchPath(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SubSearchPathContext subSearchPath() throws RecognitionException {
		SubSearchPathContext _localctx = new SubSearchPathContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_subSearchPath);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			specialPath();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(209);
				match(T__0);
				setState(210);
				specialPath();
				}
				}
				setState(215);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCheckContext functionCheck() throws RecognitionException {
		FunctionCheckContext _localctx = new FunctionCheckContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_functionCheck);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				functionName();
				setState(217);
				match(T__3);
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << Literal) | (1L << Number))) != 0)) {
					{
					setState(218);
					functionParam();
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__4) {
						{
						{
						setState(219);
						match(T__4);
						setState(220);
						functionParam();
						}
						}
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(228);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230);
				functionName();
				setState(231);
				match(T__3);
				setState(232);
				functionNodeName();
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(233);
					match(T__4);
					setState(234);
					functionParam();
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(240);
				match(T__5);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public FunctionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionName; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNameContext functionName() throws RecognitionException {
		FunctionNameContext _localctx = new FunctionNameContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__21);
			setState(245);
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
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionNodeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionNodeNameContext functionNodeName() throws RecognitionException {
		FunctionNodeNameContext _localctx = new FunctionNodeNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionNodeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(T__6);
			setState(248);
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
		public TerminalNode Literal() { return getToken(JPathActionParser.Literal, 0); }
		public TerminalNode Number() { return getToken(JPathActionParser.Number, 0); }
		public FunctionParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionParam; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitFunctionParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionParamContext functionParam() throws RecognitionException {
		FunctionParamContext _localctx = new FunctionParamContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_functionParam);
		try {
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__22:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				variableReference();
				}
				break;
			case Literal:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(Literal);
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
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
		public TerminalNode NCName() { return getToken(JPathActionParser.NCName, 0); }
		public VariableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitVariableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableReferenceContext variableReference() throws RecognitionException {
		VariableReferenceContext _localctx = new VariableReferenceContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_variableReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			match(T__22);
			setState(256);
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
		public TerminalNode FLOAT() { return getToken(JPathActionParser.FLOAT, 0); }
		public TerminalNode INT() { return getToken(JPathActionParser.INT, 0); }
		public NumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numValue; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof JPathActionVisitor ) return ((JPathActionVisitor<? extends T>)visitor).visitNumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumValueContext numValue() throws RecognitionException {
		NumValueContext _localctx = new NumValueContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_numValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
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
		"\u0004\u0001\u001d\u0105\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000>\b\u0000\n\u0000\f\u0000A\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0003\u0000G\b\u0000\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001N\b\u0001\n\u0001\f\u0001Q\t"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002[\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0003\u0005e\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0003\u0007m\b\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0003\t{\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u0083\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u008a\b\u000b\n\u000b\f\u000b\u008d\t\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0005\u000e\u009a\b\u000e\n\u000e\f\u000e\u009d\t\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00a2\b\u000f\n\u000f"+
		"\f\u000f\u00a5\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00b0\b\u0011\n\u0011\f\u0011\u00b3\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u00b8\b\u0012\n\u0012\f\u0012\u00bb\t\u0012\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00bf\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0003\u0013\u00c5\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0003\u0014\u00ca\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0005\u0016\u00d4\b\u0016"+
		"\n\u0016\f\u0016\u00d7\t\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u00de\b\u0017\n\u0017\f\u0017\u00e1\t\u0017"+
		"\u0003\u0017\u00e3\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u00ec\b\u0017\n\u0017"+
		"\f\u0017\u00ef\t\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u00f3\b\u0017"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00fe\b\u001a\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0000\u0000"+
		"\u001d\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468\u0000\u0003\u0001\u0000\u0010\u0011\u0002"+
		"\u0000\u000e\u000f\u0012\u0014\u0001\u0000\u0019\u001a\u0107\u0000:\u0001"+
		"\u0000\u0000\u0000\u0002H\u0001\u0000\u0000\u0000\u0004Z\u0001\u0000\u0000"+
		"\u0000\u0006\\\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\nd\u0001"+
		"\u0000\u0000\u0000\ff\u0001\u0000\u0000\u0000\u000el\u0001\u0000\u0000"+
		"\u0000\u0010n\u0001\u0000\u0000\u0000\u0012z\u0001\u0000\u0000\u0000\u0014"+
		"\u0082\u0001\u0000\u0000\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018"+
		"\u0090\u0001\u0000\u0000\u0000\u001a\u0093\u0001\u0000\u0000\u0000\u001c"+
		"\u0096\u0001\u0000\u0000\u0000\u001e\u009e\u0001\u0000\u0000\u0000 \u00a6"+
		"\u0001\u0000\u0000\u0000\"\u00ac\u0001\u0000\u0000\u0000$\u00b4\u0001"+
		"\u0000\u0000\u0000&\u00c4\u0001\u0000\u0000\u0000(\u00c6\u0001\u0000\u0000"+
		"\u0000*\u00cd\u0001\u0000\u0000\u0000,\u00d0\u0001\u0000\u0000\u0000."+
		"\u00f2\u0001\u0000\u0000\u00000\u00f4\u0001\u0000\u0000\u00002\u00f7\u0001"+
		"\u0000\u0000\u00004\u00fd\u0001\u0000\u0000\u00006\u00ff\u0001\u0000\u0000"+
		"\u00008\u0102\u0001\u0000\u0000\u0000:?\u0003\n\u0005\u0000;<\u0005\u0001"+
		"\u0000\u0000<>\u0003\n\u0005\u0000=;\u0001\u0000\u0000\u0000>A\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@F\u0001"+
		"\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0002\u0000\u0000"+
		"CD\u0003\u0002\u0001\u0000DE\u0005\u0003\u0000\u0000EG\u0001\u0000\u0000"+
		"\u0000FB\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000\u0000G\u0001\u0001"+
		"\u0000\u0000\u0000HI\u0003\b\u0004\u0000IJ\u0005\u0004\u0000\u0000JO\u0003"+
		"\u0004\u0002\u0000KL\u0005\u0005\u0000\u0000LN\u0003\u0004\u0002\u0000"+
		"MK\u0001\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000OP\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000RS\u0005\u0006\u0000\u0000S\u0003\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0007\u0000\u0000U[\u0005\u001c\u0000\u0000V[\u00036\u001b\u0000"+
		"W[\u0005\u0018\u0000\u0000X[\u0003\u0006\u0003\u0000Y[\u0005\u001a\u0000"+
		"\u0000ZT\u0001\u0000\u0000\u0000ZV\u0001\u0000\u0000\u0000ZW\u0001\u0000"+
		"\u0000\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\u0005"+
		"\u0001\u0000\u0000\u0000\\]\u0005\u0007\u0000\u0000]^\u0005\u0018\u0000"+
		"\u0000^\u0007\u0001\u0000\u0000\u0000_`\u0005\b\u0000\u0000`a\u0005\u001c"+
		"\u0000\u0000a\t\u0001\u0000\u0000\u0000be\u0003\f\u0006\u0000ce\u0003"+
		"\u000e\u0007\u0000db\u0001\u0000\u0000\u0000dc\u0001\u0000\u0000\u0000"+
		"e\u000b\u0001\u0000\u0000\u0000fg\u0003\u000e\u0007\u0000gh\u0003\u0012"+
		"\t\u0000h\r\u0001\u0000\u0000\u0000im\u0005\u001c\u0000\u0000jm\u0005"+
		"\u0018\u0000\u0000km\u0003\u0010\b\u0000li\u0001\u0000\u0000\u0000lj\u0001"+
		"\u0000\u0000\u0000lk\u0001\u0000\u0000\u0000m\u000f\u0001\u0000\u0000"+
		"\u0000no\u0005\t\u0000\u0000o\u0011\u0001\u0000\u0000\u0000pq\u0005\u0002"+
		"\u0000\u0000qr\u0003\u0014\n\u0000rs\u0005\u0003\u0000\u0000s{\u0001\u0000"+
		"\u0000\u0000tu\u0005\n\u0000\u0000u{\u0003$\u0012\u0000vw\u0005\u000b"+
		"\u0000\u0000wx\u0003\"\u0011\u0000xy\u0005\f\u0000\u0000y{\u0001\u0000"+
		"\u0000\u0000zp\u0001\u0000\u0000\u0000zt\u0001\u0000\u0000\u0000zv\u0001"+
		"\u0000\u0000\u0000{\u0013\u0001\u0000\u0000\u0000|\u0083\u0003\u001e\u000f"+
		"\u0000}\u0083\u0003\u001c\u000e\u0000~\u0083\u0003$\u0012\u0000\u007f"+
		"\u0083\u0003\u0016\u000b\u0000\u0080\u0083\u0003\u001a\r\u0000\u0081\u0083"+
		"\u0003\u0010\b\u0000\u0082|\u0001\u0000\u0000\u0000\u0082}\u0001\u0000"+
		"\u0000\u0000\u0082~\u0001\u0000\u0000\u0000\u0082\u007f\u0001\u0000\u0000"+
		"\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000"+
		"\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0085\u0003\u0018\f\u0000"+
		"\u0085\u0086\u0005\u0004\u0000\u0000\u0086\u008b\u00032\u0019\u0000\u0087"+
		"\u0088\u0005\u0005\u0000\u0000\u0088\u008a\u00032\u0019\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e"+
		"\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0005\u0006\u0000\u0000\u008f\u0017\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\r\u0000\u0000\u0091\u0092\u0005\u001c\u0000\u0000\u0092\u0019\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0095\u0005"+
		"\u001c\u0000\u0000\u0095\u001b\u0001\u0000\u0000\u0000\u0096\u009b\u0005"+
		"\u001a\u0000\u0000\u0097\u0098\u0005\u0005\u0000\u0000\u0098\u009a\u0005"+
		"\u001a\u0000\u0000\u0099\u0097\u0001\u0000\u0000\u0000\u009a\u009d\u0001"+
		"\u0000\u0000\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001"+
		"\u0000\u0000\u0000\u009c\u001d\u0001\u0000\u0000\u0000\u009d\u009b\u0001"+
		"\u0000\u0000\u0000\u009e\u00a3\u0003 \u0010\u0000\u009f\u00a0\u0005\u0005"+
		"\u0000\u0000\u00a0\u00a2\u0003 \u0010\u0000\u00a1\u009f\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001\u0000\u0000"+
		"\u0000\u00a3\u00a4\u0001\u0000\u0000\u0000\u00a4\u001f\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\u000e\u0000"+
		"\u0000\u00a7\u00a8\u0005\u001a\u0000\u0000\u00a8\u00a9\u0005\u0005\u0000"+
		"\u0000\u00a9\u00aa\u0005\u001a\u0000\u0000\u00aa\u00ab\u0005\u000f\u0000"+
		"\u0000\u00ab!\u0001\u0000\u0000\u0000\u00ac\u00b1\u0005\u001c\u0000\u0000"+
		"\u00ad\u00ae\u0005\u0005\u0000\u0000\u00ae\u00b0\u0005\u001c\u0000\u0000"+
		"\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000"+
		"\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b2#\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b9\u0003&\u0013\u0000\u00b5\u00b6\u0007\u0000\u0000\u0000\u00b6\u00b8"+
		"\u0003&\u0013\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000\u00b8\u00bb\u0001"+
		"\u0000\u0000\u0000\u00b9\u00b7\u0001\u0000\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba%\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000"+
		"\u0000\u0000\u00bc\u00bf\u0003,\u0016\u0000\u00bd\u00bf\u0003(\u0014\u0000"+
		"\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c1\u0007\u0001\u0000\u0000"+
		"\u00c1\u00c2\u00038\u001c\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c5\u0003.\u0017\u0000\u00c4\u00be\u0001\u0000\u0000\u0000\u00c4\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c5\'\u0001\u0000\u0000\u0000\u00c6\u00c7\u0003"+
		"*\u0015\u0000\u00c7\u00c9\u0005\u0004\u0000\u0000\u00c8\u00ca\u00032\u0019"+
		"\u0000\u00c9\u00c8\u0001\u0000\u0000\u0000\u00c9\u00ca\u0001\u0000\u0000"+
		"\u0000\u00ca\u00cb\u0001\u0000\u0000\u0000\u00cb\u00cc\u0005\u0006\u0000"+
		"\u0000\u00cc)\u0001\u0000\u0000\u0000\u00cd\u00ce\u0005\u0015\u0000\u0000"+
		"\u00ce\u00cf\u0005\u001c\u0000\u0000\u00cf+\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d5\u0003\n\u0005\u0000\u00d1\u00d2\u0005\u0001\u0000\u0000\u00d2\u00d4"+
		"\u0003\n\u0005\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001"+
		"\u0000\u0000\u0000\u00d6-\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d8\u00d9\u00030\u0018\u0000\u00d9\u00e2\u0005\u0004\u0000"+
		"\u0000\u00da\u00df\u00034\u001a\u0000\u00db\u00dc\u0005\u0005\u0000\u0000"+
		"\u00dc\u00de\u00034\u001a\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e0\u00e3\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00da\u0001\u0000\u0000\u0000\u00e2"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e4\u0001\u0000\u0000\u0000\u00e4"+
		"\u00e5\u0005\u0006\u0000\u0000\u00e5\u00f3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e7\u00030\u0018\u0000\u00e7\u00e8\u0005\u0004\u0000\u0000\u00e8\u00ed"+
		"\u00032\u0019\u0000\u00e9\u00ea\u0005\u0005\u0000\u0000\u00ea\u00ec\u0003"+
		"4\u001a\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000\u00ec\u00ef\u0001\u0000"+
		"\u0000\u0000\u00ed\u00eb\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000"+
		"\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef\u00ed\u0001\u0000"+
		"\u0000\u0000\u00f0\u00f1\u0005\u0006\u0000\u0000\u00f1\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f2\u00d8\u0001\u0000\u0000\u0000\u00f2\u00e6\u0001\u0000"+
		"\u0000\u0000\u00f3/\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u0016\u0000"+
		"\u0000\u00f5\u00f6\u0005\u001c\u0000\u0000\u00f61\u0001\u0000\u0000\u0000"+
		"\u00f7\u00f8\u0005\u0007\u0000\u0000\u00f8\u00f9\u0003,\u0016\u0000\u00f9"+
		"3\u0001\u0000\u0000\u0000\u00fa\u00fe\u00036\u001b\u0000\u00fb\u00fe\u0005"+
		"\u0018\u0000\u0000\u00fc\u00fe\u0005\u001d\u0000\u0000\u00fd\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000\u0000\u0000\u00fd\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fe5\u0001\u0000\u0000\u0000\u00ff\u0100\u0005\u0017"+
		"\u0000\u0000\u0100\u0101\u0005\u001c\u0000\u0000\u01017\u0001\u0000\u0000"+
		"\u0000\u0102\u0103\u0007\u0002\u0000\u0000\u01039\u0001\u0000\u0000\u0000"+
		"\u0016?FOZdlz\u0082\u008b\u009b\u00a3\u00b1\u00b9\u00be\u00c4\u00c9\u00d5"+
		"\u00df\u00e2\u00ed\u00f2\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}