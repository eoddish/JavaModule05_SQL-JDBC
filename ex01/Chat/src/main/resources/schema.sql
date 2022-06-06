DROP TABLE MESSAGES;
DROP TABLE CHATROOMS;
DROP TABLE USERS;

CREATE TABLE USERS(
                        ID                   SERIAL,
                        LOGIN                TEXT       NOT NULL,
                        PASSWORD             TEXT       NOT NULL,
                        PRIMARY KEY (ID),
                        UNIQUE(ID)
);

CREATE TABLE CHATROOMS(
                        ID                       SERIAL,
                        NAME                     TEXT     NOT NULL,
                        OWNER                   INT      NOT NULL,
                        PRIMARY KEY (ID),
                        FOREIGN KEY (OWNER)      REFERENCES USERS(ID) ON DELETE CASCADE,
                        UNIQUE(ID)
);

CREATE TABLE MESSAGES(
                        ID                   SERIAL,
                        AUTHOR               INT        NOT NULL,
                        ROOM                 INT        NOT NULL,
                        TEXT                 TEXT,
                        DATE                 TIMESTAMP  DEFAULT     CURRENT_TIMESTAMP,
                        PRIMARY KEY          (ID),
                        FOREIGN KEY          (AUTHOR)   REFERENCES  USERS(ID) ON DELETE CASCADE,
                        FOREIGN KEY          (ROOM)     REFERENCES  CHATROOMS(ID) ON DELETE CASCADE,
                        UNIQUE(ID)
);
/*
CREATE TABLE USERS_CREATED_ROOMS(
                        USER_ID             INT NOT NULL,
                        ROOM_ID             INT NOT NULL,
                        PRIMARY             KEY (USER_ID, ROOM_ID),
                        FOREIGN             KEY (USER_ID) REFERENCES USERS(ID) ON UPDATE CASCADE,
                        FOREIGN             KEY (ROOM_ID) REFERENCES CHATROOMS(ID) ON UPDATE CASCADE
);

CREATE TABLE USERS_ROOMS(
                        USER_ID             INT NOT NULL,
                        ROOM_ID             INT NOT NULL,
                        PRIMARY             KEY (USER_ID, ROOM_ID),
                        FOREIGN             KEY (USER_ID) REFERENCES USERS(ID) ON UPDATE CASCADE,
                        FOREIGN             KEY (ROOM_ID) REFERENCES CHATROOMS(ID) ON UPDATE CASCADE
);

CREATE TABLE ROOMS_MESSAGES(
                       USER_ID             INT NOT NULL,
                       MESSAGE_ID             INT NOT NULL,
                       PRIMARY             KEY (USER_ID, MESSAGE_ID),
                       FOREIGN             KEY (USER_ID) REFERENCES USERS(ID) ON UPDATE CASCADE,
                       FOREIGN             KEY (MESSAGE_ID) REFERENCES MESSAGES(ID) ON UPDATE CASCADE
);

 */