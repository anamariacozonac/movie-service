ALTER TABLE IF EXISTS t_movies_t_persons_roles DROP CONSTRAINT fk_t_mpr_person_roles_id;
ALTER TABLE IF EXISTS t_movies_t_persons_roles DROP COLUMN person_roles_id;
ALTER TABLE IF EXISTS t_movies_t_persons_roles ADD COLUMN person_id int8 NOT NULL,
                                               ADD COLUMN role_id int8 NOT NULL;
ALTER TABLE IF EXISTS t_movies_t_persons_roles ADD CONSTRAINT fk_mpr_person FOREIGN KEY (person_id) REFERENCES t_persons,
                                               ADD CONSTRAINT  fk_mpr_role FOREIGN KEY (role_id) REFERENCES t_roles;
