-- Trigger for automatically adding schedule seat
CREATE TRIGGER trg_AfterInsert_Schedule
ON Schedule
AFTER INSERT
AS
BEGIN
    -- Check if trigger is running
    PRINT 'Trigger trg_AfterInsert_Schedule is running';

    -- Insert into SeatSchedule
    INSERT INTO SeatSchedule (SeatID, ScheduleID, Status)
    SELECT 
        Seat.SeatID,
        inserted.ScheduleID,
        'Available'
    FROM Seat
    JOIN inserted ON Seat.ScreenID = inserted.ScreenID;

    -- Check if insert was successful
    PRINT 'SeatSchedule rows inserted: ' + CAST(@@ROWCOUNT AS NVARCHAR(10));
END;
