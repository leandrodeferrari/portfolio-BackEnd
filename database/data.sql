USE portfolio;

-- INSERTS OF ROLES

INSERT INTO roles (ROLE_NAME) 
	VALUES ('ROLE_ADMIN');

-- INSERTS OF USERS

INSERT INTO users (USER_NAME, EMAIL, USER_PASSWORD, CREATION_DATE, ROLE_ID) 
	VALUES ('leandro_deferrari', 'leandro_deferrari@hotmail.com', 
			'$2a$10$tcYZ7Vi5yzKlQhIc8kogvu8ETQ9ihqobpCzkiwEvSGlHCvXPV0RAC', CURRENT_TIMESTAMP(), 1);

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
	VALUES ('Leandro', 'Deferrari Arevalo', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671724862/portfolio/foto-de-perfil_sx6idg.jpg', 
			'Java Developer', 'Queriendo conseguir mi primer empleo IT, en donde pueda ampliar mis conocimientos, formar parte de un equipo de trabajo y aportar valor a la empresa.', 
            'leandro_deferrari@hotmail.com', 
            'https://res.cloudinary.com/dwirzebm8/image/upload/v1671724894/portfolio/banner_oinhiu.jpg', 
            'https://www.linkedin.com/in/leandrodeferrari/', 
            'https://github.com/leandrodeferrari', 'https://drive.google.com/file/d/1fao9swtIL21JLkNs94Qc4xZ2ePZQA8my/view?usp=sharing', 1);

-- INSERTS OF TECHNOLOGIES

INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Spring', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671738733/portfolio/springio-ar21_mcexct.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Angular', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671738847/portfolio/angular-ar21_jwtfeo.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('MySQL', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671738921/portfolio/mysql-ar21_l7oj2z.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Jira', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739425/portfolio/atlassian_jira-ar21_focdng.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Java', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739256/portfolio/java-ar21_id7yeo.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('GitHub', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739340/portfolio/github-ar21_bulfdj.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('TypeScript', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739563/portfolio/typescriptlang-ar21_sdnsed.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('Bootstrap', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739696/portfolio/getbootstrap-ar21_nfo6xh.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('HTML', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739801/portfolio/w3_html5-ar21_vjc09g.svg', 1);
    
INSERT INTO technologies (TECHNOLOGY_NAME, LOGO_URL, PERSON_ID) 
	VALUES ('CSS', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671739875/portfolio/w3_css-ar21_xuetl8.svg', 1);
    
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
	VALUES ('Instituto de Formación Tecnica Superior (IFTS) N° 11', 
			'https://res.cloudinary.com/dwirzebm8/image/upload/v1671740375/portfolio/ifts-n-11-squarelogo-1664437707630_ttny6o.png', 3);

INSERT INTO institutes_universities (INSTITUTE_UNIVERSITY_NAME, LOGO_URL, ADDRESS_ID) 
	VALUES ('Egg Educación', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671740448/portfolio/egg-completo_rwjgfs.png', 4);

-- INSERTS OF COURSES

INSERT INTO courses (TITLE, IS_APPROVED, CERTIFICATE_URL, START_DATE, END_DATE, PERSON_ID, INSTITUTE_UNIVERSITY_ID) 
	VALUES ('FullStack Developer', 1, 'https://drive.google.com/file/d/1jkKNvYbJd-Ag2m1hr89DyQNYWGa3BPzE/view?usp=sharing', 
			'2021-11-03', '2022-09-29', 1, 2);

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
            'Perfil capacitado para producir artefactos de software (reutilizando elementos existentes o programándolos enteramente), cumpliendo con los criterios de realización establecidos para las mismas, en el marco de un equipo de trabajo organizado por proyecto.', 1, 1, 1);

-- INSERTS OF BUSINESSES

INSERT INTO businesses (BUSINESS_NAME, LOGO_URL, ADDRESS_ID) 
	VALUES ('Alkemy', 'https://res.cloudinary.com/dwirzebm8/image/upload/v1671740828/portfolio/alkemy_uui7ip.jpg', 2);
    
-- INSERTS OF PROJECT_TYPES

INSERT INTO project_types (PROJECT_TYPE_NAME) 
	VALUES ('Propio');

INSERT INTO project_types (PROJECT_TYPE_NAME) 
	VALUES ('Aceleración');
    
-- INSERTS OF PROJECTS

INSERT INTO projects (PROJECT_NAME, START_DATE, END_DATE, DESCRIPT, IMAGE_URL, EVIDENCE_URL, PROJECT_TYPE_ID, PERSON_ID, BUSINESS_ID) 
	VALUES ('AlkyBank', '2022-10-31', '2022-11-13', 'Realización del BackEnd de una Wallet Digital (Alkybank) conformado por un equipo de 8 integrantes (incluyéndome) durante 2 semanas. Utilizando las metodologías ágiles SCRUM y KANBAN (Jira). Diseñada con Java (Spring boot) y MySQL para la base de datos.', 
			'https://res.cloudinary.com/dwirzebm8/image/upload/v1671740524/portfolio/imagen-alkybank_fcm2yx.png', 
            'https://drive.google.com/file/d/1FVo2MzVsJJt-Gxq1zHSP0MJagQAE3_pI/view', 2, 1, 1);

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
	VALUES ('Trabajo ficticio', '2022-12-01', 1, 'Tareas varias con Angular y Java', 2, 1, 2, 1);