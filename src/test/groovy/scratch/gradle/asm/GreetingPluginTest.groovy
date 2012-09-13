package scratch.gradle.asm

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.Test

class GreetingPluginTest {

    @Test
    public void applyPlugin() {
        Project project = ProjectBuilder.builder().withName("testProject").build()
        project.apply plugin: 'scratch-greeting'
    }
}
