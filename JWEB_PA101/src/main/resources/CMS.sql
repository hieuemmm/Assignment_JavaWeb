USE master
GO
CREATE DATABASE CMS
GO
USE CMS
GO
CREATE TABLE member (
	[user_name] NVARCHAR(50) PRIMARY KEY,
	[first_name] NVARCHAR(30),
	[last_name] NVARCHAR(30),
    [password] NVARCHAR(30),
    [phone] NVARCHAR(50),
    [email] NVARCHAR(50),
    [description] NVARCHAR(200),
    [created_date] NVARCHAR(50),
)
GO
CREATE TABLE content(
	[id_content] int IDENTITY(1,1) PRIMARY KEY,
    [title] NVARCHAR(50),
    [brief] NVARCHAR(150),
    [content] NVARCHAR(1000),
    [created_date] NVARCHAR(50),
    [update_time] NVARCHAR(50),
    [user_name] NVARCHAR(50) FOREIGN KEY REFERENCES member ([user_name])
)