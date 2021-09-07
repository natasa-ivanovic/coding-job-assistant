insert into authorities (name) values ('ROLE_ADMIN');
insert into authorities (name) values ('ROLE_USER');

insert into company_status_config (company_medal, total_reviews, total_hired, average_rating, rated_positive_difference) values (1, 2, 0, 0, 5);
insert into company_status_config (company_medal, total_reviews, total_hired, average_rating, rated_positive_difference) values (2, 3, 2, 3, 5);
insert into company_status_config (company_medal, total_reviews, total_hired, average_rating, rated_positive_difference) values (3, 5, 3, 3.5, 5);

insert into job_offer_status_config (offer_medal, company_medal, total_followers, days_since_posted) values (1, 1, 1, 7);
insert into job_offer_status_config (offer_medal, company_medal, total_followers, days_since_posted) values (2, 2, 2, 14);
insert into job_offer_status_config (offer_medal, company_medal, total_followers, days_since_posted) values (3, 3, 3, 21);

------------------------------- USERS -------------------------------


-- password == name
-- admins
insert into users (name, surname, username, password, enabled, last_password_reset_date, role) values ('admin1', 'admin1', 'admin1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'ADMIN');

insert into user_authority (user_id, authority_id) values (1, 1);

-- jobseekers
-- passwords - admin1
insert into users (name, surname, username, password, enabled, last_password_reset_date, role, remote_work, salary_expectation, education, continuous_learning) values ('John', 'Smith', 'user1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'USER', true, 1000, 2, false);

insert into user_authority (user_id, authority_id) values (2, 2);

insert into users (name, surname, username, password, enabled, last_password_reset_date, role, remote_work, salary_expectation, education, continuous_learning) values ('Mark', 'Black', 'user2@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'USER', true, 1000, 3, false);

insert into user_authority (user_id, authority_id) values (3, 2);

insert into users (name, surname, username, password, enabled, last_password_reset_date, role, remote_work, salary_expectation, education, continuous_learning) values ('Jack', 'White', 'user3@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'USER', true, 1000, 4, false);

insert into user_authority (user_id, authority_id) values (4, 2);

insert into users (name, surname, username, password, enabled, last_password_reset_date, role, remote_work, salary_expectation, education, continuous_learning) values ('Mike', 'Reeves', 'user4@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'USER', true, 1000, 1, false);

insert into user_authority (user_id, authority_id) values (5, 2);

------------------------------ BENEFITS ----------------------------------
-- 1 - Flexible hours
insert into benefits (name, description, level_importance) values ('Flexible hours', 'description', 20);
-- 2 - Remote work
insert into benefits (name, description, level_importance) values ('Remote work', 'description', 20);
-- 3 - Home office allowance
insert into benefits (name, description, level_importance) values ('Home office allowance', 'description', 20);
-- 4 - Private health insurance
insert into benefits (name, description, level_importance) values ('Private health insurance', 'description', 20);
-- 5 - Competitive salaries
insert into benefits (name, description, level_importance) values ('Competitive salaries', 'description', 20);
-- 6 - Modern technologies
insert into benefits (name, description, level_importance) values ('Modern technologies', 'description', 20);
-- 7 - Attractive projects
insert into benefits (name, description, level_importance) values ('Attractive projects', 'description', 20);
-- 8 - Popular brand
insert into benefits (name, description, level_importance) values ('Popular brand', 'description', 20);
-- 9 - Professional growth
insert into benefits (name, description, level_importance) values ('Professional growth', 'description', 20);
-- 10 - Pleasant working atmosphere
insert into benefits (name, description, level_importance) values ('Pleasant working atmosphere', 'description', 20);
-- 11 - Paid sick leave
insert into benefits (name, description, level_importance) values ('Paid sick leave', 'description', 20);
-- 12 - Paid vacation
insert into benefits (name, description, level_importance) values ('Paid vacation', 'description', 20);
-- 13 - Life work balance
insert into benefits (name, description, level_importance) values ('Life work balance', 'description', 20);
-- 14 - Paid training
insert into benefits (name, description, level_importance) values ('Paid training', 'description', 20);
-- 15 - Provided food
insert into benefits (name, description, level_importance) values ('Provided food', 'description', 20);
-- 16 - Provided parking
insert into benefits (name, description, level_importance) values ('Provided parking', 'description', 20);
-- 17 - Work abroad
insert into benefits (name, description, level_importance) values ('Work abroad', 'description', 20);
-- 18 - Foreign language courses
insert into benefits (name, description, level_importance) values ('Foreign language courses', 'description', 20);
-- 19 - Free fitness coupons
insert into benefits (name, description, level_importance) values ('Free fitness coupons', 'description', 20);


------------------------------- CV ELEMENTS -------------------------------


-------------------- PROGRAMMING LANGUAGES --------------------

-- 1 - C
insert into cv_elements (name, type) values ('C', 0);
-- 2 - C++
insert into cv_elements (name, type) values ('C++', 0);
-- 3 - C#
insert into cv_elements (name, type) values ('C#', 0);
-- 4 - Java
insert into cv_elements (name, type) values ('Java', 0);
-- 5 - JavaScript
insert into cv_elements (name, type) values ('JavaScript', 0);
-- 6 - Ruby
insert into cv_elements (name, type) values ('Ruby', 0);
-- 7 - PHP
insert into cv_elements (name, type) values ('PHP', 0);
-- 8 - HTML
insert into cv_elements (name, type) values ('HTML', 0);
-- 9 - CSS
insert into cv_elements (name, type) values ('CSS', 0);
-- 10 - Kotlin
insert into cv_elements (name, type) values ('Kotlin', 0);
-- 11 - Python
insert into cv_elements (name, type) values ('Python', 0);
-- 12 - Go
insert into cv_elements (name, type) values ('Go', 0);
-- 13 - Pharo
insert into cv_elements (name, type) values ('Pharo', 0);
-- 14 - GML
insert into cv_elements (name, type) values ('GML', 0);
-- 15 - Lua
insert into cv_elements (name, type) values ('Lua', 0);
-- 16 - Swift
insert into cv_elements (name, type) values ('Swift', 0);
-- 17 - Dart
insert into cv_elements (name, type) values ('Dart', 0);
-- 18 - Matlab
insert into cv_elements (name, type) values ('Matlab', 0);
-- 19 - R
insert into cv_elements (name, type) values ('R', 0);
-- 20 - Bash
insert into cv_elements (name, type) values ('Bash', 0);
-- 21 - SQL
insert into cv_elements (name, type) values ('SQL', 0);

-------------------- TECHNOLOGIES --------------------

-- 22 - NodeJS
insert into cv_elements (name, type) values ('NodeJS', 1);
-- 23 - Laravel
insert into cv_elements (name, type) values ('Laravel', 1);
-- 24 - Angular
insert into cv_elements (name, type) values ('Angular', 1);
-- 25 - Vue
insert into cv_elements (name, type) values ('Vue', 1);
-- 26 - Django
insert into cv_elements (name, type) values ('Django', 1);
-- 27 - Unity
insert into cv_elements (name, type) values ('Unity', 1);
-- 28 - GM Studio
insert into cv_elements (name, type) values ('GM Studio', 1);
-- 29 - LWJGL
insert into cv_elements (name, type) values ('LWJGL', 1);
-- 30 - React
insert into cv_elements (name, type) values ('React', 1);
-- 31 - Flutter
insert into cv_elements (name, type) values ('Flutter', 1);
-- 32 - JUnit
insert into cv_elements (name, type) values ('JUnit', 1);
-- 33 - Jasmine
insert into cv_elements (name, type) values ('Jasmine', 1);
-- 34 - Selenium
insert into cv_elements (name, type) values ('Selenium', 1);
-- 35 - Ruby On Rails
insert into cv_elements (name, type) values ('Ruby On Rails', 1);
-- 36 - Maven
insert into cv_elements (name, type) values ('Maven', 1);
-- 37 - Spring Boot
insert into cv_elements (name, type) values ('Spring Boot', 1);
-- 38 - Spring
insert into cv_elements (name, type) values ('Spring', 1);
-- 39 - Pandas
insert into cv_elements (name, type) values ('Pandas', 1);
-- 40 - Numpy
insert into cv_elements (name, type) values ('Numpy', 1);
-- 41 - Tensorflow
insert into cv_elements (name, type) values ('Tensorflow', 1);
-- 42 - Keras
insert into cv_elements (name, type) values ('Keras', 1);
-- 43 - Trello
insert into cv_elements (name, type) values ('Trello', 1);
-- 44 - Jira
insert into cv_elements (name, type) values ('Jira', 1);
-- 45 - Travis-CI
insert into cv_elements (name, type) values ('Travis-CI', 1);
-- 46 - Heroku
insert into cv_elements (name, type) values ('Heroku', 1);
-- 47 - SonarQube
insert into cv_elements (name, type) values ('SonarQube', 1);
-- 48 - SonarCloud
insert into cv_elements (name, type) values ('SonarCloud', 1);
-- 49 - Git
insert into cv_elements (name, type) values ('Git', 1);
-- 50 - Amazon AWS
insert into cv_elements (name, type) values ('Amazon AWS', 1);
-- 51 - MS Azure
insert into cv_elements (name, type) values ('MS Azure', 1);

-------------------- KNOWLEDGE --------------------

-- 52 - Agile methodology
insert into cv_elements (name, type) values ('Agile methodology', 2);
-- 53 - SQL Databases
insert into cv_elements (name, type) values ('SQL Databases', 2);
-- 54 - Network communication
insert into cv_elements (name, type) values ('Network communication', 2);
-- 55 - NoSQL Databases
insert into cv_elements (name, type) values ('NoSQL Databases', 2);
-- 56 - Network management
insert into cv_elements (name, type) values ('Network management', 2);
-- 57 - Troubleshooting skills
insert into cv_elements (name, type) values ('Troubleshooting skills', 2);
-- 58 - Software virtualization
insert into cv_elements (name, type) values ('Software virtualization', 2);
-- 59 - Network protocols
insert into cv_elements (name, type) values ('Network protocols', 2);
-- 60 - REST
insert into cv_elements (name, type) values ('REST', 2);
-- 61 - Web security
insert into cv_elements (name, type) values ('Web security', 2);
-- 62 - Cloud technologies
insert into cv_elements (name, type) values ('Cloud technologies', 2);
-- 63 - Testing metodologies
insert into cv_elements (name, type) values ('Testing metodologies', 2);
-- 64 - Object oriented programming
insert into cv_elements (name, type) values ('Object oriented programming', 2);
-- 65 - Functional programming
insert into cv_elements (name, type) values ('Functional programming', 2);
-- 66 - Design patterns
insert into cv_elements (name, type) values ('Design patterns', 2);
-- 67 - CS algorithms
insert into cv_elements (name, type) values ('CS algorithms', 2);
-- 68 - ES6 specification
insert into cv_elements (name, type) values ('ES6 specification', 2);
-- 69 - Neural networks
insert into cv_elements (name, type) values ('Neural networks', 2);
-- 70 - Machine learning algorithms
insert into cv_elements (name, type) values ('Machine learning algorithms', 2);
-- 71 - SCRUM
insert into cv_elements (name, type) values ('SCRUM', 2);

-------------------- LANGUAGES --------------------

-- 72 - English
insert into cv_elements (name, type) values ('English', 3);
-- 73 - German
insert into cv_elements (name, type) values ('German', 3);
-- 74 - Dutch
insert into cv_elements (name, type) values ('Dutch', 3);
-- 75 - Spanish
insert into cv_elements (name, type) values ('Spanish', 3);
-- 76 - Italian
insert into cv_elements (name, type) values ('Italian', 3);

-------------------- SOFT SKILLS --------------------

-- 77 - Communication
insert into cv_elements (name, type) values ('Communication', 4);
-- 78 - Self motivation
insert into cv_elements (name, type) values ('Self motivation', 4);
-- 79 - Leadership
insert into cv_elements (name, type) values ('Leadership', 4);
-- 80 - Responsibility
insert into cv_elements (name, type) values ('Responsibility', 4);
-- 81 - Teamwork
insert into cv_elements (name, type) values ('Teamwork', 4);
-- 82 - Problem solving
insert into cv_elements (name, type) values ('Problem solving', 4);
-- 83 - Working under pressure
insert into cv_elements (name, type) values ('Working under pressure', 4);
-- 84 - Time management
insert into cv_elements (name, type) values ('Time management', 4);
-- 85 - Flexibility
insert into cv_elements (name, type) values ('Flexibility', 4);
-- 86 - Negotiation
insert into cv_elements (name, type) values ('Negotiation', 4);


------------------------------- JOB POSITIONS -------------------------------


-- job positions
-- 1 
insert into job_positions (title) values ('Backend Developer');
-- 2 
insert into job_positions (title) values ('Frontend Developer');
-- 3 
insert into job_positions (title) values ('FullStack Developer');
-- 4 
insert into job_positions (title) values ('Data Scientist');
-- 5 
insert into job_positions (title) values ('Game Developer');
-- 6 
insert into job_positions (title) values ('Mobile Application Developer');
-- 7 
insert into job_positions (title) values ('Computer System Analyst');
-- 8 
insert into job_positions (title) values ('Computer System Engineer');
-- 9 
insert into job_positions (title) values ('Network System Administrator');
-- 10 
insert into job_positions (title) values ('Database Administrator');
-- 11 
insert into job_positions (title) values ('Artificial Intelligence Specialist');
-- 12 
insert into job_positions (title) values ('Bioinformatics Software Engineer');
-- 13 
insert into job_positions (title) values ('Computer Forensics Investigator');
-- 14 
insert into job_positions (title) values ('Cybersecurity Strategist');
-- 15 
insert into job_positions (title) values ('Data Architect');
-- 16 
insert into job_positions (title) values ('Electronics Engineer');
-- 17 
insert into job_positions (title) values ('Game Tester');
-- 18 
insert into job_positions (title) values ('Lead Software Engineer');
-- 19 
insert into job_positions (title) values ('Security Administrator');
-- 20 
insert into job_positions (title) values ('SEO Analyst');
-- 21 
insert into job_positions (title) values ('Software Architect');
-- 22 
insert into job_positions (title) values ('Software Tester');
-- 23 
insert into job_positions (title) values ('Statistical Programmer');
-- 24 
insert into job_positions (title) values ('Telecommunications Engineer');
-- 25 
insert into job_positions (title) values ('Telecommunications Specialist');

-- backend - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 4);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 6);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 11);

-- frontend - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 7);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 8);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 9);

