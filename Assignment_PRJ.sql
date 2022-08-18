﻿create database Assignment_PRJ301
use Assignment_PRJ301

create table Employee(
	eid int identity(1,1) not null primary key,
	ename nvarchar(150) not null
)

create table Product(
	pid int identity(1,1) not null primary key,
	pname nvarchar(150) not null,
	pprice float not null
)

create table TimeSheet(
	tsid int identity(1,1) not null primary key,
	eid int not null foreign key references Employee(eid),
	pid int not null foreign key references Product(pid),
	amount int not null,
	dates date not null
)

create table DayOffType(
	dotid int identity(1,1) not null primary key,
	dottitle nvarchar(150) not null
)

create table DayOff(
	doid int identity(1,1) not null primary key,
	eid int not null foreign key references Employee(eid),
	fromdate datetime not null,
	todate datetime not null,
	dotid int not null foreign key references DayOffType(dotid),
)

insert into Employee values ('mrA'),('mrB'),('mrC'),('mrD'), ('mrE')

insert into Product values ('T-Shirt', 99),('Trousers', 89),('Skirt', 199)

insert into DayOffType values (N'Ốm'), (N'Tai nạn'), (N'Thai sản'), (N'Con ốm'), (N'Nghỉ có phép'), (N'Nghỉ không phép')

insert into DayOff values	(1, '2022-08-11', '2022-08-11', 1), (1, '2022-08-12', '2022-08-12', 5), (1, '2022-08-25', '2022-08-25', 6),
							(2, '2022-08-23', '2022-08-23', 2), (2, '2022-08-24', '2022-08-26', 5), 
							(4, '2022-08-08', '2022-08-09', 5), (4, '2022-08-24', '2022-08-24', 6), 
							(5, '2022-08-15', '2022-08-15', 6), (5, '2022-08-25', '2022-08-25', 5)

