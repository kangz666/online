USE [master]
GO
/****** Object:  Database [online_shopping]    Script Date: 01/03/2021 16:40:21 ******/
CREATE DATABASE [online_shopping] ON  PRIMARY 
( NAME = N'online_shopping', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\online_shopping.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'online_shopping_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL10_50.MSSQLSERVER\MSSQL\DATA\online_shopping_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [online_shopping] SET COMPATIBILITY_LEVEL = 100
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [online_shopping].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [online_shopping] SET ANSI_NULL_DEFAULT OFF
GO
ALTER DATABASE [online_shopping] SET ANSI_NULLS OFF
GO
ALTER DATABASE [online_shopping] SET ANSI_PADDING OFF
GO
ALTER DATABASE [online_shopping] SET ANSI_WARNINGS OFF
GO
ALTER DATABASE [online_shopping] SET ARITHABORT OFF
GO
ALTER DATABASE [online_shopping] SET AUTO_CLOSE OFF
GO
ALTER DATABASE [online_shopping] SET AUTO_CREATE_STATISTICS ON
GO
ALTER DATABASE [online_shopping] SET AUTO_SHRINK OFF
GO
ALTER DATABASE [online_shopping] SET AUTO_UPDATE_STATISTICS ON
GO
ALTER DATABASE [online_shopping] SET CURSOR_CLOSE_ON_COMMIT OFF
GO
ALTER DATABASE [online_shopping] SET CURSOR_DEFAULT  GLOBAL
GO
ALTER DATABASE [online_shopping] SET CONCAT_NULL_YIELDS_NULL OFF
GO
ALTER DATABASE [online_shopping] SET NUMERIC_ROUNDABORT OFF
GO
ALTER DATABASE [online_shopping] SET QUOTED_IDENTIFIER OFF
GO
ALTER DATABASE [online_shopping] SET RECURSIVE_TRIGGERS OFF
GO
ALTER DATABASE [online_shopping] SET  DISABLE_BROKER
GO
ALTER DATABASE [online_shopping] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO
ALTER DATABASE [online_shopping] SET DATE_CORRELATION_OPTIMIZATION OFF
GO
ALTER DATABASE [online_shopping] SET TRUSTWORTHY OFF
GO
ALTER DATABASE [online_shopping] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO
ALTER DATABASE [online_shopping] SET PARAMETERIZATION SIMPLE
GO
ALTER DATABASE [online_shopping] SET READ_COMMITTED_SNAPSHOT OFF
GO
ALTER DATABASE [online_shopping] SET HONOR_BROKER_PRIORITY OFF
GO
ALTER DATABASE [online_shopping] SET  READ_WRITE
GO
ALTER DATABASE [online_shopping] SET RECOVERY FULL
GO
ALTER DATABASE [online_shopping] SET  MULTI_USER
GO
ALTER DATABASE [online_shopping] SET PAGE_VERIFY CHECKSUM
GO
ALTER DATABASE [online_shopping] SET DB_CHAINING OFF
GO
EXEC sys.sp_db_vardecimal_storage_format N'online_shopping', N'ON'
GO
USE [online_shopping]
GO
/****** Object:  Table [dbo].[user_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[user_table](
	[user_number] [nchar](10) NOT NULL,
	[user_name] [nchar](10) NOT NULL,
	[user_password] [nchar](10) NOT NULL,
	[user_id] [nvarchar](50) NOT NULL,
	[user_address] [varchar](50) NULL,
	[user_phone] [nvarchar](50) NOT NULL,
	[user_email] [nvarchar](50) NULL,
	[user_qq] [nvarchar](50) NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[order_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[order_table](
	[order_number] [nchar](255) NOT NULL,
	[information_number] [nchar](255) NOT NULL,
	[goods_price] [nchar](255) NOT NULL,
	[user_number] [nchar](255) NOT NULL,
	[user_name] [nchar](255) NOT NULL,
	[user_address] [varchar](255) NOT NULL,
	[user_phone] [varchar](50) NOT NULL,
	[status_number] [nchar](10) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[order_status_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[order_status_table](
	[status_number] [varchar](50) NOT NULL,
	[order_status] [nchar](10) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[information_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[information_table](
	[information_number] [nchar](10) NOT NULL,
	[information_name] [nchar](10) NOT NULL,
	[category_number] [nchar](10) NOT NULL,
	[information_sum] [int] NOT NULL,
	[information_price] [float] NOT NULL,
	[information_picture] [nvarchar](50) NULL,
	[information_text] [nchar](10) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[category_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category_table](
	[category_number] [nchar](10) NOT NULL,
	[category_name] [nchar](10) NOT NULL,
 CONSTRAINT [PK_category_type] PRIMARY KEY CLUSTERED 
(
	[category_number] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[cart_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cart_table](
	[information_number] [nchar](10) NOT NULL,
	[information_name] [nchar](10) NOT NULL,
	[user_number] [nchar](10) NOT NULL,
	[information_price] [float] NOT NULL,
	[sum] [int] NOT NULL,
	[money] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[admin_table]    Script Date: 01/03/2021 16:40:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[admin_table](
	[admin_number] [nchar](10) NOT NULL,
	[admin_password] [nchar](10) NOT NULL,
	[admin_name] [nchar](10) NOT NULL,
	[admin_phone] [varchar](15) NOT NULL
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