-- fullstack - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 4);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 6);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 7);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 8);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 9);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 11);

-- data scientist - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 11);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 18);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 19);

-- game developer - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 2);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 3);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 14);

-- mobile application developer - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 3);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 10);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 11);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 16);

-- network system admin - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 20);

-- software tester - programming lang
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 1);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 2);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 3);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 4);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 5);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 6);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 7);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 11);


-- backend - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 22);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 23);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 26);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 35);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 36);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 37);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 38);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 49);

-- frontend - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 22);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 23);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 24);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 25);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 30);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 49);

-- fullstack - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 22);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 23);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 24);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 25);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 26);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 35);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 36);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 37);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 38);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 49);

-- data scientist - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 39);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 40);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 41);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 42);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 49);

-- game developer - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 27);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 28);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 29);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 49);

-- mobile application developer - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 30);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 31);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 49);

-- network system admin - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 45);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 46);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 47);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 48);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 49);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 50);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 51);

-- software tester - technologies
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 32);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 33);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 34);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 49);


-- backend - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 52);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 53);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 60);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 64);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (1, 66);

-- frontend - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 52);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 60);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 64);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 66);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (2, 68);

-- fullstack - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 52);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 53);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 60);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 64);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 66);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (3, 68);

-- data scientist - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 69);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (4, 70);

