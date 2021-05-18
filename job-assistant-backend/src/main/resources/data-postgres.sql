insert into authorities (name) values ('ROLE_ADMIN');

-- password == name
insert into users (name, surname, username, password, enabled, last_password_reset_date, role) values ('admin1', 'admin1', 'admin1@gmail.com', '$2y$12$LdA5w1xM5qBwt1l.Srv62etWXUpyfCbU/usi3EprOEdZ3ZbCiDx/K', true, '2020-12-07 16:00:00.508-07', 'ADMIN');

insert into user_authority (user_id, authority_id) values (1, 1);

-- programming languages
insert into prog_languages (name) values ('C');
insert into prog_languages (name) values ('C++');
insert into prog_languages (name) values ('C#');
insert into prog_languages (name) values ('Java');
insert into prog_languages (name) values ('JavaScript');
insert into prog_languages (name) values ('Ruby');
insert into prog_languages (name) values ('PHP');
insert into prog_languages (name) values ('HTML');
insert into prog_languages (name) values ('CSS');
insert into prog_languages (name) values ('Kotlin');
insert into prog_languages (name) values ('Python');
insert into prog_languages (name) values ('Go');
insert into prog_languages (name) values ('Pharo');
insert into prog_languages (name) values ('GML');
insert into prog_languages (name) values ('Lua');
insert into prog_languages (name) values ('Swift');
insert into prog_languages (name) values ('Dart');
insert into prog_languages (name) values ('Matlab');
insert into prog_languages (name) values ('R');
insert into prog_languages (name) values ('Bash');

-- technologies
insert into technologies (name) values ('NodeJS');
insert into technologies (name) values ('Laravel');
insert into technologies (name) values ('Angular');
insert into technologies (name) values ('Vue');
insert into technologies (name) values ('Django');
insert into technologies (name) values ('Unity');
insert into technologies (name) values ('GM Studio');
insert into technologies (name) values ('LWJGL');
insert into technologies (name) values ('React Native');
insert into technologies (name) values ('Flutter');
insert into technologies (name) values ('JUnit');
insert into technologies (name) values ('Jasmine');
insert into technologies (name) values ('Selenium');
insert into technologies (name) values ('Ruby On Rails');
insert into technologies (name) values ('Maven');
insert into technologies (name) values ('Spring Boot');
insert into technologies (name) values ('Spring');
insert into technologies (name) values ('Pandas');
insert into technologies (name) values ('Numpy');
insert into technologies (name) values ('Tensorflow');
insert into technologies (name) values ('Keras');
insert into technologies (name) values ('Trello');
insert into technologies (name) values ('Jira');
insert into technologies (name) values ('Travis-CI');
insert into technologies (name) values ('Heroku');
insert into technologies (name) values ('SonarQube');
insert into technologies (name) values ('SonarCloud');
insert into technologies (name) values ('Git');
insert into technologies (name) values ('Amazon AWS');
insert into technologies (name) values ('MS Azure');

-- knowledge
insert into knowledge (name) values ('Agile methodology');
insert into technologies (name) values ('SQL Databases');
insert into technologies (name) values ('Network communication');
insert into technologies (name) values ('NoSQL Databases');
insert into technologies (name) values ('Network management');
insert into technologies (name) values ('Troubleshooting skills');
insert into technologies (name) values ('Software virtualization');
insert into technologies (name) values ('Network protocols');
insert into technologies (name) values ('REST');
insert into technologies (name) values ('Web security');
insert into technologies (name) values ('Cloud technologies');
insert into technologies (name) values ('Testing metodologies');
insert into technologies (name) values ('Object oriented programming');
insert into technologies (name) values ('Functional programming');
insert into technologies (name) values ('Design patterns');
insert into technologies (name) values ('CS algorithms');
insert into technologies (name) values ('ES6 specification');
insert into technologies (name) values ('Neural networks');
insert into technologies (name) values ('Machine learning algorithms');
insert into technologies (name) values ('SCRUM');

-- soft skills
insert into soft_skills (name) values ('Communication');
insert into soft_skills (name) values ('Self motivation');
insert into soft_skills (name) values ('Leadership');
insert into soft_skills (name) values ('Responsibility');
insert into soft_skills (name) values ('Teamwork');
insert into soft_skills (name) values ('Problem solving');
insert into soft_skills (name) values ('Working under pressure');
insert into soft_skills (name) values ('Time management');
insert into soft_skills (name) values ('Flexibility');
insert into soft_skills (name) values ('Negotiation');

-- languages
insert into languages (name) values ('English');
insert into languages (name) values ('German');
insert into languages (name) values ('Dutch');
insert into languages (name) values ('Spanish');
insert into languages (name) values ('Italian');

-- job positions
insert into job_positions (title, subtitle) values ('Backend Developer', '');
insert into job_positions (title, subtitle) values ('Frontend Developer', '');
insert into job_positions (title, subtitle) values ('FullStack Developer', '');
insert into job_positions (title, subtitle) values ('Data Scientist', '');
insert into job_positions (title, subtitle) values ('Game Developer', '');
insert into job_positions (title, subtitle) values ('Mobile Application Developer', '');
insert into job_positions (title, subtitle) values ('Computer System Analyst', '');
insert into job_positions (title, subtitle) values ('Computer System Engineer', '');
insert into job_positions (title, subtitle) values ('Network System Administrator', '');
insert into job_positions (title, subtitle) values ('Database Administrator', '');
insert into job_positions (title, subtitle) values ('Artificial Intelligence Specialist', '');
insert into job_positions (title, subtitle) values ('Bioinformatics Software Engineer', '');
insert into job_positions (title, subtitle) values ('Computer Forensics Investigator', '');
insert into job_positions (title, subtitle) values ('Cybersecurity Strategist', '');
insert into job_positions (title, subtitle) values ('Data Architect', '');
insert into job_positions (title, subtitle) values ('Electronics Engineer', '');
insert into job_positions (title, subtitle) values ('Game Tester', '');
insert into job_positions (title, subtitle) values ('Lead Software Engineer', '');
insert into job_positions (title, subtitle) values ('Security Administrator', '');
insert into job_positions (title, subtitle) values ('SEO Analyst', '');
insert into job_positions (title, subtitle) values ('Software Architect', '');
insert into job_positions (title, subtitle) values ('Software Tester', '');
insert into job_positions (title, subtitle) values ('Statistical Programmer', '');
insert into job_positions (title, subtitle) values ('Telecommunications Engineer', '');
insert into job_positions (title, subtitle) values ('Telecommunications Specialist', '');











