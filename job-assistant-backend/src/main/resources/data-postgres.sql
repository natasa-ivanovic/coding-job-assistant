insert into authorities (name) values ('ROLE_ADMIN');
insert into authorities (name) values ('ROLE_USER');

-- password == name
-- admins
insert into users (id, name, surname, username, password, enabled, last_password_reset_date, role) values (1, 'admin1', 'admin1', 'admin1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'ADMIN');

insert into user_authority (user_id, authority_id) values (1, 1);

-- jobseekers
-- password - admin1
insert into users (id, name, surname, username, password, enabled, last_password_reset_date, role, remote_work, salary_expectation, education) values (2, 'Job', 'Seeker', 'user1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'USER', true, 1000, 2);

insert into user_authority (user_id, authority_id) values (2, 2);


-- programming languages
insert into prog_languages (id, name) values (1, 'C');
insert into prog_languages (id, name) values (2, 'C++');
insert into prog_languages (id, name) values (3, 'C#');
insert into prog_languages (id, name) values (4, 'Java');
insert into prog_languages (id, name) values (5, 'JavaScript');
insert into prog_languages (id, name) values (6, 'Ruby');
insert into prog_languages (id, name) values (7, 'PHP');
insert into prog_languages (id, name) values (8, 'HTML');
insert into prog_languages (id, name) values (9, 'CSS');
insert into prog_languages (id, name) values (10, 'Kotlin');
insert into prog_languages (id, name) values (11, 'Python');
insert into prog_languages (id, name) values (12, 'Go');
insert into prog_languages (id, name) values (13, 'Pharo');
insert into prog_languages (id, name) values (14, 'GML');
insert into prog_languages (id, name) values (15, 'Lua');
insert into prog_languages (id, name) values (16, 'Swift');
insert into prog_languages (id, name) values (17, 'Dart');
insert into prog_languages (id, name) values (18, 'Matlab');
insert into prog_languages (id, name) values (19, 'R');
insert into prog_languages (id, name) values (20, 'Bash');

-- technologies
insert into technologies (id, name) values (1, 'NodeJS');
insert into technologies (id, name) values (2, 'Laravel');
insert into technologies (id, name) values (3, 'Angular');
insert into technologies (id, name) values (4, 'Vue');
insert into technologies (id, name) values (5, 'Django');
insert into technologies (id, name) values (6, 'Unity');
insert into technologies (id, name) values (7, 'GM Studio');
insert into technologies (id, name) values (8, 'LWJGL');
insert into technologies (id, name) values (9, 'React');
insert into technologies (id, name) values (10, 'Flutter');
insert into technologies (id, name) values (11, 'JUnit');
insert into technologies (id, name) values (12, 'Jasmine');
insert into technologies (id, name) values (13, 'Selenium');
insert into technologies (id, name) values (14, 'Ruby On Rails');
insert into technologies (id, name) values (15, 'Maven');
insert into technologies (id, name) values (16, 'Spring Boot');
insert into technologies (id, name) values (17, 'Spring');
insert into technologies (id, name) values (18, 'Pandas');
insert into technologies (id, name) values (19, 'Numpy');
insert into technologies (id, name) values (20, 'Tensorflow');
insert into technologies (id, name) values (21, 'Keras');
insert into technologies (id, name) values (22, 'Trello');
insert into technologies (id, name) values (23, 'Jira');
insert into technologies (id, name) values (24, 'Travis-CI');
insert into technologies (id, name) values (25, 'Heroku');
insert into technologies (id, name) values (26, 'SonarQube');
insert into technologies (id, name) values (27, 'SonarCloud');
insert into technologies (id, name) values (28, 'Git');
insert into technologies (id, name) values (29, 'Amazon AWS');
insert into technologies (id, name) values (30, 'MS Azure');

-- knowledge
insert into knowledge (id, name) values (1, 'Agile methodology');
insert into knowledge (id, name) values (2, 'SQL Databases');
insert into knowledge (id, name) values (3, 'Network communication');
insert into knowledge (id, name) values (4, 'NoSQL Databases');
insert into knowledge (id, name) values (5, 'Network management');
insert into knowledge (id, name) values (6, 'Troubleshooting skills');
insert into knowledge (id, name) values (7, 'Software virtualization');
insert into knowledge (id, name) values (8, 'Network protocols');
insert into knowledge (id, name) values (9, 'REST');
insert into knowledge (id, name) values (10, 'Web security');
insert into knowledge (id, name) values (11, 'Cloud technologies');
insert into knowledge (id, name) values (12, 'Testing metodologies');
insert into knowledge (id, name) values (13, 'Object oriented programming');
insert into knowledge (id, name) values (14, 'Functional programming');
insert into knowledge (id, name) values (15, 'Design patterns');
insert into knowledge (id, name) values (16, 'CS algorithms');
insert into knowledge (id, name) values (17, 'ES6 specification');
insert into knowledge (id, name) values (18, 'Neural networks');
insert into knowledge (id, name) values (19, 'Machine learning algorithms');
insert into knowledge (id, name) values (20, 'SCRUM');

-- soft skills
insert into soft_skills (id, name) values (1, 'Communication');
insert into soft_skills (id, name) values (2, 'Self motivation');
insert into soft_skills (id, name) values (3, 'Leadership');
insert into soft_skills (id, name) values (4, 'Responsibility');
insert into soft_skills (id, name) values (5, 'Teamwork');
insert into soft_skills (id, name) values (6, 'Problem solving');
insert into soft_skills (id, name) values (7, 'Working under pressure');
insert into soft_skills (id, name) values (8, 'Time management');
insert into soft_skills (id, name) values (9, 'Flexibility');
insert into soft_skills (id, name) values (10, 'Negotiation');

-- languages
insert into languages (id, name) values (1, 'English');
insert into languages (id, name) values (2, 'German');
insert into languages (id, name) values (3, 'Dutch');
insert into languages (id, name) values (4, 'Spanish');
insert into languages (id, name) values (5, 'Italian');

-- job positions
insert into job_positions (id, title) values (1, 'Backend Developer');
insert into job_positions (id, title) values (2, 'Frontend Developer');
insert into job_positions (id, title) values (3, 'FullStack Developer');
insert into job_positions (id, title) values (4, 'Data Scientist');
insert into job_positions (id, title) values (5, 'Game Developer');
insert into job_positions (id, title) values (6, 'Mobile Application Developer');
insert into job_positions (id, title) values (7, 'Computer System Analyst');
insert into job_positions (id, title) values (8, 'Computer System Engineer');
insert into job_positions (id, title) values (9, 'Network System Administrator');
insert into job_positions (id, title) values (10, 'Database Administrator');
insert into job_positions (id, title) values (11, 'Artificial Intelligence Specialist');
insert into job_positions (id, title) values (12, 'Bioinformatics Software Engineer');
insert into job_positions (id, title) values (13, 'Computer Forensics Investigator');
insert into job_positions (id, title) values (14, 'Cybersecurity Strategist');
insert into job_positions (id, title) values (15, 'Data Architect');
insert into job_positions (id, title) values (16, 'Electronics Engineer');
insert into job_positions (id, title) values (17, 'Game Tester');
insert into job_positions (id, title) values (18, 'Lead Software Engineer');
insert into job_positions (id, title) values (19, 'Security Administrator');
insert into job_positions (id, title) values (20, 'SEO Analyst');
insert into job_positions (id, title) values (21, 'Software Architect');
insert into job_positions (id, title) values (22, 'Software Tester');
insert into job_positions (id, title) values (23, 'Statistical Programmer');
insert into job_positions (id, title) values (24, 'Telecommunications Engineer');
insert into job_positions (id, title) values (25, 'Telecommunications Specialist');

-- backend
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 4);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 5);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 6);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 11);