-- game developer - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 52);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 55);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 56);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 61);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (5, 62);

-- mobile application developer - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 52);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 53);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 55);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 56);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 64);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (6, 66);

-- network system admin - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 54);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 56);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 58);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 59);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (9, 61);

-- software tester - knowledge
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 57);
insert into job_positions_cv_elements (job_position_id, cv_elements_id) values (22, 63);

------------------------------- PROFICIENCIES -------------------------------


-------------------- PROGRAMMING LANGUAGES --------------------

-- C
-- 1 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (1, 1);
-- 2 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (1, 2);
-- 3 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (1, 3);
-- 4 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (1, 4);
-- 5 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (1, 5);

-- C++
-- 6 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (2, 1);
-- 7 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (2, 2);
-- 8 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (2, 3);
-- 9 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (2, 4);
-- 10 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (2, 5);

-- C#
-- 11 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (3, 1);
-- 12 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (3, 2);
-- 13 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (3, 3);
-- 14 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (3, 4);
-- 15 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (3, 5);

-- Java
-- 16 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (4, 1);
-- 17 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (4, 2);
-- 18 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (4, 3);
-- 19 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (4, 4);
-- 20 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (4, 5);

-- JavaScript
-- 21 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (5, 1);
-- 22 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (5, 2);
-- 23 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (5, 3);
-- 24 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (5, 4);
-- 25 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (5, 5);

-- Ruby
-- 26 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (6, 1);
-- 27 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (6, 2);
-- 28 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (6, 3);
-- 29 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (6, 4);
-- 30 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (6, 5);

-- PHP
-- 31 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (7, 1);
-- 32 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (7, 2);
-- 33 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (7, 3);
-- 34 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (7, 4);
-- 35 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (7, 5);

-- HTML
-- 36 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (8, 1);
-- 37 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (8, 2);
-- 38 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (8, 3);
-- 39 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (8, 4);
-- 40 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (8, 5);

-- CSS
-- 41 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (9, 1);
-- 42 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (9, 2);
-- 43 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (9, 3);
-- 44 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (9, 4);
-- 45 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (9, 5);

-- Kotlin
-- 46 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (10, 1);
-- 47 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (10, 2);
-- 48 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (10, 3);
-- 49 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (10, 4);
-- 50 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (10, 5);

-- Python
-- 51 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (11, 1);
-- 52 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (11, 2);
-- 53 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (11, 3);
-- 54 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (11, 4);
-- 55 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (11, 5);

-- Go
-- 56 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (12, 1);
-- 57 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (12, 2);
-- 58 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (12, 3);
-- 59 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (12, 4);
-- 60 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (12, 5);

-- Pharo
-- 61 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (13, 1);
-- 62 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (13, 2);
-- 63 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (13, 3);
-- 64 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (13, 4);
-- 65 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (13, 5);

-- GML
-- 66 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (14, 1);
-- 67 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (14, 2);
-- 68 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (14, 3);
-- 69 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (14, 4);
-- 70 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (14, 5);

-- Lua
-- 71 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (15, 1);
-- 72 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (15, 2);
-- 73 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (15, 3);
-- 74 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (15, 4);
-- 75 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (15, 5);

-- Swift
-- 76 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (16, 1);
-- 77 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (16, 2);
-- 78 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (16, 3);
-- 79 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (16, 4);
-- 80 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (16, 5);

-- Dart
-- 81 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (17, 1);
-- 82 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (17, 2);
-- 83 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (17, 3);
-- 84 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (17, 4);
-- 85 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (17, 5);

-- Matlab
-- 86 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (18, 1);
-- 87 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (18, 2);
-- 88 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (18, 3);
-- 89 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (18, 4);
-- 90 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (18, 5);

