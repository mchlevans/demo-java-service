SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;


CREATE DATABASE autos WITH TEMPLATE = template0 ENCODING = 'UTF8'; 

ALTER DATABASE autos OWNER TO postgres;

\connect autos

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: vehicle; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.vehicle (
    symboling INTEGER,
    normalized_losses INTEGER,
    make CHARACTER VARYING(50),
    aspiration CHARACTER VARYING(50),
    num_of_doors CHARACTER VARYING(50),
    body_style CHARACTER VARYING(50),
    drive_wheels CHARACTER VARYING(50),
    engine_location CHARACTER VARYING(50),
    wheel_base NUMERIC,
    length NUMERIC,
    width NUMERIC,
    height NUMERIC,
    curb_weight NUMERIC,
    engine_type CHARACTER VARYING(50),
    num_of_cylinders CHARACTER VARYING(50),
    engine_size NUMERIC,
    fuel_system CHARACTER VARYING(50),
    bore NUMERIC,
    stroke NUMERIC,
    compression_ratio NUMERIC,
    horsepower NUMERIC,
    peak_rpm NUMERIC,
    city_mpg NUMERIC,
    highway_mpg NUMERIC,
    price NUMERIC,
    city_L_100km NUMERIC,
    horsepower_binned CHARACTER VARYING(50),
    diesel INTEGER,
    gas INTEGER,
    vehicle_id INTEGER NOT NULL
);

ALTER TABLE public.vehicle OWNER TO postgres;

-- ************************************* insert data from local files *************************************

COPY public.vehicle FROM '/usr/src/app/initdata/automobileEDA.csv' delimiter ',' CSV HEADER;

--
-- Name: actor actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.vehicle
    ADD CONSTRAINT vehicle_pkey PRIMARY KEY (vehicle_id);
