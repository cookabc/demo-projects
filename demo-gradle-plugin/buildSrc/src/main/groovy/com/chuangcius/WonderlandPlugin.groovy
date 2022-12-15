package com.chuangcius

import org.apache.tools.ant.filters.ReplaceTokens
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.Copy
import org.gradle.api.tasks.TaskProvider
import org.gradle.api.tasks.bundling.Zip

/**
 * WonderlandPlugin
 *
 * @author xugang.song created at 2022.05.26
 */
class WonderlandPlugin implements Plugin<Project> {


    @Override
    void apply(Project project) {
        def extension = project.extensions.create('wonderland', WonderlandPluginExtension)

        TaskProvider copyQuoteTask = project.tasks.register('copyQuote', Copy) {
            from 'quote.txt'
            into "$project.buildDir/quote"
            filter(ReplaceTokens, tokens: [CHARACTER: extension.characterName.get()])
        }

        project.tasks.register('zipQuote', Zip) {
            from "$project.buildDir/quote"
            destinationDirectory = project.buildDir
            archiveFileName = 'quote.zip'
            dependsOn copyQuoteTask
        }
    }
}