-- R
-- 91 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (19, 1);
-- 92 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (19, 2);
-- 93 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (19, 3);
-- 94 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (19, 4);
-- 95 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (19, 5);

-- Bash
-- 96 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (20, 1);
-- 97 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (20, 2);
-- 98 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (20, 3);
-- 99 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (20, 4);
-- 100 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (20, 5);

-- SQL
-- 101 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (21, 1);
-- 102 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (21, 2);
-- 103 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (21, 3);
-- 104 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (21, 4);
-- 105 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (21, 5);

-------------------- TECHNOLOGIES --------------------

-- NodeJS
-- 106 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (22, 1);
-- 107 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (22, 2);
-- 108 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (22, 3);
-- 109 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (22, 4);
-- 110 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (22, 5);

-- Laravel
-- 111 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (23, 1);
-- 112 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (23, 2);
-- 113 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (23, 3);
-- 114 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (23, 4);
-- 115 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (23, 5);

-- Angular
-- 116 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (24, 1);
-- 117 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (24, 2);
-- 118 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (24, 3);
-- 119 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (24, 4);
-- 120 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (24, 5);

-- Vue
-- 121 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (25, 1);
-- 122 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (25, 2);
-- 123 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (25, 3);
-- 124 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (25, 4);
-- 125 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (25, 5);

-- Django
-- 126 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (26, 1);
-- 127 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (26, 2);
-- 128 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (26, 3);
-- 129 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (26, 4);
-- 130 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (26, 5);

-- Unity
-- 131 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (27, 1);
-- 132 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (27, 2);
-- 133 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (27, 3);
-- 134 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (27, 4);
-- 135 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (27, 5);

-- GM Studio
-- 136 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (28, 1);
-- 137 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (28, 2);
-- 138 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (28, 3);
-- 139 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (28, 4);
-- 140 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (28, 5);

-- LWJGL
-- 141 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (29, 1);
-- 142 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (29, 2);
-- 143 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (29, 3);
-- 144 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (29, 4);
-- 145 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (29, 5);

-- React
-- 146 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (30, 1);
-- 147 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (30, 2);
-- 148 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (30, 3);
-- 149 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (30, 4);
-- 150 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (30, 5);

-- Flutter
-- 151 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (31, 1);
-- 152 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (31, 2);
-- 153 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (31, 3);
-- 154 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (31, 4);
-- 155 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (31, 5);

-- JUnit
-- 156 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (32, 1);
-- 157 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (32, 2);
-- 158 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (32, 3);
-- 159 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (32, 4);
-- 160 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (32, 5);

-- Jasmine
-- 161 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (33, 1);
-- 162 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (33, 2);
-- 163 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (33, 3);
-- 164 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (33, 4);
-- 165 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (33, 5);

-- Selenium
-- 166 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (34, 1);
-- 167 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (34, 2);
-- 168 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (34, 3);
-- 169 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (34, 4);
-- 170 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (34, 5);

-- Ruby On Rails
-- 171 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (35, 1);
-- 172 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (35, 2);
-- 173 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (35, 3);
-- 174 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (35, 4);
-- 175 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (35, 5);

-- Maven
-- 176 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (36, 1);
-- 177 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (36, 2);
-- 178 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (36, 3);
-- 179 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (36, 4);
-- 180 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (36, 5);

-- Spring Boot
-- 181 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (37, 1);
-- 182 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (37, 2);
-- 183 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (37, 3);
-- 184 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (37, 4);
-- 185 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (37, 5);

-- Spring
-- 186 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (38, 1);
-- 187 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (38, 2);
-- 188 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (38, 3);
-- 189 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (38, 4);
-- 190 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (38, 5);

-- Pandas
-- 191 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (39, 1);
-- 192 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (39, 2);
-- 193 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (39, 3);
-- 194 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (39, 4);
-- 195 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (39, 5);

-- Numpy
-- 196 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (40, 1);
-- 197 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (40, 2);
-- 198 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (40, 3);
-- 199 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (40, 4);
-- 200 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (40, 5);

-- Tensorflow
-- 201 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (41, 1);
-- 202 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (41, 2);
-- 203 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (41, 3);
-- 204 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (41, 4);
-- 205 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (41, 5);

-- Keras
-- 206 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (42, 1);
-- 207 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (42, 2);
-- 208 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (42, 3);
-- 209 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (42, 4);
-- 210 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (42, 5);

-- Trello
-- 211 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (43, 1);
-- 212 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (43, 2);
-- 213 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (43, 3);
-- 214 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (43, 4);
-- 215 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (43, 5);

-- Jira
-- 216 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (44, 1);
-- 217 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (44, 2);
-- 218 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (44, 3);
-- 219 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (44, 4);
-- 220 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (44, 5);

-- Travis-CI
-- 221 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (45, 1);
-- 222 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (45, 2);
-- 223 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (45, 3);
-- 224 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (45, 4);
-- 225 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (45, 5);

-- Heroku
-- 226 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (46, 1);
-- 227 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (46, 2);
-- 228 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (46, 3);
-- 229 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (46, 4);
-- 230 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (46, 5);

-- SonarQube
-- 231 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (47, 1);
-- 232 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (47, 2);
-- 233 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (47, 3);
-- 234 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (47, 4);
-- 235 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (47, 5);

-- SonarCloud
-- 236 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (48, 1);
-- 237 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (48, 2);
-- 238 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (48, 3);
-- 239 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (48, 4);
-- 240 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (48, 5);

-- Git
-- 241 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (49, 1);
-- 242 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (49, 2);
-- 243 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (49, 3);
-- 244 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (49, 4);
-- 245 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (49, 5);

-- Amazon AWS
-- 246 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (50, 1);
-- 247 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (50, 2);
-- 248 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (50, 3);
-- 249 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (50, 4);
-- 250 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (50, 5);

-- MS Azure
-- 251 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (51, 1);
-- 252 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (51, 2);
-- 253 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (51, 3);
-- 254 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (51, 4);
-- 255 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (51, 5);

-------------------- KNOWLEDGE --------------------

-- Agile methodology
-- 256 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (52, 1);
-- 257 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (52, 2);
-- 258 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (52, 3);
-- 259 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (52, 4);
-- 260 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (52, 5);

-- SQL Databases
-- 261 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (53, 1);
-- 262 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (53, 2);
-- 263 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (53, 3);
-- 264 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (53, 4);
-- 265 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (53, 5);

-- Network communication
-- 266 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (54, 1);
-- 267 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (54, 2);
-- 268 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (54, 3);
-- 269 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (54, 4);
-- 270 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (54, 5);

