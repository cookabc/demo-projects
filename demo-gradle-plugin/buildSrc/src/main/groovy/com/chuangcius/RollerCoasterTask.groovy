package com.chuangcius

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * RollerCoasterTask
 *
 * @author xugang.song created at 2022.05.26
 */
abstract class RollerCoasterTask extends DefaultTask {
    @Input
    abstract Property<String> getFavoriteCoaster()

    RollerCoasterTask() {
        favoriteCoaster.convention('Space Mountain')
    }

    @TaskAction
    def tellMeMyFavorite() {
        println "You favorite coaster is ${favoriteCoaster.get()}!"
    }
}