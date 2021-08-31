# **ACCENTURE SIMPLE BDD FRAMEWORK**

This framework has been created using IntelliJ as IDE, Gradle for dependencies management and following a page object model.
The tests are executed in Chrome. The driver is stored in the 'resources' folder.

It requires the creation of some Gradle tasks to execute the different tests 
included.

For Login feature:

![img.png](img.png)

And for E2E feature:

![img_1.png](img_1.png)

## **TROUBLESHOOTING**

Maybe you can face several issues when you try to create these Gradle tasks. The most common problems are the next:

![img_2.png](img_2.png)

Intellij requires that the command is shortened. To achieve that, you must include the parameter '@argfile (Java 9+)' in Shorten command line parameter:

![img_3.png](img_3.png)

Another issue is that by default, the IDE can include an unnecessary class to Glue parameter:

![img_4.png](img_4.png)

Please, just remove 'net.serenitybdd.cucumber.actors'.

## **REPORTER**

Regarding the reporter, I would like to clarify that I have decided to use online Cucumber reports generated every time tests are executed, and you can find the link on the terminal output.

![img_5.png](img_5.png)

*It is possible to create more positive and negative scenarios. I would like to give you some examples:

### Login:

-login successful using the other two available users

-login unsuccessful using an invalid username

-login unsuccessful using invalid input type data, i.e., special characters and emojis (In this case, the requirements are unknown).

### E2E:

-Assert successful flow in more steps than I did in the feature

-Check cancel buttons and flow work correctly.

-Buy one, several, all items.

-Buy one when another is cancelled.

Of course, do not hesitate to contact me if there is any question you have.

Juan José Vidal Hernández

mail: juanvidher@gmail.com

phone: +34675208743

