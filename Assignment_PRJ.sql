create database Assignment_PRJ301
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
	dottitle nvarchar(150) not null,
	dotnotation nvarchar(150) not null
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

insert into DayOffType values	(N'Đi làm', N'L'), (N'Ốm,điều dưỡng', N'Ô'), (N'Con ốm', N'CÔ'), 
								(N'Thai sản', N'TS'), (N'Tai nạn', N'T'), (N'Chủ nhật', N'CN'), 
								(N'Nghỉ lễ', N'NL'), (N'Nghỉ bù', N'NB'), (N'Nghỉ phép', N'NP'),
								(N'Nghỉ nữa ngày không lương', N'1/2K'), (N'Nghỉ không lương', N'K'),
								(N'Ngừng việc', N'N'),(N'Nghỉ nửa ngày tính phép', N'1/2P'),
								(N'Làm nửa ngày công', N'N')

insert into DayOff values	(1, '2022-08-11', '2022-08-12', 9), (1, '2022-08-25', '2022-08-25', 2),
							(2, '2022-08-23', '2022-08-23', 2), (2, '2022-08-24', '2022-08-26', 9), 
							(4, '2022-08-08', '2022-08-09', 8), (4, '2022-08-24', '2022-08-24',9), 
							(5, '2022-08-15', '2022-08-15', 2), (5, '2022-08-25', '2022-08-26', 9)
							
insert into TimeSheet values
								--Nhân Viên mrA
								(1,1,100,'2022-08-01'),(1,2,110,'2022-08-02'),(1,3,110,'2022-08-03'),
								(1,3,100,'2022-08-04'),(1,2,100,'2022-08-05'),(1,1,120,'2022-08-08'),
								(1,2,100,'2022-08-09'),(1,1,100,'2022-08-10'),(1,3,110,'2022-08-15'),
								(1,3,100,'2022-08-16'),(1,1,100,'2022-08-17'),(1,2,80,'2022-08-18'),
								(1,1,100,'2022-08-19'),(1,3,100,'2022-08-22'),(1,2,100,'2022-08-23'),
								(1,2,120,'2022-08-24'),(1,1,110,'2022-08-26'),(1,3,120,'2022-08-29'),
								(1,3,110,'2022-08-30'),(1,2,80,'2022-08-31'),
								
								--Nhân Viên mrB
								(2,3,100,'2022-08-01'),(2,2,110,'2022-08-02'),(2,1,100,'2022-08-03'),
								(2,1,100,'2022-08-04'),(2,2,110,'2022-08-05'),(2,3,90,'2022-08-08'),
								(2,3,100,'2022-08-09'),(2,2,90,'2022-08-10'),(2,1,100,'2022-08-11'),
								(2,3,100,'2022-08-12'),(2,2,100,'2022-08-15'),(2,1,100,'2022-08-16'),
								(2,1,100,'2022-08-17'),(2,3,100,'2022-08-18'),(2,2,100,'2022-08-19'),
								(2,2,100,'2022-08-22'),(2,2,100,'2022-08-29'),(2,1,110,'2022-08-30'),
								(2,3,110,'2022-08-31'),
							
								--Nhân Viên mrC
								(3,1,80,'2022-08-01'),(3,2,120,'2022-08-02'),(3,3,100,'2022-08-03'),
								(3,1,100,'2022-08-04'),(3,2,100,'2022-08-05'),(3,3,100,'2022-08-08'),
								(3,3,80,'2022-08-09'),(3,2,100,'2022-08-10'),(3,1,100,'2022-08-11'),
								(3,3,100,'2022-08-12'),(3,2,100,'2022-08-15'),(3,1,120,'2022-08-16'),
								(3,1,80,'2022-08-17'),(3,3,120,'2022-08-18'),(3,3,120,'2022-08-19'),
								(3,3,80,'2022-08-22'),(3,1,120,'2022-08-23'),(3,2,80,'2022-08-24'),
								(3,3,100,'2022-08-25'),(3,1,100,'2022-08-26'),(3,2,100,'2022-08-29'),
								(3,1,100,'2022-08-30'),(3,3,100,'2022-08-31'),
								
								--Nhân Viên mrD
								(4,3,100,'2022-08-01'),(4,1,100,'2022-08-02'),(4,2,100,'2022-08-03'),
								(4,2,90,'2022-08-04'),(4,3,100,'2022-08-05'),(4,1,100,'2022-08-10'),
								(4,3,100,'2022-08-11'),(4,2,100,'2022-08-12'),(4,3,90,'2022-08-15'),
								(4,1,100,'2022-08-16'),(4,1,90,'2022-08-17'),(4,2,100,'2022-08-18'),
								(4,3,100,'2022-08-19'),(4,3,120,'2022-08-22'),(4,2,100,'2022-08-23'),
								(4,1,100,'2022-08-25'),(4,2,100,'2022-08-26'),(4,3,100,'2022-08-29'),
								(4,1,100,'2022-08-30'),(4,2,100,'2022-08-31'),
								
								--Nhân Viên mrE
								(5,2,120,'2022-08-01'),(5,3,90,'2022-08-02'),(5,1,100,'2022-08-03'),
								(5,2,100,'2022-08-04'),(5,3,100,'2022-08-05'),(5,2,120,'2022-08-08'),
								(5,1,100,'2022-08-09'),(5,2,120,'2022-08-10'),(5,3,100,'2022-08-11'),
								(5,1,100,'2022-08-12'),(5,3,100,'2022-08-16'),(5,3,100,'2022-08-17'),
								(5,2,100,'2022-08-18'),(5,1,100,'2022-08-19'),(5,1,110,'2022-08-22'),
								(5,2,90,'2022-08-23'),(5,3,120,'2022-08-24'),(5,1,100,'2022-08-29'),
								(5,3,100,'2022-08-30'),(5,2,120,'2022-08-31')
