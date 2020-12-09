--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.20
-- Dumped by pg_dump version 12.4

-- Started on 2020-12-09 13:21:54 UTC

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

--
-- TOC entry 185 (class 1259 OID 24596)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    nom character varying(100),
    prenom character varying(100),
    email character varying(100),
    login character varying(100),
    password character varying(100),
    profilepic character varying(200)
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 2120 (class 0 OID 24596)
-- Dependencies: 185
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, nom, prenom, email, login, password, profilepic) FROM stdin;
1	admin	admin	admin@info	admin	admin	./src/edu/utils/BHamza/profile.png
\.


--
-- TOC entry 2002 (class 2606 OID 24603)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


-- Completed on 2020-12-09 13:21:54 UTC

--
-- PostgreSQL database dump complete
--

