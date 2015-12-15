- Table: public."Product"

-- DROP TABLE public."Product";

CREATE TABLE public."Product"
(
  beaconid character varying(40),
  id character varying(250),
  name character varying(250),
  price numeric,
  quantity numeric
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."Product"
  OWNER TO postgres;
