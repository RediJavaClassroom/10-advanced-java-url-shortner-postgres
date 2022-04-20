DROP TABLE IF EXISTS short_links;

CREATE TABLE short_links (
    key             varchar(8) NOT NULL PRIMARY KEY,
    original_url    varchar(1024) NOT NULL
);
