create table users(
  id varchar(36) PRIMARY KEY,
  username varchar(100) NOT NULL UNIQUE KEY,
  pwd varchar(255) NOT NULL,
  firstname VARCHAR(100),
  lastname VARCHAR(100),
  email VARCHAR(100)
);

create table user_roles(
  user_id varchar(36) NOT NULL,
  role_id varchar(36) NOT NULL,
  UNIQUE KEY (user_id, role_id),
  INDEX(user_id)
);

create table roles(
  id varchar(36) PRIMARY KEY,
  role varchar(100) NOT NULL UNIQUE KEY
);

alter table user_roles add CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id);
alter table user_roles add CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id);

INSERT INTO roles (id, role) VALUES ('9efe830b-aa90-4ea1-9b1c-2332c8ca0bcd', 'user');