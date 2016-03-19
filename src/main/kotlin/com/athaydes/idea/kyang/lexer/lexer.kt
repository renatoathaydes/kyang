package com.athaydes.idea.kyang.lexer

import com.athaydes.idea.kyang.YangFileType
import com.athaydes.idea.kyang.YangLang
import com.athaydes.idea.kyang.YangParser
import com.athaydes.idea.kyang.YangTypes
import com.athaydes.idea.kyang.lexer.gen.YangLexer
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lexer.FlexAdapter
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class YangLexerAdapter() : FlexAdapter(YangLexer(null))

class YangFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, YangLang)
{
    override fun getFileType() = YangFileType

    override fun toString() = "Yang file"

}

class YangParserDefinition() : ParserDefinition
{
    object yangFileElementType : IFileElementType(YangLang)

    private val whiteSpaces = TokenSet.create(TokenType.WHITE_SPACE)
    private val comments = TokenSet.create(YangTypes.COMMENT)

    override fun createFile(fileViewProvider: FileViewProvider) = YangFile(fileViewProvider)

    override fun spaceExistanceTypeBetweenTokens(
            left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements?
    {
        throw UnsupportedOperationException()
    }

    override fun getStringLiteralElements() = TokenSet.EMPTY

    override fun getFileNodeType() = yangFileElementType

    override fun getWhitespaceTokens() = whiteSpaces

    override fun createLexer(project: Project?) = YangLexerAdapter()

    override fun createElement(node: ASTNode?) = YangTypes.Factory.createElement(node)

    override fun getCommentTokens() = comments

    override fun createParser(project: Project?) = YangParser()

}