-- NoSQL Databases
-- 271 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (55, 1);
-- 272 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (55, 2);
-- 273 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (55, 3);
-- 274 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (55, 4);
-- 275 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (55, 5);

-- Network management
-- 276 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (56, 1);
-- 277 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (56, 2);
-- 278 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (56, 3);
-- 279 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (56, 4);
-- 280 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (56, 5);

-- Troubleshooting skills
-- 281 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (57, 1);
-- 282 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (57, 2);
-- 283 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (57, 3);
-- 284 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (57, 4);
-- 285 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (57, 5);

-- Software virtualization
-- 286 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (58, 1);
-- 287 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (58, 2);
-- 288 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (58, 3);
-- 289 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (58, 4);
-- 290 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (58, 5);

-- Network protocols
-- 291 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (59, 1);
-- 292 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (59, 2);
-- 293 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (59, 3);
-- 294 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (59, 4);
-- 295 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (59, 5);

-- REST
-- 296 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (60, 1);
-- 297 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (60, 2);
-- 298 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (60, 3);
-- 299 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (60, 4);
-- 300 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (60, 5);

-- Web security
-- 301 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (61, 1);
-- 302 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (61, 2);
-- 303 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (61, 3);
-- 304 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (61, 4);
-- 305 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (61, 5);

-- Cloud technologies
-- 306 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (62, 1);
-- 307 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (62, 2);
-- 308 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (62, 3);
-- 309 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (62, 4);
-- 310 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (62, 5);

-- Testing metodologies
-- 311 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (63, 1);
-- 312 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (63, 2);
-- 313 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (63, 3);
-- 314 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (63, 4);
-- 315 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (63, 5);

-- Object oriented programming
-- 316 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (64, 1);
-- 317 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (64, 2);
-- 318 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (64, 3);
-- 319 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (64, 4);
-- 320 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (64, 5);

-- Functional programming
-- 321 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (65, 1);
-- 322 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (65, 2);
-- 323 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (65, 3);
-- 324 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (65, 4);
-- 325 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (65, 5);

-- Design patterns
-- 326 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (66, 1);
-- 327 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (66, 2);
-- 328 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (66, 3);
-- 329 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (66, 4);
-- 330 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (66, 5);

-- CS algorithms
-- 331 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (67, 1);
-- 332 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (67, 2);
-- 333 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (67, 3);
-- 334 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (67, 4);
-- 335 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (67, 5);

-- ES6 specification
-- 336 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (68, 1);
-- 337 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (68, 2);
-- 338 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (68, 3);
-- 339 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (68, 4);
-- 340 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (68, 5);

-- Neural networks
-- 341 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (69, 1);
-- 342 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (69, 2);
-- 343 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (69, 3);
-- 344 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (69, 4);
-- 345 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (69, 5);

-- Machine learning algorithms
-- 346 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (70, 1);
-- 347 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (70, 2);
-- 348 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (70, 3);
-- 349 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (70, 4);
-- 350 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (70, 5);

-- SCRUM
-- 351 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (71, 1);
-- 352 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (71, 2);
-- 353 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (71, 3);
-- 354 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (71, 4);
-- 355 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (71, 5);

-------------------- LANGUAGES --------------------

-- English
-- 356 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (72, 1);
-- 357 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (72, 2);
-- 358 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (72, 3);
-- 359 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (72, 4);
-- 360 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (72, 5);

-- German
-- 361 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (73, 1);
-- 362 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (73, 2);
-- 363 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (73, 3);
-- 364 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (73, 4);
-- 365 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (73, 5);

-- Dutch
-- 366 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (74, 1);
-- 367 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (74, 2);
-- 368 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (74, 3);
-- 369 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (74, 4);
-- 370 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (74, 5);

-- Spanish
-- 371 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (75, 1);
-- 372 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (75, 2);
-- 373 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (75, 3);
-- 374 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (75, 4);
-- 375 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (75, 5);

-- Italian
-- 376 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (76, 1);
-- 377 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (76, 2);
-- 378 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (76, 3);
-- 379 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (76, 4);
-- 380 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (76, 5);

-------------------- SOFT SKILLS --------------------

-- Communication
-- 381 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (77, 1);
-- 382 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (77, 2);
-- 383 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (77, 3);
-- 384 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (77, 4);
-- 385 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (77, 5);

-- Self motivation
-- 386 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (78, 1);
-- 387 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (78, 2);
-- 388 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (78, 3);
-- 389 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (78, 4);
-- 390 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (78, 5);

-- Leadership
-- 391 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (79, 1);
-- 392 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (79, 2);
-- 393 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (79, 3);
-- 394 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (79, 4);
-- 395 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (79, 5);

-- Responsibility
-- 396 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (80, 1);
-- 397 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (80, 2);
-- 398 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (80, 3);
-- 399 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (80, 4);
-- 400 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (80, 5);

-- Teamwork
-- 401 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (81, 1);
-- 402 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (81, 2);
-- 403 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (81, 3);
-- 404 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (81, 4);
-- 405 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (81, 5);

-- Problem solving
-- 406 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (82, 1);
-- 407 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (82, 2);
-- 408 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (82, 3);
-- 409 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (82, 4);
-- 410 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (82, 5);

-- Working under pressure
-- 411 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (83, 1);
-- 412 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (83, 2);
-- 413 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (83, 3);
-- 414 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (83, 4);
-- 415 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (83, 5);

-- Time management
-- 416 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (84, 1);
-- 417 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (84, 2);
-- 418 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (84, 3);
-- 419 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (84, 4);
-- 420 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (84, 5);

-- Flexibility
-- 421 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (85, 1);
-- 422 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (85, 2);
-- 423 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (85, 3);
-- 424 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (85, 4);
-- 425 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (85, 5);

-- Negotiation
-- 426 - BASIC
insert into cv_element_proficiencies (cv_element_id, proficiency) values (86, 1);
-- 427 - GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (86, 2);
-- 428 - VERY_GOOD
insert into cv_element_proficiencies (cv_element_id, proficiency) values (86, 3);
-- 429 - EXCELLENT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (86, 4);
-- 430 - EXPERT
insert into cv_element_proficiencies (cv_element_id, proficiency) values (86, 5);


------------------------------- INTERVIEW SUGGESTIONS -------------------------------


