INSERT INTO SPRING_BOOT_USER(USER_NAME,USER_PASSWORD,USER_ID,USER_TYPE,CREATE_DATE,LAST_LOGIN_DATE) VALUES ('Admin','$2a$10$2vMFDzTprOSb9HXnfBH/GOekH3pNBP3ajBU.yAJEOVDDrTcdMHHO2','admin',1,SYSDATE(),NULL);
INSERT INTO SPRING_BOOT_USER(USER_NAME,USER_PASSWORD,USER_ID,USER_TYPE,CREATE_DATE,LAST_LOGIN_DATE) VALUES ('Test','$2a$10$1GcbWWMzef9GRk2q42f1xOzQoPR90GOEtCyNiB3EPSzUhxiy/bCLa','test',1,SYSDATE(),NULL);
INSERT INTO SPRING_BOOT_USER(USER_NAME,USER_PASSWORD,USER_ID,USER_TYPE,CREATE_DATE,LAST_LOGIN_DATE) VALUES ('Test2','$2a$10$p5XKbYOTDoPHIVtcXqYwdu9GnRkhWKh/MsIPB.zTcn/5ettG.b5Ee','test2',1,SYSDATE(),NULL);

INSERT INTO `role` VALUES (1,'ADMIN');
INSERT INTO `role` VALUES (2,'USER');

INSERT INTO user_role (role_id, user_id) VALUES (1, 'admin'); 
INSERT INTO user_role (role_id, user_id) VALUES (2, 'test'); 
INSERT INTO user_role (role_id, user_id) VALUES (1, 'test2'); 