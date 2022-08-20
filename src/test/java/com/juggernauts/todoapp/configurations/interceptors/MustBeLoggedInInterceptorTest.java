package com.juggernauts.todoapp.configurations.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

class MustBeLoggedInInterceptorTest {
    /**
     * Method under test: {@link MustBeLoggedInInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPreHandle() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.apache.catalina.connector.Response.isCommitted(Response.java:619)
        //       at org.apache.catalina.connector.Response.setStatus(Response.java:1507)
        //       at org.apache.catalina.connector.Response.setStatus(Response.java:1489)
        //       at com.juggernauts.todoapp.configurations.interceptors.MustBeLoggedInInterceptor.preHandle(MustBeLoggedInInterceptor.java:31)
        //   In order to prevent preHandle(HttpServletRequest, HttpServletResponse, Object)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   preHandle(HttpServletRequest, HttpServletResponse, Object).
        //   See https://diff.blue/R013 to resolve this issue.

        MustBeLoggedInInterceptor mustBeLoggedInInterceptor = new MustBeLoggedInInterceptor();
        MockHttpServletRequest request = new MockHttpServletRequest();
        mustBeLoggedInInterceptor.preHandle(request, new Response(), "Handler");
    }

    /**
     * Method under test: {@link MustBeLoggedInInterceptor#preHandle(HttpServletRequest, HttpServletResponse, Object)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testPreHandle2() throws Exception {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at com.juggernauts.todoapp.configurations.interceptors.MustBeLoggedInInterceptor.lambda$preHandle$0(MustBeLoggedInInterceptor.java:21)
        //       at java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
        //       at java.util.Spliterators$ArraySpliterator.tryAdvance(Spliterators.java:958)
        //       at java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:126)
        //       at java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:499)
        //       at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:486)
        //       at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
        //       at java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
        //       at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.util.stream.ReferencePipeline.anyMatch(ReferencePipeline.java:449)
        //       at com.juggernauts.todoapp.configurations.interceptors.MustBeLoggedInInterceptor.preHandle(MustBeLoggedInInterceptor.java:21)
        //   In order to prevent preHandle(HttpServletRequest, HttpServletResponse, Object)
        //   from throwing NullPointerException, add constructors or factory
        //   methods that make it easier to construct fully initialized objects used in
        //   preHandle(HttpServletRequest, HttpServletResponse, Object).
        //   See https://diff.blue/R013 to resolve this issue.

        MustBeLoggedInInterceptor mustBeLoggedInInterceptor = new MustBeLoggedInInterceptor();
        mustBeLoggedInInterceptor.preHandle(null, new Response(), "Handler");
    }
}