-------------------- PROGRAMMING LANGUAGES --------------------

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (51, 'Python', 'basic url', 'Python is an easy to learn programming language. This tutorial introduces the reader informally to the basic concepts and features of the Python language.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (52, 'Python', 'good url', 'Python was designed for readability, and has some similarities to the English language with influence from mathematics. This tutorial will help with syntax.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (53, 'Python', 'very good url', 'Python has a very high skill ceiling - you can now start digging into these tutorials that will teach you advanced Python concepts and patterns.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (54, 'Python', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (55, 'Python', 'expert url', 'In this section you’ll find Python tutorials that teach you advanced concepts so you can be on your way to become a master of Python.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (16, 'Java', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (17, 'Java', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (18, 'Java', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (19, 'Java', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (20, 'Java', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (101, 'SQL', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (102, 'SQL', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (103, 'SQL', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (104, 'SQL', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (105, 'SQL', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (21, 'JavaScript', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (22, 'JavaScript', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (23, 'JavaScript', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (24, 'JavaScript', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (25, 'JavaScript', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (11, 'C#', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (12, 'C#', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (13, 'C#', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (14, 'C#', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (15, 'C#', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

-------------------- TECHNOLOGIES --------------------

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (181, 'Spring Boot', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (182, 'Spring Boot', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (183, 'Spring Boot', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (184, 'Spring Boot', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (185, 'Spring Boot', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (186, 'Spring', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (187, 'Spring', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (188, 'Spring', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (189, 'Spring', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (190, 'Spring', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (156, 'JUnit', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (157, 'JUnit', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (158, 'JUnit', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (159, 'JUnit', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (160, 'JUnit', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (166, 'Selenium', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (167, 'Selenium', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (168, 'Selenium', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (169, 'Selenium', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (170, 'Selenium', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (161, 'Jasmine', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (162, 'Jasmine', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (163, 'Jasmine', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (164, 'Jasmine', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (165, 'Jasmine', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (121, 'Vue', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (122, 'Vue', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (123, 'Vue', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (124, 'Vue', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (125, 'Vue', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (116, 'Angular', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (117, 'Angular', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (118, 'Angular', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (119, 'Angular', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (120, 'Angular', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (176, 'Maven', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (177, 'Maven', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (178, 'Maven', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (179, 'Maven', 'excellent url', 'This tutorial will help you push your skills to the next level! You will learn some advanced concepts that will allow you to progress further.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (180, 'Maven', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

-------------------- KNOWLEDGE --------------------

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (316, 'Object oriented programming', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (317, 'Object oriented programming', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (318, 'Object oriented programming', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (319, 'Object oriented programming', 'excellent url', 'Excellent description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum mi non dolor congue congue. Donec vestibulum nisi lectus.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (320, 'Object oriented programming', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert

insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (326, 'Design patterns', 'basic url', 'This tutorial will help you start your journey on mastering this technology! It will cover the basics of this technology.'); -- basic
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (327, 'Design patterns', 'good url', 'This tutorial will cover some intermediate topics that will advance your knowledge. These skills are the groundwork of furhter improvement.'); -- good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (328, 'Design patterns', 'very good url', 'This tutorial will be an introductory to the advanced topics that will allow you to better understand the interworkings of this technology.'); -- very good
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (329, 'Design patterns', 'excellent url', 'Excellent description. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus rutrum mi non dolor congue congue. Donec vestibulum nisi lectus.'); -- excellent
insert into interview_suggestions (cv_element_proficiency_id, subject, url, description) values (330, 'Design patterns', 'expert url', 'This tutorial will help you master your skills! You will learn the most advanced concepts that will allow you to get that desired job.'); -- expert


----------------------- USER PROFICIENCIES -------------------------------


-- user with id 2 

-- programming languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 20); -- java - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 23); -- javascript - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 54); -- python - EXCELLENT

-- technologies
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 190); -- spring - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 185); -- spring boot - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 128); -- django - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 123); -- vue - VERY_GOOD

-- knowledge
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 300); -- REST - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 263); -- SQL Databases - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 338); -- ES6 - VERY_GOOD

-- languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 359); -- ENGLISH, EXCELLENT

-- soft skills
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 405); -- Team work, EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (2, 420); -- Time management, EXPERT

-- user with id 3 

-- programming languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 18); -- java - EXPERT -2
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 21); -- javascript - VERY_GOOD -2
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 52); -- python - EXCELLENT -2

-- technologies
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 187); -- spring - EXPERT -3
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 182); -- spring boot - EXPERT -3
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 126); -- django - VERY_GOOD -2
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 121); -- vue - VERY_GOOD -2

-- knowledge
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 300); -- REST - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 263); -- SQL Databases - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 338); -- ES6 - VERY_GOOD

-- languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 357); -- ENGLISH, EXCELLENT -2

-- soft skills
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 403); -- Team work, EXPERT -2
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (3, 419); -- Time management, EXPERT -1

-- user with id 4 

-- programming languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 25); -- javascript - expert
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 40); -- html - expert

-- technologies
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 125); -- vue - expert
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 150); -- angular - expert
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 120); -- react - expert

-- knowledge
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 300); -- REST - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 339); -- ES6 - expert

-- languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 357); -- ENGLISH, EXCELLENT

-- soft skills
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 404); -- Team work, EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (4, 418); -- Time management, EXPERT

-- user with id 5 

-- programming languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 20); -- java - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 54); -- python - EXCELLENT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 35); -- php - EXPERT

-- technologies
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 190); -- spring - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 185); -- spring boot - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 128); -- django - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 115); -- laravel - expert

-- knowledge
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 298); -- REST - EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 261); -- SQL Databases - VERY_GOOD
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 336); -- ES6 - VERY_GOOD

-- languages
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 357); -- ENGLISH, EXCELLENT

-- soft skills
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 401); -- Team work, EXPERT
insert into users_proficiencies (job_seeker_id, proficiencies_id) values (5, 417); -- Time management, EXPERT

----------------------- USER WORKING EXPERIENCES -------------------------------


-- user with id 2 - 'Job Seeker'
-- id = 1
insert into working_experiences (months, seniority, position_id, user_id) values (20, 1, 1, 2); -- Backend Junior Dev 20 months, Java
-- prog lang - java
insert into working_experiences_cv_elements (working_experience_id, cv_elements_id) values (1, 4);
-- technology - spring boot
insert into working_experiences_cv_elements (working_experience_id, cv_elements_id) values (1, 37);
-- knowledge - REST
insert into working_experiences_cv_elements (working_experience_id, cv_elements_id) values (1, 60);


------------------------------- COMPANIES -------------------------------
-- 1 - LEVI9
insert into companies (name, medal) values ('Levi9', 0);
-- 2 - CONTINENTAL
insert into companies (name, medal) values ('Continental', 0);
-- 3 - VEGAIT
insert into companies (name, medal) values ('VegaIT', 0);
-- 4 - VIVIFY
insert into companies (name, medal) values ('Vivify', 0);
-- 5 - MARBLEIT
insert into companies (name, medal) values ('MarbleIT', 0);
-- 6 - NORDEUS
insert into companies (name, medal) values ('Nordeus', 0);
-- 7 - SYNECHRON
insert into companies (name, medal) values ('Synechron', 0);
-- 8 - RT-RK
insert into companies (name, medal) values ('RT-RK', 0);
-- 9 - UBISOFT
insert into companies (name, medal) values ('Ubisoft', 0);
-- 10 - 3LATERAL
insert into companies (name, medal) values ('3Lateral', 0);
-- 11 - QUANTOX TECHNOLOGY
insert into companies (name, medal) values ('Quantox Technology', 0);
-- 12 - EXECOM
insert into companies (name, medal) values ('Execom', 0);
-- 13 - MICROSOFT DEVELOPMENT CENTER SERBIA
insert into companies (name, medal) values ('Microsoft Serbia', 0);

------------------------------- COMPANY  -------------------------------------
-- LEVI9
-- flexible hours
insert into companies_benefits (company_id, benefits_id) values (1, 1);
-- remote work
insert into companies_benefits (company_id, benefits_id) values (1, 2);
-- home office allowance
insert into companies_benefits (company_id, benefits_id) values (1, 3);
-- private health insurance
insert into companies_benefits (company_id, benefits_id) values (1, 4);
-- modern technologies
insert into companies_benefits (company_id, benefits_id) values (1, 6);
-- proffesional growth
insert into companies_benefits (company_id, benefits_id) values (1, 9);
-- pleasant working atmosphere
insert into companies_benefits (company_id, benefits_id) values (1, 10);
-- paid sick leave
insert into companies_benefits (company_id, benefits_id) values (1, 11);
-- paid vacation
insert into companies_benefits (company_id, benefits_id) values (1, 12);
-- foreign languages courses
insert into companies_benefits (company_id, benefits_id) values (1, 18);

-- SYNECHRON
-- flexible hours
insert into companies_benefits (company_id, benefits_id) values (7, 1);
-- remote work
insert into companies_benefits (company_id, benefits_id) values (7, 2);
-- competitive salary
insert into companies_benefits (company_id, benefits_id) values (7, 5);
-- modern technologies
insert into companies_benefits (company_id, benefits_id) values (7, 6);
-- attractive projects
insert into companies_benefits (company_id, benefits_id) values (7, 7);
-- paid sick leave
insert into companies_benefits (company_id, benefits_id) values (7, 11);
-- paid vacation
insert into companies_benefits (company_id, benefits_id) values (7, 12);
-- private health insurance
insert into companies_benefits (company_id, benefits_id) values (7, 4);


------------------------------- IMPORTANCES -------------------------------
-- 1 - SQL DATABASES, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (263, 7, false);
-- 2 - REST, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (299, 10, false);
-- 3 - OBJECT ORIENTED PROGRAMMING, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (319, 10, false);
-- 4 - DESIGN PATTERNS, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (328, 8, false);
-- 5 - JAVA, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (19, 10, false);
-- 6 - MAVEN, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (178, 8, false);
-- 7 - SPRING BOOT, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (184, 10, false);
-- 8 - SPRING, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (189, 9, false);
-- 9 - ENGLISH, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (358, 10, false);
-- 10 - TEAMWORK, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (404, 10, false);
-- 11 - TIME MANAGEMENT, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (418, 10, false);
-- 12 - ES6 SPECIFICATION, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (339, 9, false);
-- 13 - SQL DATABASES, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (264, 9, false);
-- 14 - REST, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (300, 10, false);
-- 15 - DESIGN PATTERNS, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (330, 8, false);
-- 16 - ES6 SPECIFICATION, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (340, 9, false);
-- 17 - OBJECT ORIENTED PROGRAMMING, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (320, 9, false);
-- 18 - JAVASCRIPT, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (25, 10, false);
-- 19 - JAVA, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (20, 10, false);
-- 20 - SPRING BOOT, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (185, 10, false);
-- 21 - SPRING, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (190, 7, false);
-- 22 - REACT, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (150, 9, false);
-- 23 - TEAMWORK, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (405, 10, false);
-- 24 - TIME MANAGEMENT, EXPERT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (420, 10, false);
-- 25 - TESTING METODOLOGIES, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (311, 10, false);
-- 26 - OBJECT ORIENTED PROGRAMMING, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (316, 8, false);
-- 27 - JAVA, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (16, 9, false);
-- 28 - JAVASCRIPT, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (21, 9, false);
-- 29 - JUNIT, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (156, 10, false);
-- 30 - JASMINE, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (161, 9, false);
-- 31 - SELENIUM, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (166, 10, false);
-- 32 - ANGULAR, BASIC
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (116, 9, false);
-- 33 - NOSQL DATABASES, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (274, 10, false);
-- 34 - SQL, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (104, 10, false);
-- 35 - AMAZON AWS, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (249, 10, false);
-- 36 - NEURAL NETWORKS, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (343, 9, false);
-- 37 - MACHINE LEARNING ALGORITHMS, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (348, 10, false);
-- 38 - PYTHON, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (54, 10, false);
-- 39 - R, VERY GOOD
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (93, 7, false);
-- 40 - PANDAS, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (194, 10, false);
-- 41 - NUMPY, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (199, 10, false);
-- 42 - TENSORFLOW, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (204, 8, false);
-- 43 - KERAS, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (209, 9, false);
-- 44 - SELF MOTIVATION, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (389, 10, false);
-- 45 - PHP, EXCELLENT
insert into cv_element_importances (cv_element_proficiency_id, importance_level, optional) values (34, 10, false);

------------------------------- JOB OFFERS --------------------------------

-- 1 - LEVI9 - BACKEND - MEDIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (1, 1, 2, 0, '2021-08-22 16:00:00.508-07', 'In Levi9 we know our business and the business of our customers. We have over one thousand proffesional and talented employees.');
-------------------- KNOWLEDGE --------------------
-- SQL DATABASES, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 1);
-- REST, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 2);
-- OBJECT ORIENTED PROGRAMMING, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 3);
-- DESIGN PATTERNS, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 4);
-------------------- PROGRAMMING --------------------
-- JAVA, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 5);
-------------------- TECHNOLOGY --------------------
-- MAVEN, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 6);
-- SPRING BOOT, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 7);
-- SPRING, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 8);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 9);
-------------------- SOFT SKILLS --------------------
-- TEAMWORK, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 10);
-- TIME MANAGEMENT, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (1, 11);

-------------------------------------------------------------------------------------------------------

-- 2 - LEVI9 - FRONTEND - MEDIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (1, 2, 2, 0, '2021-08-22 16:00:00.508-07', 'In Levi9 we know our business and the business of our customers. We have over one thousand proffesional and talented employees.');
-------------------- KNOWLEDGE --------------------
-- ES6 SPECIFICATION, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 12);
-- REST, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 2);
-- DESIGN PATTERNS, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 4);
-------------------- PROGRAMMING --------------------
-- JAVASCRIPT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 18);
-------------------- TECHNOLOGY --------------------
-- REACT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 22);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 9);
-------------------- SOFT SKILLS --------------------
-- TEAMWORK, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 10);
-- TIME MANAGEMENT, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (2, 11);

-------------------------------------------------------------------------------------------------------

-- 3 - LEVI 9 - FULLSTACK - SENIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (1, 3, 3, 0, '2021-08-22 16:00:00.508-07', 'In Levi9 we know our business and the business of our customers. We have over one thousand proffesional and talented employees.');
-------------------- KNOWLEDGE --------------------
-- SQL DATABASES, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 13);
-- REST, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 14);
-- DESIGN PATTERNS, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 15);
-- ES6 SPECIFICATION, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 16);
-- OBJECT ORIENTED PROGRAMMING, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 17);
-------------------- PROGRAMMING --------------------
-- JAVA, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 19);
-- JAVASCRIPT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 18);
-------------------- TECHNOLOGY --------------------
-- SPRING BOOT, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 7);
-- SPRING, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 8);
-- REACT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 22);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 9);
-------------------- SOFT SKILLS --------------------
-- TEAMWORK, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 23);
-- TIME MANAGEMENT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (3, 24);

