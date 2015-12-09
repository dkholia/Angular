-- Table: public."Product"

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

-- Constraint: product_pk

-- ALTER TABLE "Product" DROP CONSTRAINT product_pk;

ALTER TABLE "Product"
  ADD CONSTRAINT product_pk PRIMARY KEY(beaconid);
