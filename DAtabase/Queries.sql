CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_name VARCHAR(25) NULL,
	user_password VARCHAR(25) NULL
);

create table short_production(
id int auto_increment primary key,
production_title varchar(100) not null,
production_type varchar(10) not null,
production_year int not null);

create table production(
id int auto_increment primary key,
production_title varchar(100) not null,
production_type varchar(10) not null,
production_genre varchar(25),
production_year varchar(25),
production_runtime varchar(25),
production_plot varchar(500),
production_rated varchar(500),
production_language varchar(500),
production_director varchar(500),
production_actors varchar(500)
);

CREATE TABLE user_favs (
    user_id INT,
    production_id INT,
    PRIMARY KEY (user_id, production_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (production_id) REFERENCES short_production(id)
    );
    
    CREATE TABLE user_history (
    user_id INT,
    production_id INT,
    PRIMARY KEY (user_id, production_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (production_id) REFERENCES short_production(id)
    );
    
    