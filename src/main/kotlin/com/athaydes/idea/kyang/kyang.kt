package com.athaydes.idea.kyang

import com.intellij.lang.Language
import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

class KyangFileTypeFactory : FileTypeFactory()
{
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer)
    {
        fileTypeConsumer.consume(kyangFileType)
    }
}

object kyangLang : Language("yang")

object kyangIcons
{
    val icon: Icon = IconLoader.getIcon("/com/athaydes/idea/kyang/yang.png")
}

object kyangFileType : LanguageFileType(kyangLang)
{
    override fun getName() = "Yang file"
    override fun getDefaultExtension() = "yang"
    override fun getDescription() = "Yang Data Modelling Language File"
    override fun getIcon() = kyangIcons.icon
}
