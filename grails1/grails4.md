# Grails Iteration #4

Welcome to the fourth set of Grails exercises. This is the first Rest-based iteration, in which you'll practise
URL mappings, generating JSON and XML responses, content negotiation, and testing your endpoints from a functional
test.

## Basic REST

This section will have you creating a simple REST-like API based on Grails' scaffolding. You won't be using the
`@Resource` annotation because it conflicts with the existing `CourseController`, `FacultyController`, etc. you already
have. Remember that the annotation creates a scaffolding controller and the corresponding URL mappings.

Instead, you will create the URL mappings and controller yourself.

1. Add a URL mapping from _/api/courses_ to a `CoursesApiController`, using the standard mappings of HTTP verbs to
controller actions. [Section 8.4.2](http://grails.github.io/grails-doc/2.5.0/guide/theWebLayer.html#restfulMappings) of
the Grails user guide has examples of the relevant syntax. One thing you will have to decide is whether _/api/courses_
represents a singleton or collection resource as the syntax is slightly different for each.

2. If you run the application and try to access _/api/courses_ you'll get a 404. You don't have a controller to process
the requests yet. Fix that now by creating `CoursesApiController` in the same package as your `Course` domain class.
You should have this controller extend `RestfulController` as described [in the user guide]
(http://grails.github.io/grails-doc/2.3.1/guide/webServices.html#restfulControllers). It should only handle JSON and
XML and should scaffold the `Course` domain class. Note that you shouldn't use the `scaffold` property as the
scaffolding is provided by the `RestfulController` abstract class that you're extending.

    One thing you might want to try from within IntelliJ is creating the controller as a Groovy Class. This is faster
than using the New > Grails Controller option, which relies on the Grails build system.

3. The controller you created has default implementations of all the actions that the _/api/courses_ URL maps to. So
start up the application and try sending different types of request to the URLs _/api/courses_ and _/api/courses/\<id>_.
GET requests can be sent from the browser normally, but you will need to use a browser plugin for REST or another tool
to easily send JSON/XML requests of the other types. For example, REST Console for Chrome.

    When sending requests, be sure either to add a _.\<format>_ suffix to the URL or an `Accept` header to the request.
Also add a `Content-Type` header when sending JSON or XML to the server.

    As part of the exercise, write or copy sample fragments of the JSON returned by (GET) or required by (POST, PUT)
into the comment headers (Javadocs) of each action. You will find that the POST and PUT expect JSON in the same form
as it's returned by GET. Also remember that POST operates on the parent URL, _/api/courses_, whereas PUT operates on a
known resource ID, _/api/courses/\<id>_.

    To save some time, when POSTing or PUTting the JSON for a course, use `"faculty": { "id": 1 }` for the `faculty`
property. This is the normal way to handle associations. It won't work if you try to use `"faculty": { "name": 
"Physical Sciences"}` for example, which will cause Grails to attempt to create a new faculty with that name. In other
words, the `id` property is the only way to associate one domain instance with another (existing) one.

4. Add the [_funky-spock_](http://grails.org/plugin/funky-spock) plugin as a dependency to the application. This will
allow you to write and run functional tests, which send and receive data over HTTP to a running instance of the
application.

5. Create a new Spock test under _test/functional_ with the name `RestSpec`. This should verify the behaviour of the
_/api/courses_ and _/api/courses/\<id>_ endpoints. You can use the `HttpURLConnection` object returned by
`URL.openConnection()`, or you can try an API more geared towards REST requests and responses, such as [groovy-wslite]
(https://github.com/jwagenleitner/groovy-wslite)
or [Spring's `RestTemplate`](http://spring.io/blog/2009/03/27/rest-in-spring-3-resttemplate/). [Here's an example]
(https://github.com/GrailsInAction/graina2/blob/master/ch12/hubbub/test/functional/com/grailsinaction/PostRestFunctionalSpec.groovy)
of some Grails functional tests.

    You should try to verify the behaviour of at least _GET_, _POST_, and _PUT_.

## JSON endpoints for app features

(Optional) The scaffolding can certainly get you up and running quickly with a REST-like API, but it's only useful for
CRUD-based applications centred on domain classes. You need to implement the API yourself for most applications. This section will
have you practising the necessary techniques.

1. Implement your own `index` action in `CoursesApiController` that accepts a `q` URL parameter. If this parameter is
sent by the client, the action should use its value as a query criterion. This is the same feature you implemented in
step 8 of the Courses Information section of the iteration #1 exercises. If no `q` parameter exists, use the standard
`index` implementation (`return super.index()`).

    Your implementation should factor in content negotiation. You can do this with the `respond()` method or 
`response.withFormat()`.

2. Add an action that registers a student with a course. The only information necessary is the student's email address
and the course code. Don't worry about handling student logins. Just assume that the client of the API has the required
permissions. We'll look at access control in the next iteration.

    You can code this action so that it only handles JSON, but do try to ensure that it returns the correct HTTP status
if the client attempts to request or send a format other than JSON. One way to do that is to use `respond()` with the
`responseFormats` property in a controller. Otherwise, `render()` + `request/response.withFormat` should work fine.

    For requests without any nested objects, you'll find that command objects are your best option when dealing with
JSON or XML data submissions. The [user guide](has a little bit of information](http://grails.github.io/grails-doc/2.5.0/guide/webServices.html#binding)
on this area, but there aren't many examples. If you use command objects, all you need to do is make sure that the
command object's properties have the same names as the keys in the JSON. More complex mappings between JSON and target
classes can be achieved through custom `DataBindingSourceCreator` implementations, but that will require more work
and investigation on your part.

3. Implement a JSON endpoint for the Ask A Question feature from iteration #1 as well.

4. Don't forget to write unit and functional tests for these endpoints!
