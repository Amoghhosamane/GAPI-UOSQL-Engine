// Generated from java_engine/src/gapi/uosql/UOSQL.g4 by ANTLR 4.13.2
package gapi.uosql;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link UOSQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface UOSQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#uosqlProgram}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUosqlProgram(UOSQLParser.UosqlProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(UOSQLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#connectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConnectStmt(UOSQLParser.ConnectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#chainLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChainLink(UOSQLParser.ChainLinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#edgeOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeOp(UOSQLParser.EdgeOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#edgeAttrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEdgeAttrs(UOSQLParser.EdgeAttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#traverseStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraverseStmt(UOSQLParser.TraverseStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#traverseLink}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTraverseLink(UOSQLParser.TraverseLinkContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#findStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFindStmt(UOSQLParser.FindStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#entityStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityStmt(UOSQLParser.EntityStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#entityDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityDecl(UOSQLParser.EntityDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#entityRef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityRef(UOSQLParser.EntityRefContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#entitySelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntitySelector(UOSQLParser.EntitySelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#entityAttrs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEntityAttrs(UOSQLParser.EntityAttrsContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#attrPair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrPair(UOSQLParser.AttrPairContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(UOSQLParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#conditionTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionTerm(UOSQLParser.ConditionTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#conditionFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionFactor(UOSQLParser.ConditionFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#compOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(UOSQLParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link UOSQLParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(UOSQLParser.ValueContext ctx);
}