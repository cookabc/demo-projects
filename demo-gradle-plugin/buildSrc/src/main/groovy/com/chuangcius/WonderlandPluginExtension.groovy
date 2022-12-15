package com.chuangcius

import org.gradle.api.provider.Property

/**
 * WonderlandPluginExtension
 *
 * @author xugang.song created at 2022.05.26
 */
abstract class WonderlandPluginExtension {
    abstract Property<String> getCharacterName()
}