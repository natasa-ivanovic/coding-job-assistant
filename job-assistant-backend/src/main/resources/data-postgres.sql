insert into authorities (name) values ('ROLE_ADMIN');

-- password == name
insert into users (name, surname, username, password, enabled, last_password_reset_date, role) values ('admin1', 'admin1', 'admin1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'ADMIN');

insert into user_authority (user_id, authority_id) values (1, 1);

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
insert into technologies (id, name) values (9, 'React Native');
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
insert into job_positions (title) values ('Backend Developer');
insert into job_positions (title) values ('Frontend Developer');
insert into job_positions (title) values ('FullStack Developer');
insert into job_positions (title) values ('Data Scientist');
insert into job_positions (title) values ('Game Developer');
insert into job_positions (title) values ('Mobile Application Developer');
insert into job_positions (title) values ('Computer System Analyst');
insert into job_positions (title) values ('Computer System Engineer');
insert into job_positions (title) values ('Network System Administrator');
insert into job_positions (title) values ('Database Administrator');
insert into job_positions (title) values ('Artificial Intelligence Specialist');
insert into job_positions (title) values ('Bioinformatics Software Engineer');
insert into job_positions (title) values ('Computer Forensics Investigator');
insert into job_positions (title) values ('Cybersecurity Strategist');
insert into job_positions (title) values ('Data Architect');
insert into job_positions (title) values ('Electronics Engineer');
insert into job_positions (title) values ('Game Tester');
insert into job_positions (title) values ('Lead Software Engineer');
insert into job_positions (title) values ('Security Administrator');
insert into job_positions (title) values ('SEO Analyst');
insert into job_positions (title) values ('Software Architect');
insert into job_positions (title) values ('Software Tester');
insert into job_positions (title) values ('Statistical Programmer');
insert into job_positions (title) values ('Telecommunications Engineer');
insert into job_positions (title) values ('Telecommunications Specialist');

#backend
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 4);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 5);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 6);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (1, 11);

#frontend
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 5);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 7);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 8);
insert into job_positions_programming_languages (job_position_id, programming_languages_id) values (2, 9);

#backend
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 1);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 2);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 5);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 14);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 15);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 16);
insert into job_positions_technologies (job_position_id, technologies_id) values (1, 17);

#frontend
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 1);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 2);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 3);
insert into job_positions_technologies (job_position_id, technologies_id) values (2, 4);

#backend
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 2);
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 9);

#frontend
insert into job_positions_knowledge (job_position_id, knowledge_id) values (2, 9);
insert into job_positions_knowledge (job_position_id, knowledge_id) values (1, 17);










