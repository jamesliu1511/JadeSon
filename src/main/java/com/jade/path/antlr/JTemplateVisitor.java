// Generated from JTemplate.g4 by ANTLR 4.7.2

	package com.jade.path.antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JTemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JTemplateVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JTemplateParser#locationPath}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocationPath(JTemplateParser.LocationPathContext ctx);
	/**
	 * Visit a parse tree produced by {@link JTemplateParser#step}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStep(JTemplateParser.StepContext ctx);
}