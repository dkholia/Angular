-- Table: public."user"

-- DROP TABLE public."user";

CREATE TABLE public."user"
(
  userid character varying(32) NOT NULL,
  uname character varying(40) NOT NULL,
  upwd character varying(200) NOT NULL, -- Password for the user
  isactive boolean,
  CONSTRAINT pk_user PRIMARY KEY (userid)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."user"
  OWNER TO postgres;
COMMENT ON COLUMN public."user".upwd IS 'Password for the user';
