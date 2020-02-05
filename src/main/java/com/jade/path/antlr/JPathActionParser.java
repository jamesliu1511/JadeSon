// Generated from JPathAction.g4 by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, Literal=24, 
		FLOAT=25, INT=26, Whitespace=27, NCName=28, Number=29;
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
			"Literal", "FLOAT", "INT", "Whitespace", "NCName", "Number"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\37\u0107\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\7\2@\n"+
		"\2\f\2\16\2C\13\2\3\2\3\2\3\2\3\2\5\2I\n\2\3\3\3\3\3\3\3\3\3\3\7\3P\n"+
		"\3\f\3\16\3S\13\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4]\n\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\7\3\7\5\7g\n\7\3\b\3\b\3\b\3\t\3\t\3\t\5\to\n\t\3\n\3\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13}\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\5\f\u0085\n\f\3\r\3\r\3\r\3\r\3\r\7\r\u008c\n\r\f\r\16"+
		"\r\u008f\13\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\7\20"+
		"\u009c\n\20\f\20\16\20\u009f\13\20\3\21\3\21\3\21\7\21\u00a4\n\21\f\21"+
		"\16\21\u00a7\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\7\23\u00b2"+
		"\n\23\f\23\16\23\u00b5\13\23\3\24\3\24\3\24\7\24\u00ba\n\24\f\24\16\24"+
		"\u00bd\13\24\3\25\3\25\5\25\u00c1\n\25\3\25\3\25\3\25\3\25\5\25\u00c7"+
		"\n\25\3\26\3\26\3\26\5\26\u00cc\n\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\7\30\u00d6\n\30\f\30\16\30\u00d9\13\30\3\31\3\31\3\31\3\31\3\31"+
		"\7\31\u00e0\n\31\f\31\16\31\u00e3\13\31\5\31\u00e5\n\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\7\31\u00ee\n\31\f\31\16\31\u00f1\13\31\3\31\3\31"+
		"\5\31\u00f5\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\5\34\u0100"+
		"\n\34\3\35\3\35\3\35\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:\2\5\3\2\22\23\4\2\20\21\24\26\3\2"+
		"\33\34\2\u0109\2<\3\2\2\2\4J\3\2\2\2\6\\\3\2\2\2\b^\3\2\2\2\na\3\2\2\2"+
		"\ff\3\2\2\2\16h\3\2\2\2\20n\3\2\2\2\22p\3\2\2\2\24|\3\2\2\2\26\u0084\3"+
		"\2\2\2\30\u0086\3\2\2\2\32\u0092\3\2\2\2\34\u0095\3\2\2\2\36\u0098\3\2"+
		"\2\2 \u00a0\3\2\2\2\"\u00a8\3\2\2\2$\u00ae\3\2\2\2&\u00b6\3\2\2\2(\u00c6"+
		"\3\2\2\2*\u00c8\3\2\2\2,\u00cf\3\2\2\2.\u00d2\3\2\2\2\60\u00f4\3\2\2\2"+
		"\62\u00f6\3\2\2\2\64\u00f9\3\2\2\2\66\u00ff\3\2\2\28\u0101\3\2\2\2:\u0104"+
		"\3\2\2\2<A\5\f\7\2=>\7\3\2\2>@\5\f\7\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2A"+
		"B\3\2\2\2BH\3\2\2\2CA\3\2\2\2DE\7\4\2\2EF\5\4\3\2FG\7\5\2\2GI\3\2\2\2"+
		"HD\3\2\2\2HI\3\2\2\2I\3\3\2\2\2JK\5\n\6\2KL\7\6\2\2LQ\5\6\4\2MN\7\7\2"+
		"\2NP\5\6\4\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RT\3\2\2\2SQ\3\2\2"+
		"\2TU\7\b\2\2U\5\3\2\2\2VW\7\t\2\2W]\7\36\2\2X]\58\35\2Y]\7\32\2\2Z]\5"+
		"\b\5\2[]\7\34\2\2\\V\3\2\2\2\\X\3\2\2\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2"+
		"\2]\7\3\2\2\2^_\7\t\2\2_`\7\32\2\2`\t\3\2\2\2ab\7\n\2\2bc\7\36\2\2c\13"+
		"\3\2\2\2dg\5\16\b\2eg\5\20\t\2fd\3\2\2\2fe\3\2\2\2g\r\3\2\2\2hi\5\20\t"+
		"\2ij\5\24\13\2j\17\3\2\2\2ko\7\36\2\2lo\7\32\2\2mo\5\22\n\2nk\3\2\2\2"+
		"nl\3\2\2\2nm\3\2\2\2o\21\3\2\2\2pq\7\13\2\2q\23\3\2\2\2rs\7\4\2\2st\5"+
		"\26\f\2tu\7\5\2\2u}\3\2\2\2vw\7\f\2\2w}\5&\24\2xy\7\r\2\2yz\5$\23\2z{"+
		"\7\16\2\2{}\3\2\2\2|r\3\2\2\2|v\3\2\2\2|x\3\2\2\2}\25\3\2\2\2~\u0085\5"+
		" \21\2\177\u0085\5\36\20\2\u0080\u0085\5&\24\2\u0081\u0085\5\30\r\2\u0082"+
		"\u0085\5\34\17\2\u0083\u0085\5\22\n\2\u0084~\3\2\2\2\u0084\177\3\2\2\2"+
		"\u0084\u0080\3\2\2\2\u0084\u0081\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0083"+
		"\3\2\2\2\u0085\27\3\2\2\2\u0086\u0087\5\32\16\2\u0087\u0088\7\6\2\2\u0088"+
		"\u008d\5\64\33\2\u0089\u008a\7\7\2\2\u008a\u008c\5\64\33\2\u008b\u0089"+
		"\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e"+
		"\u0090\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0091\7\b\2\2\u0091\31\3\2\2"+
		"\2\u0092\u0093\7\17\2\2\u0093\u0094\7\36\2\2\u0094\33\3\2\2\2\u0095\u0096"+
		"\7\t\2\2\u0096\u0097\7\36\2\2\u0097\35\3\2\2\2\u0098\u009d\7\34\2\2\u0099"+
		"\u009a\7\7\2\2\u009a\u009c\7\34\2\2\u009b\u0099\3\2\2\2\u009c\u009f\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\37\3\2\2\2\u009f"+
		"\u009d\3\2\2\2\u00a0\u00a5\5\"\22\2\u00a1\u00a2\7\7\2\2\u00a2\u00a4\5"+
		"\"\22\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3\2\2\2\u00a5\u00a3\3\2\2\2\u00a5"+
		"\u00a6\3\2\2\2\u00a6!\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a8\u00a9\7\20\2\2"+
		"\u00a9\u00aa\7\34\2\2\u00aa\u00ab\7\7\2\2\u00ab\u00ac\7\34\2\2\u00ac\u00ad"+
		"\7\21\2\2\u00ad#\3\2\2\2\u00ae\u00b3\7\36\2\2\u00af\u00b0\7\7\2\2\u00b0"+
		"\u00b2\7\36\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3"+
		"\2\2\2\u00b3\u00b4\3\2\2\2\u00b4%\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00bb"+
		"\5(\25\2\u00b7\u00b8\t\2\2\2\u00b8\u00ba\5(\25\2\u00b9\u00b7\3\2\2\2\u00ba"+
		"\u00bd\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\'\3\2\2\2"+
		"\u00bd\u00bb\3\2\2\2\u00be\u00c1\5.\30\2\u00bf\u00c1\5*\26\2\u00c0\u00be"+
		"\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\t\3\2\2\u00c3"+
		"\u00c4\5:\36\2\u00c4\u00c7\3\2\2\2\u00c5\u00c7\5\60\31\2\u00c6\u00c0\3"+
		"\2\2\2\u00c6\u00c5\3\2\2\2\u00c7)\3\2\2\2\u00c8\u00c9\5,\27\2\u00c9\u00cb"+
		"\7\6\2\2\u00ca\u00cc\5\64\33\2\u00cb\u00ca\3\2\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cc\u00cd\3\2\2\2\u00cd\u00ce\7\b\2\2\u00ce+\3\2\2\2\u00cf\u00d0\7"+
		"\27\2\2\u00d0\u00d1\7\36\2\2\u00d1-\3\2\2\2\u00d2\u00d7\5\f\7\2\u00d3"+
		"\u00d4\7\3\2\2\u00d4\u00d6\5\f\7\2\u00d5\u00d3\3\2\2\2\u00d6\u00d9\3\2"+
		"\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8/\3\2\2\2\u00d9\u00d7"+
		"\3\2\2\2\u00da\u00db\5\62\32\2\u00db\u00e4\7\6\2\2\u00dc\u00e1\5\66\34"+
		"\2\u00dd\u00de\7\7\2\2\u00de\u00e0\5\66\34\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e5\3\2"+
		"\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00dc\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5"+
		"\u00e6\3\2\2\2\u00e6\u00e7\7\b\2\2\u00e7\u00f5\3\2\2\2\u00e8\u00e9\5\62"+
		"\32\2\u00e9\u00ea\7\6\2\2\u00ea\u00ef\5\64\33\2\u00eb\u00ec\7\7\2\2\u00ec"+
		"\u00ee\5\66\34\2\u00ed\u00eb\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3"+
		"\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f3\7\b\2\2\u00f3\u00f5\3\2\2\2\u00f4\u00da\3\2\2\2\u00f4\u00e8\3\2"+
		"\2\2\u00f5\61\3\2\2\2\u00f6\u00f7\7\30\2\2\u00f7\u00f8\7\36\2\2\u00f8"+
		"\63\3\2\2\2\u00f9\u00fa\7\t\2\2\u00fa\u00fb\5.\30\2\u00fb\65\3\2\2\2\u00fc"+
		"\u0100\58\35\2\u00fd\u0100\7\32\2\2\u00fe\u0100\7\37\2\2\u00ff\u00fc\3"+
		"\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100\67\3\2\2\2\u0101"+
		"\u0102\7\31\2\2\u0102\u0103\7\36\2\2\u01039\3\2\2\2\u0104\u0105\t\4\2"+
		"\2\u0105;\3\2\2\2\30AHQ\\fn|\u0084\u008d\u009d\u00a5\u00b3\u00bb\u00c0"+
		"\u00c6\u00cb\u00d7\u00e1\u00e4\u00ef\u00f4\u00ff";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}