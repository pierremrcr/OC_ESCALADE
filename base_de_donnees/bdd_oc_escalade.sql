--
-- PostgreSQL database dump
--

-- Dumped from database version 10.5
-- Dumped by pg_dump version 11.1

-- Started on 2019-03-28 20:25:57 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 203 (class 1259 OID 41715)
-- Name: adresse; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adresse (
    id integer NOT NULL,
    rue character varying,
    numero integer,
    codepostal character varying NOT NULL,
    ville character varying NOT NULL,
    departement character varying NOT NULL
);


ALTER TABLE public.adresse OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 41713)
-- Name: adresse_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.adresse_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.adresse_id_seq OWNER TO postgres;

--
-- TOC entry 3244 (class 0 OID 0)
-- Dependencies: 202
-- Name: adresse_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.adresse_id_seq OWNED BY public.adresse.id;


--
-- TOC entry 199 (class 1259 OID 41693)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    id integer NOT NULL,
    contenu character varying NOT NULL,
    date timestamp(4) with time zone NOT NULL,
    utilisateur_id integer NOT NULL,
    spot_id integer
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 41691)
-- Name: commentaire_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_id_seq OWNER TO postgres;

--
-- TOC entry 3245 (class 0 OID 0)
-- Dependencies: 198
-- Name: commentaire_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.commentaire_id_seq OWNED BY public.commentaire.id;


--
-- TOC entry 216 (class 1259 OID 50074)
-- Name: commentaire_topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.commentaire_topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.commentaire_topo_id_seq OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 50066)
-- Name: commentaire_topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire_topo (
    id integer DEFAULT nextval('public.commentaire_topo_id_seq'::regclass) NOT NULL,
    contenu character varying NOT NULL,
    date timestamp with time zone NOT NULL,
    utilisateur_id integer NOT NULL,
    topo_id integer NOT NULL
);


ALTER TABLE public.commentaire_topo OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 41759)
-- Name: longueur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.longueur (
    id integer NOT NULL,
    nom character varying NOT NULL,
    nombredepoints integer NOT NULL,
    cotation character varying NOT NULL,
    hauteur character varying NOT NULL,
    voie_id integer NOT NULL
);


ALTER TABLE public.longueur OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 41757)
-- Name: longueur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.longueur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.longueur_id_seq OWNER TO postgres;

--
-- TOC entry 3246 (class 0 OID 0)
-- Dependencies: 210
-- Name: longueur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.longueur_id_seq OWNED BY public.longueur.id;


--
-- TOC entry 214 (class 1259 OID 41775)
-- Name: resatopo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.resatopo (
    id integer NOT NULL,
    datedebut date NOT NULL,
    datefin date NOT NULL,
    topo_id integer NOT NULL,
    utilisateur_id integer NOT NULL
);


ALTER TABLE public.resatopo OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 41773)
-- Name: resatopo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.resatopo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.resatopo_id_seq OWNER TO postgres;

--
-- TOC entry 3247 (class 0 OID 0)
-- Dependencies: 213
-- Name: resatopo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.resatopo_id_seq OWNED BY public.resatopo.id;


--
-- TOC entry 207 (class 1259 OID 41737)
-- Name: secteur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secteur (
    id integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL,
    spot_id integer NOT NULL
);


ALTER TABLE public.secteur OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 41735)
-- Name: secteur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.secteur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.secteur_id_seq OWNER TO postgres;

--
-- TOC entry 3248 (class 0 OID 0)
-- Dependencies: 206
-- Name: secteur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.secteur_id_seq OWNED BY public.secteur.id;


--
-- TOC entry 205 (class 1259 OID 41726)
-- Name: spot; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot (
    id integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL,
    adresse_id integer NOT NULL,
    region character varying
);


ALTER TABLE public.spot OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 41724)
-- Name: spot_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.spot_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.spot_id_seq OWNER TO postgres;

--
-- TOC entry 3249 (class 0 OID 0)
-- Dependencies: 204
-- Name: spot_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.spot_id_seq OWNED BY public.spot.id;


--
-- TOC entry 212 (class 1259 OID 41768)
-- Name: spot_topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.spot_topo (
    spot_id integer NOT NULL,
    topo_id integer NOT NULL
);


