delete from PROJECTUSER_PROJECT where projectUsers_ID > -1;
delete from TASK where id > -1; 
delete from PROJECT where id > -1; 
delete from PROJECT_USER where id > -1;

ALTER TABLE PROJECT_USER AUTO_INCREMENT = 1;
ALTER TABLE PROJECT AUTO_INCREMENT = 1;
ALTER TABLE TASK AUTO_INCREMENT = 1;


insert into PROJECT(name,description,created,lastModified) values('Project-A','Test Project',CURDATE(),CURDATE());
SET @project = LAST_INSERT_ID();

insert into Task(name,description,hoursassigned,hoursused,PROJECT_ID) values('Threads','Complete Thread Exercises',0,0,@project);
insert into Task(name,description,hoursassigned,hoursused,PROJECT_ID) values('TCP','Complete TCP Exercises',0,0,@project);


insert into PROJECT_USER (userName, email,created) values ('lam','lam@cphbusiness.dk',CURDATE());
SET @user1 = LAST_INSERT_ID();

insert into PROJECT_USER (userName, email,created) values ('tha','tha@cphbusiness.dk',CURDATE());
SET @user2 = LAST_INSERT_ID();

insert into PROJECT_USER (userName, email,created) values ('sal','sal@cphbusiness.dk',CURDATE());
SET @user3 = LAST_INSERT_ID();

# insert into PROJECT_USER (userName, email,created) values ('cnls','cnls@cphbusiness.dk',CURDATE());
# SET @user4 = LAST_INSERT_ID();


insert into PROJECTUSER_PROJECT(projectUsers_ID,projects_ID) value(@user1,@project);
insert into PROJECTUSER_PROJECT(projectUsers_ID,projects_ID) value(@user2,@project);
insert into PROJECTUSER_PROJECT(projectUsers_ID,projects_ID) value(@user3,@project);
#insert into PROJECTUSER_PROJECT(projectUsers_ID,projects_ID) value(@user4,@project);
commit;
