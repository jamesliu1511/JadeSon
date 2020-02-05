// Generated from JPath.g4 by ANTLR 4.7.2

	package com.jade.path.antlr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class JPathLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, Literal=23, FLOAT=24, 
		INT=25, Whitespace=26, NCName=27, Number=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "Literal", "FLOAT", "INT", 
			"Whitespace", "NCName", "Number", "Digits", "NCNameStartChar", "NCNameChar"
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


	public JPathLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JPath.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00c7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\7\30{\n\30\f\30"+
		"\16\30~\13\30\3\30\3\30\3\30\7\30\u0083\n\30\f\30\16\30\u0086\13\30\3"+
		"\30\5\30\u0089\n\30\3\31\5\31\u008c\n\31\3\31\6\31\u008f\n\31\r\31\16"+
		"\31\u0090\3\31\3\31\6\31\u0095\n\31\r\31\16\31\u0096\3\32\5\32\u009a\n"+
		"\32\3\32\6\32\u009d\n\32\r\32\16\32\u009e\3\33\6\33\u00a2\n\33\r\33\16"+
		"\33\u00a3\3\33\3\33\3\34\3\34\7\34\u00aa\n\34\f\34\16\34\u00ad\13\34\3"+
		"\35\5\35\u00b0\n\35\3\35\3\35\3\35\5\35\u00b5\n\35\5\35\u00b7\n\35\3\35"+
		"\3\35\5\35\u00bb\n\35\3\36\6\36\u00be\n\36\r\36\16\36\u00bf\3\37\3\37"+
		"\3 \3 \5 \u00c6\n \2\2!\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\2=\2?\2\3\2\b\3\2$$\3\2))\3\2\62;\5\2\13\f\17\17"+
		"\"\"\20\2C\\aac|\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381"+
		"\u2001\u200e\u200f\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2"+
		"\uffff\7\2/\60\62;\u00b9\u00b9\u0302\u0371\u2041\u2042\2\u00d3\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3A\3\2\2\2\5"+
		"C\3\2\2\2\7E\3\2\2\2\tG\3\2\2\2\13I\3\2\2\2\rK\3\2\2\2\17M\3\2\2\2\21"+
		"O\3\2\2\2\23Q\3\2\2\2\25S\3\2\2\2\27W\3\2\2\2\31Y\3\2\2\2\33[\3\2\2\2"+
		"\35]\3\2\2\2\37`\3\2\2\2!c\3\2\2\2#f\3\2\2\2%i\3\2\2\2\'l\3\2\2\2)p\3"+
		"\2\2\2+r\3\2\2\2-v\3\2\2\2/\u0088\3\2\2\2\61\u008b\3\2\2\2\63\u0099\3"+
		"\2\2\2\65\u00a1\3\2\2\2\67\u00a7\3\2\2\29\u00ba\3\2\2\2;\u00bd\3\2\2\2"+
		"=\u00c1\3\2\2\2?\u00c5\3\2\2\2AB\7,\2\2B\4\3\2\2\2CD\7]\2\2D\6\3\2\2\2"+
		"EF\7_\2\2F\b\3\2\2\2GH\7A\2\2H\n\3\2\2\2IJ\7}\2\2J\f\3\2\2\2KL\7\177\2"+
		"\2L\16\3\2\2\2MN\7*\2\2N\20\3\2\2\2OP\7.\2\2P\22\3\2\2\2QR\7+\2\2R\24"+
		"\3\2\2\2ST\7h\2\2TU\7v\2\2UV\7<\2\2V\26\3\2\2\2WX\7B\2\2X\30\3\2\2\2Y"+
		"Z\7>\2\2Z\32\3\2\2\2[\\\7@\2\2\\\34\3\2\2\2]^\7~\2\2^_\7~\2\2_\36\3\2"+
		"\2\2`a\7(\2\2ab\7(\2\2b \3\2\2\2cd\7>\2\2de\7?\2\2e\"\3\2\2\2fg\7@\2\2"+
		"gh\7?\2\2h$\3\2\2\2ij\7?\2\2jk\7?\2\2k&\3\2\2\2lm\7h\2\2mn\7x\2\2no\7"+
		"<\2\2o(\3\2\2\2pq\7\61\2\2q*\3\2\2\2rs\7h\2\2st\7p\2\2tu\7<\2\2u,\3\2"+
		"\2\2vw\7&\2\2w.\3\2\2\2x|\7$\2\2y{\n\2\2\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2"+
		"\2|}\3\2\2\2}\177\3\2\2\2~|\3\2\2\2\177\u0089\7$\2\2\u0080\u0084\7)\2"+
		"\2\u0081\u0083\n\3\2\2\u0082\u0081\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082"+
		"\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0087\3\2\2\2\u0086\u0084\3\2\2\2\u0087"+
		"\u0089\7)\2\2\u0088x\3\2\2\2\u0088\u0080\3\2\2\2\u0089\60\3\2\2\2\u008a"+
		"\u008c\7/\2\2\u008b\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2"+
		"\2\2\u008d\u008f\t\4\2\2\u008e\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\7\60"+
		"\2\2\u0093\u0095\t\4\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\62\3\2\2\2\u0098\u009a\7/\2\2"+
		"\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d"+
		"\t\4\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009f\3\2\2\2\u009f\64\3\2\2\2\u00a0\u00a2\t\5\2\2\u00a1\u00a0\3\2\2"+
		"\2\u00a2\u00a3\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
		"\3\2\2\2\u00a5\u00a6\b\33\2\2\u00a6\66\3\2\2\2\u00a7\u00ab\5=\37\2\u00a8"+
		"\u00aa\5? \2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3\2\2"+
		"\2\u00ab\u00ac\3\2\2\2\u00ac8\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae\u00b0"+
		"\7/\2\2\u00af\u00ae\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1"+
		"\u00b6\5;\36\2\u00b2\u00b4\7\60\2\2\u00b3\u00b5\5;\36\2\u00b4\u00b3\3"+
		"\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6"+
		"\u00b7\3\2\2\2\u00b7\u00bb\3\2\2\2\u00b8\u00b9\7\60\2\2\u00b9\u00bb\5"+
		";\36\2\u00ba\u00af\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb:\3\2\2\2\u00bc\u00be"+
		"\4\62;\2\u00bd\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0<\3\2\2\2\u00c1\u00c2\t\6\2\2\u00c2>\3\2\2\2\u00c3"+
		"\u00c6\5=\37\2\u00c4\u00c6\t\7\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c4\3\2"+
		"\2\2\u00c6@\3\2\2\2\23\2|\u0084\u0088\u008b\u0090\u0096\u0099\u009e\u00a3"+
		"\u00ab\u00af\u00b4\u00b6\u00ba\u00bf\u00c5\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}