-------------------------------------------------------------------------------------------------------

-- 4 - LEVI9 - TESTER - JUNIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (1, 22, 1, 0, '2021-08-22 16:00:00.508-07', 'In Levi9 we know our business and the business of our customers. We have over one thousand proffesional and talented employees.');
-------------------- KNOWLEDGE --------------------
-- TESTING METODOLOGIES, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 25);
-- OBJECT ORIENTED PROGRAMMING, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 26);
-------------------- PROGRAMMING --------------------
-- JAVA, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 27);
-- JAVASCRIPT, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 28);
-------------------- TECHNOLOGY --------------------
-- JUNIT, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 29);
-- JASMINE, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 30);
-- SELENIUM, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 31);
-- ANGULAR, BASIC
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 32);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 9);
-------------------- SOFT SKILLS --------------------
-- TEAM WORK, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 23);
-- TIME MANAGEMENT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (4, 24);

-------------------------------------------------------------------------------------------------------

-- 5 - CONTINENTAL - DATABASE ADMINISTRATOR - MEDIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (2, 10, 2, 0, '2021-08-22 16:00:00.508-07', 'Continental develops pioneering technologies and services for sustainable and connected mobility of people and their goods.');
-------------------- KNOWLEDGE --------------------
-- SQL DATABASES, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 13);
-- NOSQL DATABASES, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 33);
-------------------- PROGRAMMING --------------------
-- SQL, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 34);
-------------------- TECHNOLOGY --------------------
-- AMAZON AWS, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 35);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 9);
-------------------- SOFT SKILLS --------------------
-- TEAM WORK, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 23);
-- TIME MANAGEMENT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (5, 24);