ALTER TABLE public.spot_topo OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 41704)
-- Name: topo; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.topo (
    id integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL,
    proprietaire_id integer NOT NULL
);


ALTER TABLE public.topo OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 41702)
-- Name: topo_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.topo_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.topo_id_seq OWNER TO postgres;

--
-- TOC entry 3250 (class 0 OID 0)
-- Dependencies: 200
-- Name: topo_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.topo_id_seq OWNED BY public.topo.id;


--
-- TOC entry 197 (class 1259 OID 41682)
-- Name: utilisateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.utilisateur (
    id integer NOT NULL,
    nom character varying NOT NULL,
    prenom character varying NOT NULL,
    adressemail character varying NOT NULL,
    motdepasse character varying NOT NULL,
    presentation character varying NOT NULL,
    niveau character varying NOT NULL
);


ALTER TABLE public.utilisateur OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 41680)
-- Name: utilisateur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.utilisateur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.utilisateur_id_seq OWNER TO postgres;

--
-- TOC entry 3251 (class 0 OID 0)
-- Dependencies: 196
-- Name: utilisateur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.utilisateur_id_seq OWNED BY public.utilisateur.id;


--
-- TOC entry 209 (class 1259 OID 41748)
-- Name: voie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.voie (
    id integer NOT NULL,
    nom character varying NOT NULL,
    description character varying NOT NULL,
    secteur_id integer NOT NULL
);


ALTER TABLE public.voie OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 41746)
-- Name: voie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.voie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.voie_id_seq OWNER TO postgres;

--
-- TOC entry 3252 (class 0 OID 0)
-- Dependencies: 208
-- Name: voie_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.voie_id_seq OWNED BY public.voie.id;


--
-- TOC entry 3057 (class 2604 OID 41718)
-- Name: adresse id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse ALTER COLUMN id SET DEFAULT nextval('public.adresse_id_seq'::regclass);


--
-- TOC entry 3055 (class 2604 OID 41696)
-- Name: commentaire id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire ALTER COLUMN id SET DEFAULT nextval('public.commentaire_id_seq'::regclass);


--
-- TOC entry 3061 (class 2604 OID 41762)
-- Name: longueur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur ALTER COLUMN id SET DEFAULT nextval('public.longueur_id_seq'::regclass);


--
-- TOC entry 3062 (class 2604 OID 41778)
-- Name: resatopo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resatopo ALTER COLUMN id SET DEFAULT nextval('public.resatopo_id_seq'::regclass);


--
-- TOC entry 3059 (class 2604 OID 41740)
-- Name: secteur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur ALTER COLUMN id SET DEFAULT nextval('public.secteur_id_seq'::regclass);


--
-- TOC entry 3058 (class 2604 OID 41729)
-- Name: spot id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot ALTER COLUMN id SET DEFAULT nextval('public.spot_id_seq'::regclass);


--
-- TOC entry 3056 (class 2604 OID 41707)
-- Name: topo id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo ALTER COLUMN id SET DEFAULT nextval('public.topo_id_seq'::regclass);


--
-- TOC entry 3054 (class 2604 OID 41685)
-- Name: utilisateur id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur ALTER COLUMN id SET DEFAULT nextval('public.utilisateur_id_seq'::regclass);


--
-- TOC entry 3060 (class 2604 OID 41751)
-- Name: voie id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie ALTER COLUMN id SET DEFAULT nextval('public.voie_id_seq'::regclass);


--
-- TOC entry 3225 (class 0 OID 41715)
-- Dependencies: 203
-- Data for Name: adresse; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adresse (id, rue, numero, codepostal, ville, departement) FROM stdin;
1	\N	\N	05340	Pelvoux	Hautes-Alpes
2	\N	\N	64260	Arudy	Pyrénées-Atlantiques 
3	\N	\N	20137	Porto-Vecchio	Corse-du-Sud
9	Cite paradis	7	87000	LIMOGES	Haute Vienne
10		0	17000	La Rochelle	Charente Maritime
\.


