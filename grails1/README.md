# Grails Iteration #1

Welcome to the first set of Grails exercises. These will have you working with controllers, views, form submissions, and some basic database work.

Remember that you can keep the application running (via the `run-app` command or the IDE's equivalent) while editing controllers, views, tag libraries and partial templates. This will save you a lot of time since the application can take a while to start up.

Note that you may have to wait up to 5 or so seconds before a change in a source file is reflected in the running application. If you still don't see the change after that time, first check your code. If nothing obvious is amiss, restart the application.

## Getting started

Use IntelliJ's Open... option to load this project into the IDE. IntelliJ should identify it as a Grails application and offer you a Grails View tool window. You will also need to set up a Grails SDK (for Grails version 2.5.0) if you haven't done so already.

Try running the application from the IDE. You should see a play button in the tool bar next to "Grails:grails1". Just click on that button to start the app.

Once you have the application up and running, you can start working on the exercises, starting with a simple health status URL:

1. Create a new `org.example.Health` controller. If you right-click on the _controllers_ folder in the project view, you'll be able to select the New > Grails Controller option.

2. Add an action called `status`.

3. Make this action render a plain text page containing just the text "OK". If you can't remember how to do this, check both the lecture notes and the Grails user guide (the chapter on the Web Layer is the one you want).

4. Point your browser at the URL for this page to check that it works. Does the response have a content type of "text/plain"? Remember how the URL relates to the controller and action names based on a convention. You can find details of this convention in the introductory Grails lecture notes.

5. (Optional) Add a custom URL for this page at "/status".

6. (Optional) Write a org test for the `status` action. You will need to use the `@TestFor` annotation to make sure that the injected controller methods and properties work. You shouldn't need to use `@Mock` because the action shouldn't be using any other Grails artifact (a class with a special meaning in Grails, such as controllers, services, persistence classes, etc.).

## The database model

We're going to mimic a bit of the Banner system and create some persistence classes that represent the actors and objects within a university system, centred around courses. Don't forget to use the Grails user guide to see what constraints are available and how to use them.

1. Create a new domain class `org.example.Faculty`. This should have the following properties:
    * `name` (a string that must not be null, blank, or longer than 20 characters)
2. Create another domain class `org.example.Course`. This should have the following properties:
    * `code` (a string of 3 to 4 characters, must be unique)
    * `title` (a string that must not be null or blank)
    * `description` (a string that must not be null or blank, and can have up to 2000 characters)
3. Configure `Faculty` to have many `Course`s, via the `hasMany` property.
4. Configure `Course` to belong to `Faculty`, with a back reference, i.e. a `faculty` property that links to the corresponding `Faculty`.
5. Create dynamically scaffolded controllers for these persistence classes. You can do this by either running the `create-scaffold-controller` command or creating the controller manually and replacing all existing actions (if there are any) with a `scaffold` property.
6. Point your browser at the [[http://localhost:8080/grails1/dbconsole]] URL, copy the _development_ connection URL from _grails-app/conf/DataSource.groovy_ (it's the string that starts with "jdbc:h2:mem:...") and paste it into the corresponding field in that page, and then connect to the database. Have a look at the structure of the DB (tables, columns, types, etc.).
7. (Optional) In the `BootStrap.init` closure (you can find _BootStrap.groovy_ in the _grails-app/conf_ directory), load the data from _grails-app/conf/initialData.json_ and use it to populate the database. Look at the JSON file to see how it's structure. To load the file, simply use `getClass().getResource("initialData.json").getText("UTF-8")`. Check the lecture notes and user guide for information on how to save new persistence objects, particularly those with relationships. You'll want to make use of `addTo...()` and `save()`.

You can make use of the CRUD-based scaffolding UI to add data to the system, but do remember that the data will disappear if you restart the server. Also, avoid creating or modifying persistence classes while the application is running. Stop the app, make your changes, then start it up again.

## Course information pages

Next we'll add the main entry pages of the application, which will allow users to view courses and, later, register for them.

1. Create an `org.example.Main` controller.
2. Add an `index` action if it doesn't exist. Inside this action, load all the courses from the database using `Course.list()`, which returns a list of `Course` objects. Put this list in the view model returned from the action.
3. With the application running, point your browser at [[http://localhost:8080/grails1/main/]] (you don't need to specify _index_ in the URL because it's treated as the _default action_). You should see a 404 error message saying it can't find _index.gsp_. That's because you haven't created the view yet.
4. Create the view for this page in the appropriate location. The lecture notes and Grails user guide both explain the conventions for the locations and names of view files. Write whatever markup you want to display the course information, limiting it to the course code and title. You will probably want to use the `<g:each>` tag to iterate over the courses.
5. Create another page that displays all the information for just one course. The URL for the page will need to include some identifier for which course you want to display. This could be either the `id` of the persistence object or the course code. The conventions for URLs mean that you can access an `id` parameter in the `params` map, but that ID can be whatever you want (it's just a string).

    If you use the `id` property of the `Course` object as the identifier, use `Course.get(ID)` to retrieve the course object. If you are using the course code as the identifier, use a simple query to fetch the matching `Course` object. Use a GSP view to render the page, passing the course to the view via the view model. It should display the course code, the title, the description and the name of the faculty running the course.
6. Modify the first page that lists the courses so that each course code is a hyperlink to the corresponding course page. The `<g:link>` tag is the best one for this job.
7. (Optional) Add org tests for the two actions you created for this section.
8. (Optional) Modify the main course page so that it has a text field + search button. If the search field contains only "*", display all courses after the search is submitted. Otherwise, display only those courses that have a matching course code or title. You can use any wildcards you want with the database query. In this case, `Course.list()` won't cut it. You'll need one of the other query options.
9. (Optional) Use a partial template to ensure that each course is rendered the same in the course list.
10. (Really optional) Make the search AJAX in any way you see fit. You could experiment with the adaptive AJAX tags provided by Grails, such as <g:submitToRemote/>, or use native jQuery code.

## Student registration

In the next phase, you'll add the option for users (students) to register for particular courses.

1. You need to record a student registration in the database. So stop the application if it's running and create a new persistence class `org.example.Student` with the properties:
    * `name` (a string that must not be null or blank)
    * `email` (a string that must not be null or blank and must satisfy the requirements of an email address - there's a specific constraint for this)
2. Add a `hasMany` to `Student` that contains the `Course`s the student is registered for.
3. Add an `org.example.Auth` controller that has a `showLogin` action.
4. Add a view for `showLogin` that has a form containing fields for email address and the person's name.
5. Have the form submit to the `Auth.login` action, which you should also create. Have the `login` action find a `Student` with the given email address. If the result is:
    * no student found with that address, then create a new `Student` object populated with the values from the field. Save the student with `save()` and then put the `Student` object in the HTTP session under the key `user`.
    * student found but the names don't match, then redirect to an error page (you should create a simple action that renders an error message of your choice).
    * student found, then put that `Student` object in the session under the key `user`.

    In the cases where you add a user to the session, redirect back the course list.
6. Add a "Log in" link to the main courses page that points to the `Auth.login` action. The link should only be displayed if there isn't a `Student` object in the session under the key `user`. You'll find the `<g:if>` tag useful for that. Note that you can access the `session` variable directly in view as well as in controllers. If there is a `session.user` object, then display that object's `name` property instead.
7. (Optional) Create a custom tag, `<app:isAuthenticated>`, that only displays its contents if there is a user in the session. Create another tag that displays the logged-in user's name. Use these where appropriate. Add `<app:isNotAuthenticated>` too for displaying the "Log in" link.
8. (Optional) Move the "Log in" link to a layout that is applied to all the pages in the app. There are several ways to apply a layout to a view, all of them mentioned in the lecture notes.
9. (Optional) Add a URL mapping from "/login" to `Auth.showLogin` for a _GET_ and from "/login" to `Auth.login` for a _POST_. See the URL mappings chapter of the Grails user guide for details on how to do this.
10. (Optional) On the page that shows a single course, add a _Register_ button or link that goes to a `Course.register` action. The button should only be displayed if there is a user in the session. This action should pick the user out of the session, call `Student.attach()` on it, retrieve the corresponding `Course` instance for the course that was being displayed, and finally add the `Course` to the `Student` via that `hasMany` relationship from step 2.

    At the end of the action, redirect to a page listing the course that the current student is registered for. You'll have to create the corresponding page of course.
11. (Optional) Add org tests for any controller actions that don't have them.

## Ask a question

(Advanced) This last exercise is a bit more involved as we introduce a collaborator for a controller. It's partly here to provide practice at using Spock mocks inside a Grails controller org test.

1. Add a `mailSender` property to `CourseController`.
2. Add an _Ask a question_ button to the page that displays the information about a single course. Note that this should be in a separate form if your _Register_ button/link is already inside a form. Add `from` (an email address) and `body` (the question text) fields to the new form. The form should submit to a new action, which you will create next.
3. Add a `contactHead` action to `CourseController`. This action should accept `from` and `body` from a form submission. It should then call the `void sendEmail(String to, String from, String subject, String body)` method on the `mailSender` object. Don't worry, for the running application, the property will be appropriately populated before your action is called. Hard code the `to` and `from` arguments based on the course that the _Ask a question_ button was on. It's up to you where this information comes from.
4. Write a org test for `contactHead` that verifies the appropriate email is sent once, and once only.
5. Hide the _Ask a question_ form by default and only display it when a link or something is clicked on. Make sure this only happens within the browser, i.e. use Javascript and don't send an extra request to the server.
