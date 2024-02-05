Interceptors are executed:
Before sending the request to the controller.
Before sending the response to the client.

HandlerInterceptor interface has three methods:
preHandle() method − This is used to perform operations before sending the request to the controller. This method should return true to return the response to the client.
postHandle() method − This is used to perform operations before sending the response to the client.
afterCompletion() method − This is used to perform operations after completing the request and response.

For example, you can use an interceptor to add a request header before sending the request to the controller 
and add a response header before sending the response to the client

preHandle():
The interceptor invokes preHandle() before handling a request.
We can use the hook to log information about the request’s parameters, such as where the request comes from.
In case we run into a password here, we’ll need to make sure we don’t log that, of course. A simple option would be to replace passwords, and any other sensitive type of data, with stars.
We can extract the source IP address of the HTTP request.
It returns true to continue processing the request. Otherwise, request will not proceed to the controller

postHandle():
The interceptor calls this method after the handler execution but before the DispatcherServlet renders the view.
We can use it to add additional attributes to ModelAndView. 
Another use case would be to compute the request’s processing time.

afterCompletion():
We can use this method to obtain request and response data after the view is rendered.
We can also use it to perform any cleanup operations.