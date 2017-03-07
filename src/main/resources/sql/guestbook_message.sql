DROP SEQUENCE MESSAGE_ID_SEQ;
CREATE SEQUENCE message_id_seq START WITH 10000;
SELECT message_id_seq.nextval from dual;
DROP TABLE GUESTBOOK_MESSAGE;

CREATE TABLE guestbook_message ( 
								message_id 	number PRIMARY  KEY ,
								guest_name 	VARCHAR2(50 char) NOT NULL , 
								password 	VARCHAR2(10 char) NOT NULL , 
								message		LONG NOT  NULL 		
									);
									
									

									SELECT * FROM GUESTBOOK_MESSAGE;
									
				
									
INSERT INTO GUESTBOOK_MESSAGE VALUES(message_id, 'guest_name', 'password', message)									
									