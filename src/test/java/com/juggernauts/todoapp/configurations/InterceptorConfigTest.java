package com.juggernauts.todoapp.configurations;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

@ContextConfiguration(classes = {InterceptorConfig.class})
@ActiveProfiles({"josh"})
@ExtendWith(SpringExtension.class)
class InterceptorConfigTest {
    @Autowired
    private InterceptorConfig interceptorConfig;

    /**
     * Method under test: {@link InterceptorConfig#addInterceptors(InterceptorRegistry)}
     */
    @Test
    void testAddInterceptors() {
        // TODO: Complete this test.
        //   Reason: R004 No meaningful assertions found.
        //   Diffblue Cover was unable to create an assertion.
        //   Make sure that fields modified by addInterceptors(InterceptorRegistry)
        //   have package-private, protected, or public getters.
        //   See https://diff.blue/R004 to resolve this issue.

        interceptorConfig.addInterceptors(new InterceptorRegistry());
    }

    /**
     * Method under test: {@link InterceptorConfig#addInterceptors(InterceptorRegistry)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testAddInterceptors2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.juggernauts.todoapp.configurations.InterceptorConfig.addInterceptorVarargs(InterceptorConfig.java:33)
        //       at com.juggernauts.todoapp.configurations.InterceptorConfig.addInterceptors(InterceptorConfig.java:25)
        //   In order to prevent addInterceptors(InterceptorRegistry)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   addInterceptors(InterceptorRegistry).
        //   See https://diff.blue/R013 to resolve this issue.

        interceptorConfig.addInterceptors(null);
    }
}