-------------------------------------------------------------------------------------------------------

-- 6 - VEGA IT - ARTIFICIAL INTELLIGENCE SPECIALIST - MEDIOR - NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (6, 11, 2, 0, '2021-08-22 16:00:00.508-07', 'We have twelve years of experience in the industry. We always measure the quality of our service through customer happiness.');
-------------------- KNOWLEDGE --------------------
-- NEURAL NETWORKS, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 36);
-- MACHINE LEARNING ALGORITHMS, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 37);
-------------------- PROGRAMMING --------------------
-- PYTHON, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 38);
-- R, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 39);
-------------------- TECHNOLOGY --------------------
-- PANDAS, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 40);
-- NUMPY EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 41);
-- TENSORFLOW, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 42);
-- KERAS, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 43);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 9);
-------------------- SOFT SKILLS --------------------
-- TEAM WORK, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 23);
-- TIME MANAGEMENT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (6, 24);

-------------------------------------------------------------------------------------------------------

-- 7 - SYNECHRON - BACKEND, MEDIOR, NONE
insert into job_offers (company_id, position_id, seniority, medal, date_posted, description) values (7, 1, 2, 0, '2021-08-22 16:00:00.508-07', 'In Synechron we combine innovative ideas with deep business knowledge and global technology teams to deliver business solutions.');
-------------------- KNOWLEDGE --------------------
-- SQL DATABASES, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 1);
-- REST, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 2);
-- OBJECT ORIENTED PROGRAMMING, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 17);
-- DESIGN PATTERNS, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 4);
-------------------- PROGRAMMING --------------------
-- JAVA, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 5);
-- PHP, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 45);
-------------------- TECHNOLOGY --------------------
-- MAVEN, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 6);
-- SPRING BOOT, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 7);
-- SPRING, EXCELLENT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 8);
-------------------- LANGUAGE --------------------
-- ENGLISH, VERY GOOD
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 9);
-------------------- SOFT SKILLS --------------------
-- TEAM WORK, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 23);
-- TIME MANAGEMENT, EXPERT
insert into job_offers_cv_element_importances (job_offer_id, cv_element_importances_id) values (7, 24);

------------------------------------------------------------------------------------------------------

-- -- REVIEWS

-- -- Levi 9 - BACKEND, MEDIOR, 'Job Seeker' user review - 1
-- -- insert into job_offer_reviews ( poster_id, job_offer_id, company_id, rating, 
-- -- 								content, date, hired, job_offered, interview_complexity, 
-- -- 								rated_useful, rated_not_useful, recommends, salary)
-- -- 						values (2, 1, 1, 5, 
-- -- 								'This is review 1 content', '2021-03-07 16:00:00.508-07', true, true, 2, 
-- -- 								10, 2, true, 1000);

-- -- -- Levi 9 - BACKEND, MEDIOR, 'Job Seeker' user review - 2
-- -- insert into job_offer_reviews ( id, poster_id, job_offer_id, company_id, rating, 
-- -- 								content, date, hired, interview_complexity, job_offered, 
-- -- 								rated_useful, rated_not_useful, recommends, salary)
-- -- 						values (2, 2, 1, 1, 5, 
-- -- 								'This is review 2 content', '2021-03-07 16:00:00.508-07', true, 2, true, 
-- -- 								10, 2, true, 1000);