insert into TimeSheet values	
								--Nhân Viên mrA
								(1,1,100,'2022-08-01'),(1,2,100,'2022-08-01'),(1,3,100,'2022-08-01'),
								(1,1,100,'2022-08-02'),(1,2,110,'2022-08-02'),(1,3,100,'2022-08-02'),
								(1,1,110,'2022-08-03'),(1,2,100,'2022-08-03'),(1,3,110,'2022-08-03'),
								(1,1,100,'2022-08-04'),(1,2,100,'2022-08-04'),(1,3,100,'2022-08-04'),
								(1,1,90,'2022-08-05'),(1,2,100,'2022-08-05'),(1,3,110,'2022-08-05'),
								(1,1,120,'2022-08-08'),(1,2,100,'2022-08-08'),(1,3,110,'2022-08-08'),
								(1,1,80,'2022-08-09'),(1,2,100,'2022-08-09'),(1,3,110,'2022-08-09'),
								(1,1,100,'2022-08-10'),(1,2,100,'2022-08-10'),(1,3,100,'2022-08-10'),
								(1,1,110,'2022-08-15'),(1,2,110,'2022-08-15'),(1,3,110,'2022-08-15'),
								(1,1,100,'2022-08-16'),(1,2,80,'2022-08-16'),(1,3,100,'2022-08-16'),
								(1,1,100,'2022-08-17'),(1,2,100,'2022-08-17'),(1,3,110,'2022-08-17'),
								(1,1,110,'2022-08-18'),(1,2,80,'2022-08-18'),(1,3,100,'2022-08-18'),
								(1,1,100,'2022-08-19'),(1,2,100,'2022-08-19'),(1,3,100,'2022-08-19'),
								(1,1,100,'2022-08-22'),(1,2,110,'2022-08-22'),(1,3,100,'2022-08-22'),
								(1,1,100,'2022-08-23'),(1,2,100,'2022-08-23'),(1,3,100,'2022-08-23'),
								(1,1,100,'2022-08-24'),(1,2,120,'2022-08-24'),(1,3,110,'2022-08-24'),
								(1,1,110,'2022-08-26'),(1,2,90,'2022-08-26'),(1,3,100,'2022-08-26'),
								(1,1,100,'2022-08-29'),(1,2,80,'2022-08-29'),(1,3,120,'2022-08-29'),
								(1,1,100,'2022-08-30'),(1,2,100,'2022-08-30'),(1,3,110,'2022-08-30'),
								(1,1,100,'2022-08-31'),(1,2,80,'2022-08-31'),(1,3,100,'2022-08-31'),
								
								--Nhân Viên mrB
								(2,1,110,'2022-08-01'),(2,2,100,'2022-08-01'),(2,3,100,'2022-08-01'),
								(2,1,100,'2022-08-02'),(2,2,110,'2022-08-02'),(2,3,100,'2022-08-02'),
								(2,1,100,'2022-08-03'),(2,2,90,'2022-08-03'),(2,3,110,'2022-08-03'),
								(2,1,100,'2022-08-04'),(2,2,100,'2022-08-04'),(2,3,100,'2022-08-04'),
								(2,1,100,'2022-08-05'),(2,2,110,'2022-08-05'),(2,3,100,'2022-08-05'),
								(2,1,100,'2022-08-08'),(2,2,100,'2022-08-08'),(2,3,90,'2022-08-08'),
								(2,1,100,'2022-08-09'),(2,2,110,'2022-08-09'),(2,3,100,'2022-08-09'),
								(2,1,100,'2022-08-10'),(2,2,90,'2022-08-10'),(2,3,100,'2022-08-10'),
								(2,1,100,'2022-08-11'),(2,2,100,'2022-08-11'),(2,3,100,'2022-08-11'),
								(2,1,100,'2022-08-12'),(2,2,100,'2022-08-12'),(2,3,100,'2022-08-12'),
								(2,1,100,'2022-08-15'),(2,2,100,'2022-08-15'),(2,3,110,'2022-08-15'),
								(2,1,100,'2022-08-16'),(2,2,110,'2022-08-16'),(2,3,100,'2022-08-16'),
								(2,1,100,'2022-08-17'),(2,2,90,'2022-08-17'),(2,3,100,'2022-08-17'),
								(2,1,100,'2022-08-18'),(2,2,100,'2022-08-18'),(2,3,100,'2022-08-18'),
								(2,1,100,'2022-08-19'),(2,2,100,'2022-08-19'),(2,3,100,'2022-08-19'),
								(2,1,110,'2022-08-22'),(2,2,90,'2022-08-22'),(2,3,100,'2022-08-22'),
								(2,1,100,'2022-08-29'),(2,2,100,'2022-08-29'),(2,3,100,'2022-08-29'),
								(2,1,110,'2022-08-30'),(2,2,90,'2022-08-30'),(2,3,100,'2022-08-30'),
								(2,1,100,'2022-08-31'),(2,2,100,'2022-08-31'),(2,3,110,'2022-08-31'),
							
								--Nhân Viên mrC
								(3,1,80,'2022-08-01'),(3,2,100,'2022-08-01'),(3,3,100,'2022-08-01'),
								(3,1,100,'2022-08-02'),(3,2,120,'2022-08-02'),(3,3,100,'2022-08-02'),
								(3,1,100,'2022-08-03'),(3,2,80,'2022-08-03'),(3,3,100,'2022-08-03'),
								(3,1,100,'2022-08-04'),(3,2,120,'2022-08-04'),(3,3,100,'2022-08-04'),
								(3,1,100,'2022-08-05'),(3,2,100,'2022-08-05'),(3,3,100,'2022-08-05'),
								(3,1,100,'2022-08-10'),(3,2,100,'2022-08-10'),(3,3,80,'2022-08-10'),
								(3,1,100,'2022-08-11'),(3,2,100,'2022-08-11'),(3,3,120,'2022-08-11'),
								(3,1,80,'2022-08-12'),(3,2,100,'2022-08-12'),(3,3,100,'2022-08-12'),
								(3,1,100,'2022-08-15'),(3,2,100,'2022-08-15'),(3,3,100,'2022-08-15'),
								(3,1,120,'2022-08-16'),(3,2,100,'2022-08-16'),(3,3,100,'2022-08-16'),
								(3,1,80,'2022-08-17'),(3,2,100,'2022-08-17'),(3,3,100,'2022-08-17'),
								(3,1,100,'2022-08-18'),(3,2,100,'2022-08-18'),(3,3,100,'2022-08-18'),
								(3,1,100,'2022-08-19'),(3,2,100,'2022-08-19'),(3,3,120,'2022-08-19'),
								(3,1,100,'2022-08-22'),(3,2,100,'2022-08-22'),(3,3,80,'2022-08-22'),
								(3,1,120,'2022-08-23'),(3,2,100,'2022-08-23'),(3,3,100,'2022-08-23'),
								(3,1,100,'2022-08-25'),(3,2,80,'2022-08-25'),(3,3,100,'2022-08-25'),
								(3,1,100,'2022-08-26'),(3,2,100,'2022-08-26'),(3,3,100,'2022-08-26'),
								(3,1,80,'2022-08-29'),(3,2,100,'2022-08-29'),(3,3,100,'2022-08-29'),
								(3,1,100,'2022-08-30'),(3,2,100,'2022-08-30'),(3,3,120,'2022-08-30'),
								(3,1,100,'2022-08-31'),(3,2,80,'2022-08-31'),(3,3,100,'2022-08-31'),
								
								--Nhân Viên mrD
								(4,1,90,'2022-08-01'),(4,2,120,'2022-08-01'),(4,3,100,'2022-08-01'),
								(4,1,100,'2022-08-02'),(4,2,90,'2022-08-02'),(4,3,100,'2022-08-02'),
								(4,1,100,'2022-08-03'),(4,2,100,'2022-08-03'),(4,3,120,'2022-08-03'),
								(4,1,100,'2022-08-04'),(4,2,90,'2022-08-04'),(4,3,100,'2022-08-04'),
								(4,1,120,'2022-08-05'),(4,2,100,'2022-08-05'),(4,3,100,'2022-08-05'),
								(4,1,100,'2022-08-10'),(4,2,90,'2022-08-10'),(4,3,120,'2022-08-10'),
								(4,1,100,'2022-08-11'),(4,2,120,'2022-08-11'),(4,3,100,'2022-08-11'),
								(4,1,100,'2022-08-12'),(4,2,100,'2022-08-12'),(4,3,120,'2022-08-12'),
								(4,1,100,'2022-08-15'),(4,2,120,'2022-08-15'),(4,3,90,'2022-08-15'),
								(4,1,100,'2022-08-16'),(4,2,100,'2022-08-16'),(4,3,100,'2022-08-16'),
								(4,1,90,'2022-08-17'),(4,2,120,'2022-08-17'),(4,3,100,'2022-08-17'),
								(4,1,100,'2022-08-18'),(4,2,100,'2022-08-18'),(4,3,100,'2022-08-18'),
								(4,1,100,'2022-08-19'),(4,2,90,'2022-08-19'),(4,3,100,'2022-08-19'),
								(4,1,100,'2022-08-22'),(4,2,100,'2022-08-22'),(4,3,120,'2022-08-22'),
								(4,1,120,'2022-08-23'),(4,2,100,'2022-08-23'),(4,3,100,'2022-08-23'),
								(4,1,100,'2022-08-25'),(4,2,100,'2022-08-25'),(4,3,90,'2022-08-25'),
								(4,1,100,'2022-08-26'),(4,2,100,'2022-08-26'),(4,3,100,'2022-08-26'),
								(4,1,90,'2022-08-29'),(4,2,100,'2022-08-29'),(4,3,100,'2022-08-29'),
								(4,1,100,'2022-08-30'),(4,2,100,'2022-08-30'),(4,3,120,'2022-08-30'),
								(4,1,100,'2022-08-31'),(4,2,100,'2022-08-31'),(4,3,90,'2022-08-31'),
								
								--Nhân Viên mrE
								(5,1,110,'2022-08-01'),(5,2,120,'2022-08-01'),(5,3,100,'2022-08-01'),
								(5,1,100,'2022-08-02'),(5,2,120,'2022-08-02'),(5,3,90,'2022-08-02'),
								(5,1,100,'2022-08-03'),(5,2,110,'2022-08-03'),(5,3,90,'2022-08-03'),
								(5,1,100,'2022-08-04'),(5,2,100,'2022-08-04'),(5,3,100,'2022-08-04'),
								(5,1,90,'2022-08-05'),(5,2,110,'2022-08-05'),(5,3,100,'2022-08-05'),
								(5,1,100,'2022-08-08'),(5,2,120,'2022-08-08'),(5,3,90,'2022-08-08'),
								(5,1,100,'2022-08-09'),(5,2,90,'2022-08-09'),(5,3,100,'2022-08-09'),
								(5,1,100,'2022-08-10'),(5,2,120,'2022-08-10'),(5,3,120,'2022-08-10'),
								(5,1,100,'2022-08-11'),(5,2,110,'2022-08-11'),(5,3,100,'2022-08-11'),
								(5,1,100,'2022-08-12'),(5,2,120,'2022-08-12'),(5,3,100,'2022-08-12'),
								(5,1,100,'2022-08-16'),(5,2,90,'2022-08-16'),(5,3,100,'2022-08-16'),
								(5,1,100,'2022-08-17'),(5,2,100,'2022-08-17'),(5,3,100,'2022-08-17'),
								(5,1,120,'2022-08-18'),(5,2,100,'2022-08-18'),(5,3,110,'2022-08-18'),
								(5,1,100,'2022-08-19'),(5,2,100,'2022-08-19'),(5,3,120,'2022-08-19'),
								(5,1,110,'2022-08-22'),(5,2,100,'2022-08-22'),(5,3,90,'2022-08-22'),
								(5,1,120,'2022-08-23'),(5,2,90,'2022-08-23'),(5,3,100,'2022-08-23'),
								(5,1,100,'2022-08-24'),(5,2,100,'2022-08-24'),(5,3,120,'2022-08-24'),
								(5,1,100,'2022-08-29'),(5,2,90,'2022-08-29'),(5,3,110,'2022-08-29'),
								(5,1,100,'2022-08-30'),(5,2,100,'2022-08-30'),(5,3,100,'2022-08-30'),
								(5,1,100,'2022-08-31'),(5,2,120,'2022-08-31'),(5,3,110,'2022-08-31')
