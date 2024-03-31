INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708863712535896066, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:17:12.878579', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708864198127247361, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:19:08.653238', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708864212408852481, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:19:12.057413', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708864871157755905, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:21:49.115550', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708867027692687361, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:30:23.273573', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708867818314801153, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:33:31.772433', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708867945121193985, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 159, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:34:02.005952', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708867986460254210, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 1,
        null, e'org.mybatis.spring.MyBatisSystemException
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:96)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:441)
	at jdk.proxy2/jdk.proxy2.$Proxy125.selectList(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.selectList(SqlSessionTemplate.java:224)
	at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.executeForIPage(MybatisMapperMethod.java:121)
	at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.execute(MybatisMapperMethod.java:85)
	at com.baomidou.mybatisplus.core.override.MybatisMapperProxy$PlainMethodInvoker.invoke(MybatisMapperProxy.java:148)
	at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:89)
	at jdk.proxy2/jdk.proxy2.$Proxy157.selectPage(Unknown Source)
	at com.baomidou.mybatisplus.extension.service.IService.page(IService.java:389)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:704)
	at com.libre.framework.system.service.impl.SysDictServiceImpl$$SpringCGLIB$$0.page(<generated>)
	at com.libre.framework.system.controller.SysDictController.query(SysDictController.java:43)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:343)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:756)
	at org.springframework.validation.beanvalidation.MethodValidationInterceptor.invoke(MethodValidationInterceptor.java:141)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:756)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.log.aspect.SysLogAspect.logAround(SysLogAspect.java:60)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:756)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:756)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:708)
	at com.libre.framework.system.controller.SysDictController$$SpringCGLIB$$0.query(<generated>)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:205)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:150)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:884)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:797)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1081)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:974)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1011)
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:527)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:77)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1538)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:833)
Caused by: org.apache.ibatis.exceptions.PersistenceException: 
### Error querying database.  Cause: java.lang.reflect.InaccessibleObjectException: Unable to make field private final long java.lang.Long.value accessible: module java.base does not "opens java.lang" to unnamed module @6c779568
### The error may exist in com/libre/framework/system/mapper/SysDictMapper.java (best guess)
### The error may involve com.libre.framework.system.mapper.SysDictMapper.selectPage_mpCount
### The error occurred while handling results
### SQL: SELECT COUNT(*) AS total FROM sys_dict
### Cause: java.lang.reflect.InaccessibleObjectException: Unable to make field private final long java.lang.Long.value accessible: module java.base does not "opens java.lang" to unnamed module @6c779568
	at org.apache.ibatis.exceptions.ExceptionFactory.wrapException(ExceptionFactory.java:30)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:153)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:145)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:140)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:427)
	... 189 more
Caused by: java.lang.reflect.InaccessibleObjectException: Unable to make field private final long java.lang.Long.value accessible: module java.base does not "opens java.lang" to unnamed module @6c779568
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:354)
	at java.base/java.lang.reflect.AccessibleObject.checkCanSetAccessible(AccessibleObject.java:297)
	at java.base/java.lang.reflect.Field.checkCanSetAccessible(Field.java:178)
	at java.base/java.lang.reflect.Field.setAccessible(Field.java:172)
	at org.apache.ibatis.reflection.invoker.GetFieldInvoker.invoke(GetFieldInvoker.java:38)
	at org.apache.ibatis.reflection.wrapper.BeanWrapper.getBeanProperty(BeanWrapper.java:164)
	at org.apache.ibatis.reflection.wrapper.BeanWrapper.get(BeanWrapper.java:49)
	at org.apache.ibatis.reflection.MetaObject.getValue(MetaObject.java:122)
	at com.libre.mybatis.dict.DictBindProcessor.dictBindValue(DictBindProcessor.java:47)
	at com.libre.mybatis.dict.DictBindInterceptor.lambda$intercept$0(DictBindInterceptor.java:25)
	at com.libre.mybatis.dict.DictBindContext.lambda$isBind$0(DictBindContext.java:74)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1625)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
	at java.base/java.util.stream.ForEachOps$ForEachTask.compute(ForEachOps.java:290)
	at java.base/java.util.concurrent.CountedCompleter.exec(CountedCompleter.java:754)
	at java.base/java.util.concurrent.ForkJoinTask.doExec$$$capture(ForkJoinTask.java:373)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java)
	at java.base/java.util.concurrent.ForkJoinTask.invoke(ForkJoinTask.java:686)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateParallel(ForEachOps.java:159)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateParallel(ForEachOps.java:173)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:233)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:765)
	at com.libre.mybatis.dict.DictBindContext.isBind(DictBindContext.java:73)
	at com.libre.mybatis.dict.DictBindProcessor.process(DictBindProcessor.java:75)
	at com.libre.mybatis.dict.DictBindInterceptor.intercept(DictBindInterceptor.java:24)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:62)
	at jdk.proxy2/jdk.proxy2.$Proxy206.handleResultSets(Unknown Source)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.query(PreparedStatementHandler.java:65)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.query(RoutingStatementHandler.java:79)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:64)
	at jdk.proxy2/jdk.proxy2.$Proxy207.query(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doQuery(SimpleExecutor.java:63)
	at org.apache.ibatis.executor.BaseExecutor.queryFromDatabase(BaseExecutor.java:325)
	at org.apache.ibatis.executor.BaseExecutor.query(BaseExecutor.java:156)
	at com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor.willDoQuery(PaginationInnerInterceptor.java:135)
	at com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor.intercept(MybatisPlusInterceptor.java:75)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:62)
	at jdk.proxy2/jdk.proxy2.$Proxy205.query(Unknown Source)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.selectList(DefaultSqlSession.java:151)
	... 196 more
