package com.chuangcius

import org.gradle.api.provider.Property

/**
 * WonderlandPluginExtension
 *
 * @author chuangcius created at 2022.05.26
 */
abstract class WonderlandPluginExtension {
    abstract Property<String> getCharacterName()
}