--
-- TOC entry 3221 (class 0 OID 41693)
-- Dependencies: 199
-- Data for Name: commentaire; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire (id, contenu, date, utilisateur_id, spot_id) FROM stdin;
2	Super site !	2019-02-25 14:45:19.869+01	1	2
3	Test commentaire	2019-03-21 20:31:42.674+01	1	2
\.


--
-- TOC entry 3237 (class 0 OID 50066)
-- Dependencies: 215
-- Data for Name: commentaire_topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.commentaire_topo (id, contenu, date, utilisateur_id, topo_id) FROM stdin;
1	Super Topo !	2019-02-25 14:45:19.869+01	1	1
4	topo bien détaillé 	2019-02-26 15:03:55.231+01	1	1
\.


--
-- TOC entry 3233 (class 0 OID 41759)
-- Dependencies: 211
-- Data for Name: longueur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.longueur (id, nom, nombredepoints, cotation, hauteur, voie_id) FROM stdin;
1	1ère longueur	5	6c	20	1
2	2ème longueur	4	7a	18	1
3	1ère longueur	5	6a	24	2
4	2ème longueur	5	6b	20	2
5	1ère longueur	4	6c	22	3
6	1ère longueur	5	7b	21	4
7	2ème longueur	6	7a	16	4
8	Longueur principale	8	8b	23	5
9	Longueur principale	6	8a	25	6
10	Longueur principale	7	8b	27	7
11	Longueur principale	6	8a	23	8
12	Longueur principale	7	7c	26	9
13	Longueur principale	5	7b	24	10
14	1ère longueur	4	6b	17	11
15	2ème longueur	5	6c	15	11
16	Longueur principale	7	8a	23	12
19	Longueur de LR	5	6b	25	19
\.


--
-- TOC entry 3236 (class 0 OID 41775)
-- Dependencies: 214
-- Data for Name: resatopo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.resatopo (id, datedebut, datefin, topo_id, utilisateur_id) FROM stdin;
\.


--
-- TOC entry 3229 (class 0 OID 41737)
-- Dependencies: 207
-- Data for Name: secteur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secteur (id, nom, description, spot_id) FROM stdin;
1	Le Blanc d'Argent	Secteur d'Ailefroide	1
2	Le plateau de Mille Vaches	Secteur d'Ailefroide	1
3	La cuvette du Chamois	Secteur d'Arudy	2
4	Le Mont Perdu	Secteur d'Arudy	2
5	Rizanese	Secteur des Aiguilles de Bavella	3
6	Notre Dames des Neiges	Secteur des Aiguilles de Bavella	3
21	Secteur de La Rochelle 	Description secteur LR	10
\.