', '127.0.0.1', 8, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:34:11.862285', null, 'GET',
        'org.mybatis.spring.MyBatisExceptionTranslator', 'MyBatisExceptionTranslator.java',
        'translateExceptionIfPossible', '96', 'MyBatisSystemException', null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708867994777559042, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 4, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-02 23:34:13.844500', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708868001647828994, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 5, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:34:15.482409', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708868008719425538, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 2,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-02 23:34:17.168675', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708878534807760898, null, 'admin', 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 00:16:06.783764', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708878542269427713, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 00:16:08.562859', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708878561500311553, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 16, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 00:16:13.148472', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1708880020048556033, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 00:22:00.892707', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052291635589121, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:46:33.640877', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052298392612866, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:46:35.250711', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052530400538626, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 5, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:47:30.566587', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052595198341122, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:47:46.015151', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052608477507586, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-03 11:47:49.180928', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052620418691073, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 3, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:47:52.027760', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052633542668289, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-03 11:47:55.157404', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052721056821250, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:48:16.021699', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052730766635009, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 10,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:48:18.337095', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052881585418241, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:48:54.295014', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052900753387522, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 7, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:48:58.864626', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709052934785970177, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:49:06.979202', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709053293382184961, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:50:32.475308', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709053323463733249, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 8, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:50:39.647652', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709053329344147458, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 5, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-03 11:50:41.049735', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709053340052205570, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:50:43.602459', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709053346146529282, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-03 11:50:45.055033', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709467671248097281, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 15:17:07.856767', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709467671248097282, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 15:17:07.856853', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709467989478330370, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 15:18:23.728135', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709468005165027330, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 17, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 15:18:27.469667', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709468025314463745, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 12, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 15:18:32.273602', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709468029806563329, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-04 15:18:33.344246', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483541647183873, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 4, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:20:11.655856', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483547552763905, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:20:13.064262', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483732852920322, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 2,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:20:57.242007', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483738997575681, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:20:58.707716', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483751802785793, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:21:01.760537', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709483846896046081, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-04 16:21:24.432789', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1709668212515315714, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-05 04:34:00.621444', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715420436885446658, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-21 01:31:17.782367', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715420638404976642, null, 'admin', 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-21 01:32:05.828528', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715420646562897921, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-21 01:32:07.772961', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715985106159566850, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 14:55:05.427820', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715985151319638017, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 11, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 14:55:16.195668', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715991293009625089, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":0,"title":"文章管理","name":null,"seq":null,"path":"/article","permission":null,"component":"/blog/article","icon":"backup","isFrame":null,"type":1,"cache":false,"hidden":false,"status":null,"remark":null}',
        0, null, null, '127.0.0.1', 25, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:19:40.488690', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715991478116843522, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1715991292925739010,"parentId":0,"title":"文章管理","name":null,"seq":null,"path":"/article","permission":null,"component":"/blog/article/Article","icon":"backup","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 8, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:20:24.621470', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715991505866358786, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1715991292925739010,"parentId":0,"title":"文章管理","name":null,"seq":null,"path":"/article","permission":null,"component":"blog/article/Article","icon":"backup","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:20:31.237630', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715991841221935106, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1715991292925739010,"parentId":0,"title":"文章管理","name":null,"seq":null,"path":"/article","permission":null,"component":"blog/article/ArticleEdit","icon":"backup","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 3, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:21:51.192701', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715999085854470146, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 16, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:50:38.446681', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1715999103982252033, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-22 15:50:42.769042', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130639032668161, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:00:40.326912', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130710805598210, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 27, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:00:57.441247', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130739972788225, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:01:04.393728', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130745853202434, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 1, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-28 13:01:05.795520', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130759895732226, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:01:09.143297', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718130765851643905, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 2,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:01:10.563776', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718132242603167745, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 13:07:02.647837', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718167076952199169, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":0,"title":"博客管理","name":null,"seq":null,"path":"/blog","permission":null,"component":null,"icon":"app","isFrame":null,"type":0,"cache":false,"hidden":false,"status":null,"remark":null}',
        0, null, null, '127.0.0.1', 7, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:25:27.803869', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718169901472010241, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":1718167076935421954,"title":"分类管理","name":null,"seq":null,"path":"/category","permission":null,"component":"blog/category/Category","icon":"database","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:36:41.221760', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718169971227480065, null, 'admin', 'Api', '菜单删除', 'DELETE /api/sys/menu', '[1715991292925739010]', 0, null,
        null, '127.0.0.1', 26, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:36:57.852266', null, 'DELETE',
        'com.libre.framework.system.controller.SysMenuController', null, 'deleteByIds', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718170260378603521, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":1718167076935421954,"title":"文章管理","name":null,"seq":null,"path":"/blog/article","permission":null,"component":"blog/article/ArticleEdit","icon":"app","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:38:06.792199', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718170323830034434, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1718169901463621634,"parentId":1718167076935421954,"title":"分类管理","name":null,"seq":null,"path":"/blog/category","permission":null,"component":"blog/category/Category","icon":"database","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 9, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:38:21.919389', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718171595060662273, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 6, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:43:25.005149', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718171612819345409, null, 'admin', 'Api', '查询字典', 'GET /api/sys/dict?size=10&page=1&sort=id,desc', null, 0,
        null, null, '127.0.0.1', 8, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:43:29.238570', null, 'GET',
        'com.libre.framework.system.controller.SysDictController', null, 'query', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718174670500450305, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 12, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:55:38.246957', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718174705409642498, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:55:46.570031', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718174713265573890, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 3, 'Mac OS X',
        'Chrome 11', '内网IP', '2023-10-28 15:55:48.442539', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718175283506368513, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 24, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:58:04.399143', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718175321242521601, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 1, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 15:58:13.396704', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718179063740289025, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 9, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 16:13:05.677645', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1718215962567647233, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":1718167076935421954,"title":"标签管理","name":null,"seq":null,"path":"/blog/tag","permission":null,"component":"blog/tag/Tag","icon":"backup","isFrame":null,"type":1,"cache":false,"hidden":false,"status":null,"remark":null}',
        0, null, null, '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-10-28 18:39:43.042820', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1720780777823719426, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-04 20:31:22.651481', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1721886075472891905, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-07 21:43:26.147119', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1721890829280329730, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"/Users/libre/video/1699365733986-200524110515-2-1200.jpg","articleName":null,"summary":null,"content":null,"status":1,"top":0,"featured":0}',
        0, null, null, '127.0.0.1', 8, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-07 22:02:19.542829', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1721891359863980033, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"/Users/libre/video/1699365858405-200524110515-7-lp.jpg","articleName":null,"summary":null,"content":null,"status":1,"top":1,"featured":1}',
        0, null, null, '127.0.0.1', 3, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-07 22:04:26.044648', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1721891927009378306, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"/Users/libre/video/1699365998919-200524110515-6-lp.jpg","articleName":null,"summary":null,"content":null,"status":1,"top":0,"featured":0}',
        0, null, null, '127.0.0.1', 11, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-07 22:06:41.261294', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1721909318783188993, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"/Users/libre/video/1699370144285-200524110515-14-lp.jpg","articleName":null,"summary":"","content":" # test\n```java\npublic void test() {\n   System.out.println(\"你好，世界！\")\n}\n```","status":1,"top":0,"featured":0}',
        0, null, null, '127.0.0.1', 3, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-07 23:15:47.783387', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1723285021365755905, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-11-11 18:22:20.839076', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732762567677349889, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:02:43.964600', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732762599751192577, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 9, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:02:51.611331', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732762986742845442, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 2,
        'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:04:23.876312', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732763003033522178, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:04:27.761229', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732763281162014721, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":1718167076935421954,"title":"文章列表","name":null,"seq":null,"path":"/article","permission":null,"component":"/blog/article/Article","icon":"app","isFrame":null,"type":1,"cache":false,"hidden":false,"status":null,"remark":null}',
        0, null, null, '127.0.0.1', 20, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:05:34.071913', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732763311105150977, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1732763281111683073,"parentId":1718167076935421954,"title":"文章列表","name":null,"seq":null,"path":"/article","permission":null,"component":"blog/article/Article","icon":"app","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 6, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:05:41.211665', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1732772561902669825, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 6, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-07 22:42:26.772678', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733099369340710913, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 20:21:03.738159', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733099382204641281, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 20:21:06.805345', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733145987607711745, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"1702049174785-202201cthxrxhggtg.jpg","articleName":"sfsf","summary":"sfsfs","content":"sfsfsf","status":1,"top":0,"featured":0,"categoryId":1718181725051314178,"tagIds":[1718217710032183298,1718217000993447937]}',
        0, null, null, '127.0.0.1', 19, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 23:26:18.399251', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733150523206422529, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1732763281111683073,"parentId":1718167076935421954,"title":"文章列表","name":null,"seq":null,"path":"/blog/article","permission":null,"component":"blog/article/Article","icon":"app","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 18, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 23:44:19.770332', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733150569318600706, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1718170260370214914,"parentId":1718167076935421954,"title":"文章管理","name":null,"seq":null,"path":"/blog/articleEdit","permission":null,"component":"blog/article/ArticleEdit","icon":"app","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 23:44:30.764079', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733153194491568129, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"test","status":1,"top":0,"featured":0,"categoryId":1718181774380523521,"tagIds":[1718217000993447937,1718217710032183298,1718217734522724353]}',
        0, null, null, '127.0.0.1', 11, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-08 23:54:56.654830', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733159391609233410, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733153194374127618,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"test","status":1,"top":1,"featured":1,"categoryId":1718181774380523521,"tagIds":[1718217734522724353,1718217710032183298,1718217000993447937]}',
        1, null, e'org.springframework.dao.DuplicateKeyException:
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
### The error may exist in com/libre/framework/blog/mapper/ArticleMapper.java (best guess)
### The error may involve com.libre.framework.blog.mapper.ArticleMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO blog_article  ( id, cover, article_name, summary, content, status, top, featured, category_id, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name )  VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
; ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
	at org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator.doTranslate(SQLErrorCodeSQLExceptionTranslator.java:254)
	at org.springframework.jdbc.support.AbstractFallbackSQLExceptionTranslator.translate(AbstractFallbackSQLExceptionTranslator.java:107)
	at org.mybatis.spring.MyBatisExceptionTranslator.translateExceptionIfPossible(MyBatisExceptionTranslator.java:92)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:439)
	at jdk.proxy2/jdk.proxy2.$Proxy141.insert(Unknown Source)
	at org.mybatis.spring.SqlSessionTemplate.insert(SqlSessionTemplate.java:272)
	at com.baomidou.mybatisplus.core.override.MybatisMapperMethod.execute(MybatisMapperMethod.java:59)
	at com.baomidou.mybatisplus.core.override.MybatisMapperProxy$PlainMethodInvoker.invoke(MybatisMapperProxy.java:148)
	at com.baomidou.mybatisplus.core.override.MybatisMapperProxy.invoke(MybatisMapperProxy.java:89)
	at jdk.proxy2/jdk.proxy2.$Proxy186.insert(Unknown Source)
	at com.baomidou.mybatisplus.extension.service.IService.save(IService.java:60)
	at com.libre.framework.blog.service.impl.ArticleServiceImpl.add(ArticleServiceImpl.java:58)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.transaction.interceptor.TransactionInterceptor$1.proceedWithInvocation(TransactionInterceptor.java:123)
	at org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:385)
	at org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:119)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.blog.service.impl.ArticleServiceImpl$$SpringCGLIB$$0.add(<generated>)
	at com.libre.framework.blog.controller.ArticleAdminController.saveArticle(ArticleAdminController.java:35)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.blog.controller.ArticleAdminController$$SpringCGLIB$$0.saveArticle(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:77)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1538)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