-- frontend
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 5);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 7);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 8);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 9);

-- backend
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 1);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 2);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 5);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 14);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 15);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 16);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 17);

-- frontend
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 1);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 2);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 3);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 4);

-- backend
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 2);
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 9);

-- frontend
insert into job_positions_knowledge (job_position_id, knowledge_id) values (2, 9);
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 17);

-- programming proficiencies --

-- programming language - C
insert into programming_proficiencies (id, programming_language_id, proficiency) values (1, 1, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (2, 1, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (3, 1, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (4, 1, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (5, 1, 4); -- EXPERT
-- programming language - C++
insert into programming_proficiencies (id, programming_language_id, proficiency) values (6, 2, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (7, 2, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (8, 2, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (9, 2, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (10, 2, 4); -- EXPERT
-- programming language - C#
insert into programming_proficiencies (id, programming_language_id, proficiency) values (11, 3, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (12, 3, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (13, 3, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (14, 3, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (15, 3, 4); -- EXPERT
-- programming language - Java
insert into programming_proficiencies (id, programming_language_id, proficiency) values (16, 4, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (17, 4, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (18, 4, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (19, 4, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (20, 4, 4); -- EXPERT
-- programming language - JavaScript
insert into programming_proficiencies (id, programming_language_id, proficiency) values (21, 5, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (22, 5, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (23, 5, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (24, 5, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (25, 5, 4); -- EXPERT
-- programming language - Ruby
insert into programming_proficiencies (id, programming_language_id, proficiency) values (26, 6, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (27, 6, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (28, 6, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (29, 6, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (30, 6, 4); -- EXPERT
-- programming language - PHP
insert into programming_proficiencies (id, programming_language_id, proficiency) values (31, 7, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (32, 7, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (33, 7, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (34, 7, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (35, 7, 4); -- EXPERT
-- programming language - HTML
insert into programming_proficiencies (id, programming_language_id, proficiency) values (36, 8, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (37, 8, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (38, 8, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (39, 8, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (40, 8, 4); -- EXPERT
-- programming language - CSS
insert into programming_proficiencies (id, programming_language_id, proficiency) values (41, 9, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (42, 9, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (43, 9, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (44, 9, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (45, 9, 4); -- EXPERT
-- programming language - Kotlin
insert into programming_proficiencies (id, programming_language_id, proficiency) values (46, 10, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (47, 10, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (48, 10, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (49, 10, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (50, 10, 4); -- EXPERT
-- programming language - Python
insert into programming_proficiencies (id, programming_language_id, proficiency) values (51, 11, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (52, 11, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (53, 11, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (54, 11, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (55, 11, 4); -- EXPERT
-- programming language - Go
insert into programming_proficiencies (id, programming_language_id, proficiency) values (56, 12, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (57, 12, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (58, 12, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (59, 12, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (60, 12, 4); -- EXPERT
-- programming language - Pharo
insert into programming_proficiencies (id, programming_language_id, proficiency) values (61, 13, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (62, 13, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (63, 13, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (64, 13, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (65, 13, 4); -- EXPERT
-- programming language - GML
insert into programming_proficiencies (id, programming_language_id, proficiency) values (66, 14, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (67, 14, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (68, 14, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (69, 14, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (70, 14, 4); -- EXPERT
-- programming language - Lua
insert into programming_proficiencies (id, programming_language_id, proficiency) values (71, 15, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (72, 15, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (73, 15, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (74, 15, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (75, 15, 4); -- EXPERT
-- programming language - Swift
insert into programming_proficiencies (id, programming_language_id, proficiency) values (76, 16, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (77, 16, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (78, 16, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (79, 16, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (80, 16, 4); -- EXPERT
-- programming language - Dart
insert into programming_proficiencies (id, programming_language_id, proficiency) values (81, 17, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (82, 17, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (83, 17, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (84, 17, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (85, 17, 4); -- EXPERT
-- programming language - Matlab
insert into programming_proficiencies (id, programming_language_id, proficiency) values (86, 18, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (87, 18, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (88, 18, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (89, 18, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (90, 18, 4); -- EXPERT
-- programming language - R
insert into programming_proficiencies (id, programming_language_id, proficiency) values (91, 19, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (92, 19, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (93, 19, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (94, 19, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (95, 19, 4); -- EXPERT
-- programming language - Bash
insert into programming_proficiencies (id, programming_language_id, proficiency) values (96, 20, 0); -- BASIC
insert into programming_proficiencies (id, programming_language_id, proficiency) values (97, 20, 1); -- GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (98, 20, 2); -- VERY_GOOD
insert into programming_proficiencies (id, programming_language_id, proficiency) values (99, 20, 3); -- EXCELLENT
insert into programming_proficiencies (id, programming_language_id, proficiency) values (100, 20, 4); -- EXPERT

-- technology proficiencies

-- technology - NodeJS
insert into technology_proficiencies (id, technology_id, proficiency) values (1, 1, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (2, 1, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (3, 1, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (4, 1, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (5, 1, 4); -- EXPERT
-- technology - Laravel
insert into technology_proficiencies (id, technology_id, proficiency) values (6, 2, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (7, 2, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (8, 2, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (9, 2, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (10, 2, 4); -- EXPERT
-- technology - Angular
insert into technology_proficiencies (id, technology_id, proficiency) values (11, 3, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (12, 3, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (13, 3, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (14, 3, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (15, 3, 4); -- EXPERT
-- technology - Vue
insert into technology_proficiencies (id, technology_id, proficiency) values (16, 4, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (17, 4, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (18, 4, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (19, 4, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (20, 4, 4); -- EXPERT
-- technology - Django
insert into technology_proficiencies (id, technology_id, proficiency) values (21, 5, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (22, 5, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (23, 5, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (24, 5, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (25, 5, 4); -- EXPERT
-- technology - Unity
insert into technology_proficiencies (id, technology_id, proficiency) values (26, 6, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (27, 6, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (28, 6, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (29, 6, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (30, 6, 4); -- EXPERT
-- technology - GM Studio
insert into technology_proficiencies (id, technology_id, proficiency) values (31, 7, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (32, 7, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (33, 7, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (34, 7, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (35, 7, 4); -- EXPERT
-- technology - LWJGL
insert into technology_proficiencies (id, technology_id, proficiency) values (36, 8, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (37, 8, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (38, 8, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (39, 8, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (40, 8, 4); -- EXPERT
-- technology - React
insert into technology_proficiencies (id, technology_id, proficiency) values (41, 9, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (42, 9, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (43, 9, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (44, 9, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (45, 9, 4); -- EXPERT
-- technology - Flutter
insert into technology_proficiencies (id, technology_id, proficiency) values (46, 10, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (47, 10, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (48, 10, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (49, 10, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (50, 10, 4); -- EXPERT
-- technology - JUnit
insert into technology_proficiencies (id, technology_id, proficiency) values (51, 11, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (52, 11, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (53, 11, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (54, 11, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (55, 11, 4); -- EXPERT
-- technology - Jasmine
insert into technology_proficiencies (id, technology_id, proficiency) values (56, 12, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (57, 12, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (58, 12, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (59, 12, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (60, 12, 4); -- EXPERT
-- technology - Selenium
insert into technology_proficiencies (id, technology_id, proficiency) values (61, 13, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (62, 13, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (63, 13, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (64, 13, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (65, 13, 4); -- EXPERT
-- technology - Ruby On Rails
insert into technology_proficiencies (id, technology_id, proficiency) values (66, 14, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (67, 14, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (68, 14, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (69, 14, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (70, 14, 4); -- EXPERT
-- technology - Maven
insert into technology_proficiencies (id, technology_id, proficiency) values (71, 15, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (72, 15, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (73, 15, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (74, 15, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (75, 15, 4); -- EXPERT
-- technology - Spring Boot
insert into technology_proficiencies (id, technology_id, proficiency) values (76, 16, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (77, 16, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (78, 16, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (79, 16, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (80, 16, 4); -- EXPERT
-- technology - Spring
insert into technology_proficiencies (id, technology_id, proficiency) values (81, 17, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (82, 17, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (83, 17, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (84, 17, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (85, 17, 4); -- EXPERT
-- technology - Pandas
insert into technology_proficiencies (id, technology_id, proficiency) values (86, 18, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (87, 18, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (88, 18, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (89, 18, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (90, 18, 4); -- EXPERT
-- technology - Numpy
insert into technology_proficiencies (id, technology_id, proficiency) values (91, 19, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (92, 19, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (93, 19, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (94, 19, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (95, 19, 4); -- EXPERT
-- technology - Tensorflow
insert into technology_proficiencies (id, technology_id, proficiency) values (96, 20, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (97, 20, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (98, 20, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (99, 20, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (100, 20, 4); -- EXPERT
-- technology - Keras
insert into technology_proficiencies (id, technology_id, proficiency) values (101, 21, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (102, 21, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (103, 21, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (104, 21, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (105, 21, 4); -- EXPERT
-- technology - Trello
insert into technology_proficiencies (id, technology_id, proficiency) values (106, 22, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (107, 22, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (108, 22, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (109, 22, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (110, 22, 4); -- EXPERT
-- technology - Jira
insert into technology_proficiencies (id, technology_id, proficiency) values (111, 23, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (112, 23, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (113, 23, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (114, 23, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (115, 23, 4); -- EXPERT
-- technology - Travis-CI
insert into technology_proficiencies (id, technology_id, proficiency) values (116, 24, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (117, 24, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (118, 24, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (119, 24, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (120, 24, 4); -- EXPERT
-- technology - Heroku
insert into technology_proficiencies (id, technology_id, proficiency) values (121, 25, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (122, 25, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (123, 25, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (124, 25, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (125, 25, 4); -- EXPERT
-- technology - SonarQube
insert into technology_proficiencies (id, technology_id, proficiency) values (126, 26, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (127, 26, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (128, 26, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (129, 26, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (130, 26, 4); -- EXPERT
-- technology - SonarCloud
insert into technology_proficiencies (id, technology_id, proficiency) values (131, 27, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (132, 27, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (133, 27, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (134, 27, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (135, 27, 4); -- EXPERT
-- technology - Git
insert into technology_proficiencies (id, technology_id, proficiency) values (136, 28, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (137, 28, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (138, 28, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (139, 28, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (140, 28, 4); -- EXPERT
-- technology - Amazon AWS
insert into technology_proficiencies (id, technology_id, proficiency) values (141, 29, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (142, 29, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (143, 29, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (144, 29, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (145, 29, 4); -- EXPERT
-- technology - MS Azure
insert into technology_proficiencies (id, technology_id, proficiency) values (146, 30, 0); -- BASIC
insert into technology_proficiencies (id, technology_id, proficiency) values (147, 30, 1); -- GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (148, 30, 2); -- VERY_GOOD
insert into technology_proficiencies (id, technology_id, proficiency) values (149, 30, 3); -- EXCELLENT
insert into technology_proficiencies (id, technology_id, proficiency) values (150, 30, 4); -- EXPERT

-- knowledge proficiency

-- knowledge - Agile methodology
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (1, 1, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (2, 1, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (3, 1, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (4, 1, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (5, 1, 4); -- EXPERT
-- knowledge - SQL Databases
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (6, 2, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (7, 2, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (8, 2, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (9, 2, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (10, 2, 4); -- EXPERT
-- knowledge - Network communication
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (11, 3, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (12, 3, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (13, 3, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (14, 3, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (15, 3, 4); -- EXPERT
-- knowledge - NoSQL Databases
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (16, 4, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (17, 4, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (18, 4, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (19, 4, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (20, 4, 4); -- EXPERT
-- knowledge - Network management
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (21, 5, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (22, 5, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (23, 5, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (24, 5, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (25, 5, 4); -- EXPERT
-- knowledge - Troubleshooting skills
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (26, 6, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (27, 6, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (28, 6, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (29, 6, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (30, 6, 4); -- EXPERT
-- knowledge - Software virtualization
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (31, 7, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (32, 7, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (33, 7, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (34, 7, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (35, 7, 4); -- EXPERT
-- knowledge - Network protocols
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (36, 8, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (37, 8, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (38, 8, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (39, 8, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (40, 8, 4); -- EXPERT
-- knowledge - REST
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (41, 9, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (42, 9, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (43, 9, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (44, 9, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (45, 9, 4); -- EXPERT
-- knowledge - Web security
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (46, 10, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (47, 10, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (48, 10, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (49, 10, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (50, 10, 4); -- EXPERT
-- knowledge - Cloud technologies
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (51, 11, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (52, 11, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (53, 11, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (54, 11, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (55, 11, 4); -- EXPERT
-- knowledge - Testing metodologies
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (56, 12, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (57, 12, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (58, 12, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (59, 12, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (60, 12, 4); -- EXPERT
-- knowledge - Object oriented programming
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (61, 13, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (62, 13, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (63, 13, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (64, 13, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (65, 13, 4); -- EXPERT
-- knowledge - Functional programming
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (66, 14, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (67, 14, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (68, 14, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (69, 14, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (70, 14, 4); -- EXPERT
-- knowledge - Design patterns
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (71, 15, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (72, 15, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (73, 15, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (74, 15, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (75, 15, 4); -- EXPERT
-- knowledge - CS algorithms
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (76, 16, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (77, 16, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (78, 16, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (79, 16, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (80, 16, 4); -- EXPERT
-- knowledge - ES6 specification
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (81, 17, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (82, 17, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (83, 17, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (84, 17, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (85, 17, 4); -- EXPERT
-- knowledge - Neural networks
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (86, 18, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (87, 18, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (88, 18, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (89, 18, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (90, 18, 4); -- EXPERT
-- knowledge - Machine learning algorithms
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (91, 19, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (92, 19, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (93, 19, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (94, 19, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (95, 19, 4); -- EXPERT
-- knowledge - SCRUM
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (96, 20, 0); -- BASIC
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (97, 20, 1); -- GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (98, 20, 2); -- VERY_GOOD
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (99, 20, 3); -- EXCELLENT
insert into knowledge_proficiencies (id, knowledge_id, proficiency) values (100, 20, 4); -- EXPERT

-- soft skill proficiency

-- soft skill - Communication
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (1, 1, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (2, 1, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (3, 1, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (4, 1, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (5, 1, 4); -- EXPERT
-- soft skill - Self motivation
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (6, 2, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (7, 2, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (8, 2, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (9, 2, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (10, 2, 4); -- EXPERT
-- soft skill - Leadership
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (11, 3, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (12, 3, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (13, 3, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (14, 3, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (15, 3, 4); -- EXPERT
-- soft skill - Responsibility
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (16, 4, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (17, 4, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (18, 4, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (19, 4, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (20, 4, 4); -- EXPERT
-- soft skill - Teamwork
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (21, 5, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (22, 5, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (23, 5, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (24, 5, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (25, 5, 4); -- EXPERT
-- soft skill - Problem solving
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (26, 6, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (27, 6, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (28, 6, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (29, 6, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (30, 6, 4); -- EXPERT
-- soft skill - Working under pressure
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (31, 7, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (32, 7, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (33, 7, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (34, 7, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (35, 7, 4); -- EXPERT
-- soft skill - Time management
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (36, 8, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (37, 8, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (38, 8, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (39, 8, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (40, 8, 4); -- EXPERT
-- soft skill - Flexibility
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (41, 9, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (42, 9, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (43, 9, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (44, 9, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (45, 9, 4); -- EXPERT
-- soft skill - Negotiation
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (46, 10, 0); -- BASIC
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (47, 10, 1); -- GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (48, 10, 2); -- VERY_GOOD
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (49, 10, 3); -- EXCELLENT
insert into soft_skill_proficiencies (id, soft_skill_id, proficiency) values (50, 10, 4); -- EXPERT

-- language proficiency

-- language - English
insert into language_proficiencies (id, language_id, proficiency) values (1, 1, 0); -- BASIC
insert into language_proficiencies (id, language_id, proficiency) values (2, 1, 1); -- GOOD
insert into language_proficiencies (id, language_id, proficiency) values (3, 1, 2); -- VERY_GOOD
insert into language_proficiencies (id, language_id, proficiency) values (4, 1, 3); -- EXCELLENT
insert into language_proficiencies (id, language_id, proficiency) values (5, 1, 4); -- EXPERT
-- language - German
insert into language_proficiencies (id, language_id, proficiency) values (6, 2, 0); -- BASIC
insert into language_proficiencies (id, language_id, proficiency) values (7, 2, 1); -- GOOD
insert into language_proficiencies (id, language_id, proficiency) values (8, 2, 2); -- VERY_GOOD
insert into language_proficiencies (id, language_id, proficiency) values (9, 2, 3); -- EXCELLENT
insert into language_proficiencies (id, language_id, proficiency) values (10, 2, 4); -- EXPERT
-- language - Dutc
insert into language_proficiencies (id, language_id, proficiency) values (11, 3, 0); -- BASIC
insert into language_proficiencies (id, language_id, proficiency) values (12, 3, 1); -- GOOD
insert into language_proficiencies (id, language_id, proficiency) values (13, 3, 2); -- VERY_GOOD
insert into language_proficiencies (id, language_id, proficiency) values (14, 3, 3); -- EXCELLENT
insert into language_proficiencies (id, language_id, proficiency) values (15, 3, 4); -- EXPERT
-- language - Spanish
insert into language_proficiencies (id, language_id, proficiency) values (16, 4, 0); -- BASIC
insert into language_proficiencies (id, language_id, proficiency) values (17, 4, 1); -- GOOD
insert into language_proficiencies (id, language_id, proficiency) values (18, 4, 2); -- VERY_GOOD
insert into language_proficiencies (id, language_id, proficiency) values (19, 4, 3); -- EXCELLENT
insert into language_proficiencies (id, language_id, proficiency) values (20, 4, 4); -- EXPERT
-- language - Italian
insert into language_proficiencies (id, language_id, proficiency) values (21, 5, 0); -- BASIC
insert into language_proficiencies (id, language_id, proficiency) values (22, 5, 1); -- GOOD
insert into language_proficiencies (id, language_id, proficiency) values (23, 5, 2); -- VERY_GOOD
insert into language_proficiencies (id, language_id, proficiency) values (24, 5, 3); -- EXCELLENT
insert into language_proficiencies (id, language_id, proficiency) values (25, 5, 4); -- EXPERT

----------------------- users proficiencies -------------------------------
-- user with id 2 - 'Job Seeker'

-- java, javascript, python
insert into users_programming_proficiencies (job_seeker_id, programming_proficiencies_id) values (2, 20); -- java - EXPERT
insert into users_programming_proficiencies (job_seeker_id, programming_proficiencies_id) values (2, 23); -- javascript - VERY_GOOD
insert into users_programming_proficiencies (job_seeker_id, programming_proficiencies_id) values (2, 54); -- python - EXCELLENT


-- spring, spring boot, django, vue
insert into users_technology_proficiencies (job_seeker_id, technology_proficiencies_id) values (2, 85); -- spring - EXPERT
insert into users_technology_proficiencies (job_seeker_id, technology_proficiencies_id) values (2, 80); -- spring boot - EXPERT
insert into users_technology_proficiencies (job_seeker_id, technology_proficiencies_id) values (2, 23); -- django - VERY_GOOD
insert into users_technology_proficiencies (job_seeker_id, technology_proficiencies_id) values (2, 18); -- vue - VERY_GOOD


-- REST, SQL, EC6
insert into users_knowledge_proficiencies (job_seeker_id, knowledge_proficiencies_id) values (2, 45); -- REST - EXPERT
insert into users_knowledge_proficiencies (job_seeker_id, knowledge_proficiencies_id) values (2, 8); -- SQL - VERY_GOOD
insert into users_knowledge_proficiencies (job_seeker_id, knowledge_proficiencies_id) values (2, 83); -- EC6 - VERY_GOOD

------------------------------------------------------------------------------

-- companies
insert into companies (id, name, rank) values (1, 'Levi9', 0);
insert into companies (id, name, rank) values (2, 'Continental', 0);
insert into companies (id, name, rank) values (3, 'VegaIT', 0);
insert into companies (id, name, rank) values (4, 'Vivify', 0);
insert into companies (id, name, rank) values (5, 'MarbleIT', 0);
insert into companies (id, name, rank) values (6, 'Nordeus', 0);
insert into companies (id, name, rank) values (7, 'Synechron', 0);

-- language importances
insert into language_importances (id, language_proficiency_id, optional, importance) values (1, 3, false, 9);

-- -- job offers
-- -- Levi9
insert into job_offers (id, company_id, position_id, seniority, rank) values (1, 1, 1, 2, 0); -- BACKEND, MEDIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (1, 8, false, 7); -- SQL DATABASES, VERY GOOD
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (2, 44, false, 10); -- REST, EXCELLENT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (3, 65, false, 10); -- Object oriented programming, EXPERT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (4, 73, false, 8); -- Design patterns, VERY GOOD

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (1, 1); -- SQL Databases, GOOD 
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (1, 2); -- REST, EXCELLENT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (1, 3); -- Object oriented programming, EXPERT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (1, 4); -- Design patterns, VERY GOOD

-- programming importances
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (1, 19, false, 10); -- Java, EXCELLENT

insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (1, 1); -- Java, EXCELLENT

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (1, 73, false, 8); -- Maven, VERY GOOD
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (2, 79, false, 10); -- Spring Boot, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (3, 84, false, 9); -- Spring, EXCELLENT

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (1, 1); -- Maven, VERY GOOD
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (1, 2); -- Spring Boot, EXCELLENT 
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (1, 3); -- Spring, EXCELLENT

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (1, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into soft_skill_importances (id, soft_skill_proficiency_id, optional, importance) values (1, 24, false, 10); -- Team work, EXCELLENT
insert into soft_skill_importances (id, soft_skill_proficiency_id, optional, importance) values (2, 38, false, 10); -- Time management, VERY GOOD

insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (1, 1); -- Team work, EXCELLENT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (1, 2); -- Time management, VERY GOOD
-- -----------------------------------------
-- Levi9
insert into job_offers (id, company_id, position_id, seniority, rank) values (2, 1, 2, 2, 0); -- FRONTEND, MEDIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (5, 84, false, 9); -- ES6 specification, EXCELLENT

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (2, 2); -- REST, EXCELLENT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (2, 4); -- Design patterns, VERY GOOD
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (2, 5); -- ES6 specification, EXCELLENT

-- programming importances
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (2, 24, false, 10); -- JavaScript, EXCELLENT

insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (2, 2); -- JavaScript, EXCELLENT

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (4, 44, false, 10); -- REACT, EXCELLENT

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (2, 4); -- REACT, EXCELLENT

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (2, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (2, 1); -- Team work, EXCELLENT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (2, 2); -- Time management, VERY GOOD
-------------------------------------
-- Levi9
insert into job_offers (id, company_id, position_id, seniority, rank) values (3, 1, 3, 3, 0); -- FULLSTACK, SENIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (6, 10, false, 9); -- SQL DATABASES, EXCELLENT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (7, 45, false, 10); -- REST, EXPERT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (8, 75, false, 8); -- Design patterns, EXPERT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (9, 85, false, 9); -- ES6 specification, EXPERT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (10, 65, false, 9); -- Object oriented programming, EXPERT

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (3, 6); -- SQL Databases, EXPERT 
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (3, 7); -- REST, EXPERT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (3, 8); -- Design patterns, EXPERT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (3, 9); -- ES6 specification, EXPERT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (3, 10); -- Object oriented programming, EXPERT

-- programming importances
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (3, 20, false, 10); -- Java, EXPERT
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (4, 25, false, 10); -- JavaScript, EXCELLENT

insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (3, 3); -- Java, EXPERT
insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (3, 4); -- JavaScript, EXPERT

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (5, 80, false, 10); -- Spring Boot, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (6, 85, false, 7); -- Spring, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (7, 45, false, 9); -- REACT, EXPERT

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (3, 5); -- Spring Boot, EXPERT 
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (3, 6); -- Spring, EXPERT
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (3, 7); -- REACT, EXPERT

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (3, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into soft_skill_importances (id, soft_skill_proficiency_id, optional, importance) values (3, 25, false, 10); -- Team work, EXPERT
insert into soft_skill_importances (id, soft_skill_proficiency_id, optional, importance) values (4, 40, false, 10); -- Time management, EXPERT

insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (3, 3); -- Team work, EXPERT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (3, 4); -- Time management, EXPERT
-------------------------------------
-- Levi9
insert into job_offers (id, company_id, position_id, seniority, rank) values (4, 1, 22, 1, 0); -- TESTER, JUNIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (11, 56, false, 10); -- Testing metodologies, BASIC
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (12, 60, false, 8); -- Object oriented programming, BASIC

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (4, 11); -- Testing metodologies, BASIC
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (4, 12); -- Object oriented programming, BASIC

-- programming importances
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (5, 15, false, 9); -- Java, BASIC
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (6, 20, false, 9); -- JavaScript, BASIC

insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (4, 5); -- Java, BASIC
insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (4, 6); -- JavaScript, BASIC

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (8, 51, true, 7); -- JUnit, BASIC
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (9, 56, false, 9); -- Jasmine, BASIC
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (10, 61, false, 10); -- Selenium, BASIC
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (11, 11, false, 9); -- Angular, BASIC

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (4, 8); -- JUnit, BASIC
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (4, 9); -- Jasmine, BASIC
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (4, 10); -- Selenium, BASIC
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (4, 11); -- Angular, BASIC

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (4, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (4, 3); -- Team work, EXPERT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (4, 4); -- Time management, EXPERT
-------------------------------------

-- Continental
insert into job_offers (id, company_id, position_id, seniority, rank) values (5, 2, 10, 2, 0); -- DATABASE ADMINISTRATOR, MEDIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (13, 9, false, 9); -- SQL Databases, EXCELLENT
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (14, 19, false, 7); -- NoSQL Databases, EXCELLENT

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (5, 13); -- SQL Databases, EXCELLENT
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (5, 14); -- NoSQL Databases, EXCELLENT

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (12, 144, false, 10); -- Amazon AWS, EXCELLENT

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (5, 12); -- Amazon AWS, EXCELLENT

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (5, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (5, 3); -- Team work, EXPERT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (5, 4); -- Time management, EXPERT
------------------------------------

-- VegaIT
insert into job_offers (id, company_id, position_id, seniority, rank) values (6, 3, 11, 2, 0); -- ARTIFICIAL INTELLIGENCE SPECIALIST, MEDIOR, NONE

-- knowledge importances
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (15, 88, false, 9); -- Neural networks, VERY GOOD
insert into knowledge_importances (id, knowledge_proficiency_id, optional, importance) values (16, 93, false, 10); -- Machine learning algorithms, VERY GOOD

insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (6, 15); -- Neural networks, VERY GOOD
insert into job_offers_knowledge_importances (job_offer_id, knowledge_importances_id) values (6, 16); -- Machine learning algorithms, VERY GOOD
 
-- programming importances
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (7, 54, false, 10); -- Python, EXCELLENT
insert into programming_importances (id, programming_proficiency_id, optional, importance) values (8, 93, true, 7); -- R, VERY GOOD

insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (6, 7); -- Python, EXCELLENT
insert into job_offers_programming_importances (job_offer_id, programming_importances_id) values (6, 8); -- R, VERY_GOOD

-- technology importances
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (13, 89, false, 10); -- Pandas, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (14, 94, false, 10); -- Numpy, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (15, 99, false, 8); -- Tensorflow, EXCELLENT
insert into technology_importances (id, technology_proficiency_id, optional, importance) values (16, 104, false, 9); -- Keras, EXCELLENT

insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (6, 13); -- Pandas, EXCELLENT
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (6, 14); -- Numpy, EXCELLENT
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (6, 15); -- Tensorflow, EXCELLENT
insert into job_offers_technology_importances (job_offer_id, technology_importances_id) values (6, 16); -- Keras, EXCELLENT

-- language importances
insert into job_offers_language_importances (job_offer_id, language_importances_id) values (6, 1); -- ENGLISH, VERY GOOD

-- soft skills importances
insert into soft_skill_importances (id, soft_skill_proficiency_id, optional, importance) values (5, 9, false, 10); -- Self motivation, EXCELLENT

insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (6, 3); -- Team work, EXPERT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (6, 4); -- Time management, EXPERT
insert into job_offers_soft_skill_importances (job_offer_id, soft_skill_importances_id) values (6, 5); -- Self motivation, EXCELLENT
-----------------------------------
