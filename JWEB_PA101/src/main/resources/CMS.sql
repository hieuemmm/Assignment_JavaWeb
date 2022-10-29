USE master
GO
CREATE DATABASE CMS
GO
USE CMS
GO
create table content(
	[id_content] int IDENTITY(1,1) primary key 
      ,[title] nvarchar(50)
      ,[brief] nvarchar(150)
      ,[content] nvarchar(1000)
      ,[created_date] nvarchar(50)
      ,[update_time] nvarchar(50)
      ,[sort] nvarchar(50)
      ,[author_id] nvarchar(50)
)

create table member
([id_member] int IDENTITY(1,1) primary key 
      ,[first_name] nvarchar(30)
      ,[last_name]nvarchar(30)
      ,[user_name]nvarchar(50)
      ,[password]nvarchar(30)
      ,[phone]nvarchar(50)
      ,[email]nvarchar(50)
      ,[description]nvarchar(200)
      ,[created_date]nvarchar(50)
      ,[update_time]nvarchar(50)
,[id_content] int FOREIGN KEY  REFERENCES content ([id_content]))