Caused by: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
	at org.postgresql.core.v3.QueryExecutorImpl.receiveErrorResponse(QueryExecutorImpl.java:2713)
	at org.postgresql.core.v3.QueryExecutorImpl.processResults(QueryExecutorImpl.java:2401)
	at org.postgresql.core.v3.QueryExecutorImpl.execute(QueryExecutorImpl.java:368)
	at org.postgresql.jdbc.PgStatement.executeInternal(PgStatement.java:498)
	at org.postgresql.jdbc.PgStatement.execute(PgStatement.java:415)
	at org.postgresql.jdbc.PgPreparedStatement.executeWithFlags(PgPreparedStatement.java:190)
	at org.postgresql.jdbc.PgPreparedStatement.execute(PgPreparedStatement.java:177)
	at com.p6spy.engine.wrapper.PreparedStatementWrapper.execute(PreparedStatementWrapper.java:362)
	at com.alibaba.druid.pool.DruidPooledPreparedStatement.execute(DruidPooledPreparedStatement.java:483)
	at org.apache.ibatis.executor.statement.PreparedStatementHandler.update(PreparedStatementHandler.java:48)
	at org.apache.ibatis.executor.statement.RoutingStatementHandler.update(RoutingStatementHandler.java:75)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:61)
	at jdk.proxy2/jdk.proxy2.$Proxy225.update(Unknown Source)
	at org.apache.ibatis.executor.SimpleExecutor.doUpdate(SimpleExecutor.java:50)
	at org.apache.ibatis.executor.BaseExecutor.update(BaseExecutor.java:117)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.apache.ibatis.plugin.Invocation.proceed(Invocation.java:49)
	at com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor.intercept(MybatisPlusInterceptor.java:106)
	at org.apache.ibatis.plugin.Plugin.invoke(Plugin.java:59)
	at jdk.proxy2/jdk.proxy2.$Proxy224.update(Unknown Source)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.update(DefaultSqlSession.java:197)
	at org.apache.ibatis.session.defaults.DefaultSqlSession.insert(DefaultSqlSession.java:184)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.mybatis.spring.SqlSessionTemplate$SqlSessionInterceptor.invoke(SqlSessionTemplate.java:425)
	... 187 more
