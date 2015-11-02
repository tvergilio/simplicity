# Grails Iteration #2

Welcome to the second set of Grails exercises. The first iteration introduced some basic persistence with a few simple
domain classes. You'll now go further into persistence by exploring queries, custom mappings, and transactions. You'll
also learn about dependency injection and how Spring underpins your Grails applications.

## Creating data

You should have these core domain classes from the first iteration:

* `Course`
* `Faculty`
* `Student`

If any of them are missing, go back to iteration #1 to complete the corresponding steps.

GORM provides various CRUD-based (create, retrieve, update, delete) methods to interact with the database. In this
first section you'll concentrate on the first: creating new data.

1. Make a many-to-many relationship between `Student` and `Course`. At the moment, `Student` should have a `hasMany`
property, so all you need to do is add a `hasMany` to `Course` for the registered students. If you do nothing else,
the application will fail to start at this point, reporting an error along the lines of "you need to add a belongsTo".
This is because every many-to-many relationship requires a `belongsTo` property on one side of the relationship. This
isn't really about ownership, but rather to define how saves are cascaded. If you save a `Student` object, are the
attached `Course`s saved too? Or is it the other way round? You can see an example in pages 114-119 of the lecture
notes.

    In this case, we want to attach courses to students, so we're going to have `Course` belong to `Student`. This is a
little tricky because `Course` already belongs to `Faculty` and you can't have duplicate property names in a class!
In a many-to-many, the `belongsTo` can't include a back reference, so it has to specify a class without an associated
property. Your current `belongsTo` should be a map that has a property name plus the class type, which is incompatible
with many-to-many relationships. So what you need to do is change the value of `belongsTo` in `Course` so it is a list
of the class literals `Faculty` and `Course`.

    So what happens to `Course`'s reference to `Faculty`? It's now gone, but you can add it explicitly by declaring a
normal property of type `Faculty` with the same name as before (probably `faculty`).

2. In the `BootStrap.init` closure (you can find _BootStrap.groovy_ in the _grails-app/conf_ directory), load the data
from _grails-app/conf/initialData.json_ and use it to populate the database. Look at the JSON file to see how it's
structured. To load the file, simply use `getClass().getResource("initialData.json").getText("UTF-8")`. Page 142 of
the lecture notes has a brief example. You basically need to use the `addTo...()` and `save()` methods to link objects
together and persist them to the database. This was an optional task in the first iteration but is now required.

    Note that the lecture notes give examples of saving data with different types of relationships alongside the details
of how they map to the database. You can also find more information in the GORM chapter of the Grails user guide.

    If you did the optional task from before, the only change is that you now need to create the students.

3. (Optional) Pluralise the database table names and add an index to the `code` property on `Course` so that queries
on the course code are more efficient. You can do this through a `mapping` property as described in the Custom ORM
Mapping chapter of the user guide. Note that you can find details and examples for each type of custom mapping under
the Database Mapping heading of the quick reference of the user guide.

## Querying

Once you have data in a database, you usually want to access it through queries. You may already have performed some
queries from the optional tasks in iteration 1, but you will now explore the different types of queries in a focused
way.

As described in the lecture notes starting at page 141, GORM provides four different ways of querying the database:

* Dynamic finders
* Where queries
* Criteria API
* HQL

(There is a fifth option which is query by example in which your query argument is a partially initialised domain
instance and GORM tries to find matching records).

Consider only using a couple of these types in a single application. I tend to prefer Where queries + HQL. For these
exercises, though, try all the query types and only skip Criteria API if you want to save time (i.e. treat it as optional).

1. Create an integration test, for example by using the command `create-integration-test org.example.Query`.

    Integration tests look like normal unit tests, but they bootstrap most of the Grails environment, ensuring that all
the GORM methods work and interact with a real database (whichever one is configured for the "test" environment).
 
    With Grails 2.x, you won't be able to run this test case as a JUnit test. Either execute the Grails `test-app` command
or use IntelliJ's "run as test-app" option (it has a Grails icon). Note that the test case will take a little while to run
because of the Grails initialisation that takes place. Grails will also execute the `BootStrap.init` closure, which
means that you'll have data for your tests. Lastly, you can safely save more data within a `given` block if you wish
as that data will not persist between tests.

2. Write a test that looks up a course by its code

3. Write a test that looks up a faculty by its name and checks the appropriate courses are attached

