-- Insert random data into TRANSACTION_DATA table
INSERT INTO TRANSACTION_DATA (DATA_KEY, VALUE)
VALUES
    ('key1', 'value1'),
    ('key2', 'value2'),
    ('key3', 'value3'),
    ('key4', 'value4'),
    ('key5', 'value5'),
    ('key6', 'value6'),
    ('key7', 'value7'),
    ('key8', 'value8'),
    ('key9', 'value9'),
    ('key10', 'value10');

-- Insert random data into TRANSACTION table
INSERT INTO TRANSACTION (`TIMESTAMP`, TYPE, ACTOR, TRANSACTION_DATA_ID)
VALUES
    (CURRENT_TIMESTAMP, 'type1', 'actor1', 1), -- Reference TRANSACTION_DATA_ID to match the inserted data
    (CURRENT_TIMESTAMP, 'type2', 'actor2', 2),
    (CURRENT_TIMESTAMP, 'type3', 'actor3', 3),
    (CURRENT_TIMESTAMP, 'type4', 'actor4', 4),
    (CURRENT_TIMESTAMP, 'type5', 'actor5', 5),
    (CURRENT_TIMESTAMP, 'type6', 'actor6', 6),
    (CURRENT_TIMESTAMP, 'type7', 'actor7', 7),
    (CURRENT_TIMESTAMP, 'type8', 'actor8', 8),
    (CURRENT_TIMESTAMP, 'type9', 'actor9', 9),
    (CURRENT_TIMESTAMP, 'type10', 'actor10', 10);