', '127.0.0.1', 110, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 00:19:34.162308', null, 'POST',
        'org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator',
        'SQLErrorCodeSQLExceptionTranslator.java', 'doTranslate', '254', 'DuplicateKeyException', e'
### Error updating database.  Cause: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
### The error may exist in com/libre/framework/blog/mapper/ArticleMapper.java (best guess)
### The error may involve com.libre.framework.blog.mapper.ArticleMapper.insert-Inline
### The error occurred while setting parameters
### SQL: INSERT INTO blog_article  ( id, cover, article_name, summary, content, status, top, featured, category_id, gmt_create, gmt_modified, gmt_create_name, gmt_modified_name )  VALUES  ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
### Cause: org.postgresql.util.PSQLException: ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.
; ERROR: duplicate key value violates unique constraint "blog_article_pk"
  详细：Key (id)=(1733153194374127618) already exists.', null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733161757758754817, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733153194374127618,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"test","status":1,"top":1,"featured":1,"categoryId":1718181774380523521,"tagIds":[1718217734522724353,1718217710032183298,1718217000993447937]}',
        0, null, null, '127.0.0.1', 31, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 00:28:58.295209', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733167482140631042, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733153194374127618,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"test![202201cthxrxhggtg.jpg](1)","status":1,"top":1,"featured":1,"categoryId":1718181774380523521,"tagIds":[1718217000993447937,1718217710032183298,1718217734522724353]}',
        0, null, null, '127.0.0.1', 24, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 00:51:43.095304', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733177267980341249, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733153194374127618,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"![202201cthxrxhggtg.jpg](http://127.0.0.1:9876/file/1702056621215-202201cthxrxhggtg.jpg)","status":1,"top":1,"featured":1,"categoryId":1718181774380523521,"tagIds":[1718217000993447937,1718217710032183298,1718217734522724353]}',
        0, null, null, '127.0.0.1', 16, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 01:30:36.220429', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733179867433844738, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733153194374127618,"cover":"1702050892248-202201cthxrxhggtg.jpg","articleName":"test","summary":"sfsfsf","content":"![202201cthxrxhggtg.jpg](http://127.0.0.1:9876/file/1702057235527-202201cthxrxhggtg.jpg)","status":1,"top":1,"featured":1,"categoryId":1718181774380523521,"tagIds":[1718217000993447937,1718217710032183298,1718217734522724353]}',
        0, null, null, '127.0.0.1', 16, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 01:40:55.979023', null, 'POST',
        'com.libre.framework.blog.controller.ArticleAdminController', null, 'saveArticle', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733185521074569218, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 02:03:23.912474', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733186284693749762, null, 'admin', 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 02:06:25.973019', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733186294000910337, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-09 02:06:28.191216', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733817896137502722, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 19:56:13.875731', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733817909026598913, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 19:56:16.947940', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733829904480186370, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":null,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<pre><code class=\"language-java\">java</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 16, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 20:43:56.886606', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733830704338153473, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<p><br></p><pre><code class=\"language-java\">public void test() {\n   System.out.println(''Hello, World'');\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 25, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 20:47:07.587963', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733837042749607938, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<ul><li>1</li><li>2</li><li>3</li></ul><h1>标题1</h1><h2>标题2</h2><pre><code class=\"language-java\">public void test() {\n   System.out.println(''Hello, World'');\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 18, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 21:12:18.783630', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733847753424965633, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<ul><li>1</li><li>2</li><li>3</li></ul><h1>标题1</h1><h2>标题2</h2><p><br></p><pre><code >public void test() {\n   System.out.println(''Hello, World'');\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 21:54:52.407681', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733849150941892609, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<ul><li>1</li><li>2</li><li>3</li></ul><h1>标题1</h1><h2>标题2</h2><p><br></p><pre><code class=\"language-java\">public void test() {\n   System.out.println(''Hello, World'');\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 11, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-10 22:00:25.601880', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733900228672688129, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<ul><li>1</li><li>2</li><li>3</li></ul><h1>标题1</h1><h2>标题2</h2><p><br></p><p><br></p><pre><code class=\"language-java\">public void test() { System.out.println(''Hello, World''); }</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 11, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-11 01:23:23.482207', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733923143057215489, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<pre><code class=\"language-javascript\">export default {\n  name: ''ArticleEdit'',\n  components: {Editor, Toolbar},\n  created() {\n    console.log(\"-==========\")\n    const articleId = this.$route.query.articleId\n    if (articleId) {\n      get(articleId).then(res =&gt; {\n        this.article = res\n        this.article.categoryName = this.article.category.categoryName\n        let tags = []\n        this.article.tagNames = []\n        this.article.tagIds = []\n        if (this.article.tags) {\n          tags = this.article.tags\n          tags.forEach(tag =&gt; {\n            this.article.tagNames.push(tag.tagName)\n            this.article.tagIds.push(tag.id)\n          })\n        }\n        console.log(this.article)\n      })\n    } else {\n      const article = sessionStorage.getItem(''article'')\n      if (article) {\n        this.article = JSON.parse(article)\n      }\n    }\n  },\n  computed: {\n    ...mapGetters([\n      ''baseApi'',\n      ''fileUploadApi''\n    ]),\n    tagClass() {\n      return function (item) {\n        const index = this.article.tagNames.indexOf(item.tagName)\n        return index !== -1 ? ''tag-item-select'' : ''tag-item''\n      }\n    }\n  },\n  data() {\n    return {\n      editor: null,\n      html: ''&lt;p&gt;hello&lt;/p&gt;'',\n      toolbarConfig: {},\n      editorConfig: {placeholder: ''请输入内容...''},\n      mode: ''default'', // or ''simple''\n      addOrEdit: false,\n      autoSave: true,\n      categoryName: '''',\n      tagName: '''',\n      categories: [],\n      tagList: [],\n      typeList: [\n        {\n          type: 1,\n          desc: ''原创''\n        },\n        {\n          type: 2,\n          desc: ''转载''\n        },\n        {\n          type: 3,\n          desc: ''翻译''\n        }\n      ],\n      article: {\n        id: null,\n        articleName: '''',\n        content: '''',\n        featured: 0,\n        summary: '''',\n        cover: '''',\n        categoryName: null,\n        categoryId: null,\n        tagNames: [],\n        tagIds: [],\n        top: 0,\n        type: 1,\n        status: 1\n      },\n      headers: {Authorization: ''Bearer '' + getToken()}\n    }\n  },\n  methods: {\n    onCreated(editor) {\n      this.editor = Object.seal(editor) // 一定要用 Object.seal() ，否则会报错\n    },\n    code(content) {\n      shiki\n          .getHighlighter({\n            theme: ''nord'',\n            langs: [''js''],\n          })\n          .then(highlighter =&gt; {\n            const code = highlighter.codeToHtml(`console.log(''shiki'');`, { lang: ''js'' })\n            document.getElementById(''output'').innerHTML = code\n          })\n    },\n    listCategories() {\n      categoryList().then(res =&gt; {\n        this.categories = res\n      })\n    },\n    listTags() {\n      listAllTag().then(res =&gt; {\n        this.tagList = res\n      })\n    },\n    openModel() {\n      if (this.article.articleName.trim() === '''') {\n        this.$message.error(''文章标题不能为空'')\n        return false\n      }\n      if (this.article.content.trim() === '''') {\n        this.$message.error(''文章内容不能为空'')\n        return false\n      }\n      this.listCategories()\n      this.listTags()\n      this.addOrEdit = true\n    },\n    uploadCover(response) {\n      this.article.cover = response.data\n    },\n    beforeUpload(file) {\n      let isLt2M = true\n      isLt2M = file.size / 1024 / 1024 &lt; 100\n      return new Promise((resolve) =&gt; {\n        if (isLt2M) {\n          resolve(file)\n        }\n        imageConversion.compressAccurately(file, 1024).then((res) =&gt; {\n          resolve(res)\n        })\n      })\n    },\n    uploadImg(pos, file) {\n      const formData = new FormData();\n      formData.append(''file'', file)\n      upload(formData).then(res =&gt; {\n        let path = this.baseApi + ''/file/'' + res\n        this.$refs.md.$img2Url(pos, path)\n      })\n    },\n    saveArticleDraft() {\n      if (this.article.articleName.trim() === '''') {\n        this.$message.error(''文章标题不能为空'')\n        return false\n      }\n      if (this.article.content.trim() === '''') {\n        this.$message.error(''文章内容不能为空'')\n        return false\n      }\n      this.article.status = 3\n      add(this.article).then(res =&gt; {\n        if (res) {\n          this.$notify.success({\n            title: ''成功'',\n            message: ''保存草稿成功''\n          })\n        } else {\n          this.$notify.error({\n            title: ''失败'',\n            message: ''保存草稿失败''\n          })\n        }\n      })\n      this.autoSave = false\n    },\n    saveOrUpdateArticle() {\n      if (this.article.articleName.trim() === '''') {\n        this.$message.error(''文章标题不能为空'')\n        return false\n      }\n      if (this.article.content.trim() === '''') {\n        this.$message.error(''文章内容不能为空'')\n        return false\n      }\n      if (this.article.categoryName == null) {\n        this.$message.error(''文章分类不能为空'')\n        return false\n      }\n      if (this.article.tagNames.length === 0) {\n        this.$message.error(''文章标签不能为空'')\n        return false\n      }\n      if (this.article.cover.trim() === '''') {\n        this.$message.error(''文章封面不能为空'')\n        return false\n      }\n      this.code(this.article.content)\n      add(this.article).then(res =&gt; {\n        this.$notify.success({\n          title: ''成功''\n        })\n        this.addOrEdit = false\n      })\n      this.autoSave = false\n    },\n    searchCategories(keywords, cb) {\n      let param = {blurry: keywords}\n      list(param)\n          .then(res =&gt; {\n            cb(res)\n          })\n    },\n    handleSelectCategories(item) {\n      this.addCategory({\n        categoryName: item.categoryName,\n        id: item.id\n      })\n    },\n    addCategory(item) {\n      this.article.categoryName = item.categoryName\n      this.article.categoryId = item.id\n    },\n    removeCategory() {\n      this.article.categoryName = null\n      this.article.categoryId = null\n    },\n    searchTags(keywords, cb) {\n      this.axios\n          .get(''/api/admin/tags/search'', {\n            params: {\n              keywords: keywords\n            }\n          })\n          .then(({data}) =&gt; {\n            cb(data.data)\n          })\n    },\n    handleSelectTag(item) {\n      this.addTag({\n        tagName: item.tagName,\n        id: item.id\n      })\n    },\n    addTag(item) {\n      if (this.article.tagNames.indexOf(item.tagName) === -1) {\n        this.article.tagNames.push(item.tagName)\n        this.article.tagIds.push(item.id)\n      }\n    },\n    removeTag(item) {\n      const index = this.article.tagNames.indexOf(item)\n      this.article.tagNames.splice(index, 1)\n      this.article.tagIds.splice(index, 1)\n    },\n    beforeDestroy() {\n      const editor = this.editor\n      if (editor == null) return\n      editor.destroy() // 组件销毁时，及时销毁编辑器\n    }\n  },\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 14, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-11 02:54:26.696826', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733923559308333057, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<p><br></p><pre><code class=\"language-java\">public void test() {\n  System.out.println();\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 10, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-11 02:56:05.939551', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733923603507908609, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<p>代码实例</p><pre><code class=\"language-java\">public void test() {\n  System.out.println();\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 9, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-11 02:56:16.477002', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1733927608468443137, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<p>代码实例</p><pre><code class=\"language-java\">public void test() {\n  System.out.println();\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 7, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-11 03:12:11.333528', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1734263147285458946, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-12 01:25:30.022537', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1734263184715427842, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-12 01:25:38.946207', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1734263563666599937, null, 'admin', 'Api', '添加文章', 'POST /api/blog/article/add',
        '{"id":1733829904429854721,"cover":"1702212229054-202201cthxrxhggtg.jpg","articleName":"java","summary":"cscsdcs","content":"<p>😇😟代码实例</p><pre><code class=\"language-java\">public void test() {\n  System.out.println();\n}</code></pre><p><br></p>","status":1,"top":0,"featured":1,"categoryId":1718181725051314178,"tagIds":[1718217000993447937]}',
        0, null, null, '127.0.0.1', 20, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-12 01:27:09.294803', null, 'POST',
        'com.libre.framework.blog.controller.admin.ArticleAdminController', null, 'saveArticle', null, null, null,
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1735341008176136194, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-15 00:48:32.084764', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1735341021497245697, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-15 00:48:35.259650', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1736745144931090434, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-18 21:48:04.374656', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1736745163574771714, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-18 21:48:08.819216', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1737127732002693121, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2023-12-19 23:08:20.240123', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750186485765763073, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-24 23:59:09.757655', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750186513251037185, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 13, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-24 23:59:16.310206', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750190652584488962, null, 'admin', 'Api', '新增菜单', 'POST /api/sys/menu',
        '{"id":null,"parentId":3,"title":"文件管理","name":null,"seq":null,"path":"/tool/file","permission":null,"component":"tool/storage/index","icon":"chain","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 70, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-25 00:15:43.204008', null, 'POST',
        'com.libre.framework.system.controller.SysMenuController', null, 'create', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750190901604511745, null, 'admin', 'Api', '修改菜单', 'PUT /api/sys/menu',
        '{"id":1750190652307664897,"parentId":3,"title":"文件管理","name":null,"seq":null,"path":"/tool/file","permission":null,"component":"tools/storage/index","icon":"chain","isFrame":false,"type":1,"cache":false,"hidden":false,"status":true,"remark":null}',
        0, null, null, '127.0.0.1', 75, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-25 00:16:42.575612', null, 'PUT',
        'com.libre.framework.system.controller.SysMenuController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750849911521300482, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-26 19:55:22.783227', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750849926385913858, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-26 19:55:26.327378', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1750849946048811009, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 6, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-26 19:55:31.015652', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751210946698719233, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 19:50:00.278651', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751210968450379777, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 19:50:05.462515', null,
        'POST', null, null, null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751212305674186754, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 15, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 19:55:24.281824', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751220705229320194, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 7, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 20:28:46.891758', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751220739962351618, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 7, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 20:28:55.173648', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751220745071013889, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_yes_no&size=9999&page=0', null, 0, null, null, '127.0.0.1', 3, 'Mac OS X',
        'Chrome 11', '内网IP', '2024-01-27 20:28:56.390599', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751220757607788545, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_job_status&size=9999&page=0', null, 0, null, null, '127.0.0.1', 2,
        'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 20:28:59.379852', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751220857725825025, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_notice_statussys_notice_type&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 2, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-27 20:29:23.250346', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751305684579823617, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 99, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-28 02:06:27.548847', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751305779538866177, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 41, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-28 02:06:50.189814', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751305915056828417, null, 'admin', 'Api', '修改用户', 'POST /api/sys/user/edit',
        '{"id":1611456101490913282,"username":"test","nickName":"test","email":"test@gmail.com","phone":"15191910116","gender":"1","avatarName":null,"avatarPath":null,"enabled":1,"roleIds":[1611451973884768257]}',
        0, null, null, '127.0.0.1', 12351, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-28 02:07:22.497837', null,
        'POST', 'com.libre.framework.system.controller.SysUserController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1751305915555950594, null, 'admin', 'Api', '修改用户', 'POST /api/sys/user/edit',
        '{"id":1611456101490913282,"username":"test","nickName":"test","email":"test@gmail.com","phone":"15191910116","gender":"1","avatarName":null,"avatarPath":null,"enabled":0,"roleIds":[1611451973884768257]}',
        0, null, null, '127.0.0.1', 15339, 'Mac OS X', 'Chrome 11', '内网IP', '2024-01-28 02:07:22.617368', null,
        'POST', 'com.libre.framework.system.controller.SysUserController', null, 'update', null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753419130641403905, null, null, 'Logout', '登出成功', 'DELETE /api/auth/logout', null, 0, null, null,
        '127.0.0.1', null, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:04:32.356006', null, 'DELETE', null, null,
        null, null, null, null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753421423600259074, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:75)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 1372, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:13:39.038894', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '75', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753421934210629634, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:74)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 15372, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:15:40.778038', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '74', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753423141557825538, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:77)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 227, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:20:28.631870', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '77', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753423355186343937, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:78)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 15589, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:21:19.565534', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '78', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753424216125923330, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:78)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 45204, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:24:44.828629', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '78', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753424409852436482, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:78)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1538)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 13299, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:25:31.016777', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '78', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753426389505220610, null, null, 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 1, null, e'java.lang.NullPointerException: Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null
	at com.libre.framework.system.security.controller.AuthorizationController.login(AuthorizationController.java:83)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:352)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:196)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint.proceed(MethodInvocationProceedingJoinPoint.java:89)
	at com.libre.framework.toolkit.moudle.log.aspect.SysLogAspect.logAround(SysLogAspect.java:64)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethodWithGivenArgs(AbstractAspectJAdvice.java:637)
	at org.springframework.aop.aspectj.AbstractAspectJAdvice.invokeAdviceMethod(AbstractAspectJAdvice.java:627)
	at org.springframework.aop.aspectj.AspectJAroundAdvice.invoke(AspectJAroundAdvice.java:71)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:173)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:97)
	at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:184)
	at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:765)
	at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:717)
	at com.libre.framework.system.security.controller.AuthorizationController$$SpringCGLIB$$0.login(<generated>)
	at java.base/jdk.internal.reflect.DirectMethodHandleAccessor.invoke(DirectMethodHandleAccessor.java:103)
	at java.base/java.lang.reflect.Method.invoke(Method.java:580)
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:254)
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:182)
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:118)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:917)
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:829)
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1089)
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979)
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014)
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:914)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:547)
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885)
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:614)
	at io.undertow.servlet.handlers.ServletHandler.handleRequest(ServletHandler.java:74)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:129)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:110)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.security.web.FilterChainProxy.lambda$doFilterInternal$3(FilterChainProxy.java:231)
	at org.springframework.security.web.ObservationFilterChainDecorator$FilterObservation$SimpleFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:479)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$1(ObservationFilterChainDecorator.java:340)
	at org.springframework.security.web.ObservationFilterChainDecorator.lambda$wrapSecured$0(ObservationFilterChainDecorator.java:82)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:128)
	at org.springframework.security.web.access.intercept.AuthorizationFilter.doFilter(AuthorizationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:126)
	at org.springframework.security.web.access.ExceptionTranslationFilter.doFilter(ExceptionTranslationFilter.java:120)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:131)
	at org.springframework.security.web.session.SessionManagementFilter.doFilter(SessionManagementFilter.java:85)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AnonymousAuthenticationFilter.doFilter(AnonymousAuthenticationFilter.java:100)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter.doFilter(SecurityContextHolderAwareRequestFilter.java:179)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.savedrequest.RequestCacheAwareFilter.doFilter(RequestCacheAwareFilter.java:63)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at com.libre.framework.system.security.jwt.JwtAuthenticationTokenFilter.doFilterInternal(JwtAuthenticationTokenFilter.java:47)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:227)
	at org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter.doFilter(AbstractAuthenticationProcessingFilter.java:221)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestRedirectFilter.doFilterInternal(OAuth2AuthorizationRequestRedirectFilter.java:181)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:107)
	at org.springframework.security.web.authentication.logout.LogoutFilter.doFilter(LogoutFilter.java:93)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.web.filter.CorsFilter.doFilterInternal(CorsFilter.java:91)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.header.HeaderWriterFilter.doHeadersAfter(HeaderWriterFilter.java:90)
	at org.springframework.security.web.header.HeaderWriterFilter.doFilterInternal(HeaderWriterFilter.java:75)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:82)
	at org.springframework.security.web.context.SecurityContextHolderFilter.doFilter(SecurityContextHolderFilter.java:69)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter.doFilterInternal(WebAsyncManagerIntegrationFilter.java:62)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:227)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.session.DisableEncodeUrlFilter.doFilterInternal(DisableEncodeUrlFilter.java:42)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.wrapFilter(ObservationFilterChainDecorator.java:240)
	at org.springframework.security.web.ObservationFilterChainDecorator$AroundFilterObservation$SimpleAroundFilterObservation.lambda$wrap$0(ObservationFilterChainDecorator.java:323)
	at org.springframework.security.web.ObservationFilterChainDecorator$ObservationFilter.doFilter(ObservationFilterChainDecorator.java:224)
	at org.springframework.security.web.ObservationFilterChainDecorator$VirtualFilterChain.doFilter(ObservationFilterChainDecorator.java:137)
	at org.springframework.security.web.FilterChainProxy.doFilterInternal(FilterChainProxy.java:233)
	at org.springframework.security.web.FilterChainProxy.doFilter(FilterChainProxy.java:191)
	at org.springframework.web.filter.DelegatingFilterProxy.invokeDelegate(DelegatingFilterProxy.java:352)
	at org.springframework.web.filter.DelegatingFilterProxy.doFilter(DelegatingFilterProxy.java:268)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.ServerHttpObservationFilter.doFilterInternal(ServerHttpObservationFilter.java:109)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116)
	at io.undertow.servlet.core.ManagedFilter.doFilter(ManagedFilter.java:67)
	at io.undertow.servlet.handlers.FilterHandler$FilterChainImpl.doFilter(FilterHandler.java:131)
	at io.undertow.servlet.handlers.FilterHandler.handleRequest(FilterHandler.java:84)
	at io.undertow.servlet.handlers.security.ServletSecurityRoleHandler.handleRequest(ServletSecurityRoleHandler.java:62)
	at io.undertow.servlet.handlers.ServletChain$1.handleRequest(ServletChain.java:68)
	at io.undertow.servlet.handlers.ServletDispatchingHandler.handleRequest(ServletDispatchingHandler.java:36)
	at io.undertow.servlet.handlers.RedirectDirHandler.handleRequest(RedirectDirHandler.java:68)
	at io.undertow.servlet.handlers.security.SSLInformationAssociationHandler.handleRequest(SSLInformationAssociationHandler.java:117)
	at io.undertow.servlet.handlers.security.ServletAuthenticationCallHandler.handleRequest(ServletAuthenticationCallHandler.java:57)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.security.handlers.AbstractConfidentialityHandler.handleRequest(AbstractConfidentialityHandler.java:46)
	at io.undertow.servlet.handlers.security.ServletConfidentialityConstraintHandler.handleRequest(ServletConfidentialityConstraintHandler.java:64)
	at io.undertow.security.handlers.AuthenticationMechanismsHandler.handleRequest(AuthenticationMechanismsHandler.java:60)
	at io.undertow.servlet.handlers.security.CachedAuthenticatedSessionHandler.handleRequest(CachedAuthenticatedSessionHandler.java:77)
	at io.undertow.security.handlers.AbstractSecurityContextAssociationHandler.handleRequest(AbstractSecurityContextAssociationHandler.java:43)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.SendErrorPageHandler.handleRequest(SendErrorPageHandler.java:52)
	at io.undertow.server.handlers.PredicateHandler.handleRequest(PredicateHandler.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.handleFirstRequest(ServletInitialHandler.java:276)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:135)
	at io.undertow.servlet.handlers.ServletInitialHandler$2.call(ServletInitialHandler.java:132)
	at io.undertow.servlet.core.ServletRequestContextThreadSetupAction$1.call(ServletRequestContextThreadSetupAction.java:48)
	at io.undertow.servlet.core.ContextClassLoaderSetupAction$1.call(ContextClassLoaderSetupAction.java:43)
	at io.undertow.servlet.handlers.ServletInitialHandler.dispatchRequest(ServletInitialHandler.java:256)
	at io.undertow.servlet.handlers.ServletInitialHandler$1.handleRequest(ServletInitialHandler.java:101)
	at io.undertow.server.Connectors.executeRootHandler(Connectors.java:393)
	at io.undertow.server.HttpServerExchange$1.run(HttpServerExchange.java:859)
	at org.jboss.threads.ContextHandler$1.runWith(ContextHandler.java:18)
	at org.jboss.threads.EnhancedQueueExecutor$Task.run(EnhancedQueueExecutor.java:2513)
	at org.jboss.threads.EnhancedQueueExecutor$ThreadBody.run(EnhancedQueueExecutor.java:1512)
	at org.xnio.XnioWorker$WorkerThreadFactory$1$1.run(XnioWorker.java:1282)
	at java.base/java.lang.Thread.run(Thread.java:1583)
