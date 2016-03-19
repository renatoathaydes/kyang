package com.athaydes.idea.kyang

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import com.intellij.psi.tree.IElementType
import javax.swing.Icon

class YangFileTypeFactory : FileTypeFactory()
{
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer)
    {
        fileTypeConsumer.consume(YangFileType)
    }
}

object YangLang : Language("Yang")

object YangIcons
{
    val icon: Icon = IconLoader.getIcon("/com/athaydes/idea/kyang/yang.png")
}

object YangFileType : LanguageFileType(YangLang)
{
    override fun getName() = "Yang"
    override fun getDefaultExtension() = "yang"
    override fun getDescription() = "Yang Data Modelling Language File"
    override fun getIcon() = YangIcons.icon
}

class YangTokenType(val debugName: String) : IElementType(debugName, YangLang)

class YangElementType(val debugName: String) : IElementType(debugName, YangLang)