--
-- TOC entry 3227 (class 0 OID 41726)
-- Dependencies: 205
-- Data for Name: spot; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spot (id, nom, description, adresse_id, region) FROM stdin;
2	Arudy	La vallée d’Ossau est l’une des trois grandes vallées de montagne de la région béarnaise. Elle s’étire du nord au sud depuis Pau jusqu’au col du Pourtalet, à la frontière espagnole, sous le regard bienveillant du pic du Midi d’Ossau (2884 mètres), à la silhouette bicéphale si caractéristique. En partie basse se trouve le site d’escalade d’Arudy, lieu historique de la grimpe en vallée d’Ossau. «On ne sait pas exactement à quand remonte la pratique de l’escalade arudienne. En 1958, de jeunes grimpeurs ont tenté d’escalader la Pointe centrale de Sesto (la grande pointe blanche) et en 1959, sont apparus les premiers tracés. Dans les années 1970, quelques voies furent pré-équipées depuis le haut des sommets», lit-on dans un texte publié par Ville d’Arudy - Maison d’Ossau, en 1999. «Depuis, des gens viennent du monde entier s’entraîner sur ce rocher-école», lit-on ensuite sur le site Internet de la mairie d’Arudy. Si nous osons relayer telle quelle cette information sans chercher à la vérifier, ajoutons une possible explication à ce succès planétaire: un rocher calcaire très varié où quelque 230 voies offrent un panel de difficultés allant de l’initiation au haut niveau. De quoi drainer toute la planète grimpe dans la région, ou au moins tous les Palois, qui en ont fait leur falaise…	2	Limousin
3	Aiguilles de Bavella	Dans le massif de Bavella poussent des aiguilles de granit rouge moucheté de lichen jaune dont la base se perd dans des vallons touffus. Avec leurs parois vermoulues de tafonis délirants, elles composent un décor extravagant, avec parfois un peu de brume façon baie d’Along, ou des pins suspendus façon Japon... Dépaysement assuré. Les tours sont parcourues de voies rocheuses de plusieurs décennies d’âges, dont l’un des premiers ouvreurs fut Jean-Paul Quilici, guide de haute montagne, et de bon nombre d’itinéraires sportifs modernes sur spits ou goujons, parfois à compléter d’un jeu de friends, qui s’y sont ajoutés au fil du temps, attrayants, plus ou moins audacieux, plus ou moins engagés (plutôt plus que moins), et où il est vraiment question de grimpe. Plus tard (en 1992 pour être précis), Arnaud et François Petit ouvrent avec “Jeef“ l’un des monuments de l’escalade granitique en libre. Au même moment, une flopée de grimpeurs haut de gamme, marseillais et locaux, découvrent ce paradis de l’aventure et mettent en valeur de nouveaux secteurs, dénichant des voies inoubliables qu’ils ouvrent du bas sur un rocher excellent. Sur cette autre planète, le potentiel est si vaste que l’ouverture de nouvelles voies continue sur ces aiguilles magiques, supports de rêves à venir, ou existants, comme l’improbable “Delicatessen“, aussi invraisemblable en difficulté qu’en esthétique avec son granit rouge orné de lichen vert et grignoté d’alvéoles géantes. Les possibilités sont innombrables et le niveau très abordable. Il y a également une école d’escalade à proximité du col de Bavella avec plusieurs secteurs et une centaine de couennes de tous niveaux pour prendre l’ambiance des lieux avant de jeter son dévolu sur l’une des tours. Là, un grand choix d’itinéraires de grande ampleur, classiques et modernes, de F à TD, pour 200 m d’escalade, sur des falaises tout droit sorties d’un décor de BD de science-fiction, vous fera voyager bien plus loin que la Corse...	3	Corse
1	Ailefroide	Situé presque au fond de la vallée de la Vallouise, au Nord de L’Argentière la Bessée, existe-t-il meilleur endroit pour grimper en été ? Peut-être, mais Ailefroide a quand même de quoi convaincre. Ici, à 1.500 m d’altitude, on est en pleine ambiance montagne, entourés de sommets, les vrais, comme sur les cartes postales avec de la neige dessus. Ailefroide c’est beau, et c’est d’ailleurs un site naturel majeur, en partie dans le Parc national des Écrins. Autour, le rocher est partout. D’abord, à portée de bras, il y a ce chaos de gravillons de granit géants, dégringolés des montagnes autour, et aménagés en parcours de bloc pour tous les niveaux. Ailefroide a connu une frénésie d’ouverture dans les années 2000 sous l’impulsion d’Anthony Lamiche et de quelques locaux (les Olivier Fourbet, Yann Ghesquiers, François Lombard et consort...), ce qui en fait aujourd’hui un haut lieu du bloc en France, bien placé dans le best of des sites les plus paradisiaques. Ensuite, à deux pas des blocs, il y a ces dalles granitiques d’excellente qualité parcourues de très nombreuses grandes voies disséminées de part et d’autre d’Ailefroide. Et pour compléter, il y a des sites de couennes sur plusieurs secteurs sportifs en dalles lisses et dévers accessibles. Grandes voies, blocs, couennes, tout est accessible depuis le centre du hameau d’Ailefroide. Dans chaque spécialité, il y en a pour tout le monde, du débutant au sur-confirmé, et la diversité d’orientation permet de grimper avec le soleil ou de le fuir, selon la saison. Tout cela donne de quoi s’occuper plusieurs jours. Voire, plusieurs années. Le tout sous le regard bienveillant de sommets mythiques comme Le Pelvoux et La Barre des Écrins...	1	Alpes
10	Spot La Rochelle	Description du sport de LR	10	Poitou charente
\.


