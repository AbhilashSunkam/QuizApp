
#Quiz Application

[![Travis](https://img.shields.io/travis/AbhilashSunkam/QuizApp.svg)](https://github.com/AbhilashSunkam/QuizApp)

- A quizApp which has ability to build quizzes based on level and category.
- It has two levels of login. 
- Admin will be able to generate quizzes based on category and level from the questions existing in the question bank. 
- Once the user logs in, after he selects a category and difficulty level he will get one of the generated quizzes. 

Randomness on two levels is achieved

- While generating a quiz by Admin
- While getting quiz for a user

#Technologies used

- Java 8
- MySQL
- HsqlDb for testing
- Javascript, CSS, HTML
- Google sign in
- Hibernate (ORM)
- Google checkstyle and code formatter

Apiary Link : [apiary](https://app.apiary.io/quizapplication/editor)

Travis Link : [travis](https://travis-ci.org/AbhilashSunkam/QuizApp)

Sentry Link : [sentry](https://sentry.io/practo-bs/quiz-app/)

AWS Deployment : [amazon Ec2 hosting](http://ec2-35-161-132-3.us-west-2.compute.amazonaws.com:8080/Quiz-App)

Schema Diagram : [schema](https://github.com/AbhilashSunkam/QuizApp/blob/master/quizapp.svg)

#Running on AWS server

- Create a Deployable war file 
- Run it on Tomcat server by putting the war file in the webapps folder

