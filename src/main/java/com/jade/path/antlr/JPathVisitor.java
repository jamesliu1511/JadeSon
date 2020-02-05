// Generated from JPath.g4 by ANTLR 4.7.2

	package com.jade.path.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPathParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPathVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPathParser#specialPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialPath(JPathParser.SpecialPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#searchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchPath(JPathParser.SearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(JPathParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(JPathParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(JPathParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(JPathParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#functionFetch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFetch(JPathParser.FunctionFetchContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#fetchName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchName(JPathParser.FetchNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#existCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistCheck(JPathParser.ExistCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#numSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumSelect(JPathParser.NumSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#rangeSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeSelect(JPathParser.RangeSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(JPathParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#chooseSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseSelect(JPathParser.ChooseSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#conditionSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSelect(JPathParser.ConditionSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(JPathParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#funValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValue(JPathParser.FunValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#funValueName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValueName(JPathParser.FunValueNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#subSearchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubSearchPath(JPathParser.SubSearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#functionCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCheck(JPathParser.FunctionCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(JPathParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#functionNodeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionNodeName(JPathParser.FunctionNodeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(JPathParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(JPathParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathParser#numValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumValue(JPathParser.NumValueContext ctx);
}