--
-- TOC entry 3234 (class 0 OID 41768)
-- Dependencies: 212
-- Data for Name: spot_topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.spot_topo (spot_id, topo_id) FROM stdin;
\.


--
-- TOC entry 3223 (class 0 OID 41704)
-- Dependencies: 201
-- Data for Name: topo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.topo (id, nom, description, proprietaire_id) FROM stdin;
1	Topo test	Description du topo test	1
2	Topo de Pierre	Détail du topo comprenant site, voies et longueurs	1
\.


--
-- TOC entry 3219 (class 0 OID 41682)
-- Dependencies: 197
-- Data for Name: utilisateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.utilisateur (id, nom, prenom, adressemail, motdepasse, presentation, niveau) FROM stdin;
1	Mercier	Pierre	pierremercier@fakemail.com	123456	Créateur et administrateur du site	Débutant
2	Sessa	Romain	romainsessa@fakemail.Com	dFGddf	AMateur d'escalade	Intermédiaire
\.


--
-- TOC entry 3231 (class 0 OID 41748)
-- Dependencies: 209
-- Data for Name: voie; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.voie (id, nom, description, secteur_id) FROM stdin;
1	L'Etoile Noire	Voie pour les initiés. Tend à virer vers le coté obscure de la force	1
2	La Fée Verte	Une voie pour ceux qui aime la nature verdoyante	1
3	Jabba the Hutt	Voie obèse	2
4	Seul au monde	Une voie unique pour se retrouver avec soi meme	2
5	Into the Wild	Une voie similaire à la voie "Seul au monde" du secteur d'Arudy	3
6	Mick Jagger	Une voie pour ceux qui aiment les pierres qui roulent	3
7	Enigma	Belle ligne, mousquetage diffcile, mathématiquement complexe...	4
8	Mistral Gagnant	Voie compliquée, souvent ventée, idéal pour bousiller ses godasses et s'marrer	4
9	L'indestructible	Cette voie porte bien son nom, vous ne serez plus le meme homme après avoir affronté ce mastodonte	5
10	J'temmène au vent	Voie venteuse mais parfaitement équipée	5
11	Paradis Perdus	Une des voies les plus belles de ce site. Idéal pour prendre de la hauteur et cotoyer les nuages	6
12	Mission Impossible	Votre mission si vous l'acceptez : Grimper cette voie relativement compliquée mais loin d'etre impossible	6
19	Voie de la Rochelle 	Description de la voie LR	21
\.


--
-- TOC entry 3253 (class 0 OID 0)
-- Dependencies: 202
-- Name: adresse_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.adresse_id_seq', 10, true);


--
-- TOC entry 3254 (class 0 OID 0)
-- Dependencies: 198
-- Name: commentaire_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_id_seq', 3, true);


--
-- TOC entry 3255 (class 0 OID 0)
-- Dependencies: 216
-- Name: commentaire_topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.commentaire_topo_id_seq', 4, true);


--
-- TOC entry 3256 (class 0 OID 0)
-- Dependencies: 210
-- Name: longueur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.longueur_id_seq', 19, true);


--
-- TOC entry 3257 (class 0 OID 0)
-- Dependencies: 213
-- Name: resatopo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.resatopo_id_seq', 1, false);


--
-- TOC entry 3258 (class 0 OID 0)
-- Dependencies: 206
-- Name: secteur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.secteur_id_seq', 21, true);


--
-- TOC entry 3259 (class 0 OID 0)
-- Dependencies: 204
-- Name: spot_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.spot_id_seq', 10, true);


--
-- TOC entry 3260 (class 0 OID 0)
-- Dependencies: 200
-- Name: topo_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.topo_id_seq', 5, true);


--
-- TOC entry 3261 (class 0 OID 0)
-- Dependencies: 196
-- Name: utilisateur_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.utilisateur_id_seq', 5, true);


--
-- TOC entry 3262 (class 0 OID 0)
-- Dependencies: 208
-- Name: voie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.voie_id_seq', 19, true);


--
-- TOC entry 3071 (class 2606 OID 41723)
-- Name: adresse adresse_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adresse
    ADD CONSTRAINT adresse_pk PRIMARY KEY (id);


