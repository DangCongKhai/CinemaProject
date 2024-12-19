CREATE TABLE [Account] (
  [AccountID] 	INT IDENTITY(1,1),
  [Email] 		VARCHAR(100),
  [Password] 	VARCHAR(255),
  [Role] 		NVARCHAR(10),
  PRIMARY KEY ([AccountID]),
  CONSTRAINT chk_role 
	CHECK ([Role] IN ('Staff', 'Admin', 'Customer'))
);

CREATE TABLE [Movie] (
  [MovieID] 	INT IDENTITY(1,1),
  [Title] 		NVARCHAR(150),
  [Genre] 		NVARCHAR(50),
  [Duration] 	INT,
  [Actor] 		NVARCHAR(MAX),
  [Description] NVARCHAR(MAX),
  [Image] 		VARBINARY(MAX),
  PRIMARY KEY ([MovieID])
);

CREATE TABLE [Schedule] (
	[ScheduleID] INT             NOT NULL IDENTITY (1, 1),
	[ShowDate]   DATE            NOT NULL,
	[StartTime]  INT             NOT NULL,
	[EndTime]    INT             NOT NULL,
	[Price]      DECIMAL (10, 2) NOT NULL,
	[MovieID]    INT             NOT NULL,
	[ScreenID]   INT             NOT NULL,
	PRIMARY KEY CLUSTERED ([ScheduleID] ASC),
	CONSTRAINT [FK_Schedule_MovieID] FOREIGN KEY ([MovieID]) REFERENCES [Movie] ([MovieID]) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE [Screen] (
  [ScreenID] 		INT IDENTITY(1,1),
  [ScreenNumber] 	INT,
  [TotalSeats] 		INT,
  PRIMARY KEY ([ScreenID])
);

CREATE TABLE [User] (
	[UserID]    INT             IDENTITY (1, 1) NOT NULL,
	[AccountID] INT             NOT NULL,
	[Name]      NVARCHAR (100)  NULL,
	[Gender]    NVARCHAR (10)   NULL,
	[Birthday]  DATE            NULL,
	[Balance]   DECIMAL (10, 2) NULL,
	PRIMARY KEY CLUSTERED ([UserID] ASC),
	CONSTRAINT [chk_gender_customer] 
		CHECK ([Gender]='Other' OR [Gender]='Female' OR [Gender]='Male'),
	CONSTRAINT [FK_User_AccountID] 
		FOREIGN KEY ([AccountID]) 
			REFERENCES [Account]([AccountID])
);

CREATE TABLE [Ticket] ( 
	[TicketID] 		INT IDENTITY(1,1) PRIMARY KEY, 
	[BookingDate] 	DATETIME 		NOT NULL, 
	[BookingStatus] NVARCHAR(10) 	NOT NULL, 
	[TotalPrice] 	DECIMAL(10, 2) 	NOT NULL, 
	[CustomerID] 	INT 			NULL, 
	[StaffID] 		INT 			NULL, 
	[BookingType] 	NVARCHAR(10) 	NOT NULL, 
	CONSTRAINT chk_booking_status 
		CHECK ([BookingStatus] IN ('success', 'fail')), 
	CONSTRAINT chk_booking_type 
		CHECK ([BookingType] IN ('online', 'offline')), 
	CONSTRAINT [FK_Ticket_CustomerID] 
		FOREIGN KEY ([CustomerID]) 
			REFERENCES [User]([UserID]), 
	CONSTRAINT [FK_Ticket_StaffID] 
		FOREIGN KEY ([StaffID]) 
			REFERENCES [User]([UserID]) 
);

CREATE TABLE [Seat] (
  [SeatID] 		INT IDENTITY(1,1),
  [SeatNumber] 	VARCHAR(10),
  [ScreenID] 	INT,
  PRIMARY KEY ([SeatID]),
  CONSTRAINT [FK_Seat_ScreenID]
    FOREIGN KEY ([ScreenID])
      REFERENCES [Screen]([ScreenID])
);


CREATE TABLE [SeatSchedule] (
	[SeatScheduleID] INT           IDENTITY (1, 1) NOT NULL,
	[SeatID]         INT           NOT NULL,
	[ScheduleID]     INT           NOT NULL,
	[Status]         NVARCHAR (15) CONSTRAINT [DEFAULT_SeatSchedule_Status] DEFAULT ('Available') NOT NULL,
	[Expiration]     DATETIME      NULL,
	PRIMARY KEY CLUSTERED ([SeatScheduleID] ASC),
	CONSTRAINT [chk_seat_status] CHECK ([Status]='Reserved' OR [Status]='Available' OR [Status]='Booked'),
	CONSTRAINT [FK_SeatSchedule_ScheduleID] FOREIGN KEY ([ScheduleID]) REFERENCES [Schedule] ([ScheduleID]) ON DELETE CASCADE,
	CONSTRAINT [FK_SeatSchedule_SeatID] FOREIGN KEY ([SeatID]) REFERENCES [Seat] ([SeatID])
);

CREATE TABLE [TicketSeat] (
  [TicketSeatID] 	INT IDENTITY(1,1),
  [TicketID] 		INT,
  [SeatScheduleID] 	INT,
  PRIMARY KEY ([TicketSeatID]),
  CONSTRAINT [FK_TicketSeat_TicketID]
    FOREIGN KEY ([TicketID])
      REFERENCES [Ticket]([TicketID]),
	CONSTRAINT [FK_TicketSeat_SeatSchedule] 
		FOREIGN KEY ([SeatScheduleID]) 
			REFERENCES [SeatSchedule]([SeatScheduleID]) 
				ON DELETE CASCADE
);


CREATE TABLE [FoodDrink] (
	[FoodDrinkID] INT             IDENTITY (1, 1) NOT NULL,
	[Name]        NVARCHAR (50)   NOT NULL,
	[Type]        VARCHAR (50)    NOT NULL,
	[Price]       DECIMAL (10, 2) NOT NULL,
	[Description] NVARCHAR (50)   NULL,
	CONSTRAINT [PK_FoodDrink] PRIMARY KEY CLUSTERED ([FoodDrinkID] ASC),
	CONSTRAINT [CK_FoodDrink_Type] CHECK ([Type]='Food' OR [Type]='Drink')
);
CREATE TABLE [OrderFoodDrink] (
	[OrderFoodDrinkID] INT NOT NULL,
	[TicketID]         INT NOT NULL,
	[FoodDrinkID]      INT NOT NULL,
	[Quantity]         INT NOT NULL,
	[TotalPrice]       INT NOT NULL,
	CONSTRAINT [PK_OrderFoodDrink] PRIMARY KEY CLUSTERED ([OrderFoodDrinkID] ASC),
	CONSTRAINT [FK_OrderFoodDrink_FoodDrink] FOREIGN KEY ([FoodDrinkID]) REFERENCES 	[FoodDrink] ([FoodDrinkID]),
	CONSTRAINT [FK_OrderFoodDrink_Ticket_1] FOREIGN KEY ([TicketID]) REFERENCES 
	[Ticket] ([TicketID])
);

INSERT INTO [Screen] (ScreenNumber, TotalSeats) VALUES
(1, 48), (2, 48), (3, 48), (4, 48)

-- Insert into Seat table for each Screen
DECLARE @screenID INT = 1;
DECLARE @row CHAR(1);
DECLARE @number INT;
DECLARE @seatNumber VARCHAR(3);

-- Loop for each screen
WHILE @screenID <= 4
BEGIN
    SET @row = 'A';
    SET @number = 1;
    
    -- Loop for each row A to F
    WHILE @row <= 'F'
    BEGIN
        -- Loop for each seat number 1 to 8
        WHILE @number <= 8
        BEGIN
            SET @seatNumber = @row + CAST(@number AS VARCHAR(1));
            INSERT INTO [Seat] (SeatNumber, ScreenID)
            VALUES (@seatNumber, @screenID);
            
            SET @number = @number + 1;
        END;
        
        -- Move to the next row
        SET @row = CHAR(ASCII(@row) + 1);
        SET @number = 1;
    END;
    
    SET @screenID = @screenID + 1;
END;