4. Enable SQL logging as described on page 152 of the lecture notes. Run the tests again to see what queries are being
executed.

5. (Optional) Modify your faculty query so that the courses are fetched eagerly (see the Grails user guide for the
details of eager fetching). Do you see a change in the number of SQL queries that are executed?

6. Write a test that finds all faculties associated with the courses PHYS, CHEM and FRCH. You won't be able to do this
with dynamic finders.

7. Write a test that finds all courses in the Humanities faculty. You should be able to do this with only one SQL
query.

8. (Optional) Write a test that returns the number of registered students for each course. For example, return pairs
of course code + registration count. You won't be able to do this with dynamic finders and probably not with Where
queries either.


## Transactions and services

ACID transactions are an important mechanism for ensuring data integrity and Grails gives you an easy way to enable
them: services. Services also provide a way to decouple your UI (controllers and views) from the database access. To
understand how they work, it's useful to know a little about the Spring framework.

Spring is a fairly hefty library with a lot of associated projects that encompass a lot of the work that applications
commonly need to do. At it's core, though, Spring is a dependency injection framework, as the lecture notes attempt
to describe in pages 157-161. All you really need to understand at this stage are the basic concepts of how objects
are instantiated and connected together (via wiring).

For this section, you should attempt to move all of your database access and business logic out of controllers and
into services. You can use the `create-service` command to create them or just create new Groovy classes inside the
_grails-app/services_ directory with a name suffix of `Service`. The names of the services are up to you, but consider
what functionality a given service provides and name it after that.

1. Create a service for handling student registrations. This should create new `Student` objects for the `login` action
on request and link students to courses.

2. Inject the service into the relevant controllers by declaring a property with the appropriate name in those classes.
Page 160 of the lecture notes explains how to do this, as does the user guide in more detail. See The Service Layer
chapter.

3. If you don't yet have a page that displays the courses that a student is currently registered for, create scaffolding
controllers for `Student` and `Course`. Go to the Show page for a given student to see the courses listed.

4. Make sure that when you attach a course to a student, you explicitly call `save(flush: true)` on the student. To
understand about flushing, read about the persistence session from page 162 onwards of the lecture notes.

5. _After_ saving the `Student` object during registration, try throwing a `RuntimeException`. Was the course linked to
the student? Now try throwing `Exception`. Can you see the link this time? You should notice that no connection is made
the first time, but it is the second time. This is because transactions are only rolled back for runtime exceptions by
default. You rarely need to know about the difference between checked exceptions and runtime exceptions in Groovy as
they are treated the same, but this is one of those rare cases.

    Exceptions are the normal mechanism for rolling back transactions in services. The idea is that a transaction
should only fail if there is an unexpected event. Data validation should occur before any attempt to persist it is made,
so validation failures should not trigger a rollback.

6. Create or update unit tests for the affected controllers and the new service. Note that you should use Spock's
mocking support to mock the service in the controller unit tests.

7. (Optional) If you implemented the Ask A Question feature, refactor that code to use a service as well.

8. (Optional) The `DummyEmailService` should only be used for testing and development. Production should actually send
an email. In _grails-app/conf/spring/resources.groovy_, register a different implementation for the `mailSender` Spring
bean that sends an email (for example using the Grails Mail plugin or Javamail - horrible! - or by ignoring it). The
key is to see how you can enable different implementations. The _resources.groovy_ file can include normal Groovy
code like conditions, but is mostly based on something called the Bean Builder DSL as described in the Grails And
Spring chapter of the Grails user guide.
 
## Auditing

(Optional) It's a common requirement in applications to track what changes are made to the data. Although there are
a few Grails plugins that provide auditing support, you're going to implement a basic mechanism yourself for practice.

1. Create an `AuditEvent` domain class that has properties for the type/class that an event relates to and the type
of the event itself (CREATION, MODIFICATION, DELETION, etc.). These should be strings.

2. Create an `AuditService` that has a method for recording an event. You can have separate methods for each event type
or make the event type an argument of a single main method. Each method you create should persist a new `AuditEvent`
instance based on the provided information.

3. Inject the audit service into your other services and use it to record any changes that you make.

4. Write integration tests for your other services that verify the appropriate events are created. Note once again that
you don't have to mock anything. Integration tests wire all your services together automatically. The only thing
missing is the HTTP handling.

