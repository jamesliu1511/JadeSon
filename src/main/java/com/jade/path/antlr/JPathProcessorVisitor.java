// Generated from JPathProcessor.g4 by ANTLR 4.7.2

	package com.jade.path.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPathProcessorParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPathProcessorVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#locationPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationPath(JPathProcessorParser.LocationPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#specialPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialPath(JPathProcessorParser.SpecialPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#searchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchPath(JPathProcessorParser.SearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(JPathProcessorParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(JPathProcessorParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(JPathProcessorParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(JPathProcessorParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#functionFetch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFetch(JPathProcessorParser.FunctionFetchContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#fetchName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchName(JPathProcessorParser.FetchNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#existCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistCheck(JPathProcessorParser.ExistCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#numSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumSelect(JPathProcessorParser.NumSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#rangeSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeSelect(JPathProcessorParser.RangeSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(JPathProcessorParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#chooseSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseSelect(JPathProcessorParser.ChooseSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#conditionSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSelect(JPathProcessorParser.ConditionSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(JPathProcessorParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#funValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValue(JPathProcessorParser.FunValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#funValueName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValueName(JPathProcessorParser.FunValueNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#subSearchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubSearchPath(JPathProcessorParser.SubSearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#functionCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCheck(JPathProcessorParser.FunctionCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(JPathProcessorParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#functionNodeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionNodeName(JPathProcessorParser.FunctionNodeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(JPathProcessorParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(JPathProcessorParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathProcessorParser#numValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumValue(JPathProcessorParser.NumValueContext ctx);
}