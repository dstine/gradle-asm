package scratch.gradle.asm

import org.gradle.api.Plugin
import org.gradle.api.Project

class GreetingPlugin implements Plugin<Project> {

    void apply(Project project) {
        project.task('hello') << {
            println "hello!"
        }
    }
}
