// Generated from java_engine/src/gapi/uosql/UOSQL.g4 by ANTLR 4.13.2
package gapi.uosql;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class UOSQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, CONNECT=22, TRAVERSE=23, FIND=24, 
		WHERE=25, AND=26, OR=27, KIND=28, BOOLEAN=29, IDENT=30, STRING=31, NUMBER=32, 
		WS=33;
	public static final int
		RULE_uosqlProgram = 0, RULE_statement = 1, RULE_connectStmt = 2, RULE_chainLink = 3, 
		RULE_edgeOp = 4, RULE_edgeAttrs = 5, RULE_traverseStmt = 6, RULE_traverseLink = 7, 
		RULE_findStmt = 8, RULE_entityStmt = 9, RULE_entityDecl = 10, RULE_entityRef = 11, 
		RULE_entitySelector = 12, RULE_entityAttrs = 13, RULE_attrPair = 14, RULE_conditionExpr = 15, 
		RULE_conditionTerm = 16, RULE_conditionFactor = 17, RULE_compOp = 18, 
		RULE_value = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"uosqlProgram", "statement", "connectStmt", "chainLink", "edgeOp", "edgeAttrs", 
			"traverseStmt", "traverseLink", "findStmt", "entityStmt", "entityDecl", 
			"entityRef", "entitySelector", "entityAttrs", "attrPair", "conditionExpr", 
			"conditionTerm", "conditionFactor", "compOp", "value"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'->'", "'<-'", "'<->'", "'--'", "'['", "','", "']'", "'*'", 
			"'('", "')'", "'{'", "'}'", "'='", "'=='", "'!='", "'>='", "'<='", "'>'", 
			"'<'", "'CONTAINS'", "'CONNECT'", "'TRAVERSE'", "'FIND'", "'WHERE'", 
			"'AND'", "'OR'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "CONNECT", 
			"TRAVERSE", "FIND", "WHERE", "AND", "OR", "KIND", "BOOLEAN", "IDENT", 
			"STRING", "NUMBER", "WS"
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
	public String getGrammarFileName() { return "UOSQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public UOSQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UosqlProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(UOSQLParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public UosqlProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_uosqlProgram; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterUosqlProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitUosqlProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitUosqlProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UosqlProgramContext uosqlProgram() throws RecognitionException {
		UosqlProgramContext _localctx = new UosqlProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_uosqlProgram);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 297795584L) != 0)) {
				{
				{
				setState(40);
				statement();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public ConnectStmtContext connectStmt() {
			return getRuleContext(ConnectStmtContext.class,0);
		}
		public TraverseStmtContext traverseStmt() {
			return getRuleContext(TraverseStmtContext.class,0);
		}
		public FindStmtContext findStmt() {
			return getRuleContext(FindStmtContext.class,0);
		}
		public EntityStmtContext entityStmt() {
			return getRuleContext(EntityStmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(60);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONNECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				connectStmt();
				setState(49);
				match(T__0);
				}
				break;
			case TRAVERSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				traverseStmt();
				setState(52);
				match(T__0);
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 3);
				{
				setState(54);
				findStmt();
				setState(55);
				match(T__0);
				}
				break;
			case KIND:
				enterOuterAlt(_localctx, 4);
				{
				setState(57);
				entityStmt();
				setState(58);
				match(T__0);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConnectStmtContext extends ParserRuleContext {
		public TerminalNode CONNECT() { return getToken(UOSQLParser.CONNECT, 0); }
		public EntityRefContext entityRef() {
			return getRuleContext(EntityRefContext.class,0);
		}
		public EdgeAttrsContext edgeAttrs() {
			return getRuleContext(EdgeAttrsContext.class,0);
		}
		public List<ChainLinkContext> chainLink() {
			return getRuleContexts(ChainLinkContext.class);
		}
		public ChainLinkContext chainLink(int i) {
			return getRuleContext(ChainLinkContext.class,i);
		}
		public ConnectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_connectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterConnectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitConnectStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitConnectStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConnectStmtContext connectStmt() throws RecognitionException {
		ConnectStmtContext _localctx = new ConnectStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_connectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CONNECT);
			setState(63);
			entityRef();
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(64);
				edgeAttrs();
				}
			}

			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 60L) != 0)) {
				{
				{
				setState(67);
				chainLink();
				}
				}
				setState(72);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ChainLinkContext extends ParserRuleContext {
		public EdgeOpContext edgeOp() {
			return getRuleContext(EdgeOpContext.class,0);
		}
		public EntityRefContext entityRef() {
			return getRuleContext(EntityRefContext.class,0);
		}
		public List<EdgeAttrsContext> edgeAttrs() {
			return getRuleContexts(EdgeAttrsContext.class);
		}
		public EdgeAttrsContext edgeAttrs(int i) {
			return getRuleContext(EdgeAttrsContext.class,i);
		}
		public ChainLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterChainLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitChainLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitChainLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChainLinkContext chainLink() throws RecognitionException {
		ChainLinkContext _localctx = new ChainLinkContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_chainLink);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			edgeOp();
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(74);
				edgeAttrs();
				}
			}

			setState(77);
			entityRef();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(78);
				edgeAttrs();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EdgeOpContext extends ParserRuleContext {
		public EdgeOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEdgeOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEdgeOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEdgeOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeOpContext edgeOp() throws RecognitionException {
		EdgeOpContext _localctx = new EdgeOpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_edgeOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 60L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class EdgeAttrsContext extends ParserRuleContext {
		public List<AttrPairContext> attrPair() {
			return getRuleContexts(AttrPairContext.class);
		}
		public AttrPairContext attrPair(int i) {
			return getRuleContext(AttrPairContext.class,i);
		}
		public EdgeAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_edgeAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEdgeAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEdgeAttrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEdgeAttrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EdgeAttrsContext edgeAttrs() throws RecognitionException {
		EdgeAttrsContext _localctx = new EdgeAttrsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_edgeAttrs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(T__5);
			setState(84);
			attrPair();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(85);
				match(T__6);
				setState(86);
				attrPair();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TraverseStmtContext extends ParserRuleContext {
		public TerminalNode TRAVERSE() { return getToken(UOSQLParser.TRAVERSE, 0); }
		public EntityRefContext entityRef() {
			return getRuleContext(EntityRefContext.class,0);
		}
		public List<TraverseLinkContext> traverseLink() {
			return getRuleContexts(TraverseLinkContext.class);
		}
		public TraverseLinkContext traverseLink(int i) {
			return getRuleContext(TraverseLinkContext.class,i);
		}
		public TerminalNode WHERE() { return getToken(UOSQLParser.WHERE, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public TraverseStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traverseStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterTraverseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitTraverseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitTraverseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraverseStmtContext traverseStmt() throws RecognitionException {
		TraverseStmtContext _localctx = new TraverseStmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_traverseStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(TRAVERSE);
			setState(95);
			entityRef();
			setState(97); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(96);
				traverseLink();
				}
				}
				setState(99); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 60L) != 0) );
			setState(103);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(101);
				match(WHERE);
				setState(102);
				conditionExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class TraverseLinkContext extends ParserRuleContext {
		public EdgeOpContext edgeOp() {
			return getRuleContext(EdgeOpContext.class,0);
		}
		public EntitySelectorContext entitySelector() {
			return getRuleContext(EntitySelectorContext.class,0);
		}
		public List<EdgeAttrsContext> edgeAttrs() {
			return getRuleContexts(EdgeAttrsContext.class);
		}
		public EdgeAttrsContext edgeAttrs(int i) {
			return getRuleContext(EdgeAttrsContext.class,i);
		}
		public TraverseLinkContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traverseLink; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterTraverseLink(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitTraverseLink(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitTraverseLink(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TraverseLinkContext traverseLink() throws RecognitionException {
		TraverseLinkContext _localctx = new TraverseLinkContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_traverseLink);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			edgeOp();
			setState(107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(106);
				edgeAttrs();
				}
			}

			setState(109);
			entitySelector();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(110);
				edgeAttrs();
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

	@SuppressWarnings("CheckReturnValue")
	public static class FindStmtContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(UOSQLParser.FIND, 0); }
		public TerminalNode KIND() { return getToken(UOSQLParser.KIND, 0); }
		public TerminalNode WHERE() { return getToken(UOSQLParser.WHERE, 0); }
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public FindStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_findStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterFindStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitFindStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitFindStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindStmtContext findStmt() throws RecognitionException {
		FindStmtContext _localctx = new FindStmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_findStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(FIND);
			setState(114);
			_la = _input.LA(1);
			if ( !(_la==T__8 || _la==KIND) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(115);
				match(WHERE);
				setState(116);
				conditionExpr();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntityStmtContext extends ParserRuleContext {
		public EntityDeclContext entityDecl() {
			return getRuleContext(EntityDeclContext.class,0);
		}
		public EntityStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEntityStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEntityStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEntityStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityStmtContext entityStmt() throws RecognitionException {
		EntityStmtContext _localctx = new EntityStmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_entityStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			entityDecl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntityDeclContext extends ParserRuleContext {
		public TerminalNode KIND() { return getToken(UOSQLParser.KIND, 0); }
		public TerminalNode STRING() { return getToken(UOSQLParser.STRING, 0); }
		public EntityAttrsContext entityAttrs() {
			return getRuleContext(EntityAttrsContext.class,0);
		}
		public EntityDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEntityDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEntityDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEntityDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityDeclContext entityDecl() throws RecognitionException {
		EntityDeclContext _localctx = new EntityDeclContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_entityDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			match(KIND);
			setState(122);
			match(T__9);
			setState(123);
			match(STRING);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(124);
				match(T__6);
				setState(125);
				entityAttrs();
				}
			}

			setState(128);
			match(T__10);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntityRefContext extends ParserRuleContext {
		public TerminalNode KIND() { return getToken(UOSQLParser.KIND, 0); }
		public TerminalNode STRING() { return getToken(UOSQLParser.STRING, 0); }
		public EntityRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEntityRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEntityRef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEntityRef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityRefContext entityRef() throws RecognitionException {
		EntityRefContext _localctx = new EntityRefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_entityRef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(KIND);
			setState(131);
			match(T__9);
			setState(132);
			match(STRING);
			setState(133);
			match(T__10);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntitySelectorContext extends ParserRuleContext {
		public TerminalNode KIND() { return getToken(UOSQLParser.KIND, 0); }
		public TerminalNode STRING() { return getToken(UOSQLParser.STRING, 0); }
		public EntitySelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entitySelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEntitySelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEntitySelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEntitySelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntitySelectorContext entitySelector() throws RecognitionException {
		EntitySelectorContext _localctx = new EntitySelectorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_entitySelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(KIND);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(136);
				match(T__9);
				setState(137);
				_la = _input.LA(1);
				if ( !(_la==T__8 || _la==STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(138);
				match(T__10);
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

	@SuppressWarnings("CheckReturnValue")
	public static class EntityAttrsContext extends ParserRuleContext {
		public List<AttrPairContext> attrPair() {
			return getRuleContexts(AttrPairContext.class);
		}
		public AttrPairContext attrPair(int i) {
			return getRuleContext(AttrPairContext.class,i);
		}
		public EntityAttrsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entityAttrs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterEntityAttrs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitEntityAttrs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitEntityAttrs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EntityAttrsContext entityAttrs() throws RecognitionException {
		EntityAttrsContext _localctx = new EntityAttrsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_entityAttrs);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(141);
				match(T__11);
				setState(142);
				attrPair();
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(143);
					match(T__6);
					setState(144);
					attrPair();
					}
					}
					setState(149);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(150);
				match(T__12);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				match(T__5);
				setState(153);
				attrPair();
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(154);
					match(T__6);
					setState(155);
					attrPair();
					}
					}
					setState(160);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(161);
				match(T__7);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AttrPairContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(UOSQLParser.IDENT, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public AttrPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterAttrPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitAttrPair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitAttrPair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrPairContext attrPair() throws RecognitionException {
		AttrPairContext _localctx = new AttrPairContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attrPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(IDENT);
			setState(166);
			match(T__13);
			setState(167);
			value();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionExprContext extends ParserRuleContext {
		public List<ConditionTermContext> conditionTerm() {
			return getRuleContexts(ConditionTermContext.class);
		}
		public ConditionTermContext conditionTerm(int i) {
			return getRuleContext(ConditionTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(UOSQLParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(UOSQLParser.OR, i);
		}
		public ConditionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterConditionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitConditionExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitConditionExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionExprContext conditionExpr() throws RecognitionException {
		ConditionExprContext _localctx = new ConditionExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_conditionExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			conditionTerm();
			setState(174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(170);
				match(OR);
				setState(171);
				conditionTerm();
				}
				}
				setState(176);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionTermContext extends ParserRuleContext {
		public List<ConditionFactorContext> conditionFactor() {
			return getRuleContexts(ConditionFactorContext.class);
		}
		public ConditionFactorContext conditionFactor(int i) {
			return getRuleContext(ConditionFactorContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(UOSQLParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(UOSQLParser.AND, i);
		}
		public ConditionTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterConditionTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitConditionTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitConditionTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionTermContext conditionTerm() throws RecognitionException {
		ConditionTermContext _localctx = new ConditionTermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_conditionTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			conditionFactor();
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(178);
				match(AND);
				setState(179);
				conditionFactor();
				}
				}
				setState(184);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionFactorContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(UOSQLParser.IDENT, 0); }
		public CompOpContext compOp() {
			return getRuleContext(CompOpContext.class,0);
		}
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ConditionExprContext conditionExpr() {
			return getRuleContext(ConditionExprContext.class,0);
		}
		public ConditionFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterConditionFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitConditionFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitConditionFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionFactorContext conditionFactor() throws RecognitionException {
		ConditionFactorContext _localctx = new ConditionFactorContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_conditionFactor);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(185);
				match(IDENT);
				setState(186);
				compOp();
				setState(187);
				value();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__9);
				setState(190);
				conditionExpr();
				setState(191);
				match(T__10);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CompOpContext extends ParserRuleContext {
		public CompOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compOp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterCompOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitCompOp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitCompOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompOpContext compOp() throws RecognitionException {
		CompOpContext _localctx = new CompOpContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_compOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4177920L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(UOSQLParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(UOSQLParser.NUMBER, 0); }
		public TerminalNode BOOLEAN() { return getToken(UOSQLParser.BOOLEAN, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof UOSQLListener ) ((UOSQLListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof UOSQLVisitor ) return ((UOSQLVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6979321856L) != 0)) ) {
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
		"\u0004\u0001!\u00c8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001=\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0003\u0002B\b\u0002\u0001\u0002\u0005\u0002"+
		"E\b\u0002\n\u0002\f\u0002H\t\u0002\u0001\u0003\u0001\u0003\u0003\u0003"+
		"L\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003P\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005X\b"+
		"\u0005\n\u0005\f\u0005[\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0004\u0006b\b\u0006\u000b\u0006\f\u0006c\u0001\u0006"+
		"\u0001\u0006\u0003\u0006h\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007"+
		"l\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007p\b\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0003\bv\b\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\n\u007f\b\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0003"+
		"\f\u008c\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u0092\b\r\n\r\f\r"+
		"\u0095\t\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0005\r\u009d"+
		"\b\r\n\r\f\r\u00a0\t\r\u0001\r\u0001\r\u0003\r\u00a4\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005"+
		"\u000f\u00ad\b\u000f\n\u000f\f\u000f\u00b0\t\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00b5\b\u0010\n\u0010\f\u0010\u00b8\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0003\u0011\u00c2\b\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0000\u0000\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0005\u0001\u0000\u0002\u0005\u0002\u0000\t\t\u001c\u001c\u0002\u0000"+
		"\t\t\u001f\u001f\u0001\u0000\u000e\u0015\u0002\u0000\u001d\u001d\u001f"+
		" \u00c9\u0000+\u0001\u0000\u0000\u0000\u0002<\u0001\u0000\u0000\u0000"+
		"\u0004>\u0001\u0000\u0000\u0000\u0006I\u0001\u0000\u0000\u0000\bQ\u0001"+
		"\u0000\u0000\u0000\nS\u0001\u0000\u0000\u0000\f^\u0001\u0000\u0000\u0000"+
		"\u000ei\u0001\u0000\u0000\u0000\u0010q\u0001\u0000\u0000\u0000\u0012w"+
		"\u0001\u0000\u0000\u0000\u0014y\u0001\u0000\u0000\u0000\u0016\u0082\u0001"+
		"\u0000\u0000\u0000\u0018\u0087\u0001\u0000\u0000\u0000\u001a\u00a3\u0001"+
		"\u0000\u0000\u0000\u001c\u00a5\u0001\u0000\u0000\u0000\u001e\u00a9\u0001"+
		"\u0000\u0000\u0000 \u00b1\u0001\u0000\u0000\u0000\"\u00c1\u0001\u0000"+
		"\u0000\u0000$\u00c3\u0001\u0000\u0000\u0000&\u00c5\u0001\u0000\u0000\u0000"+
		"(*\u0003\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000"+
		"\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000"+
		"\u0000\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/\u0001"+
		"\u0001\u0000\u0000\u000001\u0003\u0004\u0002\u000012\u0005\u0001\u0000"+
		"\u00002=\u0001\u0000\u0000\u000034\u0003\f\u0006\u000045\u0005\u0001\u0000"+
		"\u00005=\u0001\u0000\u0000\u000067\u0003\u0010\b\u000078\u0005\u0001\u0000"+
		"\u00008=\u0001\u0000\u0000\u00009:\u0003\u0012\t\u0000:;\u0005\u0001\u0000"+
		"\u0000;=\u0001\u0000\u0000\u0000<0\u0001\u0000\u0000\u0000<3\u0001\u0000"+
		"\u0000\u0000<6\u0001\u0000\u0000\u0000<9\u0001\u0000\u0000\u0000=\u0003"+
		"\u0001\u0000\u0000\u0000>?\u0005\u0016\u0000\u0000?A\u0003\u0016\u000b"+
		"\u0000@B\u0003\n\u0005\u0000A@\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000"+
		"\u0000BF\u0001\u0000\u0000\u0000CE\u0003\u0006\u0003\u0000DC\u0001\u0000"+
		"\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001"+
		"\u0000\u0000\u0000G\u0005\u0001\u0000\u0000\u0000HF\u0001\u0000\u0000"+
		"\u0000IK\u0003\b\u0004\u0000JL\u0003\n\u0005\u0000KJ\u0001\u0000\u0000"+
		"\u0000KL\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MO\u0003\u0016"+
		"\u000b\u0000NP\u0003\n\u0005\u0000ON\u0001\u0000\u0000\u0000OP\u0001\u0000"+
		"\u0000\u0000P\u0007\u0001\u0000\u0000\u0000QR\u0007\u0000\u0000\u0000"+
		"R\t\u0001\u0000\u0000\u0000ST\u0005\u0006\u0000\u0000TY\u0003\u001c\u000e"+
		"\u0000UV\u0005\u0007\u0000\u0000VX\u0003\u001c\u000e\u0000WU\u0001\u0000"+
		"\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000YZ\u0001"+
		"\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000"+
		"\\]\u0005\b\u0000\u0000]\u000b\u0001\u0000\u0000\u0000^_\u0005\u0017\u0000"+
		"\u0000_a\u0003\u0016\u000b\u0000`b\u0003\u000e\u0007\u0000a`\u0001\u0000"+
		"\u0000\u0000bc\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000dg\u0001\u0000\u0000\u0000ef\u0005\u0019\u0000\u0000"+
		"fh\u0003\u001e\u000f\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000"+
		"\u0000h\r\u0001\u0000\u0000\u0000ik\u0003\b\u0004\u0000jl\u0003\n\u0005"+
		"\u0000kj\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000"+
		"\u0000\u0000mo\u0003\u0018\f\u0000np\u0003\n\u0005\u0000on\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000p\u000f\u0001\u0000\u0000\u0000"+
		"qr\u0005\u0018\u0000\u0000ru\u0007\u0001\u0000\u0000st\u0005\u0019\u0000"+
		"\u0000tv\u0003\u001e\u000f\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000"+
		"\u0000\u0000v\u0011\u0001\u0000\u0000\u0000wx\u0003\u0014\n\u0000x\u0013"+
		"\u0001\u0000\u0000\u0000yz\u0005\u001c\u0000\u0000z{\u0005\n\u0000\u0000"+
		"{~\u0005\u001f\u0000\u0000|}\u0005\u0007\u0000\u0000}\u007f\u0003\u001a"+
		"\r\u0000~|\u0001\u0000\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0001\u0000\u0000\u0000\u0080\u0081\u0005\u000b\u0000\u0000\u0081"+
		"\u0015\u0001\u0000\u0000\u0000\u0082\u0083\u0005\u001c\u0000\u0000\u0083"+
		"\u0084\u0005\n\u0000\u0000\u0084\u0085\u0005\u001f\u0000\u0000\u0085\u0086"+
		"\u0005\u000b\u0000\u0000\u0086\u0017\u0001\u0000\u0000\u0000\u0087\u008b"+
		"\u0005\u001c\u0000\u0000\u0088\u0089\u0005\n\u0000\u0000\u0089\u008a\u0007"+
		"\u0002\u0000\u0000\u008a\u008c\u0005\u000b\u0000\u0000\u008b\u0088\u0001"+
		"\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u0019\u0001"+
		"\u0000\u0000\u0000\u008d\u008e\u0005\f\u0000\u0000\u008e\u0093\u0003\u001c"+
		"\u000e\u0000\u008f\u0090\u0005\u0007\u0000\u0000\u0090\u0092\u0003\u001c"+
		"\u000e\u0000\u0091\u008f\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000"+
		"\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000"+
		"\u0000\u0000\u0096\u0097\u0005\r\u0000\u0000\u0097\u00a4\u0001\u0000\u0000"+
		"\u0000\u0098\u0099\u0005\u0006\u0000\u0000\u0099\u009e\u0003\u001c\u000e"+
		"\u0000\u009a\u009b\u0005\u0007\u0000\u0000\u009b\u009d\u0003\u001c\u000e"+
		"\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u00a0\u0001\u0000\u0000"+
		"\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u00a1\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000\u0000"+
		"\u0000\u00a1\u00a2\u0005\b\u0000\u0000\u00a2\u00a4\u0001\u0000\u0000\u0000"+
		"\u00a3\u008d\u0001\u0000\u0000\u0000\u00a3\u0098\u0001\u0000\u0000\u0000"+
		"\u00a4\u001b\u0001\u0000\u0000\u0000\u00a5\u00a6\u0005\u001e\u0000\u0000"+
		"\u00a6\u00a7\u0005\u000e\u0000\u0000\u00a7\u00a8\u0003&\u0013\u0000\u00a8"+
		"\u001d\u0001\u0000\u0000\u0000\u00a9\u00ae\u0003 \u0010\u0000\u00aa\u00ab"+
		"\u0005\u001b\u0000\u0000\u00ab\u00ad\u0003 \u0010\u0000\u00ac\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ad\u00b0\u0001\u0000\u0000\u0000\u00ae\u00ac\u0001"+
		"\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u001f\u0001"+
		"\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b6\u0003"+
		"\"\u0011\u0000\u00b2\u00b3\u0005\u001a\u0000\u0000\u00b3\u00b5\u0003\""+
		"\u0011\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5\u00b8\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b6\u00b7\u0001\u0000"+
		"\u0000\u0000\u00b7!\u0001\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000"+
		"\u0000\u00b9\u00ba\u0005\u001e\u0000\u0000\u00ba\u00bb\u0003$\u0012\u0000"+
		"\u00bb\u00bc\u0003&\u0013\u0000\u00bc\u00c2\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0005\n\u0000\u0000\u00be\u00bf\u0003\u001e\u000f\u0000\u00bf\u00c0"+
		"\u0005\u000b\u0000\u0000\u00c0\u00c2\u0001\u0000\u0000\u0000\u00c1\u00b9"+
		"\u0001\u0000\u0000\u0000\u00c1\u00bd\u0001\u0000\u0000\u0000\u00c2#\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c4\u0007\u0003\u0000\u0000\u00c4%\u0001\u0000"+
		"\u0000\u0000\u00c5\u00c6\u0007\u0004\u0000\u0000\u00c6\'\u0001\u0000\u0000"+
		"\u0000\u0014+<AFKOYcgkou~\u008b\u0093\u009e\u00a3\u00ae\u00b6\u00c1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}