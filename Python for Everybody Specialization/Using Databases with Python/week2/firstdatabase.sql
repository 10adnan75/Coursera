CREATE TABLE Ages ( 
  name VARCHAR(128), 
  age INTEGER
)

DELETE FROM Ages;
INSERT INTO Ages (name, age) VALUES ('John', 42);
INSERT INTO Ages (name, age) VALUES ('Fred', 75);
INSERT INTO Ages (name, age) VALUES ('Alex', 19);
INSERT INTO Ages (name, age) VALUES ('Ginger', 34);

SELECT hex(name || age) AS X FROM Ages ORDER BY X
