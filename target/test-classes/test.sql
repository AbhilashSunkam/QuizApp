insert into questions (id, answer, answer1, answer2, answer3, answer4, question_name, category_id, difficulty_id) values (11, 'a', 'delhi' ,'mumbai' ,'bangalore' ,'hyderabad','what is capital of india', 1, 1 );
insert into questions (id, answer, answer1, answer2, answer3, answer4, question_name, category_id, difficulty_id) values (12, 'b', 'bangalore', 'chennai', 'hyderabad','mumbai','what is the capital of tamilnadu',1,1);
insert into questions (id, answer, answer1, answer2, answer3, answer4, question_name, category_id, difficulty_id) values (13, 'c','southafrica','australia','india','pakistan','Who won 2011 world cup',1,1);
insert into questions (id, answer, answer1, answer2, answer3, answer4, question_name, category_id, difficulty_id) values (14, 'c','southafrica','australia','india','pakistan','Who won 2011 world cup',1,1);
insert into questions (id, answer, answer1, answer2, answer3, answer4, question_name, category_id, difficulty_id) values (15, 'c','southafrica','australia','india','pakistan','Who won 2011 world cup',1,1);


insert into quizzes(id, category_id, difficulty_id, description) values (11, 1 , 1 , 'abhi quiz');
insert into quizzes(id, category_id, difficulty_id, description) values (12, 1 , 1 , 'sai quiz');
insert into quizzes(id, category_id, difficulty_id, description) values (13, 1 , 1 , 'ojas quiz');
insert into quizzes(id, category_id, difficulty_id, descirption) values(24,1,1,'testquiz');
insert into quizquestions(id, quiz_id, question_id) values (11, 11, 11);
insert into quizquestions(id, quiz_id, question_id) values (12, 11, 12);
insert into quizquestions(id, quiz_id, question_id) values (13, 2, 1);
insert into quizquestions(id, quiz_id, question_id) values (14, 2, 3);


insert into users(id, email, score, role_id, quiz_id) values (1, 'xyz@practo.com', 0, 2, 1);
insert into users(id, email, score, role_id, quiz_id) values (12, 'pqr@practo.com', 1, 2, 2);
insert into users(id, email, score, role_id, quiz_id) values (3, 'pqr@practo.com', 1, 2, 2);
insert into users(id, email, score, role_id, quiz_id) values (13, 'pqr@practo.com', 1, 2, 2);
insert into users(id, email, score, role_id, quiz_id) values (14, 'asa@practo.com', 1 ,2 ,2);

insert into role(id, role_name) values (1, 'admin');
insert into role(id, role_name) values (2, 'user');
insert into role(id, role_name) values (3, 'user');
