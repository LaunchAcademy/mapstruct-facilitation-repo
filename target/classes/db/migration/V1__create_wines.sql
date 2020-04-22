CREATE TABLE wines (
  id SERIAL PRIMARY KEY,
  brand_name VARCHAR(255) NOT NULL,
  winery VARCHAR(255) NOT NULL,
  variety VARCHAR(255) NOT NULL,
  price INTEGER NOT NULL,
  is_corked BOOLEAN NOT NULL DEFAULT TRUE,
  origin_city VARCHAR(255),
  origin_province VARCHAR(255),
  origin_country VARCHAR(255),
  volume_ml INTEGER
)