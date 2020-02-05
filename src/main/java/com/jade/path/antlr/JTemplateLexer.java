// Generated from JTemplate.g4 by ANTLR 4.7.2

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
public class JTemplateLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Literal=2, FLOAT=3, INT=4, Whitespace=5, NCName=6, Number=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "Literal", "FLOAT", "INT", "Whitespace", "NCName", "Number", 
			"Digits", "NCNameStartChar", "NCNameChar"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "Literal", "FLOAT", "INT", "Whitespace", "NCName", "Number"
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


	public JTemplateLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "JTemplate.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\th\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\3\3\3\3\7\3\34\n\3\f\3\16\3\37\13\3\3\3\3\3\3\3\7\3$\n\3\f"+
		"\3\16\3\'\13\3\3\3\5\3*\n\3\3\4\5\4-\n\4\3\4\6\4\60\n\4\r\4\16\4\61\3"+
		"\4\3\4\6\4\66\n\4\r\4\16\4\67\3\5\5\5;\n\5\3\5\6\5>\n\5\r\5\16\5?\3\6"+
		"\6\6C\n\6\r\6\16\6D\3\6\3\6\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\3\b\5\bQ\n"+
		"\b\3\b\3\b\3\b\5\bV\n\b\5\bX\n\b\3\b\3\b\5\b\\\n\b\3\t\6\t_\n\t\r\t\16"+
		"\t`\3\n\3\n\3\13\3\13\5\13g\n\13\2\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\2\23\2\25\2\3\2\b\3\2$$\3\2))\3\2\62;\5\2\13\f\17\17\"\"\20\2C\\aac|"+
		"\u00c2\u00d8\u00da\u00f8\u00fa\u0301\u0372\u037f\u0381\u2001\u200e\u200f"+
		"\u2072\u2191\u2c02\u2ff1\u3003\ud801\uf902\ufdd1\ufdf2\uffff\7\2/\60\62"+
		";\u00b9\u00b9\u0302\u0371\u2041\u2042\2t\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\3\27\3\2\2\2"+
		"\5)\3\2\2\2\7,\3\2\2\2\t:\3\2\2\2\13B\3\2\2\2\rH\3\2\2\2\17[\3\2\2\2\21"+
		"^\3\2\2\2\23b\3\2\2\2\25f\3\2\2\2\27\30\7\61\2\2\30\4\3\2\2\2\31\35\7"+
		"$\2\2\32\34\n\2\2\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33\3\2\2\2\35\36\3"+
		"\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 *\7$\2\2!%\7)\2\2\"$\n\3\2\2#\"\3\2\2"+
		"\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&(\3\2\2\2\'%\3\2\2\2(*\7)\2\2)\31\3"+
		"\2\2\2)!\3\2\2\2*\6\3\2\2\2+-\7/\2\2,+\3\2\2\2,-\3\2\2\2-/\3\2\2\2.\60"+
		"\t\4\2\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2"+
		"\2\63\65\7\60\2\2\64\66\t\4\2\2\65\64\3\2\2\2\66\67\3\2\2\2\67\65\3\2"+
		"\2\2\678\3\2\2\28\b\3\2\2\29;\7/\2\2:9\3\2\2\2:;\3\2\2\2;=\3\2\2\2<>\t"+
		"\4\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\n\3\2\2\2AC\t\5\2\2BA"+
		"\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\b\6\2\2G\f\3\2\2\2"+
		"HL\5\23\n\2IK\5\25\13\2JI\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\16\3"+
		"\2\2\2NL\3\2\2\2OQ\7/\2\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RW\5\21\t\2SU\7"+
		"\60\2\2TV\5\21\t\2UT\3\2\2\2UV\3\2\2\2VX\3\2\2\2WS\3\2\2\2WX\3\2\2\2X"+
		"\\\3\2\2\2YZ\7\60\2\2Z\\\5\21\t\2[P\3\2\2\2[Y\3\2\2\2\\\20\3\2\2\2]_\4"+
		"\62;\2^]\3\2\2\2_`\3\2\2\2`^\3\2\2\2`a\3\2\2\2a\22\3\2\2\2bc\t\6\2\2c"+
		"\24\3\2\2\2dg\5\23\n\2eg\t\7\2\2fd\3\2\2\2fe\3\2\2\2g\26\3\2\2\2\23\2"+
		"\35%),\61\67:?DLPUW[`f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}