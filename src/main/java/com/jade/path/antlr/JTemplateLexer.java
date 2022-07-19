// Generated from JTemplate.g4 by ANTLR 4.10.1

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
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, Literal=2, FLOAT=3, INT=4, NCName=5, Number=6, WS=7;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "Literal", "FLOAT", "INT", "NCName", "Number", "WS", "Digits", 
			"NCNameStartChar", "NCNameChar"
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
			null, null, "Literal", "FLOAT", "INT", "NCName", "Number", "WS"
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
		"\u0004\u0000\u0007f\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0005\u0001\u001a\b\u0001\n\u0001\f\u0001\u001d\t\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0005\u0001\"\b\u0001\n\u0001\f\u0001"+
		"%\t\u0001\u0001\u0001\u0003\u0001(\b\u0001\u0001\u0002\u0003\u0002+\b"+
		"\u0002\u0001\u0002\u0004\u0002.\b\u0002\u000b\u0002\f\u0002/\u0001\u0002"+
		"\u0001\u0002\u0004\u00024\b\u0002\u000b\u0002\f\u00025\u0001\u0003\u0003"+
		"\u00039\b\u0003\u0001\u0003\u0004\u0003<\b\u0003\u000b\u0003\f\u0003="+
		"\u0001\u0004\u0001\u0004\u0005\u0004B\b\u0004\n\u0004\f\u0004E\t\u0004"+
		"\u0001\u0005\u0003\u0005H\b\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005M\b\u0005\u0003\u0005O\b\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005S\b\u0005\u0001\u0006\u0004\u0006V\b\u0006\u000b\u0006\f\u0006W"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0004\u0007]\b\u0007\u000b\u0007"+
		"\f\u0007^\u0001\b\u0001\b\u0001\t\u0001\t\u0003\te\b\t\u0000\u0000\n\u0001"+
		"\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007"+
		"\u000f\u0000\u0011\u0000\u0013\u0000\u0001\u0000\u0006\u0001\u0000\"\""+
		"\u0001\u0000\'\'\u0001\u000009\u0003\u0000\t\n\r\r  \u000e\u0000AZ__a"+
		"z\u00c0\u00d6\u00d8\u00f6\u00f8\u02ff\u0370\u037d\u037f\u1fff\u200c\u200d"+
		"\u2070\u218f\u2c00\u2fef\u3001\u8000\ud7ff\u8000\uf900\u8000\ufdcf\u8000"+
		"\ufdf0\u8000\ufffd\u0005\u0000-.09\u00b7\u00b7\u0300\u036f\u203f\u2040"+
		"r\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0001\u0015\u0001\u0000\u0000\u0000\u0003\'"+
		"\u0001\u0000\u0000\u0000\u0005*\u0001\u0000\u0000\u0000\u00078\u0001\u0000"+
		"\u0000\u0000\t?\u0001\u0000\u0000\u0000\u000bR\u0001\u0000\u0000\u0000"+
		"\rU\u0001\u0000\u0000\u0000\u000f\\\u0001\u0000\u0000\u0000\u0011`\u0001"+
		"\u0000\u0000\u0000\u0013d\u0001\u0000\u0000\u0000\u0015\u0016\u0005/\u0000"+
		"\u0000\u0016\u0002\u0001\u0000\u0000\u0000\u0017\u001b\u0005\"\u0000\u0000"+
		"\u0018\u001a\b\u0000\u0000\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a"+
		"\u001d\u0001\u0000\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0001\u0000\u0000\u0000\u001c\u001e\u0001\u0000\u0000\u0000\u001d"+
		"\u001b\u0001\u0000\u0000\u0000\u001e(\u0005\"\u0000\u0000\u001f#\u0005"+
		"\'\u0000\u0000 \"\b\u0001\u0000\u0000! \u0001\u0000\u0000\u0000\"%\u0001"+
		"\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000"+
		"$&\u0001\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&(\u0005\'\u0000\u0000"+
		"\'\u0017\u0001\u0000\u0000\u0000\'\u001f\u0001\u0000\u0000\u0000(\u0004"+
		"\u0001\u0000\u0000\u0000)+\u0005-\u0000\u0000*)\u0001\u0000\u0000\u0000"+
		"*+\u0001\u0000\u0000\u0000+-\u0001\u0000\u0000\u0000,.\u0007\u0002\u0000"+
		"\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001\u0000"+
		"\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u000013\u0005"+
		".\u0000\u000024\u0007\u0002\u0000\u000032\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u0000"+
		"6\u0006\u0001\u0000\u0000\u000079\u0005-\u0000\u000087\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009;\u0001\u0000\u0000\u0000:<\u0007\u0002"+
		"\u0000\u0000;:\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=;\u0001"+
		"\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>\b\u0001\u0000\u0000\u0000"+
		"?C\u0003\u0011\b\u0000@B\u0003\u0013\t\u0000A@\u0001\u0000\u0000\u0000"+
		"BE\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000CD\u0001\u0000\u0000"+
		"\u0000D\n\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000FH\u0005-\u0000"+
		"\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001\u0000"+
		"\u0000\u0000IN\u0003\u000f\u0007\u0000JL\u0005.\u0000\u0000KM\u0003\u000f"+
		"\u0007\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0001"+
		"\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OS\u0001\u0000\u0000\u0000PQ\u0005.\u0000\u0000QS\u0003\u000f\u0007\u0000"+
		"RG\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000S\f\u0001\u0000\u0000"+
		"\u0000TV\u0007\u0003\u0000\u0000UT\u0001\u0000\u0000\u0000VW\u0001\u0000"+
		"\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XY\u0001"+
		"\u0000\u0000\u0000YZ\u0006\u0006\u0000\u0000Z\u000e\u0001\u0000\u0000"+
		"\u0000[]\u000209\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000"+
		"\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0010\u0001"+
		"\u0000\u0000\u0000`a\u0007\u0004\u0000\u0000a\u0012\u0001\u0000\u0000"+
		"\u0000be\u0003\u0011\b\u0000ce\u0007\u0005\u0000\u0000db\u0001\u0000\u0000"+
		"\u0000dc\u0001\u0000\u0000\u0000e\u0014\u0001\u0000\u0000\u0000\u0011"+
		"\u0000\u001b#\'*/58=CGLNRW^d\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}