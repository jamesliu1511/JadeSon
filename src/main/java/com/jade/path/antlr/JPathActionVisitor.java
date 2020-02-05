// Generated from JPathAction.g4 by ANTLR 4.7.2

	package com.jade.path.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JPathActionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JPathActionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#locationPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationPath(JPathActionParser.LocationPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionProcessor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionProcessor(JPathActionParser.FunctionProcessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#processorParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessorParam(JPathActionParser.ProcessorParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#specialName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialName(JPathActionParser.SpecialNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#processor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProcessor(JPathActionParser.ProcessorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#specialPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecialPath(JPathActionParser.SpecialPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#searchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSearchPath(JPathActionParser.SearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(JPathActionParser.StepContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#all}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAll(JPathActionParser.AllContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(JPathActionParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#arrayExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(JPathActionParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionFetch}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFetch(JPathActionParser.FunctionFetchContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#fetchName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFetchName(JPathActionParser.FetchNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#existCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExistCheck(JPathActionParser.ExistCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#numSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumSelect(JPathActionParser.NumSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#rangeSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeSelect(JPathActionParser.RangeSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#rangeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRangeExpr(JPathActionParser.RangeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#chooseSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChooseSelect(JPathActionParser.ChooseSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#conditionSelect}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionSelect(JPathActionParser.ConditionSelectContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#conditionExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionExpr(JPathActionParser.ConditionExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#funValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValue(JPathActionParser.FunValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#funValueName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunValueName(JPathActionParser.FunValueNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#subSearchPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubSearchPath(JPathActionParser.SubSearchPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionCheck}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCheck(JPathActionParser.FunctionCheckContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(JPathActionParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionNodeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionNodeName(JPathActionParser.FunctionNodeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#functionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParam(JPathActionParser.FunctionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#variableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableReference(JPathActionParser.VariableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JPathActionParser#numValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumValue(JPathActionParser.NumValueContext ctx);
}