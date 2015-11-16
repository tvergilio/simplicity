# Grails Iteration #3

Welcome to the third set of Grails exercises. In this iteration, you'll move beyond the core parts of Grails and
start working with plugins and access control. But first, messages.

## Resource bundles

The pages from the first iteration that display the list of available courses and show the details of a single course
should have bits of fixed text here and there, such as welcome text, field labels, etc.

1. Replace the fixed pieces of text with content retrieved from the resource bundles. Put the keys and display text
in _messages.properties_.

2. (Optional) Add one or more translations for the message keys you've created and test what happens when you add
the corresponding `lang` parameter to the URL.

## Access control

In these exercises, you're going to familiarise yourself with the basics of Spring Security and its Grails plugin.
You should already have a rudimentary sign in process from the first iteration, so you're just going to replace
that with Spring Security.

1. Add the Spring Security Core plugin as a dependency. Remember that this has to go inside the `plugins` block in
_BuildConfig.groovy_. You can find out which version of the plugin is the latest by going to the [plugin portal]
(http://grails.org/plugins) and searching for the plugin you're interested in.

2. Run `grails compile` or `grails refresh-dependencies`. These will trigger download and 'installation' of the
plugin. It's not really installed as such, but it can be useful to think of the process in that way.

3. Run the `s2-quickstart` command, which will create a login page, a logout URL, and domain classes for users and
roles. The default class names for the latter are `Person` and `Authority`, but remember that you can change those.
Do be aware that _user_ and _role_ are often reserved words in databases, so you may have to customise the table
names if you choose those as the class names.

4. Have a look at the end of _grails-app/conf/Config.groovy_. You'll see that the plugin has added various configuration
settings. There's no need to change these at the moment.

5. Run the application and try to access some of the pages you've created in previous iterations. What happens?

6. You now need to selectively open up the different parts of the application. Make sure that anyone can access:
    * the home page
    * login and logout URLs
    * available courses and individual course information

7. Since you won't be using `Student` for access control any more, you should link it to the Spring Security `Person`
class (or whichever class name you chose earlier). You can either do this as an association/reference or through
inheritance. You may want to add some students in `BootStrap` if you don't already have that code from iteration 2.
If you do have that code, you'll need to update it.

8. Update your sign in links so that they point to the plugin's login page. The same goes for any logout links you
may have.

9. (Optional) Only display the _register_ button if the user is authenticated or remembered.

10. (Optional) Mark the `register` action as requiring either an authenticated or remembered user. Also update it
to fetch the current user from Spring Security rather than the session. You should no longer be storing the user in
the session at this point.

11. (Optional) Add a sign up process so that new users can add accounts. You don't need to handle email confirmation
or verification, but do check whether the user already has an account.

12. (Optional) Integrate any other pages of the application with Spring Security. Most of this will simply involve
adding access rules.

## Plugins

For this exercise, extract the auditing components of your application into a plugin and then have your application
depend on that plugin. This may require some refactoring of the application beyond moving the audit classes out of
the app and into the plugin.

