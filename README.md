# Interceptors
Interceptors are executed after DispatcherServlet and before the controller.
The are executed before sending the request to the controller, before sending the response to the client, and after sending the response to the client.

## HandlerInterceptor Interface Methods
1. preHandle() method − it is used to perform operations before sending the request to the controller. This method should return true to return the response to the client.
1. postHandle() method − it is used to perform operations before sending the response to the client.
1. afterCompletion() method − it is used to perform operations after completing the request and response.

For example, an interceptor can be used to add a request header before sending the request to the controller and to add a response header before sending the response to the client.

### preHandle():
1. The interceptor invokes preHandle() before handling a request.
1. We can use this hook to log information about the request's parameters, such as where the request comes from (extract the source IP address of the HTTP request).
1. In case we run into a password or any other sensitive data, we can replace them with stars.
1. It returns true to continue processing the request. Otherwise, request will not proceed to the controller.

### postHandle():
1. The interceptor calls this method after the handler execution (controller) but before the DispatcherServlet renders the view.
1. We can use it to add additional attributes to ModelAndView. 
1. Another use case would be to compute the request's processing time.

### afterCompletion():
1. We can use this method to obtain request and response data after the view is rendered.
1. We can also use it to perform any cleanup operation.

## Methodology
1. Create an interceptor class that implements the HandlerInterceptor interface methods. Define this class as a @Component.
2. Register this Interceptor with InterceptorRegistry by using WebMvcConfigurer. Define this class as a @Configuration class.

## Difference Between Filters and Interceptors
The key difference between Spring Interceptors and Filters is the level at which they operate. Interceptors operate at the controller level, while Filters operate at the servlet level. This means that Interceptors have access to the controller and can modify the model and view, while Filters do not have access to the controller and can only modify the request and response.

Another difference is the order in which they are executed. Interceptors are executed before and after the controller method, while Filters are executed before and after the servlet. This means that Interceptors have more fine-grained control over the request and response, while Filters have more general control over the request and response.

### Request Execution Flow
1. A request is received by the Spring Boot application.
1. The request passes through the filter chain, which is responsible for handling low-level tasks such as authentication and URL rewriting. Each filter in the chain can modify the request or response before passing it on to the next filter.
1. Once the request has passed through the filter chain, it reaches the DispatcherServlet.
1. The DispatcherServlet matches the request to the appropriate controller method.
1. Before the controller method is invoked, the request passes through the interceptor chain, which is responsible for handling high-level tasks such as logging and performance monitoring. Each interceptor in the chain can modify the request or response before passing it on to the next interceptor.
1. Once the request has passed through the interceptor chain, the controller method is invoked.
1. The controller method generates a response, which passes back through the interceptor chain.
1. After the response has passed through the interceptor chain, it passes back through the filter chain. Each filter in the chain can modify the response before it is sent back to the client.

![Request Execution Flow](/assets/images/flow.png)