', '127.0.0.1', 240, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:33:23.002683', null, 'POST',
        'com.libre.framework.system.security.controller.AuthorizationController', 'AuthorizationController.java',
        'login', '83', 'NullPointerException',
        'Cannot invoke "com.libre.framework.system.security.auth.LibreWebAuthenticationDetails.isRememberMe()" because "details" is null',
        null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753426993115889666, null, 'admin', 'Login', '登录成功', 'POST /api/auth/token?password=******&username=admin',
        null, 0, null, null, '127.0.0.1', 257, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:35:46.914814', null,
        'POST', 'com.libre.framework.system.security.controller.AuthorizationController', null, 'login', null, null,
        null, null);
INSERT INTO public.sys_log (id, user_id, username, log_type, description, params, data, success, class_method,
                            stack_trace, request_ip, request_time, os, browser, address, gmt_create, app_name,
                            request_method, class_name, file_name, method_name, line_number, exception_name, message,
                            seq)
VALUES (1753427163954085890, null, 'admin', 'Api', '查询多个字典详情',
        'GET /api/sys/dict/info/map?names=sys_common_enabledsys_user_sex&size=9999&page=0', null, 0, null, null,
        '127.0.0.1', 5, 'Mac OS X', 'Chrome 11', '内网IP', '2024-02-02 22:36:27.646593', null, 'GET',
        'com.libre.framework.system.controller.SysDictInfoController', null, 'getDictMaps', null, null, null, null);
