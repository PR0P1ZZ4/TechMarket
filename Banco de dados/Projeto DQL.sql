-- Table: ecommerce.item_do_pedido

-- DROP TABLE IF EXISTS ecommerce.item_do_pedido;

CREATE TABLE IF NOT EXISTS ecommerce.item_do_pedido
(
    id_item integer primary key generated always as identity,
    id_produto integer,
    id_pedido integer,
    quantidade integer NOT NULL,
    CONSTRAINT item_do_pedido_id_pedido_fkey FOREIGN KEY (id_pedido)
        REFERENCES ecommerce.pedido (id_pedido) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT item_do_pedido_id_produto_fkey FOREIGN KEY (id_produto)
        REFERENCES ecommerce.produto (id_produto) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

TABLESPACE pg_default;

ALTER TABLE IF EXISTS ecommerce.item_do_pedido
    OWNER to postgres;