// Generated from java_engine/src/gapi/uosql/UOSQL.g4 by ANTLR 4.13.2
package gapi.uosql;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link UOSQLParser}.
 */
public interface UOSQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#uosqlProgram}.
	 * @param ctx the parse tree
	 */
	void enterUosqlProgram(UOSQLParser.UosqlProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#uosqlProgram}.
	 * @param ctx the parse tree
	 */
	void exitUosqlProgram(UOSQLParser.UosqlProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(UOSQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(UOSQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#connectStmt}.
	 * @param ctx the parse tree
	 */
	void enterConnectStmt(UOSQLParser.ConnectStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#connectStmt}.
	 * @param ctx the parse tree
	 */
	void exitConnectStmt(UOSQLParser.ConnectStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#chainLink}.
	 * @param ctx the parse tree
	 */
	void enterChainLink(UOSQLParser.ChainLinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#chainLink}.
	 * @param ctx the parse tree
	 */
	void exitChainLink(UOSQLParser.ChainLinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#edgeOp}.
	 * @param ctx the parse tree
	 */
	void enterEdgeOp(UOSQLParser.EdgeOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#edgeOp}.
	 * @param ctx the parse tree
	 */
	void exitEdgeOp(UOSQLParser.EdgeOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#edgeAttrs}.
	 * @param ctx the parse tree
	 */
	void enterEdgeAttrs(UOSQLParser.EdgeAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#edgeAttrs}.
	 * @param ctx the parse tree
	 */
	void exitEdgeAttrs(UOSQLParser.EdgeAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#traverseStmt}.
	 * @param ctx the parse tree
	 */
	void enterTraverseStmt(UOSQLParser.TraverseStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#traverseStmt}.
	 * @param ctx the parse tree
	 */
	void exitTraverseStmt(UOSQLParser.TraverseStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#traverseLink}.
	 * @param ctx the parse tree
	 */
	void enterTraverseLink(UOSQLParser.TraverseLinkContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#traverseLink}.
	 * @param ctx the parse tree
	 */
	void exitTraverseLink(UOSQLParser.TraverseLinkContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#findStmt}.
	 * @param ctx the parse tree
	 */
	void enterFindStmt(UOSQLParser.FindStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#findStmt}.
	 * @param ctx the parse tree
	 */
	void exitFindStmt(UOSQLParser.FindStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#entityStmt}.
	 * @param ctx the parse tree
	 */
	void enterEntityStmt(UOSQLParser.EntityStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#entityStmt}.
	 * @param ctx the parse tree
	 */
	void exitEntityStmt(UOSQLParser.EntityStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void enterEntityDecl(UOSQLParser.EntityDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#entityDecl}.
	 * @param ctx the parse tree
	 */
	void exitEntityDecl(UOSQLParser.EntityDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#entityRef}.
	 * @param ctx the parse tree
	 */
	void enterEntityRef(UOSQLParser.EntityRefContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#entityRef}.
	 * @param ctx the parse tree
	 */
	void exitEntityRef(UOSQLParser.EntityRefContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#entitySelector}.
	 * @param ctx the parse tree
	 */
	void enterEntitySelector(UOSQLParser.EntitySelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#entitySelector}.
	 * @param ctx the parse tree
	 */
	void exitEntitySelector(UOSQLParser.EntitySelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#entityAttrs}.
	 * @param ctx the parse tree
	 */
	void enterEntityAttrs(UOSQLParser.EntityAttrsContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#entityAttrs}.
	 * @param ctx the parse tree
	 */
	void exitEntityAttrs(UOSQLParser.EntityAttrsContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#attrPair}.
	 * @param ctx the parse tree
	 */
	void enterAttrPair(UOSQLParser.AttrPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#attrPair}.
	 * @param ctx the parse tree
	 */
	void exitAttrPair(UOSQLParser.AttrPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void enterConditionExpr(UOSQLParser.ConditionExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#conditionExpr}.
	 * @param ctx the parse tree
	 */
	void exitConditionExpr(UOSQLParser.ConditionExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#conditionTerm}.
	 * @param ctx the parse tree
	 */
	void enterConditionTerm(UOSQLParser.ConditionTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#conditionTerm}.
	 * @param ctx the parse tree
	 */
	void exitConditionTerm(UOSQLParser.ConditionTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#conditionFactor}.
	 * @param ctx the parse tree
	 */
	void enterConditionFactor(UOSQLParser.ConditionFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#conditionFactor}.
	 * @param ctx the parse tree
	 */
	void exitConditionFactor(UOSQLParser.ConditionFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#compOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(UOSQLParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#compOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(UOSQLParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link UOSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(UOSQLParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link UOSQLParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(UOSQLParser.ValueContext ctx);
}