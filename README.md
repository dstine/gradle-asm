Gradle ASM
==========

Demonstrates ASM issue with Gradle 1.2 and Cobertura. See [Gradle Forums](http://forums.gradle.org/gradle/topics/cobertura_instrumentation_fails_in_gradle_1_2) for discussion.

<pre>
$ gradle clean test
:clean
:compileJava UP-TO-DATE
:compileGroovy
:processResources
:classes
:instrumentCobertura
:compileTestJava UP-TO-DATE
:compileTestGroovy
:processTestResources UP-TO-DATE
:testClasses
:test

scratch.gradle.asm.GreetingPluginTest > applyPlugin FAILED
    org.gradle.api.GradleException at GreetingPluginTest.groovy:11
        Caused by: java.lang.IncompatibleClassChangeError at GreetingPluginTest.groovy:11

1 test completed, 1 failed
:test FAILED
</pre>

<pre>
$ gradle clean test --info
...
Successfully started process 'Gradle Worker 2'
Gradle Worker 2 executing tests.
Gradle Worker 2 finished executing tests.

scratch.gradle.asm.GreetingPluginTest > applyPlugin FAILED
    org.gradle.api.GradleException: Could not generate a proxy class for class org.gradle.api.internal.project.DefaultProject.
        at org.gradle.api.internal.AbstractClassGenerator.generate(AbstractClassGenerator.java:187)
        at org.gradle.api.internal.ClassGeneratorBackedInstantiator.newInstance(ClassGeneratorBackedInstantiator.java:36)
        at org.gradle.api.internal.project.ProjectFactory.createProject(ProjectFactory.java:47)
        at org.gradle.api.internal.project.ProjectFactory.createProject(ProjectFactory.java:31)
        at org.gradle.testfixtures.internal.ProjectBuilderImpl.createProject(ProjectBuilderImpl.java:72)
        at org.gradle.testfixtures.ProjectBuilder.build(ProjectBuilder.java:99)
        at org.gradle.testfixtures.ProjectBuilder$build.call(Unknown Source)
Process 'Gradle Worker 2' finished with exit value 0 (state: SUCCEEDED)
        at org.codehaus.groovy.runtime.callsite.CallSiteArray.defaultCall(CallSiteArray.java:42)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:108)
        at org.codehaus.groovy.runtime.callsite.AbstractCallSite.call(AbstractCallSite.java:112)
        at scratch.gradle.asm.GreetingPluginTest.applyPlugin(GreetingPluginTest.groovy:11)

        Caused by:
        java.lang.IncompatibleClassChangeError: Found interface org.objectweb.asm.MethodVisitor, but class was expected
            at org.gradle.api.internal.AsmBackedClassGenerator$ClassBuilderImpl.addGetter(AsmBackedClassGenerator.java:470)
            at org.gradle.api.internal.AsmBackedClassGenerator$ClassBuilderImpl.addGetter(AsmBackedClassGenerator.java:464)
            at org.gradle.api.internal.AsmBackedClassGenerator$ClassBuilderImpl.mixInGroovyObject(AsmBackedClassGenerator.java:430)
            at org.gradle.api.internal.AbstractClassGenerator.generate(AbstractClassGenerator.java:75)
            ... 10 more

1 test completed, 1 failed
:test FAILED
</pre>
