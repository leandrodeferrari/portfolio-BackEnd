USE portfolio;

-- INSERTS OF ROLES

INSERT INTO roles (ROLE_NAME) 
	VALUES ('ROLE_ADMIN');

-- INSERTS OF USERS

INSERT INTO users (USER_NAME, EMAIL, USER_PASSWORD, CREATION_DATE, ROLE_ID) 
	VALUES ('leandro_deferrari', 'leandro_deferrari@hotmail.com', '12345678', CURRENT_TIMESTAMP(), 1);

-- INSERTS OF CITIES

INSERT INTO cities (CITY_NAME) 
	VALUES ('Ciudad Madero');
    
INSERT INTO cities (CITY_NAME) 
	VALUES ('Manhattan');
    
INSERT INTO cities (CITY_NAME) 
	VALUES ('Parque Patricios');

INSERT INTO cities (CITY_NAME) 
	VALUES ('Ciudad de Mendoza');

-- INSERTS OF LOCALITIES

INSERT INTO localities (LOCALITY_NAME) 
	VALUES ('AMBA');

INSERT INTO localities (LOCALITY_NAME) 
	VALUES ('Nueva York');
    
INSERT INTO localities (LOCALITY_NAME) 
	VALUES ('CABA');
    
INSERT INTO localities (LOCALITY_NAME) 
	VALUES ('Capital de Mendoza');
    
-- INSERTS OF PROVINCES

INSERT INTO provinces (PROVINCE_NAME) 
	VALUES ('Buenos Aires');
    
INSERT INTO provinces (PROVINCE_NAME) 
	VALUES ('Mendoza');

-- INSERTS OF COUNTRIES

INSERT INTO countries (COUNTRY_NAME) 
	VALUES ('Argentina');

INSERT INTO countries (COUNTRY_NAME) 
	VALUES ('EE. UU.');

-- INSERTS OF ADDRESSES

INSERT INTO addresses (CITY_ID, LOCALITY_ID, PROVINCE_ID, COUNTRY_ID) 
	VALUES (1, 1, 1, 1);
    
INSERT INTO addresses (CITY_ID, LOCALITY_ID, COUNTRY_ID) 
	VALUES (2, 2, 2);
    
INSERT INTO addresses (CITY_ID, LOCALITY_ID, PROVINCE_ID, COUNTRY_ID) 
	VALUES (3, 3, 1, 1);
    
INSERT INTO addresses (CITY_ID, LOCALITY_ID, PROVINCE_ID, COUNTRY_ID)  
	VALUES (4, 4, 2, 1);
    
-- INSERTS OF PERSONS

INSERT INTO persons (FIRST_NAME, LAST_NAME, PROFILE_PHOTO_URL, TITLE, ABOUT_ME, EMAIL, BANNER_URL, LINKEDIN_URL, GITHUB_URL, CV_URL, ADDRESS_ID) 
	VALUES ('Leandro', 'Deferrari Arevalo', 'www.prueba.com/foto-perfil', 
			'Java Developer', 'bla bla bla bla bla bla', 'leandro_deferrari@hotmail.com', 
            'www.prueba.com/banner', 'https://www.linkedin.com/in/javadeveloper-leandrodeferrariarevalo', 
            'https://github.com/leandrodeferrari', 'www.prueba.com/cv', 1);
    
-- INSERTS OF TECHNOLOGIES

INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Spring boot', 'www.prueba.com/spring_boot', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Angular', 'www.prueba.com/angular', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('MySQL', 'www.prueba.com/mysql', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('SQL Server', 'www.prueba.com/sql-server', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Java', 'www.prueba.com/java', 1);
    
-- INSERTS OF LANGUAGE_LEVELS

INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('A1');
    
INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('A2');
    
INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('B1');
    
INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('B2');
    
INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('C1');
    
INSERT INTO language_levels (LANGUAGE_LEVEL_NAME) 
	VALUES ('C2');
    
-- INSERTS OF LANGUAGES

INSERT INTO languages (LANGUAGE_NAME, PERSON_ID, LANGUAGE_LEVEL_ID) 
	VALUES ('Inglés', 1, 2);
    
-- INSERTS OF INSTITUTES_UNIVERSITIES

INSERT INTO institutes_universities (INSTITUTE_UNIVERSITY_NAME, LOGO_URL, ADDRESS_ID) 
	VALUES ('Instituto de Formación Tecnica Superior (IFTS) N° 11', 'www.prueba.com/logo', 3);

INSERT INTO institutes_universities (INSTITUTE_UNIVERSITY_NAME, LOGO_URL, ADDRESS_ID) 
	VALUES ('Egg Educación', 'www.prueba.com/logo', 4);

-- INSERTS OF COURSES

INSERT INTO courses (TITLE, IS_APPROVED, CERTIFICATE_URL, START_DATE, END_DATE, PERSON_ID, INSTITUTE_UNIVERSITY_ID) 
	VALUES ('FullStack Developer', 1, 'www.prueba.com/certificado', '2021-11-03', '2022-09-29', 1, 2);

-- INSERTS OF CAREER_TYPES

INSERT INTO career_types (CAREER_TYPE_NAME) 
	VALUES ('Tecnicatura');
    
INSERT INTO career_types (CAREER_TYPE_NAME) 
	VALUES ('Licenciatura');

INSERT INTO career_types (CAREER_TYPE_NAME) 
	VALUES ('Ingeniería');

-- INSERTS OF CAREERS

INSERT INTO careers (CAREER_NAME, START_DATE, END_DATE, IS_FINISHED, APPROVED_SUBJECTS, TOTAL_SUBJECTS, STUDY_PLAN_URL, DESCRIPT, PERSON_ID, 
INSTITUTE_UNIVERSITY_ID, CAREER_TYPE_ID) 
	VALUES ('Desarrollo de Software', '2022-08-16', '2024-12-01', 0, 4, 23, 
			'https://www.ifts11.com/wp/carreras/plan-de-desarrollo-de-software/#page-content',
            'bla bla bla bla bla', 1, 1, 1);

-- INSERTS OF BUSINESSES

INSERT INTO businesses (BUSINESS_NAME, LOGO_URL, ADDRESS_ID) 
	VALUES ('Alkemy', 'www.prueba.com/alkemy', 2);
    
-- INSERTS OF PROJECT_TYPES

INSERT INTO project_types (PROJECT_TYPE_NAME) 
	VALUES ('Personal');

INSERT INTO project_types (PROJECT_TYPE_NAME) 
	VALUES ('A Terceros');
    
-- INSERTS OF PROJECTS

INSERT INTO projects (PROJECT_NAME, START_DATE, END_DATE, DESCRIPT, IMAGE_URL, EVIDENCE_URL, PROJECT_TYPE_ID, PERSON_ID, BUSINESS_ID) 
	VALUES ('AlkyBank', '2022-10-31', '2022-11-13', 'Skill-Up Java: Desarrollo, en equipo, de una Wallet Digital', 
			'www.prueba.com/imagen', 'https://github.com/stanagatha/Skill-Up-Java-Wallet', 2, 1, 1);

-- INSERTS OF SENIORITY_TYPES

INSERT INTO seniority_types (SENIORITY_NAME) 
	VALUES ('Trainee');
    
INSERT INTO seniority_types (SENIORITY_NAME) 
	VALUES ('Junior');
    
INSERT INTO seniority_types (SENIORITY_NAME) 
	VALUES ('SemiSenior');
    
INSERT INTO seniority_types (SENIORITY_NAME) 
	VALUES ('Senior');
    
-- INSERTS OF JOB_EXPERIENCE_TYPES

INSERT INTO job_experience_types (JOB_EXPERIENCE_TYPE_NAME) 
	VALUES ('Freelance');
    
INSERT INTO job_experience_types (JOB_EXPERIENCE_TYPE_NAME) 
	VALUES ('En relación de dependencia');
    
INSERT INTO job_experience_types (JOB_EXPERIENCE_TYPE_NAME) 
	VALUES ('Contractor');

-- INSERTS OF JOB_EXPERIENCES

INSERT INTO job_experiences (JOB_POSITION_NAME, START_DATE, IS_CURRENT_JOB, DESCRIPT, SENIORITY_TYPE_ID, PERSON_ID, JOB_EXPERIENCE_TYPE_ID, BUSINESS_ID) 
	VALUES ('FullStack Java Developer', '2022-12-01', 1, 'Tareas varias con Angular y Java', 2, 1, 2, 1);