--
-- TOC entry 3067 (class 2606 OID 41701)
-- Name: commentaire commentaire_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT commentaire_pk PRIMARY KEY (id);


--
-- TOC entry 3085 (class 2606 OID 50073)
-- Name: commentaire_topo commentaire_topo_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire_topo
    ADD CONSTRAINT commentaire_topo_pkey PRIMARY KEY (id);


--
-- TOC entry 3079 (class 2606 OID 41767)
-- Name: longueur longueur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT longueur_pk PRIMARY KEY (id);


--
-- TOC entry 3083 (class 2606 OID 41780)
-- Name: resatopo resatopo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resatopo
    ADD CONSTRAINT resatopo_pk PRIMARY KEY (id);


--
-- TOC entry 3075 (class 2606 OID 41745)
-- Name: secteur secteur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT secteur_pk PRIMARY KEY (id);


--
-- TOC entry 3073 (class 2606 OID 41734)
-- Name: spot spot_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT spot_pk PRIMARY KEY (id);


--
-- TOC entry 3081 (class 2606 OID 41772)
-- Name: spot_topo spot_topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot_topo
    ADD CONSTRAINT spot_topo_pk PRIMARY KEY (spot_id, topo_id);


--
-- TOC entry 3069 (class 2606 OID 41712)
-- Name: topo topo_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT topo_pk PRIMARY KEY (id);


--
-- TOC entry 3065 (class 2606 OID 41690)
-- Name: utilisateur utilisateur_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.utilisateur
    ADD CONSTRAINT utilisateur_pk PRIMARY KEY (id);


--
-- TOC entry 3077 (class 2606 OID 41756)
-- Name: voie voie_pk; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT voie_pk PRIMARY KEY (id);


--
-- TOC entry 3089 (class 2606 OID 41791)
-- Name: spot adresse_spot_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot
    ADD CONSTRAINT adresse_spot_fk FOREIGN KEY (adresse_id) REFERENCES public.adresse(id);


--
-- TOC entry 3091 (class 2606 OID 41806)
-- Name: voie secteur_voie_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.voie
    ADD CONSTRAINT secteur_voie_fk FOREIGN KEY (secteur_id) REFERENCES public.secteur(id);


--
-- TOC entry 3087 (class 2606 OID 41826)
-- Name: commentaire spot_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT spot_commentaire_fk FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 3090 (class 2606 OID 41801)
-- Name: secteur spot_secteur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.secteur
    ADD CONSTRAINT spot_secteur_fk FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 3093 (class 2606 OID 41816)
-- Name: spot_topo spot_spot_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot_topo
    ADD CONSTRAINT spot_spot_topo_fk FOREIGN KEY (spot_id) REFERENCES public.spot(id);


--
-- TOC entry 3095 (class 2606 OID 41831)
-- Name: resatopo topo_resatopo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resatopo
    ADD CONSTRAINT topo_resatopo_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 3094 (class 2606 OID 41821)
-- Name: spot_topo topo_spot_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.spot_topo
    ADD CONSTRAINT topo_spot_topo_fk FOREIGN KEY (topo_id) REFERENCES public.topo(id);


--
-- TOC entry 3086 (class 2606 OID 41781)
-- Name: commentaire utilisateur_commentaire_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT utilisateur_commentaire_fk FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3096 (class 2606 OID 41836)
-- Name: resatopo utilisateur_resatopo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.resatopo
    ADD CONSTRAINT utilisateur_resatopo_fk FOREIGN KEY (utilisateur_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3088 (class 2606 OID 41811)
-- Name: topo utilisateur_topo_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.topo
    ADD CONSTRAINT utilisateur_topo_fk FOREIGN KEY (proprietaire_id) REFERENCES public.utilisateur(id);


--
-- TOC entry 3092 (class 2606 OID 41796)
-- Name: longueur voie_longueur_fk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.longueur
    ADD CONSTRAINT voie_longueur_fk FOREIGN KEY (voie_id) REFERENCES public.voie(id);


-- Completed on 2019-03-28 20:25:58 CET

--
-- PostgreSQL database dump complete
--

