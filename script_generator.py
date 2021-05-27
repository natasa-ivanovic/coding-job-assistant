
# insert into programming_proficiencies (id, programming_language_id, proficiency) values ();

# programming proficiencies
proficiencies = [
    'BASIC',
    'GOOD',
    'VERY_GOOD',
    'EXCELLENT',
    'EXPERT'
]

prog_lang_list = [
    'C',
    'C++',
    'C#',
    'Java',
    'JavaScript',
    'Ruby',
    'PHP',
    'HTML',
    'CSS',
    'Kotlin',
    'Python',
    'Go',
    'Pharo',
    'GML',
    'Lua',
    'Swift',
    'Dart',
    'Matlab',
    'R',
    'Bash',
]
table_name = "programming_proficiencies"
prof_number = len(prog_lang_list)
prof_ids = range(1, prof_number + 1)
current_id = 1
for prof_id, prog_language in zip(prof_ids, prog_lang_list):
    print("-- programming language - " + prog_language)
    for proficiency in range(5):
        prof_suffix = " -- " + proficiencies[proficiency]
        print("insert into " + table_name + " (id, programming_language_id, proficiency) values (" + str(current_id) + ", " + str(prof_id) + ", " + str(proficiency) + ");" + prof_suffix)
        current_id += 1

technologies_list = [
    'NodeJS',
    'Laravel',
    'Angular',
    'Vue',
    'Django',
    'Unity',
    'GM Studio',
    'LWJGL',
    'React Native',
    'Flutter',
    'JUnit',
    'Jasmine',
    'Selenium',
    'Ruby On Rails',
    'Maven',
    'Spring Boot',
    'Spring',
    'Pandas',
    'Numpy',
    'Tensorflow',
    'Keras',
    'Trello',
    'Jira',
    'Travis-CI',
    'Heroku',
    'SonarQube',
    'SonarCloud',
    'Git',
    'Amazon AWS',
    'MS Azure',
]
table_name = "technology_proficiencies"
prof_number = len(technologies_list)
prof_ids = range(1, prof_number + 1)
current_id = 1
for prof_id, technology in zip(prof_ids, technologies_list):
    print("-- technology - " + technology)
    for proficiency in range(5):
        prof_suffix = " -- " + proficiencies[proficiency]
        print("insert into " + table_name + " (id, technology_id, proficiency) values (" + str(current_id) + ", " + str(prof_id) + ", " + str(proficiency) + ");" + prof_suffix)
        current_id += 1


knowledge_list = [
    'Agile methodology',
    'SQL Databases',
    'Network communication',
    'NoSQL Databases',
    'Network management',
    'Troubleshooting skills',
    'Software virtualization',
    'Network protocols',
    'REST',
    'Web security',
    'Cloud technologies',
    'Testing metodologies',
    'Object oriented programming',
    'Functional programming',
    'Design patterns',
    'CS algorithms',
    'ES6 specification',
    'Neural networks',
    'Machine learning algorithms',
    'SCRUM',
]

table_name = "knowledge_proficiencies"
prof_number = len(knowledge_list)
prof_ids = range(1, prof_number + 1)
current_id = 1
for prof_id, knowledge in zip(prof_ids, knowledge_list):
    print("-- knowledge - " + knowledge)
    for proficiency in range(5):
        prof_suffix = " -- " + proficiencies[proficiency]
        print("insert into " + table_name + " (id, knowledge_id, proficiency) values (" + str(current_id) + ", " + str(prof_id) + ", " + str(proficiency) + ");" + prof_suffix)
        current_id += 1

soft_skills_list = [
    'Communication',
    'Self motivation',
    'Leadership',
    'Responsibility',
    'Teamwork',
    'Problem solving',
    'Working under pressure',
    'Time management',
    'Flexibility',
    'Negotiation',
]

table_name = "soft_skills_proficiencies"
prof_number = len(soft_skills_list)
prof_ids = range(1, prof_number + 1)
current_id = 0
for prof_id, soft_skill in zip(prof_ids, soft_skills_list):
    print("-- soft skill - " + soft_skill)
    for proficiency in range(5):
        prof_suffix = " -- " + proficiencies[proficiency]
        print("insert into " + table_name + " (id, soft_skill_id, proficiency) values (" + str(current_id) + ", " + str(prof_id) + ", " + str(proficiency) + ");" + prof_suffix)
        current_id += 1

languages_list = [
    'English',
    'German',
    'Dutch',
    'Spanish',
    'Italian',
]

table_name = "language_proficiencies"
prof_number = 5
prof_ids = range(1, prof_number + 1)
current_id = 0
for prof_id, language in zip(prof_ids, languages_list):
    print("-- language - " + language)
    for proficiency in range(5):
        prof_suffix = " -- " + proficiencies[proficiency]
        print("insert into " + table_name + " (id, language_id, proficiency) values (" + str(current_id) + ", " + str(prof_id) + ", " + str(proficiency) + ");" + prof_suffix)
        current_id += 1
